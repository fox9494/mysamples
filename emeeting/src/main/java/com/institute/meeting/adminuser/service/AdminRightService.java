package com.institute.meeting.adminuser.service;

import java.util.List;

import com.institute.meeting.adminuser.entity.TAdminRight;

public interface AdminRightService {
	
	public void updateRight(Integer roleId,List<TAdminRight> list);

}
