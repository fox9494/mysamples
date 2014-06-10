package com.soarsky.octopus.task.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.channel.constant.ChannelContent;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.task.constant.TaskContent;
import com.soarsky.octopus.utils.PageBean;


public class TCompanyDAO extends BaseDAO  {
	
	/**
     * 分页查询所有客户 
	  * @author lw
	  * @param maxsize 每页条数
	  * @param currentPage 当前页数
	  * @param company 要得到的对象
	  * @return 
	 */
	public PageBean queryUserClientForPage(int maxresult, int currentPage,TCompany company) {
		
		Criteria crit=this.getSession().createCriteria(TCompany.class).add(Restrictions.eq("isRemove",TaskContent.NOTROMOVE)).addOrder(Order.desc("createDate"));
		
		return this.queryForPageByParams(maxresult, currentPage, crit);
	}
	
	/**
	 * 根据客户名和职业进行模糊查询
	 * @author lw
	 * @param maxsize 每页条数
	 * @param currentPage 当前页数
	 * @param company 要得到的对象
	 * @return
	*/
	public PageBean queryUserByNameOrProfession(int maxresult, int currentPage,TCompany company) {
		
		Criteria crit=this.getSession().createCriteria(TCompany.class).add(Restrictions.eq("isRemove", TaskContent.NOTROMOVE)).addOrder(Order.desc("createDate"));
	 
		if(StringUtils.isNotEmpty(company.getName())){
			
			crit.add(Restrictions.like("name","%"+company.getName()+"%"));
			
		}
		if(StringUtils.isNotEmpty(company.getChannelIndustry().getName())){
			
			crit.createCriteria("channelIndustry").add(Restrictions.eq("name",company.getChannelIndustry().getName()));
		   
		}
		
			
			return this.queryForPageByParams(maxresult, currentPage, crit);
	}
	
	/**
	 *查询所有客户 
	 *@author lw
	 *@return
	 */
	@SuppressWarnings("unchecked")
	public List<TCompany> queryAllCompany() {
		
		Criteria crit=this.getSession().createCriteria(TCompany.class).add(Restrictions.eq("isRemove",TaskContent.NOTROMOVE));
		
		List<TCompany>companys=crit.list();
		
		return companys;
	}
	
	/**
	  * 根据客户名称查找客户对象
	  * @author lw
	  * @param company 客户对象
	  * @return
	  */
	@SuppressWarnings("unchecked")
	public Boolean findCompanyByName(TCompany company) {
		
		Criteria crit=this.getSession().createCriteria(TCompany.class).add(Restrictions.eq("name",company.getName())).add(Restrictions.eq("isRemove",ChannelContent.NOTROMOVE));
		
		List<TCompany>companys=crit.list();
		
		if(companys.size()>0){
			
			return true;
			
		}
		
		return false;
	}
    
	/**
	 * 删除客户对象
	 * @author lw
	 * @param info 要删除的对象集合
	*/
	public void deleteUser(String info) {	    
			String sql = "update t_company set isremove="+JEEContant.ROMOVE+" where id in ("+info+")";
			this.executeBySql(sql, null);
	}
	
	/**
	 * 修改客户
	 * @author lw
	 * @param  company 客户对象
	 * 
	*/
	public void updateCompany(TCompany company) {
		String hql = "update TCompany t set t.name=:name,t.phone=:phone,t.contactName=:contactName,t.address=:address,t.email=:email,t.createDate=:createDate,t.channelIndustry.id=:channelIndustryid,t.area.id=:areaid where t.id=:id";
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("name", company.getName());
		paramMap.put("phone", company.getPhone());
		paramMap.put("contactName", company.getContactName());
		paramMap.put("address", company.getAddress());
		paramMap.put("email", company.getEmail());
		paramMap.put("createDate",company.getCreateDate());
		paramMap.put("channelIndustryid",company.getChannelIndustry().getId());
		paramMap.put("areaid",company.getArea().getId());
		paramMap.put("id",company.getId());
		this.executeByHql(hql, paramMap);
		
	}
}