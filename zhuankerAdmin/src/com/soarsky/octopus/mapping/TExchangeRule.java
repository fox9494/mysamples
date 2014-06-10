package com.soarsky.octopus.mapping;

import java.math.BigDecimal;


/**
 * TExchangeRule entity. @author MyEclipse Persistence Tools
 */

public class TExchangeRule  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Long gold;
     private Integer rate;
     private Integer isRemove;

    // Constructors

    /** default constructor */
    public TExchangeRule() {
    }

	/** minimal constructor */
   

   
    // Property accessor

    public Long getGold() {
        return this.gold;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGold(Long gold) {
        this.gold = gold;
    }

    public Integer getRate() {
        return this.rate;
    }
    
    public void setRate(Integer rate) {
        this.rate = rate;
    }

	public Integer getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}
}