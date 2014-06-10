package com.soarsky.octopus.common.action;

import java.io.File;

import org.springframework.util.FileCopyUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.soarsky.octopus.utils.FileNameGenerator;
import com.soarsky.octopus.utils.PathUtil;

public class UpLoadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String relativPath;// 相对路径，相对于“从配置中得到的上传文件的基准路径”的路径.如赚客网头像的relativPath为"/image/base"

	private File sourceFile;// 源文件，页面上传的文件

	private String fileUrl;// 文件保存在服务器的相对路径（需要存储到数据库中的url），用于返回

	//private Object data;// 其他可能需要的数据，用于返回

	private String sourceFileFileName;// 上传的文件的实际名字，注意页面的file输入框的name必须是upload

	public String upLoad() {
		
		String path=PathUtil.getUploadBasePath() + relativPath;
		
		File file=new File(path);	
		if(!file.mkdirs()){
		    file.mkdirs();		   	
		}
		
	    if(sourceFile!=null){	    						
		    String extName = sourceFileFileName.substring(sourceFileFileName.lastIndexOf("."));		    
			String fileName = FileNameGenerator.getFileName()+extName;			
			File uploadfile=new File(path,fileName);			
			try{				
				FileCopyUtils.copy(sourceFile, uploadfile);				
			}catch (Exception e) {				
				e.printStackTrace();				
			}
			fileUrl = relativPath+"/"+fileName;//
			return SUCCESS;
		}
	    return INPUT;
	}

	public String getRelativPath() {
		return relativPath;
	}

	public void setRelativPath(String relativPath) {
		this.relativPath = relativPath;
	}

	public File getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

//	public Object getData() {
//		return data;
//	}
//
//	public void setData(Object data) {
//		this.data = data;
//	}

	public String getSourceFileFileName() {
		return sourceFileFileName;
	}

	public void setSourceFileFileName(String sourceFileFileName) {
		this.sourceFileFileName = sourceFileFileName;
	}

}
