DROP DATABASE IF EXISTS `meeting`;
CREATE DATABASE `meeting` ;
create user 'meeting'@'%' IDENTIFIED by  'meeting';
GRANT ALL ON meeting.* to 'meeting'@'%';
USE `meeting`;

##后台用户表
DROP TABLE IF EXISTS `t_adminusers`;
CREATE TABLE `t_adminusers` (
  `UserID` int(11) NOT NULL auto_increment,
  `UserAccount` varchar(50) default NULL,
  `UserPassword` varchar(50) default NULL,
  `CreateDate` datetime default NULL,
  `EditDate` datetime default NULL,
  PRIMARY KEY  (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

##后台用户角色表
DROP TABLE IF EXISTS `t_adminusers_role`;
CREATE TABLE `t_adminusers_role` (
  `UserRoleID` int(11) NOT NULL auto_increment,
  `userId` int(11) default NULL,
  `roleId` int(11) default NULL,
  PRIMARY KEY  (`UserRoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_adminusers_role(`userId`,`roleId`) values(1,1);


##模块表
DROP TABLE IF EXISTS `t_model`;
CREATE TABLE `t_model` (
  `modelId` int(11) NOT NULL auto_increment COMMENT '模块ID',
  `name` varchar(128) NOT NULL COMMENT '模块名',
  `code` varchar(128) NOT NULL COMMENT '模块编码',
  `type` varchar(1) NOT NULL COMMENT '模块类型 0-菜单,1-非菜单项',
  `order` int(11) NULL COMMENT '模块顺序',
  `url` varchar(256) NULL COMMENT '资源url',
  `parentId` int(11) NULL COMMENT '父ID',
  `icon`   varchar(512) null COMMENT '导航菜单的图标',
  PRIMARY KEY (`modelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

delete from t_model;

insert into t_model(`modelId`,`name`,`code`,`type`,`order`,url,parentId,icon) values(1,'系统管理','com.meeting.adminuser','0',1,'',null,'<img src="../images/1361617211_setting_tools.png">&nbsp;');
insert into t_model(`modelId`,`name`,`code`,`type`,`order`,url,parentId,icon) values(2,'角色管理','com.meeting.adminuser.role','0',1,'adminRoleList!searchListPage.action',1,'<img src="../images/1361617228_group.png">&nbsp;');
insert into t_model(`modelId`,`name`,`code`,`type`,`order`,url,parentId,icon) values(3,'用户管理','com.meeting.adminuser.user','0',2,'',1,'<img src="../images/1361617541_application_form_edit.png"/>&nbsp;');
insert into t_model(`modelId`,`name`,`code`,`type`,`order`,url,parentId,icon) values(4,'会议管理','com.meeting.meeting','0',2,'',null,'<img src="../images/1361617203_book_open.png"/>&nbsp;');

##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('类别管理','com.guoxin.category','0',1,'',null,'<img src="../images/1361617443_chart_bar.png"/>&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('应用管理','com.guoxin.application','0',2,'',null,'<img src="../images/1361617541_application_form_edit.png"/>&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('角色管理','com.guoxin.clientrole','0',3,'',null,'<img src="../images/1361617228_group.png">&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('客户管理','com.guoxin.client','0',4,'',null,'<img src="../images/1361617669_user1.png">&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('版本管理','com.guoxin.version','0',5,'',null,'<img src="../images/1361617203_book_open.png">&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('后台管理','com.guoxin.adminuser','0',6,'',null,'<img src="../images/1361617211_setting_tools.png">&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('类别管理','com.guoxin.category.list','0',1,'typeList!searchListPage.action',1,'<img src="../images/min-icon.png"/>&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('应用管理','com.guoxin.application.list','0',1,'../jsp/frame.jsp',2,'<img src="../images/min-icon.png"/>&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('角色管理','com.guoxin.clientrole.list','0',1,'roleList!searchListPage.action',3,'<img src="../images/min-icon.png"/>&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('角色应用','com.guoxin.clientrole.app','0',2,'roleAppList!searchListPage.action',3,'<img src="../images/min-icon.png"/>&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('客户管理','com.guoxin.client.list','0',1,'customerList!searchListPage.action',4,'<img src="../images/min-icon.png"/>&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('查看版本','com.guoxin.version.list','0',1,'searchLocalVerList!searchVersion.action',5,'<img src="../images/min-icon.png"/>&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('上传版本','com.guoxin.version.upload','0',2,'updateLocalVersion!initUpdateVersion.action',5,'<img src="../images/min-icon.png"/>&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('后台管理员','com.guoxin.adminuser.list','0',1,'adminuserList!searchListPage.action',6,'<img src="../images/min-icon.png"/>&nbsp;');
##insert into t_model(`name`,`code`,`type`,`order`,url,parentId,icon) values('权限分配','com.guoxin.adminuser.pri','0',2,'adminRoleList!searchAllRole.action',6,'<img src="../images/min-icon.png"/>&nbsp;');


##后台用户角色表
DROP TABLE IF EXISTS `t_admin_role`;
CREATE TABLE `t_admin_role` (
  `roleId` int(11) NOT NULL auto_increment COMMENT '角色ID',
  `roleName` varchar(128) NOT NULL COMMENT '角色名',
  `remark` varchar(200) default NULL,
  `CreateDate` datetime default NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

delete from t_admin_role;
insert into t_admin_role(roleName) values('超级管理员');
insert into t_admin_role(roleName) values('业务管理员');
insert into t_admin_role(roleName) values('系统管理员');

#后台角色权限表
DROP TABLE IF EXISTS `t_admin_right`;
CREATE TABLE `t_admin_right` (
  `rightId` int(11) NOT NULL auto_increment COMMENT '权限ID',
  `roleId`  int(11)  NULL COMMENT '角色ID',
  `modelId`  int(11) NOT NULL COMMENT '模块ID',
  PRIMARY KEY (`rightId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

delete from t_admin_right;
insert into t_admin_right(roleId,modelId) values(1,1);
insert into t_admin_right(roleId,modelId) values(1,2);
insert into t_admin_right(roleId,modelId) values(1,3);
insert into t_admin_right(roleId,modelId) values(1,4);


#本地应用版本表
DROP TABLE IF EXISTS `t_local_version`;
CREATE TABLE `t_local_version` (
`id`  int(1) NOT NULL COMMENT '主键ID' ,
`version`  varchar(5) NULL COMMENT '版本号' ,
`url`  varchar(200) NULL COMMENT '版本地址' ,
`descripe`  text NULL COMMENT '版本描述' ,
`mustUpdte`  int(1) NULL COMMENT '是否强制更新' ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `t_local_version` VALUES ('1', '0', null, null, 0);

insert into t_adminusers(UserAccount,UserPassword) values('admin','admin');
