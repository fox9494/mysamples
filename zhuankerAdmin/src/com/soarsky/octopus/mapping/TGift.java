package com.soarsky.octopus.mapping;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * TGift entity. @author MyEclipse Persistence Tools
 */

public class TGift  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Integer giftType;
     private Long giftGold;
     private String giftUrl;
     private String giftName;
     private double giftPrice;
     private Set TExchangeLogs = new HashSet(0);
     private Integer isRemove;
     private Date exchange_date;

    // Constructors

    /** default constructor */
    public TGift() {
    }

	/** minimal constructor */
    public TGift(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TGift(Long id, Integer giftType, Long giftGold, String giftUrl, String giftName, Set TExchangeLogs) {
        this.id = id;
        this.giftType = giftType;
        this.giftGold = giftGold;
        this.giftUrl = giftUrl;
        this.giftName = giftName;
        this.TExchangeLogs = TExchangeLogs;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGiftType() {
        return this.giftType;
    }
    
    public void setGiftType(Integer giftType) {
        this.giftType = giftType;
    }

    public Long getGiftGold() {
        return this.giftGold;
    }
    
    public void setGiftGold(Long giftGold) {
        this.giftGold = giftGold;
    }

    public String getGiftUrl() {
        return this.giftUrl;
    }
    
    public void setGiftUrl(String giftUrl) {
        this.giftUrl = giftUrl;
    }

    public String getGiftName() {
        return this.giftName;
    }
    
    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

	public double getGiftPrice() {
		return giftPrice;
	}

	public void setGiftPrice(double giftPrice) {
		this.giftPrice = giftPrice;
	}

	public Set getTExchangeLogs() {
		return TExchangeLogs;
	}

	public void setTExchangeLogs(Set tExchangeLogs) {
		TExchangeLogs = tExchangeLogs;
	}

	public Integer getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}

	public Date getExchange_date() {
		return exchange_date;
	}

	public void setExchange_date(Date exchange_date) {
		this.exchange_date = exchange_date;
	}
}