package com.soarsky.octopus.clientuser.service;

import java.util.List;

import com.soarsky.octopus.mapping.THobbies;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.mapping.TUserLevel;
import com.soarsky.octopus.utils.PageBean;

public interface TUserClientService {
	
  public PageBean getUserClientList(int maxresult,int currentpage);

  public PageBean getUserClientByConditions(int dEFAULTPAGESIZE,Integer currentPage, TUserClient userclient,List<THobbies> hobbies,Integer startAge,Integer endAge);

  public TUserClient  initUserClient(TUserClient  userclient);
  
  public String getAllUserLevel(Long total);
}
