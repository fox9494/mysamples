package com.institute.meeting.adminuser.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.institute.meeting.adminuser.dao.AdminUserDao;
import com.institute.meeting.adminuser.entity.TAdminusers;
import com.institute.meeting.common.dao.impl.BaseDaoImpl;
import com.institute.meeting.utils.PageBean;

public class AdminUserDaoImpl extends BaseDaoImpl implements AdminUserDao{
	
	
	
	@SuppressWarnings("unchecked")
	public TAdminusers findByNamePass(String userAccount,String password){
		List<TAdminusers> list=new ArrayList<TAdminusers>();
		Map<String,Object> params=new HashMap<String,Object>();
		String sql="";
		sql="SELECT * FROM t_adminusers WHERE UserAccount COLLATE utf8_bin =:userAccount and UserPassword COLLATE utf8_bin =:password";
		params.put("userAccount", userAccount);
		params.put("password", password);
		list=this.queryBySql(sql, params, TAdminusers.class);	
		if (list!=null && !list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	
	/**
	 * 分页查询后台用户
	 * @param pageSize  
	 * @param curPage  当前页码数
	 * @return
	 */
	public PageBean queryPageList(int pageSize,int curPage){
		return this.queryForPageByParams(pageSize, curPage, this.getSession().createCriteria(TAdminusers.class));
	}


	/**
	 * 删除用户
	 * 
	 */
	public void deleteAdminUser(int userId) {
		this.delete(this.getSession().get(TAdminusers.class, userId));
		
	}

	/**
	 * 根据用户名查找用户
	 * @param userAccount
	 * @return
	*/
	public boolean findByName(String userAccount) {
		Map<String,Object> params=new HashMap<String,Object>();
		String sql="";
		sql="SELECT * FROM t_adminusers WHERE UserAccount COLLATE utf8_bin =:userAccount";
		params.put("userAccount", userAccount);
		//Criteria crit=this.getSession().createCriteria(TAdminusers.class).add(Restrictions.eq("userAccount",userAccount));
		//List users=crit.list();
		List users=this.queryBySql(sql, params, TAdminusers.class);
		if(users.size()>0){
			return true;
		}else{
		return false;
		}
	}
	

}
