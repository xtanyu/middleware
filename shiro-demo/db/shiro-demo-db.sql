/*
 Navicat MySQL Data Transfer

 Source Server         : testhousekeeper
 Source Server Type    : MySQL
 Source Server Version : 50715
 Source Host           : localhost:3306
 Source Schema         : shiro-demo-db

 Target Server Type    : MySQL
 Target Server Version : 50715
 File Encoding         : 65001

 Date: 04/06/2021 13:43:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE "user" (
  "name" varchar(255) DEFAULT NULL,
  "password" varchar(255) DEFAULT NULL,
  "permissions" varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('小白', '123456', 'test2');
INSERT INTO `user` VALUES ('小黑', '123456', 'test1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
