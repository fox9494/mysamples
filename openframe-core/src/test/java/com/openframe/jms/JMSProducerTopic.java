package com.openframe.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

public class JMSProducerTopic {
	
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = factory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		ActiveMQTopic topic = new ActiveMQTopic("testTopic");
		
		MessageProducer producer = session.createProducer(topic);
		
		//topic消息默认是非持久化的,设置持久化能发送离线消息
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		
		connection.start();//所有设置完成，开始连接
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
