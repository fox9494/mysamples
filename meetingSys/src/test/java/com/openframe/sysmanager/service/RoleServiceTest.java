package com.openframe.sysmanager.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.openframe.sysmanager.dao.RoleDAO;
import com.openframe.sysmanager.domain.Role;
import com.openframe.sysmanager.service.impl.RoleServiceImpl;

//可以使用JMock来模拟被调对象
public class RoleServiceTest {

	private RoleService roleService;
	private final Mockery context = new Mockery() {
		{
			// 1.1、表示可以支持Mock非接口类，默认只支持Mock接口
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};

	private RoleDAO roleDAO = context.mock(RoleDAO.class);

	@Before
	public void setUp() {
		roleService = new RoleServiceImpl();
		ReflectionTestUtils.setField(roleService, "roleDAO", roleDAO);
	}

	@Test
	public void roleServiceTest() {
		final Role role = new Role();
		role.setRoleName("admin-admin");
		role.setCreateDate(new Date());
		context.checking(new org.jmock.Expectations() {
			{
				// 5、表示需要调用roleDAO对象的insert一次
				// 且返回值为1
				oneOf(roleDAO).insert(role);
				will(returnValue(1));
			}
		});

		roleService.save(role);
		context.assertIsSatisfied();
		
		System.out.println("role");
	}
	
	@Test
	public void countTest() {
		final Role role = new Role();
		role.setRoleName("admin-admin");
		role.setCreateDate(new Date());
		
		
		context.checking(new org.jmock.Expectations() {
			{
				// 5、表示需要调用roleDAO对象的select一次
				// 且返回值为1
				
				List list = new ArrayList();
				list.add("1");
				list.add("2");
				oneOf(roleDAO).selectAll();
				will(returnValue(list));
			}
		});

		int num = roleService.count(5);
		context.assertIsSatisfied();
		System.out.println(num);
		assertEquals(1, num);
	}

}
