/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2013/3/6 10:44:13                            */
/*==============================================================*/

alter table t_apk
   drop constraint FK_T_APK_APK_APP_R_T_APPLIC;

alter table t_app_image
   drop constraint FK_T_APP_IM_APP_IMAGE_T_APPLIC;

alter table t_application
   drop constraint FK_T_APPLIC_APP_COMPA_T_COMPAN;

alter table t_application
   drop constraint FK_T_APPLIC_APP_TASK__T_TASK;

alter table t_channel
   drop constraint FK_T_CHANNE_REFERENCE_T_AREA;

alter table t_channel
   drop constraint FK_T_CHANNE_REFERENCE_T_MANAGE;

alter table t_channel
   drop constraint FK_T_CHANNE_REFERENCE_T_CHANNE;

alter table t_channel_invite
   drop constraint FK_T_CHANNE_CHANNEL_I_T_CHANNE;

alter table t_client_login_log
   drop constraint FK_T_CLIENT_USER_LOGI_T_USER_C;

alter table t_company
   drop constraint FK_T_COMPAN_COMPANY_A_T_AREA;
   
alter table t_company
   drop constraint FK_T_COMPAN_COMPANY_I_T_CHANNE;

alter table t_download_install_log
   drop constraint FK_T_DOWNLO_DOWNLOAD__T_APPLIC;

alter table t_download_install_log
   drop constraint FK_T_DOWNLO_DOWNLOAD__T_USER_C;

alter table t_exchange_log
   drop constraint FK_T_EXCHAN_EXCHANGE__T_GIFT;

alter table t_exchange_log
   drop constraint FK_T_EXCHAN_EXCHANGE__T_USER_C;

alter table t_gold_change
   drop constraint FK_T_GOLD_C_GOLD_CHAN_T_USER_C;

alter table t_installed_apk
   drop constraint FK_T_INSTAL_INSTALLED_T_USER_C;

alter table t_manager_info
   drop constraint FK_T_MANAGE_MANAGER_I_T_ROLE_I;

alter table t_right_info
   drop constraint FK_T_RIGHT__RIGHT_INF_T_MODEL_;

alter table t_right_info
   drop constraint FK_T_RIGHT__RIGHT_INF_T_ROLE_I;
/* 由于意见反馈可以匿名，注释此外键
*alter table t_suggection
*   drop constraint FK_T_SUGGEC_SUGGESTIO_T_USER_C;
*/
alter table t_system_flow
   drop constraint FK_T_SYSTEM_SYSTEM_FL_T_APPLIC;

alter table t_system_flow
   drop constraint FK_T_SYSTEM_SYSTEM_FL_T_USER_C;

alter table t_task_attribute
   drop constraint FK_T_TASK_A_TASK_ATTR_T_TASK;

alter table t_task_channel
   drop constraint FK_T_TASK_C_REFERENCE_T_TASK;

alter table t_task_channel
   drop constraint FK_T_TASK_C_REFERENCE_T_CHANNE;

alter table t_task_hobbies
   drop constraint FK_T_TASK_H_TASK_HABI_T_HOBBIE;

alter table t_task_hobbies
   drop constraint FK_T_TASK_H_TASK_HOBB_T_TASK;

alter table t_user_client
   drop constraint FK_T_USER_C_USER_AREA_T_AREA;

alter table t_user_gold_count
   drop constraint FK_T_USER_G_USER_GOLD_T_USER_C;

alter table t_user_hobbies
   drop constraint FK_T_USER_H_USER_HOBB_T_HOBBIE;

alter table t_user_hobbies
   drop constraint FK_T_USER_H_USER_HOBB_T_USER_C;

alter table t_user_position
   drop constraint FK_T_USER_P_USER_POSI_T_USER_C;

alter table t_user_task
   drop constraint FK_T_USER_T_USER_TASK_T_TASK;

alter table t_user_task
   drop constraint FK_T_USER_T_USER_TASK_T_USER_C;

drop table t_company_order cascade constraints;

drop table t_announcement cascade constraints;

drop table t_apk cascade constraints;

drop table t_app_image cascade constraints;

drop table t_application cascade constraints;

drop table t_area cascade constraints;

drop table t_channel cascade constraints;

drop table t_channel_industry cascade constraints;

drop table t_channel_invite cascade constraints;

drop table t_client_login_log cascade constraints;

drop table t_company cascade constraints;

drop table t_download_install_log cascade constraints;

drop table t_exchange_log cascade constraints;

drop table t_exchange_rule cascade constraints;

drop table t_game cascade constraints;

drop table t_gift cascade constraints;

drop table t_gold_change cascade constraints;

drop table t_hobbies cascade constraints;

drop table t_installed_apk cascade constraints;

drop table t_manager_info cascade constraints;

drop table t_model_info cascade constraints;

drop table t_right_info cascade constraints;

drop table t_role_info cascade constraints;

drop table t_suggection cascade constraints;

drop table t_system_flow cascade constraints;

drop table t_task cascade constraints;

drop table t_task_attribute cascade constraints;

drop table t_task_channel cascade constraints;

drop table t_task_hobbies cascade constraints;

drop table t_user_client cascade constraints;

drop table t_user_gold_count cascade constraints;

drop table t_user_hobbies cascade constraints;

drop table t_user_level cascade constraints;

drop table t_user_position cascade constraints;

drop table t_user_task cascade constraints;

drop table t_version cascade constraints;

drop table t_professio cascade constraints;

drop table t_client_mobile cascade constraints;

drop table t_config cascade constraints;

drop table t_log cascade constraints;

drop table  t_demand_payment  cascade constraints;

drop table  t_channel_payment  cascade constraints;



create table  t_channel_payment   (
    id                  NUMBER(20)                      not null,
    channel_id          NUMBER(10),
    start_date          DATE,
    end_date            DATE,
    task_statistics     NUMBER(20),
    coin_statistics     NUMBER(20),
    payment_money       NUMBER(14,2),
    payment_date        DATE,
   constraint PK_T_CHANNEL_PAYMENT primary key ( id )
);


/*==============================================================*/
/* Table:  t_demand_payment                                     */
/*==============================================================*/
create table  t_demand_payment   (
    id                  NUMBER(20)                      not null,
    company_id          NUMBER(10),
    task_id             NUMBER(20),
    start_date          DATE,
    end_date            DATE,
    statistics_amount   NUMBER(20),
    approved_amount     NUMBER(20),
    payment_money       NUMBER(14,2),
    payment_date        DATE,
   constraint PK_T_DEMAND_PAYMENT primary key ( id )
);


/*----操作日志表------*/
create table t_log 
(
   ID                 NUMBER(20)           not null,
   operator           VARCHAR2(56),
   content            VARCHAR2(512),
   exceContent        clob,
   status             VARCHAR2(2),
   createDate         date,
   constraint PK_T_LOG primary key (ID)
);

/*----配置表------*/
create table t_config 
(
   ID                 NUMBER(20)           not null,
   modelCode          VARCHAR2(128),
   key                VARCHAR2(50),
   value              VARCHAR2(512),
   constraint PK_T_CONFIG primary key (ID)
);



/*==============================================================*/
/* Table: "t_client_mobile"                                     */
/*==============================================================*/
create table t_client_mobile 
(
   ID                 NUMBER(20)           not null,
   OS                 VARCHAR2(50),
   phonenumber        VARCHAR2(20),
   IMEI                 VARCHAR2(50),
   IMSI                 VARCHAR2(50),
   clientId           NUMBER(20),
   reportDate        Date,
   constraint PK_T_CLIENT_MOBILE primary key (id)
);

comment on table t_client_mobile is
'用户手机基本信息';

/*==============================================================*/
/* Table: t_announcement                                      */
/*==============================================================*/
create table t_announcement 
(
   id                 NUMBER(10)           not null,
   title              VARCHAR2(50),
   description        CLOB,
   create_date        DATE,
   constraint PK_T_ANNOUNCEMENT primary key (id)
);

comment on table t_announcement is
'章鱼网动态表';


create table t_professio
(
   id                 NUMBER(4)            not null,
   name               VARCHAR2(64),
   constraint PK_T_PROFESSIO primary key (id)
);

comment on table t_professio is
'职业表';

/*==============================================================*/
/* Table: t_apk                                               */
/*==============================================================*/
create table t_apk 
(
   id                 NUMBER(15)           not null,
   app_id             NUMBER(10),
   apk_size           NUMBER(20),
   download_url       VARCHAR2(512),
   upload_date        DATE,
   RESOLUTION_WIDTH   number(4),
   RESOLUTION_height   number(4),
   is_default         NUMBER(1),
   constraint PK_T_APK primary key (id)
);

comment on table t_apk is
'apk表';

/*==============================================================*/
/* Table: t_app_image                                         */
/*==============================================================*/
create table t_app_image 
(
   id                 NUMBER(20)           not null,
   apk_id             NUMBER(10),
   image_url          VARCHAR2(512),
   constraint PK_T_APP_IMAGE primary key (id)
);

comment on table t_app_image is
'应用截图表';

/*==============================================================*/
/* Table: t_application                                       */
/*==============================================================*/
create table t_application 
(
   appId              NUMBER(10)           not null,
   taskId             NUMBER(20),
   companyId          NUMBER(10),
   costType           number(1),
   package_name       VARCHAR2(100),
   version            VARCHAR2(10),
   platform             VARCHAR2(50),
   versionrequire       varchar2(80),
   iconUrl              varchar2(512),
   initDownLoad       NUMBER(20),
   description        CLOB,
   rating             VARCHAR2(5),
   appName	          varchar2(50),
   constraint PK_T_APPLICATION primary key (appId)
);

comment on table t_application is
'应用表';

/*==============================================================*/
/* Table: t_area                                              */
/*==============================================================*/
create table t_area 
(
   id                 NUMBER(4)            not null,
   stateName          VARCHAR2(100),
   parent_id          NUMBER(4),
   isremove           NUMBER(1),      /* 判断区域记录是否被删除*/
   constraint PK_T_AREA primary key (id)
);

comment on table t_area is
'区域表';

/*==============================================================*/
/* Table: t_channel                                           */
/*==============================================================*/
create table t_channel 
(
   id                 NUMBER(10)            not null,
   channel_name       VARCHAR2(512),
   industry_id        NUMBER(4),
   areaId             NUMBER(4),
   parentId           NUMBER(10),
   MIDCode            VARCHAR2(512),
   manager_Id         number(4),
   level_code         VARCHAR2(256),
   create_date        DATE,
   contactPerson      varchar2(128),
   mobile             varchar2(32),
   email              varchar2(56),
   bank               varchar2(56),
   bankName           varchar2(128),
   bankAccount        varchar2(128),
   paylevel           NUMBER(6,2),
   apkUrl             varchar2(512),
   isRemove           number(1),
   constraint PK_T_CHANNEL primary key (id)
);

comment on table t_channel is
'渠道表';

comment on column t_channel.level_code is
'1级  0001
2级  00010001
3级  000100010001';

/*==============================================================*/
/* Table: t_channel_industry                                  */
/*==============================================================*/
create table t_channel_industry 
(
   id                 NUMBER(4)            not null,
   name               VARCHAR2(50),
   isremove           NUMBER(4),
   constraint PK_T_CHANNEL_INDUSTRY primary key (id)
);

comment on table t_channel_industry is
'渠道行业表';

/*==============================================================*/
/* Table: t_channel_invite                                    */
/*==============================================================*/
create table t_channel_invite 
(
   id                 NUMBER(15)           not null,
   channel_id         NUMBER(10),
   name               VARCHAR2(50),
   mobile             NUMBER(20),
   email              VARCHAR2(50),
   invite_date        DATE,
   INVITESTATE        Integer,              
   constraint PK_T_CHANNEL_INVITE primary key (id)
);

comment on table t_channel_invite is
'渠道商邀请表';

/*==============================================================*/
/* Table: t_client_login_log                                  */
/*==============================================================*/
create table t_client_login_log 
(
   id                 NUMBER(20)           not null,
   user_id            NUMBER(20),
   login_date         DATE,
   logout_date        DATE,
   constraint PK_T_CLIENT_LOGIN_LOG primary key (id)
);

comment on table t_client_login_log is
'客户端用户登录日志表';

/*==============================================================*/
/* Table: t_company                                           */
/*==============================================================*/
create table t_company 
(
   id                 NUMBER(10)           not null,
   industry_id        NUMBER(4),
   area_id            NUMBER(4),
   name               VARCHAR2(50),
   phone              VARCHAR2(11),
   contact_name       VARCHAR2(50),
   address            VARCHAR2(300),
   email              VARCHAR2(50),
   createdate         DATE,
   isremove           NUMBER(1),
   constraint PK_T_COMPANY primary key (id)
);

comment on table t_company is
'应用提供方表';

create table t_company_order 
(
   id                 NUMBER(20)           not null,
   companyId          NUMBER(10),
   type               NUMBER(1),
   name               VARCHAR2(128),
   startDate		  Date,
   endDate            Date,
   totalmoney         NUMBER(20,2),
   unitprice          NUMBER(10,2),
   totalNumber        NUMBER(20),
   state              NUMBER(1),
   isremove           number(1),
   
   
   constraint PK_T_COMPANY_ORDER primary key (id)
);

/*==============================================================*/
/* Table: t_download_install_log                              */
/*==============================================================*/
create table t_download_install_log 
(
   id                 NUMBER(20)           not null,
   user_id            NUMBER(20),
   app_id             NUMBER(10),
   type               NUMBER(1),
   operate_date       DATE,
   constraint PK_T_DOWNLOAD_INSTALL_LOG primary key (id)
);

comment on table t_download_install_log is
'下载 安装日志表';

/*==============================================================*/
/* Table: t_exchange_log                                      */
/*==============================================================*/
create table t_exchange_log 
(
   id                 NUMBER(20)           not null,
   user_id            NUMBER(20),
   gift_id            NUMBER(10),
   gift_type          NUMBER(2),
   gift_gold          NUMBER(10),
   exchange_detail    VARCHAR2(300),
   status             NUMBER(2),
   result_desc        VARCHAR2(1000),
   target_card_num    varchar2(50),
   target_account_name VARCHAR2(20),
   target_bank_type   VARCHAR2(100),
   submitDate          date,
   approvalDate		    date,
   finishDate          date,
   constraint PK_T_EXCHANGE_LOG primary key (id)
);

comment on table t_exchange_log is
'兑换日志表';

comment on column t_exchange_log.status is
'申请；审批通过；完成；异常';

comment on column t_exchange_log.target_card_num is
'手机号；银行账号；QQ账号';

comment on column t_exchange_log.target_account_name is
'银行账号用户名';

comment on column t_exchange_log.target_bank_type is
'银行名称';

/*==============================================================*/
/* Table: t_exchange_rule                                     */
/*==============================================================*/
create table t_exchange_rule 
(
   id                 NUMBER(4)            not null,
   gold               NUMBER(20),
   rate               NUMBER(4),
   isremove           NUMBER(4),
   constraint PK_T_EXCHANGE_RULE primary key (id)
);

comment on table t_exchange_rule is
'兑换规则表';

/*==============================================================*/
/* Table: t_game                                              */
/*==============================================================*/
create table t_game 
(
   id                 NUMBER(10)           not null,
   name               VARCHAR2(100),
   url                VARCHAR2(512),
   constraint PK_T_GAME primary key (id)
);

comment on table t_game is
'游戏列表';

/*==============================================================*/
/* Table: t_gift                                              */
/*==============================================================*/
create table t_gift 
(
   id                 NUMBER(10)           not null,
   gift_type          NUMBER(2),
   gift_gold          NUMBER(10),
   gift_url           VARCHAR2(512),
   gift_name          VARCHAR2(50),
   gift_price         NUMBER(10),
   exchange_date      DATE,
   isremove           NUMBER(4),
   constraint PK_T_GIFT primary key (id)
);

comment on table t_gift is
'兑换物品表';

/*==============================================================*/
/* Table: t_gold_change                                       */
/*==============================================================*/
create table t_gold_change 
(
   id                 NUMBER(20)           not null,
   user_id            NUMBER(20),
   current_gold       NUMBER(15),
   current_exchange_num NUMBER(10),
   tuser_task_id            NUMBER(20),
   deal_date          DATE,
   operate_type       VARCHAR2(2),
   constraint PK_T_GOLD_CHANGE primary key (id)
);

comment on table t_gold_change is
'金币变化日志';

comment on column t_gold_change.operate_type is
'完成任务；兑换；粉丝所得；游戏所得；游戏所配';

/*==============================================================*/
/* Table: t_hobbies                                           */
/*==============================================================*/
create table t_hobbies 
(
   hobbiesId          NUMBER(4)            not null,
   tagName            VARCHAR2(50),
   isremove           NUMBER(4),
   constraint PK_T_HOBBIES primary key (hobbiesId)
);

comment on table t_hobbies is
'兴趣爱好表';

/*==============================================================*/
/* Table: t_installed_apk                                     */
/*==============================================================*/
create table t_installed_apk 
(
   id                 NUMBER(20)           not null,
   package_name       VARCHAR2(100),
   apk_name           VARCHAR2(50),
   user_id            NUMBER(20),
   version            VARCHAR2(100),
   report_date        date,
   constraint PK_T_INSTALLED_APK primary key (id)
);

comment on table t_installed_apk is
'已安装应用表';

/*==============================================================*/
/* Table: t_manager_info                                      */
/*==============================================================*/
create table t_manager_info 
(
   id                 number(10)           not null,
   user_name          VARCHAR2(128),
   password           VARCHAR2(128),
   real_name          VARCHAR2(128),
   role_id            number(2),
   create_date        DATE,
   isremove            number(1),
   constraint PK_T_MANAGER_INFO primary key (id)
);

comment on table t_manager_info is
'后台用户表
';

/*==============================================================*/
/* Table: t_model_info                                        */
/*==============================================================*/
create table t_model_info 
(
   id                 NUMBER(4)            not null,
   name               VARCHAR2(128),
   code               VARCHAR2(128),
   type               VARCHAR2(1),
   modelOrder         NUMBER(4) ,
   url                VARCHAR2(256),
   parent_id          NUMBER(4),
   icon               VARCHAR2(512),
   constraint PK_T_MODEL_INFO primary key (id)
);

comment on table t_model_info is
'模块表';

comment on column t_model_info.type is
'模块类型 0-菜单,1-非菜单项';

/*==============================================================*/
/* Table: t_right_info                                        */
/*==============================================================*/
create table t_right_info 
(
   id                 NUMBER(6)            not null,
   role_id            NUMBER(2),
   model_id           NUMBER(4),
   constraint PK_T_RIGHT_INFO primary key (id)
);

comment on table t_right_info is
'后台角色权限表
';

/*==============================================================*/
/* Table: t_role_info                                         */
/*==============================================================*/
create table t_role_info 
(
   id                 NUMBER(2)            not null,
   role_name          VARCHAR2(128),
   isRemove			  number(1),
   constraint PK_T_ROLE_INFO primary key (id)
);

comment on table t_role_info is
'后台用户角色表
';

/*==============================================================*/
/* Table: t_suggection                                        */
/*==============================================================*/
create table t_suggection 
(
   id                 NUMBER(20)           not null,
   user_id            NUMBER(20),
   suggection         CLOB,
   mobile             VARCHAR2(20),
   email              VARCHAR2(50),
   replyDate           DATE,
   constraint PK_T_SUGGECTION primary key (id)
);

comment on table t_suggection is
'用户信息反馈表';

/*==============================================================*/
/* Table: t_system_flow                                       */
/*==============================================================*/
create table t_system_flow 
(
   id                 NUMBER(20)           not null,
   use_id             NUMBER(10),
   apk_id             NUMBER(10),
   down_num           NUMBER(20),
   up_num             NUMBER(20),
   report_date        DATE,
   constraint PK_T_SYSTEM_FLOW primary key (id)
);

comment on table t_system_flow is
'系统应用使用流量表';

/*==============================================================*/
/* Table: t_task                                              */
/*==============================================================*/
create table t_task 
(
   taskId             NUMBER(20)           not null,
   company_id         NUMBER(15),
   name               VARCHAR2(50),
   gold_num           NUMBER(10),
   finish_condition   NUMBER(2),
   end_date           DATE,
   description        CLOB,
   create_date        DATE,
   need_top           NUMBER(1),
   has_filter         NUMBER(1),
   update_date        DATE,
   isremove           NUMBER(4),
   appId              NUMBER(10),
   completeDescription VARCHAR2(1000),
   orderId            number(20),
   totalNumber        number(20),
   curNumber          number(20) default 0,
   state              number(1),
   expireState        number(1),
   constraint PK_T_TASK primary key (taskId)
);

comment on table t_task is
'任务表';

comment on column t_task.has_filter is
'便于查询';

/*==============================================================*/
/* Table: t_task_attribute                                    */
/*==============================================================*/
create table t_task_attribute 
(
   taskAttrId         NUMBER(20)           not null,
   task_id            NUMBER(20),
   area_id            NUMBER(4),
   sex                NUMBER(1),
   start_age          NUMBER(3),
   end_age            NUMBER(3),
   constraint PK_T_TASK_ATTRIBUTE primary key (taskAttrId)
);

comment on table t_task_attribute is
'任务属性表';

/*==============================================================*/
/* Table: t_task_channel                                      */
/*==============================================================*/
create table t_task_channel 
(
   id                 NUMBER(20)           not null,
   task_id            NUMBER(20),
   channel_id         NUMBER(10),
   constraint PK_T_TASK_CHANNEL primary key (id)
);

comment on table t_task_channel is
'任务渠道表';

/*==============================================================*/
/* Table: t_task_hobbies                                      */
/*==============================================================*/
create table t_task_hobbies 
(
   taskHobid          NUMBER(4)            not null,
   hobbies_id         NUMBER(4),
   task_id            NUMBER(20),
   constraint PK_T_TASK_HOBBIES primary key (taskHobid)
);

comment on table t_task_hobbies is
'任务爱好表';

/*==============================================================*/
/* Table: t_user_client                                       */
/*==============================================================*/
create table t_user_client 
(
   id                 NUMBER(20)           not null,
   parent_id          NUMBER(20),
   user_name          VARCHAR2(50),
   password           VARCHAR2(128),
   nick_name          VARCHAR2(50),
   area_id            NUMBER(4),
   phone              VARCHAR2(11),
   constellation      VARCHAR2(20),
   midCode            VARCHAR2(20),
   email              VARCHAR2(50),
   register_type      NUMBER(2),
   sex                NUMBER(1),
   shengxiao          NUMBER(2),
   profession         NUMBER(4),
   birthday           DATE,
   isCompelete        NUMBER(1),
   token              VARCHAR2(32),
   channelId		  NUMBER(10),
   apkUrl			  VARCHAR2(512),
   register_date      DATE,
   finished_task_num  NUMBER(10),
   leveCode           VARCHAR2(256),
   age				  number(3),
   invitecode		  number(10),
   constraint PK_T_USER_CLIENT primary key (id)
);

comment on table t_user_client is
'用户总表';

comment on column t_user_client.id is
'用户ID';

comment on column t_user_client.parent_id is
'父ID';

comment on column t_user_client.area_id is
'区域ID';

comment on column t_user_client.midCode is
'唯一标示MID';

comment on column t_user_client.register_type is
'注册方式(渠道推荐，自己注册)';

/*==============================================================*/
/* Table: t_user_gold_count                                   */
/*==============================================================*/
create table t_user_gold_count 
(
   id                 NUMBER(20)           not null,
   user_id            NUMBER(20),
   task_gold          NUMBER(20),
   fans_gold          NUMBER(20),
   game_gold          NUMBER(20),
   current_gold       NUMBER(20),
   total_gold         NUMBER(20),
   constraint PK_T_USER_GOLD_COUNT primary key (id)
);

comment on table t_user_gold_count is
'用户金币统计';

/*==============================================================*/
/* Table: t_user_hobbies                                      */
/*==============================================================*/
create table t_user_hobbies 
(
   id                 NUMBER(4)            not null,
   user_id            NUMBER(20),
   hobbies_id         NUMBER(4),
   constraint PK_T_USER_HOBBIES primary key (id)
);

comment on table t_user_hobbies is
'用户兴趣爱好表';

/*==============================================================*/
/* Table: t_user_level                                        */
/*==============================================================*/
create table t_user_level 
(
   id                 NUMBER(4)            not null,
   name               VARCHAR2(50),
   gold_num           NUMBER(10),
   image_url          VARCHAR2(512),
   reward_num         NUMBER(10),
   isremove           NUMBER(4),
   constraint PK_T_USER_LEVEL primary key (id)
);

comment on table t_user_level is
'章鱼级别';

/*==============================================================*/
/* Table: t_user_position                                     */
/*==============================================================*/
create table t_user_position 
(
   id                 NUMBER(20)           not null,
   user_id            NUMBER(20),
   position           VARCHAR2(300),
   report_date        DATE,
   constraint PK_T_USER_POSITION primary key (id)
);

comment on table t_user_position is
'用户位置信息表';

/*==============================================================*/
/* Table: t_user_task                                         */
/*==============================================================*/
create table t_user_task 
(
   Id                 NUMBER(20)           not null,
   task_id            NUMBER(20),
   user_id            NUMBER(20),
   finish_date        DATE,
   gold_num           NUMBER(10),
   is_finished        NUMBER(1),
   operate_status     NUMBER(1),
   constraint PK_T_USER_TASK primary key (Id)
);

comment on table t_user_task is
'用户 任务表';

/*==============================================================*/
/* Table: t_version                                           */
/*==============================================================*/
create table t_version 
(
   id                 NUMBER(4)            not null,
   version            VARCHAR2(5),
   description        CLOB,
   force_update       NUMBER(1),
   apk_url            VARCHAR2(512),
   upload_date        DATE,
   constraint PK_T_VERSION primary key (id)
);

comment on table t_version is
'章鱼网版本表';

/*==============================================================*/
/* Table: t_game_gold_exchange                                           */
/*==============================================================*/
create table t_game_gold_exchange 
(
   id                 NUMBER(20)            not null,
   user_id            NUMBER(20),
   description        CLOB,
   gold               NUMBER(10),
   operateType        VARCHAR2(2),
   operateDate        DATE,
   constraint PK_T_GAME_GOLD_EXCHANGE primary key (id)
);
comment on table t_game_gold_exchange is
'游戏金币变化表';

/*==============================================================*/
/* Table: t_invite_code                                          */
/*==============================================================*/
create table t_invite_code 
(
   id                 NUMBER(20)            not null,
   invitecode         NUMBER(10),
   constraint PK_T_INVITE_CODE primary key (id)
);
comment on table t_invite_code is
'邀请码对照表';

/*==============================================================*/
/* Table: t_redirect                                            */
/*==============================================================*/
create table t_redirect 
(
   id                 NUMBER(20)            not null,
   redirect_key       VARCHAR2(10),
   redirect_url       VARCHAR2(512),
   constraint PK_T_REDIRECT primary key (id)
);
comment on table t_redirect is
'分享跳转对照表';

alter table t_apk
   add constraint FK_T_APK_APK_APP_R_T_APPLIC foreign key (app_id)
      references t_application (appId);

alter table t_app_image
   add constraint FK_T_APP_IM_APP_IMAGE_T_APPLIC foreign key (apk_id)
      references t_application (appId);

alter table t_application
   add constraint FK_T_APPLIC_APP_COMPA_T_COMPAN foreign key (companyId)
      references t_company (id);

alter table t_application
   add constraint FK_T_APPLIC_APP_TASK__T_TASK foreign key (taskId)
      references t_task (taskId);

alter table t_channel
   add constraint FK_T_CHANNE_REFERENCE_T_AREA foreign key (areaId)
      references t_area (id);

alter table t_channel
   add constraint FK_T_CHANNE_REFERENCE_T_MANAGE foreign key (manager_Id)
      references t_manager_info (id);

alter table t_channel
   add constraint FK_T_CHANNE_REFERENCE_T_CHANNE foreign key (industry_id)
      references t_channel_industry (id);

alter table t_channel_invite
   add constraint FK_T_CHANNE_CHANNEL_I_T_CHANNE foreign key (channel_id)
      references t_channel (id);

alter table t_client_login_log
   add constraint FK_T_CLIENT_USER_LOGI_T_USER_C foreign key (user_id)
      references t_user_client (id);

alter table t_company
   add constraint FK_T_COMPAN_COMPANY_A_T_AREA foreign key (area_id)
      references t_area (id);

alter table t_company
   add constraint FK_T_COMPAN_COMPANY_I_T_CHANNE foreign key (industry_id)
      references t_channel_industry (id);

alter table t_download_install_log
   add constraint FK_T_DOWNLO_DOWNLOAD__T_APPLIC foreign key (app_id)
      references t_application (appId);

alter table t_download_install_log
   add constraint FK_T_DOWNLO_DOWNLOAD__T_USER_C foreign key (user_id)
      references t_user_client (id);

alter table t_exchange_log
   add constraint FK_T_EXCHAN_EXCHANGE__T_GIFT foreign key (gift_id)
      references t_gift (id);

alter table t_exchange_log
   add constraint FK_T_EXCHAN_EXCHANGE__T_USER_C foreign key (user_id)
      references t_user_client (id);

alter table t_gold_change
   add constraint FK_T_GOLD_C_GOLD_CHAN_T_USER_C foreign key (user_id)
      references t_user_client (id);

alter table t_installed_apk
   add constraint FK_T_INSTAL_INSTALLED_T_USER_C foreign key (user_id)
      references t_user_client (id);

alter table t_manager_info
   add constraint FK_T_MANAGE_MANAGER_I_T_ROLE_I foreign key (role_id)
      references t_role_info (id);

alter table t_right_info
   add constraint FK_T_RIGHT__RIGHT_INF_T_MODEL_ foreign key (model_id)
      references t_model_info (id);

alter table t_right_info
   add constraint FK_T_RIGHT__RIGHT_INF_T_ROLE_I foreign key (role_id)
      references t_role_info (id);
/**
*由于意见反馈可以匿名，注释此外键
*alter table t_suggection
*   add constraint FK_T_SUGGEC_SUGGESTIO_T_USER_C foreign key (user_id)
*      references t_user_client (id);
*/
alter table t_system_flow
   add constraint FK_T_SYSTEM_SYSTEM_FL_T_APPLIC foreign key (apk_id)
      references t_application (appId);

alter table t_system_flow
   add constraint FK_T_SYSTEM_SYSTEM_FL_T_USER_C foreign key (use_id)
      references t_user_client (id);

alter table t_task_attribute
   add constraint FK_T_TASK_A_TASK_ATTR_T_TASK foreign key (task_id)
      references t_task (taskId);

alter table t_task_channel
   add constraint FK_T_TASK_C_REFERENCE_T_TASK foreign key (task_id)
      references t_task (taskId);

alter table t_task_channel
   add constraint FK_T_TASK_C_REFERENCE_T_CHANNE foreign key (channel_id)
      references t_channel (id);

alter table t_task_hobbies
   add constraint FK_T_TASK_H_TASK_HABI_T_HOBBIE foreign key (hobbies_id)
      references t_hobbies (hobbiesId);

alter table t_task_hobbies
   add constraint FK_T_TASK_H_TASK_HOBB_T_TASK foreign key (task_id)
      references t_task (taskId);

alter table t_user_client
   add constraint FK_T_USER_C_USER_AREA_T_AREA foreign key (area_id)
      references t_area (id);

alter table t_user_gold_count
   add constraint FK_T_USER_G_USER_GOLD_T_USER_C foreign key (user_id)
      references t_user_client (id);

alter table t_user_hobbies
   add constraint FK_T_USER_H_USER_HOBB_T_HOBBIE foreign key (hobbies_id)
      references t_hobbies (hobbiesId);

alter table t_user_hobbies
   add constraint FK_T_USER_H_USER_HOBB_T_USER_C foreign key (user_id)
      references t_user_client (id);
alter table t_user_position
   add constraint FK_T_USER_P_USER_POSI_T_USER_C foreign key (user_id)
      references t_user_client (id);

alter table t_user_task
   add constraint FK_T_USER_T_USER_TASK_T_TASK foreign key (task_id)
      references t_task (taskId);

alter table t_user_task
   add constraint FK_T_USER_T_USER_TASK_T_USER_C foreign key (user_id)
      references t_user_client (id);
      
      


