package com.soarsky.octopus.manager.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.StandardBasicTypes;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.manager.vo.TransModelBean;
import com.soarsky.octopus.mapping.TModelInfo;

public class TModelInfoDAO extends BaseDAO  {
	
	


	//查询root节点
	public TModelInfo findByroot(){
		
	    Map<String,Object> params=new HashMap<String,Object>();
	    String sql="select * FROM t_model_info  where parent_id=:parentid";
	    params.put("parentid", JEEContant.ROOTMODEL);
		List<TModelInfo> modelList=this.queryBySql(sql, params, TModelInfo.class);

		return modelList.get(0);
	}
	
	/**
	 * 查询出所有导航菜单
	 * @return
	 */
	public List<TransModelBean> selectMenu(){
		
		String sql = "select level,id,name,code,type,modelorder,url,parent_id,icon " 
		       +" from t_model_info where type="+JEEContant.MENU+" start with id= " +JEEContant.ROOTAREA
			   +"connect by prior id = parent_id order by modelorder";
		return this.getSession().createSQLQuery(sql).addScalar("LEVEL", StandardBasicTypes.INTEGER).addScalar("ID", StandardBasicTypes.INTEGER).
				addScalar("NAME",StandardBasicTypes.STRING).addScalar("CODE", StandardBasicTypes.STRING).addScalar("TYPE", StandardBasicTypes.STRING).
				addScalar("MODELORDER", StandardBasicTypes.INTEGER).addScalar("URL", StandardBasicTypes.STRING).addScalar("PARENT_ID", StandardBasicTypes.INTEGER)
				.addScalar("ICON", StandardBasicTypes.STRING).setResultTransformer(new AliasToBeanResultTransformer(TransModelBean.class)).list();
	}
	
	
	/**
	 * 根据给定节点查出所有父节点
	 * @return
	 */
	public List<TModelInfo> selectParentModelById(Long id){
		String sql = "select id,name,code,type,modelorder,url,parent_id,icon " 
		       +" from t_model_info where id < :id start with id=:id connect by prior parent_id = id order by modelorder";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("id", id);
		return this.queryBySql(sql, params, TModelInfo.class);
	}
	
	
	
	/**
	    * 根据parentId查询区域信息
	    * 
	    * @param parentId
	    * @return
	    */
	
	public List<TModelInfo> findModel(Long parentId) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "";
		sql = "select * FROM t_model_info WHERE parent_id=:parentId";
		params.put("parentId", parentId);
		List<TModelInfo> ModelList = this.queryBySql(sql, params, TModelInfo.class);
    
		return ModelList;

	}
	
	/**
	 * 删除model
	 * 
	 * 
	 */
	public void deleteModel(Long id){
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("id", id);
		String sql1="delete from t_model_info  t WHERE t.id=:id";
	    String sql2="select * from t_model_info m WHERE m.parent_Id=:id";
	    String sql3="delete  from t_model_info p WHERE p.parent_Id=:id";
	    List<TModelInfo> ModelList=this.queryBySql(sql2, params, TModelInfo.class);
	    if(ModelList.size()>0){
	    	
	    	this.executeBySql(sql3, params);
	    }
		this.executeBySql(sql1, params);
		
		
	}
   
}
	
	
