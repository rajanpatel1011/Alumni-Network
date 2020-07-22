-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: aumninw
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adminlogin`
--

DROP TABLE IF EXISTS `adminlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adminlogin` (
  `a_id` int unsigned NOT NULL AUTO_INCREMENT,
  `aU_name` varchar(50) DEFAULT NULL,
  `a_pwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminlogin`
--

LOCK TABLES `adminlogin` WRITE;
/*!40000 ALTER TABLE `adminlogin` DISABLE KEYS */;
INSERT INTO `adminlogin` VALUES (1,'rajan','rajan');
/*!40000 ALTER TABLE `adminlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `album` (
  `a_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `uplodr_Id` int unsigned DEFAULT NULL,
  `perm_Id` int unsigned NOT NULL DEFAULT '0',
  `date_time` datetime DEFAULT NULL,
  `caption` varchar(200) DEFAULT NULL,
  `upload_pic` varchar(50) DEFAULT NULL,
  `albm_name` varchar(45) NOT NULL DEFAULT '',
  `creator_Id` int unsigned NOT NULL DEFAULT '0',
  `albm_pic` varchar(45) NOT NULL DEFAULT '',
  `details` varchar(45) NOT NULL DEFAULT '',
  `creation_dttime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `taken_dttime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `delete_flag` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`a_Id`),
  KEY `FK_gallary_permission` (`perm_Id`),
  CONSTRAINT `FK_gallary_permission` FOREIGN KEY (`perm_Id`) REFERENCES `permision` (`perm_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `b_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `Branch_Name` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`b_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'Information Technology'),(2,'Computer Engineering'),(3,'Automobile Engineering'),(4,'Elec. & Comm. Engg.'),(5,'Mechanical Engineering');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `c_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `f_Id` int unsigned NOT NULL DEFAULT '0',
  `cmt_data` varchar(500) DEFAULT NULL,
  `m_Id` int unsigned DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `rate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`c_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `degree_type`
--

DROP TABLE IF EXISTS `degree_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `degree_type` (
  `d_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `degree_Type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`d_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `degree_type`
--

LOCK TABLES `degree_type` WRITE;
/*!40000 ALTER TABLE `degree_type` DISABLE KEYS */;
INSERT INTO `degree_type` VALUES (1,'B.E'),(2,'M.E'),(3,'other');
/*!40000 ALTER TABLE `degree_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doc_req`
--

DROP TABLE IF EXISTS `doc_req`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doc_req` (
  `doc_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `m_Id` int unsigned DEFAULT NULL,
  `data` varchar(500) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `email_Id` varchar(50) DEFAULT NULL,
  `sub` varchar(50) DEFAULT NULL,
  `accept` varchar(5) DEFAULT NULL,
  `pannding` varchar(5) DEFAULT NULL,
  `ready` varchar(5) DEFAULT NULL,
  `rejected` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`doc_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doc_req`
--

LOCK TABLES `doc_req` WRITE;
/*!40000 ALTER TABLE `doc_req` DISABLE KEYS */;
/*!40000 ALTER TABLE `doc_req` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edu_details`
--

DROP TABLE IF EXISTS `edu_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edu_details` (
  `e_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `m_Id` int unsigned DEFAULT NULL,
  `d_Id` int unsigned DEFAULT NULL,
  `cource_name` varchar(50) DEFAULT NULL,
  `year` varchar(50) DEFAULT NULL,
  `college_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`e_Id`),
  KEY `FK_edu_details_M_Id` (`m_Id`),
  KEY `FK_edu_details_D_Id` (`d_Id`),
  CONSTRAINT `FK_edu_details_D_Id` FOREIGN KEY (`d_Id`) REFERENCES `degree_type` (`d_Id`),
  CONSTRAINT `FK_edu_details_M_Id` FOREIGN KEY (`m_Id`) REFERENCES `members` (`m_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edu_details`
--

LOCK TABLES `edu_details` WRITE;
/*!40000 ALTER TABLE `edu_details` DISABLE KEYS */;
INSERT INTO `edu_details` VALUES (1,1,1,'Microsoft Certified','2006','B.V.M'),(2,1,2,'Java','2008','SAMCDM'),(3,201402,3,'Microsoft Certified','2010','A.D.I.T'),(4,201402,2,'M.e','2008','G.H..Patel');
/*!40000 ALTER TABLE `edu_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `evnt_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `evnt_Pic` varchar(50) DEFAULT NULL,
  `org_dat_time` datetime DEFAULT NULL,
  `description` varbinary(500) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`evnt_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faq`
--

DROP TABLE IF EXISTS `faq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faq` (
  `f_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `que` varchar(200) DEFAULT NULL,
  `ans` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`f_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faq`
--

LOCK TABLES `faq` WRITE;
/*!40000 ALTER TABLE `faq` DISABLE KEYS */;
/*!40000 ALTER TABLE `faq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forum` (
  `f_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `p_sub` varchar(50) DEFAULT NULL,
  `perm_Id` int unsigned DEFAULT NULL,
  `creator_Id` int unsigned DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `reciver_Id` int unsigned DEFAULT NULL,
  `No_Of_cmt` int unsigned DEFAULT NULL,
  `desription` varchar(100) NOT NULL DEFAULT '',
  `pinned_flag` int unsigned NOT NULL DEFAULT '0',
  `delete_flag` int unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`f_Id`),
  KEY `FK_forum_cratorId` (`creator_Id`),
  KEY `FK_forum_p_id` (`perm_Id`),
  CONSTRAINT `FK_forum_cratorId` FOREIGN KEY (`creator_Id`) REFERENCES `members` (`m_Id`),
  CONSTRAINT `FK_forum_perm_Id` FOREIGN KEY (`perm_Id`) REFERENCES `permision` (`perm_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (1,'Maths 1 doubt solved',1,1,'2013-02-03 00:00:00',NULL,0,'I have a doubt and now its solved',0,0),(2,'Operating system',2,1,'2013-06-08 00:00:00',NULL,0,'Does anyone have Mac OS ? ',0,0),(3,'dsds',2,1,'2014-03-21 12:56:11',201402,0,'sdfsd',0,0),(4,'sfds',3,2,'2014-03-21 13:51:21',NULL,0,'ffsdfgsg',0,0),(5,'sub1',2,2,'2014-03-21 14:00:01',NULL,0,'description',0,0),(6,'new',2,1,'2014-03-22 09:30:53',NULL,0,'evet',0,0),(7,'subjet',2,1,'2014-03-22 09:34:39',201402,0,'sdfds',0,0),(8,'topic',3,1,'2014-03-22 09:35:54',NULL,0,'desctiption testing',0,0),(9,'New Subject',4,2,'2014-03-22 10:51:16',1,0,'New Description',0,0),(10,'rahul',1,1,'2014-03-30 16:57:50',2,0,'123',0,0),(11,'suraj',2,1,'2014-03-30 16:58:37',NULL,0,'sdldbdmbvbmmm',0,0),(12,'hsdgds',3,1,'2014-03-30 18:48:01',201402,0,'vdvds',0,0),(13,'Jgdg',2,1,'2014-03-30 19:04:40',NULL,0,'hhssss',0,0),(14,'JAY',2,1,'2014-03-30 19:05:21',NULL,0,'KSGGSDGGSGSDGDSGDSGSGSDFG',0,0),(15,'Rajan',1,1,'2014-03-30 19:18:16',NULL,0,'ddssd',0,0),(16,'akash',2,1,'2014-04-06 17:31:30',NULL,0,'ffffffffff',0,0),(17,'newupdate',1,1,'2014-04-07 15:29:38',NULL,0,'update',0,0),(18,'Rajan',1,201402,'2014-04-08 18:41:32',NULL,0,'hello',0,0),(19,'at now',2,201402,'2014-04-08 18:41:55',NULL,0,'fgdsf',0,0),(20,'iiiiiii',1,201402,'2020-07-21 23:55:08',NULL,1,'i-',0,1);
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `helpsuppot`
--

DROP TABLE IF EXISTS `helpsuppot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `helpsuppot` (
  `h_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `email_Id` varchar(50) DEFAULT NULL,
  `msg` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`h_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `helpsuppot`
--

LOCK TABLES `helpsuppot` WRITE;
/*!40000 ALTER TABLE `helpsuppot` DISABLE KEYS */;
/*!40000 ALTER TABLE `helpsuppot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hobbies`
--

DROP TABLE IF EXISTS `hobbies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hobbies` (
  `hob_id` int unsigned NOT NULL AUTO_INCREMENT,
  `hob_name` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`hob_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hobbies`
--

LOCK TABLES `hobbies` WRITE;
/*!40000 ALTER TABLE `hobbies` DISABLE KEYS */;
INSERT INTO `hobbies` VALUES (1,'Reading'),(2,'Sleeping'),(3,'Traveling');
/*!40000 ALTER TABLE `hobbies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `init_mod`
--

DROP TABLE IF EXISTS `init_mod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `init_mod` (
  `in_mod_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `b_Id` int unsigned DEFAULT NULL,
  `p_Id` int unsigned DEFAULT NULL,
  `i_Id1` int unsigned DEFAULT NULL,
  `i_Id2` int unsigned DEFAULT NULL,
  PRIMARY KEY (`in_mod_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `init_mod`
--

LOCK TABLES `init_mod` WRITE;
/*!40000 ALTER TABLE `init_mod` DISABLE KEYS */;
/*!40000 ALTER TABLE `init_mod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `init_users`
--

DROP TABLE IF EXISTS `init_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `init_users` (
  `i_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `m_Id` int unsigned DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`i_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `init_users`
--

LOCK TABLES `init_users` WRITE;
/*!40000 ALTER TABLE `init_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `init_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_hob`
--

DROP TABLE IF EXISTS `member_hob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_hob` (
  `mh_id` int unsigned NOT NULL AUTO_INCREMENT,
  `m_id` int unsigned NOT NULL DEFAULT '0',
  `hob_id` int unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`mh_id`),
  KEY `FK_member_hob_mId` (`m_id`),
  KEY `FK_member_hob_hId` (`hob_id`),
  CONSTRAINT `FK_member_hob_hId` FOREIGN KEY (`hob_id`) REFERENCES `hobbies` (`hob_id`),
  CONSTRAINT `FK_member_hob_mId` FOREIGN KEY (`m_id`) REFERENCES `members` (`m_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_hob`
--

LOCK TABLES `member_hob` WRITE;
/*!40000 ALTER TABLE `member_hob` DISABLE KEYS */;
INSERT INTO `member_hob` VALUES (1,1,2),(2,1,3),(3,1,1),(4,201402,2),(5,201402,1);
/*!40000 ALTER TABLE `member_hob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members` (
  `m_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `u_Id` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `f_name` varchar(50) DEFAULT NULL,
  `m_name` varchar(50) DEFAULT NULL,
  `l_name` varchar(50) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `email_Id` varchar(50) DEFAULT NULL,
  `enr_No` varchar(50) DEFAULT NULL,
  `Mob_No` varchar(15) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `acc_type` int unsigned DEFAULT NULL,
  `hobbies` varchar(100) DEFAULT NULL,
  `profile_pic` varchar(50) DEFAULT NULL,
  `b_Id` int unsigned DEFAULT NULL,
  `p_Id` int unsigned DEFAULT NULL,
  `highest_degree` varchar(45) DEFAULT NULL,
  `first_login` int unsigned DEFAULT NULL,
  `add1` varchar(45) DEFAULT NULL,
  `add2` varchar(45) DEFAULT NULL,
  `tot_exp_month` varchar(45) DEFAULT NULL,
  `tot_exp_year` varchar(45) DEFAULT NULL,
  `keyskills` varchar(100) DEFAULT NULL,
  `mod_Id` int unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`m_Id`),
  KEY `FK_members_branch` (`b_Id`),
  KEY `FK_members_passout` (`p_Id`),
  CONSTRAINT `FK_members_branch` FOREIGN KEY (`b_Id`) REFERENCES `branch` (`b_Id`),
  CONSTRAINT `FK_members_passout` FOREIGN KEY (`p_Id`) REFERENCES `passout_year` (`p_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=201403 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (1,'rahulp','123','rahul','s','prajapati','2014-03-05 12:03:00','rahul@gmail.com','123','123123132','M',0,'h1,h2','image/rahulp.jpg',2,1,'B.E',1,'address1','address2','2','3','ket1',2),(2,'jayj','1234','jay','n','jari','2014-03-05 12:03:00','jay.jariwala@gmail.com','007','9992012473','M',0,'h2,h4','image/jayj.jpg',4,1,'B.E',1,'add2','add34','9','1','key22',0),(5,'suraj','suraj','iiiiiii','dfff','ddkkj','1993-10-20 00:00:00','dsfds@fdfs.fdf','10053011033','3338822888','m',1,'ii','suraj.png',1,1,'M.E',1,'sdf','kkjjj','7','2','kjfjfj',0),(201402,'2002029','rajan','resh','Gopalbhai','Shah','1993-10-20 00:00:00','asfsdf@sfds.com','100530116042','8844288442','m',1,'music','rajan.png',1,2,'M.E',0,'sddfdsfssf','surat','3','6','je lakhe te',2);
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moderator`
--

DROP TABLE IF EXISTS `moderator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moderator` (
  `mod_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `m_Id` int unsigned DEFAULT NULL,
  `mod_Id1` int unsigned DEFAULT NULL,
  `mod_Id2` int unsigned DEFAULT NULL,
  PRIMARY KEY (`mod_Id`),
  KEY `FK_moderator_1` (`mod_Id1`),
  KEY `FK_moderator_2` (`mod_Id2`),
  CONSTRAINT `FK_moderator_1` FOREIGN KEY (`mod_Id1`) REFERENCES `moderator` (`mod_Id`),
  CONSTRAINT `FK_moderator_2` FOREIGN KEY (`mod_Id2`) REFERENCES `moderator` (`mod_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moderator`
--

LOCK TABLES `moderator` WRITE;
/*!40000 ALTER TABLE `moderator` DISABLE KEYS */;
INSERT INTO `moderator` VALUES (1,201402,NULL,NULL);
/*!40000 ALTER TABLE `moderator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modrequest`
--

DROP TABLE IF EXISTS `modrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modrequest` (
  `R_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `m_id` int unsigned NOT NULL DEFAULT '0',
  `mod_id1` int unsigned DEFAULT NULL,
  `mod_id2` int unsigned DEFAULT NULL,
  PRIMARY KEY (`R_Id`),
  KEY `FK_modrequest_mid` (`m_id`),
  KEY `FK_modrequest_mod1` (`mod_id1`),
  KEY `FK_modrequest_mod2` (`mod_id2`),
  CONSTRAINT `FK_modrequest_mid` FOREIGN KEY (`m_id`) REFERENCES `members` (`m_Id`),
  CONSTRAINT `FK_modrequest_mod1` FOREIGN KEY (`mod_id1`) REFERENCES `moderator` (`mod_Id`),
  CONSTRAINT `FK_modrequest_mod2` FOREIGN KEY (`mod_id2`) REFERENCES `moderator` (`mod_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modrequest`
--

LOCK TABLES `modrequest` WRITE;
/*!40000 ALTER TABLE `modrequest` DISABLE KEYS */;
INSERT INTO `modrequest` VALUES (1,1,1,NULL);
/*!40000 ALTER TABLE `modrequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `n_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `hide` varchar(50) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`n_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passout_year`
--

DROP TABLE IF EXISTS `passout_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passout_year` (
  `p_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `Passout_yr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`p_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passout_year`
--

LOCK TABLES `passout_year` WRITE;
/*!40000 ALTER TABLE `passout_year` DISABLE KEYS */;
INSERT INTO `passout_year` VALUES (1,'2001'),(2,'2002'),(3,'2003'),(4,'2004'),(5,'2005'),(6,'2006'),(7,'2007'),(8,'2008'),(9,'2009'),(10,'2010'),(11,'2011'),(12,'2012'),(13,'2013'),(14,'2014'),(15,'2015');
/*!40000 ALTER TABLE `passout_year` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permision`
--

DROP TABLE IF EXISTS `permision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permision` (
  `perm_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `perm_Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`perm_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permision`
--

LOCK TABLES `permision` WRITE;
/*!40000 ALTER TABLE `permision` DISABLE KEYS */;
INSERT INTO `permision` VALUES (1,'public'),(2,'batch'),(3,'year'),(4,'branch'),(5,'private');
/*!40000 ALTER TABLE `permision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photos`
--

DROP TABLE IF EXISTS `photos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `photos` (
  `ph_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `a_Id` int unsigned NOT NULL DEFAULT '0',
  `ph_title` varchar(45) NOT NULL DEFAULT '',
  `picture_loc` varchar(45) NOT NULL DEFAULT '',
  `creator_Id` int unsigned NOT NULL DEFAULT '0',
  `catption` varchar(45) NOT NULL DEFAULT '',
  `perm_Id` int unsigned NOT NULL DEFAULT '0',
  `creation_dttime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `taken_dttime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ph_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photos`
--

LOCK TABLES `photos` WRITE;
/*!40000 ALTER TABLE `photos` DISABLE KEYS */;
/*!40000 ALTER TABLE `photos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinned_forum`
--

DROP TABLE IF EXISTS `pinned_forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pinned_forum` (
  `Pinned_Id` int NOT NULL,
  `m_Id` int DEFAULT NULL,
  `f_Id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Pinned_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinned_forum`
--

LOCK TABLES `pinned_forum` WRITE;
/*!40000 ALTER TABLE `pinned_forum` DISABLE KEYS */;
/*!40000 ALTER TABLE `pinned_forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proff_details`
--

DROP TABLE IF EXISTS `proff_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proff_details` (
  `pr_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `m_Id` int unsigned DEFAULT NULL,
  `designation` varchar(50) DEFAULT NULL,
  `fun_Area` varchar(50) DEFAULT NULL,
  `start_month` varchar(45) NOT NULL DEFAULT '',
  `start_year` varchar(45) NOT NULL DEFAULT '',
  `end_month` varchar(45) NOT NULL DEFAULT '',
  `end_year` varchar(45) NOT NULL DEFAULT '',
  `industry_name` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`pr_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proff_details`
--

LOCK TABLES `proff_details` WRITE;
/*!40000 ALTER TABLE `proff_details` DISABLE KEYS */;
INSERT INTO `proff_details` VALUES (1,201402,'perment','Programmer','May','2002','May','2003','Insfosys'),(2,201402,'Temp','Developer','May','2004','April','2006','IDEA');
/*!40000 ALTER TABLE `proff_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratecmt`
--

DROP TABLE IF EXISTS `ratecmt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ratecmt` (
  `cmt_Id` int NOT NULL,
  `m_Id` int DEFAULT NULL,
  PRIMARY KEY (`cmt_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratecmt`
--

LOCK TABLES `ratecmt` WRITE;
/*!40000 ALTER TABLE `ratecmt` DISABLE KEYS */;
/*!40000 ALTER TABLE `ratecmt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rejected_users`
--

DROP TABLE IF EXISTS `rejected_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rejected_users` (
  `rejectedUID` int NOT NULL AUTO_INCREMENT,
  `enr_no` int NOT NULL,
  `f_name` varchar(45) NOT NULL DEFAULT '',
  `l_name` varchar(45) NOT NULL DEFAULT '',
  `gender` char(1) NOT NULL DEFAULT '',
  `dob` datetime DEFAULT NULL,
  `email_Id` varchar(45) NOT NULL DEFAULT '',
  `p_id` int unsigned NOT NULL DEFAULT '0',
  `b_id` int unsigned NOT NULL DEFAULT '0',
  `email_verify` int unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`rejectedUID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rejected_users`
--

LOCK TABLES `rejected_users` WRITE;
/*!40000 ALTER TABLE `rejected_users` DISABLE KEYS */;
INSERT INTO `rejected_users` VALUES (1,123,'Rajan','Patel','M','2014-03-06 00:00:00','rajan@gmail.com',3,3,0),(2,32,'new','one','F','2014-02-26 00:00:00','new@nsw.sdf',2,2,0);
/*!40000 ALTER TABLE `rejected_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repoted_users`
--

DROP TABLE IF EXISTS `repoted_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repoted_users` (
  `rept_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `Repoted_UId` int unsigned DEFAULT NULL,
  `Repoter_UId` int unsigned DEFAULT NULL,
  `issu_msg` varchar(500) DEFAULT NULL,
  `wrng_msg` varchar(500) DEFAULT NULL,
  `ban` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`rept_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repoted_users`
--

LOCK TABLES `repoted_users` WRITE;
/*!40000 ALTER TABLE `repoted_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `repoted_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requested_users`
--

DROP TABLE IF EXISTS `requested_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requested_users` (
  `R_Id` int unsigned NOT NULL AUTO_INCREMENT,
  `f_name` varchar(50) DEFAULT NULL,
  `l_name` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email_Id` varchar(50) DEFAULT NULL,
  `p_Id` int unsigned DEFAULT NULL,
  `b_Id` int unsigned DEFAULT NULL,
  `enr_No` varchar(50) DEFAULT NULL,
  `accept` varchar(50) DEFAULT NULL,
  `reject` varchar(50) DEFAULT NULL,
  `mod_Id1` int unsigned DEFAULT NULL,
  `mod_Id2` int unsigned DEFAULT NULL,
  PRIMARY KEY (`R_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requested_users`
--

LOCK TABLES `requested_users` WRITE;
/*!40000 ALTER TABLE `requested_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `requested_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tempuserdata`
--

DROP TABLE IF EXISTS `tempuserdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tempuserdata` (
  `tempUID` int NOT NULL AUTO_INCREMENT,
  `enr_no` varchar(45) NOT NULL DEFAULT '',
  `f_name` varchar(45) NOT NULL DEFAULT '',
  `l_name` varchar(45) NOT NULL DEFAULT '',
  `gender` char(1) NOT NULL DEFAULT '',
  `dob` datetime DEFAULT NULL,
  `email_Id` varchar(45) NOT NULL DEFAULT '',
  `p_id` int unsigned NOT NULL DEFAULT '0',
  `b_id` int unsigned NOT NULL DEFAULT '0',
  `email_verify` int unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`tempUID`),
  KEY `FK_tempuserdata_1` (`p_id`),
  KEY `FK_tempuserdata_2` (`b_id`),
  CONSTRAINT `FK_tempuserdata_1` FOREIGN KEY (`p_id`) REFERENCES `passout_year` (`p_Id`),
  CONSTRAINT `FK_tempuserdata_2` FOREIGN KEY (`b_id`) REFERENCES `branch` (`b_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; (`b_id`) REFER `aumninw/branch`(`b_Id`';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tempuserdata`
--

LOCK TABLES `tempuserdata` WRITE;
/*!40000 ALTER TABLE `tempuserdata` DISABLE KEYS */;
INSERT INTO `tempuserdata` VALUES (14,'344','suraj','davariya','M','2014-03-21 00:00:00','suarj@gmail.com',2,5,0),(15,'88','sdgodsg','kfgflk','M','2014-03-06 12:03:00','jvsvs@#v.fsdkm',3,3,0),(17,'jvfkj','ooo','fkjj','M','2014-02-27 12:02:00','kjjmbjh@hhj.gh',4,4,0),(18,'h33','gjsdgsfjo','fdjifd','M','2014-03-05 12:03:00','oivsdj@fdlj.dkfd',4,3,0);
/*!40000 ALTER TABLE `tempuserdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-22  0:31:38
