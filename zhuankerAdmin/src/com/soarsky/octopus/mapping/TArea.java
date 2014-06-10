package com.soarsky.octopus.mapping;

import java.util.HashSet;
import java.util.Set;


/**
 * TArea entity. @author MyEclipse Persistence Tools
 */

public class TArea  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String statename;
     private Long parentId;
     private Integer isremove;
     private Set TUserClients = new HashSet(0);
     private Set TCompanies = new HashSet(0);
     private Set TChannels = new HashSet(0);


    // Constructors

    /** default constructor */
    public TArea() {
    }

	/** minimal constructor */
   
    // Property accessors

    
    public TArea(Long id, String statename, Long parentId, Integer isremove,
			Set tUserClients, Set tCompanies, Set tChannels) {
		super();
		this.id = id;
		this.statename = statename;
		this.parentId = parentId;
		this.isremove = isremove;
		TUserClients = tUserClients;
		TCompanies = tCompanies;
		TChannels = tChannels;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatename() {
        return this.statename;
    }
    
    public void setStatename(String statename) {
        this.statename = statename;
    }

    public Long getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Set getTUserClients() {
        return this.TUserClients;
    }
    
    public void setTUserClients(Set TUserClients) {
        this.TUserClients = TUserClients;
    }

    public Set getTCompanies() {
        return this.TCompanies;
    }
    
    public void setTCompanies(Set TCompanies) {
        this.TCompanies = TCompanies;
    }

    public Set getTChannels() {
        return this.TChannels;
    }
    
    public void setTChannels(Set TChannels) {
        this.TChannels = TChannels;
    }

	public Integer getIsremove() {
		return isremove;
	}

	public void setIsremove(Integer isremove) {
		this.isremove = isremove;
	}
    
   








}