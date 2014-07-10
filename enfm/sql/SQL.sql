DROP DATABASE IF EXISTS `enfm`;
CREATE DATABASE `enfm` ;
create user 'enfm'@'%' IDENTIFIED by  'enfm';
GRANT ALL ON enfm.* to 'enfm'@'%';
USE `enfm`;

##后台用户表
DROP TABLE IF EXISTS `t_admin_users`;
CREATE TABLE `t_admin_users` (
  `UserID` int(11) NOT NULL auto_increment,
  `UserAccount` varchar(50) default NULL,
  `UserPassword` varchar(50) default NULL,
  `CreateDate` datetime default NULL,
  `EditDate` datetime default NULL,
  PRIMARY KEY  (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into t_admin_users(UserAccount,UserPassword) values('admin','admin');

##后台用户角色表
DROP TABLE IF EXISTS `t_admin_role`;
CREATE TABLE `t_admin_role` (
  `roleId` int(11) NOT NULL auto_increment COMMENT '角色ID',
  `roleName` varchar(128) NOT NULL COMMENT '角色名',
  `remark` varchar(200) default NULL,
  `CreateDate` datetime default NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_admin_role(roleName) values('超级管理员');
insert into t_admin_role(roleName) values('业务管理员');
insert into t_admin_role(roleName) values('系统管理员');

##后台用户所属角色表
DROP TABLE IF EXISTS `t_adminusers_role`;
CREATE TABLE `t_adminusers_role` (
  `UserRoleID` int(11) NOT NULL auto_increment,
  `userId` int(11) default NULL,
  `roleId` int(11) default NULL,
  PRIMARY KEY  (`UserRoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_adminusers_role(`userId`,`roleId`) values(1,1);


##资源模块表
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `moduleId` int(11) NOT NULL auto_increment COMMENT '模块ID',
  `name` varchar(128) NOT NULL COMMENT '模块名',
  `code` varchar(128) NOT NULL COMMENT '模块编码',
  `type` varchar(1) NOT NULL COMMENT '模块类型 0-菜单,1-非菜单项',
  `order` int(11) NULL COMMENT '模块顺序',
  `url` varchar(256) NULL COMMENT '资源url',
  `parentId` int(11) NULL COMMENT '父ID',
  `icon`   varchar(512) null COMMENT '导航菜单的图标',
  PRIMARY KEY (`moduleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_module(`moduleId`,`name`,`code`,`type`,`order`,url,parentId,icon) 
values(1,'系统管理','com.cpy.enfm.adminuser','0',1,'',null,'icon-orange');
insert into t_module(`moduleId`,`name`,`code`,`type`,`order`,url,parentId,icon) 
values(2,'角色管理','com.cpy.enfm.adminuser.role','0',1,'adminRoleList!searchListPage.action',1,'icon-role');
insert into t_module(`moduleId`,`name`,`code`,`type`,`order`,url,parentId,icon) 
values(3,'用户管理','com.cpy.enfm.adminuser.user','0',2,'',1,'icon-user');
insert into t_module(`moduleId`,`name`,`code`,`type`,`order`,url,parentId,icon) 
values(4,'会议管理','com.cpy.enfm.meeting','0',2,'',null,'icon-database');


#后台角色权限表
DROP TABLE IF EXISTS `t_admin_privilege`;
CREATE TABLE `t_admin_privilege` (
  `privilegeId` int(11) NOT NULL auto_increment COMMENT '权限ID',
  `roleId`  int(11)  NULL COMMENT '角色ID',
  `moduleId`  int(11) NOT NULL COMMENT '模块ID',
  PRIMARY KEY (`privilegeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into t_admin_privilege(roleId,moduleId) values(1,1);
insert into t_admin_privilege(roleId,moduleId) values(1,2);
insert into t_admin_privilege(roleId,moduleId) values(1,3);
insert into t_admin_privilege(roleId,moduleId) values(1,4);



