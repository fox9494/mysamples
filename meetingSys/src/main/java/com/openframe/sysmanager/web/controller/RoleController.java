package com.openframe.sysmanager.web.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openframe.common.controller.PageController;
import com.openframe.common.page.PageBean;
import com.openframe.sysmanager.domain.Role;
import com.openframe.sysmanager.service.RoleService;
import com.openframe.sysmanager.service.TestService;
import com.openframe.sysmanager.web.validator.RoleValidator;

@Controller
public class RoleController extends PageController{
	
	
	@Autowired
	@Qualifier("testService")
	private TestService testService ;
	
	
	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;
	
	/**
	 * 初始化添加页面
	 * @return
	 */
	@RequestMapping(value="/frame/sys/initRoleAdd.do")
	public String initAdd(Model model){
		testService.print();
		return "sysmanager/roleadd";
	}
	
	
    @RequestMapping(value="frame/sys/roleList.do")
	public String queryPage(HttpServletRequest request,HttpServletResponse response,Role role,Map<String, Object> model) {
    	
    	PageBean pageBean = roleService.queryPageUser(this.getPageBean(role, request));
		model.put("pageBean", pageBean);
    	return "sysmanager/rolelist";
		
	}
	

	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping(value="/frame/sys/roleAdd.do")
	public String addForm(@ModelAttribute("role")Role role,BindingResult result){
		new RoleValidator().validate(role, result);
        if (result.hasErrors()) {
            return "sysmanager/roleadd";
        }
		if (role!=null){
			role.setCreateDate(new Date());
			roleService.save(role);
		}
		
		return "redirect:/frame/sys/roleList.do";
	}

}
