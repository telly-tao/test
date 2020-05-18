/*
Navicat MySQL Data Transfer

Source Server         : myCount
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : db_test

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2020-05-17 20:41:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sex` char(4) NOT NULL,
  `jg` varchar(50) NOT NULL,
  `jianjie` varchar(255) NOT NULL,
  `love` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ_tb_user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('44', 'admin1', '202cb962ac59075b964b07152d234b70', '女', '吉林省', '一号管理员', '排球,');
INSERT INTO `tb_user` VALUES ('45', 'admin2', '900150983cd24fb0d6963f7d28e17f72', '男', '吉林省', '二号管理员', '篮球, 足球');
