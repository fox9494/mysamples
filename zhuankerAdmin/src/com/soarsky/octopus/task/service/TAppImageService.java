package com.soarsky.octopus.task.service;

import java.util.List;

import com.soarsky.octopus.mapping.TAppImage;

public interface TAppImageService{
	
	/**
	 * 批量修改应用图片
	 * @param imgs 图片集合
    */
	public void editAppImg(List<TAppImage> imgs);
	
}
