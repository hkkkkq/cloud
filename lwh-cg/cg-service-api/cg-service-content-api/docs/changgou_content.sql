/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.8
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 192.168.1.8:3306
 Source Schema         : changgou_content

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 13/07/2020 06:00:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_content
-- ----------------------------
DROP TABLE IF EXISTS `tb_content`;
CREATE TABLE `tb_content` (
  `id` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL COMMENT '内容类目ID',
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '内容标题',
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '链接',
  `pic` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片绝对路径',
  `status` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '状态,0无效，1有效',
  `sort_order` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_content
-- ----------------------------
BEGIN;
INSERT INTO `tb_content` VALUES (1, 1, NULL, 'http://192.168.1.8:8080/group1/M00/00/00/wKgBCF8Ga82AQ5oLAAh4pF5PghM212.png', 'http://192.168.1.8:8080/group1/M00/00/00/wKgBCF8Ga82AQ5oLAAh4pF5PghM212.png', '1', 1);
INSERT INTO `tb_content` VALUES (2, 1, NULL, 'http://192.168.1.8:8080/group1/M00/00/00/wKgBCF8Ga82AQ5oLAAh4pF5PghM212.png', 'http://192.168.1.8:8080/group1/M00/00/00/wKgBCF8Ga82AQ5oLAAh4pF5PghM212.png', '1', 2);
INSERT INTO `tb_content` VALUES (4, 3, NULL, 'http://192.168.1.8:8080/group1/M00/00/00/wKgBCF8Ga82AQ5oLAAh4pF5PghM212.png', 'http://192.168.1.8:8080/group1/M00/00/00/wKgBCF8Ga82AQ5oLAAh4pF5PghM212.png', '1', 4);
INSERT INTO `tb_content` VALUES (5, 2, NULL, 'http://192.168.1.8:8080/group1/M00/00/00/wKgBCF8Ga82AQ5oLAAh4pF5PghM212.png', 'http://192.168.1.8:8080/group1/M00/00/00/wKgBCF8Ga82AQ5oLAAh4pF5PghM212.png', '1', 3);
INSERT INTO `tb_content` VALUES (6, 3, NULL, 'http://192.168.1.8:8080/group1/M00/00/00/wKgBCF8Ga82AQ5oLAAh4pF5PghM212.png', 'http://192.168.1.8:8080/group1/M00/00/00/wKgBCF8Ga82AQ5oLAAh4pF5PghM212.png', '1', 5);
COMMIT;

-- ----------------------------
-- Table structure for tb_content_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_content_category`;
CREATE TABLE `tb_content_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
