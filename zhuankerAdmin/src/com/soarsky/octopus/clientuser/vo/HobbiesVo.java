package com.soarsky.octopus.clientuser.vo;

public class HobbiesVo {
	private Long hobbiesid;
    private String tagname;
    private Integer isRemove;
    
	public HobbiesVo() {

	}
	public HobbiesVo(Long hobbiesid, String tagname, Integer isRemove) {
		super();
		this.hobbiesid = hobbiesid;
		this.tagname = tagname;
		this.isRemove = isRemove;
	}
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public Integer getIsRemove() {
		return isRemove;
	}
	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}
	public Long getHobbiesid() {
		return hobbiesid;
	}
	public void setHobbiesid(Long hobbiesid) {
		this.hobbiesid = hobbiesid;
	}
}
