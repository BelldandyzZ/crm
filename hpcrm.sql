/*
SQLyog Enterprise v13.1.1 (64 bit)
MySQL - 5.5.27 : Database - hpcrm
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `contract` */

insert  into `contract`(`ct_id`,`ct_contract_amount`,`ct_contract_docment`,`ct_tender_amount`,`ct_tender_docment`,`p_id`) values 
(1,'1','646-e8bca275fca1修改crm.txt','12312','50e-aaa398ce4141修改crm.txt',13);

/*Table structure for table `cus_pro` */

DROP TABLE IF EXISTS `cus_pro`;

CREATE TABLE `cus_pro` (
  `cp_id` int(11) NOT NULL,
  `p_id` int(11) DEFAULT NULL COMMENT '项目id',
  `c_id` int(11) DEFAULT NULL COMMENT '用户id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cus_pro` */

insert  into `cus_pro`(`cp_id`,`p_id`,`c_id`) values 
(1,1,1),
(2,2,1),
(1,1,2),
(2,2,2),
(6,6,2),
(6,6,1),
(8,8,1),
(7,7,4),
(14,14,2),
(15,15,2),
(10,10,2),
(9,9,2),
(5,5,2),
(5,5,1),
(12,12,2),
(19,19,2),
(13,13,1);

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`c_id`,`c_rename`,`c_name`,`c_depart`,`c_cie_type`,`c_job`,`c_tele`,`c_post`,`c_hobby`,`c_remark`) values 
(1,'张三','张家界航院','销售部','学校','售后','123','123@qq.com','唱歌','良好'),
(2,'李四','张家界航院','销售部','学校','销售','123','123@qq.com','唱歌','良好'),
(4,'王五','张家界航院','销售部','学校','销售','123','123@qq.com','唱歌','良好');

/*Table structure for table `emp_role` */

DROP TABLE IF EXISTS `emp_role`;

CREATE TABLE `emp_role` (
  `er_id` int(11) NOT NULL AUTO_INCREMENT,
  `e_id` int(11) DEFAULT NULL,
  `r_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`er_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `emp_role` */

insert  into `emp_role`(`er_id`,`e_id`,`r_id`) values 
(9,4,11),
(10,4,12),
(12,5,11),
(19,1,11);

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`e_id`,`rename`,`e_name`,`e_pwd`,`e_birthday`,`e_school`,`e_job`,`e_start_time`,`e_social_position`,`e_honor`,`e_remark`) values 
(1,'超管','admin','admin','2022-10-08','张家界学院','售后','2022-10-08','党员','党员-省赛一等奖','良好'),
(2,'john','john','123','2022-10-01','张家界航院','售前','2022-10-10','党员','党员','良好'),
(3,'tom','tom','123','2022-10-01','张家界航院','售前','2022-10-01','党员','群众-无','良好'),
(4,'xxz','xxz','123','2022-10-01','张家界航院','售前','2022-10-10','党员','党员','良好'),
(5,'marry','marry','123','2022-10-01','张家界航院','售前','2022-10-01','党员','团员-无','良好'),
(9,'123','123','123','','','售前','','党员','','');

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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `interview` */

insert  into `interview`(`i_id`,`i_company`,`c_id`,`i_visit_time`,`p_id`,`e_id`,`i_others`,`i_content`,`i_next`) values 
(1,'张家界航院',1,'2022-10-01',1,5,'肖某|王某','农村致富','下乡'),
(13,'厚朴公司',2,'2022-10-03',1,4,'jack|marry','牛逼','揍你'),
(14,'厚朴公司',2,'2022-10-03',1,4,'jack|marry','牛逼','揍你'),
(15,'厚朴公司',1,'2022-10-03',2,2,'jack|marry','牛逼','揍你'),
(18,'热望亲热去',2,'2022-10-08',1,4,'大是大非','撒旦发射点','发放'),
(19,'热望亲热去',1,'2022-10-08',1,4,'大是大非','撒旦发射点','发放'),
(20,'热望亲热去',4,'2022-10-08',1,4,'大是大非','撒旦发射点','发放'),
(21,'123',1,'2022-10-09',1,1,'jack|marry','123','123'),
(24,'厚朴公司',2,'2022-10-14',5,1,'jack|marry','123','123'),
(25,'厚朴公司',1,'2022-10-14',5,1,'jack|marry','123','123'),
(28,'厚朴公司123',2,'2022-10-14',9,6,'jack|marry','牛逼','揍你'),
(29,'厚朴公司123',1,'2022-10-14',9,6,'jack|marry','牛逼','揍你'),
(37,'的期望',2,'2022-10-29',NULL,3,'jack|marry','去问驱蚊器','请问请问'),
(38,'大大大大大大',2,'2022-10-29',-1,4,'jack|marry','顶顶顶顶顶','大大大大大大');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_code` varchar(50) DEFAULT NULL,
  `cur_code` varchar(50) DEFAULT NULL,
  `m_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`m_id`,`parent_code`,`cur_code`,`m_name`) values 
(1,'0','10','客户管理'),
(2,'0','20','访谈记录'),
(3,'0','30','项目管理'),
(4,'0','40','报表统计'),
(5,'0','50','权限管理'),
(6,'10','1010','查询客户信息'),
(7,'10','1020','添加客户信息'),
(8,'10','1030','删除客户信息'),
(9,'10','1040','修改客户信息'),
(10,'10','1050','导入客户信息'),
(11,'10','1060','导出客户信息'),
(12,'20','2010','查询访谈记录'),
(13,'20','2020','添加访谈记录'),
(14,'20','2030','导出访谈记录'),
(15,'30','3010','查看项目信息'),
(16,'30','3020','添加项目信息'),
(17,'30','3030','修改项目信息'),
(18,'50','5010','数据字典'),
(19,'50','5020','员工管理'),
(20,'50','5030','授权信息'),
(21,'5010','501010','查看字典信息'),
(22,'5010','501020','添加字典信息'),
(23,'5020','502010','查看员工信息'),
(24,'5020','502020','添加员工信息'),
(25,'5020','502030','修改员工信息'),
(26,'5020','502040','删除员工信息'),
(27,'5020','502050','导入员工信息'),
(28,'5020','502060','导出员工信息'),
(29,'5030','503010','查看角色信息'),
(30,'5030','503020','删除角色信息'),
(31,'5030','503030','修改角色信息'),
(32,'5030','503040','角色资源绑定');

/*Table structure for table `payment_back` */

DROP TABLE IF EXISTS `payment_back`;

CREATE TABLE `payment_back` (
  `pb_id` int(11) NOT NULL,
  `pb_money` int(11) NOT NULL COMMENT '回款金额',
  `pb_order` int(11) NOT NULL AUTO_INCREMENT COMMENT '录入顺序，自增',
  `pb_time` char(10) DEFAULT NULL COMMENT '回款时间',
  KEY `pb_order` (`pb_order`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8;

/*Data for the table `payment_back` */

insert  into `payment_back`(`pb_id`,`pb_money`,`pb_order`,`pb_time`) values 
(1001,12000,1,'2022-10-08'),
(1003,12000,3,'2022-10-08'),
(1004,12000,4,'2022-10-08'),
(1006,12000,6,'2022-10-08'),
(2001,12000,2,'2022-10-08'),
(2002,12000,5,'2022-10-08'),
(2003,12000,3,'2022-10-08'),
(2007,12000,5,'2022-10-08'),
(2006,12000,5,'2022-10-08'),
(2005,12000,5,'2022-10-08'),
(2008,12000,127,'2022-10-08'),
(2009,12000,128,'2022-10-08'),
(6001,12000,129,'2022-10-08'),
(5001,12000,130,'2022-10-08'),
(8001,12000,131,'2022-10-08'),
(10001,12000,133,'2022-10-08'),
(6002,12000,139,'2022-10-08'),
(6003,12000,140,'2022-10-08'),
(10002,12000,141,'2022-10-08'),
(10003,12000,142,'2022-10-08'),
(10004,12000,143,'2022-10-08'),
(10005,12000,144,'2022-10-08'),
(10006,12000,145,'2022-10-08'),
(6004,12000,146,'2022-10-08'),
(7001,12000,147,'2022-10-08'),
(10007,12312,148,'2022-10-08'),
(12001,12002,149,'2022-10-08'),
(13001,112322,152,'2022-10-29');

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`p_id`,`p_name`,`p_moeny`,`p_progress`,`p_owner`,`cp_id`,`pb_id`,`startTime`,`endTime`) values 
(1,'工地项目(点击查看对应的合同表)1','1000000','招标','jack',1,1000,'2022-10-01','2022-10-30'),
(2,'工地项目2','1000000','招标','jack',2,2000,'2022-10-08','2022-10-30'),
(5,'创业','120000','意向','xxz',5,5000,'2022-10-03','2022-10-30'),
(6,'创业2','120000','方案','marry',6,6000,'2022-10-08','2022-10-30'),
(7,'创业4','120000','意向','jack',7,7000,'2022-10-03','2022-10-30'),
(8,'创业3','120000','回款','jack',8,8000,'2022-10-01','2022-10-30'),
(9,'123','120000','意向','超管',9,9000,'2022-10-08','2022-10-30'),
(10,'1232','120000','意向','超管',10,10000,'2022-10-01','2022-10-30'),
(12,'312','120000','意向','xxz',12,12000,'2022-10-08','2022-10-30'),
(13,'666','120000','方案','tom',13,13000,'2022-11-05','2022-11-27');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_name` varchar(50) DEFAULT NULL,
  `r_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`r_id`,`r_name`,`r_remark`) values 
(11,'管理员','fasd'),
(12,'销售','212313'),
(13,'前台','313');

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `rm_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_id` int(11) DEFAULT NULL,
  `r_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1322 DEFAULT CHARSET=utf8;

/*Data for the table `role_menu` */

insert  into `role_menu`(`rm_id`,`m_id`,`r_id`) values 
(1290,1,11),
(1291,6,11),
(1292,7,11),
(1293,8,11),
(1294,9,11),
(1295,10,11),
(1296,11,11),
(1297,2,11),
(1298,12,11),
(1299,13,11),
(1300,14,11),
(1301,3,11),
(1302,15,11),
(1303,16,11),
(1304,17,11),
(1305,4,11),
(1306,5,11),
(1307,18,11),
(1308,21,11),
(1309,22,11),
(1310,19,11),
(1311,23,11),
(1312,24,11),
(1313,25,11),
(1314,26,11),
(1315,27,11),
(1316,28,11),
(1317,20,11),
(1318,29,11),
(1319,30,11),
(1320,31,11),
(1321,32,11);

/*Table structure for table `type_dic` */

DROP TABLE IF EXISTS `type_dic`;

CREATE TABLE `type_dic` (
  `code` varchar(50) DEFAULT NULL COMMENT '字典code',
  `type` varchar(50) DEFAULT NULL COMMENT '字典类型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `type_dic` */

insert  into `type_dic`(`code`,`type`) values 
('jobType','岗位性质'),
('companyType','单位类型'),
('progress','项目进度'),
('schoolType','院校岗位');

/*Table structure for table `value_dic` */

DROP TABLE IF EXISTS `value_dic`;

CREATE TABLE `value_dic` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `v_value` varchar(50) DEFAULT NULL COMMENT '字典值',
  `type_code` varchar(50) DEFAULT NULL COMMENT '关联type_dic表',
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `value_dic` */

insert  into `value_dic`(`v_id`,`v_value`,`type_code`) values 
(1,'售前','jobType'),
(2,'售后','jobType'),
(3,'销售','jobType'),
(4,'商务','jobType'),
(5,'财务','jobType'),
(6,'其他','jobType'),
(7,'学校','companyType'),
(8,'国企','companyType'),
(9,'政府机构','companyType'),
(10,'名气外企','companyType'),
(11,'其他','companyType'),
(12,'意向','progress'),
(13,'方案','progress'),
(14,'招标','progress'),
(15,'合同','progress'),
(16,'回款','progress'),
(17,'项目完结','progress'),
(18,'校长','schoolType'),
(19,'书记','schoolType'),
(20,'教学副校长','schoolType'),
(21,'其他副校长','schoolType'),
(22,'二级学院院长','schoolType'),
(23,'二级学院副院长','schoolType'),
(24,'教研室主任','schoolType'),
(25,'专业带头人','schoolType'),
(26,'老师','schoolType'),
(27,'立项','progress'),
(28,'项目终止','progress'),
(29,'施工','progress');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
