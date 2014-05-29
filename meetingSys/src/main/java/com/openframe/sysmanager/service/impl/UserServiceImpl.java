package com.openframe.sysmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.openframe.common.page.PageBean;
import com.openframe.sysmanager.dao.UserDAO;
import com.openframe.sysmanager.domain.User;
import com.openframe.sysmanager.service.UserService;
import com.openframe.utils.BeanHolder;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO; 
	
//	@Transactional
//	public void addUsers(List<User> list){
//		userDAO.batchInsert(list);
//	}
	
	
	@Transactional
	public void add(User user){
		userDAO.insert(user);
		System.out.println("the id is "+user.getUserId());
	}
	
	/**
	 * 使用编程式事务操作mybatis批量提交
	 * @param user
	 */
	public void addUsers(List<User> list){
		DataSourceTransactionManager tx = (DataSourceTransactionManager) BeanHolder.getBean("transactionManager");
		DefaultTransactionDefinition def  = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = tx.getTransaction(def);
		try {
			
			List<User> newlist = new ArrayList<User>();
			for (int i = 0; i < list.size(); i++) {
				newlist.add(list.get(i));
				if (newlist.size()==20){//20条记录提交一次
					userDAO.batchInsert(newlist);
					for (User user : newlist) {
						System.out.println("id is "+user.getUserId());
					}
					tx.commit(status);
					newlist.clear();
				}
				
				if (newlist.size()<20 && i==(list.size()-1)){//最后不足20条记录则一次提交
					userDAO.batchInsert(newlist);
					tx.commit(status);
				}
			}
		} catch (Exception e) {
			tx.rollback(status);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 分页查询
	 * @param pageObj
	 * @return
	 */
	public PageBean queryPageUser(PageBean pageObj){
		return userDAO.queryPage(pageObj);
	}
	
	
	public User queryOne(String userId){
		return (User) userDAO.selectById(userId);
	}
}
