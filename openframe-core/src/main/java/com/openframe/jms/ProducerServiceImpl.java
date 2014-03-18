package com.openframe.jms;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.openframe.webservice.TestEntity;

/**
 * Jms消息发送者
 * @author Administrator
 *
 */

@Component("producerService")
public class ProducerServiceImpl implements ProducerService {
	
	private JmsTemplate jmsTemplate; 

	
	/**
	 * 发送简单的文本消息
	 */
	/*@Override
	public void sendMessage(Destination destination, final String message) {
		System.out.println("---------------生产者发送消息-----------------");  
        System.out.println("---------------生产者发了一个消息：" + message);  
        
        jmsTemplate.send(destination, new MessageCreator() {  
            public Message createMessage(Session session) throws JMSException {  
                return session.createTextMessage(message);  
            }  
        });  
	}*/
	
	/**
	 * 发送对象消息
	 */
	@Override
	public void sendMessage(Destination destination, final TestEntity message) {
		System.out.println("---------------生产者发送消息-----------------");  
        System.out.println("---------------生产者发了一个对象消息：" + message.toString());  
        
        jmsTemplate.send(destination, new MessageCreator() {  
            public Message createMessage(Session session) throws JMSException {  
                return session.createObjectMessage(message);  
            }  
        });  
	}
	
	

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	@Resource
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	
	
	
	

}
