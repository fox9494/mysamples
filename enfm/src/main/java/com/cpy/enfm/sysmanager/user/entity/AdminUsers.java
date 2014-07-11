package com.cpy.enfm.sysmanager.user.entity;

import java.util.Date;

public class AdminUsers {
    
    private Integer userId;

    
    private String userAccount;

    
    private String userPassword;

    
    private Date createDate;

    
    private Date editDate;

    
    public Integer getUserId() {
        return userId;
    }

    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    
    public String getUserAccount() {
        return userAccount;
    }

    
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    
    public String getUserPassword() {
        return userPassword;
    }

    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    
    public Date getCreateDate() {
        return createDate;
    }

    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    public Date getEditDate() {
        return editDate;
    }

    
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }
}