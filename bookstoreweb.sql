-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstoreweb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tblaccount`
--

DROP TABLE IF EXISTS `tblaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblaccount` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `PHONENUMBER` varchar(255) DEFAULT NULL,
  `CREDITCARD` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `ROLE` varchar(255) DEFAULT 'CLIENT',
  `EMAIL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblaccount`
--

LOCK TABLES `tblaccount` WRITE;
/*!40000 ALTER TABLE `tblaccount` DISABLE KEYS */;
INSERT INTO `tblaccount` VALUES (1,'ADMIN','','','','ADMIN','ADMIN','ADMIN',''),(11,'Trần Minh Hải','Hà Nội','0972644728','','hai262','2621997','ADMIN','i1.vagabondwolf@gmail.com'),(23,'Trần Văn Tét','','','','test','test','CLIENT',''),(24,'Lê Văn Thắng','','','','thangle1202','123456','ADMIN',''),(25,'','','','','servlet','servlet','CLIENT','');
/*!40000 ALTER TABLE `tblaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblbook`
--

DROP TABLE IF EXISTS `tblbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblbook` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `AUTHOR` varchar(255) DEFAULT NULL,
  `PUBLISHER` varchar(255) DEFAULT NULL,
  `CATEGORY` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `SOLD` int(10) DEFAULT NULL,
  `RELEASEDYEAR` int(10) DEFAULT NULL,
  `IMAGEURL` varchar(255) DEFAULT NULL,
  `DISCOUNT` int(15) DEFAULT NULL,
  `FINALPRICE` int(15) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbook`
--

LOCK TABLES `tblbook` WRITE;
/*!40000 ALTER TABLE `tblbook` DISABLE KEYS */;
INSERT INTO `tblbook` VALUES (2,'Cái chết tựa như cơn gió','Da Thị Xua','RIOT','Kiếm hiệp','Luôn quanh ta',NULL,2000,'image/yasuo.jpg',50000,100000),(3,'Ái tình nơi đầu lưỡi','Jo Kyung Ran','Chưa cập nhật','Chưa cập nhật','Chưa cập nhật',NULL,2001,'image/aitinhnoidauluoi.jpg',30000,50000),(4,'A scent of water','Edward Earwood','NXB Giáo dục','Giáo dục','Bringing life back to the Christian school movement',NULL,1999,'image/ascentofwater.jpg',50000,150000),(5,'Chuyện con mèo dạy hải âu bay','Luis Sepúlveda','NXB Hội nhà văen','Tiểu thuyết','Con mòe',NULL,2007,'image/chuyenconmeodayhaiaubay.jpg',50000,50000),(6,'Chuyện kể năm 2000','Bùi Ngọc Tấn','NXB Thanh Niên','Ngụ ngôn','Những câu chuyện ngụ ngôn năm 2000',NULL,1997,'image/chuyenkenam2000.jpg',30000,70000),(7,'Có 2 con mèo ngồi bên cửa sổ','Nguyễn Nhật Ánh','NXB Trẻ','Tiểu thuyết','Cuộc đời của 2 chú mòe',NULL,1999,'image/cohaiconmeongoibencuaso.jpg',50000,150000),(11,'Còn chút gì để nhớ','Nguyễn Nhật Ánh','NXB Trẻ','Truyện ngắn','asdasd',NULL,1997,'image/conchutgidenho.jpg',0,70000),(12,'Dangerous Frames','Nicholas J.G.Winter','NXB Nước ngoài','Kĩ năng sống','How ideas about rage & gender shape public opinion',NULL,1977,'image/dangerousframes.jpg',0,170000),(13,'Đôi mắt không còn ướt nước','Chưa cập nhật','Chưa cập nhật','Tiểu thuyết','Chưa cập nhật',NULL,2001,'image/doimatkhongconuotnuoc.jpg',0,30000),(14,'Giấc mơ đôi chân thiên thần','Trần Trà My','NXB Lao Động','Truyện ngắn','Chưa cập nhật',NULL,1990,'image/giacmodoichanthienthan.jpg',0,70000),(15,'Invoker','In hữu cơ','VALVE','Giả tưởng','Hiểu biết là sức mạnh',NULL,2009,'image/invoker.jpg',0,190000),(21,'Yêu trên từng ngón tay','Trần Trà My','Chưa cập nhật','Tiểu thuyết','Chưa cập nhật',NULL,2007,'image/yeutrentungngontay.jpg',0,160000);
/*!40000 ALTER TABLE `tblbook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblbooksincart`
--

DROP TABLE IF EXISTS `tblbooksincart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblbooksincart` (
  `ACCOUNTID` int(10) DEFAULT NULL,
  `BOOKID` int(10) DEFAULT NULL,
  `QUANTITY` int(10) DEFAULT NULL,
  KEY `ACCOUNTID` (`ACCOUNTID`),
  KEY `BOOKID` (`BOOKID`),
  CONSTRAINT `booksincart_ibfk_1` FOREIGN KEY (`ACCOUNTID`) REFERENCES `tblaccount` (`id`),
  CONSTRAINT `booksincart_ibfk_2` FOREIGN KEY (`BOOKID`) REFERENCES `tblbook` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbooksincart`
--

LOCK TABLES `tblbooksincart` WRITE;
/*!40000 ALTER TABLE `tblbooksincart` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblbooksincart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblbooksinfavorite`
--

DROP TABLE IF EXISTS `tblbooksinfavorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblbooksinfavorite` (
  `ACCOUNTID` int(15) NOT NULL,
  `BOOKID` int(15) NOT NULL,
  PRIMARY KEY (`ACCOUNTID`,`BOOKID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbooksinfavorite`
--

LOCK TABLES `tblbooksinfavorite` WRITE;
/*!40000 ALTER TABLE `tblbooksinfavorite` DISABLE KEYS */;
INSERT INTO `tblbooksinfavorite` VALUES (11,2),(11,5),(23,7);
/*!40000 ALTER TABLE `tblbooksinfavorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblbooksinorder`
--

DROP TABLE IF EXISTS `tblbooksinorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblbooksinorder` (
  `ORDERID` int(10) DEFAULT NULL,
  `BOOKID` int(10) DEFAULT NULL,
  `QUANTITY` int(15) DEFAULT NULL,
  KEY `ORDERID` (`ORDERID`),
  CONSTRAINT `tblbooksinorder_ibfk_1` FOREIGN KEY (`ORDERID`) REFERENCES `tblorder` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbooksinorder`
--

LOCK TABLES `tblbooksinorder` WRITE;
/*!40000 ALTER TABLE `tblbooksinorder` DISABLE KEYS */;
INSERT INTO `tblbooksinorder` VALUES (4,4,1),(5,5,1),(6,4,1);
/*!40000 ALTER TABLE `tblbooksinorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblfeedback`
--

DROP TABLE IF EXISTS `tblfeedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblfeedback` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `MESSAGE` longtext NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `ACCOUNTID` int(15) DEFAULT NULL,
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblfeedback`
--

LOCK TABLES `tblfeedback` WRITE;
/*!40000 ALTER TABLE `tblfeedback` DISABLE KEYS */;
INSERT INTO `tblfeedback` VALUES (1,'alo',NULL,NULL);
/*!40000 ALTER TABLE `tblfeedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbllog`
--

DROP TABLE IF EXISTS `tbllog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbllog` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `DATE` varchar(255) DEFAULT NULL,
  `ACCOUNTID` int(10) NOT NULL,
  `OBJECTTYPE` varchar(255) NOT NULL,
  `OBJECTID` int(10) NOT NULL,
  `ACTION` varchar(255) DEFAULT NULL,
  `DETAIL` longtext,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllog`
--

LOCK TABLES `tbllog` WRITE;
/*!40000 ALTER TABLE `tbllog` DISABLE KEYS */;
INSERT INTO `tbllog` VALUES (2,'Mon Nov 05 02:38:25 ICT 2018',11,'BOOK',0,'ADD',NULL),(3,'Mon Nov 05 02:57:16 ICT 2018',11,'BOOK',0,'ADD',NULL),(4,'Mon Nov 05 03:23:42 ICT 2018',11,'BOOK',0,'ADD',NULL),(5,'Mon Nov 05 03:38:00 ICT 2018',11,'BOOK',0,'ADD',NULL),(6,'Mon Nov 05 04:08:02 ICT 2018',11,'BOOK',0,'ADD',NULL),(7,'Sun Nov 11 14:21:20 ICT 2018',11,'BOOK',0,'ADD',NULL),(8,'Sun Nov 11 14:26:37 ICT 2018',11,'BOOK',0,'ADD',NULL);
/*!40000 ALTER TABLE `tbllog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblorder`
--

DROP TABLE IF EXISTS `tblorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblorder` (
  `ID` int(15) NOT NULL AUTO_INCREMENT,
  `ACCOUNTID` int(10) DEFAULT NULL,
  `CREATEDDATE` varchar(255) DEFAULT NULL,
  `ADDRESS` longtext,
  `PHONENUMBER` varchar(255) DEFAULT NULL,
  `TOTALPRICE` int(11) DEFAULT NULL,
  `ISDELIVERING` tinyint(1) DEFAULT '0',
  `ISDELIVERED` tinyint(1) DEFAULT '0',
  `ISPAID` tinyint(1) DEFAULT '0',
  `CLIENTNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ACCOUNTID` (`ACCOUNTID`),
  CONSTRAINT `tblorder_ibfk_1` FOREIGN KEY (`ACCOUNTID`) REFERENCES `tblaccount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblorder`
--

LOCK TABLES `tblorder` WRITE;
/*!40000 ALTER TABLE `tblorder` DISABLE KEYS */;
INSERT INTO `tblorder` VALUES (4,11,'Mon Nov 05 18:35:54 ICT 2018','Hà Nội','0972644728',150000,0,0,0,'Trần Minh Hải'),(5,11,'Mon Nov 05 18:50:35 ICT 2018','HCM','0972644728',50000,0,0,0,'Trần Minh Hải'),(6,11,'Tue Nov 06 10:54:18 ICT 2018','Hà Nội','0972644728',150000,0,0,0,'Trần Minh Hải');
/*!40000 ALTER TABLE `tblorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bookstoreweb'
--

--
-- Dumping routines for database 'bookstoreweb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-11 23:36:52
