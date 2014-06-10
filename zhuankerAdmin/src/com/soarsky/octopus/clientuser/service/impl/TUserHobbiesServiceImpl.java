package com.soarsky.octopus.clientuser.service.impl;

import java.util.List;

import com.soarsky.octopus.clientuser.dao.TUserHobbiesDAO;
import com.soarsky.octopus.clientuser.service.TUserHobbiesService;
import com.soarsky.octopus.mapping.THobbies;

public class TUserHobbiesServiceImpl implements TUserHobbiesService {

	private TUserHobbiesDAO tUserHobbiesDAO;

	/**
	 * 根据用户id得到爱好
	 * 
	 * @author yl
	 */
	public List<THobbies> findHobbiesByUserId(long userId) {

		return tUserHobbiesDAO.findHobbiesByUserId(userId);
	}

	public TUserHobbiesDAO gettUserHobbiesDAO() {
		return tUserHobbiesDAO;
	}

	public void settUserHobbiesDAO(TUserHobbiesDAO tUserHobbiesDAO) {
		this.tUserHobbiesDAO = tUserHobbiesDAO;
	}

}
