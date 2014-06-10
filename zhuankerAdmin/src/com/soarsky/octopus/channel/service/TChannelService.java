package com.soarsky.octopus.channel.service;

import java.util.List;

import com.soarsky.octopus.clientuser.vo.TreeData;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TUserClient;
import com.soarsky.octopus.utils.PageBean;

public interface TChannelService {
	
	/**
	 * 更新实体
	 */
	public void updateChannel(TChannel channel);
	
	
	/**
	 * 根据渠道ID查找渠道
	 * @param
	*/
	public TChannel  initChannel(TChannel tChannel);
	
	/**
	 * 新增渠道
	 * @param 
	 */
	public void addChannel(TChannel tChannel);
    
	/**
	 * 修改渠道
	 * @param 
	 */
	public void modifyChannel(TChannel tChannel);
	
	/**
	 * 删除渠道
	 * @param 
	 */
	public void deleteChannel(Long id);
	
	/**
	 * 分发赚客网
	 * @param
	 */
	public void pushToUser();
	
	/**
	 * 查询当前用户下的所有渠道
	 */
	
	public List<TChannel> findAllChannelByManagerId(Long managerId);
    
	public List<TreeData> findAllChannels();
	
	
	
	/**
	 * 根据id查询渠道信息
	 * @param parentId
	 * @return
	 */
	public TChannel getChannel(Long id);
	
	/**
	 * 根据parenid查询出本级中使用的最大code
	 * @param parentId
	 * @return
	 */
	public String getMaxCode(Long parentId);
	/**
	 * 分页显示一级渠道
	 * @param maxresult
	 * @param currentpage
	 * @return
	 */
	public PageBean findAllFirstChannel(int maxresult,int currentpage);
	/**
	 * 添加一级渠道
	 * @param channel
	 */
	public void saveFirstChannel(TChannel channel);
	/**
	 * 删除一级渠道
	 * @param channel
	 */
	public void deleteFirstChannel(String ids);
	
	/**
	 * 根据渠道id和目标url发送apkurl邮件
	 * @param targetEmail
	 * @param id
	 */
	public void sendEmailByChannel(String targetEmail,Long id);
	/**
	 * 更新一级渠道
	 * @param channel
	 */
	public void editFirstChannel(TChannel channel);
	/**
	 * 根据id查找一级渠道
	 * @param id
	 * @return
	 */
	public TChannel getFirstChannelById(long id);
	/**
	 * 校验是否有相同的一级渠道
	 * @param name 渠道名字
	 * @return
	 */
	public boolean findFirstChannelByName(String name);
	/**
	 * 判断是否含有相同的账号
	 * @param userName
	 * @return
	 */
	public boolean checkManageinfo(String userName);
	/**
	 * 验证一级渠道（编辑时验证）
	 * @param name
	 * @return
	 */
	public boolean checkChannel(String newName,String oldName);
	/**
	 * 验证账号（编辑时验证）
	 * @param name
	 * @return
	 */
	public boolean checkUserName(String newName,String oldName);
	/**
	 * 更新一级渠道时，删除以前的账号
	 * @param id
	 */
	public void deleteOldManageinfo(long id );
	/**
	 * 查找一级渠道的行数
	 * @return
	 */
	public long findRowNumber();
	/**
	 * 计算渠道code
	 * @row 该层下渠道的记录行数
	 * @number 当前添加渠道的层数numer=0表示其他渠道(子渠道)number=1表示一级渠道
	 * @parentId 父级渠道code
	 * @author yl
	 * @return
	 */
	public String getChannelCode(long row,int number,String parentId);
	/**
	 * 根据parentid找到parent
	 * @param id
	 * @return
	 */
	public String getParentArea(long id);
	
	/**
	 * 查询所以渠道
	 * 
	 */
	public List<TreeData> findTree(Long managerId);
	
	
	/**
	 * 查询上级渠道
	 */
	public TChannel findByParent(Long channelId);
	
	/**
	 * 展示渠道的内容
	 */
	public PageBean findAllChannel(Long parentId,int maxResult,int currentPage);
	
	
	/**
	 * 计算当前Id下面的记录数
	 */
	public Long findByRow(Long parentId);
	
	/**
	 * 查询上级的层级code
	 */
	public String findByCode(Long parentId);
	
	/**
	 * 判断是否为末级渠道
	 */
	public boolean findLastChannel(TChannel tChannel);
	
	/**
	 * 算出所以用户的有效金币总数
	 */
	public Long findByAllgold(List<TUserClient> UserClientList);
	/**
	 * 找到根渠道，一级渠道的父节点
	 * @author yl
	 * @return
	 */
	public TChannel getParentChannel();
	
	/**
	 * 根据id查询渠道
	 */
	public TChannel findByChannel(Long channelId);
	
	/**
	 * 判断新增的渠道名字是否存在
	 */
	public boolean findJudgeChannel(TChannel channel);
	
	/**
	 * 根据managerId查询渠道
	 */
	public TChannel findByManagerIdChannel(Long managerId);
	/**
	 * 判断是否有子渠道，如果有则给予提醒
	 * @param idList
	 * @return
	 */
	public boolean isHaveChannel(String ids);
	/**
	 * 批量删除后台账号（渠道的）
	 */
	public void deleteManageInfo(List<Long> idList);
	
	/**
	 * 分页查询所有有效渠道，用于渠道批量打包
	 * @return
	 */
	public PageBean queryPageForPackage(int pageSize,int page);

}
