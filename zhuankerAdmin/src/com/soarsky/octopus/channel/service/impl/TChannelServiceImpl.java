package com.soarsky.octopus.channel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.soarsky.octopus.channel.dao.TChannelDAO;
import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.channel.vo.NonFinalChannel;
import com.soarsky.octopus.clientuser.vo.Attr;
import com.soarsky.octopus.clientuser.vo.TreeData;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.common.service.MailService;
import com.soarsky.octopus.common.service.PackageApkService;
import com.soarsky.octopus.manager.dao.TRoleInfoDAO;
import com.soarsky.octopus.manager.dao.TVersionDAO;
import com.soarsky.octopus.mapping.TArea;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TManagerInfo;
import com.soarsky.octopus.mapping.TRightInfo;
import com.soarsky.octopus.mapping.TRoleInfo;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.mapping.TUserGoldCount;
import com.soarsky.octopus.mapping.TVersion;
import com.soarsky.octopus.utils.MD5Util;
import com.soarsky.octopus.utils.PageBean;
import com.soarsky.octopus.utils.PathUtil;

public class TChannelServiceImpl implements TChannelService{
	
	private TChannelDAO tChannelDAO;
	
	private TVersionDAO tVersionDAO;
	
	private MailService mailService;
	
	private PackageApkService packageApkService;
	
	private static Logger logger = Logger.getLogger(TChannelServiceImpl.class);  
	
	
	/**
	 * 更新实体
	 */
	public void updateChannel(TChannel channel){
		tChannelDAO.merger(channel);
	}
	
	/**
	 * 分页显示一级渠道
	 * @author yl
	 */
	public PageBean findAllFirstChannel(int maxresult, int currentpage) {
		
		return tChannelDAO.findAllFirstChannel(maxresult, currentpage);
	}
	/**
	 * 删除一级渠道
	 * @author yl
	 */
	public void deleteFirstChannel(String ids) {
		String[] idArray = ids.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : idArray) {
			idList.add(Long.valueOf(id));
		}
		tChannelDAO.deleteFirstChannel(idList);
	}
	/**
	 * 添加一级渠道
	 * @author yl
	 */
	public void saveFirstChannel(TChannel channel) {	
		long row = tChannelDAO.findRowNumber();
		//计算一级渠道code
		String str = getChannelCode(row, JEEContant.FIRSTCHANNEL_NUMBER,null);
		
		//设置根渠道(一级渠道的父节点)
		TChannel parentChannel = tChannelDAO.getParentChannel();
		channel.setParent(parentChannel);
		String parentlevel = parentChannel.getLevelCode();
		channel.setLevelCode(parentChannel.getLevelCode()+str);
		//设置默认的角色
		TRoleInfo role =  tChannelDAO.getById(TRoleInfo.class, JEEContant.INIT_ROLE);
		if (role!=null){
			Set<TRightInfo> set = role.getTRightInfos();
			for (TRightInfo right : set) {
			}
		}
		channel.getTManagerInfo().setTRoleInfo(role);
		tChannelDAO.save(channel);	
		TVersion version = tVersionDAO.queryMaxVersion();
		if (version!=null){//有版本才打包
			packageApkService.packageApk(channel.getId(),"Octopus.apk",version.getApkUrl());
		}
	}
	/**
	 * 更新一级渠道
	 * @author yl
	 */
	public void editFirstChannel(TChannel channel) {
		//得到以前的一级渠道
		TChannel old = tChannelDAO.getById(TChannel.class,channel.getId());
		TManagerInfo manager = old.getTManagerInfo();
		if (!manager.getPassword().equals(channel.getTManagerInfo().getPassword())){
			manager.setPassword(MD5Util.getMD5(channel.getTManagerInfo().getPassword()));
		}
		manager.setUserName(channel.getTManagerInfo().getUserName());
		manager.setRealName(channel.getChannelName());
		
		old.setChannelName(channel.getChannelName());
		old.setTArea(channel.getTArea());
		old.setTChannelIndustry(channel.getTChannelIndustry());
		old.setContactPerson(channel.getContactPerson());
		old.setMobile(channel.getMobile());
		old.setEmail(channel.getEmail());
		old.setBank(channel.getBank());
		old.setBankName(channel.getBankName());
		old.setBankAccount(channel.getBankAccount());
		old.setPaylevel(channel.getPaylevel());
		
		
		/*
		String oldUserName = old.getTManagerInfo().getUserName();		
		String newUserName = channel.getTManagerInfo().getUserName();
		String oldPassword = old.getTManagerInfo().getPassword();		
		String newPassword = channel.getTManagerInfo().getPassword();
		//如果账号没有变，那么还是用以前的账号
		if(oldUserName.equals(newUserName)&&!oldPassword.equals(newPassword)){
			deleteOldManageinfo(old.getTManagerInfo().getId());
			channel.getTManagerInfo().setUserName(oldUserName);
			channel.getTManagerInfo().setPassword(MD5Util.getMD5(newPassword));
		}
		//如果密码不变，那么还是用以前的密码
		if(!oldUserName.equals(newUserName)&&oldPassword.equals(newPassword)){
			deleteOldManageinfo(old.getTManagerInfo().getId());
			channel.getTManagerInfo().setUserName(newUserName);
			channel.getTManagerInfo().setPassword(oldPassword);
		}
		else{
			deleteOldManageinfo(old.getTManagerInfo().getId());
			channel.getTManagerInfo().setPassword(MD5Util.getMD5(newPassword));
		}
		channel.setLevelCode(old.getLevelCode());
		//设置一级渠道的父节点
		channel.setParent(tChannelDAO.getParentChannel());
		//为账号，设置默认的角色
		TRoleInfo role =  tChannelDAO.getById(TRoleInfo.class, JEEContant.INIT_ROLE);
		if (role!=null){
			Set<TRightInfo> set = role.getTRightInfos();
			for (TRightInfo right : set) {				
			}
		}
		channel.getTManagerInfo().setTRoleInfo(role);		
		tChannelDAO.upDate(channel);	*/	
	}
	/**
	 * 根据id得到一级渠道
	 * @author yl
	 */
	public TChannel getFirstChannelById(long id) {
		TChannel firstChannel = tChannelDAO.getById(TChannel.class, id);
		//懒加载
		long channelId = firstChannel.getTManagerInfo().getId();
		long parentId = firstChannel.getTArea().getParentId();
		String name = 	firstChannel.getTManagerInfo().getUserName();
		String passWord = firstChannel.getTManagerInfo().getPassword();
		return firstChannel;
	}

	/**
	 * 判断是否有相同的一级渠道
	 * @author yl
	 */
	public boolean findFirstChannelByName(String name) {
		if(tChannelDAO.findFirstChannelByName(name)){
			return true;
		}
		return false;
	}
	/**
	 * 判断是否含有相同的账号
	 * @author yl
	 */
	public boolean checkManageinfo(String userName) {
		if(tChannelDAO.checkManageinfo(userName)){
			return true;			
		}
		return false;
	}
	
	
	/**
	 * 根据父节点查询本级有渠道数量
	 * @param parentId
	 * @return
	 */
	/*
	public String generateLevelCode(Long parentId){
		Long rowNum =  tChannelDAO.findRowNumberByParent(parentId);
		Long sequece = rowNum + 1;
		String code = String.format("%04d", sequece);
		String parentCode = tChannelDAO.getById(TChannel.class, parentId).getLevelCode();
		return parentCode+code;
	}*/
	
	/**
	 * 根据父节点查询本级有渠道数量
	 * @param parentId
	 * @return
	 */
	/*
	public String generateLevelCode(Long parentId){
		Long rowNum =  tChannelDAO.findRowNumberByParent(parentId);
		Long sequece = rowNum + 1;
		String code = String.format("%04d", sequece);
		String parentCode = tChannelDAO.getById(TChannel.class, parentId).getLevelCode();
		return parentCode+code;
	}*/
	
	/**
	 * 删除旧的账号密码
	 */
	public void deleteOldManageinfo(long  id) {
		String hql = "update TManagerInfo m set m.isRemove=1 where m.id=:id";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		tChannelDAO.executeByHql(hql, param);
	}
	/**
	 * 一级渠道的总记录数
	 * @author yl
	 */
	public long findRowNumber() {		
		return tChannelDAO.findRowNumber();
	}
	/**
	 * 计算渠道code
	 * @row 该层下渠道的记录行数
	 * @number 当前添加渠道的层数numer=0表示其他渠道(子渠道)number=1表示一级渠道
	 * @parentId 父级渠道code
	 * @author yl
	 * @return
	 */
	public String getChannelCode(long row,int number,String parentId){
		String result="";
		//记录加一
		long rows = row+1;
		String format = "%0"+JEEContant.ZERO_NUMBERS+"d";
		//如果层数等于1
		if(number==JEEContant.FIRSTCHANNEL_NUMBER&&parentId==null){									
			//格式化
			result = String.format(format, rows);
			return result;
		}
		//其他渠道(子渠道)Code
		else if(number==JEEContant.OTHERCHANNEL_NUMBER&&parentId!=null){			
			//格式化
			result = parentId+String.format(format, rows);
			return result;			
		}
		else{
			return null;
		}		
	}
	/**
	 * 根据parentid找到parent
	 * @author yl
	 */
	public String getParentArea(long id) {
		return tChannelDAO.getParentArea(id);
	}
	/**
	 * 根渠道
	 * @author yl
	 */
	public TChannel getParentChannel() {
		return tChannelDAO.getParentChannel();
	}
	
	public TChannelDAO gettChannelDAO() {
		return tChannelDAO;
	}

	public void settChannelDAO(TChannelDAO tChannelDAO) {
		this.tChannelDAO = tChannelDAO;
	}

	/**
	 * 添加渠道
	 * 
	 */
	public void addChannel(TChannel tChannel) {
		tChannelDAO.save(tChannel);	
		
		//打包渠道apk
		TVersion version = tVersionDAO.queryMaxVersion();
		if (version!=null){//有版本才打包
			packageApkService.packageApk(tChannel.getId(),"Octopus.apk",version.getApkUrl());
		}
	}

	/**
	 * 修改渠道
	 */
	public void modifyChannel(TChannel tChannel) {
		
		TChannel old = tChannelDAO.getById(TChannel.class,tChannel.getId());
		TManagerInfo manager = old.getTManagerInfo();
		if (!manager.getPassword().equals(tChannel.getTManagerInfo().getPassword())){
			manager.setPassword(MD5Util.getMD5(tChannel.getTManagerInfo().getPassword()));
		}
		manager.setUserName(tChannel.getTManagerInfo().getUserName());
		manager.setRealName(tChannel.getChannelName());
		tChannel.setTManagerInfo(manager);
	    TRoleInfo role=this.tChannelDAO.getById(TRoleInfo.class, JEEContant.INITROLEID);
		tChannel.getTManagerInfo().setTRoleInfo(role);
		tChannelDAO.upDateChannel(tChannel);
	}

	/**
	 * 删除渠道
	 */
	public void deleteChannel(Long id) {
		
		this.tChannelDAO.deleteChannel(id);
	}
	
	/**
	 * 查询上级渠道
	 * 
	 */
	public TChannel findByParent(Long channelId){
		
		TChannel parentChannel=this.tChannelDAO.getById(TChannel.class, channelId);
		return parentChannel;
	}

	@Override
	public void pushToUser() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 分页查询所有有效渠道，用于渠道批量打包
	 * @return
	 */
	public PageBean queryPageForPackage(int pageSize,int page){
		return tChannelDAO.queryForPage(pageSize, page);
	}

	@Override
	public List<TChannel> findAllChannelByManagerId(Long managerId) {
		TManagerInfo tManagerInfo =  new TManagerInfo();
		tManagerInfo.setId(managerId);
		TChannel tChannel = new TChannel();
		tChannel.setTManagerInfo(tManagerInfo);
		List<TChannel> list = tChannelDAO.findByExample(tChannel);
		return  tChannelDAO.findAllChannelByManagerId(list.get(0).getId());
	}
	
    /**
     *得到所有的渠道信息
     *@author lw
     *@return 
    */
	public List<TreeData> findAllChannels() {
		
		return tChannelDAO.findAllChannels();
	}
    /**
     * 根据渠道ID查找渠道
     * @author lw
     * @param  tChannel 要查找的渠道对象
     * @return
	*/
	public TChannel initChannel(TChannel tChannel) {
		
		return tChannelDAO.getById(TChannel.class, tChannel.getId());
	}
	/**
	 * 根据id查询出渠道信息
	 * @param parentId
	 * @return
	 */
	public TChannel getChannel(Long id){
		return tChannelDAO.getById(TChannel.class, id);
	}
	
	/**
	 * 根据parenid查询出本级中使用的最大code
	 * @param parentId
	 * @return
	 */
	public String getMaxCode(Long parentId){
		return tChannelDAO.findMaxCode(parentId);
	}
	
	/**
	 * 根据渠道id和目标url发送apkurl邮件
	 * @param targetEmail
	 * @param id
	 */
	public void sendEmailByChannel(String targetEmail,Long id){
		TChannel channelInDB = tChannelDAO.getById(TChannel.class, id);
		 String downUrl = "";
		 if (channelInDB!=null){
			 if (StringUtils.isNotBlank(channelInDB.getApkUrl())){
				 downUrl = PathUtil.getHttpPath()+"/upload"+channelInDB.getApkUrl();
			 }
		 }
		 logger.info("准备开始发送邮件,参数如下：channelId:"+id+",downUrl:"+downUrl);
		 mailService.sendMail(targetEmail,  downUrl);
	}
	
	/**
	 * 查询所有渠道
	 * 
	 */
	public List<TreeData> findTree(Long managerId) {
		List<TreeData> TreeDataList=new ArrayList<TreeData>();
		List<TChannel> tChannelList=this.tChannelDAO.findTree(managerId);
		Map<Long,TreeData> modelMap = new HashMap<Long,TreeData>();
		if (tChannelList!=null){
			for (TChannel tChannel : tChannelList) {
				if(tChannel.getIsRemove()==JEEContant.NOTROMOVE){
				TreeData tree=new TreeData();
				tree.setChildren(new ArrayList<TreeData>());
				tree.setData(tChannel.getChannelName());
				tree.setStatename(tChannel.getChannelName());
				Attr attr=new Attr();
				attr.setId(tChannel.getId());
				attr.setParentId(tChannel.getParent().getId());
				attr.setLeveCode(tChannel.getLevelCode());
				tree.setAttr(attr);
				modelMap.put(tChannel.getId(), tree);
				}
				else{
					
					continue;
				}
			}
		}
		
		//得到根节点并设置每个节点的子节点
		Set<Entry<Long, TreeData>> set = modelMap.entrySet();
		for (Entry<Long, TreeData> entry : set) {
			TreeData tree = entry.getValue();
			TreeData parentTree = modelMap.get(tree.getAttr().getParentId());
			if (parentTree==null){//表示root节点
				TreeDataList.add(tree);
			}else{
				parentTree.getChildren().add(tree);
			}
		}
		return TreeDataList;
	}

	/**
	 * 展示渠道内容
	 */
	public PageBean findAllChannel(Long parentId,int maxResult,int currentPage) {
				    			
			PageBean pageBean=this.tChannelDAO.queryChannel(parentId, maxResult, currentPage);				
			List<NonFinalChannel> nonFinalChannelList=new ArrayList<NonFinalChannel>();	
			List<TChannel> channelList=pageBean.getList();
			for(TChannel channel:channelList){
				NonFinalChannel nonFinalChannel2=new NonFinalChannel();
				nonFinalChannel2.setChildChannel(channel.getChannelName());
				nonFinalChannel2.setRegistUserNum(this.tChannelDAO.findByNonLastChannel(channel.getLevelCode()).size());
				nonFinalChannel2.setEffectGold(this.findByAllgold(this.tChannelDAO.findByNonLastChannel(channel.getLevelCode())));
				nonFinalChannelList.add(nonFinalChannel2);				
			}			
			pageBean.setList(nonFinalChannelList);
											
			return pageBean;
		}		
		
	
	
	/**
	 * 当前id下面的记录数
	 */
	public Long findByRow(Long parentId) {
		
		List<TChannel> resultChannelList=this.tChannelDAO.findParTree(parentId);
		Long rowNum=Long.parseLong(String.valueOf(resultChannelList.size()));
		return rowNum;
	}
	/**
	 * 查询上级的层级code
	 */
	public String findByCode(Long parentId) {
	
		String levelCode=this.tChannelDAO.getById(TChannel.class,parentId).getLevelCode();
		return levelCode;
	}
	
	/**
	 * 判断是否为末级渠道
	 */
	public boolean findLastChannel(TChannel channel) {
		
		List<TChannel> ChannelList=this.tChannelDAO.findByLastChannel(channel.getId());
		
		for(TChannel tChannel : ChannelList){
			
			if(channel.getLevelCode().length()>tChannel.getLevelCode().length()){
							
				return true;
			}
			else {
				
				return false;
			}
			
		}
		return false;
	}
	
	/**
	 * 计算所以金币总数
	 */
	public Long findByAllgold(List<TUserClient> UserClientList) {
		
		Long totalGold=JEEContant.NONGOLDNUM;
		
		for(TUserClient tUser : UserClientList){
			
			 List<TUserGoldCount> goldList=this.tChannelDAO.findByAllGOld(tUser.getId());
			
				for(TUserGoldCount goldCount : goldList){
					
					totalGold+=goldCount.getTotal_gold();
				   }
				
				}
	
		return totalGold;
	}
	
	/**
	 * 根据Id查询渠道
	 */
	public TChannel findByChannel(Long channelId) {
		
		TChannel tChannel=this.tChannelDAO.getById(TChannel.class, channelId);
		String userName=tChannel.getTManagerInfo().getUserName();
		String password=tChannel.getTManagerInfo().getPassword();
	    Long  parentId=tChannel.getTArea().getParentId();
		return tChannel;
	}
	
	/**
	 * 判断渠道名字是否存在
	 */
	public boolean findJudgeChannel(TChannel channel) {
		
		List<TChannel> tChannelList=this.tChannelDAO.findParTree(channel.getParent().getId());
		for(TChannel tChannel: tChannelList){
			
			if(tChannel.getChannelName().equals(channel.getChannelName())){
				
				return true;
				
			}
			else{
				
				return false;
			}
		}
		
		return false;
	}
		/**
		 * 验证渠道（编辑时）
		 * @author yl
		 */
	public boolean checkChannel(String newName,String oldName) {
		if(tChannelDAO.checkChannel(newName,oldName)){
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * 验证账号（编辑时)
	 * @author yl
	 */
	public boolean checkUserName(String newName,String oldName) {
		if(tChannelDAO.checkUserName(newName,oldName)){
			return true;
		}
		else{
			return false;
		}
		
	}
	 /* 
	  * 判断是否有子渠道
	  * @author yl
	  */
	public boolean isHaveChannel(String ids) {
		String[] id = ids.split(",");
		List<Long> idList = new ArrayList<Long>();
		for(String list:id){
			idList.add(Long.valueOf(list));
		}
		boolean flag = tChannelDAO.isHaveChannel(idList);
		if(flag){
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * 删除后台账号（渠道的）
	 * @author yl
	 */
	public void deleteManageInfo(List<Long> idList) {
		tChannelDAO.deleteManageInfo(idList);		
	}
	/**
	 * 根据managerID查询渠道
	 */
	public TChannel findByManagerIdChannel(Long managerId) {
			
		return this.tChannelDAO.findByChannel(managerId);
	}
	public TVersionDAO gettVersionDAO() {
		return tVersionDAO;
	}
	public void settVersionDAO(TVersionDAO tVersionDAO) {
		this.tVersionDAO = tVersionDAO;
	}
	public MailService getMailService() {
		return mailService;
	}
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
	public PackageApkService getPackageApkService() {
		return packageApkService;
	}
	public void setPackageApkService(PackageApkService packageApkService) {
		this.packageApkService = packageApkService;
	}






}
