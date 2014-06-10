package com.soarsky.octopus.manager.action;

import java.util.ArrayList;
import java.util.List;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.manager.vo.Attr;
import com.soarsky.octopus.manager.vo.TreeData;

public class TreeAction extends BaseAction {
	
	private List<TreeData> data;
	
	public String getTree(){
		
		List<TreeData> vo = new ArrayList<TreeData>();
		TreeData n1 = new TreeData();
		n1.setData("四川");
		Attr attr = new Attr();
		attr.setId("1");
		n1.setAttr(attr);
		n1.setState("close");
		List<TreeData> children = new ArrayList<TreeData>();
		TreeData c1 = new TreeData();
		c1.setData("成都");
		Attr attr1 = new Attr();
		attr1.setId("1-1");
		c1.setAttr(attr1);
		children.add(c1);
		
		TreeData c2 = new TreeData();
		c2.setData("德阳");
		Attr attr2 = new Attr();
		attr2.setId("1-2");
		c2.setAttr(attr2);
		children.add(c2);
		
		n1.setChildren(children);
		
		
		TreeData n2 = new TreeData();
		n2.setData("广东");
		Attr attr22 = new Attr();
		attr22.setId("2-1");
		n2.setAttr(attr22);
		
		vo.add(n1);
		vo.add(n2);
		
		data = vo;
		
		
		return SUCCESS;
		
	}

	public List<TreeData> getData() {
		return data;
	}

	public void setData(List<TreeData> data) {
		this.data = data;
	}

}
