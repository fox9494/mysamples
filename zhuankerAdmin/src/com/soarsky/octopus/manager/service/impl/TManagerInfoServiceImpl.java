package com.soarsky.octopus.manager.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.dao.TManagerInfoDAO;
import com.soarsky.octopus.manager.service.TManagerInfoService;
import com.soarsky.octopus.mapping.TManagerInfo;
import com.soarsky.octopus.mapping.TModelInfo;
import com.soarsky.octopus.mapping.TRightInfo;
import com.soarsky.octopus.mapping.TRoleInfo;
import com.soarsky.octopus.utils.MD5Util;
import com.soarsky.octopus.utils.PageBean;

public class TManagerInfoServiceImpl implements TManagerInfoService {
	
	private TManagerInfoDAO tManagerInfoDAO;
	
	
	
	/**
	 * 用户登录验证
	 * @param userName  用户名
	 * @param password  MD5加密的密码
	 * @return
	 */
	public TManagerInfo login(String userName, String password){
		TManagerInfo manager = new TManagerInfo();
		manager.setUserName(userName);
		manager.setPassword(password);
		manager.setIsRemove(JEEContant.NOTROMOVE);
		List<TManagerInfo> list = tManagerInfoDAO.findByExample(manager);
		return (list!=null&&!list.isEmpty())?list.get(0):null ;
	}
	
	/**
	 * 得到用户的导航菜单
	 * @param uid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TModelInfo> getAdminUserMenus(Long uid){
		TRoleInfo role= tManagerInfoDAO.getById(TManagerInfo.class, uid).getTRoleInfo();
		Set<TRightInfo> rights = role.getTRightInfos();
		List<TModelInfo> resultList = new ArrayList<TModelInfo>();
		Map<Long,TModelInfo> modelMap = new HashMap<Long,TModelInfo>();
		if (rights!=null){
			for (TRightInfo rightInfo : rights) {
				TModelInfo model = rightInfo.getTModelInfo();

				Set<TModelInfo> setOrder = new TreeSet<TModelInfo>(new Comparator(){
					@Override
					public int compare(Object o1, Object o2) {
						TModelInfo t1 =(TModelInfo) o1;
						TModelInfo t2 =(TModelInfo) o2;
						
						if (t1.getModelOrder()>t2.getModelOrder()){
							return 1;
						}else if(t1.getModelOrder()==t2.getModelOrder()){
							return 0;
						}else{
							return -1;
						}
					}
					
				});
				
				TModelInfo cloneModel = new TModelInfo(model.getId(), model.getName(), model.getCode(), model.getType(), model.getUrl(),
						model.getIcon(), model.getParent(), model.getModelOrder(), new HashSet(), setOrder);
				
				modelMap.put(model.getId(), cloneModel);
			}
		}
		
		//得到根节点并设置每个节点的子节点
		Set<Entry<Long, TModelInfo>> set = modelMap.entrySet();
		for (Entry<Long, TModelInfo> entry : set) {
			TModelInfo model = entry.getValue();
			TModelInfo parentTree = modelMap.get(model.getParent().getId());
			if (parentTree==null){//表示root节点
				resultList.add(model);
			}else{
				parentTree.getModelSet().add(model);
			}
		}
		
		
		return resultList;
	}

	/**
	 * 分页查询
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public PageBean queryListPage(int pageSize,int currentPage){
		return tManagerInfoDAO.queryForPage(pageSize, currentPage);
	}
	

	/**
	 * 保存
	 * @param manager
	 */
	public void save(TManagerInfo manager){
		tManagerInfoDAO.save(manager);
	}
	
	/**
	 * 根据主键查找
	 * @param id
	 * @return
	 */
	public TManagerInfo findManager(Long id){
		return tManagerInfoDAO.getById(TManagerInfo.class, id);
	}
	
	/**
	 * 修改
	 * @param manager
	 */
	public void editManager(TManagerInfo manager){
		tManagerInfoDAO.update(manager);
	}
	
	/**
	 * 修改密码
	 * @param manager
	 */
	public int editPass(String password,Long id){
		return tManagerInfoDAO.updatePass(password,id);
	}
	
	/**
	 * 执行逻辑删除
	 * @param ids
	 */
	public void deleteManagers(String ids){
		tManagerInfoDAO.delete(ids);
	}
	
	
	
	/**
	 * 验证用户是否具有该code权限
	 * @param uid  用户ID
	 * @param code  权限码
	 * @return
	 */
	public boolean validateRight(Long uid,String code){
		boolean result = false;
		TManagerInfo managerUser = tManagerInfoDAO.getById(TManagerInfo.class, uid);
		if(null == managerUser){
			return result;
		}
		Set<TRightInfo> rights = managerUser.getTRoleInfo().getTRightInfos();
		if (rights!=null){
			for (TRightInfo rightInfo : rights) {
				if (code.equalsIgnoreCase(rightInfo.getTModelInfo().getCode())){
					result=true;
				}
			}
		}
		return result;
	}
	
	/**
	 * 验证用户是否具有该url权限
	 * @param uid  用户ID
	 * @param url  请求地址
	 * @return
	 */
	public boolean validateRightByUrl(Long uid,String url){
		boolean result = false;
		TManagerInfo managerUser = tManagerInfoDAO.getById(TManagerInfo.class, uid);
		if(null == managerUser){
			return result;
		}
		Set<TRightInfo> rights = managerUser.getTRoleInfo().getTRightInfos();
		if (rights!=null){
			for (TRightInfo rightInfo : rights) {
				if (url.equalsIgnoreCase(rightInfo.getTModelInfo().getUrl())){
					result=true;
				}
			}
		}
		return result;
	}
	
	/**
	 * 修改密码
	 * @param id
	 * @param password
	 */
	public void initPassword(String ids){
		String password = MD5Util.getMD5(JEEContant.initPassword);
		String[] idArray = ids.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : idArray) {
			idList.add(Long.valueOf(id));
		}
		tManagerInfoDAO.updatePass(password, idList);
	}

	public TManagerInfoDAO gettManagerInfoDAO() {
		return tManagerInfoDAO;
	}

	public void settManagerInfoDAO(TManagerInfoDAO tManagerInfoDAO) {
		this.tManagerInfoDAO = tManagerInfoDAO;
	}

	/**
	 * 判断是否有重复的用户名
	 */
	public boolean judgeUserName(String userName) {
		
		return this.tManagerInfoDAO.findByMangerInfo(userName);
	}

	/**
	 * 判断用户下是否有渠道存在
	 */
	public boolean judgeMgrChannel(String ids) {
		
		String[] id = ids.split(",");
		List<Long> idList = new ArrayList<Long>();
		for(String list:id){
			idList.add(Long.valueOf(list));
		}
		
	   return this.tManagerInfoDAO.judgeMgrChannel(idList);
		
		
	}
}
