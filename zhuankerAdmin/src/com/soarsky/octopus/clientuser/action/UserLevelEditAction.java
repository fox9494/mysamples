package com.soarsky.octopus.clientuser.action;

import java.io.File;

import org.springframework.util.FileCopyUtils;

import com.soarsky.octopus.clientuser.constant.UserLevelErrorMsg;
import com.soarsky.octopus.clientuser.service.TUserLevelService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TUserLevel;
import com.soarsky.octopus.task.constant.TaskContent;
import com.soarsky.octopus.utils.FileNameGenerator;
import com.soarsky.octopus.utils.PathUtil;

public class UserLevelEditAction extends BaseAction {

	private static final long serialVersionUID = 2602986371829555835L;
    
    private TUserLevelService  tUserLevelService;
    
	private TUserLevel  userLevel;
	
    private File icon;
	
	private String iconFileName;
	
	/**
	 * 初始化赚客级别修改对象
	 * @author lw	
	 * @return
	*/
	public String initUserLevel(){
		
		userLevel=tUserLevelService.initUserLevel(userLevel);
		
		return SUCCESS;
	}
    
	/**
	 * 修改级别对象
	 * @author lw
	 * @return
	*/
	public String editUserLevel(){
		
        String path=PathUtil.getUploadImageBase();
		
		File file=new File(path);		
		if(!file.mkdirs()){			
			file.mkdirs();			
		}		
		if(icon!=null){			
		    String extName = iconFileName.substring(iconFileName.lastIndexOf("."));		    
			String iconName = FileNameGenerator.getFileName()+extName;	
			File uploadfile=new File(path,iconName);			
			try{				
				FileCopyUtils.copy(icon, uploadfile);				
			}catch (Exception e) {				
				e.printStackTrace();				
			}			
			userLevel.setImageUrl(TaskContent.UPLOADIMGPATH+"base/"+iconName);
		}
		
		tUserLevelService.updateUserLevel(userLevel);
		
		return "editsuccess";
	}
	
	/**
	 * 验证修改赚客级别
	 * @author lw
    */
	public void validateEditUserLevel(){
		
		TUserLevel oldUserLevel=tUserLevelService.initUserLevel(userLevel);
		
		if(!userLevel.getName().equals(oldUserLevel.getName())){
			Boolean isExist=tUserLevelService.findUserLevelByName(userLevel);
			if(isExist){
				this.addFieldError(UserLevelErrorMsg.NAMEEXIST,UserLevelErrorMsg.NAMEEXIST_MSG);
			}
		}
		if(!userLevel.getGoldNum().equals(oldUserLevel.getGoldNum())){
			Boolean isGoldExist=tUserLevelService.findUserLevelByGOld(userLevel);
			if(isGoldExist){
				this.addFieldError(UserLevelErrorMsg.GOLDEXIST,UserLevelErrorMsg.GOLDEXIST_MSG);
			}
		}
		if(userLevel.getName().length()<1){
			this.addFieldError(UserLevelErrorMsg.NAME, UserLevelErrorMsg.NAME_MSG);
		}
		if(userLevel.getGoldNum()==null){
			this.addFieldError(UserLevelErrorMsg.GOLD, UserLevelErrorMsg.GOLD_MSG );
		}
	}
	
	public TUserLevelService gettUserLevelService() {
		return tUserLevelService;
	}

	public void settUserLevelService(TUserLevelService tUserLevelService) {
		this.tUserLevelService = tUserLevelService;
	}

	public TUserLevel getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(TUserLevel userLevel) {
		this.userLevel = userLevel;
	}

	public File getIcon() {
		return icon;
	}

	public void setIcon(File icon) {
		this.icon = icon;
	}

	public String getIconFileName() {
		return iconFileName;
	}

	public void setIconFileName(String iconFileName) {
		this.iconFileName = iconFileName;
	}
}
