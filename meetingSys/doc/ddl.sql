--系统角色表
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `REMARK` varchar(200) DEFAULT NULL,
  `INSERT_DATE` datetime NOT NULL,
  `UPDATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_sys_role` VALUES ('1', '系统管理员', null, '2014-06-03 09:15:51', '2014-06-03 09:15:53');


--系统用户表
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `salt`       varchar(10),
  `INSERT_DATE` datetime NOT NULL,
  `UPDATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_sys_user` VALUES ('1', 'admin', 'admin', '232wewews','2014-06-03 09:15:51', '2014-06-03 09:15:53');

--用户角色表
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- 系统资源表
create table `t_sys_resource`(
  `id`         bigint not null auto_increment,
  `name`      varchar(100),
  `operationCode`  varchar(100),
  `url`      varchar(200),
  `parent_id` bigint,
  `type` varchar(1),       --0:菜单，1：按钮等其他
  PRIMARY KEY (`ID`)
) charset=utf8 ENGINE=InnoDB;

--系统角色权限表
create table `t_sys_privilege`(
  `id`         bigint not null auto_increment,
  `role_id`   bigint,
  `resource_id` bigint,
  PRIMARY KEY (`ID`)
) charset=utf8 ENGINE=InnoDB;
