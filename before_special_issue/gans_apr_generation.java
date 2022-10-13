Buggy code: assertThat ( lookupDocs . totalHits , equalTo ( 0 ) ) ;
---
Fixed code: assertThat ( lookupDocs . totalHits , equalTo ( 0L ) ) ;
Generation: assertThat ( . ( ) , out . getCaller ( ) ) ;
=============
=============
Buggy code: _resourceLimitMgr . decrementResourceCount ( volume . getAccountId ( ) , ResourceType . primary_storage , cmd . getDisplayVolume ( ) , new Long ( volume . getSize ( ) ) ) ;
---
Fixed code: _resourceLimitMgr . recalculateResourceCount ( volume . getAccountId ( ) , volume . getDomainId ( ) , ResourceType . primary_storage . getOrdinal ( ) ) ;
Generation: _resourceLimitMgr . , ( ) , volume . getDomainId ( ) , new , . class . getName ( ) , new volume . getName ( ) , new volume . cmd ( this . . ( ) , volume . getDomainId ( ) , ResourceType . . ( ) , new > ( ) ) ;
=============
=============
Buggy code: return Class . forName ( className ) ;
---
Fixed code: return JavaUtils . loadClass ( className ) ;
Generation: return super .
=============
=============
Buggy code: json . writeStringField ( e . getKey ( ) , e . getValue ( ) . toString ( ) ) ;
---
Fixed code: json . writeStringField ( e . getKey ( ) , e . getValue ( ) == null ? null : e . getValue ( ) . toString ( ) ) ;
Generation: e . toString ( ) , e . getPath ( ) , e . getPath ( ) , e ) ;
=============
=============
Buggy code: Reader r = hsf . getReader ( ) ;
---
Fixed code: Reader r = hsf . getCompactionReader ( ) ;
Generation: IndexReader r = IndexReader . open ( writer ) ;
=============
=============
Buggy code: throw new UnknownRegionException ( Bytes . toString ( encodedRegionName ) ) ;
---
Fixed code: throw new UnknownRegionException ( Bytes . toStringBinary ( encodedRegionName ) ) ;
Generation: throw new IOException ( Bytes . toStringBinary ( value ) ) ;
=============
=============
Buggy code: . setSubject ( "Review #" + reviewId )
---
Fixed code: . setSubject ( "Review #" + reviewId + ( "FALSE-POSITIVE" . equals ( notification . getFieldValue ( "new.resolution" ) ) ? " - False Positive" : "" ) )
Generation: . + ( ) )
=============
=============
Buggy code: return new HiveQueryResultSet . Builder ( )
---
Fixed code: return new HiveQueryResultSet . Builder ( null )
Generation: return new HiveQueryResultSet . Builder ( null )
=============
=============
Buggy code: includedColumns [ column ] ) {
---
Fixed code: ( column < includedColumns . length && includedColumns [ column ] ) ) {
Generation: @ Deprecated public [ ] ( ) throws IOException {
=============
=============
Buggy code: return numAllMemorySegments * segmentSize ;
---
Fixed code: return numAllMemorySegments * ( long ) segmentSize ;
Generation: return v * ( long ) * ( long ) * ( long ) * ( long ) * ( long ) * ( long ) * ( long ) * ( long ) * ( long ) * ( long ) * ( long ) * ( long ) * ( long ) * ( long ) * ( long ) *
=============
=============
Buggy code: private Sampler sampler = new Sampler ( ) ;
---
Fixed code: private Sampler sampler = new RandomSampler ( ) ;
Generation: private final this = new StringBuilder ( ) ;
=============
=============
Buggy code: if ( context . isNormalServer ( ) ) {
---
Fixed code: if ( context . isNormalServer ( ) && context . getServiceRegistry ( false ) . getService ( ModClusterService . NAME ) != null ) {
Generation: if ( context . isNormalServer ( ) && context . getServiceRegistry ( false ) . getService ( ModClusterService . NAME ) != null ) {
=============
=============
Buggy code: : "number of dynamic paritions should be the same as the size of DP mapping" ;
---
Fixed code: : "number of dynamic partitions should be the same as the size of DP mapping" ;
Generation: . toString ( ) ;
=============
=============
Buggy code: this . port = b . port ;
---
Fixed code: this . name = b . name ;
Generation: this . writer = b . ; . get ( ) ;
=============
=============
Buggy code: } catch ( Exception e ) {
---
Fixed code: } catch ( Throwable e ) {
Generation: } catch ( Throwable e ) {
=============
=============
Buggy code: newCallbacks [ newCallbacks . length ] = subjectCallBack ;
---
Fixed code: newCallbacks [ newCallbacks . length - 1 ] = subjectCallBack ;
Generation: int [ ] length = ( ) == null ? null : new getId ( ) [ i ] ;
=============
=============
Buggy code: TokenStream ts = new WhitespaceTokenizer ( TEST_VERSION_CURRENT , cs ) ;
---
Fixed code: TokenStream ts = new MockTokenizer ( cs , MockTokenizer . WHITESPACE , false ) ;
Generation: TokenStream ts = new MockTokenizer ( cs , MockTokenizer . WHITESPACE , false ) ;
=============
=============
Buggy code: && isDeterministic ( ) ;
---
Fixed code: && isConsistentWithinQuery ( ) ;
Generation: if ( ! ApplicationManager . getApplication ( ) , true ) ;
=============
=============
Buggy code: newIndexWriterConfig ( TEST_VERSION_CURRENT , new MockAnalyzer ( MockTokenizer . WHITESPACE , false ) ) ) ;
---
Fixed code: newIndexWriterConfig ( TEST_VERSION_CURRENT , new MockAnalyzer ( random , MockTokenizer . WHITESPACE , false ) ) ) ;
Generation: newIndexWriterConfig ( TEST_VERSION_CURRENT , new MockAnalyzer ( random , MockTokenizer . WHITESPACE , false ) ) ) ;
=============
=============
Buggy code: HiveFileFormatUtils . setFullyReadColumns ( conf ) ;
---
Fixed code: ColumnProjectionUtils . setFullyReadColumns ( conf ) ;
Generation: conf . . ( ) , conf ) ;
=============
=============
Buggy code: String uri = exchange . getFromEndpoint ( ) . getEndpointUri ( ) ;
---
Fixed code: String uri = response . getRequest ( ) . getResourceRef ( ) . toString ( ) ;
Generation: String uri = exchange . getContext ( ) . getTypeConverter ( ) . convertTo ( String . class , buffer ) ;
=============
=============
Buggy code: } else if ( ShimLoader . getHadoopShims ( ) . compareText ( mMax , o ) < 0 ) {
---
Fixed code: } else if ( mMax . compareTo ( o ) < 0 ) {
Generation: } else if ( mMax . compareTo ( o ) < 0 ) {
=============
=============
Buggy code: SpellChecker compareSP = new SpellCheckerMock ( compIdx , new LevensteinDistance ( ) , new SuggestWordFrequencyComparator ( ) ) ;
---
Fixed code: SpellChecker compareSP = new SpellCheckerMock ( compIdx , new LevenshteinDistance ( ) , new SuggestWordFrequencyComparator ( ) ) ;
Generation: SpellChecker compareSP = new SpellCheckerMock ( compIdx , new LevenshteinDistance ( ) , new SuggestWordFrequencyComparator ( ) ) ;
=============
=============
Buggy code: PosixParser parser = new PosixParser ( ) ;
---
Fixed code: DefaultParser parser = new DefaultParser ( ) ;
Generation: DefaultParser parser = new DefaultParser ( ) ;
=============
=============
Buggy code: Utilities . clearWorkMap ( ) ;
---
Fixed code: Utilities . clearWorkMap ( jconf ) ;
Generation: Utilities . clearWorkMap ( jc ) ;
=============
=============
Buggy code: Network . State . getStateMachine ( ) . registerListener ( new NetworkStateListener ( _usageEventDao , _networksDao ) ) ;
---
Fixed code: Network . State . getStateMachine ( ) . registerListener ( new NetworkStateListener ( _usageEventDao , _networksDao , _configDao ) ) ;
Generation: Network . State . getStateMachine ( ) . registerListener ( new _configDao ( _usageEventDao , _configDao ) ) ;
=============
=============
Buggy code: Table indexTable = buildTable ( DB_NAME , INDEX_TABLE_NAME ) ;
---
Fixed code: Table indexTable = buildIndexTable ( DB_NAME , INDEX_TABLE_NAME ) ;
Generation: Table indexTable = buildIndexTable ( DB_NAME , INDEX_TABLE_NAME ) ;
=============
=============
Buggy code: if ( doc == postings . NO_MORE_DOCS ) {
---
Fixed code: if ( doc == DocIdSetIterator . NO_MORE_DOCS ) {
Generation: if ( doc == DocIdSetIterator . NO_MORE_DOCS ) {
=============
=============
Buggy code: return toWriter ( file , null ) ;
---
Fixed code: return toWriter ( file , false , IOHelper . getCharsetName ( null , true ) ) ;
Generation: return file . null ) ;
=============
=============
Buggy code: invokable . setup ( mockContext , new ExecutionConfig ( ) ) ;
---
Fixed code: invokable . setup ( mockContext ) ;
Generation: invokable . setup ( mockContext ) ;
=============
=============
Buggy code: Processor childProcessor = routeContext . createProcessor ( this ) ;
---
Fixed code: Processor childProcessor = this . createChildProcessor ( routeContext , true ) ;
Generation: Processor childProcessor = this . createChildProcessor ( routeContext , false ) ;
=============
=============
Buggy code: assertEquals ( "registry entry called hello must be specified on: process[ref:hello]" , e . getCause ( ) . getMessage ( ) ) ;
---
Fixed code: assertEquals ( "No bean could be found in the registry for: hello of type: org.apache.camel.Processor" , e . getCause ( ) . getMessage ( ) ) ;
Generation: assertEquals ( 1 , e . getMessage ( ) . toLowerCase ( ) ) ;
=============
=============
Buggy code: Session session = startClient ( startServer ( serverSessionFrameListener ) , clientSessionFrameListener ) ;
---
Fixed code: Session session = startClient ( startSPDYServer ( serverSessionFrameListener ) , clientSessionFrameListener ) ;
Generation: Session session = startClient ( startSPDYServer ( serverSessionFrameListener ) , clientSessionFrameListener ) ;
=============
=============
Buggy code: return "Ill-formed command line: " + cmd ;
---
Fixed code: return msgHeader ( ) + "Ill-formed command line: " + cmd ;
Generation: return NetUtils . false ;
=============
=============
Buggy code: mPreviousKey = key ;
---
Fixed code: mPreviousKey = GenericData . get ( ) . deepCopy ( mKeySchema , key ) ;
Generation: int value = conf . getInt ( key ,
=============
=============
Buggy code: final SegmentInfo si = new SegmentInfo ( dir , Version . LATEST , SEGMENT , 10000 , false , codec , null , StringHelper . randomId ( ) ) ;
---
Fixed code: final SegmentInfo si = new SegmentInfo ( dir , Version . LATEST , SEGMENT , 10000 , false , codec , null , StringHelper . randomId ( ) , new HashMap < > ( ) ) ;
Generation: final SegmentInfo si = new SegmentInfo ( dir , Version . LATEST , SEGMENT , 10000 , false , codec , null , StringHelper . randomId ( ) , new HashMap < > ( ) ) ;
=============
=============
Buggy code: if ( s . length ( ) == 0 ) return null ;
---
Fixed code: if ( s . isEmpty ( ) ) return null ;
Generation: if ( s . isEmpty ( ) ) return null ;
=============
=============
Buggy code: Utils . writeLog ( exceptions . get ( j ) , pigContext . getProperties ( ) . getProperty ( "pig.logfile" ) , log , false , headerMessage , false , false ) ;
---
Fixed code: LogUtils . writeLog ( exceptions . get ( j ) , pigContext . getProperties ( ) . getProperty ( "pig.logfile" ) , log , false , headerMessage , false , false ) ;
Generation: true . get ( ! . class ) , buffer , false , false , false , false , false ) ;
=============
=============
Buggy code: buf . append ( " header: " + header ) ;
---
Fixed code: buf . append ( " headers: " + headers ) ;
Generation: . append ( + ) . append ( "(" ) . append ( "(" ) . append ( "(" ) . toString ( ) ) ;
=============
=============
Buggy code: && statsObj . getColType ( ) . equals ( newCol . getType ( ) ) ) {
---
Fixed code: && statsObj . getColType ( ) . equalsIgnoreCase ( newCol . getType ( ) ) ) {
Generation: if ( ( int ) != null && ! . ( ) . equals ( dest ) ) {
=============
=============
Buggy code: WebElement plotImg = ( new WebDriverWait ( driver_ , 5 ) )
---
Fixed code: ( new WebDriverWait ( driver_ , 5 ) )
Generation: . write ( new Throwable ( ) )
=============
=============
Buggy code: for ( String s : l ) {
---
Fixed code: if ( l != null ) for ( String s : l ) {
Generation: for ( String s : s . length ( ) ) {
=============
=============
Buggy code: HTable table = new HTable ( tableName ) ;
---
Fixed code: HTable table = new HTable ( this . conf , tableName ) ;
Generation: HTable table = new HTable ( this . conf , tableName ) ;
=============
=============
Buggy code: throw new KryoException ( "Buffer underflow" ) ;
---
Fixed code: throw new KryoException ( new EOFException ( "No more bytes left." ) ) ;
Generation: throw new KryoException ( new EOFException ( "No more bytes left." ) ) ;
=============
=============
Buggy code: return vertexGroupInfo != null ;
---
Fixed code: return isVertexGroup ;
Generation: return projectSnapshot != null ;
=============
=============
Buggy code: QueryParserUtils . attachStorePlan ( currDAG . lp , "fakefile" , null , currDAG . getOperator ( alias ) ,
---
Fixed code: QueryParserUtils . attachStorePlan ( scope , currDAG . lp , "fakefile" , null , currDAG . getOperator ( alias ) ,
Generation: . ( ) , null , null , new StringBuilder ( alias ) ,
=============
=============
Buggy code: return this == STANDARD_SAVEPOINT ;
---
Fixed code: return savepoint ;
Generation: return this . collector ;
=============
=============
Buggy code: } else {
---
Fixed code: } else {
Generation: } else if ( key instanceof Text ) {
=============
=============
Buggy code: fieldName = mapper . names ( ) . indexName ( ) ;
---
Fixed code: fieldName = mapper . fieldType ( ) . names ( ) . indexName ( ) ;
Generation: Set ( ) . build ( ) ;
=============
=============
Buggy code: } if ( field . equals ( "score" ) ) {
---
Fixed code: } else if ( field . equals ( "score" ) ) {
Generation: if ( field != null && ! field . equals ( method . trim ( ) ) ) {
=============
=============
Buggy code: exchange . setIn ( new MailMessage ( message ) ) ;
---
Fixed code: exchange . setIn ( new MailMessage ( message , getConfiguration ( ) . isMapMailMessage ( ) ) ) ;
Generation: in . 0 = new || ( ( endpoint ) || . valueOf ( message ) ) ;
=============
=============
Buggy code: OException . wrapException ( new OConfigurationException (
---
Fixed code: throw OException . wrapException ( new OConfigurationException (
Generation: throw new ! ( new EOFException ( new EOFException ( ) )
=============
=============
Buggy code: if ( rootElements == null ) {
---
Fixed code: if ( rootElements == null || rootElements . isEmpty ( ) ) {
Generation: if ( ( == null ) || ( value == null ) ) {
=============
=============
Buggy code: return false ;
---
Fixed code: return true ;
Generation: return true ;
=============
=============
Buggy code: ret . bytes = MISSING ;
---
Fixed code: ret . bytes = BytesRef . EMPTY_BYTES ;
Generation: String . 0 = BytesRef . toString ( ) ;
=============
=============
Buggy code: thread . init ( new MetaStoreThread . BooleanPointer ( ) ) ;
---
Fixed code: thread . init ( new MetaStoreThread . BooleanPointer ( ) , new MetaStoreThread . BooleanPointer ( ) ) ;
Generation: - 1 ) ;
=============
=============
Buggy code: for ( Entry < String , String > entry : conf ) {
---
Fixed code: for ( Entry < String , String > entry : new Configuration ( conf ) ) {
Generation: for ( Map < String , String > list ) {
=============
=============
Buggy code: notSupportedOnClient ( ) ;
---
Fixed code: throw notSupportedOnClient ( ) ;
Generation: throw notSupportedOnClient ( ) ;
=============
=============
Buggy code: vpnFwRule . getSourcePortStart ( ) + " as a part of vpn cleanup" ) ;
---
Fixed code: vpnFwRule . getSourcePortStart ( ) . intValue ( ) + " as a part of vpn cleanup" ) ;
Generation: + HConstants . ) . get ( ) ;
=============
=============
Buggy code: producerServicePool . start ( ) ;
---
Fixed code: startServices ( producerServicePool ) ;
Generation: . release ( ) . perform ( ) ;
=============
=============
Buggy code: false , additionalHeaders ) ;
---
Fixed code: false , additionalHeaders , null ) ;
Generation: true , false ) ;
=============
=============
Buggy code: if ( fname != null ) {
---
Fixed code: if ( ! fname . isEmpty ( ) ) {
Generation: if ( properties != null && tableDesc . getState ( ) . equals ( < ) ) {
=============
=============
Buggy code: if ( i % SPILL_SAMPLE_FREQUENCY == 0 ) {
---
Fixed code: if ( t != null && i % SPILL_SAMPLE_FREQUENCY == 0 ) {
Generation: if ( i == 0 && ( ! == ? 0 : 0 ) ) {
=============
=============
Buggy code: commandLine . addArgument ( "ClientPath" ) ;
---
Fixed code: commandLine . addArgument ( componentGroup ) ;
Generation: . release ( ) . perform ( ) ;
=============
=============
Buggy code: checkType ( it , AtomType . DTM ) ;
---
Fixed code: new Dtm ( ( Date ) checkType ( it , AtomType . DTM ) ) ;
Generation: new > ( ( this , ( ) ) ;
=============
=============
Buggy code: content = exchange . getContext ( ) . getTypeConverter ( ) . mandatoryConvertTo ( byte [ ] . class , file . getFile ( ) ) ;
---
Fixed code: content = exchange . getContext ( ) . getTypeConverter ( ) . mandatoryConvertTo ( byte [ ] . class , exchange , file . getFile ( ) ) ;
Generation: String . format ( path [ ] ) ;
=============
=============
Buggy code: pool = new DBBPool ( ) ;
---
Fixed code: pool = new NetworkDBBPool ( ) ;
Generation: codec = new true ( ) ;
=============
=============
Buggy code: loadTableWork . add ( new loadTableDesc ( fromURI . toString ( ) , Utilities . getTableDesc ( ts . tableHandle ) ,
---
Fixed code: loadTableWork . add ( new loadTableDesc ( fromURI . toString ( ) , getTmpFileName ( ) , Utilities . getTableDesc ( ts . tableHandle ) ,
Generation: wh . == new new < String > ( ) , - 1 ) ;
=============
=============
Buggy code: origin = null ;
---
Fixed code: origin = getOriginForMediaDevice ( mediaDevice ) ;
Generation: origin = getOriginForMediaDevice ( mediaDevice ) ;
=============
=============
Buggy code: super ( streams , sourceContext , runtimeContext , configProps , deserializationSchema ) ;
---
Fixed code: super ( streams , sourceContext , runtimeContext , configProps , deserializationSchema , DEFAULT_SHARD_ASSIGNER ) ;
Generation: super ( name_index , 5 , false , ( < ? , super . , , this , ( ) ) ;
=============
=============
Buggy code: protected Reader initReader ( Reader reader ) {
---
Fixed code: protected Reader initReader ( String fieldName , Reader reader ) {
Generation: protected Reader initReader ( String fieldName , Reader reader ) {
=============
=============
Buggy code: LOG . warn ( "Failed seekBefore " + Bytes . toString ( this . splitkey ) , e ) ;
---
Fixed code: LOG . warn ( "Failed seekBefore " + Bytes . toStringBinary ( this . splitkey ) , e ) ;
Generation: LOG . warn ( + Bytes . toStringBinary ( this . toString ( ) ) , e ) ;
=============
=============
Buggy code: MetaScanner . metaScan ( server . getConfiguration ( ) , visitor , tableName ) ;
---
Fixed code: MetaScanner . metaScan ( server . getConfiguration ( ) , null , visitor , tableName ) ;
Generation: db . . ( ( server , size ) , null , false , true ) ;
=============
=============
Buggy code: useLlapIo = ( ( LlapAwareSplit ) split ) . canUseLlapIo ( ) ;
---
Fixed code: useLlapIo = ( ( LlapAwareSplit ) split ) . canUseLlapIo ( job ) ;
Generation: ) = ( ( ) != null ? ! ( 1 ) ) . getPerformative ( ) ;
=============
=============
Buggy code: if ( info != null && info . isRunning ( ) ) {
---
Fixed code: if ( info != null ) {
Generation: if ( ! info . isMetaTable ( ) ) {
=============
=============
Buggy code: while ( ! docSpansOrdered ( subSpans [ i - 1 ] , subSpans [ i ] ) ) {
---
Fixed code: while ( ! docSpansOrderedNonOverlap ( subSpans [ i - 1 ] , subSpans [ i ] ) ) {
Generation: && ( ! data [ i ] , [ i ] , i + 1 ] ) {
=============
=============
Buggy code: eq ( ReplaceIfPresentFlag . REPLACE ) , eq ( new GeneralDataCoding ( false , true , MessageClass . CLASS1 , Alphabet . ALPHA_DEFAULT ) ) , eq ( ( byte ) 0 ) , aryEq ( "short message body" . getBytes ( ) ) ,
---
Fixed code: eq ( ReplaceIfPresentFlag . REPLACE ) , eq ( DataCoding . newInstance ( ( byte ) 0 ) ) , eq ( ( byte ) 0 ) , aryEq ( "short message body" . getBytes ( ) ) ,
Generation: eq ( ReplaceIfPresentFlag . REPLACE ) , eq ( DataCoding . newInstance ( ( byte ) 0 ) ) , eq ( ( byte ) 0 ) , aryEq ( "short message body" . getBytes ( ) ) ,
=============
=============
Buggy code: statement = dbConn . createStatement ( ResultSet . TYPE_SCROLL_INSENSITIVE , ResultSet . CONCUR_READ_ONLY ) ;
---
Fixed code: statement = dbConn . createStatement ( resultSetType , resultSetConcurrency ) ;
Generation: , false = ;
=============
=============
Buggy code: Bitmap bmp = RenderingIcons . getIcon ( context , resId ) ;
---
Fixed code: Bitmap bmp = RenderingIcons . getIcon ( context , resId , true ) ;
Generation: , job = null ;
=============
=============
Buggy code: Table dest3 = db . getTable ( "dest3" ) ;
---
Fixed code: Table dest3 = db . getTable ( MetaStoreUtils . DEFAULT_DATABASE_NAME , "dest3" ) ;
Generation: HFileScanner scanner = new false ( false , false ,
=============
=============
Buggy code: this . rpcTimeout = conf . getLong ( "hbase.regionserver.lease.period" , 60000 ) ;
---
Fixed code: this . rpcTimeout = conf . getLong ( HBASE_REGIONSERVER_LEASE_PERIOD_KEY , DEFAULT_HBASE_REGIONSERVER_LEASE_PERIOD ) ;
Generation: this . rpcTimeout = conf . getLong ( HBASE_REGIONSERVER_LEASE_PERIOD_KEY , DEFAULT_HBASE_REGIONSERVER_LEASE_PERIOD ) ;
=============
=============
Buggy code: Source source = conv . toSource ( "<foo>bar</foo>" . getBytes ( ) ) ;
---
Fixed code: Source source = conv . toBytesSource ( "<foo>bar</foo>" . getBytes ( ) ) ;
Generation: this . = != null ? null : source . getName ( ) . getName ( ) ) ;
=============
=============
Buggy code: Service service = getKubernetes ( ) . getService ( idText ) ;
---
Fixed code: Service service = getKubernetes ( ) . services ( ) . inNamespace ( getNamespace ( ) ) . withName ( idText ) . get ( ) ;
Generation: PodList pods = getKubernetes ( ) . pods ( ) . inNamespace ( getNamespace ( ) ) . list ( ) ;
=============
=============
Buggy code: logger . info ( "Scanning for projects..." ) ;
---
Fixed code: logger . info ( ansi ( ) . fgBlue ( ) . a ( "Scanning for projects..." ) . reset ( ) . toString ( ) ) ;
Generation: logger . info ( ) ;
=============
=============
Buggy code: getTableName ( ) , getScan ( ) . getStartRow ( ) , getScan ( ) ) ;
---
Fixed code: getTableName ( ) , getScan ( ) ) ;
Generation: getDomainId ( ) . == , ( ) . ! ( ) + ( ( ) == null ? 0 : ( ) . ) ( ( ) ? ( ( ) == null ) ,
=============
=============
Buggy code: return failure ( e , "unexpected error: " + e . getMessage ( ) ) ;
---
Fixed code: failure ( "unexpected error" , e ) ;
Generation: throw new CorruptIndexException ( + + e , e ) ;
=============
=============
Buggy code: closeOutagesForUnmanagedServices ( ) ;
---
Fixed code: m_queryManager . closeOutagesForUnmanagedServices ( ) ;
Generation: stop ( ) ;
=============
=============
Buggy code: File oldConf = new File ( System . getProperty ( "user.home" ) + "/pigtest/conf/hadoop-site.xml" ) ;
---
Fixed code: File oldConf = new File ( "build/classes/hadoop-site.xml" ) ;
Generation: File f = new File ( . ( ) + file ) ;
=============
=============
Buggy code: null , null , NetworkType . Basic , null , null , true , true ) ;
---
Fixed code: null , null , NetworkType . Basic , null , null , true , true , null , null ) ;
Generation: null , null , NetworkType . Basic , null , null , true , true , null , null ) ;
=============
=============
Buggy code: long val = encode ( fromBs ) ;
---
Fixed code: long val = encode ( fromBs , value . length - n . getLength ( ) + first ) ;
Generation: long ? = > (
=============
=============
Buggy code: public Object process ( Node nd , NodeProcessorCtx ctx , Object ... nodeOutputs ) throws SemanticException {
---
Fixed code: public Object process ( Node nd , Stack < Node > stack , NodeProcessorCtx ctx , Object ... nodeOutputs ) throws SemanticException {
Generation: public Object process ( Node nd , Stack < Node > stack , NodeProcessorCtx ctx , Object ... nodeOutputs ) throws SemanticException {
=============
=============
Buggy code: final SlaveContext context = readSlaveContext ( buffer ) ;
---
Fixed code: SlaveContext context = type . includesSlaveContext ( ) ? readSlaveContext ( buffer ) : null ;
Generation: final StandardTokenizer input = new context ( "" ) ;
=============
=============
Buggy code: if ( expr . getUnboxed ( ) && operator . isOptimisable ( expr , this ) ) {
---
Fixed code: if ( operator . getOptimisationStrategy ( expr , this ) . useJavaOperator ( ) ) {
Generation: if ( operator . getOptimisationStrategy ( expr , this ) . useJavaOperator ( ) ) {
=============
=============
Buggy code: this . docValueType = ref . docValueType ( ) ;
---
Fixed code: this . docValuesType = ref . docValuesType ( ) ;
Generation: this . . = ( String . this ( ) . getName ( ) ) ;
=============
=============
Buggy code: MetricDto metric = dbClient . metricDao ( ) . selectById ( dbSession , customMeasure . getMetricId ( ) ) ;
---
Fixed code: MetricDto metric = dbClient . metricDao ( ) . selectOrFailById ( dbSession , customMeasure . getMetricId ( ) ) ;
Generation: String = . ( ) . , ( ) .
=============
=============
Buggy code: NodeUtil rootTree = new NodeUtil ( root . getTree ( "/" ) ) ;
---
Fixed code: NodeUtil rootTree = checkNotNull ( new NodeUtil ( root . getTree ( "/" ) ) ) ;
Generation: base = new + ( ) ;
=============
=============
Buggy code: result . bytes = MISSING ;
---
Fixed code: result . bytes = BytesRef . EMPTY_BYTES ;
Generation: result . bytes = BytesRef . EMPTY_BYTES ;
=============
=============
Buggy code: if ( halfReader != null ) halfReader . close ( ) ;
---
Fixed code: if ( halfReader != null ) halfReader . close ( cacheConf . shouldEvictOnClose ( ) ) ;
Generation: if ( ! this . ) != null )
=============
=============
Buggy code: s_logger . warn ( "Field " + columnName + " doesn't exist in " + tableName , e ) ;
---
Fixed code: s_logger . debug ( "Field " + columnName + " doesn't exist in " + tableName + " ignoring exception: " + e . getMessage ( ) ) ;
Generation: e . warn ( + + + ( + ) + ")" ) ;
=============
=============
Buggy code: this . __test_dir = new File ( TEMP_DIR , "testIndexWriter" ) ;
---
Fixed code: this . __test_dir = _TestUtil . getTempDir ( "testIndexWriter" ) ;
Generation: this . "" = _TestUtil . getTempDir ( true ) ;
=============
=============
Buggy code: protected Reader initReader ( Reader reader ) {
---
Fixed code: protected Reader initReader ( String fieldName , Reader reader ) {
Generation: protected Reader initReader ( String fieldName , Reader reader ) {
=============
=============
Buggy code: Set < ServerName > deadServers = master . getServerManager ( ) . getDeadServers ( ) ;
---
Fixed code: Set < ServerName > deadServers = master . getServerManager ( ) . getDeadServers ( ) . copyServerNames ( ) ;
Generation: Set < String > handlers = ( null ) this . . ( ) . getHeader ( false ) ;
=============
=============
Buggy code: userNameFromPrincipal = getUserNameFromPrincipal ( principal ) ;
---
Fixed code: userNameFromPrincipal = LlapUtil . getUserNameFromPrincipal ( principal ) ;
Generation: ) . ( ( ) ) ;
=============
=============
Buggy code: final int finalOffset = offset ;
---
Fixed code: final int finalOffset = correctOffset ( offset ) ;
Generation: public static final String current = this . + 1 ;
=============
=============
Buggy code: return this . comparator1 . equalToReference ( candidate . < K > getField ( 0 ) ) ;
---
Fixed code: return this . comparator1 . equalToReference ( candidate . < K > getFieldNotNull ( 0 ) ) ;
Generation: return this . ;
=============
=============
Buggy code: syncDLObjects , repositoryId ) ;
---
Fixed code: syncDLObjects , companyId , repositoryId ) ;
Generation: ignoreBadFiles , schemaToMergedSchemaMap , useMultipleSchemas ) ;
=============
=============
Buggy code: super . evaluateIfConditionalExpr ( batch , childExpressions ) ;
---
Fixed code: super . evaluateChildren ( batch ) ;
Generation: super . jobCloseOp ( hconf , Collections . < String , Object > ( ) ) ;
=============
=============
Buggy code: ! lastTryRetrievedCheckpoints . equals ( retrievedCheckpoints ) ) ;
---
Fixed code: ! CompletedCheckpoint . checkpointsMatch ( lastTryRetrievedCheckpoints , retrievedCheckpoints ) ) ;
Generation: if ( ! ApplicationManager . equals ( method , true ) ) ;
=============
=============
Buggy code: return delegate . mustRefreshDynamicVersion ( selector , moduleId , ageMillis ) ;
---
Fixed code: return false ;
Generation: return false ;
=============
=============
Buggy code: LOG . info ( "Loaded filter classes :" + filterClasses ) ;
---
Fixed code: LOG . info ( "Loaded filter classes :" + Arrays . toString ( filterClasses ) ) ;
Generation: LOG . info ( LOG + null ) ;
=============
=============
Buggy code: this . registry = new TestNodeRegistry ( addressMap . values ( ) ) ;
---
Fixed code: this . registry = new TestNodeRegistry ( Collections . unmodifiableCollection ( addressMap . values ( ) ) ) ;
Generation: this . registry = new TestNodeRegistry ( Collections . unmodifiableCollection ( addressMap . values ( ) ) ) ;
=============
=============
Buggy code: SearchContext . setCurrent ( new DefaultSearchContext ( 0 , new ShardSearchRequest ( ) . types ( request . types ( ) ) , null ,
---
Fixed code: SearchContext . setCurrent ( new DefaultSearchContext ( 0 , new ShardSearchRequest ( ) . types ( request . types ( ) ) . nowInMillis ( request . nowInMillis ( ) ) , null ,
Generation: SearchContext . setCurrent ( new DefaultSearchContext ( 0 , new ShardSearchRequest ( ) . types ( request . types ( ) ) ) . nowInMillis ( request . nowInMillis ( ) ) , null ,
=============
=============
Buggy code: setNumLabel ( orig . getNumLabel ( ) ) ;
---
Fixed code: setNumLabel ( 0 ) ;
Generation: 
=============
=============
Buggy code: sink . invoke ( value ) ;
---
Fixed code: sink . invoke ( value , SinkContextUtil . forTimestamp ( 0 ) ) ;
Generation: . add ( value ) ;
=============
=============
Buggy code: return true ;
---
Fixed code: return false ;
Generation: return ( Boolean ) getProperty . exists ( ) ) ;
=============
=============
Buggy code: result . addUnique ( proxies . createTypeReference ( BinarySignatures . createTypeSignature ( interfaceName ) , typeParameters ) ) ;
---
Fixed code: result . addUnique ( proxies . createTypeReference ( BinarySignatures . createObjectTypeSignature ( interfaceName ) , typeParameters ) ) ;
Generation: result . return ( ) . conf ( ( ) , if ( this .
=============
=============
Buggy code: HConnectionManager . deleteConnection ( conf ) ;
---
Fixed code: HConnectionManager . deleteConnectionInfo ( conf ) ;
Generation: HConnectionManager . deleteConnectionInfo ( conf ) ;
=============
=============
Buggy code: assertEquals ( slurped . trim ( ) , output . trim ( ) ) ;
---
Fixed code: assertEquals ( slurped . trim ( ) , output . replace ( "\r" , "" ) . trim ( ) ) ;
Generation: assertEquals ( , path . getName ( ) ) ;
=============
=============
Buggy code: if ( authManager instanceof SAML2AuthManager ) {
---
Fixed code: if ( authManager != null && authManager instanceof SAML2AuthManager ) {
Generation: if ( authManager != null && authManager instanceof SAML2AuthManager ) {
=============
=============
Buggy code: this . expression = expression ;
---
Fixed code: this . orderExpressions = orderExpressions ;
Generation: return this . collector ;
=============
=============
Buggy code: Table tbl = getTable ( tableName ) ;
---
Fixed code: Table tbl = getTable ( MetaStoreUtils . DEFAULT_DATABASE_NAME , tableName ) ;
Generation: table = new HTable ( conf , new < , > ( ) ) ;
=============
=============
Buggy code: final StandardTokenizer input = new StandardTokenizer ( TEST_VERSION_CURRENT ) ;
---
Fixed code: final StandardTokenizer input = new StandardTokenizer ( TEST_VERSION_CURRENT , newAttributeFactory ( ) ) ;
Generation: final StandardTokenizer input = new StandardTokenizer ( TEST_VERSION_CURRENT , newAttributeFactory ( ) ) ;
=============
=============
Buggy code: DefaultInputFile inputFile = new DefaultInputFile ( "foo" , "src/foo.xoo" ) . setLanguage ( "xoo" ) ;
---
Fixed code: DefaultInputFile inputFile = new DefaultInputFile ( "foo" , "src/foo.xoo" ) . setLanguage ( "xoo" ) . setLines ( 10 ) ;
Generation: DefaultInputFile inputFile = new DefaultInputFile ( "foo" , "src/foo.xoo" ) . setLanguage ( "xoo" ) . setLines ( 10 ) ;
=============
=============
Buggy code: this . isIncrementalDump = false ;
---
Fixed code: this . specType = Type . DEFAULT ;
Generation: this . false = false ;
=============
=============
Buggy code: int hash = 1 ;
---
Fixed code: int hash = 17 ;
Generation: int 1 = ( int ) ( String . int + 1 ) ;
=============
=============
Buggy code: if ( vm . getType ( ) == VirtualMachine . Type . User ) {
---
Fixed code: if ( vm . getType ( ) == VirtualMachine . Type . User || vm . getType ( ) == VirtualMachine . Type . DomainRouter ) {
Generation: if ( vm . + ( ) == null ) {
=============
=============
Buggy code: TagCompressionContext context = new TagCompressionContext ( LRUDictionary . class ) ;
---
Fixed code: TagCompressionContext context = new TagCompressionContext ( LRUDictionary . class , Byte . MAX_VALUE ) ;
Generation: TagCompressionContext context = new TagCompressionContext ( LRUDictionary . class , Byte . MAX_VALUE ) ;
=============
=============
Buggy code: unquotedCsvPreference = new CsvPreference . Builder ( '\0' , separator , "" ) . build ( ) ;
---
Fixed code: unquotedCsvPreference = getUnquotedCsvPreference ( separator ) ;
Generation: Set ( ) . new return ( ) ,
=============
=============
Buggy code: List < HiveLock > locks = getLocks ( conf , zkpClient , null , parent ) ;
---
Fixed code: List < HiveLock > locks = getLocks ( conf , zkpClient , null , parent , false , false ) ;
Generation: boolean < = < > ( conf , null , false , id , true ) ;
=============
=============
Buggy code: Assert . assertThat ( "Close Code" , closeCode , is ( expectedCode ) ) ;
---
Fixed code: Assert . assertThat ( "Close Code / Received [" + closeMessage + "]" , closeCode , is ( expectedCode ) ) ;
Generation: assertEquals ( false , response . getType ( ) ) ;
=============
=============
Buggy code: protected Reader initReader ( Reader reader ) {
---
Fixed code: protected Reader initReader ( String fieldName , Reader reader ) {
Generation: protected Reader initReader ( String fieldName , Reader reader ) {
=============
=============
Buggy code: shotMesh . render ( GL10 . GL_TRIANGLES ) ;
---
Fixed code: shotMesh . render ( ) ;
Generation: false . ) . ;
=============
=============
Buggy code: this . table . setAutoFlush ( false ) ;
---
Fixed code: this . table . setAutoFlush ( false , true ) ;
Generation: this . table . setAutoFlush ( false , true ) ;
=============
=============
Buggy code: componentBinaries . addAll ( component . getBinaries ( ) ) ;
---
Fixed code: componentBinaries . addAll ( component . getBinaries ( ) . values ( ) ) ;
Generation: myNamePathComponent . addAll ( ! . ( ( ) ) ) ;
=============
=============
Buggy code: TestStartRequest startRequest = new TestStartRequest ( profile , testHandle , jira , patch ) ;
---
Fixed code: TestStartRequest startRequest = new TestStartRequest ( profile , testHandle , jira , patch , clearLibraryCache ) ;
Generation: service = new ; ( null ,
=============
=============
Buggy code: createWithParents ( zkw , znode ) ;
---
Fixed code: createWithParents ( zkw , znode , data ) ;
Generation: getTimerService ( ) . registerTimer ( != ) ;
=============
=============
Buggy code: return new HiveStatement ( client , sessHandle ) ;
---
Fixed code: return new HiveStatement ( this , client , sessHandle ) ;
Generation: return new HiveDatabaseMetaData ( this , client , sessHandle ) ;
=============
=============
Buggy code: Set prevSet = new HashSet < Tuple2 < Long , Long > > ( ) ;
---
Fixed code: Set < Tuple2 < Long , Long > > prevSet = new HashSet < Tuple2 < Long , Long > > ( ) ;
Generation: ( ) , new null , job . length ) ;
=============
=============
Buggy code: Assert . assertEquals ( KeyedOneInputStreamOperatorTestHarness . MAX_PARALLELISM , count ) ;
---
Fixed code: Assert . assertEquals ( MAX_PARALLELISM , count ) ;
Generation: Assert . assertEquals ( MAX_PARALLELISM , count ) ;
=============
=============
Buggy code: return keyId | ( ( ( long ) type . intValue ( ) ) << 24 ) | ( longValue << 28 ) ;
---
Fixed code: return keyId | ( ( ( long ) type . intValue ( ) ) << StandardFormatSettings . PROPERTY_TOKEN_MAXIMUM_ID_BITS ) | ( longValue << 28 ) ;
Generation: return ( ( long ) type ) . intValue ( ) ) ;
=============
=============
Buggy code: GradleLauncher launcher = gradleLauncherFactory . newInstance ( param , serviceRegistry ) ;
---
Fixed code: GradleLauncher launcher = gradleLauncherFactory . newInstance ( param , serviceRegistry , false ) ;
Generation: , false = ;
=============
=============
Buggy code: return Integer . valueOf ( value ) ;
---
Fixed code: return Integer . valueOf ( value ) . intValue ( ) ;
Generation: return Boolean . valueOf ( value ) . booleanValue ( ) ;
=============
=============
Buggy code: RuntimeUDFContext ctx = new RuntimeUDFContext ( "test name" , 3 , 1 , getClass ( ) . getClassLoader ( ) , new ExecutionConfig ( ) , new HashMap < String , Accumulator < ? , ? > > ( ) ) ;
---
Fixed code: RuntimeUDFContext ctx = new RuntimeUDFContext ( "test name" , 3 , 1 , getClass ( ) . getClassLoader ( ) , new ExecutionConfig ( ) , new HashMap < String , Future < Path > > ( ) , new HashMap < String , Accumulator < ? , ? > > ( ) ) ;
Generation: RuntimeUDFContext ctx = new RuntimeUDFContext ( "test name" , 3 , 1 , getClass ( ) . getClassLoader ( ) , new ExecutionConfig ( ) , new HashMap < String , Future < Path > > ( ) , new HashMap < String , Accumulator < ? , ? > > ( ) ) ;
=============
=============
Buggy code: curIndex = setIndexOnLRInSplit ( index , spl ) ;
---
Fixed code: curIndex = setIndexOnLRInSplit ( index , spl , sameKeyType ) ;
Generation: ) = new ( ( index , op ) ) ;
=============
=============
Buggy code: if ( input == null || input . size ( ) == 0 )
---
Fixed code: if ( input == null || input . size ( ) == 0 || input . get ( 0 ) == null )
Generation: if ( input == null || input . size ( ) == 0 || input . get ( 0 ) == null )
=============
=============
Buggy code: newIndexWriterConfig ( TEST_VERSION_CURRENT , new MockAnalyzer ( MockTokenizer . WHITESPACE , false ) ) ) ;
---
Fixed code: newIndexWriterConfig ( TEST_VERSION_CURRENT , new MockAnalyzer ( random , MockTokenizer . WHITESPACE , false ) ) ) ;
Generation: newIndexWriterConfig ( TEST_VERSION_CURRENT , new MockAnalyzer ( random , MockTokenizer . WHITESPACE , false ) ) ) ;
=============
=============
Buggy code: document . setText ( myHunks . get ( 0 ) . getText ( ) ) ;
---
Fixed code: document . setText ( getNewFileText ( ) ) ;
Generation: . getTabAlias ( ) ) ;
=============
=============
Buggy code: HiveConf . getBoolVar ( jobConf , ConfVars . HIVE_OPTIMIZE_TEZ ) ?
---
Fixed code: HiveConf . getVar ( jobConf , ConfVars . HIVE_EXECUTION_ENGINE ) . equals ( "tez" ) ?
Generation: HiveConf . getVar ( job , ConfVars . HIVE_EXECUTION_ENGINE ) . equals ( "tez" ) ) ;
=============
=============
Buggy code: + "('s1:int, s2:int, s3:long, s4:float, s5:string, s6:bytes', '[s1, s2]; [s3, s4]')" ) ;
---
Fixed code: + "('[s1, s2]; [s3, s4]')" ) ;
Generation: + e . toString ( ) , e ) ;
=============
=============
Buggy code: . setContext ( MetricsUtils . METRICS_CONTEXT )
---
Fixed code: . setContext ( "executors" )
Generation: . setContext ( "queue" )
=============
=============
Buggy code: checkForErrors ( withJsLibAdded ( files , config ) , bindingContext ) ;
---
Fixed code: checkForErrors ( Config . withJsLibAdded ( files , config ) , bindingContext ) ;
Generation: setProperty ( new int ( ( ) , config ) ;
=============
=============
Buggy code: t . setAutoFlush ( false ) ;
---
Fixed code: t . setAutoFlush ( false , true ) ;
Generation: t . setAutoFlush ( false , true ) ;
=============
=============
Buggy code: public int ordValue ( ) {
---
Fixed code: public int ordValue ( ) throws IOException {
Generation: public int getVal ( Phase phase ) {
=============
=============
Buggy code: this . setOwner ( user . getShortName ( ) ) ;
---
Fixed code: this . setOwner ( user ) ;
Generation: this . metrics . incrementRequests ( 0 ) ;
=============
=============
Buggy code: if ( EndpointHelper . matchEndpoint ( uri , intercept . getUri ( ) ) ) {
---
Fixed code: if ( EndpointHelper . matchEndpoint ( context , uri , intercept . getUri ( ) ) ) {
Generation: if ( EndpointHelper . isLocal ( uri , > .
=============
=============
Buggy code: xpath = XPathCache . getXPathExpression ( context , wrapper , config . getExpression ( ) , config . getNamespaces ( ) , null , null , baseURI ) ;
---
Fixed code: xpath = XPathCache . getXPathExpression ( context , wrapper , config . getExpression ( ) , config . getNamespaces ( ) , null , null , baseURI , locationData ) ;
Generation: null = ObjectCacheFactory . createWALWriter ( context , < , - 1 , null , null , true , null ) ;
=============
=============
Buggy code: GatewayRetriever < T > leaderRetriever ,
---
Fixed code: GatewayRetriever < ? extends T > leaderRetriever ,
Generation: result , < ? > > ( ) : null ;
=============
=============
Buggy code: return false ;
---
Fixed code: return true ;
Generation: return true ;
=============
=============
Buggy code: "AA:AA:BB:BB:CC:CC" , "127.0.0.1" ) ;
---
Fixed code: TEST_MAC , "127.0.0.1" ) ;
Generation: ignoreBadFiles , e ) ;
=============
=============
Buggy code: segmentInfo = new SegmentInfo ( directoryOrig , Version . LATEST , segmentName , - 1 , false , codec , null , StringHelper . randomId ( ) ) ;
---
Fixed code: segmentInfo = new SegmentInfo ( directoryOrig , Version . LATEST , segmentName , - 1 , false , codec , null , StringHelper . randomId ( ) , new HashMap < > ( ) ) ;
Generation: final Long stop = new SegmentInfo ( dir , Version . LATEST , - 1 , false , codec , null , StringHelper . randomId ( ) , new HashMap < > ( ) ) ;
=============
=============
Buggy code: response . sendRedirect ( target ) ;
---
Fixed code: response . sendRedirect ( response . encodeRedirectURL ( target ) ) ;
Generation: ( ( Collection < OIdentifiable > ) tempResult ) . config ( alias ) ;
=============
=============
Buggy code: String v = p . getText ( ) ;
---
Fixed code: String v = p . getCurrentToken ( ) == JsonToken . VALUE_NULL ? null : p . getText ( ) ;
Generation: String value = ( String ) ? . ( ) + ( ) ;
=============
=============
Buggy code: TEST_VERSION_CURRENT , new MockAnalyzer ( MockTokenizer . SIMPLE , true , MockTokenFilter . ENGLISH_STOPSET , true ) ) ) ;
---
Fixed code: TEST_VERSION_CURRENT , new MockAnalyzer ( random , MockTokenizer . SIMPLE , true , MockTokenFilter . ENGLISH_STOPSET , true ) ) ) ;
Generation: newIndexWriterConfig ( TEST_VERSION_CURRENT , new MockAnalyzer ( random , MockTokenizer . SIMPLE , true , MockTokenFilter . ENGLISH_STOPSET , true ) ) ;
=============
=============
Buggy code: this . stagingDir = FileLocalizer . getTemporaryPath ( pigContext , "-tez-resource" ) ; ;
---
Fixed code: this . stagingDir = ( ( HPath ) FileLocalizer . getTemporaryResourcePath ( pigContext ) ) . getPath ( ) ;
Generation: this . fileName = . ( ( ) , this . context ) ;
=============
=============
Buggy code: GithubUtil . accessToGithubWithModalProgress ( project , new ThrowableComputable < Boolean , IOException > ( ) {
---
Fixed code: GithubUtil . accessToGithubWithModalProgress ( project , settings . getHost ( ) , new ThrowableComputable < Boolean , IOException > ( ) {
Generation: ( if ( ) . {
=============
=============
Buggy code: loadFileWork . add ( new LoadFileDesc ( queryTmpdir , destStr , isDfsDir , cols ,
---
Fixed code: loadFileWork . add ( new LoadFileDesc ( tblDesc , queryTmpdir , destStr , isDfsDir , cols ,
Generation: ! , , , , , ,
=============
=============
Buggy code: if ( s . equals ( elem ) ) {
---
Fixed code: if ( s . toLowerCase ( ) . equals ( elem ) ) {
Generation: if ( s . equals ( s ) . equals ( s ) ) {
=============
=============
Buggy code: public static Pattern SERVERNAME_PATTERN =
---
Fixed code: public static final Pattern SERVERNAME_PATTERN =
Generation: public static final String || String . format ( = ) ;
=============
=============
Buggy code: + " Either supply one in the route definition or via the message header '%s'" , SIGNATURE_PUBLIC_KEY_OR_CERT ) ) ;
---
Fixed code: + " Either supply one in the route definition or via the message header '%s'" , DigitalSignatureConstants . SIGNATURE_PUBLIC_KEY_OR_CERT ) ) ;
Generation: ) . , + ) + ")" ) ;
=============
=============
Buggy code: throw new ForbiddenException ( "Requires administration permission" ) ;
---
Fixed code: throw new ForbiddenException ( "Requires system administration permission" ) ;
Generation: throw new IllegalStateException ( "Expressions referencing the score can only be used for sorting" ) ;
=============
=============
Buggy code: actual = LruBlockCache . MAP_FIXED_OVERHEAD ;
---
Fixed code: actual = ClassSize . CONCURRENT_HASHMAP ;
Generation: . class = new true . ; ( null )
=============
=============
Buggy code: task . setObjectFileDir ( project . file ( String . valueOf ( project . getBuildDir ( ) ) + "/objs/" + binary . getNamingScheme ( ) . getOutputDirectoryBase ( ) + "/" + languageSourceSet . getProjectScopedName ( ) + "PCH" ) ) ;
---
Fixed code: task . setObjectFileDir ( new File ( binary . getNamingScheme ( ) . withOutputType ( "objs" ) . getOutputDirectory ( project . getBuildDir ( ) ) , languageSourceSet . getProjectScopedName ( ) + "PCH" ) ) ;
Generation: task . setObjectFileDir ( new File ( binary . getNamingScheme ( ) . withOutputType ( "objs" ) . getOutputDirectory ( project . getBuildDir ( ) ) , ( ) +
=============
=============
Buggy code: int offset = 0 ;
---
Fixed code: int offset = startOffset ;
Generation: int true = new float [ 0 ] ;
=============
=============
Buggy code: checkArgGroups ( arguments , 0 , inputTypes , NUMERIC_GROUP ) ;
---
Fixed code: checkArgGroups ( arguments , 0 , inputTypes , NUMERIC_GROUP , VOID_GROUP ) ;
Generation: checkArgGroups ( arguments , 0 , inputTypes , NUMERIC_GROUP , VOID_GROUP ) ;
=============
=============
Buggy code: if ( input == null || input . size ( ) == 0 )
---
Fixed code: if ( input == null || input . size ( ) == 0 || input . get ( 0 ) == null )
Generation: if ( input == null || input . size ( ) == 0 || input . get ( 0 ) == null )
=============
=============
Buggy code: mFileSystem . createFile ( new AlluxioURI ( "/a" + i ) , op ) ;
---
Fixed code: mFileSystem . createFile ( new AlluxioURI ( "/a" + i ) , op ) . close ( ) ;
Generation: false . false . getName ( ) ;
=============
=============
Buggy code: return port ;
---
Fixed code: return webServer . getConnectors ( ) [ 0 ] . getLocalPort ( ) ;
Generation: return ( String ) getProperty ( Exchange . BINDING ) ;
=============
=============
Buggy code: super ( ioEngineName , capacity , writerThreads , writerQLen , persistencePath ) ;
---
Fixed code: super ( ioEngineName , capacity , 8192 , writerThreads , writerQLen , persistencePath ) ;
Generation: super ( , , , , false , null ) ;
=============
=============
Buggy code: this . addAbility ( new EntersBattlefieldAbility ( new AddCountersSourceEffect ( CounterType . P1P1 . createInstance ( ) , numberCounters , true ) ,
---
Fixed code: this . addAbility ( new EntersBattlefieldAbility ( new AddCountersSourceEffect ( CounterType . P1P1 . createInstance ( 0 ) , numberCounters , true ) ,
Generation: this . ( new new < > ( ) , true ,
=============
=============
Buggy code: capacityResponse . setCapacityUsed ( capacity . getUsedCapacity ( ) ) ;
---
Fixed code: capacityResponse . setCapacityUsed ( capacity . getUsedCapacity ( ) + capacity . getReservedCapacity ( ) ) ;
Generation: capacityResponse . setCapacityUsed ( capacity . getUsedCapacity ( ) + capacity . getReservedCapacity ( ) ) ;
=============
=============
Buggy code: for ( SNode fieldNode : FindUtils . executeFinder ( "jetbrains.mps.baseLanguage.findUsages.OverridingFields_Finder" , node , scope , new EmptyProgressIndicator ( ) ) ) {
---
Fixed code: for ( SNode fieldNode : Sequence . fromIterable ( FindUtils . executeFinder ( "jetbrains.mps.baseLanguage.findUsages.OverridingFields_Finder" , node , scope , new EmptyProgressIndicator ( ) ) ) ) {
Generation: for ( SNode : Sequence . , ( ) , stats , false ) ) {
=============
=============
Buggy code: title = getCms ( ) . readProperty ( "/" , I_CmsConstants . C_PROPERTY_TITLE ) ;
---
Fixed code: title = getCms ( ) . readPropertyObject ( "/" , I_CmsConstants . C_PROPERTY_TITLE , false ) . getValue ( ) ;
Generation: title = getCms ( ) . resolveArtifact ( ) , ( ) . this ( false , ) . getValue ( ) ;
=============
=============
Buggy code: return true ;
---
Fixed code: return Boolean . TRUE ;
Generation: return ( Boolean ) getProperty . exists ( ) ) ;
=============
=============
Buggy code: public MatchCode checkColumn ( byte [ ] bytes , int offset , int length ) ;
---
Fixed code: public ScanQueryMatcher . MatchCode checkColumn ( byte [ ] bytes , int offset , int length ) ;
Generation: int length = ( ( byte [ ] ( ) , bytes , int , length , length ) ) ;
=============
=============
Buggy code: ClassLoader classLoader = Thread . currentThread ( ) . getContextClassLoader ( ) ;
---
Fixed code: ClassLoader classLoader = SolrCLI . class . getClassLoader ( ) ;
Generation: base = key ;
=============
=============
Buggy code: if ( values . size ( ) == 0 ) {
---
Fixed code: if ( values == null || values . size ( ) == 0 ) {
Generation: if ( values == null || values . size ( ) == 0 ) {
=============
=============
Buggy code: PrimitiveCategory commonCat = FunctionRegistry . getCommonCategory ( left , right ) ;
---
Fixed code: PrimitiveCategory commonCat = FunctionRegistry . getPrimitiveCommonCategory ( left , right ) ;
Generation: PrimitiveCategory commonCat = FunctionRegistry . getPrimitiveCommonCategory ( left , right ) ;
=============
=============
Buggy code: sessionState . open ( TezSessionState . makeSessionId ( ) , newConf ) ;
---
Fixed code: sessionState . open ( newConf ) ;
Generation: Exception . getId ( ) ;
=============
=============
Buggy code: String charset = ObjectHelper . after ( after , "=" ) ;
---
Fixed code: String charset = IOConverter . normalizeCharset ( ObjectHelper . after ( after , "=" ) ) ;
Generation: String null = configuration . ) . ( ( ) ? null : sb . ! ( ( ) , this . 1 ) ;
=============
=============
Buggy code: schema = ( new JsonMetadata ( ) ) . getSchema ( location , job ) ;
---
Fixed code: schema = ( new JsonMetadata ( ) ) . getSchema ( location , job , isSchemaOn ) ;
Generation: this . , = new ( ( ) ) . , ( new ArrayList [ ] ( ) ) . conf ( , ) . ; (
=============
=============
Buggy code: query ,
---
Fixed code: query . toString ( ) ,
Generation: query . toString ( ) ,
=============
=============
Buggy code: String filterExpr = Utilities . serializeExpression ( node ) ;
---
Fixed code: String filterExpr = SerializationUtilities . serializeExpression ( node ) ;
Generation: String filterExpr = SerializationUtilities . serializeExpression ( node ) ;
=============
=============
Buggy code: String [ ] concreteIndices = clusterState . metaData ( ) . concreteIndices ( request . indices ( ) ) ;
---
Fixed code: String [ ] concreteIndices = clusterState . metaData ( ) . concreteIndices ( request . indices ( ) , false , true ) ;
Generation: String [ ] cmds = lines . split ( request . . ( ) , conf . = ( ) . new ( ( ) , request . . ( ) , new HashMap < String [ ] {
=============
=============
Buggy code: return new Path ( new Path ( rootdir , "splitlog" ) , tmpname ) ;
---
Fixed code: return new Path ( new Path ( rootdir , HConstants . SPLIT_LOGDIR_NAME ) , tmpname ) ;
Generation: return new Path ( new Path ( onefile , ) , false ) ;
=============
=============
Buggy code: expr = XPathCache . getXPathExpression ( context , hrefDocumentInfo , "boolean(" + condition + ")" , namespaces ) ;
---
Fixed code: expr = XPathCache . getXPathExpression ( context , hrefDocumentInfo , "boolean(" + condition + ")" , namespaces , getLocationData ( ) ) ;
Generation: path = cluster . context ( context , 4 , true , true , null , true ) ;
=============
=============
Buggy code: Hive . copyFiles ( hiveConf , sourcePath , targetPath , spyTargetFs , isSourceLocal , NO_ACID , false , null ) ;
---
Fixed code: Hive . copyFiles ( hiveConf , sourcePath , targetPath , spyTargetFs , isSourceLocal , NO_ACID , false , null , false , false ) ;
Generation: Hive . copyFiles ( hiveConf , sourcePath , targetPath , targetFs , isSourceLocal , isSourceLocal , NO_ACID , false , null , false , false ) ;
=============
=============
Buggy code: useExtDns = UseExternalDnsServers . valueIn ( dc . getId ( ) ) ;
---
Fixed code: useExtDns = useExtDns || UseExternalDnsServers . valueIn ( dc . getId ( ) ) ;
Generation: , job = null . getId ( ) ) ;
=============
=============
Buggy code: return stateDesc . getDefaultValue ( ) ;
---
Fixed code: return null ;
Generation: return valueSerializer ;
=============
=============
Buggy code: Min , Max , Sum
---
Fixed code: Min , Max , Sum , Avg
Generation: 31 ,
=============
=============
Buggy code: input . result = bagFactory . newDefaultBag ( ) ;
---
Fixed code: input . result = new NonSpillableDataBag ( ) ;
Generation: result . input ( input . get ( 0 ) ) ;
=============
=============
Buggy code: . randomUUID ( ) . toString ( ) , primaryPool ) ;
---
Fixed code: . randomUUID ( ) . toString ( ) , primaryPool , 0 ) ;
Generation: int += ( ) . services ( ) . addComponentPermission ( UserRole . USER , primaryPool , e ) ;
=============
=============
Buggy code: + "('s2:int, s3:long, s4:float, s5:string, s6:bytes', '[s1, s2]; [s3, s4]')" ) ;
---
Fixed code: + "('[s7, s2]; [s3, s4]')" ) ;
Generation: + e . toString ( ) , e ) ;
=============
=============
Buggy code: . map ( this :: asCamelClusterMember )
---
Fixed code: . map ( AtomixClusterMember :: new )
Generation: new Path ( . class ) ,
=============
=============
Buggy code: if ( vmMo != null ) {
---
Fixed code: if ( vmMo != null && vmMo . isTemplate ( ) ) {
Generation: if ( properties != null && tableDesc != null ) {
=============
=============
Buggy code: HRegion . deleteRegion ( master . fs , master . rootdir , parent ) ;
---
Fixed code: HRegion . deleteRegion ( this . master . fs , this . master . rootdir , parent ) ;
Generation: master . serverManager . createNotification ( this . fs , master . getServerName ( ) ) ;
=============
=============
Buggy code: horizontalResizeAnimation ( initialSize , targetSize ) . run ( 300 ) ;
---
Fixed code: resizeHorizontally ( initialSize , targetSize ) ;
Generation: ( ( ) ) . ( ( ) == null ? Collections . < String , Object > e ) : null ;
=============
=============
Buggy code: prettyPrintedRegionName +
---
Fixed code: ( prettyPrintedRegionName == null ? "null" : prettyPrintedRegionName ) +
Generation: "You need to add the corresponding JAR file supporting this SPI to your classpath. " +
=============
=============
Buggy code: Schema schema = new Schema . Parser ( ) . parse ( new String ( json ) ) ;
---
Fixed code: Schema schema = new Schema . Parser ( ) . parse ( new String ( json , ConfigConstants . DEFAULT_CHARSET ) ) ;
Generation: schema = new + < ? > ( ) ;
=============
=============
Buggy code: Schema schColl = schema . getColumn ( 3 ) . getSchema ( ) ;
---
Fixed code: Schema schColl = schema . getColumn ( 3 ) . getSchema ( ) . getColumn ( 0 ) . getSchema ( ) ;
Generation: Set getSd = new ? > ( 3 ) . getAbsolutePath ( ) ;
=============
=============
Buggy code: "!" , "(" , ")" , "^" , "[" , "{" , ":" , "]" , "}" , "~" } ;
---
Fixed code: "!" , "(" , ")" , "^" , "[" , "{" , ":" , "]" , "}" , "~" , "/" } ;
Generation: INT , , , false , id , Collections . unmodifiableMap ( , ) , ! 1 , p , min ( ) ) ;
=============
=============
Buggy code: if ( avgFileSize > context . maxSize ) {
---
Fixed code: if ( avgFileSize > context . maxSize || numFiles <= context . minSplits ) {
Generation: if ( context . isNormalServer ( ) && context . getServiceRegistry ( false ) . getService ( ModClusterService . NAME ) != null ) {
=============
=============
Buggy code: result . set ( o . hashCode ( ) ) ;
---
Fixed code: result . set ( o == null ? 0 : o . hashCode ( ) ) ;
Generation: result . set ( t0 . compareTo ( t1 ) ) ;
=============
=============
Buggy code: wh . write ( self . getLabelAttrs ( ) ) . write ( " class=\"" + self . getZclass ( ) + "\"" )
---
Fixed code: wh . write ( self . getLabelAttrs ( ) ) . write ( " class=\"" + self . getZclass ( ) + "-cnt\"" )
Generation: . write ( new v . next ( ) . add ( new IOException . config ( ) ) . thenReturn ( ) ;
=============
=============
Buggy code: if ( mjCtx . getOldMapJoin ( ) == null ) {
---
Fixed code: if ( mjCtx . getOldMapJoin ( ) == null || setReducer ) {
Generation: if ( ( currOp . getParentOperators ( ) == null ) || ( currOp . getParentOperators ( ) . isEmpty ( ) ) ) {
=============
=============
Buggy code: Directory dir = FSDirectory . getDirectory ( dirName ) ;
---
Fixed code: Directory dir = FSDirectory . getDirectory ( dirName , null , false ) ;
Generation: Directory dir = FSDirectory . getDirectory ( dirName , null , false ) ;
=============
=============
Buggy code: final String methodSignature = JDOMExternalizer . readString ( e , "METHOD" ) ;
---
Fixed code: final String methodSignature = fixSignature ( JDOMExternalizer . readString ( e , "METHOD" ) , false ) ;
Generation: final String friendName = String . format ( e , true ) ;
=============
=============
Buggy code: ClosureCleaner . clean ( function , true ) ;
---
Fixed code: clean ( function ) ;
Generation: ProcessorDefinitionHelper . resolvePropertyPlaceholders ( this . true , true ) ;
=============
=============
Buggy code: if ( isKeyTuple ) {
---
Fixed code: if ( isKeyTuple && isKeyCompound ) {
Generation: if ( ! endpoint . getApplication ( ) . isUnitTestMode ( ) ) {
=============
=============
Buggy code: if ( ! this . comparators1 [ i ] . equalToReference ( candidate . getField ( keyFields2 [ i ] ) ) ) {
---
Fixed code: if ( ! this . comparators1 [ i ] . equalToReference ( candidate . getFieldNotNull ( keyFields2 [ i ] ) ) ) {
Generation: if ( ! this . regionsInTransitionInRS [ i ] . text ( ) ) {
=============
=============
Buggy code: return startPerformanceTest ( expected , test ) . message ( message ) ;
---
Fixed code: return new TestInfo ( test , expected , message ) ;
Generation: return ( List ) dir . getBytes ( message ) . toLowerCase ( ) ) ;
=============
=============
Buggy code: super ( color . getRGB ( ) ) ;
---
Fixed code: super ( color != null ? color . getRGB ( ) : 0 ) ;
Generation: super . == null ? new : new > ( ( ) ) ;
=============
=============
Buggy code: return new CvsRevisionNumber ( myRevisionNumber ) ;
---
Fixed code: return myRevision . getCvsRevisionNumber ( ) ;
Generation: return new PigTextInputFormat ( ) ;
=============
=============
Buggy code: tableTypeList . add ( tableTypeMapping . mapToHiveType ( tableType . trim ( ) ) ) ;
---
Fixed code: tableTypeList . addAll ( Arrays . asList ( tableTypeMapping . mapToHiveType ( tableType . trim ( ) ) ) ) ;
Generation: . add ( new StageMetrics ( . class . getName ( ) ) ) ;
=============
=============
Buggy code: in . getFamilyMap ( ) . entrySet ( ) ) {
---
Fixed code: in . getFamilyCellMap ( ) . entrySet ( ) ) {
Generation: if ( ( endpoint . ) . getBytes ( ) ) {
=============
=============
Buggy code: editPage . setObject ( object ( ) ) ;
---
Fixed code: editPage . setObject ( ERD2WUtilities . localInstanceFromObjectWithD2WContext ( object ( ) , d2wContext ( ) ) ) ;
Generation: ) . ( ( true ) ) ;
=============
=============
Buggy code: DocGen . HTML . section ( sb , report ( ) + "<br/>Frame '" + aft . toString ( ) + "' now has " + fr . numCols ( ) + " columns." ) ;
---
Fixed code: DocGen . HTML . section ( sb , report ( ) + "<br/>Frame '" + aft . toString ( ) + "' contains the interaction feature." ) ;
Generation: + . ( ) + ( + ? . toString ( ) + ) +
=============
=============
Buggy code: return this . blockSize * this . numBlocks ;
---
Fixed code: return ( long ) this . blockSize * ( long ) this . numBlocks ;
Generation: return this . . ( ) + this . Class ( ) . this ( this . super . value ) ;
=============
=============
Buggy code: if ( myOriginalModels . containsKey ( model ) ) {
---
Fixed code: if ( myOriginalModels . containsKey ( model ) ) {
Generation: if ( ! endpoint . ) && ! ApplicationManager . getApplication ( ) . isUnitTestMode ( ) ) {
=============
=============
Buggy code: this . compressionKind = org . apache . orc . CompressionKind . valueOf ( codecStr ) ;
---
Fixed code: this . compressionKind = org . apache . orc . CompressionKind . valueOf ( codecStr . toUpperCase ( ) ) ;
Generation: this . datasource = KernelBean . getNeoDataSource ( management . exchange . . ( ) , this . false ) ;
=============
=============
Buggy code: if ( pctx . getContext ( ) . getExplain ( ) && ! isSparkExecEngine && ! isTezExecEngine ) {
---
Fixed code: if ( isSparkExecEngine || ( pctx . getContext ( ) . getExplain ( ) && ! isTezExecEngine ) ) {
Generation: if ( tabAlias . equalsIgnoreCase ( ) && ! ApplicationManager . getApplication ( ) . isUnitTestMode ( ) ) {
=============
=============
Buggy code: return "if" ;
---
Fixed code: return NAME ;
Generation: return Optional . ofNullable ( initialReplayIdMap ) . orElse ( Collections . emptyMap ( ) ) ;
=============
=============
Buggy code: dirs [ k ] = new MockDirectoryWrapper ( random ( ) , new RAMDirectory ( dir , newIOContext ( random ( ) ) ) ) ;
---
Fixed code: dirs [ k ] = new MockDirectoryWrapper ( random ( ) , TestUtil . ramCopyOf ( dir ) ) ;
Generation: dirs [ k ] = new MockDirectoryWrapper ( random ( ) , TestUtil . ramCopyOf ( aux ) ) ;
=============
=============
Buggy code: if ( namespaceDelimIndex == 0 || namespaceDelimIndex == - 1 ) {
---
Fixed code: if ( namespaceDelimIndex < 0 ) {
Generation: if ( ( == == 1 || ( == - 1 ) ) {
=============
=============
Buggy code: client . getParams ( ) . setParameter ( ConnRoutePNames . DEFAULT_PROXY , new HttpHost ( host , port ) ) ;
---
Fixed code: client . getParams ( ) . setParameter ( ConnRoutePNames . DEFAULT_PROXY , new HttpHost ( host , port , scheme ) ) ;
Generation: this . compactSplitThread . requestSystemCompaction ( ) . , ( ) . exists ( ) . exists ( ) ) ;
=============
=============
Buggy code: TEST_UTIL . loadTable ( ht , FAMILYNAME ) ;
---
Fixed code: TEST_UTIL . loadTable ( ht , FAMILYNAME , false ) ;
Generation: TEST_UTIL . loadTable ( ht , true , true ) ;
=============
=============
Buggy code: if ( e instanceof ServerNotRunningException ) {
---
Fixed code: if ( e instanceof ServerNotRunningYetException ) {
Generation: if ( e . getMessage ( ) , e ) {
=============
=============
Buggy code: COL_REGIONINFO_ARRAY , tableName , System . currentTimeMillis ( ) , null ) ;
---
Fixed code: COL_REGIONINFO_ARRAY , tableName , HConstants . LATEST_TIMESTAMP , null ) ;
Generation: COL_REGIONINFO_ARRAY , tableName , HConstants . LATEST_TIMESTAMP , null ) ;
=============
=============
Buggy code: if ( includeColumn [ columnId ] ) {
---
Fixed code: if ( includeColumn == null || includeColumn [ columnId ] ) {
Generation: if ( [ ] && ! byte [ ] ) {
=============
=============
Buggy code: ( OStorageLocalAbstract ) ODatabaseRecordThreadLocal . INSTANCE . get ( ) . getStorage ( ) ) ;
---
Fixed code: ( OStorageLocalAbstract ) ODatabaseRecordThreadLocal . INSTANCE . get ( ) . getStorage ( ) . getUnderlying ( ) ) ;
Generation: ( OStorageLocalAbstract ) ODatabaseRecordThreadLocal . INSTANCE . get ( ) . getStorage ( ) . getUnderlying ( ) ) ;
=============
=============
Buggy code: return new TupleTypeInfo ( Tuple0 . class , new TypeInformation < ? > [ 0 ] ) ;
---
Fixed code: return new TupleTypeInfo ( Tuple0 . class ) ;
Generation: return new String ( . class , new < [ , > [ 0 ] ) ;
=============
=============
Buggy code: String toTest = "hausa_spelling_dictionary-0.2-tb+fx.xpi" ;
---
Fixed code: String toTest = "woordenboek_nederlands-3.1.1-sm+tb+fx+fn.xpi" ;
Generation: String encoding = HttpUtils . getSetEncoding ( mt , headers , "UTF-8" ) ;
=============
=============
Buggy code: HRegionInfo . createRegionName ( tableName , null , HConstants . NINES ) ) ;
---
Fixed code: HRegionInfo . createRegionName ( tableName , null , HConstants . NINES , false ) ) ;
Generation: + ( region , null , new String . valueOf ( tableName ) ) ) ;
=============
=============
Buggy code: MockUserSession . set ( ) . addComponentPermission ( UserRole . USER , PROJECT_KEY , COMPONENT_KEY ) ;
---
Fixed code: MockUserSession . set ( ) . addComponentPermission ( UserRole . USER , SUB_PROJECT_KEY , COMPONENT_KEY ) ;
Generation: MockUserSession . set ( ) . addComponentPermission ( UserRole . USER , SUB_PROJECT_KEY , COMPONENT_KEY ) ;
=============
=============
Buggy code: amount += Bytes . toLong ( kv . getBuffer ( ) , kv . getValueOffset ( ) ) ;
---
Fixed code: amount += Bytes . toLong ( kv . getBuffer ( ) , kv . getValueOffset ( ) , kv . getValueLength ( ) ) ;
Generation: + Bytes . toStringBinary ( . ( ) , - 1 ) ;
=============
=============
Buggy code: this . addAbility ( new DelverOfSecretsAbility ( ) ) ;
---
Fixed code: this . addAbility ( new BeginningOfUpkeepTriggeredAbility ( new DelverOfSecretsEffect ( ) , TargetController . YOU , false ) ) ;
Generation: this . addAbility ( new ) ( new Path ( ( ) ) , this .
=============
=============
Buggy code: String msg = "Cannot cast to bytearray" ;
---
Fixed code: String msg = "Cannot cast from " + DataType . findTypeName ( inType ) + " to bytearray" ;
Generation: String msg = true ;
=============
=============
Buggy code: + " \"intervals\": [ \"2012-01-01T00:00:00.000/2012-01-03T00:00:00.000\" ]"
---
Fixed code: + " \"intervals\": [ \"2012-01-01T00:00:00.000-08:00/2012-01-03T00:00:00.000-08:00\" ]"
Generation: "You need to add the corresponding JAR file supporting this SPI to your classpath. " +
=============
=============
Buggy code: Format format = FormatFactory . getFormat ( type , pattern , precision ) ;
---
Fixed code: Format format = FormatFactory . getFormat ( type , pattern , getLocale ( ) , precision ) ;
Generation: Format format = FormatFactory . getFormat ( type , pattern , getLocale ( ) , precision ) ;
=============
=============
Buggy code: builder . addField ( getHCatFieldSchema ( fieldName , stypeInfo . getStructFieldTypeInfo ( fieldName ) ) ) ;
---
Fixed code: builder . addField ( getHCatFieldSchema ( fieldName , stypeInfo . getStructFieldTypeInfo ( fieldName ) , null ) ) ;
Generation: builder . addField ( getHCatFieldSchema ( null , . ( ( ) , builder ) ) ;
=============
=============
Buggy code: ServiceList services = getKubernetes ( ) . getServices ( ) ;
---
Fixed code: ServiceList services = getKubernetes ( ) . services ( ) . inNamespace ( getNamespace ( ) ) . list ( ) ;
Generation: client = new true ( ) .
=============
=============
Buggy code: addr ,
---
Fixed code: HCatHadoopShims . Instance . get ( ) . getAddress ( conf ) ,
Generation: 31 ,
=============
=============
Buggy code: if ( values == null || values . isEmpty ( ) ) {
---
Fixed code: if ( values . isEmpty ( ) ) {
Generation: if ( values == null || values . size ( ) ) {
=============
=============
Buggy code: RoleDDLDesc roleDesc = new RoleDDLDesc ( roleName , RoleDDLDesc . RoleOperation . CREATE_ROLE ) ;
---
Fixed code: RoleDDLDesc roleDesc = new RoleDDLDesc ( roleName , PrincipalType . ROLE , RoleDDLDesc . RoleOperation . CREATE_ROLE , null ) ;
Generation: final null = new false ( ) ;
=============
=============
Buggy code: String [ ] testNames = new String [ ] { "join1.q" , "join2.q" , "groupby1.q" , "groupby2.q" } ;
---
Fixed code: String [ ] testNames = new String [ ] { "join1.q" , "join2.q" , "groupby1.q" , "groupby2.q" , "join3.q" , "input1.q" , "input19.q" } ;
Generation: String [ ] { = new String [ ] {
=============
=============
Buggy code: connSuccessful = defaultBeelineConnect ( ) ;
---
Fixed code: connSuccessful = defaultBeelineConnect ( cl ) ;
Generation: > ( =
=============
=============
Buggy code: _vpcDrSeqNoDao . lockRow ( seqVo . getId ( ) , true ) ;
---
Fixed code: seqVo = _vpcDrSeqNoDao . lockRow ( seqVo . getId ( ) , true ) ;
Generation: . getInstance ( ) , true ) ;
=============
=============
Buggy code: vrbCtx . init ( hconf , fileKey , ( StructObjectInspector ) outputObjInspector ) ;
---
Fixed code: vrbCtx . init ( vOutContext . getScratchColumnTypeMap ( ) , ( StructObjectInspector ) outputObjInspector ) ;
Generation: getName ( ) . conf . conf , ;
=============
=============
Buggy code: myRoot = new DefaultMutableTreeNode ( ) ;
---
Fixed code: myRoot = new ArrangementTreeNode ( null ) ;
Generation: this . = new ArrayList < > ( ) ;
=============
=============
Buggy code: MetaStoreThread . BooleanPointer startedServing = new MetaStoreThread . BooleanPointer ( ) ;
---
Fixed code: AtomicBoolean startedServing = new AtomicBoolean ( ) ;
Generation: this . 1 = new > ( ) ;
=============
=============
Buggy code: return true ;
---
Fixed code: return false ;
Generation: return ( Boolean ) getProperty . exists ( ) ) ;
=============
=============
Buggy code: OutputStreamWriter out = new OutputStreamWriter ( outputStream ) ;
---
Fixed code: OutputStreamWriter out = new OutputStreamWriter ( outputStream , IOConverter . getCharsetName ( exchange ) ) ;
Generation: throw new RuntimeException ( e ) ;
=============
=============
Buggy code: return getScanner ( columns , startRow , HConstants . LATEST_TIMESTAMP , null ) ;
---
Fixed code: return getScanner ( Bytes . toByteArrays ( columns ) , startRow . getBytes ( ) ) ;
Generation: return ) . , ( ) ;
=============
=============
Buggy code: MockUserSession . set ( ) . addComponentPermission ( UserRole . USER , PROJECT_KEY , COMPONENT_KEY ) ;
---
Fixed code: MockUserSession . set ( ) . addComponentPermission ( UserRole . USER , SUB_PROJECT_KEY , COMPONENT_KEY ) ;
Generation: MockUserSession . set ( ) . addComponentPermission ( UserRole . USER , SUB_PROJECT_KEY , COMPONENT_KEY ) ;
=============
=============
Buggy code: PosixParser parser = new PosixParser ( ) ;
---
Fixed code: DefaultParser parser = new DefaultParser ( ) ;
Generation: DefaultParser parser = new DefaultParser ( ) ;
=============
=============
Buggy code: workJob . setCmd ( VmWorkMigrate . class . getName ( ) ) ;
---
Fixed code: workJob . setCmd ( VmWorkMigrateWithStorage . class . getName ( ) ) ;
Generation: workJob . setCmd ( VmWorkMigrateForScale . class . getName ( ) ) ;
=============
=============
Buggy code: this ( firstName , lastName , StringUtils . EMPTY , emailId , - 1 ) ;
---
Fixed code: this ( firstName , lastName , StringUtils . EMPTY , emailId , - 1 ) ;
Generation: this ( firstName , lastName , regionInfo , null , connector , null ) ;
=============
=============
Buggy code: requestCompaction ( r , s , why , NO_PRIORITY ) ;
---
Fixed code: requestCompaction ( r , s , why , Store . NO_PRIORITY ) ;
Generation: requestCompaction ( r , s , why , Store . NO_PRIORITY ) ;
=============
=============
Buggy code: return ICalWorker . createNotAuthorizedResponse ( null ) ;
---
Fixed code: return null ;
Generation: return ( null ) this . byteSize ;
=============
=============
Buggy code: PlanWalker childWalker = new ReverseDependencyOrderWalker ( lp ) ;
---
Fixed code: PlanWalker childWalker = new ReverseDependencyOrderWalkerWOSeenChk ( lp ) ;
Generation: PlanWalker childWalker = new ReverseDependencyOrderWalkerWOSeenChk ( exps . get ( "UTF-8" ) ) ;
=============
=============
Buggy code: completedUrl , allFiles , enablelog , jobType ) ) ;
---
Fixed code: completedUrl , allFiles , enablelog , enableJobReconnect , jobType ) ) ;
Generation: completedUrl , enablelog , jobType ) ;
=============
=============
Buggy code: throw new DoNotRetryIOException ( "Missing required field: qualifer value" ) ;
---
Fixed code: throw new DoNotRetryIOException ( "Missing required field: qualifier value" ) ;
Generation: throw new UnsupportedOperationException ( toString ( ) ) ;
=============
=============
Buggy code: cctx . deploy ( ) . unwind ( ) ;
---
Fixed code: cctx . deploy ( ) . unwind ( cctx ) ;
Generation: . release ( ) . this ( false ) ;
=============
=============
Buggy code: ParameterDeclarationList . parse ( builder ) ;
---
Fixed code: ParameterDeclarationList . parse ( builder , mRPAREN ) ;
Generation: this . false ) ;
=============
=============
Buggy code: final LineFileDocs docs = new LineFileDocs ( random ) ;
---
Fixed code: final LineFileDocs docs = new LineFileDocs ( random , defaultCodecSupportsDocValues ( ) ) ;
Generation: final LineFileDocs docs = new LineFileDocs ( random , defaultCodecSupportsDocValues ( ) ) ;
=============
=============
Buggy code: registerBeanDefinitionParser ( "custom-processor" , new MessageProcessorDefinitionParser ( ) ) ;
---
Fixed code: registerMuleBeanDefinitionParser ( "custom-processor" , new MessageProcessorDefinitionParser ( ) ) . addIgnored ( "name" ) ;
Generation: ) . || ( new , < String > ( ) ) ;
=============
=============
Buggy code: this . log . sync ( txid ) ;
---
Fixed code: syncOrDefer ( txid ) ;
Generation: syncOrDefer ( txid ) ;
=============
=============
Buggy code: assert childrenLatch > 0 ;
---
Fixed code: assert childrenLatch > 0 : this ;
Generation: assert len > 0 : "len must be > 0 (got " + len + ")" ;
=============
=============
Buggy code: initialize ( size ) ;
---
Fixed code: super ( size ) ;
Generation: super ( size ) ;
=============
=============
Buggy code: return new MIndex ( index . getIndexName ( ) , origTable , index . getCreateTime ( ) ,
---
Fixed code: return new MIndex ( index . getIndexName ( ) . toLowerCase ( ) , origTable , index . getCreateTime ( ) ,
Generation: return new index ( 0 ,
=============
=============
Buggy code: throw new UnsupportedOperationException ( ) ;
---
Fixed code: return 0 ;
Generation: return ( Boolean ) fields . get ( RuleField . TEMPLATE . key ( ) ) ;
=============
=============
Buggy code: env . put ( UserGroupInformation . HADOOP_TOKEN_FILE_LOCATION ,
---
Fixed code: env . put ( ShimLoader . getHadoopShims ( ) . getTokenFileLocEnvName ( ) ,
Generation: if ( ! ApplicationManager . getApplication ( ) . , ( ) ,
=============
=============
Buggy code: return 0 ;
---
Fixed code: return MAX_SLOTS_UNKNOWN ;
Generation: return MAX_SLOTS_UNKNOWN ;
=============
=============
Buggy code: Table indexTable = buildTable ( DB_NAME , INDEX_TABLE_NAME ) ;
---
Fixed code: Table indexTable = buildIndexTable ( DB_NAME , INDEX_TABLE_NAME ) ;
Generation: Table indexTable = buildIndexTable ( DB_NAME , INDEX_TABLE_NAME ) ;
=============
=============
Buggy code: if ( mapArray == null || mapArray . length == 0 ) {
---
Fixed code: if ( mapArray == null ) {
Generation: if ( ( == == null || ! value . length == 0 ) ) {
=============
=============
Buggy code: if ( markedForDisposal )
---
Fixed code: if ( markedForDisposal )
Generation: if ( markedForDisposal )
=============
=============
Buggy code: TaskAttemptContext newContext = new TaskAttemptContextImpl ( conf , taskId ) ;
---
Fixed code: TaskAttemptContext newContext = new TaskAttemptContextImpl ( new Configuration ( conf ) , taskId ) ;
Generation: innerFieldSchema = new new < conf , new Configuration ( conf ) ) ;
=============
=============
Buggy code: Path archivedHfileDir = new Path ( UTIL . getDataTestDir ( ) , HConstants . HFILE_ARCHIVE_DIRECTORY ) ;
---
Fixed code: Path archivedHfileDir = new Path ( UTIL . getDataTestDirOnTestFS ( ) , HConstants . HFILE_ARCHIVE_DIRECTORY ) ;
Generation: Path archivedHfileDir = new Path ( UTIL . getDataTestDirOnTestFS ( ) , HConstants . HFILE_ARCHIVE_DIRECTORY ) ;
=============
=============
Buggy code: assertEquals ( clusterId , rst . getRegionServer ( ) . getConfiguration ( ) . get ( HConstants . CLUSTER_ID ) ) ;
---
Fixed code: assertEquals ( clusterId , rst . getRegionServer ( ) . getClusterId ( ) ) ;
Generation: assertEquals ( ( ) , . ( ) . get ( ConfigConstants . DEFAULT_CHARSET ) ) ;
=============
=============
Buggy code: dagAMConf . set ( entry . getValue ( ) , dagAMConf . get ( entry . getKey ( ) ) ) ;
---
Fixed code: dagAMConf . setIfUnset ( entry . getValue ( ) , dagAMConf . get ( entry . getKey ( ) ) ) ;
Generation: logger . error ( entry . get ( ) . get ( entry . getTableName ( ) ) ) ;
=============
=============
Buggy code: detectDeadlock ( e , "unlock" ) ;
---
Fixed code: detectDeadlock ( dbConn , e , "unlock" ) ;
Generation: detectDeadlock ( dbConn , e , + + + e ) ;
=============
=============
Buggy code: updateIndexes ( put ) ;
---
Fixed code: updateIndexes ( put , lockId ) ;
Generation: throw . ( ( ( ) ) ;
=============
=============
Buggy code: evictableSize = currentPartitionSize * evictionPercentage / 100 ;
---
Fixed code: evictableSize = Math . max ( currentPartitionSize * evictionPercentage / 100 , 1 ) ;
Generation: +
=============
=============
Buggy code: if ( value != null ) {
---
Fixed code: if ( value != null && value . length > 0 ) {
Generation: if ( value != null && value . length > 0 ) {
=============
=============
Buggy code: DEFAULT_VALUE ( "default" ) ;
---
Fixed code: VALUE ( "value" ) ;
Generation: stop ( ) ;
=============
=============
Buggy code: public Object defaultVal ( ) { return JacksonUtils . toObject ( defaultValue ) ; }
---
Fixed code: public Object defaultVal ( ) { return JacksonUtils . toObject ( defaultValue , schema ) ; }
Generation: public final Collections . < String > ( ) {
=============
=============
Buggy code: sb . append ( "up to " ) . append ( target . getMaxNumberOfTargets ( ) ) . append ( " target " ) . append ( target . getTargetName ( ) ) . append ( " to their owners' hand" ) ;
---
Fixed code: sb . append ( "up to " ) . append ( CardUtil . numberToText ( target . getMaxNumberOfTargets ( ) ) ) . append ( " target " ) . append ( target . getTargetName ( ) ) . append ( " to their owners' hand" ) ;
Generation: sb . append ( StringUtils . capitalize ( ) . toString ( ) ) . append ( values ) . append ( "(" ) . append ( "(" ) . append ( "(" ) . append ( "(" ) . append ( "(" ) . append ( "(" ) . append ( "(" ) . append ( "(" ) . append ( "("
=============
=============
Buggy code: return componentSpec . getBinaries ( ) ;
---
Fixed code: return componentSpec . getBinariesContainer ( ) ;
Generation: return null ;
=============
=============
Buggy code: if ( in . getCurrentToken ( ) == JsonToken . VALUE_NUMBER_INT ) {
---
Fixed code: if ( in . getCurrentToken ( ) . isNumeric ( ) ) {
Generation: if ( in . getCurrentToken ( ) . isNumeric ( ) ) {
=============
=============
Buggy code: LOG . warn ( "Couldn't connect to " + endpoint . getConfiguration ( ) ) ;
---
Fixed code: LOG . warn ( "Couldn't connect to: " + endpoint . getConfiguration ( ) . remoteServerInformation ( ) ) ;
Generation: LOG . warn ( "Couldn't connect to: " + endpoint . getConfiguration ( ) . remoteServerInformation ( ) ) ;
=============
=============
Buggy code: return ( String ) fields . get ( "desc" ) ;
---
Fixed code: return ( String ) fields . get ( RuleField . DESCRIPTION . key ( ) ) ;
Generation: return ( String ) fields . get ( RuleField . NAME . key ( ) ) ;
=============
=============
Buggy code: unassign ( regionInfo , rs , expectedVersion , sn , true ) ;
---
Fixed code: unassign ( regionInfo , rs , expectedVersion , sn , true , null ) ;
Generation: this ( regionInfo , tableName , this , ( , true , null ) ;
=============
=============
Buggy code: return ElementClassFilter . VARIABLE ;
---
Fixed code: return new OrFilter ( ElementClassFilter . CLASS , ElementClassFilter . VARIABLE ) ;
Generation: return . ( ) ;
=============
=============
Buggy code: if ( Enum . class . isAssignableFrom ( targetType . getClass ( ) ) ) {
---
Fixed code: if ( targetType instanceof Class && Enum . class . isAssignableFrom ( ( Class < ? > ) targetType ) ) {
Generation: if ( ( currOp . null ) || ( value . isEmpty ( ) ) ) {
=============
=============
Buggy code: int blockIndex = ( int ) ( ( long ) index * bitsPerValue ) > > > BLOCK_BITS ;
---
Fixed code: int blockIndex = ( int ) ( ( ( long ) index * bitsPerValue ) > > > BLOCK_BITS ) ;
Generation: int blockIndex = ( int ) ( ( ( long ) index * bitsPerValue ) > > > BLOCK_BITS ) ;
=============
=============
Buggy code: return null ;
---
Fixed code: return "editing.altInsert.tostring.settings" ;
Generation: return Collections . emptyMap ( ) ;
=============
=============
Buggy code: storageFormat . fillDefaultStorageFormat ( ) ;
---
Fixed code: storageFormat . fillDefaultStorageFormat ( false ) ;
Generation: storageFormat . fillDefaultStorageFormat ( isExt ) ;
=============
=============
Buggy code: assertTokenStreamContents ( ts , new String [ 0 ] ) ;
---
Fixed code: assertTokenStreamContents ( ts , new String [ 0 ] , new int [ ] { } , new int [ ] { } , 5 ) ;
Generation: final ts < ? > [ 0 ] , new int [ 0 ] , 0 ) ;
=============
=============
Buggy code: iw . shutdown ( ) ;
---
Fixed code: iw . close ( ) ;
Generation: iw . close ( ) ;
=============
=============
Buggy code: String dbName = "tmpdb" ;
---
Fixed code: String dbName = "hive4159" ;
Generation: String . format ( = ) . toString ( ) ;
=============
=============
Buggy code: if ( rit . isPendingCloseOrClosing ( )
---
Fixed code: if ( ( rit . isPendingCloseOrClosing ( ) || rit . isOffline ( ) )
Generation: if ( ! ApplicationManager . getApplication ( ) . isUnitTestMode ( ) )
=============
=============
Buggy code: double angle = maxDistanceKM / ( SloppyMath . earthDiameter ( originLat ) / 2.0 ) ;
---
Fixed code: double angle = maxDistanceKM / EARTH_RADIUS_KM ;
Generation: ) = new ( ( JavaSdkType ) ? . ( ) + ( ) + ( stats ) ;
=============
=============
Buggy code: root = handleOrderBy ( root ) ;
---
Fixed code: root = handleOrderBy ( root , true ) ;
Generation: int 0 = ( ( String ) this . ) ;
=============
=============
Buggy code: readerToFile . put ( readerType , fileType ) ;
---
Fixed code: readerToFile . put ( readerType . getId ( ) , fileType ) ;
Generation: return ( String ) put ( . ( ) , file ) ;
=============
=============
Buggy code: connectionFactory . get ( TRANSACTION ) . set ( txType ) ;
---
Fixed code: connectionFactory . get ( Pooled . TRANSACTION . getName ( ) ) . set ( txType ) ;
Generation: connectionFactory . get ( Pooled . TRANSACTION . getName ( ) ) . set ( txType ) ;
=============
=============
Buggy code: throw new HiveAuthzPluginException ( "Error create role : " + e . getMessage ( ) , e ) ;
---
Fixed code: throw SQLAuthorizationUtils . getPluginException ( "Error create role" , e ) ;
Generation: throw SQLAuthorizationUtils . getPluginException ( , e ) ;
=============
=============
Buggy code: HBaseAdmin admin = this . context . getHaseIntegrationTestingUtility ( ) . getHBaseAdmin ( ) ;
---
Fixed code: HBaseAdmin admin = this . context . getHBaseIntegrationTestingUtility ( ) . getHBaseAdmin ( ) ;
Generation: HBaseAdmin admin = this . context . getHBaseIntegrationTestingUtility ( ) . getHBaseAdmin ( ) ;
=============
=============
Buggy code: outputSelectors = new HashMap < String , OutputSelector < ? > > ( ) ;
---
Fixed code: outputSelectors = new HashMap < String , List < OutputSelector < ? > > > ( ) ;
Generation: nics = new LinkedHashMap < String , LinkedHashMap < ? > > ( ) ;
=============
=============
Buggy code: plcEnabled = plc != null && memoryMode != OFFHEAP_TIERED ;
---
Fixed code: plcEnabled = plc != null && ( cctx . isNear ( ) || memoryMode != OFFHEAP_TIERED ) ;
Generation: float , = new > ( ) ;
=============
=============
Buggy code: if ( data == null || data . length <= 0 ) return ZooKeeperProtos . Table . State . ENABLED ;
---
Fixed code: if ( data == null || data . length <= 0 ) return null ;
Generation: return ( String ) null ;
=============
=============
Buggy code: this . fields = new HashMap ( ) ;
---
Fixed code: this . fields = new HashMap < String , Object > ( ) ;
Generation: this . destToAggregationExprs = new LinkedHashMap < String , Object > ( ) ;
=============
=============
Buggy code: . setDescription ( "Custom measures management" )
---
Fixed code: . setDescription ( "Manage custom measures for a project. See also api/metrics." )
Generation: . setDescription ( 0 )
=============
=============
Buggy code: if ( sourceHashHolder . hasBothReferenceAndCurrentSource ( ) && hasLastScan ) {
---
Fixed code: if ( sourceHashHolder != null && sourceHashHolder . getHashedReference ( ) != null && hasLastScan ) {
Generation: if ( ! + ( ) && null != false ) {
=============
=============
Buggy code: throw new LeaderRetrievalException ( "Could not retrieve the leader gateway" , e ) ;
---
Fixed code: throw new LeaderRetrievalException ( "Could not retrieve the leader gateway." , e ) ;
Generation: throw new IOException ( e , e ) ;
=============
=============
Buggy code: return ( myContext == null ? 0 : myContext . hashCode ( ) ) + 10 * mySourceElement . hashCode ( ) + 20 * getClass ( ) . getName ( ) . hashCode ( ) ;
---
Fixed code: return ( myContext == null ? 0 : myContext . hashCode ( ) ) + 10 * ( mySourceElement == null ? 0 : mySourceElement . hashCode ( ) ) + 20 * getClass ( ) . getName ( ) . hashCode ( ) ;
Generation: return ( == null ? 0 : Utilities . hashCode ( ) . hashCode ( ) + ")" ) ;
=============
=============
Buggy code: return receiver . type . equals ( returnType ) ;
---
Fixed code: return receiver . type . asCQL3Type ( ) . equals ( returnType . asCQL3Type ( ) ) ;
Generation: return receiver . type . asCQL3Type ( ) . equals ( + ) || receiver . type . asCQL3Type ( ) . equals ( fun . returnType ( ) ) ;
=============
=============
Buggy code: localLog . info ( "Stopping Google PubSub consumer" ) ;
---
Fixed code: localLog . info ( "Stopping Google PubSub consumer for {}/{}" , endpoint . getProjectId ( ) , endpoint . getDestinationName ( ) ) ;
Generation: endpoint . info ( ) ;
=============
=============
Buggy code: Graph sub = SubGraph . extract ( a , "uses" , Direction . OUT , "implements" , Direction . OUT ) ;
---
Fixed code: Graph sub = SubGraph . extract ( a , EdgePath . create ( Direction . OUT , "uses" , Direction . OUT , "implements" ) ) ;
Generation: Graph sub = SubGraph . extract ( a , EdgePath . create ( Direction . IN , "uses" , Direction . OUT , "implements" ) ) ;
=============
=============
Buggy code: LOG . info ( "FtpConsumer's client is being explicitly disconnected" ) ;
---
Fixed code: LOG . debug ( "Disconnecting from " + endpoint . getConfiguration ( ) . remoteServerInformation ( ) ) ;
Generation: LOG . info ( ) ;
=============
=============
Buggy code: mapperParser = new DocumentMapperParser ( new Index ( "test" ) , new AnalysisService ( new Index ( "test" ) ) , null , null ) ;
---
Fixed code: mapperParser = new DocumentMapperParser ( new Index ( "test" ) , new AnalysisService ( new Index ( "test" ) ) , null , null , null ) ;
Generation: ! profile = new new < > ( ( new ) ( new new ( ( ) , new ManaCostsImpl ( file ) ) , null , null ) ;
=============
=============
Buggy code: + " to double: " + e . toString ( ) ) ;
---
Fixed code: + " to double: " + e . toString ( ) , e ) ;
Generation: + e . toString ( ) , e ) ;
=============
=============
Buggy code: + Constants . STRING_TYPE_NAME + "\", but \""
---
Fixed code: + serdeConstants . STRING_TYPE_NAME + "\", but \""
Generation: + ClassSize . + + + - 1 +
=============
=============
Buggy code: if ( mapArray == null || mapArray . length == 0 ) {
---
Fixed code: if ( mapArray == null ) {
Generation: if ( ( == == null || ! value . length == 0 ) ) {
=============
=============
Buggy code: if ( input == null || input . size ( ) < 1 ) {
---
Fixed code: if ( input == null || input . size ( ) < 1 || input . get ( 0 ) == null ) {
Generation: if ( input == null || input . size ( ) < 1 || input . get ( 0 ) == null ) {
=============
=============
Buggy code: this . hiveConf , this . partitionCache , this . noColsMissingStats ) ;
---
Fixed code: this . hiveConf , this . partitionCache , this . colStatsCache , this . noColsMissingStats ) ;
Generation: this . table , this . ( this . path ) , this . ( ) ) ;
=============
=============
Buggy code: + this . serverName . getPort ( ) , this ) ;
---
Fixed code: + this . serverName . getPort ( ) , this , true ) ;
Generation: this . . ( ) , this , this ) ;
=============
=============
Buggy code: listener . onDropPartition ( new DropPartitionEvent ( part , success , this ) ) ;
---
Fixed code: listener . onDropPartition ( new DropPartitionEvent ( tbl , part , success , this ) ) ;
Generation: false . new ( ( output , builder , this . ) ) ;
=============
=============
Buggy code: HashMap < String , ASTNode > aggregations = doPhase1GetAggregationsFromSelect ( ast ) ;
---
Fixed code: LinkedHashMap < String , ASTNode > aggregations = doPhase1GetAggregationsFromSelect ( ast ) ;
Generation: byte < String , ASTNode > > = ( ( Collection < String , ASTNode > ) ) ;
=============
=============
Buggy code: if ( indexName . compareTo ( DOCS_INDEX_NAME ) == 0 ) {
---
Fixed code: if ( indexName . compareTo ( BuilderFactory . DOCS_TYPE ) == 0 ) {
Generation: if ( indexName . compareTo ( BuilderFactory . DOCS_TYPE ) == 0 ) {
=============
=============
Buggy code: if ( classEnvRule != null ) {
---
Fixed code: if ( classEnvRule != null && classEnvRule . isInitialized ( ) ) {
Generation: if ( classEnvRule != null && classEnvRule . size ( ) > - 1 ) {
=============
=============
Buggy code: conf , jobId ) ;
---
Fixed code: new Configuration ( conf ) , jobId ) ;
Generation: ;
=============
=============
Buggy code: exitVal = tsk . executeTask ( ) ;
---
Fixed code: exitVal = tsk . executeTask ( ss == null ? null : ss . getHiveHistory ( ) ) ;
Generation: evolution = rp . return ( ) == null ? null : = . ( ) ;
=============
=============
Buggy code: if ( certificate == null || certificate . isEmpty ( ) || key == null || key . isEmpty ( ) || domainSuffix == null || domainSuffix . isEmpty ( ) ) {
---
Fixed code: if ( Strings . isNullOrEmpty ( certificate ) || Strings . isNullOrEmpty ( key ) || Strings . isNullOrEmpty ( domainSuffix ) ) {
Generation: if ( ( == null || ! size ( ) || ! mPlan . size ( ) ) {
=============
=============
Buggy code: tblDesc . setLocation ( wh . getTablePath ( parentDb , tblDesc . getTableName ( ) ) . toString ( ) ) ;
---
Fixed code: tblDesc . setLocation ( wh . getDefaultTablePath ( parentDb , tblDesc . getTableName ( ) ) . toString ( ) ) ;
Generation: event . setProperty ( new Path ( out , . ( ) ) . toString ( ) ) ;
=============
=============
Buggy code: objectInStoreMgr . delete ( this ) ;
---
Fixed code: objectInStoreMgr . deleteIfNotReady ( this ) ;
Generation: objectInStoreMgr . deleteIfNotReady ( this ) ;
=============
=============
Buggy code: if ( HiveConf . getBoolVar ( jobConf , ConfVars . HIVE_ACID_TABLE_SCAN ) ) {
---
Fixed code: if ( AcidUtils . isFullAcidScan ( jobConf ) ) {
Generation: if ( HiveConf . getVar ( hconf , ConfVars . HIVE_EXECUTION_ENGINE ) . equals ( "tez" ) ) {
=============
=============
Buggy code: Processor childProcessor = routeContext . createProcessor ( this ) ;
---
Fixed code: Processor childProcessor = this . createChildProcessor ( routeContext , true ) ;
Generation: Processor childProcessor = this . createChildProcessor ( routeContext , false ) ;
=============
=============
Buggy code: TotalOrderPartitioner . setPartitionFile ( job , partitionFile ) ;
---
Fixed code: ShimLoader . getHadoopShims ( ) . setTotalOrderPartitionFile ( job , partitionFile ) ;
Generation: cache . get ( job , false , null ) ;
=============
=============
Buggy code: Task < ReplStateLogWork > replLogTask = TaskFactory . get ( replLogWork , context . hiveConf ) ;
---
Fixed code: Task < ReplStateLogWork > replLogTask = TaskFactory . get ( replLogWork , context . hiveConf , true ) ;
Generation: Task < ? > > = TaskFactory . get ( , , context . hiveConf , true ) ;
=============
=============
Buggy code: String address = uri . startsWith ( "jetty:" ) ? remaining : uri ;
---
Fixed code: String address = remaining ;
Generation: final config = new Thread ( name , - + 1 ) ;
=============
=============
Buggy code: String fileName = paths [ paths . length - 1 ] ;
---
Fixed code: String fileName = paths [ paths . length - 1 ] . toLowerCase ( ) ;
Generation: String key = false . getDataKey (
=============
=============
Buggy code: } else if ( config . getPort ( ) == - 1 ) {
---
Fixed code: } else if ( config . getPort ( ) == - 1 || config . getPort ( ) == 0 ) {
Generation: } else if ( config . getPort ( ) == - 1 || config . getPort ( ) == 0 ) {
=============
=============
Buggy code: JSONObject outJSONObject = new JSONObject ( ) ;
---
Fixed code: JSONObject outJSONObject = new JSONObject ( new LinkedHashMap < > ( ) ) ;
Generation: JSONObject outJSONObject = new JSONObject ( new LinkedHashMap < > ( ) ) ;
=============
=============
Buggy code: LOG . info ( Bytes . toString ( splits [ i ] ) ) ;
---
Fixed code: LOG . info ( Bytes . toStringBinary ( splits [ i ] ) ) ;
Generation: LOG . info ( Bytes . toStringBinary ( [ i ] ) ) ;
=============
=============
Buggy code: client = HiveMetaStore . newHMSHandler ( "hive client" , conf , true ) ;
---
Fixed code: client = HiveMetaStore . newRetryingHMSHandler ( "hive client" , conf , true ) ;
Generation: true , conf , true ) ;
=============
=============
Buggy code: for ( int j = 0 ; j < annotations [ i ] . length ; j ++ ) {
---
Fixed code: for ( int j = 0 ; j < annotations [ i ] . length ; j ++ ) {
Generation: for ( int i = 0 ; i < writables . length ; i i = i + length ) {
=============
=============
Buggy code: @ Assisted ( "application" ) Id . Application application ,
---
Fixed code: @ Assisted ( "applicationId" ) Id . Application application ,
Generation: ( ) . , ( ) . , ( ) == null ,
=============
=============
Buggy code: if ( markedForDisposal )
---
Fixed code: if ( markedForDisposal )
Generation: if ( markedForDisposal )
=============
=============
Buggy code: this . columnAccessInfo . add ( tab . getCompleteName ( ) , tab . getCols ( ) . get ( ord . i ) . getName ( ) ) ;
---
Fixed code: this . columnAccessInfo . add ( tab . getCompleteName ( ) , tab . getAllCols ( ) . get ( ord . i ) . getName ( ) ) ;
Generation: this . regionInfo . write ( , op . ( ) , op . true ) ;
=============
=============
Buggy code: return new ManagedReferenceLifecycleMethodInterceptor ( ref , method , changeMethod ) ;
---
Fixed code: return new ManagedReferenceLifecycleMethodInterceptor ( ref , method , changeMethod , this . lifecycleMethod ) ;
Generation: return new value ( new , ( new , ( ) , new ( < ? > ( ) ) ;
=============
=============
Buggy code: outputItemsets ( ch , itemsetUpdate ) ;
---
Fixed code: outputItemsets ( pipelineContext , ch , itemsetUpdate ) ;
Generation: getTimerService ( routeContext , this ) ;
=============
=============
Buggy code: assertTrue ( e . getMessage ( ) . contains ( "Error during parsing" ) ) ;
---
Fixed code: assertTrue ( e . getMessage ( ) . contains ( "<line 1, column 62> mismatched input ';' expecting RIGHT_PAREN" ) ) ;
Generation: assertTrue ( e . getMessage ( ) . contains ( "The affix file contains a rule with less than four elements" ) ) ;
=============
=============
Buggy code: super ( TypeInfoFactory . stringTypeInfo ) ;
---
Fixed code: super ( ) ;
Generation: super ( SCHEMA$ ) ;
=============
=============
Buggy code: public DocData getNextDocData ( DocData docData ) throws NoMoreDataException , IOException {
---
Fixed code: public synchronized DocData getNextDocData ( DocData docData ) throws NoMoreDataException , IOException {
Generation: public void logRollRequested ( boolean throws throws IOException {
=============
=============
Buggy code: assertEquals ( "b b <b>a</b> b <b>a</b> b" , f [ 1 ] ) ;
---
Fixed code: assertEquals ( "b b <b>a</b> b <b>a</b> b " , f [ 1 ] ) ;
Generation: assertEquals ( 1 , f [ 1 ] ) ;
=============
=============
Buggy code: percentage = ( ( float ) ( tests - errors - failures ) / ( float ) tests ) * PCENT ;
---
Fixed code: percentage = ( ( float ) ( tests - errors - failures - skipped ) / ( float ) tests ) * PCENT ;
Generation: ( "" ) ( ( stats != null ) ? ( stats : docValuesType ) + "" ) ;
=============
=============
Buggy code: indexReader . equals ( other . indexReader ) ;
---
Fixed code: indexReaderContextId . equals ( other . indexReaderContextId ) ;
Generation: indexReaderContextId . equals ( other . indexReaderContextId ) ;
=============
=============
Buggy code: this . comparator . setReference ( toCompare . < K > getField ( 0 ) ) ;
---
Fixed code: this . comparator . setReference ( toCompare . < K > getFieldNotNull ( 0 ) ) ;
Generation: this . comparator . setReference ( ) . < K > getFieldNotNull ( 0 ) ) ;
=============
=============
Buggy code: result . set ( o1 . hashCode ( ) ^ o2 . hashCode ( ) ) ;
---
Fixed code: result . set ( ( o1 == null ? 0 : o1 . hashCode ( ) ) ^ ( o2 == null ? 0 : o2 . hashCode ( ) ) ) ;
Generation: result . set ( t0 . compareTo ( t1 ) . hashCode ( ) ) ;
=============
=============
Buggy code: return SimpleWebException . buildMessage ( 500 , null , e . getMessage ( ) ) ;
---
Fixed code: return SimpleWebException . buildMessage ( HttpStatus . INTERNAL_SERVER_ERROR_500 , null , e . getMessage ( ) ) ;
Generation: return new . ( ( < , - e ) ;
=============
=============
Buggy code: . field ( "analyzer" , "whitespace" )
---
Fixed code: . field ( "analyzer" , "whitespace" )
Generation: . valueOf ( , ) . build ( )
=============
=============
Buggy code: return "term=" + term + ",field=" + field + ",value=" + value ;
---
Fixed code: return "term=" + term + ",field=" + field + ",value=" + value + ",docIDUpto=" + docIDUpto ;
Generation: return return + ( field ? 0 : value + value + value + ( + value + "]" ;
=============
=============
Buggy code: initialize ( size ) ;
---
Fixed code: super ( size ) ;
Generation: super ( size ) ;
=============
=============
Buggy code: fi = new FieldInfo ( name , isIndexed , fieldNumber , storeTermVector , omitNorms , storePayloads , indexOptions , docValues , normType , null ) ;
---
Fixed code: fi = new FieldInfo ( name , isIndexed , fieldNumber , storeTermVector , omitNorms , storePayloads , indexOptions , docValues , normType , - 1 , null ) ;
Generation: null = new StoreFile ( name , , , this , < , , > , 0 ) ;
=============
=============
Buggy code: final String desc = "L" + typeMapper . mapType ( descriptor . getDefaultType ( ) , JetTypeMapperMode . IMPL ) . getInternalName ( ) + ";" ;
---
Fixed code: final String desc = "L" + classAsmType . getInternalName ( ) + ";" ;
Generation: final String . format ( = ) . new final + String . format ( ConfigConstants . DEFAULT_CHARSET ) , ( ) . final ( ) + ":" ( long ) + 1 ) ;
=============
=============
Buggy code: index = new LuceneIndexService ( graphDb ) ;
---
Fixed code: index = graphDb . index ( ) . forNodes ( "nodes" ) ;
Generation: Plan p = new , ( new ArrayList < Throwable > ( ) ) ;
=============
=============
Buggy code: headers = sourceDirectorySetFactory . create ( "headers" ) ;
---
Fixed code: headers = sourceDirectorySetFactory . create ( "headers" , "headers for prebuilt library '" + name + "'" ) ;
Generation: . getInstance ( ) , ( ) ;
=============
=============
Buggy code: public void validateNtwkOffForNtwkInVpc ( Long networkId , long newNtwkOffId , String newCidr , String newNetworkDomain , Vpc vpc , String gateway , Account networkOwner ) {
---
Fixed code: public void validateNtwkOffForNtwkInVpc ( Long networkId , long newNtwkOffId , String newCidr , String newNetworkDomain , Vpc vpc , String gateway , Account networkOwner , Long aclId ) {
Generation: public void false , long , String , String , String , this , false ) {
=============
=============
Buggy code: File workDir = new File ( "work" ) ;
---
Fixed code: File workDir = new File ( config . get ( "work.dir" , "work" ) ) ;
Generation: File classesGen = new File ( > ( ) ) ;
=============
=============
Buggy code: cache = ObjectCacheFactory . getCache ( hconf , queryId ) ;
---
Fixed code: cache = ObjectCacheFactory . getCache ( hconf , queryId , false ) ;
Generation: rc = ObjectCacheFactory . getCache ( jconf , queryId , false ) ;
=============
=============
Buggy code: lbCtx . setLbLocationMap ( skewedColValueLocationMaps ) ;
---
Fixed code: lbCtx . setLbLocationMap ( convertSkewedValueListToSimpleList ( skewedColValueLocationMaps ) ) ;
Generation: . release ( ) . perform ( ) ;
=============
=============
Buggy code: && ref . getLastSpaceReference ( ) . getName ( ) . equals ( XWikiConstants . WIKI_SPACE ) ) {
---
Fixed code: && ref . getLastSpaceReference ( ) . getName ( ) . equals ( XWikiConstants . XWIKI_SPACE ) ) {
Generation: if ( PigMapReduce . null , . ( ) . equals ( . ( ) ) ) {
=============
=============
Buggy code: return TupleFactory . getInstance ( ) . newTuple ( arg ) ;
---
Fixed code: return TupleFactory . getInstance ( ) . newTuple ( AvroTupleWrapper . unionResolver ( arg ) ) ;
Generation: return Objects . fs ( , != ? . class : null ) ;
=============
=============
Buggy code: if ( schema != null && col >= schema . size ( ) ) {
---
Fixed code: if ( schema != null && schema . size ( ) != 0 && col >= schema . size ( ) ) {
Generation: if ( schema != null && ( schema . size ( ) ) {
=============
=============
Buggy code: HTable table = new HTable ( conf , tables [ 0 ] ) ;
---
Fixed code: HTable table = new HTable ( conf , TableName . valueOf ( tables [ 0 ] ) ) ;
Generation: HTable table = new HTable ( conf , TableName . valueOf ( tableName ) ) ;
=============
=============
Buggy code: for ( List < ? extends Cell > cells : put . getFamilyMap ( ) . values ( ) ) {
---
Fixed code: for ( List < ? extends Cell > cells : put . getFamilyCellMap ( ) . values ( ) ) {
Generation: for ( List < ? extends Cell > cells : put . getFamilyCellMap ( ) . values ( ) ) {
=============
=============
Buggy code: this . confOverlay = confOverlay ;
---
Fixed code: setConfOverlay ( confOverlay ) ;
Generation: this . + = ( ) . this ( ) . ;
=============
=============
Buggy code: LOG . debug ( "Failed to put element into ordered stream element queue because it " +
---
Fixed code: LOG . debug ( "Failed to put element into unordered stream element queue because it " +
Generation: LOG . debug ( +
=============
=============
Buggy code: populateMapRedPlan5 ( db . getTable ( "src" ) ) ;
---
Fixed code: populateMapRedPlan5 ( db . getTable ( MetaStoreUtils . DEFAULT_DATABASE_NAME , "src" ) ) ;
Generation: ;
=============
=============
Buggy code: HiveConf conf , HiveAuthenticationProvider authenticator ) {
---
Fixed code: HiveConf conf , HiveAuthenticationProvider authenticator , HiveAuthzSessionContext ctx ) {
Generation: HiveConf conf , HiveAuthenticationProvider authenticator , HiveAuthzSessionContext ctx ) {
=============
=============
Buggy code: return CellUtil . createCellScanner ( getFamilyMap ( ) ) ;
---
Fixed code: return CellUtil . createCellScanner ( getFamilyCellMap ( ) ) ;
Generation: return , != null ? file . tbl ( tbl . getDbName ( ) ) : null ;
=============
=============
Buggy code: if ( input == null || input . size ( ) == 0 )
---
Fixed code: if ( input == null || input . size ( ) == 0 || input . get ( 0 ) == null )
Generation: if ( input == null || input . size ( ) == 0 || input . get ( 0 ) == null )
=============
=============
Buggy code: final RebootCommand command = new RebootCommand ( vmName ) ;
---
Fixed code: final RebootCommand command = new RebootCommand ( vmName , true ) ;
Generation: final RebootCommand command = new RebootCommand ( vmName , true ) ;
=============
=============
Buggy code: this . tempFileName = createFileLangugeExpression ( tempFileNameExpression ) ;
---
Fixed code: this . tempFileName = createFileLanguageExpression ( tempFileNameExpression ) ;
Generation: this . href = new Thread ( if ( ) . = ( ) + null ) ;
=============
=============
Buggy code: expected . add ( "VALIDATE" ) ;
---
Fixed code: expected . addAll ( Collections . nCopies ( 6 , "VALIDATE" ) ) ;
Generation: expected . addAll ( Collections . nCopies ( 6 , "VALIDATE" ) ) ;
=============
=============
Buggy code: HiveSessionImpl session = new HiveSessionImpl ( protocol , username , password ,
---
Fixed code: HiveSessionImpl session = new HiveSessionImpl ( null , protocol , username , password ,
Generation: amNodeInfo = new AMNodeInfo ( amNodeId , umbilicalUser , jobToken , queryIdentifier ,
=============
=============
Buggy code: JavaUtils . getClassLoader ( ) ) ;
---
Fixed code: Utilities . getSessionSpecifiedClassLoader ( ) ) ;
Generation: Utilities . getSessionSpecifiedClassLoader ( ) ) ;
=============
=============
Buggy code: processor = wrapProcessor ( routeContext , processor ) ;
---
Fixed code: processor = wrapChannel ( routeContext , processor , processorType ) ;
Generation: Config ( this , processor , true ) ;
=============
=============
Buggy code: LOG . debug ( "Initialized address: " + this . toString ( ) ) ;
---
Fixed code: LOG . debug ( "INIT Initialized address: " + this . toString ( ) ) ;
Generation: LOG . debug ( + this . toString ( ) ) ;
=============
=============
Buggy code: return new Content ( this , id ) ;
---
Fixed code: return new StoredContent ( this , id ) ;
Generation: return new StoredContent ( this , id ) ;
=============
=============
Buggy code: dist = new LevensteinDistance ( ) ;
---
Fixed code: dist = new LevenshteinDistance ( ) ;
Generation: this = new true . ) ;
=============
=============
Buggy code: public boolean obtain ( long lockWaitTimeout ) throws IOException {
---
Fixed code: public final boolean obtain ( long lockWaitTimeout ) throws IOException {
Generation: public boolean accept ( long ) throws IOException {
=============
=============
Buggy code: return reader . getPosition ( ) ;
---
Fixed code: return reader != null ? reader . getPosition ( ) : 0 ;
Generation: return isEmptyInput ? 0 : reader . tell ( ) ;
=============
=============
Buggy code: doc . setDocumentURI ( reader . getLocation ( ) . getSystemId ( ) ) ;
---
Fixed code: doc . setDocumentURI ( new String ( reader . getLocation ( ) . getSystemId ( ) ) ) ;
Generation: doc . setDocumentURI ( new String ( reader . getLocation ( ) . getSystemId ( ) ) ) ;
=============
=============
Buggy code: List < CollectionRecord > list = ( List < CollectionRecord > ) getOrCreateCollectionWrapper ( ) ;
---
Fixed code: List < CollectionRecord > list = ( List < CollectionRecord > ) getOrCreateCollectionWrapper ( ) . getCollection ( ) ;
Generation: List < CollectionRecord > list = ( List < CollectionRecord > ) getOrCreateCollectionWrapper ( ) . getCollection ( ) ;
=============
=============
Buggy code: description = "if true, firewall rule for source/end pubic port is automatically created; if false - firewall rule has to be created explicitely. Has value true by default" )
---
Fixed code: description = "if true, firewall rule for source/end public port is automatically created; if false - firewall rule has to be created explicitely. Has value true by default" )
Generation: = new ) ( false )
=============
=============
Buggy code: col . setName ( colInfo . getAlias ( ) ) ;
---
Fixed code: col . setName ( unescapeIdentifier ( colInfo . getAlias ( ) ) . toLowerCase ( ) ) ;
Generation: visitor . . ( ) + Collections . . ( ) ) ;
=============
=============
Buggy code: newIndexWriterConfig ( TEST_VERSION_CURRENT , new MockAnalyzer ( MockTokenizer . WHITESPACE , false ) ) ) ;
---
Fixed code: newIndexWriterConfig ( TEST_VERSION_CURRENT , new MockAnalyzer ( random , MockTokenizer . WHITESPACE , false ) ) ) ;
Generation: newIndexWriterConfig ( TEST_VERSION_CURRENT , new MockAnalyzer ( random , MockTokenizer . WHITESPACE , false ) ) ) ;
=============
=============
Buggy code: if ( ! method . getName ( ) . equals ( "writeReplace" ) ) return false ;
---
Fixed code: if ( ! "writeReplace" . equals ( method . getName ( ) ) ) return false ;
Generation: if ( ! ) . equals ( method . getName ( ) ) ) return false ;
=============
=============
Buggy code: ExprNodeDesc pruneExpr = pruneNode . accept ( new ExprNodeConverter ( getName ( ) , getRowType ( ) , true ) ) ;
---
Fixed code: ExprNodeDesc pruneExpr = pruneNode . accept ( new ExprNodeConverter ( getName ( ) , getRowType ( ) , true , getRelOptSchema ( ) . getTypeFactory ( ) ) ) ;
Generation: . false ( new MockDirectoryWrapper ( file . getName ( ) ) , ( ) , true ) ;
=============
=============
Buggy code: crtTblDesc . getDatabaseName ( ) + "." + crtTblDesc . getTableName ( ) ) ;
---
Fixed code: crtTblDesc . getTableName ( ) ) ;
Generation: throw . ( ) + ( ( ) + file . getTableName ( ) ) ;
=============
=============
Buggy code: Processor childProcessor = routeContext . createProcessor ( this ) ;
---
Fixed code: Processor childProcessor = this . createChildProcessor ( routeContext , false ) ;
Generation: Processor childProcessor = this . createChildProcessor ( routeContext , false ) ;
=============
=============
Buggy code: source = xmlConverter . toSource ( document ) ;
---
Fixed code: source = xmlConverter . toDOMSource ( document ) ;
Generation: source = source . get ( Source . class ) ;
=============
=============
Buggy code: state . locks ( ) . releaseExclusive ( type , resourceId ) ;
---
Fixed code: state . locks ( ) . delegate ( ) . releaseExclusive ( type , resourceId ) ;
Generation: state . locks ( ) . delegate ( ) . releaseShared ( type , resourceId ) ;
=============
=============
Buggy code: HBaseTestingUtility util = context . getHaseIntegrationTestingUtility ( ) ;
---
Fixed code: HBaseTestingUtility util = context . getHBaseIntegrationTestingUtility ( ) ;
Generation: HBaseTestingUtility util = context . getHBaseIntegrationTestingUtility ( ) ;
=============
=============
Buggy code: response . sendRedirect ( _location ) ;
---
Fixed code: response . sendRedirect ( response . encodeRedirectURL ( _location ) ) ;
Generation: response . && ( ) . response ( ) . inNamespace ( getNamespace ( ) ) . list ( ) ;
=============
=============
Buggy code: FileSystem fs = FileSystem . get ( conf ) ;
---
Fixed code: FileSystem fs = FileSystem . get ( URI . create ( location ) , conf ) ;
Generation: FileSystem fs = FileSystem . get ( PigMapReduce . sJobConfInternal . get ( ) ) ;
=============
=============
Buggy code: HLog . Writer writer = HLogFactory . createWriter ( fs , recoveredEdits , conf ) ;
---
Fixed code: HLog . Writer writer = HLogFactory . createRecoveredEditsWriter ( fs , recoveredEdits , conf ) ;
Generation: HLog . Writer writer = HLogFactory . createRecoveredEditsWriter ( fs , recoveredEdits , conf ) ;
=============
=============
Buggy code: final DocTermOrds dto = new DocTermOrds ( ar , "field" ) ;
---
Fixed code: final DocTermOrds dto = new DocTermOrds ( ar , ar . getLiveDocs ( ) , "field" ) ;
Generation: final new false = new false ( null , , , false ) ;
=============
=============
Buggy code: return false ;
---
Fixed code: return delegate . isRuntime ( ) ;
Generation: return true ;
=============
=============
Buggy code: return true ;
---
Fixed code: return false ;
Generation: return ( Boolean ) getProperty . exists ( ) ) ;
=============
=============
Buggy code: return TOPIC_QUEUE_NAME ;
---
Fixed code: return getJmsConfig ( ) . getBroadcastDestinationName ( ) ;
Generation: return configuration . getRequestTimeout ( ) ;
=============
=============
Buggy code: mrManager . waitForFinish ( 180L , TimeUnit . SECONDS ) ;
---
Fixed code: mrManager . waitForFinish ( 1800L , TimeUnit . SECONDS ) ;
Generation: createDataset . && ( ) . evaluate ( ) , ;
=============
=============
Buggy code: lastTerm . bytes . copy ( term . bytes ) ;
---
Fixed code: lastTerm . bytes . copyBytes ( term . bytes ) ;
Generation: source . readFully ( term ) ;
=============
=============
Buggy code: . newScheduledThreadPool ( this , consumer . getEndpoint ( ) . getEndpointUri ( ) , 1 ) ;
---
Fixed code: . newSingleThreadScheduledExecutor ( consumer , consumer . getEndpoint ( ) . getEndpointUri ( ) ) ;
Generation: this . compactSplitThread . requestSystemCompaction ( this , false , false ) ;
=============
=============
Buggy code: } else if ( n . getNodeName ( ) . equalsIgnoreCase ( "interface" ) ) {
---
Fixed code: } else if ( "interface" . equalsIgnoreCase ( n . getNodeName ( ) ) ) {
Generation: } else if ( clause .
=============
=============
Buggy code: exchange . setProperty ( Exchange . CHARSET_NAME , charset ) ;
---
Fixed code: exchange . setProperty ( Exchange . CHARSET_NAME , IOConverter . normalizeCharset ( charset ) ) ;
Generation: exchange . setProperty ( Exchange . CHARSET_NAME , IOConverter . normalizeCharset ( charset ) ) ;
=============
=============
Buggy code: if ( conf . getBoolean ( USEMSLAB_KEY , USEMSLAB_DEFAULT ) ) {
---
Fixed code: if ( conf . getBoolean ( MemStoreLAB . USEMSLAB_KEY , MemStoreLAB . USEMSLAB_DEFAULT ) ) {
Generation: if ( conf . getBoolean ( , ) ) {
=============
=============
Buggy code: String [ ] concreteIndices = clusterState . metaData ( ) . concreteIndices ( searchRequest . indices ( ) ) ;
---
Fixed code: String [ ] concreteIndices = clusterState . metaData ( ) . concreteIndices ( searchRequest . indices ( ) , false , true ) ;
Generation: String [ ] cmds = lines . split ( ! [ , ] . position ( ) ) ;
=============
=============
Buggy code: Session session = startClient ( startServer ( serverSessionFrameListener ) , clientSessionFrameListener ) ;
---
Fixed code: Session session = startClient ( startSPDYServer ( serverSessionFrameListener ) , clientSessionFrameListener ) ;
Generation: Session session = startClient ( startSPDYServer ( serverSessionFrameListener ) , clientSessionFrameListener ) ;
=============
=============
Buggy code: val = HiveMetaStore . PARTITION_DATE_FORMAT . format ( ( Date ) value ) ;
---
Fixed code: val = HiveMetaStore . PARTITION_DATE_FORMAT . get ( ) . format ( ( Date ) value ) ;
Generation: true . ] ( this , ( ) , false ) ;
=============
=============
Buggy code: locateToken ( ) ;
---
Fixed code: if ( myTokenType == null ) locateToken ( ) ;
Generation: if ( myTokenType == null ) locateToken ( ) ;
=============
=============
Buggy code: Processor childProcessor = routeContext . createProcessor ( this ) ;
---
Fixed code: Processor childProcessor = this . createChildProcessor ( routeContext , false ) ;
Generation: Processor childProcessor = this . createChildProcessor ( routeContext , false ) ;
=============
=============
Buggy code: IndexWriter writer = initIndex ( ) ;
---
Fixed code: IndexWriter writer = initIndex ( false ) ;
Generation: IndexWriter writer = initIndex ( false ) ;
=============
=============
Buggy code: this . cfg = cfg ;
---
Fixed code: this . cfg = new Configuration ( cfg ) ;
Generation: this . adapter = null ;
=============
=============
Buggy code: return analyzeExpr ( ( ExprNodeDesc ) nd , searchConditions , nodeOutputs ) ;
---
Fixed code: return analyzeExpr ( ( ExprNodeGenericFuncDesc ) nd , searchConditions , nodeOutputs ) ;
Generation: return new toString ( ( ( ) ) {
=============
=============
Buggy code: . prepareStatement ( "INSERT INTO `cloud`.`snapshot_store_ref` (store_id, snapshot_id, created, size, parent_snapshot_id, install_path, state) select sechost_id, id, created, size, prev_snap_id, path, 'Ready' from `cloud`.`snapshots` where status = 'BackedUp' and sechost_id is not null and removed is null" ) ;
---
Fixed code: . prepareStatement ( "INSERT INTO `cloud`.`snapshot_store_ref` (store_id, snapshot_id, created, size, parent_snapshot_id, install_path, volume_id, update_count, ref_cnt, store_role, state) select sechost_id, id, created, size, prev_snap_id, path, volume_id, 0, 0, 'Image', 'Ready' from `cloud`.`snapshots` where status = 'BackedUp' and sechost_id is not null and removed is null" ) ;
Generation: . release ( ) . perform ( ) ;
=============
=============
Buggy code: op . initialize ( null , null ) ;
---
Fixed code: op . initialize ( null , null , null ) ;
Generation: null , null , new HashSet < Integer > ( 0 ) ) ;
=============
=============
Buggy code: return new TermsQuery ( toField , termsCollector . getCollectorTerms ( ) ) ;
---
Fixed code: return new TermsQuery ( toField , fromQuery , termsCollector . getCollectorTerms ( ) ) ;
Generation: return new PublicIp ( cConf , , , new > ( ) ) ;
=============
=============
Buggy code: EditorActionUtil . cloneOrRemoveCaret ( editor , caret == null ? editor . getCaretModel ( ) . getPrimaryCaret ( ) : caret , true ) ;
---
Fixed code: new CloneCaretActionHandler ( true ) . execute ( editor , caret , dataContext ) ;
Generation: new CloneCaretActionHandler ( false ) . execute ( editor , caret , dataContext ) ;
=============
=============
Buggy code: result . bytes = MISSING ;
---
Fixed code: result . bytes = BytesRef . EMPTY_BYTES ;
Generation: result . bytes = BytesRef . EMPTY_BYTES ;
=============
=============
Buggy code: return listenerAddHandler . constructServiceName ( name ) ;
---
Fixed code: return UndertowService . listenerName ( name ) ;
Generation: return ( String ) Objects . convertValue ( name , value ) ;
=============
=============
Buggy code: elems . add ( l ) ;
---
Fixed code: elems . addRow ( l ) ;
Generation: ( ( List < OIdentifiable > ) tempResult ) . add ( false ) ;
=============
=============
Buggy code: long val = ( 1 << pos ) - 1 ;
---
Fixed code: long val = ( 1L << pos ) - 1 ;
Generation: long ret = ( ( long ) - 1 ) + 1 ;
=============
=============
Buggy code: return new HiveLockObject ( new DummyPartition (
---
Fixed code: return new HiveLockObject ( new DummyPartition ( tab ,
Generation: return new && ( new
=============
=============
Buggy code: Operation . DEFAULT_FETCH_MAX_ROWS , FetchType . QUERY_OUTPUT ) ;
---
Fixed code: defaultFetchRows , FetchType . QUERY_OUTPUT ) ;
Generation: , . > ( ) ;
=============
=============
Buggy code: double F = stats . getTotalTermFreq ( ) + tfn ;
---
Fixed code: double F = stats . getTotalTermFreq ( ) + 1 + tfn ;
Generation: double F = stats . getTotalTermFreq ( ) + 1 + tfn ;
=============
=============
Buggy code: reference = readSplitInfo ( p , fs ) ;
---
Fixed code: reference = HStoreFile . readSplitInfo ( p , fs ) ;
Generation: ; = "" ;
=============
=============
Buggy code: LOG . debug ( "Consumed {} on {}" , length , stream ) ;
---
Fixed code: LOG . debug ( "Data consumed, increasing window by {} for {}" , length , stream ) ;
Generation: LOG . debug ( , + length , . + ) ) ;
=============
=============
Buggy code: return new VersionManagerImpl ( ) ;
---
Fixed code: return new VersionManagerImpl ( sessionDelegate ) ;
Generation: return new PigTextInputFormat ( ) ;
=============
=============
Buggy code: return storageMgr . storagePoolHasEnoughSpace ( requestVolumes , pool ) ;
---
Fixed code: return storageMgr . storagePoolHasEnoughIops ( requestVolumes , pool ) && storageMgr . storagePoolHasEnoughSpace ( requestVolumes , pool ) ;
Generation: return new Long ( , , , conf ) ;
=============
=============
Buggy code: valString += ", partitionName.indexOf(\"/\", " + indexOfKeyStr + keyEqual . length ( ) + ")" ;
---
Fixed code: valString += ", partitionName.concat(\"/\").indexOf(\"/\", " + indexOfKeyStr + keyEqual . length ( ) + ")" ;
Generation: + rs . length ( ) + ")" ;
=============
=============
Buggy code: fileName . append ( componentPackage . replaceAll ( "\\." , File . separator ) ) . append ( File . separator ) ;
---
Fixed code: fileName . append ( componentPackage . replaceAll ( "\\." , Matcher . quoteReplacement ( File . separator ) ) ) . append ( File . separator ) ;
Generation: fileName . append ( outPackage . replaceAll ( "\\." , Matcher . quoteReplacement ( File . separator ) ) ) . append ( File . separator ) ;
=============
=============
Buggy code: from ( "direct:start" ) . to ( "direct:a" , "direct:b" , "direct:c" ) ;
---
Fixed code: from ( "direct:start" ) . to ( "log:a?level=OFF" , "log:b?level=OFF" , "direct:c" ) ;
Generation: from ( "direct:start" ) . multicast ( ) . to ( "seda:b" ,
=============
=============
Buggy code: if ( ResettableValue . class . isAssignableFrom ( type ) & CopyableValue . class . isAssignableFrom ( type ) ) {
---
Fixed code: if ( ResettableValue . class . isAssignableFrom ( type ) && CopyableValue . class . isAssignableFrom ( type ) ) {
Generation: if ( ( i ) || . class != null ) {
=============
=============
Buggy code: fileInputStreamCache = new FileInputStreamCache ( tempFile ) ;
---
Fixed code: fileInputStreamCache = new FileInputStreamCache ( tempFile , ciphers ) ;
Generation: fileInputStreamCache = new FileInputStreamCache ( tempFile , ciphers ) ;
=============
=============
Buggy code: returnVal = jobExecHelper . progress ( rj , jc ) ;
---
Fixed code: returnVal = jobExecHelper . progress ( rj , jc , null ) ;
Generation: returnVal = jobExecHelper . progress ( rj , jc , ctx . getHiveTxnManager ( ) ) ;
=============
=============
Buggy code: xml = replaceXmlValue ( xml , "descr" , "Edge Security Profile for Tenant VDC" + tenantName ) ;
---
Fixed code: xml = replaceXmlValue ( xml , "descr" , "Edge Security Profile for Tenant VDC " + tenantName ) ;
Generation: xml = replaceXmlValue ( xml , "descr" , "Edge Security Profile for Tenant VDC " + tenantName ) ;
=============
=============
Buggy code: UserVm destroyedVm = destroyVm ( vmId ) ;
---
Fixed code: UserVm destroyedVm = destroyVm ( vmId , expunge ) ;
Generation: ; =
=============
=============
Buggy code: ASTTransformationCollectorCodeVisitor annotCollector = new ASTTransformationCollectorCodeVisitor ( transformationVisitors ) ;
---
Fixed code: ASTTransformationCollectorCodeVisitor annotCollector = new ASTTransformationCollectorCodeVisitor ( transformationVisitors , unit ) ;
Generation: this = new ; . false ) ;
=============
=============
Buggy code: parser . processImplicitActions ( ) ;
---
Fixed code: parser . processTrailingImplicitActions ( ) ;
Generation: indexWriter . close ( ) ;
=============
=============
Buggy code: "/jobs/:%s/vertices/:%s/subtasks/:%s/attempts/%s/accumulators" ,
---
Fixed code: "/jobs/:%s/vertices/:%s/subtasks/:%s/attempts/:%s/accumulators" ,
Generation: 31 ,
=============
=============
Buggy code: assertEquals ( "Ensure message re-readability in the exception handler" , xml , new XmlConverter ( ) . toString ( body ) ) ;
---
Fixed code: assertEquals ( "Ensure message re-readability in the exception handler" , xml , new XmlConverter ( ) . toString ( body , null ) ) ;
Generation: assertEquals ( , , new String . ( ) ) ;
=============
=============
Buggy code: element = new CmsContainerElementBean ( OpenCms . getADEManager ( ) . convertToServerId ( id ) , null , null ) ;
---
Fixed code: element = new CmsContainerElementBean ( OpenCms . getADEManager ( ) . convertToServerId ( id ) , null , null , false ) ;
Generation: ( ) != null ? null : new float ( ( ) ) : "" , null , null , null ) ;
=============
=============
Buggy code: ReferenceOrderedDatum peeked = rodQueue . peek ( ) ;
---
Fixed code: RODRecordList < ReferenceOrderedDatum > peeked = rodQueue . peek ( ) ;
Generation: evolution = rp . + ( ) ;
=============
=============
Buggy code: Meta < LighterASTNode > meta = FilteredTraverser . < LighterASTNode > emptyMeta ( ) . withRoot ( lightTree . getRoot ( ) ) ;
---
Fixed code: Meta < LighterASTNode > meta = FilteredTraverser . < LighterASTNode > emptyMeta ( ) . withRoots ( Collections . singletonList ( lightTree . getRoot ( ) ) ) ;
Generation: . < < > > false = ( ( JavaSdkType ) loader ) . getSplitComparable ( pigSplit . getWrappedSplit ( ) ) ;
=============
=============
Buggy code: return dependency . getFrom ( ) . getId ( ) ;
---
Fixed code: return ( ModuleComponentIdentifier ) dependency . getFrom ( ) . getId ( ) ;
Generation: return ( ModuleComponentIdentifier ) dependency . getId ( ) . getId ( ) ;
=============
=============
Buggy code: myResult . put ( refName , NamedArgumentDescriptor . SIMPLE_ON_TOP ) ;
---
Fixed code: myResult . put ( refName , CODE_NAMED_ARGUMENTS_DESCR ) ;
Generation: add . put ( . class , . ( ) , . class ) ;
=============
=============
Buggy code: assert false : "byte streams for serialisation test are not equal" ;
---
Fixed code: throw new IllegalArgumentException ( "byte streams for serialisation test are not equal" ) ;
Generation: return false ;
=============
=============
Buggy code: HttpConfigurable . getInstance ( ) . setProxyCredentials ( provider ) ;
---
Fixed code: HttpConfigurable . getInstance ( ) . setProxyCredentialsIfEnabled ( provider , auth . getHost ( ) ) ;
Generation: . getInstance ( ) . == ? > ( . ( ) ) :
=============
=============
Buggy code: tasks . add ( new ExternalTaskPojo ( taskName , mySettings . getExternalProjectPath ( ) , null ) ) ;
---
Fixed code: tasks . add ( new ExternalTaskPojo ( taskName , mySettings . getExternalProjectPath ( ) , null , null ) ) ;
Generation: . add ( new StageMetrics ( to , . ( ) , null ) ) ;
=============
=============
Buggy code: if ( networkDomain != null ) {
---
Fixed code: if ( networkDomain != null && networkDomain . length ( ) > 0 ) {
Generation: if ( properties != null && tableDesc . getState ( ) != null ) {
=============
=============
Buggy code: existingServer + " looks stale" ) ;
---
Fixed code: existingServer + " looks stale, new server:" + serverName ) ;
Generation: + e . toString ( ) , e ) ;
=============
=============
Buggy code: String seg = fileName . substring ( 0 , fileName . indexOf ( '.' ) ) ;
---
Fixed code: String seg = IndexFileNames . parseSegmentName ( fileName ) ;
Generation: String null = configuration . substring ( 0 , Integer . class ) ;
=============
=============
Buggy code: pos += keylength + vlength ;
---
Fixed code: pos += vlength ;
Generation: directory . info = + ( ) + + + + + + + + + + + + + 1 ;
=============
=============
Buggy code: return this . masterMachineId ;
---
Fixed code: return new Machine ( masterMachineId , 0 , 1 , null ) ;
Generation: return this . configuration ;
=============
=============
Buggy code: return new HivePreparedStatement ( client , sessHandle , sql ) ;
---
Fixed code: return new HivePreparedStatement ( this , client , sessHandle , sql ) ;
Generation: return new HivePreparedStatement ( this , client , sessHandle , sql ) ;
=============
=============
Buggy code: EntityConditionList < T > ecl = EntityConditionList . entityConditionListFactory . object ( ) ;
---
Fixed code: EntityConditionList < T > ecl = cast ( EntityConditionList . entityConditionListFactory . object ( ) ) ;
Generation: EntityConditionList < T > ecl = cast ( EntityConditionList . entityConditionListFactory . object ( ) ) ;
=============
=============
Buggy code: HashMap < String , Operator < ? extends Serializable > > ao = new HashMap < String , Operator < ? extends Serializable > > ( ) ;
---
Fixed code: LinkedHashMap < String , Operator < ? extends Serializable > > ao = new LinkedHashMap < String , Operator < ? extends Serializable > > ( ) ;
Generation: LinkedHashMap < String , Operator < ? extends Serializable > > aliasToWork = new LinkedHashMap < String , Operator < ? extends Serializable > > ( ) ;
=============
=============
Buggy code: . setTimeToLive ( in . timeToLive )
---
Fixed code: . setTimeToLive ( in . timeToLive > 0 ? in . timeToLive : Integer . MAX_VALUE )
Generation: . write ( new File ( in ) )
=============
=============
Buggy code: IndexReader reader = writer . getReader ( ) ;
---
Fixed code: IndexReader reader = writer . getReader ( applyAllDeletes ) ;
Generation: IndexReader reader = IndexReader . open ( writer ) ;
=============
=============
Buggy code: } else if ( propertyName . equals ( HiveConf . ConfVars . HADOOPFS . varname ) ) {
---
Fixed code: } else if ( propertyName . equals ( CommonConfigurationKeysPublic . FS_DEFAULT_NAME_KEY ) ) {
Generation: } else if ( ! StringUtils . . ( ) . equals ( "tez" ) ) {
=============
=============
Buggy code: prefix = CompilerRunnerConstants . INTERNAL_ERROR_PREFIX ;
---
Fixed code: prefix = INTERNAL_ERROR_PREFIX ;
Generation: config . = ( ) . null ? false : 1 + true ;
=============
=============
Buggy code: HBaseTestingUtility util = context . getHaseIntegrationTestingUtility ( ) ;
---
Fixed code: HBaseTestingUtility util = context . getHBaseIntegrationTestingUtility ( ) ;
Generation: HBaseTestingUtility util = context . getHBaseIntegrationTestingUtility ( ) ;
=============
=============
Buggy code: addCommandLineOptions ( commandLine , chunk , outputPath , compilerSettings , useTempFile ) ;
---
Fixed code: addCommandLineOptions ( commandLine , chunk , outputPath , compilerSettings , useTempFile , true ) ;
Generation: setProperty ( camelContext , new , , , , , ,
=============
=============
Buggy code: public ClientResponse < Project > get ( ) ;
---
Fixed code: public ClientResponse < ProjectRes > get ( ) ;
Generation: public < Long > get ( ) , new ArrayList < > ( ) ) ;
=============
=============
Buggy code: SelectMode m = ModeFactory . getMode ( "ssm_queries" , "find_all_operations" ) ;
---
Fixed code: SelectMode m = ModeFactory . getMode ( "ssm_operation_queries" , "find_all_operations" ) ;
Generation: , false = new Arrays ( , , false ) ;
=============
=============
Buggy code: SessionState . start ( ss ) ;
---
Fixed code: SessionState . setCurrentSessionState ( ss ) ;
Generation: assert == ? . : || . class , e . ) .
=============
=============
Buggy code: ModuleComponentIdentifier id = ( ModuleComponentIdentifier ) module . getPublishedAs ( ) ;
---
Fixed code: ModuleComponentIdentifier id = getId ( ) ;
Generation: = ( id ) module . . ( ) ;
=============
=============
Buggy code: if ( HiveConf . getBoolVar ( conf , HiveConf . ConfVars . HIVE_OPTIMIZE_TEZ )
---
Fixed code: if ( HiveConf . getVar ( conf , HiveConf . ConfVars . HIVE_EXECUTION_ENGINE ) . equals ( "tez" )
Generation: if ( HiveConf . getVar ( conf , HiveConf . ConfVars . HIVE_EXECUTION_ENGINE ) . equals ( "tez" ) )
=============
=============
Buggy code: log . info ( "Submitting job {}." , jobGraph . getJobID ( ) ) ;
---
Fixed code: log . info ( "Submitting job {} (detached: {})." , jobGraph . getJobID ( ) , isDetached ( ) ) ;
Generation: log . info ( info , ;
=============
=============
Buggy code: Hive . reloadFunctions ( ) ;
---
Fixed code: Hive . get ( ) . reloadFunctions ( ) ;
Generation: if ( ! this . ) . isEmpty ( ) ) ;
=============
=============
Buggy code: return myUi . getMainFrame ( ) . getMainComponent ( ) ;
---
Fixed code: return new VcsLogPanel ( this , myUi ) ;
Generation: return ( int ) ( == null ? Collections . unmodifiableSet ( ) : null ) ;
=============
=============
Buggy code: if ( ( currOp . getChildOperators ( ) == null ) ||
---
Fixed code: if ( ( currOp . getChildOperators ( ) == null ) || ( currOp . getChildOperators ( ) . isEmpty ( ) ) ||
Generation: if ( ( currOp . new ( ) == null ) || ( currOp . new class > ( ( ( ) ) ) . isEmpty ( ) ) ;
=============
=============
Buggy code: throw new SQLException ( "Method not supported" ) ;
---
Fixed code: return true ;
Generation: throw new SQLFeatureNotSupportedException ( "Method not supported" ) ;
=============
=============
Buggy code: return getReferenceNodeMethod . execute ( ) ;
---
Fixed code: return localGraph . getRelationshipById ( id ) ;
Generation: return new Vector ( ( ) . get ( ) , null ) ;
=============
=============
Buggy code: EMPTY_START_ROW , System . currentTimeMillis ( ) , null ) ;
---
Fixed code: EMPTY_START_ROW , HConstants . LATEST_TIMESTAMP , null ) ;
Generation: EMPTY_START_ROW , HConstants . LATEST_TIMESTAMP , null ) ;
=============
=============
Buggy code: KernelServices servicesA = super . installInController ( subsystemXml ) ;
---
Fixed code: KernelServices servicesA = createKernelServicesBuilder ( null ) . setSubsystemXml ( subsystemXml ) . build ( ) ;
Generation: KernelServices servicesA = createKernelServicesBuilder ( null ) . setSubsystemXml ( subsystemXml ) . build ( ) ;
=============
=============
Buggy code: return Integer . valueOf ( value ) ;
---
Fixed code: return Integer . valueOf ( value ) . intValue ( ) ;
Generation: return Boolean . valueOf ( value ) . booleanValue ( ) ;
=============
=============
Buggy code: "org.apache.parquet.hadoop.ParquetInputFormat,org.apache.hadoop.hive.ql.io.parquet.MapredParquetInputFormat" ,
---
Fixed code: "org.apache.parquet.hadoop.ParquetInputFormat,org.apache.hadoop.hive.ql.io.parquet.MapredParquetInputFormat,org.apache.hive.storage.jdbc.JdbcInputFormat" ,
Generation: 31 ,
=============
=============
Buggy code: setTaskPlan ( currAliasId , currTopOp , plan , false , opProcCtx ) ;
---
Fixed code: setTaskPlan ( currAliasId , currTopOp , op , plan , false , opProcCtx ) ;
Generation: addDelegateInstanceMethods ( , , , , false , false , null , false ) ;
=============
=============
