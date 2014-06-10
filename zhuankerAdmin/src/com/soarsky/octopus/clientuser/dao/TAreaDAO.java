package com.soarsky.octopus.clientuser.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TArea;

public class TAreaDAO extends BaseDAO  {
	
	
	/**
	    * 根据parentId查询区域信息
	    * 
	    * @param parentId
	    * @return
	    */
	@SuppressWarnings("unchecked")
	public List<TArea> findArea(Long parentId) {
		
		 List<TArea> areaList=this.getSession().createCriteria(TArea.class).add(Restrictions.eq("parentId",parentId)).add(Restrictions.eq("isremove", JEEContant.NOTROMOVE)).list();
		 return areaList;
		
	}
	
	/**
	    * 根据parentId查询区域信息
	    * 
	    * @param parentId
	    * @return
	*/
	@SuppressWarnings("unchecked")
    public List<TArea> findAreaById(Long parentId) {
		
		Criteria crit=this.getSession().createCriteria(TArea.class).add(Restrictions.eq("parentId",parentId))
				.add(Restrictions.eq("isremove", JEEContant.NOTROMOVE));
		return crit.list();
	}
	
	//删除区域
	public void deleteArea(Long id){
		
		Map<String,Object> params=new HashMap<String,Object>();
				
		String sql="update(select * FROM t_area where id=:id or parent_id=:parentid) a SET a.ISREMOVE=:isremove";
		
		params.put("id", id);
		
		params.put("parentid", id);
		
		params.put("isremove", JEEContant.ROMOVE);
		
		this.executeBySql(sql, params);
		
	}
	
	//编辑区域
	public void editArea(Long id,String statename){
		
		Map<String,Object> params=new HashMap<String,Object>();
		
		String sql="update(select * FROM t_area where id=:id AND isremove=:isremove) a SET a.STATENAME=:statename";
		
		params.put("id", id);
		
		params.put("statename", statename);
		
		params.put("isremove", JEEContant.NOTROMOVE);
		
		this.executeBySql(sql, params);
		
		
	}
	
	//查找根节点
	
	public TArea findByroot(){
		
	    Map<String,Object> params=new HashMap<String,Object>();
	    
	    String sql="select * FROM t_area where parent_id=:parentid";
	    
	    params.put("parentid", JEEContant.NOTROMOVE);
	    
		List<TArea> areaList=this.queryBySql(sql, params, TArea.class);
		
		TArea arearoot=areaList.get(0);
		
		return arearoot;
	}
	
	/**
     * 初始化用户注册管理区域
     * @author lw
     * @return
    */
	public List<TArea> findAreaList() {
		
		Criteria crit=this.getSession().createCriteria(TArea.class).add(Restrictions.eq("parentId",ClientUserContent.CHINA));
		
		List<TArea> areas=crit.list();
		
		if(areas.size()>0){
			
			return areas;
			
		}
		
		return null;
	}
	
	
	
}
	
	
