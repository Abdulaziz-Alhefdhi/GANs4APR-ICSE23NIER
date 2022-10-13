/**
 * Dummy JavaDoc
 */
public class FixedCodes {

/**
 * Dummy JavaDoc
 */
 String superUserShortName) throws IOException {
 List<String> ipList = new ArrayList<String>();
 Enumeration<NetworkInterface> netInterfaceList = NetworkInterface
        .getNetworkInterfaces();
 while (netInterfaceList.hasMoreElements()) {
 NetworkInterface inf = netInterfaceList.nextElement();
 Enumeration<InetAddress> addrList = inf.getInetAddresses();
 while (addrList.hasMoreElements()) {
 InetAddress addr = addrList.nextElement();
        ipList.add(addr.getHostAddress());
      }
    }
 StringBuilder builder = new StringBuilder();
 for (String ip : ipList) {
      builder.append(ip);
      builder.append(',');
    }
    builder.append("127.0.1.1,");
    builder.append(InetAddress.getLocalHost().getCanonicalHostName());
    conf.setStrings(DefaultImpersonationProvider.getProxySuperuserIpConfKey(superUserShortName),
        builder.toString());
  }

/**
 * Dummy JavaDoc
 */
 Job job) throws IOException {
 if (isSchemaOn) {
 JsonMetadata metadataWriter = new JsonMetadata();
 byte recordDel = '\n';
            metadataWriter.setFieldDel(fieldDel);
            metadataWriter.setRecordDel(recordDel);
            metadataWriter.storeSchema(schema, location, job);
        }
    }

/**
 * Dummy JavaDoc
 */
final class DocumentsWriter {
 Directory directory;

 private volatile boolean closed;

 PrintStream infoStream;
 SimilarityProvider similarityProvider;

 List<String> newFiles;

 final IndexWriter indexWriter;

 private AtomicInteger numDocsInRAM = new AtomicInteger(0);

 
 volatile DocumentsWriterDeleteQueue deleteQueue = new DocumentsWriterDeleteQueue();
 private final Queue<FlushTicket> ticketQueue = new LinkedList<DocumentsWriter.FlushTicket>();

 private Collection<String> abortedFiles;               

 final IndexingChain chain;

 final DocumentsWriterPerThreadPool perThreadPool;
 final FlushPolicy flushPolicy;
 final DocumentsWriterFlushControl flushControl;
 final Healthiness healthiness;
 DocumentsWriter(IndexWriterConfig config, Directory directory, IndexWriter writer, FieldNumberBiMap globalFieldNumbers,
 BufferedDeletesStream bufferedDeletesStream) throws IOException {
 this.directory = directory;
 this.indexWriter = writer;
 this.similarityProvider = config.getSimilarityProvider();
 this.perThreadPool = config.getIndexerThreadPool();
 this.chain = config.getIndexingChain();
 this.perThreadPool.initialize(this, globalFieldNumbers, config);
 final FlushPolicy configuredPolicy = config.getFlushPolicy();
 if (configuredPolicy == null) {
      flushPolicy = new FlushByRamOrCountsPolicy();
    } else {
      flushPolicy = configuredPolicy;
    }
    flushPolicy.init(this);

    healthiness = new Healthiness();
 final long maxRamPerDWPT = config.getRAMPerThreadHardLimitMB() * 1024 * 1024;
    flushControl = new DocumentsWriterFlushControl(this, healthiness, maxRamPerDWPT);
  }

 synchronized void deleteQueries(final Query... queries) throws IOException {
    deleteQueue.addDelete(queries);
    flushControl.doOnDelete();
 if (flushControl.doApplyAllDeletes()) {
      applyAllDeletes(deleteQueue);
    }
  }

 
 
 
 synchronized void deleteTerms(final Term... terms) throws IOException {
 final DocumentsWriterDeleteQueue deleteQueue = this.deleteQueue;
    deleteQueue.addDelete(terms);
    flushControl.doOnDelete();
 if (flushControl.doApplyAllDeletes()) {
      applyAllDeletes(deleteQueue);
    }
  }

 DocumentsWriterDeleteQueue currentDeleteSession() {
 return deleteQueue;
  }

 private void applyAllDeletes(DocumentsWriterDeleteQueue deleteQueue) throws IOException {
 if (deleteQueue != null) {
 synchronized (ticketQueue) {
 
        ticketQueue.add(new FlushTicket(deleteQueue.freezeGlobalBuffer(null), false));
        applyFlushTickets();
      }
    }
    indexWriter.applyAllDeletes();
    indexWriter.flushCount.incrementAndGet();
  }

 synchronized void setInfoStream(PrintStream infoStream) {
 this.infoStream = infoStream;
 final Iterator<ThreadState> it = perThreadPool.getAllPerThreadsIterator();
 while (it.hasNext()) {
      it.next().perThread.setInfoStream(infoStream);
    }
  }

 
 int getNumDocs() {
 return numDocsInRAM.get();
  }

 Collection<String> abortedFiles() {
 return abortedFiles;
  }

 
 boolean message(String message) {
 if (infoStream != null) {
      indexWriter.message("DW: " + message);
    }
 return true;
  }

 private void ensureOpen() throws AlreadyClosedException {
 if (closed) {
 throw new AlreadyClosedException("this IndexWriter is closed");
    }
  }

 
 synchronized void abort() throws IOException {
 boolean success = false;

 synchronized (this) {
      deleteQueue.clear();
    }

 try {
 if (infoStream != null) {
        message("docWriter: abort");
      }

 final Iterator<ThreadState> threadsIterator = perThreadPool.getActivePerThreadsIterator();

 while (threadsIterator.hasNext()) {
 ThreadState perThread = threadsIterator.next();
        perThread.lock();
 try {
 if (perThread.isActive()) { 
            perThread.perThread.abort();
            perThread.perThread.checkAndResetHasAborted();
          } else {
 assert closed;
          }
        } finally {
          perThread.unlock();
        }
      }

      success = true;
    } finally {
 if (infoStream != null) {
        message("docWriter: done abort; abortedFiles=" + abortedFiles + " success=" + success);
      }
    }
  }

 boolean anyChanges() {
 return numDocsInRAM.get() != 0 || anyDeletions();
  }

 public int getBufferedDeleteTermsSize() {
 return deleteQueue.getBufferedDeleteTermsSize();
  }

 
 public int getNumBufferedDeleteTerms() {
 return deleteQueue.numGlobalTermDeletes();
  }

 public boolean anyDeletions() {
 return deleteQueue.anyChanges();
  }

 void close() {
    closed = true;
    flushControl.setClosed();
  }

 boolean updateDocument(final Document doc, final Analyzer analyzer,
 final Term delTerm) throws CorruptIndexException, IOException {
    ensureOpen();
 boolean maybeMerge = false;
 final boolean isUpdate = delTerm != null;
 if (healthiness.anyStalledThreads()) {

 
 if (infoStream != null) {
        message("WARNING DocumentsWriter has stalled threads; will hijack this thread to flush pending segment(s)");
      }

 
 DocumentsWriterPerThread flushingDWPT;
 while ((flushingDWPT = flushControl.nextPendingFlush()) != null) {
 
        maybeMerge = doFlush(flushingDWPT);
 if (!healthiness.anyStalledThreads()) {
 break;
        }
      }

 if (infoStream != null && healthiness.anyStalledThreads()) {
        message("WARNING DocumentsWriter still has stalled threads; waiting");
      }

      healthiness.waitIfStalled(); 

 if (infoStream != null && healthiness.anyStalledThreads()) {
        message("WARNING DocumentsWriter done waiting");
      }
    }

 final ThreadState perThread = perThreadPool.getAndLock(Thread.currentThread(),
 this, doc);
 final DocumentsWriterPerThread flushingDWPT;

 try {

 if (!perThread.isActive()) {
        ensureOpen();
 assert false: "perThread is not active but we are still open";
      }

 final DocumentsWriterPerThread dwpt = perThread.perThread;
 try {
        dwpt.updateDocument(doc, analyzer, delTerm);
        numDocsInRAM.incrementAndGet();
      } finally {
 if (dwpt.checkAndResetHasAborted()) {
          flushControl.doOnAbort(perThread);
        }
      }
      flushingDWPT = flushControl.doAfterDocument(perThread, isUpdate);
    } finally {
      perThread.unlock();
    }

 if (flushingDWPT != null) {
      maybeMerge |= doFlush(flushingDWPT);
    } else {
 final DocumentsWriterPerThread nextPendingFlush = flushControl.nextPendingFlush();
 if (nextPendingFlush != null) {
        maybeMerge |= doFlush(nextPendingFlush);
      }
    }
 return maybeMerge;
  }

 private boolean doFlush(DocumentsWriterPerThread flushingDWPT) throws IOException {
 boolean maybeMerge = false;
 while (flushingDWPT != null) {
      maybeMerge = true;
 boolean success = false;
 FlushTicket ticket = null;

 try {
 assert currentFullFlushDelQueue == null
 || flushingDWPT.deleteQueue == currentFullFlushDelQueue : "expected: "
 + currentFullFlushDelQueue + "but was: " + flushingDWPT.deleteQueue
 + " " + flushControl.isFullFlush();
 
 try {
 synchronized (ticketQueue) {
 
            ticket = new FlushTicket(flushingDWPT.prepareFlush(), true);
            ticketQueue.add(ticket);
          }

 
 final FlushedSegment newSegment = flushingDWPT.flush();
 synchronized (ticketQueue) {
            ticket.segment = newSegment;
          }
 
          success = true;
        } finally {
 if (!success && ticket != null) {
 synchronized (ticketQueue) {
 
 
 
              ticket.isSegmentFlush = false;
            }
          }
        }
 
        applyFlushTickets();
      } finally {
        flushControl.doAfterFlush(flushingDWPT);
        flushingDWPT.checkAndResetHasAborted();
        indexWriter.flushCount.incrementAndGet();
      }

      flushingDWPT = flushControl.nextPendingFlush();
    }
 return maybeMerge;
  }

 private void applyFlushTickets() throws IOException {
 synchronized (ticketQueue) {
 while (true) {
 
 final FlushTicket head = ticketQueue.peek();
 if (head != null && head.canPublish()) {
          ticketQueue.poll();
          finishFlush(head.segment, head.frozenDeletes);
        } else {
 break;
        }
      }
    }
  }

 private void finishFlush(FlushedSegment newSegment, FrozenBufferedDeletes bufferedDeletes)
 throws IOException {
 
 if (newSegment == null) {
 assert bufferedDeletes != null;
 if (bufferedDeletes != null && bufferedDeletes.any()) {
        indexWriter.bufferedDeletesStream.push(bufferedDeletes);
 if (infoStream != null) {
          message("flush: push buffered deletes: " + bufferedDeletes);
        }
      }
    } else {
      publishFlushedSegment(newSegment, bufferedDeletes);
    }
  }

 final void subtractFlushedNumDocs(int numFlushed) {
 int oldValue = numDocsInRAM.get();
 while (!numDocsInRAM.compareAndSet(oldValue, oldValue - numFlushed)) {
      oldValue = numDocsInRAM.get();
    }
  }

 
 private void publishFlushedSegment(FlushedSegment newSegment, FrozenBufferedDeletes globalPacket)
 throws IOException {
 assert newSegment != null;
 final SegmentInfo segInfo = indexWriter.prepareFlushedSegment(newSegment);
 final BufferedDeletes deletes = newSegment.segmentDeletes;
 FrozenBufferedDeletes packet = null;
 if (deletes != null && deletes.any()) {
 
      packet = new FrozenBufferedDeletes(deletes, true);
 if (infoStream != null) {
        message("flush: push buffered seg private deletes: " + packet);
      }
    }

 
    indexWriter.publishFlushedSegment(segInfo, packet, globalPacket);
  }

 
 private volatile DocumentsWriterDeleteQueue currentFullFlushDelQueue = null;
 
 private synchronized boolean setFlushingDeleteQueue(DocumentsWriterDeleteQueue session) {
    currentFullFlushDelQueue = session;
 return true;
  }

 
 final boolean flushAllThreads()
 throws IOException {
 final DocumentsWriterDeleteQueue flushingDeleteQueue;

 synchronized (this) {
      flushingDeleteQueue = deleteQueue;
 
      flushControl.markForFullFlush(); 
 assert setFlushingDeleteQueue(flushingDeleteQueue);
    }
 assert currentFullFlushDelQueue != null;
 assert currentFullFlushDelQueue != deleteQueue;

 boolean anythingFlushed = false;
 try {
 DocumentsWriterPerThread flushingDWPT;
 
 while ((flushingDWPT = flushControl.nextPendingFlush()) != null) {
        anythingFlushed |= doFlush(flushingDWPT);
      }
 
 while (flushControl.anyFlushing()) {
        flushControl.waitForFlush();
      }
 if (!anythingFlushed) { 
 synchronized (ticketQueue) {
          ticketQueue.add(new FlushTicket(flushingDeleteQueue.freezeGlobalBuffer(null), false));
        }
        applyFlushTickets();
      }
    } finally {
 assert flushingDeleteQueue == currentFullFlushDelQueue;
    }
 return anythingFlushed;
  }

 final void finishFullFlush(boolean success) {
 assert setFlushingDeleteQueue(null);
 if (success) {
 
      flushControl.finishFullFlush();
    } else {
      flushControl.abortFullFlushes();
    }
  }

 static final class FlushTicket {
 final FrozenBufferedDeletes frozenDeletes;
 
 FlushedSegment segment;
 boolean isSegmentFlush;

 FlushTicket(FrozenBufferedDeletes frozenDeletes, boolean isSegmentFlush) {
 this.frozenDeletes = frozenDeletes;
 this.isSegmentFlush = isSegmentFlush;
    }

 boolean canPublish() {
 return (!isSegmentFlush || segment != null);
    }
  }
}

/**
 * Dummy JavaDoc
 */
 enum Attribute {

 DIRECTORY("directory"),
 EXISTING_HASH("existing-hash"),
 EXISTING_PATH("existing-path"),
 HASH("hash"),
 IN_RUNTIME_USE("in-runtime-use"),
 NAME("name"),
 PATH("path"),
 RESULTING_VERSION("resulting-version"),
 SLOT("slot"),

 
 UNKNOWN(null),
        ;

 private final String name;
 Attribute(String name) {
 this.name = name;
        }

 static Map<String, Attribute> attributes = new HashMap<String, Attribute>();
 static {
 for(Attribute attribute : Attribute.values()) {
 if(attribute != UNKNOWN) {
                    attributes.put(attribute.name, attribute);
                }
            }
        }

 static Attribute forName(String name) {
 final Attribute attribute = attributes.get(name);
 return attribute == null ? UNKNOWN : attribute;
        }
    }

/**
 * Dummy JavaDoc
 */
 public void setInputFormatClass(String name) throws HiveException {
 if (name == null) {
      inputFormatClass = null;
      tTable.getSd().setInputFormat(null);
 return;
    }
 try {
      setInputFormatClass((Class<? extends InputFormat<WritableComparable, Writable>>) Class
          .forName(name, true, Utilities.getSessionSpecifiedClassLoader()));
    } catch (ClassNotFoundException e) {
 throw new HiveException("Class not found: " + name, e);
    }
  }

/**
 * Dummy JavaDoc
 */
 public ReduceRecordProcessor(final JobConf jconf, final ProcessorContext context) throws Exception {
 super(jconf, context);

 String queryId = HiveConf.getVar(jconf, HiveConf.ConfVars.HIVEQUERYID);
    cache = ObjectCacheFactory.getCache(jconf, queryId, true);
    dynamicValueCache = ObjectCacheFactory.getCache(jconf, queryId, false, true);

 String cacheKey = processorContext.getTaskVertexName() + REDUCE_PLAN_KEY;
    cacheKeys = Lists.newArrayList(cacheKey);
    dynamicValueCacheKeys = new ArrayList<String>();
    reduceWork = (ReduceWork) cache.retrieve(cacheKey, new Callable<Object>() {
 @Override
 public Object call() {
 return Utilities.getReduceWork(jconf);
      }
    });

 Utilities.setReduceWork(jconf, reduceWork);
    mergeWorkList = getMergeWorkList(jconf, cacheKey, queryId, cache, cacheKeys);
  }

/**
 * Dummy JavaDoc
 */
 private long size(final QueryContext ctx) {
 final Value rt = root(ctx);
 final Data data = rt != null && rt.type == Type.DOC &&
      rt instanceof DBNode ? ((DBNode) rt).data : null;

 if(data == null || !data.meta.pthindex || !data.meta.uptodate ||
 !data.single()) return -1;

 ArrayList<PathNode> nodes = data.path.root();
 for(final AxisStep s : step) {
      nodes = s.size(nodes, data);
 if(nodes == null) return -1;
    }

 long sz = 0;
 for(final PathNode pn : nodes) sz += pn.size;
 return sz;
  }

/**
 * Dummy JavaDoc
 */
 class VectorizationDispatcher implements Dispatcher {

 private PhysicalContext pctx;

 private List<String> reduceColumnNames;
 private List<TypeInfo> reduceTypeInfos;

 public VectorizationDispatcher(PhysicalContext pctx) {
 this.pctx = pctx;
      reduceColumnNames = null;
      reduceTypeInfos = null;
    }

 @Override
 public Object dispatch(Node nd, Stack<Node> stack, Object... nodeOutputs)
 throws SemanticException {
 Task<? extends Serializable> currTask = (Task<? extends Serializable>) nd;
 if (currTask instanceof MapRedTask) {
        convertMapWork(((MapRedTask) currTask).getWork().getMapWork(), false);
      } else if (currTask instanceof TezTask) {
 TezWork work = ((TezTask) currTask).getWork();
 for (BaseWork w: work.getAllWork()) {
 if (w instanceof MapWork) {
            convertMapWork((MapWork) w, true);
          } else if (w instanceof ReduceWork) {
 
 if (HiveConf.getBoolVar(pctx.getConf(),
 HiveConf.ConfVars.HIVE_VECTORIZATION_REDUCE_ENABLED)) {
              convertReduceWork((ReduceWork) w);
            }
          }
        }
      }
 return null;
    }

 private void convertMapWork(MapWork mapWork, boolean isTez) throws SemanticException {
 boolean ret = validateMapWork(mapWork, isTez);
 if (ret) {
        vectorizeMapWork(mapWork);
      }
    }

 private void addMapWorkRules(Map<Rule, NodeProcessor> opRules, NodeProcessor np) {
      opRules.put(new RuleRegExp("R1", TableScanOperator.getOperatorName() + ".*"
 + FileSinkOperator.getOperatorName()), np);
      opRules.put(new RuleRegExp("R2", TableScanOperator.getOperatorName() + ".*"
 + ReduceSinkOperator.getOperatorName()), np);
    }

 private boolean validateMapWork(MapWork mapWork, boolean isTez) throws SemanticException {
 LOG.info("Validating MapWork...");

 
 for (String path : mapWork.getPathToPartitionInfo().keySet()) {
 PartitionDesc pd = mapWork.getPathToPartitionInfo().get(path);
 List<Class<?>> interfaceList =
 Arrays.asList(pd.getInputFileFormatClass().getInterfaces());
 if (!interfaceList.contains(VectorizedInputFormatInterface.class)) {
 LOG.info("Input format: " + pd.getInputFileFormatClassName()
 + ", doesn't provide vectorized input");
 return false;
        }
      }
 Map<Rule, NodeProcessor> opRules = new LinkedHashMap<Rule, NodeProcessor>();
 MapWorkValidationNodeProcessor vnp = new MapWorkValidationNodeProcessor(mapWork, isTez);
      addMapWorkRules(opRules, vnp);
 Dispatcher disp = new DefaultRuleDispatcher(vnp, opRules, null);
 GraphWalker ogw = new DefaultGraphWalker(disp);
 
 ArrayList<Node> topNodes = new ArrayList<Node>();
      topNodes.addAll(mapWork.getAliasToWork().values());
 HashMap<Node, Object> nodeOutput = new HashMap<Node, Object>();
      ogw.startWalking(topNodes, nodeOutput);
 for (Node n : nodeOutput.keySet()) {
 if (nodeOutput.get(n) != null) {
 if (!((Boolean)nodeOutput.get(n)).booleanValue()) {
 return false;
          }
        }
      }
 return true;
    }

 private void vectorizeMapWork(MapWork mapWork) throws SemanticException {
 LOG.info("Vectorizing MapWork...");
      mapWork.setVectorMode(true);
 Map<Rule, NodeProcessor> opRules = new LinkedHashMap<Rule, NodeProcessor>();
 MapWorkVectorizationNodeProcessor vnp = new MapWorkVectorizationNodeProcessor(mapWork);
      addMapWorkRules(opRules, vnp);
 Dispatcher disp = new DefaultRuleDispatcher(vnp, opRules, null);
 GraphWalker ogw = new PreOrderWalker(disp);
 
 ArrayList<Node> topNodes = new ArrayList<Node>();
      topNodes.addAll(mapWork.getAliasToWork().values());
 HashMap<Node, Object> nodeOutput = new HashMap<Node, Object>();
      ogw.startWalking(topNodes, nodeOutput);

 Map<String, Map<Integer, String>> allScratchColumnVectorTypeMaps = vnp.getAllScratchColumnVectorTypeMaps();
      mapWork.setAllScratchColumnVectorTypeMaps(allScratchColumnVectorTypeMaps);
 Map<String, Map<String, Integer>> allColumnVectorMaps = vnp.getAllColumnVectorMaps();
      mapWork.setAllColumnVectorMaps(allColumnVectorMaps);

 if (LOG.isDebugEnabled()) {
        debugDisplayAllMaps(allColumnVectorMaps, allScratchColumnVectorTypeMaps);
      }

 return;
    }

 private void convertReduceWork(ReduceWork reduceWork) throws SemanticException {
 boolean ret = validateReduceWork(reduceWork);
 if (ret) {
        vectorizeReduceWork(reduceWork);
      }
    }

 private boolean getOnlyStructObjectInspectors(ReduceWork reduceWork) throws SemanticException {
 try {
 
 ObjectInspector keyObjectInspector = reduceWork.getKeyObjectInspector();
 if (keyObjectInspector == null || !(keyObjectInspector instanceof StructObjectInspector)) {
 return false;
        }
 StructObjectInspector keyStructObjectInspector = (StructObjectInspector)keyObjectInspector;
 List<? extends StructField> keyFields = keyStructObjectInspector.getAllStructFieldRefs();

 
 if (reduceWork.getNeedsTagging()) {
 return false;
        }

 
 ObjectInspector valueObjectInspector = reduceWork.getValueObjectInspector();
 if (valueObjectInspector == null ||
 !(valueObjectInspector instanceof StructObjectInspector)) {
 return false;
        }
 StructObjectInspector valueStructObjectInspector = (StructObjectInspector)valueObjectInspector;
 List<? extends StructField> valueFields = valueStructObjectInspector.getAllStructFieldRefs();

        reduceColumnNames = new ArrayList<String>();
        reduceTypeInfos = new ArrayList<TypeInfo>();

 for (StructField field: keyFields) {
          reduceColumnNames.add(Utilities.ReduceField.KEY.toString() + "." + field.getFieldName());
          reduceTypeInfos.add(TypeInfoUtils.getTypeInfoFromTypeString(field.getFieldObjectInspector().getTypeName()));
        }
 for (StructField field: valueFields) {
          reduceColumnNames.add(Utilities.ReduceField.VALUE.toString() + "." + field.getFieldName());
          reduceTypeInfos.add(TypeInfoUtils.getTypeInfoFromTypeString(field.getFieldObjectInspector().getTypeName()));
        }
      } catch (Exception e) {
 throw new SemanticException(e);
      }
 return true;
    }

 private void addReduceWorkRules(Map<Rule, NodeProcessor> opRules, NodeProcessor np) {
      opRules.put(new RuleRegExp("R1", ExtractOperator.getOperatorName() + ".*"), np);
      opRules.put(new RuleRegExp("R2", GroupByOperator.getOperatorName() + ".*"), np);
      opRules.put(new RuleRegExp("R3", SelectOperator.getOperatorName() + ".*"), np);
    }

 private boolean validateReduceWork(ReduceWork reduceWork) throws SemanticException {
 LOG.info("Validating ReduceWork...");

 
 if (!getOnlyStructObjectInspectors(reduceWork)) {
 return false;
      }
 
 Map<Rule, NodeProcessor> opRules = new LinkedHashMap<Rule, NodeProcessor>();
 ReduceWorkValidationNodeProcessor vnp = new ReduceWorkValidationNodeProcessor();
      addReduceWorkRules(opRules, vnp);
 Dispatcher disp = new DefaultRuleDispatcher(vnp, opRules, null);
 GraphWalker ogw = new DefaultGraphWalker(disp);
 
 ArrayList<Node> topNodes = new ArrayList<Node>();
      topNodes.add(reduceWork.getReducer());
 HashMap<Node, Object> nodeOutput = new HashMap<Node, Object>();
      ogw.startWalking(topNodes, nodeOutput);
 for (Node n : nodeOutput.keySet()) {
 if (nodeOutput.get(n) != null) {
 if (!((Boolean)nodeOutput.get(n)).booleanValue()) {
 return false;
          }
        }
      }
 return true;
    }

 private void vectorizeReduceWork(ReduceWork reduceWork) throws SemanticException {
 LOG.info("Vectorizing ReduceWork...");
      reduceWork.setVectorMode(true);

 
 
 
 Map<Rule, NodeProcessor> opRules = new LinkedHashMap<Rule, NodeProcessor>();
 ReduceWorkVectorizationNodeProcessor vnp =
 new ReduceWorkVectorizationNodeProcessor(reduceColumnNames);
      addReduceWorkRules(opRules, vnp);
 Dispatcher disp = new DefaultRuleDispatcher(vnp, opRules, null);
 GraphWalker ogw = new PreOrderWalker(disp);
 
 ArrayList<Node> topNodes = new ArrayList<Node>();
      topNodes.add(reduceWork.getReducer());
 LOG.info("vectorizeReduceWork reducer Operator: " +
              reduceWork.getReducer().getName() + "...");
 HashMap<Node, Object> nodeOutput = new HashMap<Node, Object>();
      ogw.startWalking(topNodes, nodeOutput);

 
      reduceWork.setReducer(vnp.getRootVectorOp());

 Operator<? extends OperatorDesc> reducer = reduceWork.getReducer();
 if (reducer.getType().equals(OperatorType.EXTRACT)) {
        ((VectorExtractOperator)reducer).setReduceTypeInfos(reduceTypeInfos);
      }

 Map<String, Map<Integer, String>> allScratchColumnVectorTypeMaps = vnp.getAllScratchColumnVectorTypeMaps();
      reduceWork.setAllScratchColumnVectorTypeMaps(allScratchColumnVectorTypeMaps);
 Map<String, Map<String, Integer>> allColumnVectorMaps = vnp.getAllColumnVectorMaps();
      reduceWork.setAllColumnVectorMaps(allColumnVectorMaps);


 if (LOG.isDebugEnabled()) {
        debugDisplayAllMaps(allColumnVectorMaps, allScratchColumnVectorTypeMaps);
      }
    }
  }

/**
 * Dummy JavaDoc
 */
 public void setSetNames(boolean setNames) {
 this.setNames = setNames;
    }

/**
 * Dummy JavaDoc
 */
 public String toString() {
 return this.id;
  }

}
