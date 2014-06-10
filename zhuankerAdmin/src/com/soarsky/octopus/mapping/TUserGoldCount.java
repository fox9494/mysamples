package com.soarsky.octopus.mapping;



/**
 * TUserGoldCount entity. @author MyEclipse Persistence Tools
 */

public class TUserGoldCount  implements java.io.Serializable {


    // Fields    

     private Long id;
     private TUserClient TUserClient;
     private Long taskGold;
     private Long fansGold;
     private Long gameGold;
     private Long currentGold;
     private Long total_gold;


    // Constructors

    /** default constructor */
    public TUserGoldCount() {
    }

	/** minimal constructor */
    public TUserGoldCount(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public TUserGoldCount(Long id, TUserClient TUserClient, Long taskGold, Long fansGold, Long gameGold, Long currentGold) {
        this.id = id;
        this.TUserClient = TUserClient;
        this.taskGold = taskGold;
        this.fansGold = fansGold;
        this.gameGold = gameGold;
        this.currentGold = currentGold;
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

    public Long getTaskGold() {
        return this.taskGold;
    }
    
    public void setTaskGold(Long taskGold) {
        this.taskGold = taskGold;
    }

    public Long getFansGold() {
        return this.fansGold;
    }
    
    public void setFansGold(Long fansGold) {
        this.fansGold = fansGold;
    }

    public Long getGameGold() {
        return this.gameGold;
    }
    
    public void setGameGold(Long gameGold) {
        this.gameGold = gameGold;
    }

    public Long getCurrentGold() {
        return this.currentGold;
    }
    
    public void setCurrentGold(Long currentGold) {
        this.currentGold = currentGold;
    }

	public Long getTotal_gold() {
		return total_gold;
	}

	public void setTotal_gold(Long total_gold) {
		this.total_gold = total_gold;
	}
   








}