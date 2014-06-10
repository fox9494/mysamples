package com.soarsky.octopus.mapping;

import java.math.BigDecimal;
import java.util.Date;


/**
 * TChannelInvite entity. @author MyEclipse Persistence Tools
 */

public class TChannelInvite  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TChannel TChannel;
     private String name;
     private Long mobile;
     private String email;
     private Date inviteDate;
     
     private Integer inviteState;


    // Constructors

    /** default constructor */
    public TChannelInvite() {
    }

	/** minimal constructor */
    public TChannelInvite(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TChannelInvite(Long id, TChannel TChannel, String name, Long mobile, String email, Date inviteDate) {
        this.id = id;
        this.TChannel = TChannel;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.inviteDate = inviteDate;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public TChannel getTChannel() {
        return this.TChannel;
    }
    
    public void setTChannel(TChannel TChannel) {
        this.TChannel = TChannel;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Long getMobile() {
        return this.mobile;
    }
    
    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getInviteDate() {
        return this.inviteDate;
    }
    
    public void setInviteDate(Date inviteDate) {
        this.inviteDate = inviteDate;
    }

	public Integer getInviteState() {
		return inviteState;
	}

	public void setInviteState(Integer inviteState) {
		this.inviteState = inviteState;
	}
   








}