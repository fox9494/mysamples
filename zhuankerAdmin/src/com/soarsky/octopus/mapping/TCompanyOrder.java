package com.soarsky.octopus.mapping;

import java.util.Date;


/**
 * TCompany entity. @author MyEclipse Persistence Tools
 */

public class TCompanyOrder  implements java.io.Serializable {


    // Fields    

     private Long id;
     
     private TCompany company;
     private Integer type;
     private String  name;
     private Date    startDate;
     private Date    endDate;
     private Double  totalmoney ;
     private Double  unitprice ;
     private Long    totalNumber;
     private Integer state;
     
     private Integer isRemove;
     

    /** default constructor */
    public TCompanyOrder() {
    }

	/** minimal constructor */
    public TCompanyOrder(Long id) {
        this.id = id;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TCompany getCompany() {
		return company;
	}

	public void setCompany(TCompany company) {
		this.company = company;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Long getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Long totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}
    
   
	
}