CREATE DATABASE  IF NOT EXISTS `hastane` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `hastane`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hastane
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_giris` varchar(45) DEFAULT NULL,
  `admin_sifre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','1'),(2,'test','12345'),(3,'deneme','12345');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doktorlar`
--

DROP TABLE IF EXISTS `doktorlar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `doktorlar` (
  `dr_id` int(11) NOT NULL,
  `dr_ad` varchar(45) DEFAULT NULL,
  `dr_soyad` varchar(45) DEFAULT NULL,
  `dr_dogum` varchar(45) DEFAULT NULL,
  `dr_tc` varchar(45) DEFAULT NULL,
  `dr_alan` varchar(45) DEFAULT NULL,
  `dr_il` varchar(45) DEFAULT NULL,
  `dr_ilce` varchar(45) DEFAULT NULL,
  `dr_tel` int(11) DEFAULT NULL,
  `dr_cins` varchar(45) DEFAULT NULL,
  `dr_sifre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dr_id`),
  UNIQUE KEY `dr_tc_UNIQUE` (`dr_tc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doktorlar`
--

LOCK TABLES `doktorlar` WRITE;
/*!40000 ALTER TABLE `doktorlar` DISABLE KEYS */;
INSERT INTO `doktorlar` VALUES (1,'Cemil','Demir','11-08-1978','3','KBB','Konya','Meram',553453453,'Erkek','1'),(2,'Cafer','Aksu','12-02-1984','4','Genel Cerrahi','Bursa','Yıldırım',123123123,'Erkek','1'),(4,'Rıfkı','Yüce','05-03-1972','2','Ortopedi','İstanbul','Şişli',123123123,'Erkek','1'),(5,'Muzaffer','Güneş','06-08-1976','5','Nöroloji',NULL,NULL,NULL,'Erkek','1'),(6,'Kamil','Yurtseven','17-05-2019','1',NULL,'','',357,'Erkek','1');
/*!40000 ALTER TABLE `doktorlar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hastalar`
--

DROP TABLE IF EXISTS `hastalar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hastalar` (
  `hasta_id` int(11) NOT NULL AUTO_INCREMENT,
  `hasta_tc` varchar(45) DEFAULT NULL,
  `hasta_ad` varchar(45) DEFAULT NULL,
  `hasta_soyad` varchar(45) DEFAULT NULL,
  `hasta_dogum` varchar(45) DEFAULT NULL,
  `hasta_dyeri` varchar(45) DEFAULT NULL,
  `hasta_adres` varchar(200) DEFAULT NULL,
  `hasta_il` varchar(45) DEFAULT NULL,
  `hasta_ilce` varchar(45) DEFAULT NULL,
  `hasta_cins` varchar(45) DEFAULT NULL,
  `hasta_tel` varchar(45) DEFAULT NULL,
  `hasta_anne` varchar(45) DEFAULT NULL,
  `hasta_baba` varchar(45) DEFAULT NULL,
  `hasta_sgk` varchar(45) DEFAULT NULL,
  `hasta_mail` varchar(75) DEFAULT NULL,
  `hasta_sifre` varchar(45) DEFAULT NULL,
  `hasta_oda` varchar(45) DEFAULT NULL,
  `hasta_yatak` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`hasta_id`),
  UNIQUE KEY `hasta_tc_UNIQUE` (`hasta_tc`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hastalar`
--

LOCK TABLES `hastalar` WRITE;
/*!40000 ALTER TABLE `hastalar` DISABLE KEYS */;
INSERT INTO `hastalar` VALUES (2,'4','Remzi','Özyurt','04-07-1997','Niğde','k.çekmece/istanbul','İstanbul','K.çekmece','Erkek','(05  )-   -  -  ','Hatun','Bağkur','Bağkur','sancakbeyi370@gmail.com','1','23','42'),(14,'2','Mahir','Gündüz','02-05-1997','Kayseri','k.çekmece','İstanbul','Küçükçekmece','Erkek','(0533)-443-43-43','Beyza','Nevzat','SSK','testmail@gmail.com','1',NULL,NULL),(15,'3','Remziiii','Bağlar','01-04-1992','Bursa','Bursa/Yıldırım','Bursa','Nilüfer','Erkek','','Gamze','SSK','SSK','deneme@gmail.com','1',NULL,NULL),(17,'1','Hüseyin','Şimşek','05-04-1978','İstanbul','Yaka mahallesi şehit muharrem öksüz sokak\nno:4 daire 4','Konya','Meram','Erkek','(0543)-434-34-34','Rıfkı','SSK','SSK','remziyldrm@hotmail.com','1','36','2');
/*!40000 ALTER TABLE `hastalar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `klinikler`
--

DROP TABLE IF EXISTS `klinikler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `klinikler` (
  `klinik_id` int(11) NOT NULL AUTO_INCREMENT,
  `dr_id` int(11) DEFAULT NULL,
  `hasta_id` int(11) DEFAULT NULL,
  `klinik_ismi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`klinik_id`),
  UNIQUE KEY `klinik_ad_UNIQUE` (`klinik_ismi`),
  KEY `asdv` (`dr_id`),
  KEY `chs` (`hasta_id`),
  CONSTRAINT `asdv` FOREIGN KEY (`dr_id`) REFERENCES `doktorlar` (`dr_id`),
  CONSTRAINT `chs` FOREIGN KEY (`hasta_id`) REFERENCES `hastalar` (`hasta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klinikler`
--

LOCK TABLES `klinikler` WRITE;
/*!40000 ALTER TABLE `klinikler` DISABLE KEYS */;
INSERT INTO `klinikler` VALUES (7,NULL,NULL,'Cildiye'),(8,NULL,NULL,'Kulak Burun Boğaz'),(9,NULL,NULL,'Onkoloji'),(10,NULL,NULL,'Beyin ve Sinir Cerrahisi'),(39,NULL,NULL,'Diş Hekimliği'),(40,NULL,NULL,'Genel Cerrahi'),(41,NULL,NULL,'Göz Hastalıkları'),(42,NULL,NULL,'İç Hastalıklar'),(43,NULL,NULL,'Ortopedi'),(44,5,NULL,'Nöroloji');
/*!40000 ALTER TABLE `klinikler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab`
--

DROP TABLE IF EXISTS `lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lab` (
  `lab_id` int(11) NOT NULL AUTO_INCREMENT,
  `lab_sonuc` varchar(300) DEFAULT NULL,
  `hasta_id` int(11) DEFAULT NULL,
  `dr_id` int(11) DEFAULT NULL,
  `sonuc_tarihi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`lab_id`),
  KEY `dfb` (`hasta_id`),
  KEY `dyb` (`dr_id`),
  CONSTRAINT `dfb` FOREIGN KEY (`hasta_id`) REFERENCES `hastalar` (`hasta_id`),
  CONSTRAINT `dyb` FOREIGN KEY (`dr_id`) REFERENCES `doktorlar` (`dr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab`
--

LOCK TABLES `lab` WRITE;
/*!40000 ALTER TABLE `lab` DISABLE KEYS */;
INSERT INTO `lab` VALUES (4,'negatif',15,6,'22-05-2019'),(5,'cvdfgsdgsdfs',15,4,'17-05-2019'),(6,'Beyinde iyi huylu kist',14,4,'28-05-2019'),(7,'Parmakta çatlak',14,2,'17-05-2019'),(8,'deneme lab sonuç',2,1,'31-08-2019');
/*!40000 ALTER TABLE `lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `randevular`
--

DROP TABLE IF EXISTS `randevular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `randevular` (
  `randevu_id` int(11) NOT NULL AUTO_INCREMENT,
  `randevu_tarihi` varchar(45) DEFAULT NULL,
  `randevu_saati` varchar(45) DEFAULT NULL,
  `dr_id` int(11) DEFAULT NULL,
  `hasta_id` int(11) DEFAULT NULL,
  `klinik_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`randevu_id`),
  KEY `sdv` (`hasta_id`),
  KEY `sdsac` (`dr_id`),
  CONSTRAINT `sdsac` FOREIGN KEY (`dr_id`) REFERENCES `doktorlar` (`dr_id`),
  CONSTRAINT `sdv` FOREIGN KEY (`hasta_id`) REFERENCES `hastalar` (`hasta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `randevular`
--

LOCK TABLES `randevular` WRITE;
/*!40000 ALTER TABLE `randevular` DISABLE KEYS */;
INSERT INTO `randevular` VALUES (30,'15-05-2019','10.45',4,2,9),(31,'15-05-2019','10.15',4,2,7),(32,'23-05-2019','09.45',1,2,10),(37,'04-05-2019','09.45',4,17,8),(38,'13-05-2019','11.15',5,17,10),(39,'21-05-2019','14.00',1,17,41),(40,'17-05-2019','10.45',4,14,39),(41,'06-05-2019','10.30',5,14,10),(42,'13-05-2019','10.15',6,14,40),(43,'10-05-2019','12.00',2,2,39),(44,'23-05-2019','10.30',2,2,42),(45,'18-05-2019','14.45',2,2,43),(46,'14-05-2019','13.00',4,15,8),(47,'10-05-2019','10.30',4,17,9),(48,'19-05-2019','10.15',6,15,40),(49,'09-05-2019','09.15',4,2,8),(50,'09-05-2019','10.30',4,14,8),(51,'23-08-2019','10.45',4,15,9),(52,'23-08-2019','12.00',4,2,9),(53,'13-08-2019','09.45',1,2,39),(54,'05-09-2019','10.45',4,17,7);
/*!40000 ALTER TABLE `randevular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recete`
--

DROP TABLE IF EXISTS `recete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recete` (
  `recete_id` int(11) NOT NULL AUTO_INCREMENT,
  `dr_id` int(11) DEFAULT NULL,
  `hasta_id` int(11) DEFAULT NULL,
  `dr_aciklama` varchar(200) DEFAULT NULL,
  `recete_tarihi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`recete_id`),
  KEY `sct` (`dr_id`),
  KEY `ykz` (`hasta_id`),
  CONSTRAINT `sct` FOREIGN KEY (`dr_id`) REFERENCES `doktorlar` (`dr_id`),
  CONSTRAINT `ykz` FOREIGN KEY (`hasta_id`) REFERENCES `hastalar` (`hasta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recete`
--

LOCK TABLES `recete` WRITE;
/*!40000 ALTER TABLE `recete` DISABLE KEYS */;
INSERT INTO `recete` VALUES (13,6,2,'test ilaç, antibiyotik, ağrı kesici','28-05-2019'),(14,6,15,'antibiyotik, ağrı kesici, ...sdas.... asd.as','28-05-2019'),(15,4,15,'sdasdasda','24-05-2019'),(16,1,15,'deneme reçete','19-08-2019');
/*!40000 ALTER TABLE `recete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hastane'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-22 11:38:06
