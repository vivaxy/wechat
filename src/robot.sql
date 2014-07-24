/*
Navicat MySQL Data Transfer

Source Server         : root@10.15.107.148
Source Server Version : 50077
Source Host           : 10.15.107.148:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50077
File Encoding         : 65001

Date: 2014-07-24 08:11:41
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id`       INT(11)   NOT NULL AUTO_INCREMENT,
  `created`  DATETIME DEFAULT NULL,
  `updated`  DATETIME DEFAULT NULL,
  `lastused` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `used`     INT(255) DEFAULT NULL,
  `teached`  INT(255) DEFAULT NULL,
  `ask`      VARCHAR(255) DEFAULT NULL,
  `answer`   VARCHAR(255) DEFAULT NULL,
  `isValid`  INT(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE =MyISAM
  AUTO_INCREMENT =6
  DEFAULT CHARSET =utf8;
