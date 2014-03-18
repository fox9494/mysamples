package com.openframe.jms;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.openframe.webservice.TestEntity;

/**
 * jms消息消费者
 * @author Administrator
 *
 */
public class ConSumerMessageListener implements MessageListener {

	/*@Override
	public void onMessage(Message message) {
		
		//这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换  
        TextMessage textMsg = (TextMessage) message;  
        System.out.println("接收到一个纯文本消息。");  
        try {  
            System.out.println("消息内容是：" + textMsg.getText());  
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  

	}*/
	
	/**
	 * 处理对象消息
	 */
	@Override
	public void onMessage(Message message) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式
		String start = df.format(new Date());
		
		//这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换  
		ObjectMessage msg = (ObjectMessage) message;  
        System.out.println("接收到一个对象消息。");  
        try {  
        	TestEntity obj = (TestEntity) msg.getObject();
            System.out.println("消息内容是：" +obj.toString());  
        } catch (JMSException e) {  
            e.printStackTrace();  
        }  
        
        System.out.println("start time:"+start);
		System.out.println("end time:"+df.format(new Date()));

	}

}
