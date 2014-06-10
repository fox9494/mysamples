package com.soarsky.octopus.mapping;

import java.util.Date;



public class TLog  implements java.io.Serializable {


	 private Long    id;
	 private String  operator;
	 private String  content;
	 private String  status;
	 private Date    createDate;
	 private String  exceContent;


    // Constructors

    /** default constructor */
    public TLog() {
    }

	/** minimal constructor */
    public TLog(Long id) {
        this.id = id;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getExceContent() {
		return exceContent;
	}

	public void setExceContent(String exceContent) {
		this.exceContent = exceContent;
	}
    
}