package com.soarsky.octopus.mapping;

import java.util.HashSet;
import java.util.Set;


/**
 * THobbies entity. @author MyEclipse Persistence Tools
 */

public class THobbies  implements java.io.Serializable {


    // Fields    

     private Long hobbiesid;
     private String tagname;
     private Integer isRemove;
     private Set TUserHobbieses = new HashSet(0);
     private Set TTaskHobbieses = new HashSet(0);


    // Constructors

    /** default constructor */
    public THobbies() {
    }

	/** minimal constructor */
    public THobbies(Long hobbiesid) {
        this.hobbiesid = hobbiesid;
    }
    
    /** full constructor */
    public THobbies(Long hobbiesid, String tagname, Set TUserHobbieses, Set TTaskHobbieses) {
        this.hobbiesid = hobbiesid;
        this.tagname = tagname;
        this.TUserHobbieses = TUserHobbieses;
        this.TTaskHobbieses = TTaskHobbieses;
    }

   
    // Property accessors

    public Long getHobbiesid() {
        return this.hobbiesid;
    }
    
    public void setHobbiesid(Long hobbiesid) {
        this.hobbiesid = hobbiesid;
    }

    public String getTagname() {
        return this.tagname;
    }
    
    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public Set getTUserHobbieses() {
        return this.TUserHobbieses;
    }
    
    public void setTUserHobbieses(Set TUserHobbieses) {
        this.TUserHobbieses = TUserHobbieses;
    }

    public Set getTTaskHobbieses() {
        return this.TTaskHobbieses;
    }
    
    public void setTTaskHobbieses(Set TTaskHobbieses) {
        this.TTaskHobbieses = TTaskHobbieses;
    }

	public Integer getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}
}