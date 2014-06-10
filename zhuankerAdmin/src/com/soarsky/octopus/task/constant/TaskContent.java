package com.soarsky.octopus.task.constant;

public class TaskContent {
	
	public final static Integer NOTROMOVE=0;//未删除标示
	
    public final static Integer ROMOVE=1;//逻辑删除标示
    
    public static final String UPLOADAPKPATH="/apk/";//上传APK路径
    
    public static final String UPLOADIMGPATH="/image/";//上传图片路径
    
    public static final int SIZE=1024;
    
    public static final Integer SUMBIT=1;//保存任务标示
    
    public static final Integer SUMBITSPECIALAPK=2;//保存特定分辨率标示
    
    public static final Integer SUMBITCHANNEL=3;//保存渠道筛选标示
    
    public static final int NEETOP=1;//置顶标示
    
    public static final int NOTNEETOP=0;//不置顶标示
    
    public static final String DOWNLOAD="0";//下载
    
    public static final String INSTALL="1";//安装
    
    public static final String ACTIVATE="2";//激活
    
    public static final Integer ADDORDER=0;//订单新增状态标示
}
