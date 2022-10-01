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
  `ct_payment_back` varchar(50) DEFAULT NULL COMMENT '回款金额',
  `ct_order` varchar(10) DEFAULT NULL COMMENT '第几次回款',
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
  `c_name` varchar(50) DEFAULT NULL COMMENT '单位类型：对应字典表的值',
  `c_depart` varchar(50) DEFAULT NULL COMMENT '客户所在公司的部门',
  `c_job` varchar(50) DEFAULT NULL COMMENT '客户职务',
  `c_tele` char(11) DEFAULT NULL COMMENT '电话',
  `c_post` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `c_hobby` varchar(255) DEFAULT NULL COMMENT '爱好',
  `c_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

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
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`e_id`,`rename`,`e_name`,`e_pwd`,`e_birthday`,`e_school`,`e_job`,`e_start_time`,`e_social_position`,`e_honor`,`e_remark`) values 
(32,'marry','marry','123','2002-01-12','张家界航院','销售','2002-01-12','党员','团员-无','良好'),
(33,'tom','tom','123','2002-12-09','张家界航院','销售','2002-12-09','党员','群众-无123','良好');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `interview` */

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(50) DEFAULT NULL COMMENT '项目名',
  `p_moeny` varchar(50) DEFAULT NULL COMMENT '项目金额',
  `p_progress` varchar(50) DEFAULT NULL COMMENT '项目进度，从字典表选择',
  `cp_id` int(11) DEFAULT NULL COMMENT '客户参与人员，多人',
  `ct_id` int(11) DEFAULT NULL COMMENT '合同详情',
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
