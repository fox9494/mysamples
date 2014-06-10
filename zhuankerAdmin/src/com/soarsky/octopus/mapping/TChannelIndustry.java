package com.soarsky.octopus.mapping;

import java.util.HashSet;
import java.util.Set;


/**
 * TChannelIndustry entity. @author MyEclipse Persistence Tools
 */

public class TChannelIndustry  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private Integer isRemove;
	 private Set tCompanies = new HashSet(0);
     private Set tChannels = new HashSet(0);


    // Constructors

    /** default constructor */
    public TChannelIndustry() {
    }

	/** minimal constructor */
   
    
    /** full constructor */
    
   
    // Property accessors

    public String getName() {
        return this.name;
    }
    
    public TChannelIndustry(Long id, String name, Integer isRemove,
			Set tCompanies, Set tChannels) {
		super();
		this.id = id;
		this.name = name;
		this.isRemove = isRemove;
		this.tCompanies = tCompanies;
		this.tChannels = tChannels;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
        this.name = name;
    }

	public Set gettCompanies() {
		return tCompanies;
	}

	public void settCompanies(Set tCompanies) {
		this.tCompanies = tCompanies;
	}

	public Set gettChannels() {
		return tChannels;
	}

	public void settChannels(Set tChannels) {
		this.tChannels = tChannels;
	}
	public Integer getIsRemove() {
			return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
			this.isRemove = isRemove;
	}
}