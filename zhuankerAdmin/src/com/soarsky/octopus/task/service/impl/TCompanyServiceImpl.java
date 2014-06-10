package com.soarsky.octopus.task.service.impl;

import java.util.List;

import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.task.dao.TCompanyDAO;
import com.soarsky.octopus.task.service.TCompanyService;
import com.soarsky.octopus.utils.PageBean;

public class TCompanyServiceImpl implements TCompanyService {
	
	private TCompanyDAO tCompanyDAO;
	/** 
     * 添加客户
     * @author lw
     * @param company 客户对象
     *
	*/
	public void addUserClient(TCompany company) {
		
		tCompanyDAO.save(company);
	}
	
     /**
      * 分页查询所有客户 
	  * @author lw
	  * @param maxsize 每页条数
	  * @param currentPage 当前页数
	  * @param company 要得到的对象
	  * @return 
	 */
	public PageBean queryPageList(int maxresult, int currentPage,TCompany company) {
		
		return tCompanyDAO.queryUserClientForPage(maxresult,currentPage,company);
	}
    
	/**
	 * 根据客户名和职业进行模糊查询
	 * @author lw
	 * @param maxsize 每页条数
	 * @param currentPage 当前页数
	 * @param company 要得到的对象
	 * @return
	*/
	public PageBean queryByNameOrProfession(int maxresult, int currentPage,TCompany company) {
		
		return tCompanyDAO.queryUserByNameOrProfession(maxresult,currentPage,company);
	}

	/**
	 * 根据客户ID查询客户
	 * @author lw
	 * @param  company 客户对象
	 * @return
	*/
    public TCompany findUserById(TCompany company){
    	
    	return tCompanyDAO.getById(TCompany.class,company.getId());
    }
    
    /**
	 * 修改客户
	 * @author lw
	 * @param  company 客户对象
	 * 
	*/
	public void updateUser(TCompany company) {
		
		tCompanyDAO.updateCompany(company);
	}
    
	/**
	 * 删除客户
	 * @author lw
	 * @param  company 客户对象
	*/
	public void deleteUser(String info) {
			
		tCompanyDAO.deleteUser(info);
	}
    
	/**
	 *查询所有客户 
	 *@author lw
	 *@return
	 */
	public List<TCompany> findAllCompany() {
		
		return tCompanyDAO.queryAllCompany();
	}
    
	 /**
	  * 根据客户名称查找客户对象
	  * @author lw
	  * @param company 客户对象
	  * @return
	  */
	public Boolean findCompanyByName(TCompany company) {
		
		return tCompanyDAO.findCompanyByName(company);
	}

	public TCompanyDAO gettCompanyDAO() {
		return tCompanyDAO;
	}

	public void settCompanyDAO(TCompanyDAO tCompanyDAO) {
		this.tCompanyDAO = tCompanyDAO;
	}
    
	
}
