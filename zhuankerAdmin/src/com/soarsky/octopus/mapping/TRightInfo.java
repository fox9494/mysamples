package com.soarsky.octopus.mapping;



/**
 * TRightInfo entity. @author MyEclipse Persistence Tools
 */

public class TRightInfo  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TRoleInfo TRoleInfo;
     private TModelInfo TModelInfo;


    // Constructors

    /** default constructor */
    public TRightInfo() {
    }
    
    public TRightInfo(Long id) {
    	this.id = id;
    }

	/** minimal constructor */

    public TRoleInfo getTRoleInfo() {
        return this.TRoleInfo;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTRoleInfo(TRoleInfo TRoleInfo) {
        this.TRoleInfo = TRoleInfo;
    }

    public TModelInfo getTModelInfo() {
        return this.TModelInfo;
    }
    
    public void setTModelInfo(TModelInfo TModelInfo) {
        this.TModelInfo = TModelInfo;
    }
   








}