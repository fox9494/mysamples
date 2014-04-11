package com.openframe.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class JMSProducer {
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = new ActiveMQQueue("testQueue");
		
		MessageProducer producer = session.createProducer(queue);
//		session.createQueue("");
		
		for (int i = 0; i < 10; i++) {
			producer.send(session.createTextMessage("Message:this is number "+i));
		}
		
		System.out.println("send finish");
		
		//关闭连接
		if(producer!=null){
			producer.close();
		}
		if  (session !=  null )          
			session.close();          
		if  (connection !=  null )          
			connection.close(); 
		
	}

}
