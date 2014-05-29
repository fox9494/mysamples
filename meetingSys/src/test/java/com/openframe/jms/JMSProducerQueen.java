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
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class JMSProducerQueen {
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = new ActiveMQQueue("testQueue");
		
		MessageProducer producer = session.createProducer(queue);
		TemporaryQueue replyQueen = session.createTemporaryQueue();//设置临时队列，用来回复消息
//		session.createQueue("");
		
		for (int i = 0; i < 10; i++) {
			TextMessage message = session.createTextMessage("Message:this is number "+i);
			message.setJMSReplyTo(replyQueen);//设置消息回复队列
			producer.send(message);
		}
		
		System.out.println("send finish");
		
		//读取回复消息
		MessageConsumer consumer = session.createConsumer(replyQueen);
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				 try {
					System.out.println( "Get reply: "  + ((TextMessage) message).getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}   
			}
		});
		
		//关闭连接
		if(producer!=null){
			producer.close();
		}
		//关闭后临时回复队列则消失
//		if  (session !=  null )          
//			session.close();          
//		if  (connection !=  null )          
//			connection.close(); 
		
	}

}
