package com.soarsky.octopus.clientuser.action;

import java.io.File;

import org.springframework.util.FileCopyUtils;

import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.clientuser.constant.UserLevelErrorMsg;
import com.soarsky.octopus.clientuser.service.TUserLevelService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TUserLevel;
import com.soarsky.octopus.task.constant.TaskContent;
import com.soarsky.octopus.utils.FileNameGenerator;
import com.soarsky.octopus.utils.PathUtil;

public class UserLevelAddAction extends BaseAction {

	private static final long serialVersionUID = -6212137187672657931L;
    
    private TUserLevelService  tUserLevelService;
    
	private TUserLevel  userLevel;
	
	private File icon;
	
	private String iconFileName;
	
   /**
    * 添加赚客级别信息
    * @author lw
    * @return
	*/
	public String save(){
		
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
		 
	    userLevel.setIsRemove(ClientUserContent.NOTROMOVE);
	    
		tUserLevelService.addUserLevel(userLevel);
		
		return SUCCESS;
	}
     
	/**
	 * 验证添加赚客级别
	 * @author lw
    */
	public void validateSave() {
		
		boolean isExist=tUserLevelService.findUserLevelByName(userLevel);//判断名称是否已存在
		boolean isGoldExist=tUserLevelService.findUserLevelByGOld(userLevel);//判断金币数是否存在
		
		if(isExist){
			this.addFieldError(UserLevelErrorMsg.NAMEEXIST,UserLevelErrorMsg.NAMEEXIST_MSG);
		}
		if(isGoldExist){
			this.addFieldError(UserLevelErrorMsg.GOLDEXIST,UserLevelErrorMsg.GOLDEXIST_MSG);
		}
		if(userLevel.getName().length()<1){
			this.addFieldError(UserLevelErrorMsg.NAME, UserLevelErrorMsg.NAME_MSG);
		}
		if(icon==null){
			this.addFieldError(UserLevelErrorMsg.IMG, UserLevelErrorMsg.IMG_MSG);
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
