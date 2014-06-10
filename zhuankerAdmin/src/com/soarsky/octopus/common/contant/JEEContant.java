package com.soarsky.octopus.common.contant;

public class JEEContant {
	
	
	public static String SESSION_LOGIN_TOKENID = "session.security.userId";
	
	
	public static String SESSION_LOGIN_TOKENNAME = "session.security.userName";
	
	public static String SESSION_LOGIN_TOKENREAL = "session.security.realName";
	
	
	public final static Integer NOTROMOVE=0;//未删除标示
		
    public final static Integer ROMOVE=1;//逻辑删除标示

    
    public final static Long   ROOTAREA=Long.valueOf("1");  //区域根节点
    
    public final static String initPassword = "123456";
    //下载安装日志表，0表示下载类型，1表示安装类型
    public final static Integer DOWNLOAD=0;
    public final static Integer INSTALL=1;
    public final static Integer APPROVED=1;//审核通过标示
    
    public final static Integer WAITING=0;//待审核标示
    
    public final static Long  ROOTMODEL=(long) 1;//model根节点初始化标示
    
    public final static Integer COMMONRESOLUTIONAPK=0;//普通分辨率APK标示
    
    public final static Integer SPECIALRESOLUTIONAPK=1;//特定分辨率APK标示
    
    public final static Long MENU = Long.valueOf("0");//菜单项
    
    public final static Long NONEMENU = Long.valueOf("1");//非菜单项
    
    public static final int SIZE=1024;//文件大小
    
    public static final String UPLOADAPKPATH="/apk/"; //路径
    
    //用户兑换常量
    public final static Integer APPLY_EXCHANGE = 0;
    
    public final static Integer APPROVE_EXCHANGE=1;
    
    public final static Integer EXCHANGE_FAIL=2;
    //计算渠道code,0的个数
    public final static Integer ZERO_NUMBERS = 4;
    //一级渠道的层数
    public final static Integer FIRSTCHANNEL_NUMBER=1;
    //代表其他渠道的层次
    public final static Integer OTHERCHANNEL_NUMBER = 0;
    //用户结算状态常量
    public final static Integer APPLY=0;//申请
    
    public final static Integer CHECKED=1;//审核通过
    
    public final static Integer UNCHECKED=2;//审核不通过
    
    public final static Integer SUCCESSED=3;//已完成
    
    public final static Integer EXCEPTION=4;//异常
    
    public final static String PARRTEN="yyyy-MM-dd";
    //添加一级渠道时，默认的角色id
    public final static Long INIT_ROLE=Long.valueOf(2);
    
    public final static Long NONGOLDNUM=(long)0;
    
    public final static Integer LASTCHANNEL=0; //当子节点的个数为0，即为末级渠道
    
    public final static Integer STATUS=5;
    //一级渠道的父节点
    public final static Long PARENTID=Long.valueOf(0);
    
    /**
     * 零级渠道id号，即渠道根节点，这里是赚客网
     */
    public final static Long ZERO_LEVEL_CHANNEL = 1L;
    
    public final static Long INITROLEID=(long)2; //新增渠道初始化用户的角色id
    //表示选择所有
    public final static Integer ALL=-1;
    //如果没有值，那么值为0
    public final static Long INITGOLD=Long.valueOf(0);
    
    public final static String INITLEVEL="奴隶";
    
    public final static Integer OVERDUE =1;//过期标识    
    
    /**
     * 用户任务表，已完成
     */
    public final static boolean FINISHED = true;
    
    /**
     * 用户任务表，未完成
     */
    public final static boolean NO_FINISHED = false;
    
    /**
     * 下拉列表在没有做选择时的默认值
     */
    public final static int SELECT_DEFAULT_VALUE = -1;
    /**
     * 金币兑换比例
     */
    public final static double SHARE_RATIO = 0.01;
    
    //金币日志操作类型 兑换0  游戏1 增加 2 
    public final static String GAME_ADD="0";
    public final static String GAME_REDUCE="1";
    public final static String EXCHANGE="2";
    public final static String TASK_ADD ="3";
    public final static String FANS_ADD="4";
    public final static String BACK_GOLD="9";
    
    
    /**
     * 不能删除的标示
     */
    public final static String DONTREMOVE="notremove";
    
    /**
     * 统计报表类型：下载量统计
     */
    public final static int REPORT_TYPE_DOWNLOAD = 0;
    
    /**
     * 统计报表类型：安装量统计
     */
    public final static int REPORT_TYPE_INSTALL = 1;
    
}
