package com.soarsky.octopus.mapping;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TInstalledApk entity. @author MyEclipse Persistence Tools
 */

public class TClientMobile  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String os;
     private String phoneNumber;
     private String imei;
     private String imsi;
     private TUserClient  tUserClient;
     private Date reportDate;
     
     


    // Constructors

    /** default constructor */
    public TClientMobile() {
    }

	/** minimal constructor */
    public TClientMobile(Long id) {
        this.id = id;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public TUserClient gettUserClient() {
		return tUserClient;
	}

	public void settUserClient(TUserClient tUserClient) {
		this.tUserClient = tUserClient;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
    

   






}