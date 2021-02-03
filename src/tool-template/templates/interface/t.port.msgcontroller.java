package ${pkg};

import payrolldeployment.${comp};

import io.ciera.runtime.summit.application.IApplication;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.application.tasks.GenericExecutionTask;
import io.ciera.runtime.summit.application.tasks.HaltExecutionTask;
import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.components.Component;
import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.Message;
import io.ciera.runtime.summit.util.LOG;
import io.ciera.runtime.summit.util.impl.LOGImpl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Properties;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

//The Spring framework arranges for an instance of this class to be
//created, passing an instance of SimpMessagingTemplate as an argument,
//which enables messages to be sent to, and received from, JavaScript clients.

@Controller
public class ${self.name}MsgController {
    private static ${self.name}MsgController singleton;
	
    private SimpMessagingTemplate template;  
	
	@Autowired
    public ${self.name}MsgController( SimpMessagingTemplate template ) {
       singleton = this;
       this.template = template;
	}
	
    public static ${self.name}MsgController Singleton() {
        return singleton;
	}
// inbound
${fromnet_message_block}
	
// outbound
${tonet_message_block}

}
