package com.soarsky.octopus.clientuser.action;

import com.soarsky.octopus.clientuser.service.TGiftService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TGift;

public class GiftDeleteAction extends BaseAction {

	private static final long serialVersionUID = -6931653478862333149L;
    
    private TGiftService  tGiftService;
	
	private TGift gift;
	
	private String info;
	
	/**
	 * 删除礼物信息
	 * @author lw
	 * @return
	*/
	public String delete(){
		
		String[]id=info.split(",");
		
		for(int i=0;i<id.length;i++){
			
			TGift gift=new TGift();
			
			gift.setId(Long.valueOf(id[i]));
			
			tGiftService.deleteGift(gift);
			
		}
		return SUCCESS;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
