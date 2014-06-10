package com.soarsky.octopus.mapping;

import java.util.Date;



/**
 * TExchangeLog entity. @author MyEclipse Persistence Tools
 */

public class TExchangeLog  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TUserClient TUserClient;
     private TGift TGift;
     private Integer giftType;
     private Long giftGold;
     private String exchangeDetail;
     private Integer status;
     private String resultDesc;
     private String targetCardNum;
     private String targetAccountName;
     private String targetBankType;
     private Date submitDate;
     
     private Date approvalDate;
     private Date finishDate ;
     


    // Constructors

    /** default constructor */
    public TExchangeLog() {
    }

	/** minimal constructor */
    public TExchangeLog(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TExchangeLog(Long id, TUserClient TUserClient, TGift TGift, Integer giftType, Long giftGold, String exchangeDetail, Integer status, String resultDesc, String targetCardNum, String targetAccountName, String targetBankType) {
        this.id = id;
        this.TUserClient = TUserClient;
        this.TGift = TGift;
        this.giftType = giftType;
        this.giftGold = giftGold;
        this.exchangeDetail = exchangeDetail;
        this.status = status;
        this.resultDesc = resultDesc;
        this.targetCardNum = targetCardNum;
        this.targetAccountName = targetAccountName;
        this.targetBankType = targetBankType;
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

    public TGift getTGift() {
        return this.TGift;
    }
    
    public void setTGift(TGift TGift) {
        this.TGift = TGift;
    }

    public Integer getGiftType() {
        return this.giftType;
    }
    
    public void setGiftType(Integer giftType) {
        this.giftType = giftType;
    }

    public Long getGiftGold() {
        return this.giftGold;
    }
    
    public void setGiftGold(Long giftGold) {
        this.giftGold = giftGold;
    }

    public String getExchangeDetail() {
        return this.exchangeDetail;
    }
    
    public void setExchangeDetail(String exchangeDetail) {
        this.exchangeDetail = exchangeDetail;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResultDesc() {
        return this.resultDesc;
    }
    
    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getTargetCardNum() {
        return this.targetCardNum;
    }
    
    public void setTargetCardNum(String targetCardNum) {
        this.targetCardNum = targetCardNum;
    }

    public String getTargetAccountName() {
        return this.targetAccountName;
    }
    
    public void setTargetAccountName(String targetAccountName) {
        this.targetAccountName = targetAccountName;
    }

    public String getTargetBankType() {
        return this.targetBankType;
    }
    
    public void setTargetBankType(String targetBankType) {
        this.targetBankType = targetBankType;
    }

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
   








}