package com.soarsky.octopus.mapping;




public class TConfig  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String modelCode ;
     private String key ;
     private String value  ;


    // Constructors

    /** default constructor */
    public TConfig() {
    }

	/** minimal constructor */
    public TConfig(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TConfig(Long id,String modelCode,String key,String value) {
        this.id = id;
        this.modelCode = modelCode;
        this.key = key;
        this.value = value;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

   
}