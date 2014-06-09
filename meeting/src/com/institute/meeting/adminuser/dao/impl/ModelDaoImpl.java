package com.institute.meeting.adminuser.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.institute.meeting.adminuser.dao.ModelDao;
import com.institute.meeting.adminuser.entity.TModel;
import com.institute.meeting.common.dao.impl.BaseDaoImpl;
import com.institute.meeting.enums.EnumConstant;


public class ModelDaoImpl extends BaseDaoImpl implements ModelDao {
	
	
	/**
	 * 查询所有导航菜单
	 * @return
	 */
	public List<TModel>  queryAllMenu(){
		return this.getSession().createCriteria(TModel.class).add(Restrictions.eq("type", EnumConstant.MENU.getCode())).add(Restrictions.isNull("parent")).list();
	}

}
 