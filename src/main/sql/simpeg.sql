/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : simpeg

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-08-31 22:09:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for table_aparatur
-- ----------------------------
DROP TABLE IF EXISTS `table_aparatur`;
CREATE TABLE `table_aparatur` (
  `nip` char(18) NOT NULL,
  `nama` varchar(150) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `tpt_lahir` varchar(150) NOT NULL,
  `jk` char(1) NOT NULL,
  `gol_darah` char(3) NOT NULL,
  PRIMARY KEY (`nip`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for table_golongan
-- ----------------------------
DROP TABLE IF EXISTS `table_golongan`;
CREATE TABLE `table_golongan` (
  `golongan` char(5) NOT NULL,
  `pangkat` char(15) DEFAULT NULL,
  PRIMARY KEY (`golongan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for table_pasfoto
-- ----------------------------
DROP TABLE IF EXISTS `table_pasfoto`;
CREATE TABLE `table_pasfoto` (
  `id_pasfoto` int(255) NOT NULL,
  `nip` char(18) NOT NULL,
  `filename` varchar(150) NOT NULL,
  `tgl_upload` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_pasfoto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for table_riwayat_pangkat
-- ----------------------------
DROP TABLE IF EXISTS `table_riwayat_pangkat`;
CREATE TABLE `table_riwayat_pangkat` (
  `id_riwayat_pangkat` int(255) NOT NULL,
  `nip` char(18) NOT NULL,
  `golongan` char(5) NOT NULL,
  `no_sk` varchar(50) NOT NULL,
  `tgl_sk` date NOT NULL,
  `nama_pejabat_ttd` varchar(150) NOT NULL,
  `nip_pejabat_ttd` char(18) NOT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_riwayat_pangkat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for table_user
-- ----------------------------
DROP TABLE IF EXISTS `table_user`;
CREATE TABLE `table_user` (
  `username` char(18) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nama` varchar(150) DEFAULT NULL,
  `role` tinyint(4) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
