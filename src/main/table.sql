/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - wmsdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wmsdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wmsdb`;

/*Table structure for table `bs_bread` */

DROP TABLE IF EXISTS `bs_bread`;

CREATE TABLE `bs_bread` (
  `breadCode` char(3) NOT NULL,
  `breadName` varchar(30) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  PRIMARY KEY (`breadCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_bread` */

insert  into `bs_bread`(`breadCode`,`breadName`,`state`) values ('001','影魔','1'),('002','莉娜','1'),('003','蓝猫','1'),('005','安阳','1'),('006','吹风','0');

/*Table structure for table `bs_builder` */

DROP TABLE IF EXISTS `bs_builder`;

CREATE TABLE `bs_builder` (
  `builderCode` char(6) NOT NULL,
  `builderName` varchar(60) DEFAULT NULL,
  `linkMan` varchar(10) DEFAULT NULL,
  `linkmanDuty` varchar(30) DEFAULT NULL,
  `sgAddr` varchar(120) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `http` varchar(40) DEFAULT NULL,
  `accounts` varchar(40) DEFAULT NULL,
  `bank` varchar(40) DEFAULT NULL,
  `countrytax` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`builderCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_builder` */

/*Table structure for table `bs_factory` */

DROP TABLE IF EXISTS `bs_factory`;

CREATE TABLE `bs_factory` (
  `factoryCode` char(3) NOT NULL,
  `factoryName` varchar(60) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `billman` varchar(50) DEFAULT NULL,
  `billDate` datetime DEFAULT NULL,
  PRIMARY KEY (`factoryCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_factory` */

/*Table structure for table `bs_itemtype` */

DROP TABLE IF EXISTS `bs_itemtype`;

CREATE TABLE `bs_itemtype` (
  `itemtypeCode` varchar(6) NOT NULL,
  `upcode` varchar(6) DEFAULT NULL,
  `oldcode` varchar(30) DEFAULT NULL,
  `itemName` varchar(20) DEFAULT NULL,
  `accCode` varchar(20) DEFAULT NULL,
  `accName` varchar(50) DEFAULT NULL,
  `step` int(11) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `price` decimal(18,8) DEFAULT NULL,
  PRIMARY KEY (`itemtypeCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_itemtype` */

insert  into `bs_itemtype`(`itemtypeCode`,`upcode`,`oldcode`,`itemName`,`accCode`,`accName`,`step`,`state`,`price`) values ('001','00','gc','钢材','','',NULL,'0','1500.00000000'),('002','00','gjx','钢绞线','','',NULL,'0','1500.00000000'),('003','00','sn','水泥','','',NULL,'0','1500.00000000'),('004','00','lq','沥青','','',NULL,'0','1500.00000000'),('005','00','qt','其他（检测设备）','','',NULL,'0','1500.00000000'),('006','00','yy','用友系统旧货品','','',NULL,'0','1500.00000000'),('007','001','yjg','I级纲','','',NULL,'0','1800.00000000'),('008','001','ejg','II级纲','','',NULL,'0','1600.00000000'),('009','001','sjg','III级纲','','',NULL,'0','1500.00000000'),('010','001','gp','纲坯','','',NULL,'0','1900.00000000'),('011','001','jzg','精扎纲','','',NULL,'0','2100.00000000'),('012','001','gb','纲板','','',NULL,'0','1500.00000000'),('013','001','rjb','热卷板','','',NULL,'0','2100.00000000'),('014','002','bzx','标准型钢绞线','','',NULL,'0','1800.00000000'),('015','002','ky','刻疫钢绞线','','',NULL,'0','1600.00000000'),('016','002','mb','模拔钢绞线','','',NULL,'0','1500.00000000'),('017','003','gsy','硅酸盐水泥','','',NULL,'0','1900.00000000'),('018','003','pt','普通水泥','','',NULL,'0','2100.00000000'),('019','003','kz','矿渣硅酸盐水泥','','',NULL,'0','1500.00000000'),('020','003','hshz','火山灰质硅酸盐水泥','','',NULL,'0','2100.00000000'),('021','003','fmh','粉煤灰硅酸盐水泥','','',NULL,'0','1900.00000000'),('022','003','fh','复合硅酸盐水泥','','',NULL,'0','2100.00000000'),('023','003','ngw','耐高温水泥','','',NULL,'0','1500.00000000'),('024','003','klsy','抗硫酸盐性水泥','','',NULL,'0','2100.00000000'),('025','003','shr','水化热水泥','','',NULL,'0','1900.00000000'),('026','003','kyx','快硬性水泥','','',NULL,'0','2100.00000000'),('027','004','mj','煤焦沥青','','',NULL,'0','1500.00000000'),('028','004','sy','石油沥青','','',NULL,'0','2100.00000000'),('029','004','tr','天然沥青','','',NULL,'0','2100.00000000'),('030','003','asdasd','asda','dsad','',NULL,'0','0.00000000'),('031','002','adff','sss','adsas','',NULL,'0','0.00000000'),('032','001','jgj','金刚金','sdd','',NULL,'0','0.00000000');

/*Table structure for table `bs_newitem` */

DROP TABLE IF EXISTS `bs_newitem`;

CREATE TABLE `bs_newitem` (
  `itemcode` char(6) NOT NULL,
  `itemtypeCode` varchar(6) DEFAULT NULL,
  `itemName` varchar(120) DEFAULT NULL,
  `oldcode` varchar(30) DEFAULT NULL,
  `breadCode` char(3) DEFAULT NULL,
  `gradeCode` char(3) DEFAULT NULL,
  `unitCode` char(4) DEFAULT NULL,
  `unitNum` int(11) DEFAULT NULL,
  `itemLen` decimal(10,2) DEFAULT NULL,
  `width` decimal(10,2) DEFAULT NULL,
  `height` decimal(10,2) DEFAULT NULL,
  `weight` decimal(10,2) DEFAULT NULL,
  `volumn` decimal(10,2) DEFAULT NULL,
  `itemValue` decimal(10,2) DEFAULT NULL,
  `state` char(1) DEFAULT NULL COMMENT '0:未启用 1:已启用',
  `saleprice` decimal(18,4) DEFAULT NULL,
  `taxRate` decimal(18,8) DEFAULT NULL,
  `spectype` varchar(50) DEFAULT NULL,
  `typeCode` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`itemcode`),
  KEY `FK_Reference_5` (`itemtypeCode`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`itemtypeCode`) REFERENCES `bs_itemtype` (`itemtypeCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_newitem` */

insert  into `bs_newitem`(`itemcode`,`itemtypeCode`,`itemName`,`oldcode`,`breadCode`,`gradeCode`,`unitCode`,`unitNum`,`itemLen`,`width`,`height`,`weight`,`volumn`,`itemValue`,`state`,`saleprice`,`taxRate`,`spectype`,`typeCode`) values ('001','007','带钢192*2.5','dg','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','192*2.5',''),('002','007','带钢2.50*232','dg','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.50*232',''),('003','007','带钢2.50*241','dg','002',NULL,'吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'1','3200.0000','0.17000000','2.50*241',''),('004','007','带钢2.50*243','dg','001',NULL,'吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.50*243',''),('005','008','带钢2.50*245','dg','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.50*245',''),('006','008','带钢2.50*252','dg','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.50*252',''),('007','009','带钢2.50*255','dg','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.50*255',''),('008','009','带钢2.50*258','dg','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.50*258',''),('009','011','圆钢12','yg','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#12',''),('010','011','圆钢16','yg','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#16',''),('011','011','圆钢14','yg','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#14',''),('012','011','圆钢18','yg','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#18',''),('013','011','圆钢20','yg','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#20',''),('014','011','圆钢22','yg','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#22',''),('015','011','圆钢24','yg','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#24',''),('016','011','圆钢26','yg','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#26',''),('017','011','圆钢40','yg','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#40',''),('018','011','圆钢32','yg','005',NULL,'吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'1','3200.0000','0.17000000','#32',''),('019','011','圆钢30','yg','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#30',''),('020','014','钢绞线12.7','gjx','001','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#12.7',''),('021','015','钢绞线15.24','gjx','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#15.24',''),('022','016','钢绞线12.5','gjx','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#12.5',''),('023','014','钢绞线15.5','gjx','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#15.5',''),('024','016','钢绞线17.7','gjx','001','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#17.7',''),('025','015','钢绞线13.24','gjx','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#13.24',''),('026','014','钢绞线12.28','gjx','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#12.28',''),('027','015','钢绞线15.8','gjx','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#15.8',''),('028','016','钢绞线13.56','gjx','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#13.56',''),('029','014','钢绞线15.57','gjx','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#15.57',''),('030','016','钢绞线17.23','gjx','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#17.23',''),('031','015','钢绞线13.77','gjx','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#13.77',''),('032','014','线材6.5','xc','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','#6.5',''),('033','021','P.042.5立窖水泥（散装）','sn','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('034','021','P.042.5转窖水泥（散装）','sn','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('035','021','P.042.5立窖水泥（散装）','sn','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('036','021','P.042.5转窖水泥（散装）','sn','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('037','021','P.042.5立窖水泥（散装）','sn','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('038','022','P.042.5转窖水泥（散装）','sn','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('039','022','P.042.5立窖水泥（散装）','sn','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('040','022','P.042.5转窖水泥（散装）','sn','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('041','022','P.042.5立窖水泥（散装）','sn','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('042','023','P.042.5转窖水泥（散装）','sn','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('043','023','P.042.5立窖水泥（散装）','sn','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('044','023','P.042.5转窖水泥（散装）','sn','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('045','023','P.042.5立窖水泥（散装）','sn','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('046','024','P.042.5转窖水泥（散装）','sn','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('047','025','P.042.5立窖水泥（散装）','sn','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('048','026','P.042.5转窖水泥（散装）','sn','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('049','023','P.042.5立窖水泥（散装）','sn','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('050','023','P.042.5转窖水泥（散装）','sn','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('051','026','P.042.5立窖水泥（散装）','sn','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('052','026','P.042.5转窖水泥（散装）','sn','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('053','025','P.042.5立窖水泥（散装）','sn','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('054','025','P.042.5转窖水泥（散装）','sn','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('055','024','P.042.5立窖水泥（散装）','sn','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('056','024','P.042.5转窖水泥（散装）','sn','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','P.042.5',''),('057','027','沥青55*2.3','lq','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','55*2.3',''),('058','027','沥青2.3*130','lq','002','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.3*130',''),('059','028','沥青2.3*15','lq','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.3*15',''),('060','028','沥青2.3*66','lq','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.3*66',''),('061','029','沥青2.3*78','lq','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.3*78',''),('062','027','沥青2.3*48','lq','004','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.3*48',''),('063','028','沥青2.3*61','lq','005','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.3*61',''),('064','029','沥青2.3*71','lq','003','一级','吨',10,NULL,NULL,NULL,NULL,NULL,NULL,'0','3200.0000','0.17000000','2.3*71','');

/*Table structure for table `bs_serve_h` */

DROP TABLE IF EXISTS `bs_serve_h`;

CREATE TABLE `bs_serve_h` (
  `serveCode` char(6) NOT NULL,
  `serveName` varchar(60) DEFAULT NULL,
  `header` varchar(20) DEFAULT NULL,
  `addr` varchar(120) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `connecter` varchar(20) DEFAULT NULL,
  `mobiltel` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `netaddr` varchar(40) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `custtype` varchar(20) DEFAULT NULL,
  `principal` varchar(20) DEFAULT NULL,
  `accounts` varchar(40) DEFAULT NULL,
  `bank` varchar(40) DEFAULT NULL,
  `countrytax` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`serveCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_serve_h` */

insert  into `bs_serve_h`(`serveCode`,`serveName`,`header`,`addr`,`tel`,`connecter`,`mobiltel`,`fax`,`netaddr`,`email`,`custtype`,`principal`,`accounts`,`bank`,`countrytax`) values ('S00001','阿里巴巴','马云','杭州','18888888888','马云','18888888888','','','999999@qq.com','','马云','9999999999999','中国银行',''),('S00003','华为','任正飞','广州','18888888888','任正飞','13333333333','','','999999@qq.com','','任正飞','9999999999999','中国银行',''),('S00004','网易','丁磊','深圳','12345678912','丁磊','','','','','','','','',''),('S00006','腾讯','马化腾','北京','','马化腾','188888888777','','','','','','9999999999999','','');

/*Table structure for table `bs_tranunit` */

DROP TABLE IF EXISTS `bs_tranunit`;

CREATE TABLE `bs_tranunit` (
  `tranCode` char(6) NOT NULL,
  `tranName` varchar(60) DEFAULT NULL,
  `city` varchar(6) DEFAULT NULL,
  `connecter` varchar(10) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `tranpower` varchar(10) DEFAULT NULL,
  `addr` varchar(120) DEFAULT NULL,
  `memo` varchar(60) DEFAULT NULL,
  `corporation` varchar(50) DEFAULT NULL,
  `taxCode` varchar(40) DEFAULT NULL,
  `charter` varchar(20) DEFAULT NULL,
  `enrol` decimal(18,2) DEFAULT NULL,
  `linkMan` varchar(50) DEFAULT NULL,
  `linkTel` varchar(50) DEFAULT NULL,
  `httpAdr` varchar(40) DEFAULT NULL,
  `principalTel` varchar(50) DEFAULT NULL,
  `accounts` varchar(40) DEFAULT NULL,
  `bank` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`tranCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_tranunit` */

insert  into `bs_tranunit`(`tranCode`,`tranName`,`city`,`connecter`,`tel`,`fax`,`tranpower`,`addr`,`memo`,`corporation`,`taxCode`,`charter`,`enrol`,`linkMan`,`linkTel`,`httpAdr`,`principalTel`,`accounts`,`bank`) values ('T00001','顺丰','北京','王卫','1999999','0000','','北京','','','','','10000000.00',NULL,'18888888888','','18888888888','9999999999999','中国银行'),('T00002','邮政','北京','李国华','18888888888','','','北京','','','','','10000000.00',NULL,'18888888888','','18888888888','9999999999999','中国银行'),('T00003','圆通','广州','喻渭蛟','','','','北京','','','','','10000000.00',NULL,'','','18888888888','9999999999999','农业银行'),('T00004','韵达','上海','先知','','','','','','','','','10000000.00',NULL,'','','18888888888','',''),('T00005','大华','湖南','丁磊','','','','','','','','','1000.00',NULL,'','','11111111111','','');

/*Table structure for table `bs_vehicle` */

DROP TABLE IF EXISTS `bs_vehicle`;

CREATE TABLE `bs_vehicle` (
  `vehicleId` varchar(20) NOT NULL,
  `tranCode` char(6) DEFAULT NULL,
  `vehicleCode` varchar(6) DEFAULT NULL,
  `companyId` char(20) DEFAULT NULL,
  `runcode` varchar(30) DEFAULT NULL,
  `drivecode` varchar(30) DEFAULT NULL,
  `buycode` varchar(30) DEFAULT NULL,
  `city` char(20) DEFAULT NULL,
  `plant` varchar(60) DEFAULT NULL,
  `makesdate` datetime DEFAULT NULL,
  `vehicleLong` varchar(10) DEFAULT NULL,
  `realLong` decimal(10,0) DEFAULT NULL,
  `vehicleType` char(6) DEFAULT NULL,
  `realWide` decimal(10,0) DEFAULT NULL,
  `plantmodel` varchar(30) DEFAULT NULL,
  `framemodel` varchar(30) DEFAULT NULL,
  `motormodel` varchar(30) DEFAULT NULL,
  `underpan` decimal(10,0) DEFAULT NULL,
  `loading` decimal(10,0) DEFAULT NULL,
  `maxloading` decimal(10,0) DEFAULT NULL,
  `vehiclecolor` varchar(10) DEFAULT NULL,
  `runlong` decimal(10,0) DEFAULT NULL,
  `checkDate` datetime DEFAULT NULL,
  `driver` varchar(10) DEFAULT NULL,
  `driverId` varchar(20) DEFAULT NULL,
  `insureDate` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`vehicleId`),
  KEY `FK_Reference_1` (`tranCode`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`tranCode`) REFERENCES `bs_tranunit` (`tranCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_vehicle` */

insert  into `bs_vehicle`(`vehicleId`,`tranCode`,`vehicleCode`,`companyId`,`runcode`,`drivecode`,`buycode`,`city`,`plant`,`makesdate`,`vehicleLong`,`realLong`,`vehicleType`,`realWide`,`plantmodel`,`framemodel`,`motormodel`,`underpan`,`loading`,`maxloading`,`vehiclecolor`,`runlong`,`checkDate`,`driver`,`driverId`,`insureDate`,`remark`) values ('湘A0001','T00001','0001',NULL,'123456','111','','刀塔','',NULL,'',NULL,NULL,NULL,'','','',NULL,NULL,NULL,'',NULL,NULL,'白牛','430422199912122665',NULL,NULL);

/*Table structure for table `bs_ware_block` */

DROP TABLE IF EXISTS `bs_ware_block`;

CREATE TABLE `bs_ware_block` (
  `wareCode` char(2) DEFAULT NULL,
  `blockCode` char(4) NOT NULL COMMENT '仓库编码+库区编码',
  `blockname` varchar(30) DEFAULT NULL,
  `blocktype` char(4) DEFAULT NULL,
  `widthno` char(1) DEFAULT NULL,
  `lengthno` char(2) DEFAULT NULL,
  `blockwidth` decimal(18,2) DEFAULT NULL,
  `blocklength` decimal(18,2) DEFAULT NULL,
  `blockarea` decimal(18,4) DEFAULT NULL,
  `imagefile` varchar(120) DEFAULT NULL,
  `imagefile1` varchar(120) DEFAULT NULL,
  `remark` varchar(60) DEFAULT NULL,
  `totalrow` int(11) DEFAULT NULL,
  `totalcol` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `rowadd` int(11) DEFAULT NULL,
  `capacity` decimal(18,4) DEFAULT NULL,
  `storenum` decimal(18,4) DEFAULT NULL,
  PRIMARY KEY (`blockCode`),
  KEY `FK_Reference_3` (`wareCode`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`wareCode`) REFERENCES `bs_warehouse` (`wareCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_ware_block` */

/*Table structure for table `bs_warearea` */

DROP TABLE IF EXISTS `bs_warearea`;

CREATE TABLE `bs_warearea` (
  `warecode` char(2) NOT NULL,
  `areatype` char(1) NOT NULL,
  `areaCode` varchar(6) NOT NULL COMMENT '仓库编码+库区编码+库位编码',
  `blockcode` char(4) DEFAULT NULL,
  `areaname` varchar(20) NOT NULL,
  `areano` char(2) NOT NULL,
  `widthno` char(1) DEFAULT NULL,
  `lengthno` char(2) DEFAULT NULL,
  `layerno` char(1) DEFAULT NULL,
  `areawidth` decimal(18,2) DEFAULT NULL,
  `arealength` decimal(18,2) DEFAULT NULL,
  `areaarea` decimal(18,4) DEFAULT NULL,
  `barcode` varchar(20) DEFAULT NULL,
  `remark` varchar(60) DEFAULT NULL,
  `capacity` decimal(18,4) DEFAULT NULL,
  `storenum` decimal(18,4) DEFAULT NULL,
  PRIMARY KEY (`areaCode`),
  KEY `FK_Reference_4` (`blockcode`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`blockcode`) REFERENCES `bs_ware_block` (`blockCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_warearea` */

/*Table structure for table `bs_warehouse` */

DROP TABLE IF EXISTS `bs_warehouse`;

CREATE TABLE `bs_warehouse` (
  `wareCode` char(2) NOT NULL,
  `wareName` varchar(60) NOT NULL,
  `dutyMan` varchar(20) DEFAULT NULL,
  `city` char(6) DEFAULT NULL,
  `postCode` char(6) DEFAULT NULL,
  `addr` varchar(120) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `attnMan` varchar(20) DEFAULT NULL,
  `mobilTel` varchar(20) DEFAULT NULL,
  `caller` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `wareArea` decimal(10,0) DEFAULT NULL,
  `leftadd` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `totalrow` int(11) DEFAULT NULL,
  `totalcol` int(11) DEFAULT NULL,
  `rowadd` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `kind` char(1) DEFAULT NULL,
  `wareType` char(1) DEFAULT NULL,
  PRIMARY KEY (`wareCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_warehouse` */

insert  into `bs_warehouse`(`wareCode`,`wareName`,`dutyMan`,`city`,`postCode`,`addr`,`tel`,`attnMan`,`mobilTel`,`caller`,`fax`,`email`,`remark`,`wareArea`,`leftadd`,`width`,`totalrow`,`totalcol`,`rowadd`,`height`,`kind`,`wareType`) values ('01','江源仓','','000014','000000','','','','','唐凯','','','123','120',NULL,40,80,55,60,180,'暂','0'),('02','江村省建材仓','邓世堪','000007','','广州市白云区江高镇江村','86205719','','13602422788','唐凯','86205719','','123','120',NULL,40,80,55,60,180,'暂','0'),('03','大学城仓库','','','000000','','','','','唐凯','','','123','120',NULL,40,80,55,60,180,'暂','0'),('04','龙川仓','Wenbt','','000000','广东龙川县','07622826761','温波涛','13825335590','唐凯','07622826774','wbt614@163.com','123','120',NULL,40,80,55,60,180,'暂','0'),('05','新港码头仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('06','鱼珠仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('07','湛江仓','Liurm','000005','524300','广东遂溪县国营雷州林场贮木场','0759-7724660','柳荣茂','13356508937',NULL,'07597724660','likelnum@163.com',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('08','外运仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('09','吉山仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('10','穗东仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('11','广钢','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('12','五矿仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('13','合富仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('14','乐从仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('15','乐居仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('16','石牌仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('17','白云仓','黄炳坤','NULL','510710','黄埔中山大道蚧山路口','82299912','NULL','13802933223',NULL,'82272726','NULL',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('18','外运仓-供应商仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('19','江村省建材仓-供应商仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('20','广州铁路配件厂','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('21','粤赣中转仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('22','汕头库','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('23','茂名沥青储运中心','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('24','金朗仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('25','石牌粤兴仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('26','海军码头','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('28','东洛围码头','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('29','汽车直发','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('30','江高钢材中心','郑应泉','000007','510450','广州市白云区江高镇广州铁路配件厂','020-86205719','邓世堪','13544501718',NULL,'020-86209690','',NULL,'0',NULL,0,NULL,NULL,NULL,NULL,NULL,'0'),('31','海运仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('32','远东仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('33','仓储北站','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('34','合富仓（供）','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('35','广州海心沙沥青仓库','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('36','鱼珠仓(供)','0','000007','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('37','五矿码头','','000005','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('38','河源移动沥青库','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('39','江源仓(供)','22','000005','000000','22','2','','22',NULL,'22','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('40','三水沥青库','陈伟跃','000005','000000','','87820398','陈武昌','13809811903',NULL,'0757-87831544','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('41','三眼桥仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('42','南漖仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('43','裕丰仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('44','石牌仓(供)','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('45','黄埔老港仓库','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('46','铁五局材料厂仓库','','000005','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('47','科氏沥青库','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('48','揭阳仓库','温波涛','000005','000000','揭阳市港务局糖厂码头','0663-8101359','','13927011488',NULL,'0663-8101359','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('49','和贵仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('50','省建材外配仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('51','省建材外配仓库','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('52','白云仓(供)','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('53','黄埔仓','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('54','三水钢筋库','陈伟跃','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('55','东莞沥青库','','000009','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('56','唐阁仓','','000005','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('57','裕丰仓(供)','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'1'),('58','梅州仓库','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('59','黄埔市政沥青库','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0'),('60','茂名海燃沥青库','','','000000','','','','',NULL,'','',NULL,'120',NULL,40,NULL,NULL,NULL,NULL,NULL,'0');

/*Table structure for table `elecinfo` */

DROP TABLE IF EXISTS `elecinfo`;

CREATE TABLE `elecinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `eleType` int(11) DEFAULT NULL,
  `timeType` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `elecinfo` */

insert  into `elecinfo`(`id`,`uid`,`eleType`,`timeType`,`price`) values (4,3,2,2,'1.60');

/*Table structure for table `sys_bbs` */

DROP TABLE IF EXISTS `sys_bbs`;

CREATE TABLE `sys_bbs` (
  `bbsId` varchar(36) NOT NULL,
  `title` varchar(500) NOT NULL,
  `publicDate` varchar(19) DEFAULT NULL,
  `stopDate` varchar(19) DEFAULT NULL,
  `billMan` varchar(19) DEFAULT NULL,
  `billDate` varchar(19) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`bbsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_bbs` */

insert  into `sys_bbs`(`bbsId`,`title`,`publicDate`,`stopDate`,`billMan`,`billDate`,`content`) values ('16c621fb228f4ce6822189e45a7bfc13','123','2019-05-30 15:22:17','2019-05-08',NULL,'2019-05-30 15:22:17','啊实打实'),('a18ba889301543028d17d0baf8ff1c48','1','2019-05-30 15:24:18','2019-05-16',NULL,'2019-05-30 15:24:18','为发热');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `userName` varchar(50) NOT NULL,
  `userPass` varchar(50) DEFAULT NULL,
  `userId` varchar(36) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`userName`,`userPass`,`userId`) values ('fly','123456','1'),('test','123','2');

/*Table structure for table `table_test` */

DROP TABLE IF EXISTS `table_test`;

CREATE TABLE `table_test` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=gb2312;

/*Data for the table `table_test` */

/*Table structure for table `useelectype` */

DROP TABLE IF EXISTS `useelectype`;

CREATE TABLE `useelectype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `useelectype` */

insert  into `useelectype`(`id`,`name`) values (1,'一般工业用电'),(2,'大工业用电'),(3,'居民用电');

/*Table structure for table `wh_inbill_d` */

DROP TABLE IF EXISTS `wh_inbill_d`;

CREATE TABLE `wh_inbill_d` (
  `rowno` char(3) NOT NULL,
  `inbillCode` varchar(15) NOT NULL,
  `itemcode` varchar(6) NOT NULL,
  `itemname` varchar(120) NOT NULL,
  `breadcode` char(3) DEFAULT NULL,
  `breadname` varchar(30) DEFAULT NULL,
  `standard` char(3) DEFAULT NULL,
  `steelNo` char(3) DEFAULT NULL,
  `facCode` char(3) DEFAULT NULL,
  `unitCode` char(4) DEFAULT NULL COMMENT '计量单位：季/段/块/件/个/箱/公斤/立方米/套/副/捆/层/片/卷/根',
  `itemnum` decimal(18,4) DEFAULT '0.0000',
  `sendNum` decimal(18,4) DEFAULT '0.0000',
  `itemPiece` decimal(18,4) DEFAULT '1.0000',
  `price` decimal(18,8) DEFAULT '0.00000000' COMMENT '财务结算时用',
  `itemvalue` decimal(18,2) DEFAULT '0.00' COMMENT '财务结算时用',
  `barcode` varchar(30) DEFAULT NULL,
  `cremark` varchar(60) DEFAULT NULL,
  `car_no` varchar(20) DEFAULT NULL,
  `carry_price` decimal(18,8) DEFAULT NULL,
  `run_price` decimal(18,8) DEFAULT NULL,
  `checkman` varchar(20) DEFAULT NULL,
  `checkdate` datetime DEFAULT NULL,
  `is_blanace` char(1) DEFAULT NULL,
  `is_prize` char(1) DEFAULT NULL COMMENT '财务未结算，又要计算成本时，获取预估价格',
  `purveybill` varchar(30) DEFAULT NULL,
  `balanceTme` datetime DEFAULT NULL,
  `spebill` varchar(50) DEFAULT NULL COMMENT '结算单号存在，代表已经结算，不存在代表未参与结算。',
  `is_error` char(1) DEFAULT NULL COMMENT '月结时成本核算有错误的单据，1：代表有错误，null或0代表没有错误',
  `is_monthbalance` char(1) DEFAULT NULL COMMENT '0：未参与月结 1：已参与月结',
  PRIMARY KEY (`rowno`,`inbillCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wh_inbill_d` */

insert  into `wh_inbill_d`(`rowno`,`inbillCode`,`itemcode`,`itemname`,`breadcode`,`breadname`,`standard`,`steelNo`,`facCode`,`unitCode`,`itemnum`,`sendNum`,`itemPiece`,`price`,`itemvalue`,`barcode`,`cremark`,`car_no`,`carry_price`,`run_price`,`checkman`,`checkdate`,`is_blanace`,`is_prize`,`purveybill`,`balanceTme`,`spebill`,`is_error`,`is_monthbalance`) values ('001','','003','带钢2.50*241','001','影魔',NULL,NULL,NULL,'吨','800.0000',NULL,NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('001','1906060090','003','带钢2.50*241','001','影魔',NULL,NULL,NULL,'吨','2222.0000',NULL,NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('001','1906060091','003','带钢2.50*241','001','影魔',NULL,NULL,NULL,'吨','100.0000',NULL,NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('001','1906060092','003','带钢2.50*241','002','莉娜',NULL,NULL,NULL,'吨','100.0000',NULL,NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('001','1906060093','003','带钢2.50*241','001','影魔',NULL,NULL,NULL,'吨','2222.0000',NULL,NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('001','1906140094','003','带钢2.50*241','001','影魔',NULL,NULL,NULL,'吨','500.0000',NULL,NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('002','','004','带钢2.50*243','001','影魔',NULL,NULL,NULL,'吨','500.0000','90.0000',NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('002','1906060090','004','带钢2.50*243','001','影魔',NULL,NULL,NULL,'吨','500.0000','90.0000',NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('002','1906060091','004','带钢2.50*243','001','影魔',NULL,NULL,NULL,'吨','500.0000','90.0000',NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('002','1906060092','004','带钢2.50*243','001','影魔',NULL,NULL,NULL,'吨','500.0000','90.0000',NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('002','1906060093','004','带钢2.50*243','001','影魔',NULL,NULL,NULL,'吨','500.0000','90.0000',NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('002','1906140094','018','圆钢32','001','影魔',NULL,NULL,NULL,'吨','200.0000',NULL,NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('003','','018','圆钢32','001','影魔',NULL,NULL,NULL,'吨','300.0000',NULL,NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('003','1906060090','018','圆钢32','001','影魔',NULL,NULL,NULL,'吨','500.0000',NULL,NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('003','1906060092','018','圆钢32','002','莉娜',NULL,NULL,NULL,'吨','300.0000',NULL,NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('003','1906060093','018','圆钢32','001','影魔',NULL,NULL,NULL,'吨','900.0000',NULL,NULL,'3200.00000000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `wh_inbill_h` */

DROP TABLE IF EXISTS `wh_inbill_h`;

CREATE TABLE `wh_inbill_h` (
  `inbillCode` char(15) NOT NULL COMMENT '入库单号为入库流水号简写：\r\n            年（2位）+月（2位）+日（2位）+三位流水号',
  `billType` char(1) DEFAULT NULL COMMENT '1、验货入库 2、退货入库 3、采购入库 4、红字回冲\r\n            当前业务默认为验货入库',
  `oldbill` char(16) DEFAULT NULL,
  `wareCode` char(2) DEFAULT NULL,
  `custName` varchar(100) DEFAULT NULL,
  `contactbill` varchar(30) DEFAULT NULL,
  `supplyName` varchar(100) DEFAULT NULL,
  `serverbill` varchar(30) DEFAULT NULL,
  `indate` datetime DEFAULT NULL,
  `tellMan` varchar(20) DEFAULT NULL,
  `tranType` char(2) DEFAULT NULL COMMENT '01汽车\r\n            02火车\r\n            03转存\r\n            04船运',
  `carrier` char(6) DEFAULT NULL,
  `vehicle` varchar(20) DEFAULT NULL,
  `driver` varchar(20) DEFAULT NULL,
  `identify_id` varchar(30) DEFAULT NULL,
  `motorman_tel` varchar(20) DEFAULT NULL,
  `remark` varchar(600) DEFAULT NULL,
  `billman` varchar(10) DEFAULT NULL,
  `billdate` datetime DEFAULT NULL,
  `stateman` varchar(10) DEFAULT NULL,
  `statedate` datetime DEFAULT NULL,
  `state` char(1) DEFAULT NULL COMMENT '0：未审核  1：已审核 ',
  `depart` char(4) DEFAULT NULL COMMENT '用于成本核算 默认为:1001',
  `vehType` char(1) DEFAULT NULL,
  `runbill` char(10) DEFAULT NULL,
  `runline` varchar(200) DEFAULT NULL,
  `inbuyman` varchar(10) DEFAULT NULL,
  `purType` char(1) DEFAULT NULL COMMENT '合同采购、临时采购、冲减期初余额',
  `bindCode` varchar(10) DEFAULT NULL,
  `senddate` datetime DEFAULT NULL COMMENT '供应商发货日期',
  PRIMARY KEY (`inbillCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wh_inbill_h` */

insert  into `wh_inbill_h`(`inbillCode`,`billType`,`oldbill`,`wareCode`,`custName`,`contactbill`,`supplyName`,`serverbill`,`indate`,`tellMan`,`tranType`,`carrier`,`vehicle`,`driver`,`identify_id`,`motorman_tel`,`remark`,`billman`,`billdate`,`stateman`,`statedate`,`state`,`depart`,`vehType`,`runbill`,`runline`,`inbuyman`,`purType`,`bindCode`,`senddate`) values ('1906050083',NULL,'','01','卡尔','','搜狐','0001','2019-05-26 16:00:00','蓝猫','0','邮政','湘A0001','白牛','430422199912122665','13888888888','这是一条好的数据',NULL,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'0','1906050083','2019-06-05 16:00:00'),('1906060084',NULL,'','01','','','阿里巴巴','','2019-05-26 16:00:00','蓝猫','0','顺丰','湘A0001','白牛','430422199912122665','','',NULL,'2019-06-06 02:52:44',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'0','1906060084','2019-06-14 16:00:00'),('1906060085',NULL,'','01','','','华为','','2019-05-26 16:00:00','火猫','0','韵达','湘A0001','白牛','430422199912122665','','',NULL,'2019-06-06 02:57:16',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'0','1906060085','2019-06-07 16:00:00'),('1906060086',NULL,'','01','','','网易','','2019-06-02 16:00:00','影魔','0','邮政','湘A0001','白牛','430422199912122665','','',NULL,'2019-06-06 03:02:06',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'0','1906060086','2019-06-15 16:00:00'),('1906060087',NULL,'','04','','','搜狐','0001','2019-05-26 16:00:00','影魔','0','韵达','湘A0001','白牛','430422199912122665','','',NULL,'2019-06-06 03:05:42',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'0','1906060087','2019-06-07 16:00:00'),('1906060088',NULL,'','04','','','腾讯','','2019-05-27 16:00:00','火猫','0','顺丰',NULL,'','','','',NULL,'2019-06-06 03:08:38',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'0','1906060088','2019-06-06 16:00:00'),('1906060089',NULL,'','03','','','华为','','2019-05-27 16:00:00','丽娜','0','圆通','湘A0001','白牛','430422199912122665','','',NULL,'2019-06-06 03:12:54',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'0','1906060089','2019-06-07 16:00:00'),('1906060090',NULL,'','01','','','华为','','2019-05-29 16:00:00','影魔','0','韵达','湘A0001','白牛','430422199912122665','','',NULL,'2019-06-06 03:14:44',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'0','1906060090','2019-06-07 16:00:00'),('1906060091',NULL,'','03','','','腾讯','','2019-05-26 16:00:00','火猫','0','圆通','湘A0001','白牛','430422199912122665','','',NULL,'2019-06-06 03:17:25',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'0','1906060091','2019-06-13 16:00:00'),('1906060092',NULL,'','03','','','搜狐','','2019-06-03 16:00:00','蓝猫','0','邮政','湘A0001','白牛','430422199912122665','','',NULL,'2019-06-06 03:21:41',NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,'0','1906060092','2019-06-14 16:00:00'),('1906060093',NULL,'','01','','','搜狐','','2019-05-26 16:00:00','火猫','0','圆通','湘A0001','白牛','430422199912122665','','',NULL,'2019-06-06 03:31:04',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'0','1906060093','2019-05-29 16:00:00'),('1906140094',NULL,'','04','','','腾讯','','2019-05-26 16:00:00','影魔','0','邮政','湘A0001','白牛','430422199912122665','','',NULL,'2019-06-14 07:16:15',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'0','1906140094','2019-05-29 16:00:00');

/*Table structure for table `wh_outbill_d` */

DROP TABLE IF EXISTS `wh_outbill_d`;

CREATE TABLE `wh_outbill_d` (
  `storebill` char(18) DEFAULT NULL,
  `areacode` varchar(11) DEFAULT NULL,
  `itemcode` char(6) NOT NULL DEFAULT '',
  `itemname` varchar(120) DEFAULT NULL,
  `breadcode` char(3) NOT NULL DEFAULT '',
  `outbillCode` char(15) DEFAULT NULL,
  `breadname` varchar(30) DEFAULT NULL,
  `supply_code` char(6) DEFAULT NULL,
  `standard` varchar(3) DEFAULT NULL,
  `steel_no` varchar(3) DEFAULT NULL,
  `batch_no` varchar(50) DEFAULT NULL,
  `fac_code` char(3) DEFAULT NULL,
  `unit_code` char(4) DEFAULT NULL,
  `plan_num` decimal(18,3) DEFAULT '0.000',
  `itemnum` decimal(18,3) DEFAULT '0.000',
  `item_piece` decimal(18,3) DEFAULT '1.000',
  `itemsalevalue` decimal(18,3) DEFAULT '0.000',
  `itemvalue` decimal(18,3) DEFAULT '0.000',
  `pay` decimal(18,2) DEFAULT NULL,
  `bar_code` varchar(30) DEFAULT NULL,
  `cremark` varchar(60) DEFAULT NULL,
  `containcode` char(4) DEFAULT NULL,
  `balance_date` char(6) DEFAULT NULL,
  `balance_price` decimal(18,3) DEFAULT NULL,
  `balance_time` datetime DEFAULT NULL,
  `spebill` varchar(50) DEFAULT NULL,
  `is_error` char(1) DEFAULT NULL,
  `uf_flag` char(1) DEFAULT NULL,
  `uf_flag1` char(1) DEFAULT NULL,
  KEY `FK_Reference_7` (`outbillCode`),
  KEY `FK_Reference_9` (`storebill`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`outbillCode`) REFERENCES `wh_outbill_h` (`outbillCode`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`storebill`) REFERENCES `wh_storage_d` (`storebill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wh_outbill_d` */

insert  into `wh_outbill_d`(`storebill`,`areacode`,`itemcode`,`itemname`,`breadcode`,`outbillCode`,`breadname`,`supply_code`,`standard`,`steel_no`,`batch_no`,`fac_code`,`unit_code`,`plan_num`,`itemnum`,`item_piece`,`itemsalevalue`,`itemvalue`,`pay`,`bar_code`,`cremark`,`containcode`,`balance_date`,`balance_price`,`balance_time`,`spebill`,`is_error`,`uf_flag`,`uf_flag1`) values ('1906060092001',NULL,'000001','钢铁公司','195','CKD201906168696','钢绞线12.7',NULL,NULL,NULL,NULL,NULL,NULL,'50.000','0.000','1.000','0.000','0.000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1906060092001',NULL,'000001','钢铁公司','195','CKD201906168697','钢绞线12.7',NULL,NULL,NULL,NULL,NULL,NULL,'50.000','0.000','1.000','0.000','0.000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `wh_outbill_h` */

DROP TABLE IF EXISTS `wh_outbill_h`;

CREATE TABLE `wh_outbill_h` (
  `outbillCode` char(16) NOT NULL,
  `sendbill` varchar(16) DEFAULT NULL,
  `salebill` char(16) DEFAULT NULL,
  `contactbill` varchar(30) DEFAULT NULL,
  `tag` varchar(10) DEFAULT NULL,
  `cust_code` char(6) DEFAULT NULL,
  `custtype` char(1) DEFAULT NULL,
  `ware_code` char(2) DEFAULT NULL,
  `project_code` char(10) DEFAULT NULL,
  `outdate` datetime DEFAULT NULL,
  `pickbill` varchar(50) DEFAULT NULL,
  `tell_man` varchar(20) DEFAULT NULL,
  `identify_id` varchar(30) DEFAULT NULL,
  `carrier` char(6) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `depart` char(4) DEFAULT NULL,
  `billtype` char(1) DEFAULT NULL,
  `vehicle` varchar(20) DEFAULT NULL,
  `driver` varchar(20) DEFAULT NULL,
  `motorman_tel` varchar(20) DEFAULT NULL,
  `remark` varchar(600) DEFAULT NULL,
  `billman` varchar(20) DEFAULT NULL,
  `stateman` varchar(20) DEFAULT NULL,
  `billdate` datetime DEFAULT NULL,
  `statedate` datetime DEFAULT NULL,
  `tran_type` char(10) DEFAULT NULL,
  `input_flag` char(1) DEFAULT '0',
  `veh_type` char(1) DEFAULT '0',
  `send_type` char(10) DEFAULT NULL,
  `runbill` char(10) DEFAULT NULL,
  `runline` char(3) DEFAULT NULL,
  `runprice` decimal(18,3) DEFAULT NULL,
  `rununit` char(4) DEFAULT NULL,
  `runcontact` varchar(30) DEFAULT NULL,
  `runstate` char(1) DEFAULT NULL,
  `supply_code` char(6) DEFAULT NULL,
  `batch_bill` char(16) DEFAULT NULL,
  `plan_code` varchar(30) DEFAULT NULL,
  `bind_code` varchar(20) DEFAULT NULL,
  `inware_code` char(2) DEFAULT NULL,
  `is_toware` char(1) DEFAULT NULL,
  `balance_date` datetime DEFAULT NULL,
  `spebill` varchar(30) DEFAULT NULL,
  `is_error` char(1) DEFAULT NULL,
  PRIMARY KEY (`outbillCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wh_outbill_h` */

insert  into `wh_outbill_h`(`outbillCode`,`sendbill`,`salebill`,`contactbill`,`tag`,`cust_code`,`custtype`,`ware_code`,`project_code`,`outdate`,`pickbill`,`tell_man`,`identify_id`,`carrier`,`state`,`depart`,`billtype`,`vehicle`,`driver`,`motorman_tel`,`remark`,`billman`,`stateman`,`billdate`,`statedate`,`tran_type`,`input_flag`,`veh_type`,`send_type`,`runbill`,`runline`,`runprice`,`rununit`,`runcontact`,`runstate`,`supply_code`,`batch_bill`,`plan_code`,`bind_code`,`inware_code`,`is_toware`,`balance_date`,`spebill`,`is_error`) values ('06897418690','120119001','1110001',NULL,'广州','1',NULL,'01','广州','2019-03-24 00:00:00','120119001','刘绍瑞','430','域卡','0',NULL,NULL,'V00001','唐凯','15085796521',NULL,'谭','lucy','2019-05-27 10:10:25',NULL,'小轿车','0','0','配送出库','050896001','','150.000','1','138100120','0','S00098',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('06897418691','120119002','1110002',NULL,'广州2','1',NULL,'01','广州','2019-03-30 00:00:00','120119002','刘绍瑞','5','域卡','0',NULL,NULL,'V00001','唐凯','15085796531',NULL,'谭','lucy','2019-05-28 10:10:25',NULL,'小轿车','0','0','配送出库','050896002','','150.000','1','138100121','0','S00098',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('06897418692','120119003','1110003',NULL,'广州2','1',NULL,'01','广州2','2019-04-06 00:00:00','120119003','刘绍瑞','430','域卡','0',NULL,NULL,'V00001','唐凯','15085796531',NULL,'谭','lucy','2019-05-28 10:10:25',NULL,'小轿车','0','0','配送出库','050896003','','150.000','1','138100122','0','S00098',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('06897418693','120119004','1110004',NULL,'广州','1',NULL,'01','广州2','2019-03-19 00:00:00','120119004','刘绍瑞','430','域卡','0',NULL,NULL,'V00001','唐凯','15085796531',NULL,'谭','lucy','2019-05-28 10:10:25',NULL,'小轿车','0','0','配送出库','050896004','','150.000','1','138100123','0','S00098',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('CKD201906168694',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('CKD201906168695',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('CKD201906168696','','1110002',NULL,'','',NULL,'01','dota','2019-06-04 16:00:00','','','','','1',NULL,NULL,'','','',NULL,NULL,NULL,'2019-06-22 16:00:00',NULL,'小轿车',NULL,NULL,'配送出库',NULL,'',NULL,'',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('CKD201906168697','','1110002',NULL,'',NULL,NULL,'01','广州','2019-05-30 16:00:00','','','','','0',NULL,NULL,'','','',NULL,NULL,NULL,'2019-06-21 16:00:00',NULL,'',NULL,NULL,'',NULL,NULL,NULL,'',NULL,NULL,'S00001',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `wh_storage` */

DROP TABLE IF EXISTS `wh_storage`;

CREATE TABLE `wh_storage` (
  `wareCode` varchar(2) NOT NULL,
  `itemcode` char(6) NOT NULL,
  `breadcode` char(3) NOT NULL,
  `item_piece` int(11) DEFAULT '0',
  `plannum` decimal(18,4) DEFAULT '0.0000',
  `itemnum` decimal(18,4) DEFAULT '0.0000',
  PRIMARY KEY (`itemcode`,`wareCode`,`breadcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wh_storage` */

/*Table structure for table `wh_storage_d` */

DROP TABLE IF EXISTS `wh_storage_d`;

CREATE TABLE `wh_storage_d` (
  `storebill` char(18) NOT NULL COMMENT '入库主键+材料流水号主键',
  `itemcode` char(6) DEFAULT NULL,
  `breadcode` char(3) DEFAULT NULL,
  `wareCode` char(2) DEFAULT NULL,
  `unitCode` char(4) DEFAULT NULL,
  `plannum` decimal(18,4) DEFAULT NULL,
  `itemnum` decimal(18,4) DEFAULT '0.0000',
  `fromTable` char(1) DEFAULT NULL COMMENT 'inbill:验货入库:',
  `indate` datetime DEFAULT NULL,
  PRIMARY KEY (`storebill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wh_storage_d` */

insert  into `wh_storage_d`(`storebill`,`itemcode`,`breadcode`,`wareCode`,`unitCode`,`plannum`,`itemnum`,`fromTable`,`indate`) values ('1906060092001','003','002','03',NULL,'50.0000','50.0000',NULL,'2019-06-04 00:00:00'),('1906060092002','004','002','03',NULL,'0.0000','200.0000',NULL,'2019-06-04 00:00:00'),('1906060092003','018','002','03',NULL,'0.0000','300.0000',NULL,'2019-06-04 00:00:00');

/*Table structure for table `vw_wh_storage` */

DROP TABLE IF EXISTS `vw_wh_storage`;

/*!50001 DROP VIEW IF EXISTS `vw_wh_storage` */;
/*!50001 DROP TABLE IF EXISTS `vw_wh_storage` */;

/*!50001 CREATE TABLE  `vw_wh_storage`(
 `itemcode` char(6) NULL ,
 `breadcode` char(3) NULL ,
 `warecode` char(2) NULL ,
 `plannum` decimal(40,4) NULL ,
 `itemnum` decimal(40,4) NULL 
)*/;

/*View structure for view vw_wh_storage */

/*!50001 DROP TABLE IF EXISTS `vw_wh_storage` */;
/*!50001 DROP VIEW IF EXISTS `vw_wh_storage` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_wh_storage` AS select `wh_storage_d`.`itemcode` AS `itemcode`,`wh_storage_d`.`breadcode` AS `breadcode`,`wh_storage_d`.`wareCode` AS `warecode`,sum(`wh_storage_d`.`plannum`) AS `plannum`,sum(`wh_storage_d`.`itemnum`) AS `itemnum` from `wh_storage_d` group by `wh_storage_d`.`itemcode`,`wh_storage_d`.`breadcode`,`wh_storage_d`.`wareCode` */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
