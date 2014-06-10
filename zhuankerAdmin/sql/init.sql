insert into t_role_info(id,role_name,isremove) values(SEQ_PRI_ROLE_INFO.NEXTVAL,'系统管理员',0);
insert into t_role_info(id,role_name,isremove) values(SEQ_PRI_ROLE_INFO.NEXTVAL,'渠道管理员',0);

insert into t_manager_info(id,user_name,password,real_name,role_id,create_date,isremove) values(SEQ_PRI_MANAGER_INFO.NEXTVAL,'admin','e10adc3949ba59abbe56e057f20f883e','系统管理员',1,sysdate,0);

insert into t_area(id,statename,parent_id,isremove) values(seq_pri_area.nextval,'root',0,0);
insert into t_channel(id,channel_name,parentid,manager_id,level_code,create_date,isremove,areaid) values(1,'赚客网',0,1,'01',sysdate,0,1);

insert into t_professio(id,name) values(seq_pri_profession.nextval,'医生');
insert into t_professio(id,name) values(seq_pri_profession.nextval,'舞蹈家');

insert into t_invite_code values(1,8848);



insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, 'root', 'com.soarsky.root', '0', 1, null, 0, null);
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '用户管理', 'com.soarsky.client', '0', 1, null, 1, '/images/icon_3_1_03.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '渠道管理', 'com.soarsky.channel', '0', 2, null, 1, '/images/icon_3_1_06.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '任务管理', 'com.soarsky.task', '0', 3, null, 1, '/images/icon_3_1_05.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '统计管理', 'com.soarsky.report', '0', 4, null, 1, '/images/icon_3_1_07.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '结算管理', 'com.soarsky.financial', '0', 5, null, 1, '/images/icon_3_1_09.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '基础数据', 'com.soarsky.basedata', '0', 6, null, 1, '/images/icon_3_1_08.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '系统管理', 'com.soarsky.admin', '0', 7, null, 1, '/images/icon_3_1_10.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '注册用户管理', 'com.soarsky.client.clientmanager', '0', 1, '/userclient/userclientList!searchList.shtml', 2, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '用户反馈', 'com.soarsky.client.suggestion', '0', 2, '/suggection/suggectionList!searchList.shtml', 2, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '一级渠道管理', 'com.soarsky.channel.firstchannel', '0', 1, '/firstChanel/firstchannelList!searchList.shtml', 3, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '客户管理', 'com.soarsky.task.channel', '0', 1, '/company/companyList!getUserList.shtml', 4, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '任务管理', 'com.soarsky.task.pubtask', '0', 2, '/task/taskList!searchList.shtml', 4, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '赚客级别', 'com.soarsky.basedata.level', '0', 1, '/userlevel/userLevelList!searchList.shtml', 7, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '区域管理', 'com.soarsky.basedata.area', '0', 2, '/jsp/clientuser/arealist.jsp', 7, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '子渠道管理', 'com.soarsky.channel.childchannel', '0', 2, '/jsp/channel/channelMgrList.jsp', 3, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '任务审核', 'com.soarsky.task.approve', '0', 3, '/task/taskApprove!searchList.shtml', 4, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '下载量统计', 'com.soarsky.report.download', '0', 1, '/reports/appDownloadStatistics.shtml', 5, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '安装量统计', 'com.soarsky.report.install', '0', 2, '/reports/appInstallsStatistics.shtml', 5, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '非系统安装', 'com.soarsky.report.nonplat', '0', 4, '/reports/userAppStatistics.shtml', 5, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '赚客网用户统计', 'com.soarsky.report.zhuanke', '0', 5, '/reports/userStatistics.shtml', 5, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '使用量统计', 'com.soarsky.report.useflow', '0', 3, '/reports/appFlowStatistics.shtml', 5, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '用户结算', 'com.soarsky.financial.client', '0', 1, '/payment/paymentList!searchList.shtml', 6, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '客户结算', 'com.soarsky.financial.channelsuply', '0', 2, '/payment/demandPaymentList.shtml', 6, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '渠道结算', 'com.soarsky.financial.channel', '0', 3, '/payment/channelPaymentList.shtml', 6, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '用户管理', 'com.soarsky.admin.manager', '0', 1, '/admin/adminList.shtml', 8, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '角色管理', 'com.soarsky.admin.role', '0', 2, '/admin/roleList.shtml', 8, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '版本管理', 'com.soarsky.admin.version', '0', 3, '/mversion/versionlist!versionList.shtml', 8, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '模块管理', 'com.soarsky.admin.model', '0', 4, '/jsp/manager/modelInfo.jsp', 8, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '客户行业管理', 'com.soarsky.basedata.industry', '0', 3, '/channelindustry/channelIndustryList!getChannelIndustryList.shtml', 7, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '爱好管理', 'com.soarsky.basedata.hobbies', '0', 4, '/hobbies/hobbiesList!searchList.shtml', 7, '/images/icon_3_1_11.png');
insert into T_MODEL_INFO (id, name, code, type, modelorder, url, parent_id, icon)
values (SEQ_PRI_MODEL_INFO.nextval, '订单管理', 'com.soarsky.task.order', '0', 4, '/companyorder/companyorderList!searchList.shtml', 4, '/images/icon_3_1_11.png');


insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (1,1,500,'/image/base/gift_q.png','Q币',5.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (2,1,1000,'/image/base/gift_q.png','Q币',10.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (3,1,1500,'/image/base/gift_q.png','Q币',15.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (4,1,2000,'/image/base/gift_q.png','Q币',20.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (5,1,3000,'/image/base/gift_q.png','Q币',30.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (6,1,5000,'/image/base/gift_q.png','Q币',50.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (7,2,1000,'/image/base/gift_phone_charge.png','话费',10.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (8,2,2000,'/image/base/gift_phone_charge.png','话费',20.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (9,2,3000,'/image/base/gift_phone_charge.png','话费',30.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (10,2,5000,'/image/base/gift_phone_charge.png','话费',50.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (11,3,5000,'/image/base/gift_cash.png','现金',50.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (12,3,10000,'/image/base/gift_cash.png','现金',100.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (13,3,20000,'/image/base/gift_cash.png','现金',200.00,0);
insert into t_gift (id,gift_type,gift_gold,gift_url,gift_name,gift_price,isremove) values (14,3,50000,'/image/base/gift_cash.png','现金',500.00,0);



insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 1);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 2);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 3);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 4);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 5);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 6);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 7);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 8);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 9);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 10);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 11);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 12);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 13);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 14);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 15);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 16);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 17);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 18);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 19);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 20);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 21);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 22);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 23);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 24);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 25);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 26);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 27);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 28);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 29);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 30);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 31);
insert into T_RIGHT_INFO (id, role_id, model_id)
values (SEQ_PRI_RIGHT_INFO.nextval, 1, 32);


insert into t_area(id,statename,parent_id,isremove) values(2,'四川省',1,0);
insert into t_area(id,statename,parent_id,isremove) values(3,'广东省',1,0);
insert into t_area(id,statename,parent_id,isremove) values(4,'江苏省',1,0);
insert into t_area(id,statename,parent_id,isremove) values(5,'成都市',2,0);
insert into t_area(id,statename,parent_id,isremove) values(6,'南充市',2,0);
insert into t_area(id,statename,parent_id,isremove) values(7,'广州市',3,0);
insert into t_area(id,statename,parent_id,isremove) values(8,'南京市',4,0);


insert into t_right_info(id,role_id,model_id) values(SEQ_PRI_RIGHT_INFO.NEXTVAL,2,1);
insert into t_right_info(id,role_id,model_id) values(SEQ_PRI_RIGHT_INFO.NEXTVAL,2,3);
insert into t_right_info(id,role_id,model_id) values(SEQ_PRI_RIGHT_INFO.NEXTVAL,2,16);


insert into t_config (ID,MODELCODE,KEY,VALUE) values (SEQ_PRI_CONFIG.nextval,'com.soarsky.octopus.register.package','jdkBinPath','C:\Program Files\Java\jdk1.6.0_35');
insert into t_config (ID,MODELCODE,KEY,VALUE) values (SEQ_PRI_CONFIG.nextval,'com.soarsky.octopus.register.package','apkToolPath','D:\apktool');

insert into t_config (ID,MODELCODE,KEY,VALUE) values (SEQ_PRI_CONFIG.nextval,'com.soarsky.octopus.clientuser','finishGold','100');
insert into t_config (ID,MODELCODE,KEY,VALUE) values (SEQ_PRI_CONFIG.nextval,'com.soarsky.octopus.client.url','imageUrl','http://192.168.1.5:8083');


insert into t_config (ID,MODELCODE,KEY,VALUE) values (SEQ_PRI_CONFIG.nextval,'com.soarsky.octopus.path.upload','basePath','D:\upload');
insert into t_config (ID,MODELCODE,KEY,VALUE) values (SEQ_PRI_CONFIG.nextval,'com.soarsky.octopus.path.upload','imgPath','D:\upload\image\');
insert into t_config (ID,MODELCODE,KEY,VALUE) values (SEQ_PRI_CONFIG.nextval,'com.soarsky.octopus.path.upload','excelPath','D:\upload\excel\');
insert into t_config (ID,MODELCODE,KEY,VALUE) values (SEQ_PRI_CONFIG.nextval,'com.soarsky.octopus.path.upload','apkPath','D:\upload\apk\');
insert into t_config (ID,MODELCODE,KEY,VALUE) values (SEQ_PRI_CONFIG.nextval,'com.soarsky.octopus.path.upload','apkBasePath','D:\upload\apk\base\');
insert into t_config (ID,MODELCODE,KEY,VALUE) values (SEQ_PRI_CONFIG.nextval,'com.soarsky.octopus.path.upload','imgBasePath','D:\upload\image\base\');
insert into t_config (ID,MODELCODE,KEY,VALUE) values (SEQ_PRI_CONFIG.nextval,'com.soarsky.octopus.client.short.url','shortUrl','http://www.dwz.cn/867Su');

insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '奴隶', 0, '/image/base/NzE2ZWEzOTEtNDlkYi00YjU0LTg3ZDMtMTk5MzA3OTg0ZDg0.png', 0, 0);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '自由民', 500, '/image/base/NmZiNDc3M2UtMzAxZS00MTZiLWJkZTItNWZmYWUwNWMwZWEx.png', 0, 50);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '奴隶主', 1000, '/image/base/MzczYzZiZmMtNzlmMy00ZTJmLTk4NWItYjYwZGQxYmE4MGU5.png', 0, 100);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '男爵', 2000, '/image/base/ZmFhOTViZjctOGUxNi00ODcwLWI0NTMtYTc4YmUyNzM4MDcx.png', 0, 200);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '子爵', 4000, '/image/base/ZmRmZGNlMTgtOTIyMi00NjAwLWE1YzgtYzAxYWU5ZTQxMDY2.png', 0, 400);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '伯爵', 7000, '/image/base/MWM2OTA1ZWQtYmYwMi00N2U3LTk1YWMtOWJkZTVlMjlkNzI4.png', 0, 700);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '侯爵', 10000, '/image/base/ZmFkYmJkNDMtODVjYS00YzA1LWI5YTAtZjdkZTljYzMyMTll.png', 0, 1000);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '公爵', 15000, '/image/base/OTNlNjk0MWMtMTZjZS00MzQ5LWE3YjQtOTA1MTFkMmE0NzEy.png', 0, 1500);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '大公', 30000, '/image/base/ZTM4NWJiOGUtNzUxNC00OTZiLTgwZTUtNDY2ZDZiYWIzMGVk.png', 0, 3000);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '大公爵', 60000, '/image/base/NTI3ZjFkZjItNjZmZi00OTI4LTk2MzYtMWVhMjQyOTM1ZDRk.png', 0, 6000);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '王子', 100000, '/image/base/NTc0NWU4NzItYzFlOS00MGQzLThjZWEtN2I3NDJiZTUzODQ4.png', 0, 10000);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '王', 200000, '/image/base/YWQwYzg3YTMtYjQyOS00NTBlLWE2NDAtM2ViZTA4ZDNlYTE1.png', 0, 20000);
insert into T_USER_LEVEL (id, name, gold_num, image_url, isremove, reward_num) values (SEQ_PRI_USER_LEVEL.nextval, '帝', 500000, '/image/base/MDRkNWYzZGMtYzAxOC00MDgwLTk3YzYtNDU3ZTgzYzcwZTk1.png', 0, 50000);
