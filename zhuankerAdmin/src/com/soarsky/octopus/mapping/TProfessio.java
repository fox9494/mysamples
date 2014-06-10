package com.soarsky.octopus.mapping;




public class TProfessio  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;


    // Constructors

    /** default constructor */
    public TProfessio() {
    }

	/** minimal constructor */
   
	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
    

   



}