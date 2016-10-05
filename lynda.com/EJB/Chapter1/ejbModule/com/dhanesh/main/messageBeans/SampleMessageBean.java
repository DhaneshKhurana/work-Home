package com.dhanesh.main.messageBeans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: SampleMessageBean
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		})
public class SampleMessageBean implements MessageListener {

    /**
     * Default constructor. 
     */
    public SampleMessageBean() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        
    }
    
    public void setMessageDrivenContext(MessageDrivenContext mdc){
    	
    }
    
    public void ejbCreate(){};
    
    public void ejbDestroy(){};

}
