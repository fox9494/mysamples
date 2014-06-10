package com.soarsky.octopus.mapping;



/**
 * TUserLevel entity. @author MyEclipse Persistence Tools
 */

public class TUserLevel  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private Long goldNum;
     private String imageUrl;
     private Long reward_num;//升级奖励金币
     private Integer isRemove;

    // Constructors

    /** default constructor */
    public TUserLevel() {
    }

	/** minimal constructor */
    

   
    // Property accessors

    

    public String getName() {
        return this.name;
    }
    
    public TUserLevel(Long id, String name, Long goldNum, String imageUrl,
			Integer isRemove) {
		super();
		this.id = id;
		this.name = name;
		this.goldNum = goldNum;
		this.imageUrl = imageUrl;
		this.isRemove = isRemove;
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

    public Long getGoldNum() {
        return this.goldNum;
    }
    
    public void setGoldNum(Long goldNum) {
        this.goldNum = goldNum;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

	public Integer getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}

	public Long getReward_num() {
		return reward_num;
	}

	public void setReward_num(Long reward_num) {
		this.reward_num = reward_num;
	}
}