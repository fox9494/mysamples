package com.openframe.sysmanager.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.openframe.webservice.HelloWorldClient;

/**
 * 集成测试代码
 * @author chenlile
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/business-config.xml","classpath:/spring/webservice-config.xml"})
@Transactional//执行完数据库的操作会自动回滚
public class WebServiceTest {
	
	@Autowired
	@Qualifier("webserviceClient")
	private HelloWorldClient client;

	@Test
	public void printHelloTest() {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");//设置日期格式
		String start = df.format(new Date());
		
		for (int i = 0; i < 10000; i++) {
			System.out.println(client.printHello());
		}
		
		System.out.println("start time:"+start);
		System.out.println("end time:"+df.format(new Date()));
	}

}
