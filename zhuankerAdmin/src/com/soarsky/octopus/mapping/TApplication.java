package com.soarsky.octopus.mapping;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


/**
 * TApplication entity. @author MyEclipse Persistence Tools
 */

public class TApplication  implements java.io.Serializable {


    // Fields    

     private Long appid;
     
     private TTask  task;
     
     private TCompany company;
     
     private Integer  costType;
     private String   package_name;
     private String   version  ;
     private String   platform;
     private String   versionrequire;
     private String   iconUrl;
     private Long     initDownLoad;
     private String   description;
     private String   rating;
     
     private String appName;
     
     private Set tApks = new HashSet(0);
     private Set tAppImages = new HashSet(0);


    // Constructors

    /** default constructor */
    public TApplication() {
    }

	/** minimal constructor */
    public TApplication(Long appid) {
        this.appid = appid;
    }

	public Long getAppid() {
		return appid;
	}

	public void setAppid(Long appid) {
		this.appid = appid;
	}

	public TTask getTask() {
		return task;
	}

	public void setTask(TTask task) {
		this.task = task;
	}

	public TCompany getCompany() {
		return company;
	}

	public void setCompany(TCompany company) {
		this.company = company;
	}

	public Integer getCostType() {
		return costType;
	}

	public void setCostType(Integer costType) {
		this.costType = costType;
	}

	public String getPackage_name() {
		return package_name;
	}

	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getVersionrequire() {
		return versionrequire;
	}

	public void setVersionrequire(String versionrequire) {
		this.versionrequire = versionrequire;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Long getInitDownLoad() {
		return initDownLoad;
	}

	public void setInitDownLoad(Long initDownLoad) {
		this.initDownLoad = initDownLoad;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Set gettApks() {
		return tApks;
	}

	public void settApks(Set tApks) {
		this.tApks = tApks;
	}

	public Set gettAppImages() {
		return tAppImages;
	}

	public void settAppImages(Set tAppImages) {
		this.tAppImages = tAppImages;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
    
   
   
}