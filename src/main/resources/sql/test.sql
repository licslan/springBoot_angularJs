#建立数据库
CREATE DATABASE 数据库名;

#建立表
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` varchar(36) NOT NULL,
  `order_no` varchar(50) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
 ) ENGINE=MyISAM DEFAULT CHARSET=utf8;
