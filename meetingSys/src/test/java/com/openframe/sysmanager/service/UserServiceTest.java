package com.openframe.sysmanager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.openframe.sysmanager.domain.User;

/**
 * 集成测试代码
 * @author chenlile
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/business-config.xml"})
@Transactional
public class UserServiceTest {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Test
	public void userServiceTest() {
		List<User> list = new ArrayList<User>();  
		User user = new User();
		user.setRealName("dd");
		user.setUserName("admin");
		user.setPassword("11");
		user.setLastLogindate(new Date());
		list.add(user);
		
		User user1 = new User();
		user1.setRealName("wg");
		user1.setPassword("11");
		user1.setUserName("chenlile");
		user1.setLastLogindate(new Date());
		list.add(user1);
		userService.addUsers(list);
	}

}
