package com.soarsky.octopus.channel.vo;

import java.io.Serializable;

public class FlagMsg implements Serializable{
private boolean flag;
private String msg;
public FlagMsg(){
	
}
public boolean isFlag() {
	return flag;
}
public void setFlag(boolean flag) {
	this.flag = flag;
}
public FlagMsg(boolean flag, String msg) {
	super();
	this.flag = flag;
	this.msg = msg;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
}
