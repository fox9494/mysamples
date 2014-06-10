package com.soarsky.octopus.clientuser.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.mapping.TUserHobbies;

public class TUserHobbiesDAO extends BaseDAO {

	public List<THobbies> findHobbiesByUserId(long userId) {
		Criteria crit = this.getSession().createCriteria(TUserHobbies.class);
		if (!"".equals(userId)) {
			crit.createCriteria("TUserClient").add(
					Restrictions.eq("id", userId));
		}
		List<THobbies> hobbiesList =(List<THobbies>) crit.list();
		
		
		return hobbiesList;

	}
}