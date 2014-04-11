package com.openframe.sysmanager.service;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.openframe.jms.ProducerService;
import com.openframe.webservice.TestEntity;

/**
 * 集成测试代码
 * 模拟生产者发送消息
 * @author chenlile
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/business-config.xml"})
@Transactional//执行完数据库的操作会自动回滚
public class JMSProducerTest {
	
	
	@Autowired  
    @Qualifier("queueDestination")  
    private Destination destination;  
      
    @Autowired  
    @Qualifier("producerService")
    private ProducerService producerService;  
      
    @Test
    public void sendTest() throws InterruptedException {  
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式
		String start = df.format(new Date());
    	for (int i = 0; i < 3; i++) {
    		Thread.sleep(10000);
    		producerService.sendMessage(destination, new TestEntity("joy",i));  
		}
    	System.out.println("start time:"+start);
		System.out.println("end time:"+df.format(new Date()));
    }  
	
	

}
