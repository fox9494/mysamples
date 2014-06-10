package com.soarsky.octopus.channel.dao;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soarsky.octopus.clientuser.vo.Attr;
import com.soarsky.octopus.clientuser.vo.TreeData;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.dao.BaseDAO;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TManagerInfo;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.mapping.TUserGoldCount;
import com.soarsky.octopus.utils.PageBean;


public class TChannelDAO extends BaseDAO  {
	
	public List<TChannel> findAllChannelByManagerId(Long id){
		return null;

	}
    
	/**
     *得到所有的渠道信息
     *@author lw
     *@return 
    */
	public List<TreeData> findAllChannels() {
		
		List<TreeData>treedata=new ArrayList<TreeData>();
		
		String sql = "select * from t_channel where parentId=1 and isRemove =:isRemove";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("isRemove", JEEContant.NOTROMOVE);
		
		List<TChannel>channels=this.queryBySql(sql, param, TChannel.class);
		for(TChannel chann:channels){
			
			TreeData  channel=new TreeData();
			
			Attr  id=new Attr();
			
			id.setId(chann.getId());
			
			channel.setData(chann.getChannelName());
			
			channel.setAttr(id);
			
			treedata.add(channel);
		}
		
		return treedata;
	}
	

	/**
	 * 根据parentid查询出本级层次使用的最大层级代码
	 * @param parentId
	 * @return
	 */
	public String findMaxCode(Long parentId){
		return (String) this.getSession().createCriteria(TChannel.class).setProjection(Projections.max("levelCode")).
				createCriteria("parent").add(Restrictions.eq("id", parentId)).uniqueResult();
	}
	/**
	 * 分页显示一级渠道
	 * @param maxresult
	 * @param currentpage
	 * @author yl
	 * @return
	 */
	public PageBean findAllFirstChannel(int maxresult,int currentpage){		
		String sql = "select * from t_channel where parentId=1 and isRemove =:isRemove";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("isRemove", JEEContant.NOTROMOVE);
		return this.queryForPageByParams(maxresult, currentpage, sql, param, TChannel.class);
	}
	/**
	 * 判断是否有相同的一级渠道
	 * @param name一级渠道的名字
	 * @author yl
	 * @return
	 */
	public boolean findFirstChannelByName(String name){
		List<Channel> channel =  this.getSession().createCriteria(TChannel.class).add(Restrictions.eq("channelName", name)).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE)).list();
		if(channel.size()>0){
			return false;
		}
		return true;
	}
	/**
	 * 判断是否有相同的账号
	 * @param userName 账号
	 * @author yl
	 * @return
	 */
	public boolean checkManageinfo(String userName){
		List<TManagerInfo> manageinfo =  this.getSession().createCriteria(TManagerInfo.class).add(Restrictions.eq("userName", userName)).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE)).list();
		if(manageinfo.size()>0){
			return false;
		}
		return true;
	}
	/**
	 * 查找一级渠道的记录数
	 * @author yl
	 * @return
	 */
	public Long findRowNumber(){
		String sql = "select * from t_channel where parentId=(select id from t_channel where parentId=:parentId)";
		int row = this.getSession().createSQLQuery(sql).setParameter("parentId", JEEContant.PARENTID).list().size();		
		return Long.valueOf(row);
	}
	/**
	 * 验证账号（编辑时）
	 * @author yl
	 * @return
	 */
	public boolean checkUserName(String newName,String oldName){
		//如果现在的名字和以前的名字相等，那么就不用验证了（不修改名字的情况）
		if(oldName.equals(newName)){
			return true;
		}
		//如果两个名字不相等，那么再进行数据库查询校验
		else{
			List<TManagerInfo> manageinfo =  this.getSession().createCriteria(TManagerInfo.class).add(Restrictions.eq("userName", newName)).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE)).list();
			if(manageinfo.size()>0){
				return false;
			}else{
				return true;
			}
		}
				
		
	}
	/**
	 * 验证渠道（编辑时）
	 * @return
	 */
	public boolean checkChannel(String newName,String oldName){
		if(newName.equals(oldName)){
			return true;
		}else {
				List<Channel> channel =  this.getSession().createCriteria(TChannel.class).add(Restrictions.eq("channelName", newName)).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE)).list();
				if(channel.size()>0){
					return false;
				}else{
					return true;
				}
		}
		
	}
	/**
	 * 删除一级渠道
	 * @author yl
	 */
	public void deleteFirstChannel(List<Long> idList){
		//先删除渠道下的账号
		if(idList!=null){				
		  for(Long id :idList){
			this.deleteChannel(id);
		  }
		}
	}
	/**
	 * 根据parentid得到parentname
	 * @param id
	 * @author yl
	 * @return
	 */
	public String getParentArea(long id){
		Criteria	crit = this.getSession().createCriteria(TArea.class);		
		crit.add(Restrictions.eq("id", id));
		TArea area = (TArea) crit.uniqueResult();
		String name = area.getStatename();
		return name;
	}
	/**
	 * 得到根渠道(一级渠道的父节点)
	 * @author yl
	 * @param id
	 * @return
	 */
	public TChannel getParentChannel(){
		String sql = "select * from t_channel where parentId=:parentId";
		Long parentId = JEEContant.PARENTID;
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("parentId", parentId);
		List<TChannel> list = this.queryBySql(sql, param, TChannel.class);
		return list.get(0);
	}
	
	/**
	 * 通过managerId获取渠道的信息
	 */
	public List<TChannel> findTree(Long managerId){
		List<TChannel> resultChannelList=new ArrayList<TChannel>();
		TChannel channel = this.findByChannel(managerId);
		if (channel!=null){
			Long parentId=channel.getParent().getId();
			Long channelId=channel.getId();
			Map<String,Object> params=new HashMap<String,Object>();
			Map<String,Object> params2=new HashMap<String,Object>();
			//使用oracle递归查询
			String sql="select * FROM t_channel START WITH parentid=:parentId AND manager_id=:managerId CONNECT BY PRIOR parentid= id ";
			String sql2="select * FROM t_channel START WITH id=:channelId CONNECT BY PRIOR id= parentid";
			
			params.put("managerId", managerId);
			params.put("parentId", parentId);
			params2.put("channelId", channelId);
			
			List<TChannel> tChannelList=this.queryBySql(sql, params, TChannel.class);
			List<TChannel> tChannelList2=this.queryBySql(sql2, params2, TChannel.class);
			
			resultChannelList.addAll(tChannelList);	
			resultChannelList.addAll(tChannelList2);
		}
		
		return resultChannelList;
		
	}
	
	/**
	 * 通过managerId查询渠道
	 * 
	 */
	public TChannel findByChannel(Long managerId){
		
		List<TChannel> tChannelParList=this.getSession().createCriteria(TChannel.class).createCriteria("TManagerInfo").add(Restrictions.eq("id", managerId)).list();
		
		return tChannelParList.get(0);
	}
	/**
	 * 查询parent下面有多少子节点
	 */
     public List<TChannel> findParTree(Long parentId){
    	
    	List<TChannel> tChannelParList=this.getSession().createCriteria(TChannel.class).createCriteria("parent").add(Restrictions.eq("id", parentId)).list();
		return  tChannelParList;
     }
	/**
	 * 通过channelId查询用户数
	 */
	public List<TUserClient> findByUser(Long channelId,String levecode){
		
	
		List<TUserClient> tUserClientList=this.getSession().createCriteria(TUserClient.class).add(Restrictions.eq("leveCode", levecode)).createCriteria("channel").add(Restrictions.eq("id", channelId)).list();
	    
		return tUserClientList;
	}
	
	/**
	 * 查询当前id下面的渠道集合，作为判断末级渠道的标准
	 */
	public List<TChannel> findByLastChannel(Long channelId){
		
		List<TChannel>tChannelLastList=new ArrayList<TChannel>();
		
		Map<String,Object> params=new HashMap<String,Object>();
		
		Map<String,Object> params2=new HashMap<String,Object>();
		
		String sql="select * from t_channel START WITH id=:channelId CONNECT BY PRIOR  parentid= id";
		String sql2="select * from t_channel START WITH id=:channelId CONNECT BY PRIOR  id= parentid";
		
		params.put("channelId", channelId);
		params2.put("channelId", channelId);
		
		List<TChannel> tChannelList=this.queryBySql(sql, params, TChannel.class);
		
		List<TChannel> tChannelList2=this.queryBySql(sql2, params2, TChannel.class);
		
		tChannelLastList.addAll(tChannelList);
		tChannelLastList.addAll(tChannelList2);
		return tChannelLastList;
	}
	
	/**
	 * 查询非末级渠道的用户数
	 */
	
	public List<TUserClient> findByNonLastChannel(String leveCode){
	
		 List<TUserClient> userClientList=this.getSession().createCriteria(TUserClient.class).add(Restrictions.like("leveCode", "%"+leveCode+"%")).list();
		
		 return userClientList;
		
	}
	
	/**
	 * 计算用户金币数量
	 */
	public List<TUserGoldCount> findByAllGOld(Long userId){

     	List<TUserGoldCount> goldList= this.getSession().createCriteria(TUserGoldCount.class).createCriteria("TUserClient").add(Restrictions.eq("id", userId)).list();

	 return goldList;
}
	
	/**
	 * 删除渠道
	 */
	public void deleteChannel(Long id){
		
		String sql="update t_channel SET isremove=:REMOVE where id IN (select id from t_channel START WITH id=:id CONNECT BY PRIOR  id= parentid)";
		String sql2 = "update t_manager_info  set isremove=:REMOVE where id in(select manager_Id from t_channel where id in (select id from t_channel START WITH id=:id CONNECT BY PRIOR  id= parentid))";
		
		Map params = new HashMap();
		params.put("id", id);
		params.put("REMOVE", JEEContant.ROMOVE);		
		this.executeBySql(sql, params);	
		this.executeBySql(sql2, params);
		
	}
	/**
	 * 更新一渠道,先清除session
	 * @author yl
	 * @param tchannel
	 */
	public void upDate(TChannel tchannel){
		this.getSession().update(tchannel);
	}
	
	/**
	 * 更新渠道
	 */
	public void upDateChannel(TChannel tChannel){
		this.getSession().clear();
		this.getSession().update(tChannel);
	}
	
	/**
	 * 根据渠道的父级渠道id查询所有统计渠道（如，查询所有一级渠道即查询父级渠道id=1的所有渠道）
	 * @param parent_id 父级渠道id
	 * @return 所有该级渠道集合
	 */
	public List<TChannel> queryTChannelByParentId(Long parent_id) {
		
		//select * from t_channel where parentid = 1000000003;
		String hql = " from TChannel where isRemove=? and parent.id=? ";
		List<Object> params = new ArrayList<Object>();
		params.add(JEEContant.NOTROMOVE);
		params.add(parent_id);
		
		return (List<TChannel>) this.queryByHql(hql, params);
	}
	/**
	 * 判断是否有子渠道
	 * @author yl
	 * @return
	 */
	public boolean isHaveChannel(List<Long> idList){
		//先找到所以一级渠道的
		String sql = "select * from t_channel where parentId in :idList";		
		List<Channel>	list = this.getSession().createSQLQuery(sql).setParameterList("idList", idList).list();
		//含有子渠道
		if(list.size()>0){
			return false;
		}else{
			return true;
		}
		
	}
	/**
	 * 批量删除账号
	 * @author yl
	 * @param idList
	 */
	public void deleteManageInfo(List<Long> idList){
		//1.首先根据渠道找到所有的角色id集合
		String sql = "update t_manager_info  set isremove=1 where id in(select manager_Id from t_channel where id in :idList)";
		this.getSession().createSQLQuery(sql).setParameterList("idList", idList).executeUpdate();
	}
	
	/**
	 * 查询pagebean
	 */
	public PageBean queryChannel(Long parentId,int maxResult,int currentPage){
		
		Map<String,Object> params=new HashMap<String,Object>();
		String sql="select * from t_channel where parentId=:parentId and isremove=:NotRemove OR id=:id ORDER BY id";
		params.put("parentId", parentId);
		params.put("NotRemove", JEEContant.NOTROMOVE);
		params.put("id", parentId);
		return this.queryForPageByParams(maxResult, currentPage, sql, params, TChannel.class);
	  
		
	
	}
	
	
	/**
	 * 分页查找所有有效渠道
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public PageBean queryForPage(int pageSize,int page){
		Criteria crit = this.getSession().createCriteria(TChannel.class).add(Restrictions.eq("isRemove", JEEContant.NOTROMOVE));
		return this.queryForPageByParams(pageSize, page, crit);
	}
	
}