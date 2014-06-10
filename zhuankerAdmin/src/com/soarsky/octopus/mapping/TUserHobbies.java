package com.soarsky.octopus.mapping;



/**
 * TUserHobbies entity. @author MyEclipse Persistence Tools
 */

public class TUserHobbies  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TUserClient TUserClient;
     private THobbies THobbies;

    // Constructors

    /** default constructor */
    public TUserHobbies() {
    }

	/** minimal constructor */
    public TUserHobbies(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TUserHobbies(Long id, TUserClient TUserClient, THobbies THobbies) {
        this.id = id;
        this.TUserClient = TUserClient;
        this.THobbies = THobbies;
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

    public THobbies getTHobbies() {
        return this.THobbies;
    }
    
    public void setTHobbies(THobbies THobbies) {
        this.THobbies = THobbies;
    }
}