/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.7.20-log : Database - javaee
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`javaee` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `javaee`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_username` varchar(50) DEFAULT NULL,
  `a_password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`a_id`,`a_username`,`a_password`) values 
(1,'admin','admin');

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `class` */

insert  into `class`(`c_id`,`c_name`) values 
(1,'幼升一'),
(2,'一升二'),
(3,'二升三'),
(4,'三升四'),
(5,'四升五'),
(6,'五升六'),
(7,'六升七'),
(8,'七升八'),
(9,'八升九');

/*Table structure for table `class_type` */

DROP TABLE IF EXISTS `class_type`;

CREATE TABLE `class_type` (
  `ct_id` int(11) NOT NULL AUTO_INCREMENT,
  `ct_name` varchar(50) DEFAULT NULL,
  `ct_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`ct_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `class_type` */

insert  into `class_type`(`ct_id`,`ct_name`,`ct_price`) values 
(1,'大班',0),
(2,'小班',200),
(3,'一对一',2000);

/*Table structure for table `education` */

DROP TABLE IF EXISTS `education`;

CREATE TABLE `education` (
  `e_id` int(11) NOT NULL AUTO_INCREMENT,
  `e_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `education` */

insert  into `education`(`e_id`,`e_name`) values 
(1,'本科'),
(2,'大专'),
(3,'研究生');

/*Table structure for table `fack` */

DROP TABLE IF EXISTS `fack`;

CREATE TABLE `fack` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_start` varchar(100) DEFAULT NULL,
  `f_end` varchar(100) DEFAULT NULL,
  `f_reason` varchar(100) DEFAULT NULL,
  `f_status` varchar(100) DEFAULT NULL,
  `f_sId` int(11) DEFAULT NULL,
  PRIMARY KEY (`f_id`),
  KEY `f_sId` (`f_sId`),
  CONSTRAINT `fack_ibfk_1` FOREIGN KEY (`f_sId`) REFERENCES `student` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fack` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(50) DEFAULT NULL,
  `s_sex` char(20) DEFAULT NULL,
  `s_class` int(11) DEFAULT NULL,
  `s_classtype` int(11) DEFAULT NULL,
  `s_phone` varchar(50) DEFAULT NULL,
  `s_address` varchar(100) DEFAULT NULL,
  `s_date` datetime DEFAULT NULL,
  `s_tuition` int(11) DEFAULT NULL,
  `s_pwd` varchar(50) DEFAULT '111111',
  PRIMARY KEY (`s_id`),
  KEY `choose_class` (`s_class`),
  KEY `choose_class_type` (`s_classtype`),
  CONSTRAINT `choose_class` FOREIGN KEY (`s_class`) REFERENCES `class` (`c_id`),
  CONSTRAINT `choose_class_type` FOREIGN KEY (`s_classtype`) REFERENCES `class_type` (`ct_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`s_id`,`s_name`,`s_sex`,`s_class`,`s_classtype`,`s_phone`,`s_address`,`s_date`,`s_tuition`,`s_pwd`) values 
(29,'朱熙爱','男',9,1,'zxa','杜集区','2019-10-25 17:39:27',1200,'111111'),
(30,'王博','男',9,1,'wb','杜集区','2019-10-25 17:40:05',1200,'000000'),
(34,'王慧涵','女',8,1,'whh','杜集区','2019-10-26 23:07:37',900,'000000'),
(35,'张佳瑞','男',5,1,'zjr','杜集区','2019-10-27 10:36:31',900,'000000'),
(37,'陈思钰','女',2,1,'csy','杜集区','2019-10-27 10:44:34',900,'000000');

/*Table structure for table `student_subject` */

DROP TABLE IF EXISTS `student_subject`;

CREATE TABLE `student_subject` (
  `ss_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_id` int(11) DEFAULT NULL,
  `sub_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ss_id`),
  KEY `choose_student` (`s_id`),
  KEY `choose_subject` (`sub_id`),
  CONSTRAINT `choose_student` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`),
  CONSTRAINT `choose_subject` FOREIGN KEY (`sub_id`) REFERENCES `subject` (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=utf8;

/*Data for the table `student_subject` */

insert  into `student_subject`(`ss_id`,`s_id`,`sub_id`) values 
(160,30,2),
(161,30,3),
(162,30,4),
(163,30,5),
(167,35,1),
(168,35,2),
(169,35,3),
(171,37,1),
(172,37,2),
(173,37,3),
(178,29,2),
(179,29,3),
(180,29,4),
(181,29,5),
(182,34,2),
(183,34,3),
(184,34,5);

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `sub_id` int(11) NOT NULL AUTO_INCREMENT,
  `sub_name` varchar(50) DEFAULT NULL,
  `sub_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `subject` */

insert  into `subject`(`sub_id`,`sub_name`,`sub_price`) values 
(1,'语文',300),
(2,'数学',300),
(3,'英语',300),
(4,'化学',300),
(5,'物理',300);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(50) DEFAULT NULL,
  `t_sex` char(1) DEFAULT NULL,
  `t_phone` varchar(50) DEFAULT NULL,
  `t_school` varchar(50) DEFAULT NULL,
  `t_education` int(11) DEFAULT NULL,
  `t_address` varchar(100) DEFAULT NULL,
  `t_date` datetime DEFAULT NULL,
  PRIMARY KEY (`t_id`),
  KEY `choose_education` (`t_education`),
  CONSTRAINT `choose_education` FOREIGN KEY (`t_education`) REFERENCES `education` (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`t_id`,`t_name`,`t_sex`,`t_phone`,`t_school`,`t_education`,`t_address`,`t_date`) values 
(7,'lv','男','15255117173','安徽财贸职业学院',2,'遂溪县','2019-11-03 09:59:10'),
(8,'大沙发','男','暗室逢灯','阿斯蒂芬',1,'案发当时','2019-11-03 18:45:40'),
(9,'罗贵','男','123456','芜湖职业技术学院',2,'safas','2019-11-03 19:08:42'),
(10,'李澳','男','123456','安徽财贸职业学院',1,'亳州市','2019-11-03 19:10:53'),
(11,'李澳','女','123456','芜湖职业技术学院',1,'亳州市','2019-11-03 19:14:45'),
(12,'李澳','女','123456','芜湖职业技术学院',1,'亳州市','2019-11-03 19:14:53'),
(13,'李澳','女','123456','芜湖职业技术学院',1,'亳州市','2019-11-03 19:14:56'),
(14,'dasfdfs','男','fasdfsadf','asdf',2,'asfsdasadf','2019-11-03 19:59:11'),
(19,'李澳','男','123456','安徽财贸职业学院',2,'亳州市','2019-11-03 21:02:35'),
(22,'fsadfasd','女','asfds','asfdsdaf',1,'fdasdf','2019-11-03 22:05:00'),
(24,'李宵','女','未知','芜湖职业技术学院',3,'亳州市','2019-11-03 22:34:28'),
(25,'李帅帅','男','未知','皖南医学院',1,'亳州市','2019-11-03 22:36:09'),
(26,'张凯','男','未知','安徽财贸职业学院',2,'亳州市','2019-11-03 23:54:26');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
