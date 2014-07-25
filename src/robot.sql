/*
Navicat MySQL Data Transfer

Source Server         : root@10.15.107.148
Source Server Version : 50077
Source Host           : 10.15.107.148:3306
Source Database       : robot

Target Server Type    : MYSQL
Target Server Version : 50077
File Encoding         : 65001

Date: 2014-07-24 08:11:41
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `robot`;
CREATE TABLE `robot` (
  `id`       INT(11)   NOT NULL AUTO_INCREMENT,
  `updated`  TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `created`  DATETIME DEFAULT NULL,
  `lastUsed` DATETIME DEFAULT NULL,
  `used`     INT(255) DEFAULT NULL,
  `taught`   INT(255) DEFAULT NULL,
  `ask`      TEXT DEFAULT NULL,
  `answer`   TEXT DEFAULT NULL,
  `isValid`  INT(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE =MyISAM
  AUTO_INCREMENT =1
  DEFAULT CHARSET =utf8;
