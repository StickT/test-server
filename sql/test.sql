/*
SQLyog v10.2 
MySQL - 5.7.12 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `field` */

DROP TABLE IF EXISTS `field`;

CREATE TABLE `field` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `http_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '所属请求',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '需要比较的字段名称',
  `pre_value` varchar(500) NOT NULL DEFAULT '' COMMENT '预期值',
  `select_value` varchar(500) NOT NULL DEFAULT '' COMMENT '测试后值',
  `result` int(1) NOT NULL DEFAULT '0' COMMENT '检测结果',
  `comments` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `created_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `field` */

/*Table structure for table `http_item` */

DROP TABLE IF EXISTS `http_item`;

CREATE TABLE `http_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `system_id` bigint(20) NOT NULL COMMENT '所属系统id',
  `group_id` bigint(20) NOT NULL COMMENT '所属分组id',
  `url` varchar(255) NOT NULL DEFAULT '' COMMENT 'url',
  `need_token` int(1) NOT NULL DEFAULT '0' COMMENT '是否需要token,默认为0不需要',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '请求类型',
  `path_param` varchar(1000) NOT NULL DEFAULT '' COMMENT '路径参数JSON字符串',
  `header` varchar(1000) NOT NULL DEFAULT '' COMMENT '请求头中参数JSON字符串',
  `body` varchar(1000) NOT NULL DEFAULT '' COMMENT '请求体中参数JSON字符串',
  `result` int(11) NOT NULL DEFAULT '0' COMMENT '结果',
  `query_sql` varchar(1000) NOT NULL DEFAULT '' COMMENT '查询测试后数据库的sql',
  `enabled` int(1) NOT NULL DEFAULT '1' COMMENT '是否启用,1为启用,0为停用',
  `comments` varchar(1000) NOT NULL DEFAULT '' COMMENT '备注',
  `created_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `GROUP_FOREIGN_KEY` (`group_id`,`system_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `http_item` */

/*Table structure for table `system` */

DROP TABLE IF EXISTS `system`;

CREATE TABLE `system` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '系统名称',
  `env` int(11) NOT NULL DEFAULT '0' COMMENT '系统对应的环境,1:测试机,2:branch,3:trunk',
  `basic_url` varchar(255) NOT NULL DEFAULT '' COMMENT '系统基础地址',
  `login_url` varchar(255) NOT NULL DEFAULT '' COMMENT '系统的登录地址',
  `login_type` int(1) NOT NULL DEFAULT '0' COMMENT '登陆请求的类型',
  `login_user` varchar(50) NOT NULL DEFAULT '' COMMENT '系统的登录用户',
  `login_password` varchar(50) NOT NULL DEFAULT '' COMMENT '系统用户的登录密码',
  `jdbc_url` varchar(255) NOT NULL DEFAULT '' COMMENT '测试数据库的url,包含用户名密码',
  `jdbc_type` int(1) NOT NULL DEFAULT '0' COMMENT '测试数据库类型,ORACLE/MYSQL',
  `created_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人名称',
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `SYSTEM_UNIQUE` (`name`,`env`,`basic_url`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `system` */

insert  into `system`(`id`,`name`,`env`,`basic_url`,`login_url`,`login_type`,`login_user`,`login_password`,`jdbc_url`,`jdbc_type`,`created_by`,`created_on`,`updated_by`,`updated_on`) values (1,'品控系统',2,'192.168.60.126:8101','/sys/webapi/login',1,'yaoyimin','1','',0,'admin','2018-02-05 17:10:19','admin','2018-02-07 17:15:52'),(2,'WMS',1,'192.168.1.1','wms',1,'admin','123456','',0,'admin','2018-02-07 17:30:10','admin','2018-02-08 15:57:45'),(3,'`12',1,'`12','`12',1,'`12','`12','',0,'admin','2018-02-08 16:47:28','admin','2018-02-08 16:47:28');

/*Table structure for table `system_group` */

DROP TABLE IF EXISTS `system_group`;

CREATE TABLE `system_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `system_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '系统id',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '分组名称',
  `enabled` int(1) NOT NULL DEFAULT '1' COMMENT '是否启用,1为启用,0为停用',
  `comments` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `created_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `SYSTEM_fOREIGN_KEY` (`system_id`),
  CONSTRAINT `SYSTEM_fOREIGN_KEY` FOREIGN KEY (`system_id`) REFERENCES `system` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `system_group` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` varchar(50) NOT NULL DEFAULT '' COMMENT '用户id',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `comments` varchar(255) NOT NULL DEFAULT '',
  `created_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `updated_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
