.if ( inbound )
    @MessageMapping( "/${mname}" )
    public void ${mname}( ${mname}Msg message ) throws Exception {
    	try {
    		${comp}.Singleton().${port}().${mname}();
    	}
        catch ( Exception e ) {
        	System.out.printf( "Exception, %s, in ${mname}()\n", e );
        }
    }
.else
    public void Send${mname}Msg() throws Exception {
    	${mname}Msg msg = new ${mname}Msg();
    	String topic = "/topic/${comp}/";
    	this.template.convertAndSend( topic, msg );
    }
.end if