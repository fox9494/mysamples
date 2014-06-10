package com.soarsky.octopus.mapping;

/**
 * TAppImage entity. @author MyEclipse Persistence Tools
 */

public class TAppImage  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TApplication TApplication;
     private String imageUrl;


    // Constructors

    /** default constructor */
    public TAppImage() {
    }

	/** minimal constructor */
    public TAppImage(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TAppImage(Long id, TApplication TApplication, String imageUrl) {
        this.id = id;
        this.TApplication = TApplication;
        this.imageUrl = imageUrl;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public TApplication getTApplication() {
        return this.TApplication;
    }
    
    public void setTApplication(TApplication TApplication) {
        this.TApplication = TApplication;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}