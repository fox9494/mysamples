package com.openframe.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class JMSReceiverQueen {
	

	
	public static void main(String[] args) throws JMSException, InterruptedException {
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = new ActiveMQQueue("testQueue");
		
		MessageConsumer consumer = session.createConsumer(queue);
		
		//过滤消息，只接受包含receive = A的消息
//		MessageConsumer consumer = session.createConsumer(queue, "receive = A");
		
		//注册监听器，通过回调
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				TextMessage textMsg = (TextMessage) message;    
                try  {    
                   System.out.println("consumer recevie message "+textMsg.getText()); 
                   MessageProducer producer = session.createProducer(message.getJMSReplyTo());//回复消息
                   producer.send(session.createTextMessage("ReplyMessage"));
               }  catch  (JMSException e) {    
                   e.printStackTrace();    
               }    
				
			}
		});
		
		
		//一直阻塞，等待消息接受
//		Message receiveMsg = consumer.receive();
//		System.out.println(((TextMessage) receiveMsg).getText());
		
		
		System.out.println("receive finish");
		
		
		Thread.sleep(10000);//为了测试，暂时不关闭，方便异步接受消息
		//关闭连接
//		if(consumer!=null){
//			consumer.close();
//		}
//		if  (session !=  null )          
//			session.close();          
//		if  (connection !=  null )          
//			connection.close(); 
		
	}



}
