package com.openframe.sysmanager.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmock.auto.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.openframe.common.controller.PageController;
import com.openframe.common.fileupload.FileManager;
import com.openframe.common.page.PageBean;
import com.openframe.sysmanager.domain.User;
import com.openframe.sysmanager.service.UserService;

@Controller
@RequestMapping()
public class UserController extends PageController{

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("fileManager")
	private FileManager fileManager;//注入文件处理类
	
	
	/**
	 * 分页查询
	 * @param request
	 * @param response
	 * @param obj
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value="/frame/sys/userList.do")
	public String queryPageUser(HttpServletRequest request,HttpServletResponse response,User user,Map<String, Object> model){
		PageBean pageBean = userService.queryPageUser(this.getPageBean(user, request));
		model.put("pageBean", pageBean);
		return "sysmanager/userlist";
	}
	
	
	@RequestMapping(value="/frame/sys/initAddUser.do")
	public String initAddUser(){
		return "sysmanager/useradd";
	}
	
	
	/**
	 * 添加用户，包括多文件上传
	 * @param model
	 * @param files
	 * @param idcard
	 * @param user
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/frame/sys/adduser.do")
	
	public String addUser(Map<String, Object> model,@RequestParam("pictureFile") MultipartFile[] files,@RequestParam("idCard") MultipartFile idcard,User user) throws IOException{
	    for (MultipartFile file : files) {
			if (!file.isEmpty()){
				String path = fileManager.uploadFile(file);
				user.setLastLogindate(new Date());
				userService.add(user);
			}
		}
	    
		model.put("user", user);
		return "add";
	}
	
	
	@RequestMapping(value="/owners/{ownerId}", method=RequestMethod.GET)
	public String findOwner(@PathVariable String ownerId, Model model) {
//	  Owner owner = ownerService.findOwner(ownerId);
//	  model.addAttribute("owner", owner);
	  return "displayOwner";
	}
	
	@RequestMapping(value="/frame/sys/listone.do")
	public String queryUser(Map<String, Object> model,@RequestParam("userId") String userId){
		User user = userService.queryOne(userId);
		model.put("user", user);
		return "add";
	}
}
