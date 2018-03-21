-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hoteldatabase
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `iduser` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` int(11) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (360448,'beta1',1310455714,'eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyUGFzc3dvcmQiOiJiZXRhMSIsInVzZXJuYW1lIjoiYmVhYXRyNDUifQ.O79xVYOosX8AlfsDtjiTChAhAuS7Od_aktEMAFEM2PWrMNZP2scubtzh0C6NHsReTGmyjlcyezwTVhXZMoXpEg');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest`
--

DROP TABLE IF EXISTS `guest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guest` (
  `idGuest` int(11) NOT NULL AUTO_INCREMENT,
  `arrivaldate` datetime DEFAULT NULL,
  `departureDate` datetime DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`idGuest`),
  KEY `idGuest` (`idGuest`)
) ENGINE=InnoDB AUTO_INCREMENT=294913 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest`
--

LOCK TABLES `guest` WRITE;
/*!40000 ALTER TABLE `guest` DISABLE KEYS */;
INSERT INTO `guest` VALUES (262144,'1667-01-13 00:00:00','1668-01-13 00:00:00','alex'),(262145,'1667-01-13 00:00:00','1669-01-13 00:00:00','bill'),(262146,'1667-01-13 00:00:00','1670-01-13 00:00:00','norman'),(294912,'1997-01-01 00:00:00','1997-01-01 00:00:00','jena');
/*!40000 ALTER TABLE `guest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_next_hi_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` VALUES ('room',38),('guest',10),('history',4),('service',1),('client',12);
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `idhistory` int(11) NOT NULL AUTO_INCREMENT,
  `enable` bit(1) DEFAULT NULL,
  `guest` int(11) DEFAULT NULL,
  `room` int(11) DEFAULT NULL,
  PRIMARY KEY (`idhistory`),
  KEY `FK_57yp5x4mu5pelt6p7sqbgf5sa` (`guest`),
  KEY `FK_ebhvwfwo2a9damdehn4ojg0am` (`room`),
  CONSTRAINT `FK_57yp5x4mu5pelt6p7sqbgf5sa` FOREIGN KEY (`guest`) REFERENCES `guest` (`idGuest`),
  CONSTRAINT `FK_ebhvwfwo2a9damdehn4ojg0am` FOREIGN KEY (`room`) REFERENCES `room` (`idRoom`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (4,'',262144,1212417),(5,'',262146,1212418),(6,'',262144,1212416),(7,'',262144,1212416),(8,'',262145,1212416),(9,'\0',262146,1212416),(10,'\0',262144,1212416);
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `idRoom` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `numberOfStars` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `busy` tinyint(1) NOT NULL,
  PRIMARY KEY (`idRoom`),
  KEY `idRoom` (`idRoom`)
) ENGINE=InnoDB AUTO_INCREMENT=1212419 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1212416,101,150011,5,4,'serviced',1),(1212417,202,1500211,1,2,'serviced',0),(1212418,909,1151,3,5,'serviced',0);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `idService` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `history_idhistory` int(11) NOT NULL,
  `service_idservice` int(11) NOT NULL,
  `idroom` int(11) NOT NULL,
  `idhistory` int(11) NOT NULL,
  PRIMARY KEY (`idService`),
  KEY `idService` (`idService`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'taxi',999,0,0,0,0),(2,'Ironing',2000,0,0,0,0),(3,'wake-up',1000,0,0,0,0);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `idhistory` int(11) NOT NULL,
  `idservice` int(11) NOT NULL,
  KEY `FK_8xwjv6ylavg9t2lkushs2j9h7` (`idservice`),
  KEY `FK_9upkwwsdu7fxdsijayll0rf6n` (`idhistory`),
  CONSTRAINT `FK_8xwjv6ylavg9t2lkushs2j9h7` FOREIGN KEY (`idservice`) REFERENCES `service` (`idService`),
  CONSTRAINT `FK_9upkwwsdu7fxdsijayll0rf6n` FOREIGN KEY (`idhistory`) REFERENCES `history` (`idhistory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (10,1),(10,2);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-21 19:32:59
