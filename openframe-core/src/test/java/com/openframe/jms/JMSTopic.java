package com.openframe.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

public class JMSTopic {

	/**
	 * @param args
	 * @throws JMSException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws JMSException, InterruptedException {
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		ActiveMQTopic topic = new ActiveMQTopic("testTopic");
		
		MessageConsumer consumer1 = session.createConsumer(topic);
		//注册监听器，通过回调
		consumer1.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				TextMessage textMsg = (TextMessage) message;    
                try  {    
                   System.out.println("consumer1 recevie message "+textMsg.getText());    
               }  catch  (JMSException e) {    
                   e.printStackTrace();    
               }    
				
			}
		});
		
		
		MessageConsumer consumer2 = session.createConsumer(topic);
		//注册监听器，通过回调
		consumer2.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				TextMessage textMsg = (TextMessage) message;    
                try  {    
                   System.out.println("consumer2 recevie message "+textMsg.getText());    
               }  catch  (JMSException e) {    
                   e.printStackTrace();    
               }    
				
			}
		});
		
		
		//一直阻塞，等待消息接受
//		Message receiveMsg = consumer.receive();
//		System.out.println(((TextMessage) receiveMsg).getText());
		
		
		System.out.println("receive finish");
		
		
//		Thread.sleep(10000);//为了测试，暂时不关闭，方便异步接受消息
//		//关闭连接
//		if(consumer1!=null){
//			consumer1.close();
//		}
//		if  (session !=  null )          
//			session.close();          
//		if  (connection !=  null )          
//			connection.close(); 
		
	}

}
