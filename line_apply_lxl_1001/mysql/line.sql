-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: line
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `pcode`
--

DROP TABLE IF EXISTS `pcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pcode` (
  `idpcode` int(11) NOT NULL AUTO_INCREMENT,
  `phonenum` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpcode`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pcode`
--

LOCK TABLES `pcode` WRITE;
/*!40000 ALTER TABLE `pcode` DISABLE KEYS */;
INSERT INTO `pcode` VALUES (2,'17733569416','9976'),(3,'18303366493','6569'),(4,'18235390758','6694'),(5,'15822144430','5962');
/*!40000 ALTER TABLE `pcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stds`
--

DROP TABLE IF EXISTS `stds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stds` (
  `idstds` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `id` varchar(45) DEFAULT NULL,
  `phonenum` varchar(45) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`idstds`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stds`
--

LOCK TABLES `stds` WRITE;
/*!40000 ALTER TABLE `stds` DISABLE KEYS */;
INSERT INTO `stds` VALUES (4,'kkkk','s000000','啊葱','111111111111111111','18303366493',20),(6,'轻微','100000','嗷嗷嗷','333333333333333333','17733569416',10),(7,'hhhhh','123456','黄飞鸿','200000000000000000','18235390758',90),(8,'hhhh','123456','好声音','600000000000000000','15822144430',80);
/*!40000 ALTER TABLE `stds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tec`
--

DROP TABLE IF EXISTS `tec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tec` (
  `idnew_table` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `phonenum` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idnew_table`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tec`
--

LOCK TABLES `tec` WRITE;
/*!40000 ALTER TABLE `tec` DISABLE KEYS */;
INSERT INTO `tec` VALUES (1,'鲁迅','111111',NULL);
/*!40000 ALTER TABLE `tec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(45) DEFAULT NULL,
  `a` varchar(45) DEFAULT NULL,
  `b` varchar(45) DEFAULT NULL,
  `c` varchar(45) DEFAULT NULL,
  `d` varchar(45) DEFAULT NULL,
  `answ` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (53,'下列哪个是英语单词','qqqq','哈哈哈哈','giao','yes','a'),(54,'兄弟们','哈哈哈哈','们个der','好','再见','a'),(55,'窗前明月光作者?','李黑','李红','李兰','李白','a'),(65,'唐代之后是哪个朝代','民国','宋','元','明','a'),(66,'英语的单词','word','english','math','qq','a'),(67,'不是腾讯的软件','qq','微信','腾讯视频','支付宝','a'),(74,'你的名字','李哈哈','你管','不告诉你','滚','a'),(75,'100<100?','对','不大于','等于','不确定','a'),(81,'lpl中价格最高的选手','阿水','乌兹','shy','厂长','a'),(87,'哪所是北京的大学','吉林大学','天津大学','南开大学','清华大学','a');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-15 15:01:21
