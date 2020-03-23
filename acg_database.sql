/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : acg_database

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-03-23 15:16:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `cid` int(100) NOT NULL,
  `vid` int(100) DEFAULT NULL,
  `videoname` varchar(100) DEFAULT NULL,
  `videopath` varchar(100) DEFAULT NULL,
  `videocreater` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('14', '1', '测试视频G', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', 'qwer');
INSERT INTO `collect` VALUES ('14', '20', '测试视频T', 'http://127.0.0.1:8080/uploadfile/Video/测试视频.mp4', 'qwer');
INSERT INTO `collect` VALUES ('18', '1', '测试视频G', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', 'qwer');

-- ----------------------------
-- Table structure for `discuss`
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss` (
  `disid` int(100) NOT NULL,
  `uid` int(100) DEFAULT NULL,
  `vid` int(100) DEFAULT NULL,
  `discussmessage` varchar(100) DEFAULT NULL,
  `disdate` datetime DEFAULT NULL,
  `disupcount` int(100) DEFAULT NULL,
  `disdowncount` int(100) DEFAULT NULL,
  PRIMARY KEY (`disid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discuss
-- ----------------------------

-- ----------------------------
-- Table structure for `is_user_dis`
-- ----------------------------
DROP TABLE IF EXISTS `is_user_dis`;
CREATE TABLE `is_user_dis` (
  `uid` int(100) DEFAULT NULL,
  `disid` int(100) DEFAULT NULL,
  `isup` int(100) DEFAULT NULL,
  `isdown` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of is_user_dis
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `userfacepath` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'http://localhost:8080/uploadfile/Userface/LauncherLogo_PC.png',
  `useraccnum` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userpass` varchar(100) DEFAULT NULL,
  `upid` int(100) DEFAULT NULL,
  `cid` int(100) DEFAULT NULL,
  `isregister` int(3) DEFAULT '0',
  `fancount` int(100) DEFAULT '0',
  `usertype` varchar(20) DEFAULT '普通',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('14', 'qwer', 'http://localhost:8080/uploadfile/Userface/JoTaRo.jpeg', 'aaa', 'aaa', '14', '14', '0', '3', '普通');
INSERT INTO `user` VALUES ('15', 'bbb', 'http://localhost:8080/uploadfile/Userface/LauncherLogo_PC.png', 'bbb', 'bbb', '15', '15', '0', '0', '普通');
INSERT INTO `user` VALUES ('18', 'ccc', 'http://localhost:8080/uploadfile/Userface/LauncherLogo_PC.png', 'ccc', 'ccc', '18', '18', '1', '0', '普通');

-- ----------------------------
-- Table structure for `useraction`
-- ----------------------------
DROP TABLE IF EXISTS `useraction`;
CREATE TABLE `useraction` (
  `uid` tinyint(10) NOT NULL,
  `vid` tinyint(10) NOT NULL,
  `up` int(1) DEFAULT '0',
  `down` int(1) DEFAULT '0',
  `collect` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of useraction
-- ----------------------------
INSERT INTO `useraction` VALUES ('15', '2', '0', '0', '0');
INSERT INTO `useraction` VALUES ('15', '3', '0', '0', '0');
INSERT INTO `useraction` VALUES ('15', '10', '0', '0', '0');
INSERT INTO `useraction` VALUES ('15', '4', '0', '0', '0');
INSERT INTO `useraction` VALUES ('18', '4', '0', '0', '0');
INSERT INTO `useraction` VALUES ('18', '8', '0', '0', '0');
INSERT INTO `useraction` VALUES ('18', '10', '0', '0', '0');
INSERT INTO `useraction` VALUES ('18', '2', '0', '0', '0');
INSERT INTO `useraction` VALUES ('14', '6', '0', '0', '0');
INSERT INTO `useraction` VALUES ('18', '5', '0', '0', '0');
INSERT INTO `useraction` VALUES ('14', '2', '0', '0', '0');
INSERT INTO `useraction` VALUES ('14', '1', '1', '0', '1');
INSERT INTO `useraction` VALUES ('18', '1', '1', '0', '1');
INSERT INTO `useraction` VALUES ('14', '20', '1', '0', '1');
INSERT INTO `useraction` VALUES ('14', '3', '0', '0', '0');

-- ----------------------------
-- Table structure for `user_up`
-- ----------------------------
DROP TABLE IF EXISTS `user_up`;
CREATE TABLE `user_up` (
  `uid` int(100) DEFAULT NULL,
  `upid` int(100) DEFAULT NULL,
  `isconcerned` int(1) DEFAULT NULL,
  `isbothconcerned` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_up
-- ----------------------------
INSERT INTO `user_up` VALUES ('18', '14', '1', '0');
INSERT INTO `user_up` VALUES ('15', '14', '1', '0');
INSERT INTO `user_up` VALUES ('14', '14', '1', '0');

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `vid` int(100) NOT NULL AUTO_INCREMENT,
  `upid` int(100) DEFAULT NULL,
  `disid` int(100) DEFAULT NULL,
  `videoname` varchar(100) DEFAULT '',
  `videotype` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `videoabstract` varchar(100) DEFAULT NULL,
  `videoface` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `videopath` varchar(100) DEFAULT NULL,
  `playcount` int(100) DEFAULT '0',
  `putcount` int(100) DEFAULT '0',
  `downcount` int(100) DEFAULT '0',
  `collectcount` int(100) DEFAULT '0',
  `createdate` datetime DEFAULT '2019-12-29 22:07:33',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '14', '1', '测试视频G', '游戏', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '87', '2', '0', '2', '2019-12-29 22:08:05');
INSERT INTO `video` VALUES ('2', '14', '2', '测试视频G', '游戏', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '38', '0', '0', '0', '2019-12-29 22:08:13');
INSERT INTO `video` VALUES ('3', '14', '3', '测试视频G', '教学', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '11', '0', '0', '0', '2019-12-29 22:08:18');
INSERT INTO `video` VALUES ('4', '14', '4', '测试视频G', '游戏', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '5', '0', '0', '0', '2019-12-29 22:08:22');
INSERT INTO `video` VALUES ('5', '14', '5', '测试视频G', '游戏', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '4', '0', '0', '0', '2019-12-29 22:08:25');
INSERT INTO `video` VALUES ('6', '14', '6', '测试视频G', '游戏', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '2', '0', '0', '0', '2019-12-29 22:08:28');
INSERT INTO `video` VALUES ('7', '14', '7', '测试视频G', '游戏', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '0', '0', '0', '0', '2019-12-29 22:08:32');
INSERT INTO `video` VALUES ('8', '14', '8', '测试视频A', '动漫', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '1', '0', '0', '0', '2019-12-29 22:08:36');
INSERT INTO `video` VALUES ('9', '14', '9', '测试视频A', '动漫', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '0', '0', '0', '0', '2019-12-29 22:08:38');
INSERT INTO `video` VALUES ('10', '14', '10', '测试视频G', '游戏', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '6', '0', '0', '0', '2019-12-29 22:08:41');
INSERT INTO `video` VALUES ('11', '14', '11', '测试视频G', '游戏', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '0', '0', '0', '0', '2019-12-29 22:08:44');
INSERT INTO `video` VALUES ('12', '14', '12', '测试视频G', '游戏', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '0', '0', '0', '0', '2019-12-29 22:08:47');
INSERT INTO `video` VALUES ('13', '14', '13', '测试视频G', '游戏', '简介.........', 'http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg', 'http://localhost:8080/uploadfile/Video/测试视频.mp4', '0', '0', '0', '0', '2019-12-29 22:08:49');
INSERT INTO `video` VALUES ('20', '14', '20', '测试视频T', '教学', '简介测试.......', 'http://127.0.0.1:8080/uploadfile/Videoface/Excalibur.jpg', 'http://127.0.0.1:8080/uploadfile/Video/测试视频.mp4', '10', '1', '0', '1', '2020-01-05 11:11:15');

-- ----------------------------
-- Table structure for `videotype`
-- ----------------------------
DROP TABLE IF EXISTS `videotype`;
CREATE TABLE `videotype` (
  `vType` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of videotype
-- ----------------------------
INSERT INTO `videotype` VALUES ('游戏');
INSERT INTO `videotype` VALUES ('教学');
INSERT INTO `videotype` VALUES ('纪实');
INSERT INTO `videotype` VALUES ('动漫');
