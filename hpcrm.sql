/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.35-log : Database - hpcrm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hpcrm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hpcrm`;

/*Table structure for table `contract` */

DROP TABLE IF EXISTS `contract`;

CREATE TABLE `contract` (
  `ct_id` int(11) NOT NULL AUTO_INCREMENT,
  `ct_contract_amount` varchar(50) DEFAULT NULL COMMENT '合同金额',
  `ct_contract_docment` varchar(100) DEFAULT NULL COMMENT '合同文件url',
  `ct_tender_amount` varchar(50) DEFAULT NULL COMMENT '招标金额',
  `ct_tender_docment` varchar(100) DEFAULT NULL COMMENT '标书文件url',
  `p_id` int(11) DEFAULT NULL COMMENT '项目合同相关信息对应的项目',
  PRIMARY KEY (`ct_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `contract` */

insert  into `contract`(`ct_id`,`ct_contract_amount`,`ct_contract_docment`,`ct_tender_amount`,`ct_tender_docment`,`p_id`) values (6,'',NULL,'',NULL,13),(8,'1',NULL,'1',NULL,20),(9,'',NULL,'',NULL,43);

/*Table structure for table `cus_pro` */

DROP TABLE IF EXISTS `cus_pro`;

CREATE TABLE `cus_pro` (
  `cp_id` int(11) NOT NULL,
  `p_id` int(11) DEFAULT NULL COMMENT '项目id',
  `c_id` int(11) DEFAULT NULL COMMENT '用户id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cus_pro` */

insert  into `cus_pro`(`cp_id`,`p_id`,`c_id`) values (1,1,1),(2,2,1),(1,1,2),(2,2,2),(6,6,2),(6,6,1),(8,8,1),(7,7,4),(14,14,2),(15,15,2),(10,10,2),(9,9,2),(5,5,2),(5,5,1),(12,12,2),(19,19,2),(13,13,1),(20,20,13),(36,36,12),(35,35,12),(34,34,12),(33,33,12),(32,32,12),(31,31,13),(30,30,13),(29,29,12),(27,27,12),(25,25,12),(26,26,12),(24,24,13),(23,23,12),(22,22,13),(21,21,12),(37,37,24),(38,38,24),(39,39,24),(41,41,24),(40,40,24),(28,28,12),(42,42,24),(43,43,25),(44,44,13);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_rename` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `c_name` varchar(50) DEFAULT NULL COMMENT '单位名称',
  `c_depart` varchar(50) DEFAULT NULL COMMENT '所在部门',
  `c_cie_type` varchar(255) DEFAULT NULL COMMENT '单位类型',
  `c_job` varchar(50) DEFAULT NULL COMMENT '客户职务',
  `c_tele` char(11) DEFAULT NULL COMMENT '电话',
  `c_post` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `c_hobby` varchar(255) DEFAULT NULL COMMENT '爱好',
  `c_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`c_id`,`c_rename`,`c_name`,`c_depart`,`c_cie_type`,`c_job`,`c_tele`,`c_post`,`c_hobby`,`c_remark`) values (12,'张叫兽','湖南理工职业学院','信息工程','学校','教授','13233445654','10086@qq.com','唱跳Rap','这是一个教授'),(13,'刘砖家','湖南烟草公司','财务部','国企','财务','13344532331','10010@qq.com','抽烟','这是财务'),(14,'21','2121','','其他','教授','2121','','',''),(15,'1','2121','','其他','教授','21','','',''),(16,'2121','2121','','其他','教授','21','','',''),(17,'2121','2121','','其他','教授','21','','',''),(18,'2121','2121','','其他','教授','21','','',''),(19,'2121','2121','','其他','教授','21','','',''),(20,'2121','2121','','其他','教授','2121','','',''),(21,'211','2112','','其他','教授','2121','','',''),(22,'211','2112','','其他','教授','2121','','',''),(23,'211','2112','','其他','教授','2121','','',''),(25,'1','1','','其他','教授','1','','','');

/*Table structure for table `emp_role` */

DROP TABLE IF EXISTS `emp_role`;

CREATE TABLE `emp_role` (
  `er_id` int(11) NOT NULL AUTO_INCREMENT,
  `e_id` int(11) DEFAULT NULL,
  `r_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`er_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `emp_role` */

insert  into `emp_role`(`er_id`,`e_id`,`r_id`) values (9,4,11),(10,4,12),(20,5,13),(22,1,14),(24,10,15);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `e_id` int(11) NOT NULL AUTO_INCREMENT,
  `rename` varchar(50) DEFAULT NULL COMMENT '姓名',
  `e_name` varchar(50) DEFAULT NULL COMMENT '账号',
  `e_pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `e_birthday` char(10) DEFAULT NULL COMMENT '生日：十位，精确到日',
  `e_school` varchar(255) DEFAULT NULL COMMENT '毕业院校',
  `e_job` varchar(50) DEFAULT NULL COMMENT '岗位性质需，要从字典表选择',
  `e_start_time` char(10) DEFAULT NULL COMMENT '入司时间',
  `e_social_position` varchar(50) DEFAULT NULL COMMENT '社会职务',
  `e_honor` varchar(255) DEFAULT NULL COMMENT '社会荣誉',
  `e_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`e_id`,`rename`,`e_name`,`e_pwd`,`e_birthday`,`e_school`,`e_job`,`e_start_time`,`e_social_position`,`e_honor`,`e_remark`) values (1,'系统管理员','admin','admin','2022-10-30','无','其他','2022-10-08','无','无','默认系统管理员，不能删除，修改'),(10,'陈伟名','cwm','123','2022-10-30','张家界航院','销售','2022-10-30','无','无','无'),(11,'彭潇','px','123','2022-10-30','','销售','','','','');

/*Table structure for table `interview` */

DROP TABLE IF EXISTS `interview`;

CREATE TABLE `interview` (
  `i_id` int(11) NOT NULL AUTO_INCREMENT,
  `i_company` varchar(255) DEFAULT NULL COMMENT '客户单位',
  `c_id` int(11) DEFAULT NULL COMMENT '客户人员',
  `i_visit_time` char(10) DEFAULT NULL COMMENT '拜访时间，固定位精确到日',
  `p_id` int(11) DEFAULT NULL COMMENT '拜访类型，从project中选择',
  `e_id` int(11) DEFAULT NULL COMMENT '我方参与人员',
  `i_others` varchar(255) DEFAULT NULL COMMENT '第三方人员',
  `i_content` varchar(255) DEFAULT NULL COMMENT '内容摘要',
  `i_next` varchar(255) DEFAULT NULL COMMENT '下一步计划',
  PRIMARY KEY (`i_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `interview` */

insert  into `interview`(`i_id`,`i_company`,`c_id`,`i_visit_time`,`p_id`,`e_id`,`i_others`,`i_content`,`i_next`) values (41,'湖南烟草公司',13,'2022-10-30',0,10,'','',''),(42,'湖南烟草公司',13,'2022-10-30',20,10,'无','',''),(43,'212',15,'2022-10-30',0,1,'','',''),(44,'2121',20,'2022-10-30',0,1,'','',''),(46,'2121',20,'2022-09-29',0,1,'','',''),(47,'121',20,'2022-10-13',24,1,'','',''),(49,'2121',20,'2022-10-30',21,1,'','',''),(51,'湖南理工职业学院',20,'2022-10-21',23,11,'','',''),(52,'1',25,'2022-10-30',0,11,'','','');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_code` varchar(50) DEFAULT NULL,
  `cur_code` varchar(50) DEFAULT NULL,
  `m_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`m_id`,`parent_code`,`cur_code`,`m_name`) values (1,'0','10','客户管理'),(2,'0','20','访谈记录'),(3,'0','30','项目管理'),(4,'0','40','报表统计'),(5,'0','50','权限管理'),(6,'10','1010','查询客户信息'),(7,'10','1020','添加客户信息'),(8,'10','1030','删除客户信息'),(9,'10','1040','修改客户信息'),(10,'10','1050','导入客户信息'),(11,'10','1060','导出客户信息'),(12,'20','2010','查询访谈记录'),(13,'20','2020','添加访谈记录'),(14,'20','2030','导出访谈记录'),(15,'30','3010','查询项目信息'),(16,'30','3020','添加项目信息'),(17,'30','3030','修改项目信息'),(18,'50','5010','数据字典'),(19,'50','5020','员工管理'),(20,'50','5030','授权信息'),(21,'5010','501010','查询字典信息'),(22,'5010','501020','添加字典信息'),(23,'5020','502010','查询员工信息'),(24,'5020','502020','添加员工信息'),(25,'5020','502030','修改员工信息'),(26,'5020','502040','删除员工信息'),(27,'5020','502050','导入员工信息'),(28,'5020','502060','导出员工信息'),(33,'20','2040','删除访谈记录'),(34,'20','2050','修改访谈记录'),(35,'30','3040','删除项目信息'),(37,'5010','501030','修改字典信息'),(38,'5010','501040','删除字典信息'),(40,'30','3050','合同管理'),(41,'30','3060','回款管理'),(42,'3050','305010','查询合同信息'),(43,'3050','305020','添加合同信息'),(44,'3050','305030','删除合同信息'),(45,'3050','305040','修改合同信息'),(46,'3060','306010','查询回款信息'),(47,'3060','306020','添加回款信息'),(48,'3060','306030','删除回款信息'),(49,'3060','306040','修改回款信息'),(50,'5020','502070','员工授权');

/*Table structure for table `payment_back` */

DROP TABLE IF EXISTS `payment_back`;

CREATE TABLE `payment_back` (
  `pb_id` int(11) NOT NULL,
  `pb_money` int(11) NOT NULL COMMENT '回款金额',
  `pb_order` int(11) NOT NULL AUTO_INCREMENT COMMENT '录入顺序，自增',
  `pb_time` char(10) DEFAULT NULL COMMENT '回款时间',
  KEY `pb_order` (`pb_order`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8;

/*Data for the table `payment_back` */

insert  into `payment_back`(`pb_id`,`pb_money`,`pb_order`,`pb_time`) values (1001,12000,1,'2022-10-08'),(1003,12000,3,'2022-10-08'),(1004,12000,4,'2022-10-08'),(1006,12000,6,'2022-10-08'),(2001,12000,2,'2022-10-08'),(2002,12000,5,'2022-10-08'),(2003,12000,3,'2022-10-08'),(2007,12000,5,'2022-10-08'),(2006,12000,5,'2022-10-08'),(2005,12000,5,'2022-10-08'),(2008,12000,127,'2022-10-08'),(2009,12000,128,'2022-10-08'),(6001,12000,129,'2022-10-08'),(5001,12000,130,'2022-10-08'),(8001,12000,131,'2022-10-08'),(10001,12000,133,'2022-10-08'),(6002,12000,139,'2022-10-08'),(6003,12000,140,'2022-10-08'),(10002,12000,141,'2022-10-08'),(10003,12000,142,'2022-10-08'),(10004,12000,143,'2022-10-08'),(10005,12000,144,'2022-10-08'),(10006,12000,145,'2022-10-08'),(6004,12000,146,'2022-10-08'),(7001,12000,147,'2022-10-08'),(10007,12312,148,'2022-10-08'),(12001,12002,149,'2022-10-08'),(13001,112322,152,'2022-10-29'),(20001,100,155,'2022-10-30'),(20002,200,156,'2022-10-13'),(21001,50,163,''),(36001,50,164,''),(42001,90,165,''),(28001,10,166,'');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(50) DEFAULT NULL COMMENT '项目名',
  `p_moeny` varchar(50) DEFAULT NULL COMMENT '项目金额',
  `p_progress` varchar(50) DEFAULT NULL COMMENT '项目进度，从字典表选择',
  `p_owner` varchar(50) DEFAULT NULL COMMENT '项目负责人',
  `cp_id` int(11) DEFAULT NULL COMMENT '客户参与人员，多人',
  `pb_id` int(11) DEFAULT NULL COMMENT '回款表的id，要回款5次需要一张新表',
  `startTime` char(10) DEFAULT NULL COMMENT '项目开始时间',
  `endTime` char(10) DEFAULT NULL COMMENT '项目结束时间',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`p_id`,`p_name`,`p_moeny`,`p_progress`,`p_owner`,`cp_id`,`pb_id`,`startTime`,`endTime`) values (44,'工地项目','100','施工','陈伟名',44,44000,'2022-10-30','');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_name` varchar(50) DEFAULT NULL,
  `r_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`r_id`,`r_name`,`r_remark`) values (14,'系统管理员','系统默认管理员，不能删除修改，拥有最高权限'),(15,'管理员','自定义的管理员');

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `rm_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_id` int(11) DEFAULT NULL,
  `r_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9090 DEFAULT CHARSET=utf8;

/*Data for the table `role_menu` */

insert  into `role_menu`(`rm_id`,`m_id`,`r_id`) values (5899,1,13),(5900,6,13),(5901,7,13),(5902,8,13),(5903,9,13),(5904,10,13),(5905,11,13),(5906,2,13),(5907,12,13),(5908,13,13),(5909,14,13),(5910,33,13),(5911,34,13),(5912,3,13),(5913,15,13),(5914,16,13),(5915,17,13),(5916,35,13),(5917,40,13),(5918,42,13),(5919,43,13),(5920,44,13),(5921,45,13),(5922,41,13),(5923,46,13),(5924,47,13),(5925,48,13),(5926,49,13),(5927,4,13),(5928,5,13),(5929,18,13),(5930,21,13),(5931,22,13),(5932,37,13),(5933,38,13),(5934,19,13),(5935,23,13),(5936,24,13),(6087,1,11),(6088,6,11),(6089,7,11),(6090,8,11),(6091,9,11),(6092,10,11),(6093,11,11),(6094,2,11),(6095,12,11),(6096,13,11),(6097,14,11),(6098,33,11),(6099,34,11),(6100,3,11),(6101,15,11),(6102,16,11),(6103,17,11),(6104,35,11),(6105,40,11),(6106,42,11),(6107,43,11),(6108,44,11),(6109,45,11),(6110,41,11),(6111,46,11),(6112,47,11),(6113,48,11),(6114,49,11),(6115,4,11),(6116,5,11),(6117,18,11),(6118,21,11),(6119,22,11),(6120,37,11),(6121,38,11),(6122,19,11),(6123,23,11),(6124,24,11),(6125,25,11),(6126,26,11),(6127,27,11),(6128,28,11),(6129,50,11),(6130,20,11),(6286,1,14),(6287,6,14),(6288,7,14),(6289,8,14),(6290,9,14),(6291,10,14),(6292,11,14),(6293,2,14),(6294,12,14),(6295,13,14),(6296,14,14),(6297,33,14),(6298,34,14),(6299,3,14),(6300,15,14),(6301,16,14),(6302,17,14),(6303,35,14),(6304,40,14),(6305,42,14),(6306,43,14),(6307,44,14),(6308,45,14),(6309,41,14),(6310,46,14),(6311,47,14),(6312,48,14),(6313,49,14),(6314,4,14),(6315,5,14),(6316,18,14),(6317,21,14),(6318,22,14),(6319,37,14),(6320,38,14),(6321,19,14),(6322,23,14),(6323,24,14),(6324,25,14),(6325,26,14),(6326,27,14),(6327,28,14),(6328,50,14),(6329,20,14),(9047,1,15),(9048,6,15),(9049,7,15),(9050,8,15),(9051,9,15),(9052,10,15),(9053,11,15),(9054,2,15),(9055,12,15),(9056,13,15),(9057,14,15),(9058,33,15),(9059,34,15),(9060,3,15),(9061,15,15),(9062,16,15),(9063,17,15),(9064,35,15),(9065,40,15),(9066,42,15),(9067,43,15),(9068,44,15),(9069,45,15),(9070,41,15),(9071,46,15),(9072,47,15),(9073,48,15),(9074,49,15),(9075,4,15),(9076,5,15),(9077,18,15),(9078,21,15),(9079,22,15),(9080,37,15),(9081,38,15),(9082,19,15),(9083,23,15),(9084,24,15),(9085,25,15),(9086,26,15),(9087,27,15),(9088,28,15),(9089,50,15);

/*Table structure for table `type_dic` */

DROP TABLE IF EXISTS `type_dic`;

CREATE TABLE `type_dic` (
  `code` varchar(50) DEFAULT NULL COMMENT '字典code',
  `type` varchar(50) DEFAULT NULL COMMENT '字典类型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `type_dic` */

insert  into `type_dic`(`code`,`type`) values ('jobType','岗位性质'),('companyType','单位类型'),('progress','项目进度'),('schoolType','院校岗位');

/*Table structure for table `value_dic` */

DROP TABLE IF EXISTS `value_dic`;

CREATE TABLE `value_dic` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `v_value` varchar(50) DEFAULT NULL COMMENT '字典值',
  `type_code` varchar(50) DEFAULT NULL COMMENT '关联type_dic表',
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `value_dic` */

insert  into `value_dic`(`v_id`,`v_value`,`type_code`) values (1,'售前','jobType'),(2,'售后','jobType'),(3,'销售','jobType'),(4,'商务','jobType'),(5,'财务','jobType'),(6,'其他','jobType'),(7,'学校','companyType'),(8,'国企','companyType'),(9,'政府机构','companyType'),(10,'名气外企','companyType'),(11,'其他','companyType'),(12,'意向','progress'),(13,'方案','progress'),(14,'招标','progress'),(15,'合同','progress'),(16,'回款','progress'),(17,'项目完结','progress'),(18,'校长','schoolType'),(19,'书记','schoolType'),(20,'教学副校长','schoolType'),(21,'其他副校长','schoolType'),(22,'二级学院院长','schoolType'),(23,'二级学院副院长','schoolType'),(24,'教研室主任','schoolType'),(25,'专业带头人','schoolType'),(26,'老师','schoolType'),(27,'立项','progress'),(28,'项目终止','progress'),(29,'施工','progress'),(30,'教授','jobType');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
