package com.openframe.sys.role.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openframe.common.controller.BaseController;
import com.openframe.common.page.PageBean;
import com.openframe.exceptions.CustomException;
import com.openframe.sys.role.domain.SysRole;
import com.openframe.sys.role.service.SysRoleService;
import com.openframe.utils.BeanUtil;

@Controller
public class SysRoleController extends BaseController {
	
	@Autowired
	@Qualifier("sysRoleService")
	private SysRoleService sysRoleService;
	
	
	@RequestMapping("/sys/role/roleList")
	public String queryByPage(PageBean paramPage,SysRole role,Model model){
		paramPage.setCondition(BeanUtil.bean2Map(role));
		PageBean pageBean=sysRoleService.queryRolePage(paramPage);
		model.addAttribute("pageBean",pageBean);
		model.addAttribute("role",role);//方便将条件值传回
		return "/sys/role/rolelist";
	}
	
	
	@RequestMapping("/sys/role/initAddRole")
	public String initAddRole(){
		return "/sys/role/roleadd";
	}
	
	@RequestMapping("/sys/role/addRole")
	public ModelAndView addRole(SysRole role){
		if (true) {
			throw new CustomException("错误提示");
		}
		sysRoleService.save(role);
		
		return ajaxDoneSuccess("操作成功");
		
	}

}
