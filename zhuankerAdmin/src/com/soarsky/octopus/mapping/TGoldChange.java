package com.soarsky.octopus.mapping;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TGoldChange entity. @author MyEclipse Persistence Tools
 */

public class TGoldChange  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TUserClient TUserClient;
     private Long currentGold;
     private Long currentExchangeNum;
     private Date dealDate;
     private String operateType;
     private TUserTask userTask;


    // Constructors

    /** default constructor */
    public TGoldChange() {
    }

	/** minimal constructor */
    public TGoldChange(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TGoldChange(Long id, TUserClient TUserClient, Long currentGold, Long currentExchangeNum, Date dealDate, String operateType) {
        this.id = id;
        this.TUserClient = TUserClient;
        this.currentGold = currentGold;
        this.currentExchangeNum = currentExchangeNum;
        this.dealDate = dealDate;
        this.operateType = operateType;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public TUserClient getTUserClient() {
        return this.TUserClient;
    }
    
    public void setTUserClient(TUserClient TUserClient) {
        this.TUserClient = TUserClient;
    }

    public Long getCurrentGold() {
        return this.currentGold;
    }
    
    public void setCurrentGold(Long currentGold) {
        this.currentGold = currentGold;
    }

    public Long getCurrentExchangeNum() {
        return this.currentExchangeNum;
    }
    
    public void setCurrentExchangeNum(Long currentExchangeNum) {
        this.currentExchangeNum = currentExchangeNum;
    }

    public Date getDealDate() {
        return this.dealDate;
    }
    
    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public String getOperateType() {
        return this.operateType;
    }
    
    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

	public TUserTask getUserTask() {
		return userTask;
	}

	public void setUserTask(TUserTask userTask) {
		this.userTask = userTask;
	}
}