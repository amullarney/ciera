.if ( inbound )
    @MessageMapping( "/${mname}" )
    public void ${mname}( ${mname}Msg message ) throws Exception {
        try {
            ${comp}.Singleton().${port}().${mname}( ${parmlist} );
        }
        catch ( Exception e ) {
            System.out.printf( "Exception, %s, in ${mname}()\n", e );
        }
    }

.else
    public void Send${mname}Msg( ${parmlist} ) throws Exception {
        ${mname}Msg msg = new ${mname}Msg();
        msg.setMessageName( "${mname}");
${msg_sets}\
        String topic = "/topic/${comp}/";
        this.template.convertAndSend( topic, msg );
    }
    
.end if
