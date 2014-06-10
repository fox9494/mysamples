package com.soarsky.octopus.mapping;



/**
 * TGame entity. @author MyEclipse Persistence Tools
 */

public class TGame  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private String url;
     private String icon;


    // Constructors

    /** default constructor */
    public TGame() {
    }

	/** minimal constructor */
    public TGame(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TGame(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
   








}