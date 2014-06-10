package com.soarsky.octopus.mapping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * TCompany entity. @author MyEclipse Persistence Tools
 */

public class TCompany  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TChannelIndustry channelIndustry;
     private TArea area;
     private String name;
     private String phone;
     private String contactName;
     private String address;
     private String email;
     private Date createDate;
     private Integer isRemove;
     private Set tApplications = new HashSet(0);


    // Constructors

    /** default constructor */
    public TCompany() {
    }

	/** minimal constructor */
    public TCompany(Long id) {
        this.id = id;
    }
    
    /** full constructor */

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
	public TCompany(Long id, TChannelIndustry channelIndustry, TArea area,
			String name, String phone, String contactName, String address,
			String email, Date createDate, Integer isRemove, Set tApplications) {
		super();
		this.id = id;
		this.channelIndustry = channelIndustry;
		this.area = area;
		this.name = name;
		this.phone = phone;
		this.contactName = contactName;
		this.address = address;
		this.email = email;
		this.createDate = createDate;
		this.isRemove = isRemove;
		this.tApplications = tApplications;
	}

	public void setId(Long id) {
        this.id = id;
    }
	
	public TChannelIndustry getChannelIndustry() {
		return channelIndustry;
	}

	public void setChannelIndustry(TChannelIndustry channelIndustry) {
		this.channelIndustry = channelIndustry;
	}

	public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactName() {
        return this.contactName;
    }
    
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
	public TArea getArea() {
		return area;
	}

	public void setArea(TArea area) {
		this.area = area;
	}

	public Set gettApplications() {
		return tApplications;
	}

	public void settApplications(Set tApplications) {
		this.tApplications = tApplications;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}
	
}