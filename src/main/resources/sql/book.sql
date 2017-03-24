/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-10-12 22:28:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for position_city_tb
-- ----------------------------
DROP TABLE IF EXISTS `position_city_tb`;
CREATE TABLE `position_city_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '城市主键',
  `city_name` varchar(20) NOT NULL COMMENT '城市名称',
  `province_id` int(11) NOT NULL COMMENT '关联position_province_tb(省份表)的主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市表';

-- ----------------------------
-- Records of position_city_tb
-- ----------------------------

-- ----------------------------
-- Table structure for position_country_tb
-- ----------------------------
DROP TABLE IF EXISTS `position_country_tb`;
CREATE TABLE `position_country_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '国家表主键',
  `country_name` varchar(20) NOT NULL COMMENT '国家名称',
  `language_code` varchar(10) NOT NULL COMMENT '语言，如：zh',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='国家表';

-- ----------------------------
-- Records of position_country_tb
-- ----------------------------
INSERT INTO `position_country_tb` VALUES ('1', '中华人民共和国', 'zh');

-- ----------------------------
-- Table structure for position_province_tb
-- ----------------------------
DROP TABLE IF EXISTS `position_province_tb`;
CREATE TABLE `position_province_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '省份主键',
  `province_name` varchar(20) NOT NULL COMMENT '省份名称',
  `country_id` int(11) NOT NULL COMMENT '关联position_country_tb(国家表)的主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='省份表';

-- ----------------------------
-- Records of position_province_tb
-- ----------------------------
INSERT INTO `position_province_tb` VALUES ('1', '北京市', '1');
INSERT INTO `position_province_tb` VALUES ('2', '天津市', '1');
INSERT INTO `position_province_tb` VALUES ('3', '上海市', '1');
INSERT INTO `position_province_tb` VALUES ('4', '重庆市', '1');
INSERT INTO `position_province_tb` VALUES ('5', '河北省', '1');
INSERT INTO `position_province_tb` VALUES ('6', '山西省', '1');
INSERT INTO `position_province_tb` VALUES ('7', '台湾省', '1');
INSERT INTO `position_province_tb` VALUES ('8', '辽宁省', '1');
INSERT INTO `position_province_tb` VALUES ('9', '吉林省', '1');
INSERT INTO `position_province_tb` VALUES ('10', '黑龙江省', '1');
INSERT INTO `position_province_tb` VALUES ('11', '江苏省', '1');
INSERT INTO `position_province_tb` VALUES ('12', '浙江省', '1');
INSERT INTO `position_province_tb` VALUES ('13', '安徽省', '1');
INSERT INTO `position_province_tb` VALUES ('14', '福建省', '1');
INSERT INTO `position_province_tb` VALUES ('15', '江西省', '1');
INSERT INTO `position_province_tb` VALUES ('16', '山东省', '1');
INSERT INTO `position_province_tb` VALUES ('17', '河南省', '1');
INSERT INTO `position_province_tb` VALUES ('18', '湖北省', '1');
INSERT INTO `position_province_tb` VALUES ('19', '湖南省', '1');
INSERT INTO `position_province_tb` VALUES ('20', '广东省', '1');
INSERT INTO `position_province_tb` VALUES ('21', '甘肃省', '1');
INSERT INTO `position_province_tb` VALUES ('22', '四川省', '1');
INSERT INTO `position_province_tb` VALUES ('23', '贵州省', '1');
INSERT INTO `position_province_tb` VALUES ('24', '海南省', '1');
INSERT INTO `position_province_tb` VALUES ('25', '云南省', '1');
INSERT INTO `position_province_tb` VALUES ('26', '青海省', '1');
INSERT INTO `position_province_tb` VALUES ('27', '陕西省', '1');
INSERT INTO `position_province_tb` VALUES ('28', '广西壮族自治区', '1');
INSERT INTO `position_province_tb` VALUES ('29', '西藏自治区', '1');
INSERT INTO `position_province_tb` VALUES ('30', '宁夏回族自治区', '1');
INSERT INTO `position_province_tb` VALUES ('31', '新疆维吾尔自治区', '1');
INSERT INTO `position_province_tb` VALUES ('32', '内蒙古自治区', '1');
INSERT INTO `position_province_tb` VALUES ('33', '澳门特别行政区', '1');
INSERT INTO `position_province_tb` VALUES ('34', '香港特别行政区', '1');

-- ----------------------------
-- Table structure for user_basic_tb
-- ----------------------------
DROP TABLE IF EXISTS `user_basic_tb`;
CREATE TABLE `user_basic_tb` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `user_nick` varchar(20) DEFAULT NULL COMMENT '用户真实姓名',
  `login_phone` varchar(11) DEFAULT NULL COMMENT '手机用户登录账号',
  `login_mail` varchar(50) DEFAULT NULL COMMENT '邮箱用户登录账号',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `user_logo` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `address` varchar(200) DEFAULT NULL COMMENT '用户详细地址',
  `city_id` int(5) DEFAULT NULL COMMENT '用户所属城市，关联城市表主键',
  `province_id` int(3) DEFAULT NULL COMMENT '用户所属省份，关联省份表主键',
  `country_id` int(3) DEFAULT NULL COMMENT '用户所属国家，关联国家表主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user_basic_tb
-- ----------------------------
INSERT INTO `user_basic_tb` VALUES ('1', '17746598041', '张岩', '17746598041', '419475937@qq.com', '123456', '/usr/local/test.png', null, null, '6', '1');
INSERT INTO `user_basic_tb` VALUES ('2', '18935445005', '翠兰', '18935445005', 'test@qq.com', '123456', null, null, null, '1', '1');
