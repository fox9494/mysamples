package com.soarsky.octopus.channel.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.FileCopyUtils;

import com.soarsky.octopus.channel.contant.ChannelInviteErrorMsg;
import com.soarsky.octopus.channel.service.TChannelInviteService;
import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.mapping.TChannelInvite;
import com.soarsky.octopus.utils.FileNameGenerator;
import com.soarsky.octopus.utils.PathUtil;

public class ChannelInviteAddAction extends BaseAction {
	

	private static final long serialVersionUID = 8461083943864585246L;
    
	private TChannelInviteService tChannelInviteService;
	
	private TChannelInvite channelInvite;
	
	private TChannelService  tChannelService;
	
	private Long channelId;
	
	private File excel;
	
	private String excelFileName;
	
	private String modelError;
	/**
	 * 添加推送信息
	 * @author lw
	 * @return
	*/
	public String save(){
		
		//channel=tChannelService.findByParent(channelId);
		
		if(excel!=null){
			List<TChannelInvite> channelInvites=this.uploadExcel();
			if(channelInvites!=null&&channelInvites.size()>0){
				//导入EXCEL进行批量推送
				tChannelInviteService.addBatchChannelInvite(channelInvites);
				//发送邮件
				if (channelInvites!=null&&!channelInvites.isEmpty()){
					for (TChannelInvite tChannelInvite : channelInvites) {
						tChannelService.sendEmailByChannel(tChannelInvite.getEmail(), channelId);
					}
				}				
			}else{
				modelError="请上传标准的推送模版";
				return INPUT;
			}
		}
		if(StringUtils.isNotEmpty(channelInvite.getName())){
			//进行单个推送
			 channelInvite.setInviteDate(new Date());
			 TChannel channel=new TChannel();
			 channel.setId(channelId);
			//设置推送渠道
			 channelInvite.setTChannel(channel);
			 tChannelInviteService.addChannelInvite(channelInvite);
			 
			 //发送邮件
			 tChannelService.sendEmailByChannel(channelInvite.getEmail(), channelId);
			
		}
		return SUCCESS;
	}
	
	/**
	 * 读取excel里的数据内容
	 * @author lw
	 * @return
	*/
	public List<TChannelInvite> uploadExcel(){
		
		List<TChannelInvite>channelInvites=new ArrayList<TChannelInvite>();
		
		String realPath=PathUtil.getUploadExcel();
        File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		FileInputStream fs=null;
		BufferedInputStream bs=null;
		try {
			String extName = excelFileName.substring(excelFileName.lastIndexOf("."));
			String excelName = FileNameGenerator.getFileName()+extName;
			//上传excel文件
			File uploadfile=new File(realPath,excelName);
			FileCopyUtils.copy(excel, uploadfile);
			
			//创建输入缓存流
			fs=new FileInputStream(realPath+"\\"+excelName);
			bs=new BufferedInputStream(fs);
			
			//上传XLS模版
			if(extName.equals(".xls")){
				channelInvites=this.uploadExcelXLS(bs);
			}else{
				//上传XLSX模版
				channelInvites=this.uploadExcelXLSX(bs);
			}
        } catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			 try {
				bs.close();
				fs.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			} 
		}
		return channelInvites;
	}
    
	/**
	 * 验证模版是否正确
	 * @author liwei
	 * @return
	*/
	public Boolean hasErrorModel(Sheet sheet){
		
		Row row= sheet.getRow(0);
		if(row!=null){
			Iterator<Cell> cells=row.cellIterator();
			while(cells.hasNext()){
				Cell cell=cells.next();
				
				if(cell.getColumnIndex()==0){
				  if(!cell.getStringCellValue().equals("姓名")){
					 this.addFieldError(ChannelInviteErrorMsg.CHANNELINVITE, ChannelInviteErrorMsg.CHANNELINVITE_MSG); 
				  }
				}else if(cell.getColumnIndex()==1){
				  if(!cell.getStringCellValue().equals("电话号码")){
					  this.addFieldError(ChannelInviteErrorMsg.CHANNELINVITE, ChannelInviteErrorMsg.CHANNELINVITE_MSG);  
				  }
				}else if(cell.getColumnIndex()==2){
				  if(!cell.getStringCellValue().equals("邮箱")){
					  this.addFieldError(ChannelInviteErrorMsg.CHANNELINVITE, ChannelInviteErrorMsg.CHANNELINVITE_MSG); 
				  }
				}else if(cell.getColumnIndex()>2){	
					this.addFieldError(ChannelInviteErrorMsg.CHANNELINVITE, ChannelInviteErrorMsg.CHANNELINVITE_MSG); 
				}
			}
		 }else{
			 this.addFieldError(ChannelInviteErrorMsg.CHANNELINVITE, ChannelInviteErrorMsg.CHANNELINVITE_MSG);  
		 }
		 return this.hasFieldErrors();
	}
	
	/**
	 * 上传XLS的模版
	 * @author lw
	 * @return
	*/
	public List<TChannelInvite> uploadExcelXLS(BufferedInputStream bs){
		
		List<TChannelInvite>channelInvites=new ArrayList<TChannelInvite>();
		try {
			//生成POIFSFileSystem对象
			POIFSFileSystem pf = new POIFSFileSystem(bs);
			//得到EXCEL对象
			HSSFWorkbook hw=new HSSFWorkbook(pf);
			//得到的第一个工作簿
			HSSFSheet sheet=hw.getSheetAt(0);
			
			//判断EXCEL是否为标准模版
			if(this.hasErrorModel(sheet)){
				return null;
			}
			
			//得到所有有效行数
			int  rowsum=sheet.getPhysicalNumberOfRows();
			//迭代所有row
			for(int index=1;index<rowsum;index++){
				//判断该行是否是有效行
				Boolean logic=false;
				//创建推送对象
				TChannelInvite excelChannInvite=new TChannelInvite();
				
				//得到cell迭代器
				Iterator<Cell> cells=sheet.getRow(index).cellIterator();
				//迭代所有cell
				while(cells.hasNext()){
					HSSFCell cell=(HSSFCell)cells.next();
					//设置推送名
					if(cell.getColumnIndex()==0){
						excelChannInvite.setName(cell.getStringCellValue());
					//设置推送电话号码	
					}else if(cell.getColumnIndex()==1){
						Double mobile=new Double(cell.getNumericCellValue());
						excelChannInvite.setMobile(mobile.longValue());
					//设置推送邮箱
					}else if(cell.getColumnIndex()==2){
						if(StringUtils.isBlank(cell.getStringCellValue())){
							logic=true;
							continue ;
						}
						excelChannInvite.setEmail(cell.getStringCellValue());
					}
				 }
				 if(logic){
					 break;
				 }
				 //创建渠道对象
				 TChannel channel=new TChannel();
				 channel.setId(channelId);
				 //设置推送渠道
				 excelChannInvite.setTChannel(channel);
				 //设置推送时间
				 excelChannInvite.setInviteDate(new Date());
				 channelInvites.add(excelChannInvite);
			  }	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    return channelInvites;
	}
	
	/**
	 * 上传XLSX的模版
	 * @author lw
	 * @return
	*/
	public List<TChannelInvite> uploadExcelXLSX(BufferedInputStream bs){
		
		List<TChannelInvite>channelInvites=new ArrayList<TChannelInvite>();
		try{
			//得到EXCEL对象
			XSSFWorkbook hw=new XSSFWorkbook(bs);
			//得到的第一个工作簿
		    XSSFSheet sheet=hw.getSheetAt(0);
			
			//判断EXCEL是否为标准模版
			if(this.hasErrorModel(sheet)){
				return null;
			}
			
			//得到所有有效行数
			int  rowsum=sheet.getPhysicalNumberOfRows();
			//迭代所有row
			for(int index=1;index<rowsum;index++){
				//判断该行是否是有效行
				Boolean logic=false;
				//创建推送对象
				TChannelInvite excelChannInvite=new TChannelInvite();
				
				//得到cell迭代器
				Iterator<Cell> cells=sheet.getRow(index).cellIterator();
				//迭代所有cell
				while(cells.hasNext()){
					XSSFCell cell=(XSSFCell)cells.next();
					//设置推送名
					if(cell.getColumnIndex()==0){
						excelChannInvite.setName(cell.getStringCellValue());
					//设置推送电话号码	
					}else if(cell.getColumnIndex()==1){
						Double mobile=new Double(cell.getNumericCellValue());
						excelChannInvite.setMobile(mobile.longValue());
					//设置推送邮箱
					}else if(cell.getColumnIndex()==2){
						if(StringUtils.isBlank(cell.getStringCellValue())){
							logic=true;
							continue ;
						}
						excelChannInvite.setEmail(cell.getStringCellValue());
					}
				 }
				 if(logic){
					 break;
				 }
				 //创建渠道对象
				 TChannel channel=new TChannel();
				 channel.setId(channelId);
				 //设置推送渠道
				 excelChannInvite.setTChannel(channel);
				 //设置推送时间
				 excelChannInvite.setInviteDate(new Date());
				 channelInvites.add(excelChannInvite);
			  }	
        } catch (IOException e) {	
			e.printStackTrace();
		}
		return channelInvites;
	}
	
	public File getExcel() {
		return excel;
	}

	public void setExcel(File excel) {
		this.excel = excel;
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public TChannelInviteService gettChannelInviteService() {
		return tChannelInviteService;
	}

	public void settChannelInviteService(TChannelInviteService tChannelInviteService) {
		this.tChannelInviteService = tChannelInviteService;
	}

	public TChannelInvite getChannelInvite() {
		return channelInvite;
	}

	public void setChannelInvite(TChannelInvite channelInvite) {
		this.channelInvite = channelInvite;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}


	public TChannelService gettChannelService() {
		return tChannelService;
	}

	public void settChannelService(TChannelService tChannelService) {
		this.tChannelService = tChannelService;
	}

	public String getModelError() {
		return modelError;
	}

	public void setModelError(String modelError) {
		this.modelError = modelError;
	}
}
