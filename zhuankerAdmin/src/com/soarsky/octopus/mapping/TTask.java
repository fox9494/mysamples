package com.soarsky.octopus.mapping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * TTask entity. @author MyEclipse Persistence Tools
 */

public class TTask  implements java.io.Serializable {


    // Fields    

     private Long taskid;
     private TCompany companyId;
     private String name;
     private Long goldNum;
     private Integer finishCondition;
     private Date endDate;
     private String description;
     private Date createDate;
     private Boolean needTop;
     private Boolean hasFilter;
     private Date updateDate;
     private Integer isRemove;
     private String completeDescription;//完成描述
     private Set TUserTasks = new HashSet(0);
     private Set TTaskChannels = new HashSet(0);
     private Set TTaskHobbieses = new HashSet(0);
     private TApplication app;
     private Set TTaskAttributes = new HashSet(0);
     
     private Integer state;
     private Integer expireState;  //过期标志z
     
     private Long orderId       ;
     private Long totalNumber   ;
     private Long curNumber     ;


    // Constructors

    /** default constructor */
    public TTask() {
    }

	/** minimal constructor */
    public TTask(Long taskid) {
        this.taskid = taskid;
    }
    
    /** full constructor */
    public TTask(Long taskid, TCompany companyId, String name, Long goldNum,
			Integer finishCondition, Date endDate, String description,
			Date createDate, Boolean needTop, Boolean hasFilter,
			Date updateDate, Integer isRemove, Integer isApproval,
			Set tUserTasks, Set tTaskChannels, Set tTaskHobbieses,
			TApplication app, Set tTaskAttributes) {
		super();
		this.taskid = taskid;
		this.companyId = companyId;
		this.name = name;
		this.goldNum = goldNum;
		this.finishCondition = finishCondition;
		this.endDate = endDate;
		this.description = description;
		this.createDate = createDate;
		this.needTop = needTop;
		this.hasFilter = hasFilter;
		this.updateDate = updateDate;
		this.isRemove = isRemove;
		TUserTasks = tUserTasks;
		TTaskChannels = tTaskChannels;
		TTaskHobbieses = tTaskHobbieses;
		this.app = app;
		TTaskAttributes = tTaskAttributes;
	}
     
   
    // Property accessors

    public Long getTaskid() {
        return this.taskid;
    }

	public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public TCompany getCompanyId() {
		return companyId;
	}

	public void setCompanyId(TCompany companyId) {
		this.companyId = companyId;
	}

	public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Long getGoldNum() {
        return this.goldNum;
    }
    
    public void setGoldNum(Long goldNum) {
        this.goldNum = goldNum;
    }

    public Integer getFinishCondition() {
        return this.finishCondition;
    }
    
    public void setFinishCondition(Integer finishCondition) {
        this.finishCondition = finishCondition;
    }

    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getNeedTop() {
        return this.needTop;
    }
    
    public void setNeedTop(Boolean needTop) {
        this.needTop = needTop;
    }

    public Boolean getHasFilter() {
        return this.hasFilter;
    }
    
    public void setHasFilter(Boolean hasFilter) {
        this.hasFilter = hasFilter;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Set getTUserTasks() {
        return this.TUserTasks;
    }
    
    public void setTUserTasks(Set TUserTasks) {
        this.TUserTasks = TUserTasks;
    }

    public Set getTTaskChannels() {
        return this.TTaskChannels;
    }
    
    public void setTTaskChannels(Set TTaskChannels) {
        this.TTaskChannels = TTaskChannels;
    }

    public Set getTTaskHobbieses() {
        return this.TTaskHobbieses;
    }
    
    public void setTTaskHobbieses(Set TTaskHobbieses) {
        this.TTaskHobbieses = TTaskHobbieses;
    }

    public TApplication getApp() {
		return app;
	}

	public void setApp(TApplication app) {
		this.app = app;
	}

	public Set getTTaskAttributes() {
        return this.TTaskAttributes;
    }
    
    public void setTTaskAttributes(Set TTaskAttributes) {
        this.TTaskAttributes = TTaskAttributes;
    }

	public Integer getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Long totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Long getCurNumber() {
		return curNumber;
	}

	public void setCurNumber(Long curNumber) {
		this.curNumber = curNumber;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCompleteDescription() {
		return completeDescription;
	}

	public void setCompleteDescription(String completeDescription) {
		this.completeDescription = completeDescription;
	}

	public Integer getExpireState() {
		return expireState;
	}

	public void setExpireState(Integer expireState) {
		this.expireState = expireState;
	}
}