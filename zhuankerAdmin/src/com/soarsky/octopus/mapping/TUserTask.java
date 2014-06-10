package com.soarsky.octopus.mapping;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TUserTask entity. @author MyEclipse Persistence Tools
 */

public class TUserTask  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TUserClient TUserClient;
     private TTask TTask;
     private Date finishDate;
     private Long goldNum;
     private Boolean isFinished;
     private Integer operateStatus;


    // Constructors

    /** default constructor */
    public TUserTask() {
    }

	/** minimal constructor */
    public TUserTask(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TUserTask(Long id, TUserClient TUserClient, TTask TTask, Date finishDate, Long goldNum, Boolean isFinished, Integer operateStatus) {
        this.id = id;
        this.TUserClient = TUserClient;
        this.TTask = TTask;
        this.finishDate = finishDate;
        this.goldNum = goldNum;
        this.isFinished = isFinished;
        this.operateStatus = operateStatus;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public TUserClient getTUserClient() {
        return this.TUserClient;
    }
    
    public void setTUserClient(TUserClient TUserClient) {
        this.TUserClient = TUserClient;
    }

    public TTask getTTask() {
        return this.TTask;
    }
    
    public void setTTask(TTask TTask) {
        this.TTask = TTask;
    }

    public Date getFinishDate() {
        return this.finishDate;
    }
    
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Long getGoldNum() {
        return this.goldNum;
    }
    
    public void setGoldNum(Long goldNum) {
        this.goldNum = goldNum;
    }

    public Boolean getIsFinished() {
        return this.isFinished;
    }
    
    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    public Integer getOperateStatus() {
        return this.operateStatus;
    }
    
    public void setOperateStatus(Integer operateStatus) {
        this.operateStatus = operateStatus;
    }
   








}