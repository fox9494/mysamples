package com.soarsky.octopus.mapping;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;


/**
 * TModelInfo entity. @author MyEclipse Persistence Tools
 */

public class TModelInfo  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private String code;
     private String type;
     private String url;
     
     private String icon;//导航图标
     
     
   //父模块
 	 private TModelInfo  parent;
     private Integer modelOrder;
     private Set tRightInfos = new HashSet(0);
     
     private Set<TModelInfo> modelSet;


    // Constructors

    /** default constructor */
    public TModelInfo() {
    }
    
    
    public TModelInfo(Long id) {
    	this.id=id;
    }

	/** minimal constructor */
    

    public String getName() {
        return this.name;
    }
    
    public TModelInfo(Long id, String name, String code, String type,
			String url, String icon, TModelInfo parent, Integer modelOrder,
			Set tRightInfos, Set<TModelInfo> modelSet) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.type = type;
		this.url = url;
		this.icon = icon;
		this.parent = parent;
		this.modelOrder = modelOrder;
		this.tRightInfos = tRightInfos;
		this.modelSet = modelSet;
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

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }


   

	public Integer getModelOrder() {
		return modelOrder;
	}

	public void setModelOrder(Integer modelOrder) {
		this.modelOrder = modelOrder;
	}

	@JSON(serialize=false)
	public TModelInfo getParent() {
		return parent;
	}

	public void setParent(TModelInfo parent) {
		this.parent = parent;
	}

	@JSON(serialize=false)
	public Set<TModelInfo> getModelSet() {
		return modelSet;
	}

	public void setModelSet(Set<TModelInfo> modelSet) {
		this.modelSet = modelSet;
	}

	@JSON(serialize=false)
	public Set gettRightInfos() {
		return tRightInfos;
	}

	public void settRightInfos(Set tRightInfos) {
		this.tRightInfos = tRightInfos;
	}


	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
   








}