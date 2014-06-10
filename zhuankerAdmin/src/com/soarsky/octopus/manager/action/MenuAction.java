package com.soarsky.octopus.manager.action;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.service.TManagerInfoService;
import com.soarsky.octopus.mapping.TModelInfo;
import com.soarsky.octopus.utils.BeanHolder;

/**
 * 动态菜单生成
 * @author chenll
 *
 */
public class MenuAction extends BaseAction {
	
	private static final long serialVersionUID = -3742057225293888691L;
	
	
	public String getMenus(String basePath){
		Long uid = (Long)ActionContext.getContext().getSession().get(JEEContant.SESSION_LOGIN_TOKENID);
		
		TManagerInfoService tManagerInfoService = (TManagerInfoService) BeanHolder.getBean("tManagerInfoService");
		List<TModelInfo> list = tManagerInfoService.getAdminUserMenus(uid);
		
		// 申明字符串缓冲区
		StringBuffer sb = new StringBuffer(500);
		sb.append("<ul>");
		if (list!=null&&!list.isEmpty()){
			Set<TModelInfo> set = list.get(0).getModelSet();//排除根节点
			for (TModelInfo tModelInfo : set) {
				//一级菜单生成
				sb.append("<li class='parent'><a href='javascript:;'><img src='"+basePath+tModelInfo.getIcon()+"'/>"+tModelInfo.getName()+"</a>");
				Set<TModelInfo> children = tModelInfo.getModelSet();
				if (children!=null && !children.isEmpty()){
					sb.append(this.generateChildMenu(children,basePath));
				}
				sb.append("</li>");
			}
		}
		sb.append("</ul>");
		return sb.toString();
	}
	
	/**
	 * 递归生存子菜单
	 * @param children
	 * @return
	 */
	private String generateChildMenu(Set<TModelInfo> children,String path){
		StringBuffer sb = new StringBuffer(500);
		sb.append("<ul>");
		if (children!=null&&!children.isEmpty()){
			for (TModelInfo tModelInfo : children) {
				Set<TModelInfo> children_1 = tModelInfo.getModelSet();
				boolean hasChildren = false;
				if (children_1!=null && !children_1.isEmpty()){
					hasChildren=true;
				}
				sb.append("<li class='");
				if (hasChildren){
					sb.append("parent'");
				}else{
					sb.append("child'");
				}
				sb.append("><a href='javascript:;' target='mainFrame' ");
				
				if (hasChildren){
					sb.append("");
				}else{
					sb.append("onclick=\"opentab('"+path+tModelInfo.getUrl()+"','"+tModelInfo.getName()+"')\"");
				}
				sb.append("><img src='"+path+tModelInfo.getIcon()+"'/>"+tModelInfo.getName()+"</a>");
				if (hasChildren){
					sb.append(this.generateChildMenu(children_1,path));
				}
				sb.append("</li>");
			}
		}
		sb.append("</ul>");
		return sb.toString();
	}


}
