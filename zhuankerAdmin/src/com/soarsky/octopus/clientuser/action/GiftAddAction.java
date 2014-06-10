package com.soarsky.octopus.clientuser.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.FileCopyUtils;

import com.soarsky.octopus.clientuser.constant.ClientUserContent;
import com.soarsky.octopus.clientuser.service.TGiftService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TGift;

public class GiftAddAction extends BaseAction{

	private static final long serialVersionUID = -5626591437234510875L;
    
	private TGiftService  tGiftService;
	
	private TGift gift;
	
    private File icon;
	
	private String iconFileName;
	
	/**
	 *添加礼物信息
	 *@author lw
	 *@return 
	 */
	public String save() {
		
        String path=this.getUploadPath();
		
		File file=new File(path);		
		if(!file.mkdirs()){			
			file.mkdirs();		
		}	
	    if(icon!=null){	    	
			SimpleDateFormat dform = new SimpleDateFormat("yyyyMMddHHmmssSSS");		
			String date = dform.format(new Date());			
		    String extName = iconFileName.substring(iconFileName.lastIndexOf("."));		    
			String iconName = date+extName;		
			File uploadfile=new File(path,iconName);		
			try{				
				FileCopyUtils.copy(icon, uploadfile);				
			}catch (Exception e) {				
				e.printStackTrace();				
			}
			gift.setGiftUrl("/"+iconName);
	    }
	    
	    gift.setIsRemove(ClientUserContent.NOTROMOVE);
	    
		tGiftService.addGift(gift);
		
		return SUCCESS;
	}
    
	/**
	 * 验证添加礼物
	 * @author lw
	*/
	public void validateSave(){
		
		Boolean isExist=tGiftService.findGiftByName(gift);
		
		if(isExist){
			this.addFieldError("exist.adderror","礼物名已存在");
		}
	}
	
	public TGiftService gettGiftService() {
		return tGiftService;
	}

	public void settGiftService(TGiftService tGiftService) {
		this.tGiftService = tGiftService;
	}

	public TGift getGift() {
		return gift;
	}

	public void setGift(TGift gift) {
		this.gift = gift;
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
