/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50041
Source Host           : localhost:3306
Source Database       : general

Target Server Type    : MYSQL
Target Server Version : 50041
File Encoding         : 65001

Date: 2013-03-14 17:12:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tauth`
-- ----------------------------
DROP TABLE IF EXISTS `tauth`;
CREATE TABLE `tauth` (
  `CID` varchar(36) NOT NULL,
  `CDESC` varchar(200) default NULL,
  `CNAME` varchar(100) NOT NULL,
  `CSEQ` decimal(22,0) default NULL,
  `CURL` varchar(200) default NULL,
  `CPID` varchar(36) default NULL,
  PRIMARY KEY  (`CID`),
  KEY `FK4BE8BFCAEB4A783` (`CPID`),
  CONSTRAINT `FK4BE8BFCAEB4A783` FOREIGN KEY (`CPID`) REFERENCES `tauth` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tauth
-- ----------------------------
INSERT INTO `tauth` VALUES ('0', '基础开发平台', '首页', '1', '', null);
INSERT INTO `tauth` VALUES ('1', '不能删除', '你好', '11', null, null);
INSERT INTO `tauth` VALUES ('bmadd', '', '部门菜单添加', '4', '/dept!add.do', 'bmgl');
INSERT INTO `tauth` VALUES ('bmaddym', '', '添加部门页面', '3', '/dept!deptAdd.do', 'bmgl');
INSERT INTO `tauth` VALUES ('bmcx', '', '部门查询', '2', '/dept!treegrid.do', 'bmgl');
INSERT INTO `tauth` VALUES ('bmdelete', '', '部门删除', '7', '/dept!delete.do', 'bmgl');
INSERT INTO `tauth` VALUES ('bmedit', '', '部门编辑', '6', '/dept!edit.do', 'bmgl');
INSERT INTO `tauth` VALUES ('bmeditym', '', '编辑部门页面', '5', '/dept!deptEdit.do', 'bmgl');
INSERT INTO `tauth` VALUES ('bmgl', '', '部门管理', '5', '', 'xtgl');
INSERT INTO `tauth` VALUES ('bmglym', '', '部门管理页面', '1', '/dept!dept.do', 'bmgl');
INSERT INTO `tauth` VALUES ('bugadd', '', '上报BUG', '4', '/bug!add.do', 'buggl');
INSERT INTO `tauth` VALUES ('bugaddym', '', '上报BUG页面', '3', '/bug!bugAdd.do', 'buggl');
INSERT INTO `tauth` VALUES ('bugcx', '', 'BUG查询', '2', '/bug!datagrid.do', 'buggl');
INSERT INTO `tauth` VALUES ('bugdelete', '', 'BUG删除', '7', '/bug!delete.do', 'buggl');
INSERT INTO `tauth` VALUES ('bugdesc', '', '查看BUG描述', '9', '/bug!showCdesc.do', 'buggl');
INSERT INTO `tauth` VALUES ('bugedit', '', 'BUG编辑', '6', '/bug!edit.do', 'buggl');
INSERT INTO `tauth` VALUES ('bugeditym', '', '编辑BUG页面', '5', '/bug!bugEdit.do', 'buggl');
INSERT INTO `tauth` VALUES ('buggl', '', 'BUG管理', '5', '', 'xtgl');
INSERT INTO `tauth` VALUES ('bugglym', '', 'BUG管理页面', '1', '/bug!bug.do', 'buggl');
INSERT INTO `tauth` VALUES ('bugupload', '', 'BUG上传', '8', '/bug!upload.do', 'buggl');
INSERT INTO `tauth` VALUES ('cdadd', '', '菜单添加', '4', '/menu!add.do', 'cdgl');
INSERT INTO `tauth` VALUES ('cdaddym', '', '添加菜单页面', '3', '/menu!menuAdd.do', 'cdgl');
INSERT INTO `tauth` VALUES ('cdcx', '', '菜单查询', '2', '/menu!treegrid.do', 'cdgl');
INSERT INTO `tauth` VALUES ('cddelete', '', '菜单删除', '7', '/menu!delete.do', 'cdgl');
INSERT INTO `tauth` VALUES ('cdedit', '', '菜单编辑', '6', '/menu!edit.do', 'cdgl');
INSERT INTO `tauth` VALUES ('cdeditym', '', '编辑菜单页面', '5', '/menu!menuEdit.do', 'cdgl');
INSERT INTO `tauth` VALUES ('cdgl', '', '菜单管理', '4', '', 'xtgl');
INSERT INTO `tauth` VALUES ('cdglym', '', '菜单管理页面', '1', '/menu!menu.do', 'cdgl');
INSERT INTO `tauth` VALUES ('jsadd', '', '角色添加', '4', '/role!add.do', 'jsgl');
INSERT INTO `tauth` VALUES ('jsaddym', '', '添加角色页面', '3', '/role!roleAdd.do', 'jsgl');
INSERT INTO `tauth` VALUES ('jscx', '', '角色查询', '2', '/role!datagrid.do', 'jsgl');
INSERT INTO `tauth` VALUES ('jsdelete', '', '角色删除', '7', '/role!delete.do', 'jsgl');
INSERT INTO `tauth` VALUES ('jsedit', '', '角色编辑', '6', '/role!edit.do', 'jsgl');
INSERT INTO `tauth` VALUES ('jseditym', '', '编辑角色页面', '5', '/role!roleEdit.do', 'jsgl');
INSERT INTO `tauth` VALUES ('jsgl', '', '角色管理', '2', '', 'xtgl');
INSERT INTO `tauth` VALUES ('jsglym', '', '角色管理页面', '1', '/role!role.do', 'jsgl');
INSERT INTO `tauth` VALUES ('ljcjk', '可查看数据库链接信息', '连接池监控', '1', '/datasource!druid.do', 'sjkgl');
INSERT INTO `tauth` VALUES ('qxadd', '', '权限添加', '4', '/auth!add.do', 'qxgl');
INSERT INTO `tauth` VALUES ('qxaddym', '', '添加权限页面', '3', '/auth!authAdd.do', 'qxgl');
INSERT INTO `tauth` VALUES ('qxcx', '', '权限查询', '2', '/auth!treegrid.do', 'qxgl');
INSERT INTO `tauth` VALUES ('qxdelete', '', '权限删除', '7', '/auth!delete.do', 'qxgl');
INSERT INTO `tauth` VALUES ('qxedit', '', '权限编辑', '6', '/auth!edit.do', 'qxgl');
INSERT INTO `tauth` VALUES ('qxeditym', '', '编辑权限页面', '5', '/auth!authEdit.do', 'qxgl');
INSERT INTO `tauth` VALUES ('qxgl', '', '权限管理', '3', '', 'xtgl');
INSERT INTO `tauth` VALUES ('qxglym', '', '权限管理页面', '1', '/auth!auth.do', 'qxgl');
INSERT INTO `tauth` VALUES ('sjkgl', '可查看数据库链接信息，SQL语句执行情况', '数据库管理', '1', '', '0');
INSERT INTO `tauth` VALUES ('xtgl', '', '系统管理', '2', '', '0');
INSERT INTO `tauth` VALUES ('yhadd', '', '用户添加', '4', '/user!add.do', 'yhgl');
INSERT INTO `tauth` VALUES ('yhaddym', '', '添加用户页面', '3', '/user!userAdd.do', 'yhgl');
INSERT INTO `tauth` VALUES ('yhcx', '', '用户查询', '2', '/user!datagrid.do', 'yhgl');
INSERT INTO `tauth` VALUES ('yhedit', '', '用户修改', '6', '/user!edit.do', 'yhgl');
INSERT INTO `tauth` VALUES ('yheditym', '', '修改用户页面', '5', '/user!userEdit.do', 'yhgl');
INSERT INTO `tauth` VALUES ('yhgl', '', '用户管理', '1', '', 'xtgl');
INSERT INTO `tauth` VALUES ('yhglym', '', '用户管理页面', '1', '/user!user.do', 'yhgl');
INSERT INTO `tauth` VALUES ('yhsc', '', '用户删除', '7', '/user!delete.do', 'yhgl');
INSERT INTO `tauth` VALUES ('yhxgjs', '批量修改用户角色', '修改角色', '9', '/user!roleEdit.do', 'yhgl');
INSERT INTO `tauth` VALUES ('yhxgjsym', '批量修改用户角色', '修改角色页面', '8', '/user!userRoleEdit.do', 'yhgl');

-- ----------------------------
-- Table structure for `tbug`
-- ----------------------------
DROP TABLE IF EXISTS `tbug`;
CREATE TABLE `tbug` (
  `CID` varchar(36) NOT NULL,
  `CCREATEDATETIME` datetime default NULL,
  `CDESC` longtext,
  `CNAME` varchar(100) NOT NULL,
  PRIMARY KEY  (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbug
-- ----------------------------

-- ----------------------------
-- Table structure for `tdept`
-- ----------------------------
DROP TABLE IF EXISTS `tdept`;
CREATE TABLE `tdept` (
  `CID` varchar(36) NOT NULL,
  `CDESC` varchar(250) default NULL,
  `CICONCLS` varchar(100) default NULL,
  `CNAME` varchar(100) NOT NULL,
  `CSEQ` decimal(22,0) default NULL,
  `CPID` varchar(36) default NULL,
  PRIMARY KEY  (`CID`),
  KEY `FK4BFAC99AEB5C820` (`CPID`),
  CONSTRAINT `FK4BFAC99AEB5C820` FOREIGN KEY (`CPID`) REFERENCES `tdept` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tdept
-- ----------------------------
INSERT INTO `tdept` VALUES ('0', '所有部门的父级部门', null, '根部门', '0', null);
INSERT INTO `tdept` VALUES ('11', 'dxf', 'df', 'dsfsd', '3', '11');

-- ----------------------------
-- Table structure for `tdic`
-- ----------------------------
DROP TABLE IF EXISTS `tdic`;
CREATE TABLE `tdic` (
  `CID` varchar(36) NOT NULL,
  `CKEY` varchar(50) NOT NULL,
  `CSTATUS` varchar(10) default NULL,
  `CTYPE` varchar(36) default NULL,
  `CVALUE` varchar(50) default NULL,
  PRIMARY KEY  (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tdic
-- ----------------------------
INSERT INTO `tdic` VALUES ('11', '2', '1', 'as', 's');

-- ----------------------------
-- Table structure for `tloguserlogin`
-- ----------------------------
DROP TABLE IF EXISTS `tloguserlogin`;
CREATE TABLE `tloguserlogin` (
  `CID` varchar(36) NOT NULL,
  `CDATETIME` datetime default NULL,
  `CMSG` varchar(200) default NULL,
  `CNAME` varchar(100) default NULL,
  PRIMARY KEY  (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tloguserlogin
-- ----------------------------
INSERT INTO `tloguserlogin` VALUES ('11', '2013-01-11 17:01:17', 'dsf', 'sdf');

-- ----------------------------
-- Table structure for `tloguserreg`
-- ----------------------------
DROP TABLE IF EXISTS `tloguserreg`;
CREATE TABLE `tloguserreg` (
  `CID` varchar(36) NOT NULL,
  `CDATETIME` datetime default NULL,
  `CMSG` varchar(200) default NULL,
  `CNAME` varchar(100) default NULL,
  PRIMARY KEY  (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tloguserreg
-- ----------------------------
INSERT INTO `tloguserreg` VALUES ('11', '2013-01-23 17:01:29', 'sad', 'asda');

-- ----------------------------
-- Table structure for `tmenu`
-- ----------------------------
DROP TABLE IF EXISTS `tmenu`;
CREATE TABLE `tmenu` (
  `CID` varchar(36) NOT NULL,
  `CICONCLS` varchar(100) default NULL,
  `CNAME` varchar(100) NOT NULL,
  `CSEQ` decimal(22,0) default NULL,
  `CURL` varchar(200) default NULL,
  `CPID` varchar(36) default NULL,
  PRIMARY KEY  (`CID`),
  KEY `FK4C3C3B3AEB9DF3A` (`CPID`),
  CONSTRAINT `FK4C3C3B3AEB9DF3A` FOREIGN KEY (`CPID`) REFERENCES `tmenu` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmenu
-- ----------------------------
INSERT INTO `tmenu` VALUES ('1', 'hello', '权限管理', '11', 'xzc', '1');
INSERT INTO `tmenu` VALUES ('2', '23', '23', '23', '23', '2');
INSERT INTO `tmenu` VALUES ('4', 'ds', 'dsfsdfds', '3', 'df', null);
INSERT INTO `tmenu` VALUES ('a036a98d-d5ab-4036-9052-0c9b7879e19e', '', 'baidu', '10', 'http://www.baidu.com', '4');
INSERT INTO `tmenu` VALUES ('bmgl', 'icon-group', '部门管理', '2', '/dept!dept.do', 'xtgl');
INSERT INTO `tmenu` VALUES ('buggl', 'icon-bug', 'BUG管理', '7', '/bug!bug.do', 'xtgl');
INSERT INTO `tmenu` VALUES ('cdgl', 'icon-menu', '菜单管理', '5', '/menu!menu.do', 'xtgl');
INSERT INTO `tmenu` VALUES ('druidIndex', 'icon-druid', 'druid监控', '1', '/datasource!druid.do', 'sjkgl');
INSERT INTO `tmenu` VALUES ('jsgl', 'icon-role', '角色管理', '3', '/role!role.do', 'xtgl');
INSERT INTO `tmenu` VALUES ('qxgl', 'icon-auth', '权限管理', '4', '/auth!auth.do', 'xtgl');
INSERT INTO `tmenu` VALUES ('sjkgl', 'icon-database', '数据库管理', '3', '', null);
INSERT INTO `tmenu` VALUES ('sjzd', 'icon-dic', '数据字典', '6', '/dic!dic.do', 'xtgl');
INSERT INTO `tmenu` VALUES ('xtgl', 'icon-orange', '系统管理', '1', '', null);
INSERT INTO `tmenu` VALUES ('yhgl', 'icon-user', '用户管理', '1', '/user!user.do', 'xtgl');

-- ----------------------------
-- Table structure for `tonline`
-- ----------------------------
DROP TABLE IF EXISTS `tonline`;
CREATE TABLE `tonline` (
  `CID` varchar(36) NOT NULL,
  `CDATETIME` datetime NOT NULL,
  `CIP` varchar(50) NOT NULL,
  `CNAME` varchar(100) NOT NULL,
  PRIMARY KEY  (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tonline
-- ----------------------------
INSERT INTO `tonline` VALUES ('1', '2013-01-08 17:02:02', 'xzc', 'xc');

-- ----------------------------
-- Table structure for `trole`
-- ----------------------------
DROP TABLE IF EXISTS `trole`;
CREATE TABLE `trole` (
  `CID` varchar(36) NOT NULL,
  `CDESC` varchar(200) default NULL,
  `CNAME` varchar(100) NOT NULL,
  PRIMARY KEY  (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trole
-- ----------------------------
INSERT INTO `trole` VALUES ('0', '拥有系统所有权限', '超级管理员');
INSERT INTO `trole` VALUES ('1', '', 'Guest');
INSERT INTO `trole` VALUES ('c6bdc84d-fec6-4115-99d9-d5b11d0577f3', '', '系统管理员');

-- ----------------------------
-- Table structure for `troletauth`
-- ----------------------------
DROP TABLE IF EXISTS `troletauth`;
CREATE TABLE `troletauth` (
  `CID` varchar(36) NOT NULL,
  `CAUTHID` varchar(36) default NULL,
  `CROLEID` varchar(36) default NULL,
  PRIMARY KEY  (`CID`),
  KEY `FKE3580B72CFBC0021` (`CAUTHID`),
  KEY `FKE3580B72EC6DCA3D` (`CROLEID`),
  CONSTRAINT `FKE3580B72CFBC0021` FOREIGN KEY (`CAUTHID`) REFERENCES `tauth` (`CID`),
  CONSTRAINT `FKE3580B72EC6DCA3D` FOREIGN KEY (`CROLEID`) REFERENCES `trole` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of troletauth
-- ----------------------------
INSERT INTO `troletauth` VALUES ('0256c60b-d6cc-4a20-8a89-e5a1fd4a842e', 'bmedit', '0');
INSERT INTO `troletauth` VALUES ('0b427dea-f612-4778-9018-95a58f28ff6c', 'bmaddym', '0');
INSERT INTO `troletauth` VALUES ('0c6ba1ce-b324-467d-aeac-8775669d3453', 'bmglym', '0');
INSERT INTO `troletauth` VALUES ('0e05cdaf-2c8b-470c-83ba-222ef2d579cc', 'jsaddym', '0');
INSERT INTO `troletauth` VALUES ('0fffc9dc-4f8e-4fdd-a1b5-9494edb9caef', 'yhgl', '0');
INSERT INTO `troletauth` VALUES ('1', '1', '1');
INSERT INTO `troletauth` VALUES ('18ecdeeb-06a1-4511-bb70-a7fa17caeacf', 'cddelete', '0');
INSERT INTO `troletauth` VALUES ('19a88894-8d1f-4059-8a2d-804adff9db98', '0', '0');
INSERT INTO `troletauth` VALUES ('1a7f7155-f6c7-43ef-b3dd-87e377c8691a', 'bugupload', '0');
INSERT INTO `troletauth` VALUES ('217a3b51-84c7-41f8-9324-2ae4beb836e9', 'yhxgjsym', '0');
INSERT INTO `troletauth` VALUES ('2914a89b-e6e0-43f2-8c0f-5aecef968618', 'qxedit', '0');
INSERT INTO `troletauth` VALUES ('292c89f9-ec30-4a4b-ab16-9c9a308efa7e', 'bugcx', '0');
INSERT INTO `troletauth` VALUES ('2a7d485a-1679-4540-9ba9-9408b6eede3f', 'bmadd', '0');
INSERT INTO `troletauth` VALUES ('2d2b90ab-4c92-4c7b-847b-78c99aba03dd', 'bugeditym', '0');
INSERT INTO `troletauth` VALUES ('2e3658e2-b2be-4ba5-bc1b-87d526152fbb', 'xtgl', '0');
INSERT INTO `troletauth` VALUES ('32f98e22-2028-4fa3-9b12-226cdca10a6a', 'qxeditym', '0');
INSERT INTO `troletauth` VALUES ('33fcdb60-f901-4049-96f4-f7bfdd4d3a6e', 'qxglym', '0');
INSERT INTO `troletauth` VALUES ('3673933c-2ea3-444f-b089-2f219720b684', 'qxaddym', '0');
INSERT INTO `troletauth` VALUES ('36a406ab-1716-411c-aa03-c396c671c583', 'bugedit', '0');
INSERT INTO `troletauth` VALUES ('41ed864e-fd9b-4402-ae02-202ac1e8eceb', 'bugaddym', '0');
INSERT INTO `troletauth` VALUES ('54220eb6-96ff-40d8-a868-f2266c65b44a', 'qxadd', '0');
INSERT INTO `troletauth` VALUES ('54a537c2-5563-4d59-9fab-b820c494934a', 'jscx', '0');
INSERT INTO `troletauth` VALUES ('57129756-f7df-44b6-af2c-6571f0099750', 'cdglym', '0');
INSERT INTO `troletauth` VALUES ('5fc39e86-49e1-4384-9e12-4810e42eb00d', 'bmcx', 'c6bdc84d-fec6-4115-99d9-d5b11d0577f3');
INSERT INTO `troletauth` VALUES ('68a6a7cd-1863-4cb5-afad-44e3335c5ab5', 'bugglym', '0');
INSERT INTO `troletauth` VALUES ('69c354ec-3ecd-4df0-a47d-3e38f0519264', 'cdeditym', '0');
INSERT INTO `troletauth` VALUES ('6ac2b1e7-79ee-4822-b7bf-15fd65f35638', 'bugdesc', '0');
INSERT INTO `troletauth` VALUES ('6fafa2d6-3d5e-4f82-8af8-b7785675a935', 'cdcx', '0');
INSERT INTO `troletauth` VALUES ('74ea7db9-2e7e-4721-b79c-0a4e06521c96', 'yhedit', '0');
INSERT INTO `troletauth` VALUES ('8af2a456-79a6-4d28-ad9f-a9d3a49be303', 'bmeditym', '0');
INSERT INTO `troletauth` VALUES ('922fd27e-80eb-4733-91e0-73076d46d736', 'yhxgjs', '0');
INSERT INTO `troletauth` VALUES ('928dec1b-d82f-4676-a828-c5bf32a0604d', 'bmglym', 'c6bdc84d-fec6-4115-99d9-d5b11d0577f3');
INSERT INTO `troletauth` VALUES ('93d3223a-3882-4c8b-8609-5f3cd107cf7d', 'jsadd', '0');
INSERT INTO `troletauth` VALUES ('957e8480-1907-4b76-961d-5eeb87e6e6f8', 'jsgl', '0');
INSERT INTO `troletauth` VALUES ('969686fb-6a84-4529-8798-b75ee66ee867', 'yhsc', '0');
INSERT INTO `troletauth` VALUES ('9b50240d-3679-4c1d-976b-216fbe98c0b0', 'cdedit', '0');
INSERT INTO `troletauth` VALUES ('9de3daa7-88e0-49ef-a80f-de46b008a9ab', 'bmdelete', '0');
INSERT INTO `troletauth` VALUES ('a0b257cf-68f2-4b74-b37b-380e16b7d472', 'bmcx', '0');
INSERT INTO `troletauth` VALUES ('a5f5fde8-437e-4c6e-ad72-cdf34c1f5d0c', 'cdadd', '0');
INSERT INTO `troletauth` VALUES ('a99ee173-3875-4279-9ea4-2a539dd6f93f', 'jsedit', '0');
INSERT INTO `troletauth` VALUES ('add3c97d-62e2-4e36-9677-fd099b47386d', 'sjkgl', '0');
INSERT INTO `troletauth` VALUES ('ae2b6c4a-79fd-4b95-8108-7bbd4c10a82d', 'ljcjk', '0');
INSERT INTO `troletauth` VALUES ('b005490d-67f7-441f-b63d-12e3377f85e3', 'bmadd', 'c6bdc84d-fec6-4115-99d9-d5b11d0577f3');
INSERT INTO `troletauth` VALUES ('b12d87bb-8702-441f-8ebf-b616e5a42818', 'bmgl', '0');
INSERT INTO `troletauth` VALUES ('bf18b9c4-e941-4b1e-b00a-fb64c75d7f62', 'bugdelete', '0');
INSERT INTO `troletauth` VALUES ('ca322300-e4ca-4928-b994-eec3ac06349e', '1', '0');
INSERT INTO `troletauth` VALUES ('cd291e4f-da94-4908-a853-6dfc8081b8cd', 'buggl', '0');
INSERT INTO `troletauth` VALUES ('d0082735-b08f-4f07-b1a9-18c4b54807ff', 'qxgl', '0');
INSERT INTO `troletauth` VALUES ('d278da1d-d8a9-4070-96e9-995ab02f736a', 'yhaddym', '0');
INSERT INTO `troletauth` VALUES ('d68cd22d-3d7d-4438-be56-60ace01cf9bc', 'bugadd', '0');
INSERT INTO `troletauth` VALUES ('d91623a4-33f0-4877-b646-ce5a34898353', 'yhadd', '0');
INSERT INTO `troletauth` VALUES ('ddd5e6d9-e65a-45ba-9db8-1830a4ccbc74', 'jsdelete', '0');
INSERT INTO `troletauth` VALUES ('df660c8f-2158-4782-a6d5-1572df7170cf', 'yheditym', '0');
INSERT INTO `troletauth` VALUES ('efdae138-3f35-4896-8522-8f1bfa269900', 'qxcx', '0');
INSERT INTO `troletauth` VALUES ('f70ded6d-cd64-4f0a-9c1d-2b5acaba60f3', 'yhglym', '0');
INSERT INTO `troletauth` VALUES ('f8239d78-0ec1-41f9-b094-0e63986a7f69', 'jsglym', '0');
INSERT INTO `troletauth` VALUES ('f8ac2c15-4670-405d-a5b0-09d777531b01', 'jseditym', '0');
INSERT INTO `troletauth` VALUES ('f9568a68-ee4e-49da-b5f8-9a7e01d40d18', 'qxdelete', '0');
INSERT INTO `troletauth` VALUES ('fa3cab43-53df-4dd9-82d5-05029bdafbd2', 'yhcx', '0');
INSERT INTO `troletauth` VALUES ('ff2b002d-903d-48e8-96a3-ac37567c83de', 'cdaddym', '0');
INSERT INTO `troletauth` VALUES ('ffe3ff1a-7157-4c6b-9b42-c01de7918d6f', 'cdgl', '0');

-- ----------------------------
-- Table structure for `tuser`
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `CID` varchar(36) NOT NULL,
  `CCREATEDATETIME` datetime default NULL,
  `CEMAIL` varchar(50) default NULL,
  `CMODIFYDATETIME` datetime default NULL,
  `CNAME` varchar(100) NOT NULL,
  `CPWD` varchar(100) NOT NULL,
  `CREALNAME` varchar(200) NOT NULL,
  `CSN` varchar(36) default NULL,
  `CSTATUS` varchar(10) default NULL,
  `CDEPTID` varchar(36) default NULL,
  PRIMARY KEY  (`CID`),
  UNIQUE KEY `CNAME` (`CNAME`),
  UNIQUE KEY `CEMAIL` (`CEMAIL`),
  KEY `FK4C79A1FD3F88E1B` (`CDEPTID`),
  CONSTRAINT `FK4C79A1FD3F88E1B` FOREIGN KEY (`CDEPTID`) REFERENCES `tdept` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('0', '2013-03-12 13:24:46', '88388996@qq.com', '2013-03-12 13:24:46', 'admin', '21232f297a57a5a743894a0e4a801fc3', '超级管理员', null, '0', '0');
INSERT INTO `tuser` VALUES ('111', null, null, '2013-01-25 17:03:06', '1234', 'E10ADC3949BA59ABBE56E057F20F883E', '1234', null, null, '11');
INSERT INTO `tuser` VALUES ('ad1c0574-cd31-42c2-9643-4dc343ee91a4', '2013-03-12 13:32:19', '', '2013-03-12 13:32:19', '12345', 'c4ca4238a0b923820dcc509a6f75849b', '1', null, '0', '0');

-- ----------------------------
-- Table structure for `tusertrole`
-- ----------------------------
DROP TABLE IF EXISTS `tusertrole`;
CREATE TABLE `tusertrole` (
  `CID` varchar(36) NOT NULL,
  `CROLEID` varchar(36) default NULL,
  `CUSERID` varchar(36) default NULL,
  PRIMARY KEY  (`CID`),
  KEY `FKE395100BF1C31FA7` (`CUSERID`),
  KEY `FKE395100BEC6DCA3D` (`CROLEID`),
  CONSTRAINT `FKE395100BEC6DCA3D` FOREIGN KEY (`CROLEID`) REFERENCES `trole` (`CID`),
  CONSTRAINT `FKE395100BF1C31FA7` FOREIGN KEY (`CUSERID`) REFERENCES `tuser` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tusertrole
-- ----------------------------
INSERT INTO `tusertrole` VALUES ('1', '1', '111');
INSERT INTO `tusertrole` VALUES ('11525ae9-6244-4244-9d67-f85277712dba', 'c6bdc84d-fec6-4115-99d9-d5b11d0577f3', 'ad1c0574-cd31-42c2-9643-4dc343ee91a4');
INSERT INTO `tusertrole` VALUES ('5fd83ac3-3891-49f8-a6a8-1935ae210d88', '0', '0');
