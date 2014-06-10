package com.soarsky.octopus.mapping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * TChannel entity. @author MyEclipse Persistence Tools
 */

public class TChannel  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TChannelIndustry TChannelIndustry;
     private TArea TArea;
     private TManagerInfo TManagerInfo;
     private String channelName;
     private TChannel parent;
     private String midcode;
     private String levelCode;
     private Date createDate;
     private Set TTaskChannels = new HashSet(0);
     private Set TChannelInvites = new HashSet(0);
     private Set TUserClients = new HashSet(0);
     
     private String contactPerson ;
     private String mobile;
     private String email;
     private String bank;
     private String bankName;
     private String bankAccount;
     private Double paylevel ;
     private Integer isRemove;
     private String apkUrl;


    // Constructors

    /** default constructor */
    public TChannel() {
    }

	/** minimal constructor */
    
    
   
   
    public TChannel(Long id,
			com.soarsky.octopus.mapping.TChannelIndustry tChannelIndustry,
			com.soarsky.octopus.mapping.TArea tArea,
			com.soarsky.octopus.mapping.TManagerInfo tManagerInfo,
			String channelName, TChannel parent, String midcode,
			String levelCode, Date createDate, Set tTaskChannels,
			Set tChannelInvites) {
		super();
		this.id = id;
		TChannelIndustry = tChannelIndustry;
		TArea = tArea;
		TManagerInfo = tManagerInfo;
		this.channelName = channelName;
		this.parent = parent;
		this.midcode = midcode;
		this.levelCode = levelCode;
		this.createDate = createDate;
		TTaskChannels = tTaskChannels;
		TChannelInvites = tChannelInvites;
	}

	// Property accessors

    public TChannelIndustry getTChannelIndustry() {
        return this.TChannelIndustry;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTChannelIndustry(TChannelIndustry TChannelIndustry) {
        this.TChannelIndustry = TChannelIndustry;
    }

    public TArea getTArea() {
        return this.TArea;
    }
    
    public void setTArea(TArea TArea) {
        this.TArea = TArea;
    }

    public TManagerInfo getTManagerInfo() {
        return this.TManagerInfo;
    }
    
    public void setTManagerInfo(TManagerInfo TManagerInfo) {
        this.TManagerInfo = TManagerInfo;
    }

    public String getChannelName() {
        return this.channelName;
    }
    
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public TChannel getParent() {
		return parent;
	}

	public void setParent(TChannel parent) {
		this.parent = parent;
	}

	public String getMidcode() {
        return this.midcode;
    }
    
    public void setMidcode(String midcode) {
        this.midcode = midcode;
    }

    public String getLevelCode() {
        return this.levelCode;
    }
    
    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set getTTaskChannels() {
        return this.TTaskChannels;
    }
    
    public void setTTaskChannels(Set TTaskChannels) {
        this.TTaskChannels = TTaskChannels;
    }

    public Set getTChannelInvites() {
        return this.TChannelInvites;
    }
    
    public void setTChannelInvites(Set TChannelInvites) {
        this.TChannelInvites = TChannelInvites;
    }

	public Set getTUserClients() {
		return TUserClients;
	}

	public void setTUserClients(Set tUserClients) {
		TUserClients = tUserClients;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Double getPaylevel() {
		return paylevel;
	}

	public void setPaylevel(Double paylevel) {
		this.paylevel = paylevel;
	}

	public Integer getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}

	public String getApkUrl() {
		return apkUrl;
	}

	public void setApkUrl(String apkUrl) {
		this.apkUrl = apkUrl;
	}
   








}