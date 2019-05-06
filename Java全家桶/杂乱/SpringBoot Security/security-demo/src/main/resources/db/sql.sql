/*
Navicat MySQL Data Transfer
Source Server         : 本地
Source Host           : localhost:3306
Source Database       : test
Target Server Type    : MYSQL
Date: 2017-8-14 22:17:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` INT (32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` INT (32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` INT (32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `desc` VARCHAR (32) DEFAULT NULL COMMENT '描述',
  `url` VARCHAR (32) DEFAULT NULL COMMENT 'url',
  `pid` INT (32),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `sys_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sys_user_id` INT(32) NOT NULL COMMENT 'user_id',
  `sys_role_id` INT(32) NOT NULL COMMENT 'role_id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

ALTER TABLE sys_role_user ADD CONSTRAINT sys_FK1 FOREIGN KEY(sys_user_id) REFERENCES sys_user(id);
ALTER TABLE sys_role_user ADD CONSTRAINT role_FK2 FOREIGN KEY(sys_role_id) REFERENCES sys_role(id);

-- ----------------------------
-- Table structure for `sys_permission_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_role`;
CREATE TABLE `sys_permission_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sys_role_id` INT(32) NOT NULL COMMENT 'role_id',
  `sys_permission_id` INT(32) NOT NULL COMMENT 'permission_id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
ALTER TABLE sys_permission_role ADD CONSTRAINT sys_FK3 FOREIGN KEY(sys_role_id) REFERENCES sys_role(id);
ALTER TABLE sys_permission_role ADD CONSTRAINT role_FK4 FOREIGN KEY(sys_permission_id) REFERENCES sys_permission(id);