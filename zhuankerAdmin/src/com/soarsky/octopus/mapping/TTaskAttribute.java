package com.soarsky.octopus.mapping;

import java.math.BigDecimal;


/**
 * TTaskAttribute entity. @author MyEclipse Persistence Tools
 */

public class TTaskAttribute  implements java.io.Serializable {


    // Fields    

     private Long taskattrid;
     private TTask TTask;
     private Long areaId;
     private Integer sex;
     private Integer startAge;
     private Integer endAge;


    // Constructors

    /** default constructor */
    public TTaskAttribute() {
    }

	/** minimal constructor */
    public TTaskAttribute(Long taskattrid) {
        this.taskattrid = taskattrid;
    }
    
    /** full constructor */
    public TTaskAttribute(Long taskattrid, TTask TTask, Integer areaId, Boolean sex, Integer startAge, Integer endAge) {
        this.taskattrid = taskattrid;
        this.TTask = TTask;
        this.startAge = startAge;
        this.endAge = endAge;
    }

   
    // Property accessors

    public Long getTaskattrid() {
        return this.taskattrid;
    }
    
    public void setTaskattrid(Long taskattrid) {
        this.taskattrid = taskattrid;
    }

    public TTask getTTask() {
        return this.TTask;
    }
    
    public void setTTask(TTask TTask) {
        this.TTask = TTask;
    }
    
    public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

    public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getStartAge() {
        return this.startAge;
    }
    
    public void setStartAge(Integer startAge) {
        this.startAge = startAge;
    }

    public Integer getEndAge() {
        return this.endAge;
    }
    
    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }
   








}