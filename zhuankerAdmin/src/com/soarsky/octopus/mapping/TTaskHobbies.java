package com.soarsky.octopus.mapping;



/**
 * TTaskHobbies entity. @author MyEclipse Persistence Tools
 */

public class TTaskHobbies  implements java.io.Serializable {


    // Fields    

     private Long taskhobid;
     private TTask TTask;
     private THobbies THobbies;


    // Constructors

    /** default constructor */
    public TTaskHobbies() {
    }

	/** minimal constructor */

    public TTask getTTask() {
        return this.TTask;
    }
    
    public Long getTaskhobid() {
		return taskhobid;
	}

	public void setTaskhobid(Long taskhobid) {
		this.taskhobid = taskhobid;
	}

	public void setTTask(TTask TTask) {
        this.TTask = TTask;
    }

    public THobbies getTHobbies() {
        return this.THobbies;
    }
    
    public void setTHobbies(THobbies THobbies) {
        this.THobbies = THobbies;
    }
   








}