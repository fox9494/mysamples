package com.openframe.common.fileupload;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileManager {
	
	public String uploadFile(MultipartFile file) throws IOException;

}
