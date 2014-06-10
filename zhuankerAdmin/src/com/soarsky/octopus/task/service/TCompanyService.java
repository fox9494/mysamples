package com.soarsky.octopus.task.service;

import java.util.List;

import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.utils.PageBean;

public interface TCompanyService {
	
	   /**
	    * 添加客户信息
	    * @param company 客户对象
	   */
	   public void addUserClient(TCompany company);
	   
	   /**
	    * 分页查询所有客户信息
	    * @param maxresult 每页最大条数
	    * @param currentPage 当前页数
	    * @param company 客户对象
	    * @return
	   */
	   public PageBean queryPageList(int maxresult,int currentPage,TCompany company);

	   /**
	    * 根据ID查询客户对象
	    * @param company 客户对象
	    * @return
	   */
	   public TCompany findUserById(TCompany company);
       
	   /**
	    * 修改客户对象
	    * @param company 客户对象
	   */
	   public void updateUser(TCompany company);
       
	   /**
	    * 删除客户对象
	    * @param info 客户对象
	   */
	   public void deleteUser(String info);

	   /**
	    * 根据客户名和行业分页查询所有客户信息
	    * @param maxresult 每页最大条数
	    * @param currentPage 当前页数
	    * @param company 客户对象
	    * @return
	   */
	   public PageBean queryByNameOrProfession(int maxresult, int currentPage,TCompany company);
	   
	   /**
	    * 查询所有客户对象
	    * @return
	   */
	   public List<TCompany>findAllCompany();
	   
	   /**
	    * 根据客户名称查找客户对象
	    * @param company 客户对象
	    * @return
	   */
	   public Boolean findCompanyByName(TCompany company);
}
