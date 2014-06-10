package com.soarsky.octopus.manager.dao;

import java.nio.channels.Channel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TManagerInfo;
import com.soarsky.octopus.utils.PageBean;

/**
 * 后台用户数据访问类
 * @author chenll
 *
 */
public class TManagerInfoDAO extends BaseDAO {
	
	public static int SUCCESS=0;
	
	public static int FAILT=-1;
	

	/**
	 * 分页查找后台用户
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public PageBean queryForPage(int pageSize,int currentPage){
		return this.queryForPageByParams(pageSize, currentPage, this.getSession().createCriteria(TManagerInfo.class).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE)));
	}
	
	
	/**
	 * 更新
	 * @param manager
	 */
	public void update(TManagerInfo manager){
		
		String hql = "update TManagerInfo t set t.realName=:realName,t.userName=:userName,t.TRoleInfo.id=:roleId where t.id=:id";
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("realName", manager.getRealName());
		paramMap.put("userName", manager.getUserName());
		paramMap.put("roleId", manager.getTRoleInfo().getId());
		paramMap.put("id", manager.getId());
		this.executeByHql(hql, paramMap);
	}
	
	/**
	 * 修改密码
	 * @param manager
	 */
	public int updatePass(String password,Long id){
		String hql = "update TManagerInfo t set t.password=:password where t.id=:id";
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("password", password);
		paramMap.put("id", id);
		try {
			this.executeByHql(hql, paramMap);
			return SUCCESS;
		} catch (Exception e) {
			return FAILT;
		}
	}

	/**
	 * 执行逻辑删除
	 * @param ids
	 */
	public void delete(String ids){
		String sql = "update t_manager_info set isremove="+JEEContant.ROMOVE+" where id in ("+ids+")";
		this.executeBySql(sql, null);
	}
	
	/**
	 * 更改密码
	 * @param password
	 * @param id
	 */
	public void updatePass(String password,List<Long> idList){
		String sql = "update t_manager_info set password=:password where id in :idList";
		this.getSession().createSQLQuery(sql).setParameter("password", password)
		.setParameterList("idList",idList).executeUpdate();
	}
	
	/**
	 * 根据用户名查询用户,并判断是否有此用户
	 */
	public boolean findByMangerInfo(String userName){
		
		List<TManagerInfo> tManagerInfoList=this.getSession().createCriteria(TManagerInfo.class).add(Restrictions.eq("userName", userName)).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE)).list();
		if(tManagerInfoList.size()>0){
			
			return true;
		}
		return false;
	}
	
	/**
	 * 查看是否有该角色的用户存在
	 */
	public boolean findByRoleUser(Long roleId){
		
		List<TManagerInfo> tManagerList=this.getSession().createCriteria(TManagerInfo.class).createCriteria("TRoleInfo").add(Restrictions.eq("id", roleId)).list();	
	    if(tManagerList.size()>0){
	    	
	    	return true;
	    }
	    return false;
	
	}
	
	/**
	 * 判断该用户下面是否有渠道
	 */
	public boolean judgeMgrChannel(List<Long> idList){
		
		        //查询该用户下面是否有渠道存在
				String sql = "select * from t_channel where MANAGER_ID in :idList and ISREMOVE=:NotRemove";		
				List<TChannel>	list = this.getSession().createSQLQuery(sql).setParameterList("idList", idList).setParameter("NotRemove",JEEContant.NOTROMOVE ).list();
				//含有渠道
				if(list.size()>0){
					return true;
				}else{
					return false;
				}
	}
    

}