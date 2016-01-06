/*
Navicat MySQL Data Transfer

Source Server Version : 50624
Source Database       : whotel

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-24 19:32:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_hotel`
-- ----------------------------
DROP TABLE IF EXISTS `t_hotel`;
CREATE TABLE `t_hotel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `otsHotelId` bigint(20) NOT NULL COMMENT 'OTS中的酒店ID',
  `bossId` bigint(20) NOT NULL COMMENT '酒店所属用户ID',
  `logoImageId` bigint(20) DEFAULT NULL COMMENT 'logo图片ID',
  `templateId` bigint(20) DEFAULT NULL COMMENT '模板ID',
  `valid` char(1) NOT NULL DEFAULT 'T' COMMENT '是否软删除',
  `status` int(11) NOT NULL COMMENT '状态：1审核中、2开业、3关闭',
  `name` varchar(255) NOT NULL COMMENT '酒店名称',
  `notice` mediumtext COMMENT '酒店公告',
  `weChatNumber` varchar(255) DEFAULT NULL COMMENT '微信号',
  `mobileNumber` varchar(20) NOT NULL COMMENT '手机号码',
  `telephoneNumber` varchar(20) NOT NULL COMMENT '电话号码',
  `longitude` decimal(12,8) NOT NULL COMMENT '经度',
  `latitude` decimal(12,8) NOT NULL COMMENT '纬度',
  `provcode` int(11) DEFAULT NULL COMMENT '省份编码',
  `citycode` int(11) DEFAULT NULL COMMENT '城市编码',
  `discode` int(11) DEFAULT NULL COMMENT '区编码',
  `areacode` int(11) DEFAULT NULL COMMENT '街道编码',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hotel
-- ----------------------------

-- ----------------------------
-- Table structure for `t_hotel_pictrue_map`
-- ----------------------------
DROP TABLE IF EXISTS `t_hotel_pictrue_map`;
CREATE TABLE `t_hotel_pictrue_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `hotelId` bigint(20) NOT NULL COMMENT '酒店ID',
  `imageId` bigint(20) NOT NULL COMMENT '图片ID',
  `sort` int(11) NOT NULL COMMENT '排序编号',
  `type` int(11) NOT NULL COMMENT '1.封面;2.酒店详情',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hotel_pictrue_map
-- ----------------------------

-- ----------------------------
-- Table structure for `t_price`
-- ----------------------------
DROP TABLE IF EXISTS `t_price`;
CREATE TABLE `t_price` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `roomTypeId` bigint(20) NOT NULL COMMENT '房型ID',
  `valid` char(1) NOT NULL DEFAULT 'T' COMMENT '是否软删除',
  `cost` decimal(10,2) NOT NULL COMMENT '门市价格',
  `price` decimal(10,2) NOT NULL COMMENT '微店价格',
  `startTime` datetime NOT NULL COMMENT '开始时间',
  `endTime` datetime NOT NULL COMMENT '结束时间',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_price
-- ----------------------------

-- ----------------------------
-- Table structure for `t_room`
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `roomTypeId` bigint(20) NOT NULL COMMENT '房型ID',
  `isLock` char(1) NOT NULL DEFAULT 'F' COMMENT '是否锁房',
  `valid` char(1) NOT NULL DEFAULT 'T' COMMENT '是否软删除',
  `name` bigint(20) NOT NULL COMMENT '房间名称',
  `floor` varchar(128) DEFAULT NULL COMMENT '楼层',
  `telephoneNumber` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `extraInfo` varchar(1024) DEFAULT NULL COMMENT '拓展信息',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_room
-- ----------------------------

-- ----------------------------
-- Table structure for `t_room_property`
-- ----------------------------
DROP TABLE IF EXISTS `t_room_property`;
CREATE TABLE `t_room_property` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `hotelId` bigint(20) NOT NULL COMMENT '酒店ID',
  `roomTypeId` bigint(20) NOT NULL COMMENT '房型ID',
  `roomId` bigint(20) NOT NULL COMMENT '房间ID',
  `valid` char(1) NOT NULL DEFAULT 'T' COMMENT '是否软删除',
  `bedTypeName` varchar(50) NOT NULL COMMENT '床型',
  `floor` varchar(20) DEFAULT NULL COMMENT '楼层',
  `orientation` varchar(50) DEFAULT NULL COMMENT '朝向',
  `isWindow` char(1) DEFAULT NULL COMMENT '是否有窗户',
  `isStair` char(1) DEFAULT NULL COMMENT '是否靠近楼梯',
  `isElevator` char(1) DEFAULT NULL COMMENT '是否靠近电梯',
  `isStreet` char(1) DEFAULT NULL COMMENT '是否靠近公路',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_room_property
-- ----------------------------

-- ----------------------------
-- Table structure for `t_room_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_room_type`;
CREATE TABLE `t_room_type` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `hotelId` bigint(20) NOT NULL COMMENT '酒店ID',
  `valid` char(1) NOT NULL DEFAULT 'T' COMMENT '是否软删除',
  `name` varchar(128) NOT NULL COMMENT '名称',
  `cost` decimal(10,2) NOT NULL COMMENT '门市价格',
  `price` decimal(10,2) NOT NULL COMMENT '微店价格',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_room_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_template`
-- ----------------------------
DROP TABLE IF EXISTS `t_template`;
CREATE TABLE `t_template` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `valid` char(1) NOT NULL DEFAULT 'T' COMMENT '是否软删除',
  `name` varchar(255) NOT NULzL COMMENT '模板名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '模板描述',
  `previewURL` varchar(1024) NOT NULL COMMENT '预览地址',
  `thumbnailURL` varchar(1024) NOT NULL,
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_template
-- ----------------------------
