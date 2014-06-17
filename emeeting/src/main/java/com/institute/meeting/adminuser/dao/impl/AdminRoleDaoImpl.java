package com.institute.meeting.adminuser.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.institute.meeting.adminuser.dao.AdminRoleDao;
import com.institute.meeting.adminuser.entity.TAdminRole;
import com.institute.meeting.common.dao.impl.BaseDaoImpl;
import com.institute.meeting.utils.PageBean;

public class AdminRoleDaoImpl extends BaseDaoImpl implements AdminRoleDao {
	
	
	
	public PageBean queryListPage(int pageSize, Integer currentPage, TAdminRole role){
		Criteria crit=this.getSession().createCriteria(TAdminRole.class).addOrder(Order.desc("createDate"));
		if(role != null) {
			if (StringUtils.isNotBlank(role.getRoleName())){
				crit.add(Restrictions.eq("roleName", role.getRoleName()));
			}
		}
		return this.queryForPageByParams(pageSize, currentPage, crit);
	
		
	}

}
