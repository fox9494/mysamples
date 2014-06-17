package com.institute.meeting.common.entity;


import java.io.Serializable;


/**
 * 适配ztree树结构模型
 * @author chenll
 */
public class TreeModel implements Serializable{
	
	private String id;  //节点id
	
	private String pId;  //节点所属父id 
	
	private String name; //节点名称
	
	private boolean open = true;  //表示树节点是否展开
	
	private boolean checked=false;
	
	private boolean isLeaf=false;//是否是叶子节点

	private String code; //权限时存的code
	

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}


	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	
	
	

}
