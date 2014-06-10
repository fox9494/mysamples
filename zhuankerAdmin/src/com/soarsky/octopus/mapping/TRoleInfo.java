package com.soarsky.octopus.mapping;

import java.util.HashSet;
import java.util.Set;


/**
 * TRoleInfo entity. @author MyEclipse Persistence Tools
 */

public class TRoleInfo  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String roleName;
     private Set TManagerInfos = new HashSet(0);
     private Set TRightInfos = new HashSet(0);
     
     private Integer isRemove;


    // Constructors

    /** default constructor */
    public TRoleInfo() {
    }
    
    public TRoleInfo(Long id) {
    	this.id=id;
    }

	/** minimal constructor */

    public String getRoleName() {
        return this.roleName;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set getTManagerInfos() {
        return this.TManagerInfos;
    }
    
    public void setTManagerInfos(Set TManagerInfos) {
        this.TManagerInfos = TManagerInfos;
    }

    public Set getTRightInfos() {
        return this.TRightInfos;
    }
    
    public void setTRightInfos(Set TRightInfos) {
        this.TRightInfos = TRightInfos;
    }

	public Integer getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}
   








}