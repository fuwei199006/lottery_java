/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21 : Database - lottery
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lottery` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lottery`;

/*Table structure for table `tbl_lottery` */

DROP TABLE IF EXISTS `tbl_lottery`;

CREATE TABLE `tbl_lottery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lottery_no` int(11) NOT NULL,
  `lottery_date` varchar(20) NOT NULL,
  `red_ball1` varchar(10) NOT NULL,
  `red_ball2` varchar(10) NOT NULL,
  `red_ball3` varchar(10) NOT NULL,
  `red_ball4` varchar(10) NOT NULL,
  `red_ball5` varchar(10) NOT NULL,
  `red_ball6` varchar(10) NOT NULL,
  `blue_ball` varchar(10) NOT NULL,
  `first_items` bigint(20) DEFAULT '0' COMMENT '一等奖注数',
  `first_award` bigint(20) DEFAULT '0' COMMENT '一等奖奖金',
  `second_items` bigint(20) DEFAULT '0' COMMENT '二等奖注数',
  `second_award` bigint(20) DEFAULT '0' COMMENT '二等奖奖金',
  `total_award` bigint(20) DEFAULT '0' COMMENT '总奖金',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `lottery_date_index` (`lottery_date`)
) ENGINE=InnoDB AUTO_INCREMENT=2293 DEFAULT CHARSET=utf8;

/*Table structure for table `tbl_lottery_forecast_log` */

DROP TABLE IF EXISTS `tbl_lottery_forecast_log`;

CREATE TABLE `tbl_lottery_forecast_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `lottery_no` int(11) NOT NULL COMMENT '彩票的期数',
  `forecast_method` int(11) NOT NULL COMMENT '预测方法',
  `red_ball1` varchar(10) NOT NULL COMMENT '红球1',
  `red_ball2` varchar(10) NOT NULL COMMENT '红球2',
  `red_ball3` varchar(10) NOT NULL COMMENT '红球3',
  `red_ball4` varchar(10) NOT NULL COMMENT '红球4',
  `red_ball5` varchar(10) NOT NULL COMMENT '红球5',
  `red_ball6` varchar(10) NOT NULL COMMENT '红球6',
  `blue_ball` varchar(10) NOT NULL COMMENT '蓝球',
  `item_count` int(11) NOT NULL COMMENT '注数',
  `award_class` varchar(20) NOT NULL COMMENT '几等奖',
  `award_amount` int(11) NOT NULL COMMENT '盈利多少',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tbl_quick_three_lottery` */

DROP TABLE IF EXISTS `tbl_quick_three_lottery`;

CREATE TABLE `tbl_quick_three_lottery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lottery_no` int(11) NOT NULL,
  `ball1` int(11) NOT NULL,
  `ball2` int(11) NOT NULL,
  `ball3` int(11) NOT NULL,
  `ball_sum` int(11) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `award_type` varchar(30) NOT NULL COMMENT '中奖形式',
  PRIMARY KEY (`id`),
  KEY `lottery_no_index` (`lottery_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='彩票数据';

/*Table structure for table `tbl_quick_three_lottery_forecast` */

DROP TABLE IF EXISTS `tbl_quick_three_lottery_forecast`;

CREATE TABLE `tbl_quick_three_lottery_forecast` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `lottery_no` int(11) NOT NULL COMMENT '彩票的期数',
  `forecast_method` int(11) NOT NULL COMMENT '预测方法',
  `ball1` int(11) NOT NULL COMMENT '球1',
  `ball2` int(11) NOT NULL COMMENT '球2',
  `ball3` int(11) NOT NULL COMMENT '球3',
  `ball_sum` int(11) NOT NULL,
  `award_type` varchar(30) NOT NULL COMMENT '中奖类型',
  `item_count` int(11) NOT NULL COMMENT '注数',
  `award_amount` int(11) NOT NULL COMMENT '盈利多少',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
