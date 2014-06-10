package com.soarsky.octopus.clientuser.service;

import java.util.List;

import com.soarsky.octopus.mapping.THobbies;

public interface TUserHobbiesService {
	/**
	 * 根据用户id查询爱好
	 * @param userId
	 * @return
	 */
	public List<THobbies> findHobbiesByUserId(long userId);

}
