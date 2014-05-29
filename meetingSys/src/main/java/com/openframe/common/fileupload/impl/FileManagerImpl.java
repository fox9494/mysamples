package com.openframe.common.fileupload.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.openframe.common.fileupload.FileManager;
import com.openframe.utils.Identities;

public class FileManagerImpl implements FileManager{

	private String fileDirectory;
	
	public String uploadFile(MultipartFile file) throws IOException{
		String fullName = fileDirectory+"/"+Identities.uuid2();
		File dir=new File(fullName);
		FileUtils.copyInputStreamToFile(file.getInputStream(), dir);
		
		
		return fullName;
	}

	public String getFileDirectory() {
		return fileDirectory;
	}

	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}
}
