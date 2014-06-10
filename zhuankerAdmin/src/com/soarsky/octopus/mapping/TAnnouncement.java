package com.soarsky.octopus.mapping;

import java.util.Date;


/**
 * TAnnouncement entity. @author MyEclipse Persistence Tools
 */

public class TAnnouncement  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String title;
     private String description;
     private Date createDate;


    // Constructors

    /** default constructor */
    public TAnnouncement() {
    }

	/** minimal constructor */
    public TAnnouncement(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TAnnouncement(Long id, String title, String description, Date createDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
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
   








}