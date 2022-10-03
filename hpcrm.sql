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
  `ct_id` int(11) NOT NULL,
  `ct_contract_amount` varchar(50) DEFAULT NULL COMMENT '合同金额',
  `ct_contract_docment` varchar(100) DEFAULT NULL COMMENT '合同文件url',
  `ct_tender_amount` varchar(50) DEFAULT NULL COMMENT '招标金额',
  `ct_tender_docment` varchar(100) DEFAULT NULL COMMENT '标书文件url',
  `p_id` int(11) DEFAULT NULL COMMENT '项目合同相关信息对应的项目',
  PRIMARY KEY (`ct_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contract` */

/*Table structure for table `cus_pro` */

DROP TABLE IF EXISTS `cus_pro`;

CREATE TABLE `cus_pro` (
  `cp_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL COMMENT '项目id',
  `c_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`cp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cus_pro` */

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`c_id`,`c_rename`,`c_name`,`c_depart`,`c_cie_type`,`c_job`,`c_tele`,`c_post`,`c_hobby`,`c_remark`) values 
(1,'jack','张家界航院','销售部','学校','销售','123','123@qq.com','唱歌','良好'),
(2,'jack','张家界航院','销售部','学校','销售','123','123@qq.com','唱歌','良好'),
(4,'jack','张家界航院','销售部','学校','销售','123','123@qq.com','唱歌','良好');

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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`e_id`,`rename`,`e_name`,`e_pwd`,`e_birthday`,`e_school`,`e_job`,`e_start_time`,`e_social_position`,`e_honor`,`e_remark`) values 
(2,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(3,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(4,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(5,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(6,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(7,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(8,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(9,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(10,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(11,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(12,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(13,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(14,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(15,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(16,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(17,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(18,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(19,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(20,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(21,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(22,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(23,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(24,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(26,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(27,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(28,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(29,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(30,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(31,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(32,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(33,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(34,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(35,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(36,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(37,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(38,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(39,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(40,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(41,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(42,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(43,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(44,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(45,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(46,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(47,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(48,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(49,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(50,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(51,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好'),
(52,'jack','jack','123','2002.05.59','张家界学院','销售','2010.12.11','党员','党员-省赛一等奖','良好'),
(53,'marry','marry','123','2002.05.59','张家界航院','销售','2002.01.12','党员','团员-无','良好'),
(54,'tom','tom','123','2002.05.59','张家界航院','销售','2002.12.09','党员','群众-无','良好');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `interview` */

insert  into `interview`(`i_id`,`i_company`,`c_id`,`i_visit_time`,`p_id`,`e_id`,`i_others`,`i_content`,`i_next`) values 
(1,'张家界航院',1,'2022-10-11',1,5,'肖某|王某','农村致富','下乡');

/*Table structure for table `payment_back` */

DROP TABLE IF EXISTS `payment_back`;

CREATE TABLE `payment_back` (
  `pb_id` int(11) NOT NULL,
  `pb_money` int(11) NOT NULL COMMENT '回款金额',
  `pb_order` int(11) NOT NULL AUTO_INCREMENT COMMENT '录入顺序，自增',
  KEY `pb_order` (`pb_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `payment_back` */

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
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project` */

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
('progress','项目进度');

/*Table structure for table `value_dic` */

DROP TABLE IF EXISTS `value_dic`;

CREATE TABLE `value_dic` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `v_value` varchar(50) DEFAULT NULL COMMENT '字典值',
  `type_code` varchar(50) DEFAULT NULL COMMENT '关联type_dic表',
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

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
(17,'结束',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
