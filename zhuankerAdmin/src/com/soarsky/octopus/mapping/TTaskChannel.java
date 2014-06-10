package com.soarsky.octopus.mapping;

import java.math.BigDecimal;


/**
 * TTaskChannel entity. @author MyEclipse Persistence Tools
 */

public class TTaskChannel  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TTask TTask;
     private TChannel TChannel;


    // Constructors

    /** default constructor */
    public TTaskChannel() {
    }

	/** minimal constructor */
    public TTaskChannel(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TTaskChannel(Long id, TTask TTask, TChannel TChannel) {
        this.id = id;
        this.TTask = TTask;
        this.TChannel = TChannel;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public TTask getTTask() {
        return this.TTask;
    }
    
    public void setTTask(TTask TTask) {
        this.TTask = TTask;
    }

    public TChannel getTChannel() {
        return this.TChannel;
    }
    
    public void setTChannel(TChannel TChannel) {
        this.TChannel = TChannel;
    }
   








}