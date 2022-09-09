CREATE DATABASE  IF NOT EXISTS `schemahotel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `schemahotel`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: schemahotel
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addetto`
--

DROP TABLE IF EXISTS `addetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addetto` (
  `codRuolo` varchar(30) NOT NULL,
  `codFiscale` varchar(16) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `dataNascita` date NOT NULL,
  `numeroTelefonico` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codRuolo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addetto`
--

LOCK TABLES `addetto` WRITE;
/*!40000 ALTER TABLE `addetto` DISABLE KEYS */;
INSERT INTO `addetto` VALUES ('10','ntdmtg84t66e917r','Augusta','Hodkiewicz','2003-11-28','+00 0819406876');
/*!40000 ALTER TABLE `addetto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `codFiscale` varchar(16) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `dataNascita` date NOT NULL,
  `numeroTelefonico` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('aghjwe03p61i024z','Evert','Reinger','1992-07-07','+587866749412'),('alofwe29x13y393m','Emerson','Halvorson','1979-01-17','+387846953906'),('gppvrd00d01e654r','Geppetto','Verdi','2000-09-01',''),('aylmgr76w23f293p','Kamren','Schroeder','1972-11-07','+219230861547'),('bbzrzq27v66f409u','Erna','Steuber','1994-01-10','+942805437201'),('blbrjd16m87t113x','Gabriel','Turcotte','1978-04-24','+279447931378'),('blhcux55j55j670c','Sim','Wilkinson','1998-09-25','+990837787130'),('BNFK823hjf','Gatto','Giallo','1888-01-02',''),('bxsfll45i86z268s','Georgette','Daugherty','2011-10-15','+179028281279'),('cevoob52q33x816b','Valentina','Gleason','1977-05-01','+988028977675'),('cjhcfe70b25l637k','Etha','Wilkinson','2008-02-03','+594243568125'),('cktwoy83v66a120h','Cesar','Hermiston','2005-06-11','+605621355907'),('cxknci45h54l136v','Kenya','Runolfsdottir','1993-12-08','+305540182752'),('czqbhp50r57r612m','Lawson','Kshlerin','2011-09-10','+693043313842'),('dmlwdv29k43r274a','Mia','Schuster','2005-09-20','+180673253040'),('dqhspx65z39r183s','Ebony','Cummings','1987-09-13','+602014640777'),('drdclc13f87h126z','Eve','McClure','1976-10-14','+177490619576'),('dvcpvg49f14i485g','Ambrose','Windler','1971-02-08','+457586669369'),('dystzk55a51q178j','Efren','Spencer','2000-08-30','+694731188661'),('dytkpz48f58a047o','Lily','Wiza','1985-07-10','+904348517680'),('eevtvs34b82p132j','Dessie','Ryan','2006-01-23','+433374627423'),('egxlqz27g52k373q','Sam','McGlynn','1983-02-01','+557996005367'),('elzcna68w16r786i','Oren','Daugherty','2006-05-10','+849723989442'),('emtixh15w95a970x','Bryce','Hoppe','1995-08-30','+952767435345'),('flmxtw26h52d292f','Rosalinda','White','2002-09-26','+731506707830'),('fvzzga53z23u653n','Lawrence','Boyle','2008-10-08','+737379779624'),('fxkfoz99m85w465g','Cornell','VonRueden','2011-03-12','+267699715119'),('gkbqxm42e95c298u','Minnie','Osinski','1985-06-08','+800353390305'),('grrnni78w99b241a','Jordon','Purdy','2020-07-08','+415087635864'),('gudeao14i92m907v','Adan','Morissette','2010-04-26','+785521029190'),('gyweox44i27l442m','Jeromy','Bergnaum','1984-08-20','+337501559219'),('hmnica27d87p353u','Jaeden','Kirlin','2000-10-10','+604261025528'),('hvbawo31o28v456e','Enrique','Romaguera','2006-04-23','+441649304755'),('iaybzl48h40v696d','Elnora','Macejkovic','1998-02-07','+245037147928'),('iflzpq39j31n394q','Adaline','Hammes','1995-09-21','+522581760929'),('iksgcw26r65i643l','Luis','Ullrich','1977-09-04','+869096556532'),('iwqkkw02p09l644z','Kirk','Moen','1990-01-02','+700714066714'),('jecvhx03s40l216s','Adelia','Christiansen','1987-08-14','+416525196920'),('jfgtlo29f11k478s','Colby','Borer','1988-06-14','+362777443584'),('jfnqzj39h54v872e','Amina','Schultz','2012-08-05','+891386068352'),('jfwwbm02d04z880j','Sylvester','Larson','1976-01-04','+129682684400'),('jmcstr41a26b286c','Jordon','Morar','1974-11-07','+468249891397'),('juwqwq73d57s417t','Loma','Schaden','2013-08-26','+690657694344'),('kbknfo98l09m797n','Wilfrid','Kihn','2016-08-10','+704987827372'),('kdbrxr24p20x988x','Colin','Kunde','1990-10-06','+299680118266'),('kwzlto75p80k530s','Gilda','Schmitt','2004-04-10','+368949131450'),('logxkf20g42z074o','Veronica','Rosenbaum','1986-12-03','+115487725775'),('lvzlsa86n79k590o','Ned','Hackett','1987-02-10','+213602010370'),('mhbuwl30t60g225j','Markus','Doyle','1995-02-26','+583653608763'),('njwrak16m57m420n','Cierra','Cole','2013-01-06','+070998887594'),('nkyhkg04j87a221h','Derek','Thiel','2022-04-22','+803089183474'),('nptjfm37m33b452y','Rico','Rodriguez','2006-03-24','+969102599019'),('nxncuu32o22q056a','Lillie','Monahan','1999-09-14','+707426166739'),('obmhvu51z32n500a','Leon','Smitham','1982-12-05','+103351404265'),('obznpr10a32w952u','Pete','Mraz','2022-05-26','+806914731824'),('ohxdvl24t38w166d','Guadalupe','Hessel','1979-09-10','+219280059659'),('ouxgsv22s26h895m','Rigoberto','McKenzie','1973-01-03','+537047948097'),('owepai91x74q170c','Leonora','Walker','1991-09-12','+378626444511'),('pdqbaz64x78a438e','Rogers','Torp','1994-04-15','+699269978082'),('phlvaj64r57e491p','William','Daugherty','2019-04-28','+329955242356'),('pjcaqs45l04g371a','Robb','Beahan','1976-05-06','+498462064820'),('pnvffr90v08j151b','Olen','Konopelski','1972-11-09','+641031095290'),('ptrhyu58r47k271f','Kenny','Willms','2020-06-23','+266935802611'),('qknmna65s25q555j','Gia','Boyer','2000-11-16','+923639191414'),('qkoooy44i68l415e','Miracle','Doyle','1985-07-10','+600301570222'),('qkseax58v71g823u','Dakota','Bayer','1975-07-09','+057325564697'),('qminsg80f67i990v','Fermin','Brown','2020-03-08','+204960009116'),('qmkntx60v07z123w','Eliza','Wehner','2014-09-30','+525636142266'),('qpccsu81x56t466a','Ivory','Funk','1985-04-27','+171592807459'),('rknmdz40r36n257i','Destinee','Lueilwitz','1993-09-30','+535818083011'),('rmopgm07g43v941g','Garnett','Morissette','2012-12-01','+808103825381'),('rxqdnv38i67x888a','Koby','Mayer','1981-09-15','+099967372977'),('savxyr00x95h847m','Ashleigh','Walter','1996-06-04','+137427316751'),('sbupog32l65f028n','London','Gislason','2021-12-28','+007108468888'),('tcutwm72t38b742j','Kris','Hettinger','1994-07-11','+260215066643'),('thgkrm91o86g587q','Janessa','Purdy','2015-07-21','+579303676915'),('ucrhhv52p15d728l','Rosemarie','Schroeder','1982-04-13','+658585768740'),('ueiifj92b58o524c','Heather','Kihn','2002-11-09','+238517756668'),('umialo57f96r805i','Marcus','O\'Connell','2005-02-27','+057039407972'),('uwddfz89g60w152l','Kody','Windler','2016-01-29','+749771281669'),('vmurvw72l21i133z','Emmanuelle','Gutkowski','2006-01-15','+891763872833'),('vzcdio85r14d454g','Marie','Marquardt','1994-04-30','+097448702622'),('waidil48b45u898w','Sylvan','Quitzon','1998-03-02','+803597385545'),('wcqkht67z81h362a','Davon','Prohaska','1995-04-11','+469869765501'),('wefzed64o55s392g','Rozella','Purdy','1984-03-04','+145715605474'),('wlurgn18s25z563g','Ole','Predovic','2017-10-12','+897261032553'),('wmgufo61f06n470c','Aditya','Bogisich','1970-05-18','+122373647029'),('wugzne29t66p409w','Justus','Larkin','2022-05-01','+664689381899'),('ximrbv13l04i886x','Jackeline','O\'Kon','1971-12-26','+902658685381'),('ybofkw17c37j802o','Darby','Powlowski','1976-10-11','+537525222770'),('ygogkn19r01c921f','Yasmine','Blanda','1973-12-10','+296904947173'),('yumydi84l00t059k','Evie','Wunsch','1993-08-22','+641545314754'),('yzfmmc73p40q141o','Cleora','Raynor','2009-07-05','+298579121290'),('yzjnes53j56r141v','Janis','Buckridge','2008-10-11','+147804853572'),('zedcmt66k92w530f','Lew','Borer','1979-02-11','+377760682624'),('zkibtg84x98g489z','Annabell','Pouros','1975-12-08','+517687062812'),('zklctk71l96x978d','Hadley','Rodriguez','2000-10-26','+441888677426'),('zsddmq19d50l295i','Clarissa','Rodriguez','1999-01-22','+214221185257'),('zudtyj45n03z110l','Pamela','Carroll','2016-06-02','+879772917612'),('zuufvt81r63d327t','Nathaniel','Block','1987-03-31','+966003433250'),('zwagfv48a49y999t','Melvin','Adams','2002-11-07','+740176389277'),('zxgbhr53x76v368i','Amira','Donnelly','1972-09-09','+815095823519');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `condizionamento`
--

DROP TABLE IF EXISTS `condizionamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `condizionamento` (
  `codDirigenteOperante` tinyint unsigned NOT NULL,
  `tipologiaSoggiornoCondizionato` varchar(30) NOT NULL,
  `meseSoggiornoCondizionato` varchar(15) NOT NULL,
  `annoSoggiornoCondizionato` year NOT NULL,
  PRIMARY KEY (`codDirigenteOperante`,`tipologiaSoggiornoCondizionato`,`meseSoggiornoCondizionato`,`annoSoggiornoCondizionato`),
  KEY `FKCON_TIP` (`tipologiaSoggiornoCondizionato`,`meseSoggiornoCondizionato`,`annoSoggiornoCondizionato`),
  CONSTRAINT `FKCON_DIR_FK` FOREIGN KEY (`codDirigenteOperante`) REFERENCES `dirigente` (`codDirigente`),
  CONSTRAINT `FKCON_TIP` FOREIGN KEY (`tipologiaSoggiornoCondizionato`, `meseSoggiornoCondizionato`, `annoSoggiornoCondizionato`) REFERENCES `tipologiasoggiorno` (`tipologia`, `mese`, `anno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `condizionamento`
--

LOCK TABLES `condizionamento` WRITE;
/*!40000 ALTER TABLE `condizionamento` DISABLE KEYS */;
INSERT INTO `condizionamento` VALUES (1,'ALI','Agosto',2022),(1,'ALI','Agosto',2023),(1,'ALI','Aprile',2022),(1,'ALI','Aprile',2023),(1,'ALI','Dicembre',2022),(1,'ALI','Dicembre',2023),(1,'ALI','Febbraio',2022),(1,'ALI','Febbraio',2023),(1,'ALI','Gennaio',2022),(1,'ALI','Gennaio',2023),(1,'ALI','Giugno',2022),(1,'ALI','Giugno',2023),(1,'ALI','Luglio',2022),(1,'ALI','Luglio',2023),(1,'ALI','Maggio',2022),(1,'ALI','Maggio',2023),(1,'ALI','Marzo',2022),(1,'ALI','Marzo',2023),(1,'ALI','Novembre',2022),(1,'ALI','Novembre',2023),(1,'ALI','Ottobre',2022),(1,'ALI','Ottobre',2023),(1,'ALI','Settembre',2022),(1,'ALI','Settembre',2023),(1,'BB','Agosto',2022),(1,'BB','Agosto',2023),(1,'BB','Aprile',2022),(1,'BB','Aprile',2023),(1,'BB','Dicembre',2022),(1,'BB','Dicembre',2023),(1,'BB','Febbraio',2022),(1,'BB','Febbraio',2023),(1,'BB','Gennaio',2022),(1,'BB','Gennaio',2023),(1,'BB','Giugno',2022),(1,'BB','Giugno',2023),(1,'BB','Luglio',2022),(1,'BB','Luglio',2023),(1,'BB','Maggio',2022),(1,'BB','Maggio',2023),(1,'BB','Marzo',2022),(1,'BB','Marzo',2023),(1,'BB','Novembre',2022),(1,'BB','Novembre',2023),(1,'BB','Ottobre',2022),(1,'BB','Ottobre',2023),(1,'BB','Settembre',2022),(1,'BB','Settembre',2023),(1,'PB','Agosto',2022),(1,'PB','Agosto',2023),(1,'PB','Aprile',2022),(1,'PB','Aprile',2023),(1,'PB','Dicembre',2022),(1,'PB','Dicembre',2023),(1,'PB','Febbraio',2022),(1,'PB','Febbraio',2023),(1,'PB','Gennaio',2022),(1,'PB','Gennaio',2023),(1,'PB','Giugno',2022),(1,'PB','Giugno',2023),(1,'PB','Luglio',2022),(1,'PB','Luglio',2023),(1,'PB','Maggio',2022),(1,'PB','Maggio',2023),(1,'PB','Marzo',2022),(1,'PB','Marzo',2023),(1,'PB','Novembre',2022),(1,'PB','Novembre',2023),(1,'PB','Ottobre',2022),(1,'PB','Ottobre',2023),(1,'PB','Settembre',2022),(1,'PB','Settembre',2023);
/*!40000 ALTER TABLE `condizionamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordinazione`
--

DROP TABLE IF EXISTS `coordinazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coordinazione` (
  `codDirigenteCoordinante` tinyint unsigned NOT NULL,
  `tipoServizioCoordinato` varchar(30) NOT NULL,
  `stagioneServizioCoordinato` varchar(15) NOT NULL,
  `annoServizioCoordinato` year NOT NULL,
  PRIMARY KEY (`codDirigenteCoordinante`,`tipoServizioCoordinato`,`stagioneServizioCoordinato`,`annoServizioCoordinato`),
  KEY `FKCOO_SER` (`tipoServizioCoordinato`,`stagioneServizioCoordinato`,`annoServizioCoordinato`),
  CONSTRAINT `FKCOO_DIR_FK` FOREIGN KEY (`codDirigenteCoordinante`) REFERENCES `dirigente` (`codDirigente`),
  CONSTRAINT `FKCOO_SER` FOREIGN KEY (`tipoServizioCoordinato`, `stagioneServizioCoordinato`, `annoServizioCoordinato`) REFERENCES `servizio` (`tipoServizio`, `stagione`, `anno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordinazione`
--

LOCK TABLES `coordinazione` WRITE;
/*!40000 ALTER TABLE `coordinazione` DISABLE KEYS */;
INSERT INTO `coordinazione` VALUES (1,'Bagno','Autunno',2022),(1,'Bagno','Autunno',2023),(1,'Bagno','Estate',2022),(1,'Bagno','Estate',2023),(1,'Bagno','Inverno',2022),(1,'Bagno','Inverno',2023),(1,'Bagno','Primavera',2022),(1,'Bagno','Primavera',2023),(1,'Casino','Autunno',2022),(1,'Casino','Autunno',2023),(1,'Casino','Estate',2022),(1,'Casino','Estate',2023),(1,'Casino','Inverno',2022),(1,'Casino','Inverno',2023),(1,'Casino','Primavera',2022),(1,'Casino','Primavera',2023),(1,'Fango','Autunno',2022),(1,'Fango','Autunno',2023),(1,'Fango','Estate',2022),(1,'Fango','Estate',2023),(1,'Fango','Inverno',2022),(1,'Fango','Inverno',2023),(1,'Fango','Primavera',2022),(1,'Fango','Primavera',2023),(1,'Idromassaggio','Autunno',2022),(1,'Idromassaggio','Autunno',2023),(1,'Idromassaggio','Estate',2022),(1,'Idromassaggio','Estate',2023),(1,'Idromassaggio','Inverno',2022),(1,'Idromassaggio','Inverno',2023),(1,'Idromassaggio','Primavera',2022),(1,'Idromassaggio','Primavera',2023),(1,'Massaggio','Autunno',2022),(1,'Massaggio','Autunno',2023),(1,'Massaggio','Estate',2022),(1,'Massaggio','Estate',2023),(1,'Massaggio','Inverno',2022),(1,'Massaggio','Inverno',2023),(1,'Massaggio','Primavera',2022),(1,'Massaggio','Primavera',2023),(1,'Palestra','Autunno',2022),(1,'Palestra','Autunno',2023),(1,'Palestra','Estate',2022),(1,'Palestra','Estate',2023),(1,'Palestra','Inverno',2022),(1,'Palestra','Inverno',2023),(1,'Palestra','Primavera',2022),(1,'Palestra','Primavera',2023),(1,'Parcheggio','Autunno',2022),(1,'Parcheggio','Autunno',2023),(1,'Parcheggio','Estate',2022),(1,'Parcheggio','Estate',2023),(1,'Parcheggio','Inverno',2022),(1,'Parcheggio','Inverno',2023),(1,'Parcheggio','Primavera',2022),(1,'Parcheggio','Primavera',2023),(1,'Spiaggia','Autunno',2022),(1,'Spiaggia','Autunno',2023),(1,'Spiaggia','Estate',2022),(1,'Spiaggia','Estate',2023),(1,'Spiaggia','Inverno',2022),(1,'Spiaggia','Inverno',2023),(1,'Spiaggia','Primavera',2022),(1,'Spiaggia','Primavera',2023);
/*!40000 ALTER TABLE `coordinazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dirigente`
--

DROP TABLE IF EXISTS `dirigente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dirigente` (
  `codDirigente` tinyint unsigned NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `dataNascita` date NOT NULL,
  `numeroTelefonico` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codDirigente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dirigente`
--

LOCK TABLES `dirigente` WRITE;
/*!40000 ALTER TABLE `dirigente` DISABLE KEYS */;
INSERT INTO `dirigente` VALUES (1,'Mario','Vandervort','1972-09-21','+69 0654191146');
/*!40000 ALTER TABLE `dirigente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `erogazione`
--

DROP TABLE IF EXISTS `erogazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `erogazione` (
  `tipoServizioErogato` varchar(30) NOT NULL,
  `stagioneServizioErogato` varchar(15) NOT NULL,
  `annoServizioErogato` year NOT NULL,
  `ruoloAddettoErogante` varchar(30) NOT NULL,
  PRIMARY KEY (`tipoServizioErogato`,`stagioneServizioErogato`,`annoServizioErogato`,`ruoloAddettoErogante`),
  KEY `FKERO_ADD` (`ruoloAddettoErogante`),
  CONSTRAINT `FKERO_ADD` FOREIGN KEY (`ruoloAddettoErogante`) REFERENCES `addetto` (`codRuolo`),
  CONSTRAINT `FKERO_SER` FOREIGN KEY (`tipoServizioErogato`, `stagioneServizioErogato`, `annoServizioErogato`) REFERENCES `servizio` (`tipoServizio`, `stagione`, `anno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `erogazione`
--

LOCK TABLES `erogazione` WRITE;
/*!40000 ALTER TABLE `erogazione` DISABLE KEYS */;
INSERT INTO `erogazione` VALUES ('Bagno','Autunno',2022,'10'),('Bagno','Autunno',2023,'10'),('Bagno','Estate',2022,'10'),('Bagno','Estate',2023,'10'),('Bagno','Inverno',2022,'10'),('Bagno','Inverno',2023,'10'),('Bagno','Primavera',2022,'10'),('Bagno','Primavera',2023,'10'),('Casino','Autunno',2022,'10'),('Casino','Autunno',2023,'10'),('Casino','Estate',2022,'10'),('Casino','Estate',2023,'10'),('Casino','Inverno',2022,'10'),('Casino','Inverno',2023,'10'),('Casino','Primavera',2022,'10'),('Casino','Primavera',2023,'10'),('Fango','Autunno',2022,'10'),('Fango','Autunno',2023,'10'),('Fango','Estate',2022,'10'),('Fango','Estate',2023,'10'),('Fango','Inverno',2022,'10'),('Fango','Inverno',2023,'10'),('Fango','Primavera',2022,'10'),('Fango','Primavera',2023,'10'),('Idromassaggio','Autunno',2022,'10'),('Idromassaggio','Autunno',2023,'10'),('Idromassaggio','Estate',2022,'10'),('Idromassaggio','Estate',2023,'10'),('Idromassaggio','Inverno',2022,'10'),('Idromassaggio','Inverno',2023,'10'),('Idromassaggio','Primavera',2022,'10'),('Idromassaggio','Primavera',2023,'10'),('Massaggio','Autunno',2022,'10'),('Massaggio','Autunno',2023,'10'),('Massaggio','Estate',2022,'10'),('Massaggio','Estate',2023,'10'),('Massaggio','Inverno',2022,'10'),('Massaggio','Inverno',2023,'10'),('Massaggio','Primavera',2022,'10'),('Massaggio','Primavera',2023,'10'),('Palestra','Autunno',2022,'10'),('Palestra','Autunno',2023,'10'),('Palestra','Estate',2022,'10'),('Palestra','Estate',2023,'10'),('Palestra','Inverno',2022,'10'),('Palestra','Inverno',2023,'10'),('Palestra','Primavera',2022,'10'),('Palestra','Primavera',2023,'10'),('Parcheggio','Autunno',2022,'10'),('Parcheggio','Autunno',2023,'10'),('Parcheggio','Estate',2022,'10'),('Parcheggio','Estate',2023,'10'),('Parcheggio','Inverno',2022,'10'),('Parcheggio','Inverno',2023,'10'),('Parcheggio','Primavera',2022,'10'),('Parcheggio','Primavera',2023,'10'),('Spiaggia','Autunno',2022,'10'),('Spiaggia','Autunno',2023,'10'),('Spiaggia','Estate',2022,'10'),('Spiaggia','Estate',2023,'10'),('Spiaggia','Inverno',2022,'10'),('Spiaggia','Inverno',2023,'10'),('Spiaggia','Primavera',2022,'10'),('Spiaggia','Primavera',2023,'10');
/*!40000 ALTER TABLE `erogazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazione` (
  `tipoPrenotazione` varchar(30) NOT NULL,
  `giorno` varchar(10) DEFAULT NULL,
  `ora` time DEFAULT NULL,
  `dataInizioSoggiornoRegistrato` date NOT NULL,
  `codFiscaleClienteRegistrato` varchar(16) NOT NULL,
  `codReceptionistOperante` tinyint unsigned NOT NULL,
  `tipoServizioUsufruito` varchar(30) NOT NULL,
  `stagioneServizioUsufruito` varchar(15) NOT NULL,
  `annoServizioUsufruito` year NOT NULL,
  UNIQUE KEY `IDPRENOTAZIONE` (`tipoPrenotazione`,`giorno`,`ora`,`dataInizioSoggiornoRegistrato`,`codFiscaleClienteRegistrato`),
  KEY `FKEFFETTUAZIONE` (`codReceptionistOperante`),
  KEY `FKREGISTRAZIONE` (`dataInizioSoggiornoRegistrato`,`codFiscaleClienteRegistrato`),
  KEY `FKACCESSO` (`tipoServizioUsufruito`,`stagioneServizioUsufruito`,`annoServizioUsufruito`),
  CONSTRAINT `FKACCESSO` FOREIGN KEY (`tipoServizioUsufruito`, `stagioneServizioUsufruito`, `annoServizioUsufruito`) REFERENCES `servizio` (`tipoServizio`, `stagione`, `anno`),
  CONSTRAINT `FKEFFETTUAZIONE` FOREIGN KEY (`codReceptionistOperante`) REFERENCES `receptionist` (`codReceptionist`),
  CONSTRAINT `FKREGISTRAZIONE` FOREIGN KEY (`dataInizioSoggiornoRegistrato`, `codFiscaleClienteRegistrato`) REFERENCES `soggiorno` (`dataInizio`, `codFiscaleCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
INSERT INTO `prenotazione` VALUES ('Spiaggia',NULL,NULL,'2022-09-01','gppvrd00D01E654R',10,'Spiaggia','Autunno',2022),('Palestra',NULL,NULL,'2022-09-01','gppvrd00D01E654R',10,'Palestra','Autunno',2022),('Casino',NULL,NULL,'2022-09-01','gppvrd00D01E654R',10,'Casino','Autunno',2022),('Massaggio','2022-09-07','20:00:00','2022-09-01','gppvrd00D01E654R',10,'Massaggio','Autunno',2022),('Fango','2022-09-07','20:00:00','2022-09-01','gppvrd00D01E654R',10,'Fango','Autunno',2022),('Bagno','2022-09-07','20:00:00','2022-09-01','gppvrd00D01E654R',10,'Bagno','Autunno',2022),('Idromassaggio','2022-09-07','20:00:00','2022-09-01','gppvrd00D01E654R',10,'Idromassaggio','Autunno',2022),('Spiaggia',NULL,NULL,'2022-09-01','blbrjd16m87t113x',10,'Spiaggia','Autunno',2022),('Palestra',NULL,NULL,'2022-09-01','blbrjd16m87t113x',10,'Palestra','Autunno',2022),('Casino',NULL,NULL,'2022-09-01','blbrjd16m87t113x',10,'Casino','Autunno',2022),('Massaggio','2022-09-07','22:00:00','2022-09-01','blbrjd16m87t113x',10,'Massaggio','Autunno',2022),('Fango','2022-09-07','22:00:00','2022-09-01','blbrjd16m87t113x',10,'Fango','Autunno',2022),('Bagno','2022-09-07','22:00:00','2022-09-01','blbrjd16m87t113x',10,'Bagno','Autunno',2022),('Idromassaggio','2022-09-07','22:00:00','2022-09-01','blbrjd16m87t113x',10,'Idromassaggio','Autunno',2022);
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receptionist`
--

DROP TABLE IF EXISTS `receptionist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receptionist` (
  `codReceptionist` tinyint unsigned NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `dataNascita` date NOT NULL,
  `numeroTelefonico` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codReceptionist`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receptionist`
--

LOCK TABLES `receptionist` WRITE;
/*!40000 ALTER TABLE `receptionist` DISABLE KEYS */;
INSERT INTO `receptionist` VALUES (10,'Luigi','Verdi','2001-05-02','+58 8318904050');
/*!40000 ALTER TABLE `receptionist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servizio`
--

DROP TABLE IF EXISTS `servizio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servizio` (
  `tipoServizio` varchar(30) NOT NULL,
  `stagione` varchar(15) NOT NULL,
  `anno` year NOT NULL,
  `tariffa` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`tipoServizio`,`stagione`,`anno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servizio`
--

LOCK TABLES `servizio` WRITE;
/*!40000 ALTER TABLE `servizio` DISABLE KEYS */;
INSERT INTO `servizio` VALUES ('Bagno','Autunno',2022,15.00),('Bagno','Autunno',2023,2000.01),('Bagno','Estate',2022,15.00),('Bagno','Estate',2023,15.00),('Bagno','Inverno',2022,15.00),('Bagno','Inverno',2023,15.00),('Bagno','Primavera',2022,15.00),('Bagno','Primavera',2023,15.00),('Casino','Autunno',2022,10.00),('Casino','Autunno',2023,10.00),('Casino','Estate',2022,10.00),('Casino','Estate',2023,10.00),('Casino','Inverno',2022,10.00),('Casino','Inverno',2023,10.00),('Casino','Primavera',2022,10.00),('Casino','Primavera',2023,10.00),('Fango','Autunno',2022,40.00),('Fango','Autunno',2023,40.00),('Fango','Estate',2022,40.00),('Fango','Estate',2023,40.00),('Fango','Inverno',2022,40.00),('Fango','Inverno',2023,40.00),('Fango','Primavera',2022,40.00),('Fango','Primavera',2023,40.00),('Idromassaggio','Autunno',2022,25.00),('Idromassaggio','Autunno',2023,25.00),('Idromassaggio','Estate',2022,25.00),('Idromassaggio','Estate',2023,25.00),('Idromassaggio','Inverno',2022,25.00),('Idromassaggio','Inverno',2023,25.00),('Idromassaggio','Primavera',2022,25.00),('Idromassaggio','Primavera',2023,25.00),('Massaggio','Autunno',2022,20.00),('Massaggio','Autunno',2023,20.00),('Massaggio','Estate',2022,20.00),('Massaggio','Estate',2023,20.00),('Massaggio','Inverno',2022,20.00),('Massaggio','Inverno',2023,20.00),('Massaggio','Primavera',2022,20.00),('Massaggio','Primavera',2023,20.00),('Palestra','Autunno',2022,5.00),('Palestra','Autunno',2023,5.00),('Palestra','Estate',2022,5.00),('Palestra','Estate',2023,5.00),('Palestra','Inverno',2022,5.00),('Palestra','Inverno',2023,5.00),('Palestra','Primavera',2022,5.00),('Palestra','Primavera',2023,5.00),('Parcheggio','Autunno',2022,8.00),('Parcheggio','Autunno',2023,8.00),('Parcheggio','Estate',2022,8.00),('Parcheggio','Estate',2023,8.00),('Parcheggio','Inverno',2022,8.00),('Parcheggio','Inverno',2023,8.00),('Parcheggio','Primavera',2022,8.00),('Parcheggio','Primavera',2023,8.00),('Spiaggia','Autunno',2022,8.00),('Spiaggia','Autunno',2023,8.00),('Spiaggia','Estate',2022,8.00),('Spiaggia','Estate',2023,8.00),('Spiaggia','Inverno',2022,8.00),('Spiaggia','Inverno',2023,8.00),('Spiaggia','Primavera',2022,8.00),('Spiaggia','Primavera',2023,8.00);
/*!40000 ALTER TABLE `servizio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soggiorno`
--

DROP TABLE IF EXISTS `soggiorno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soggiorno` (
  `codFiscaleCliente` varchar(16) NOT NULL,
  `dataInizio` date NOT NULL,
  `dataFine` date NOT NULL,
  `soggiornante` tinyint(1) NOT NULL,
  `offertaScelta` varchar(20) NOT NULL,
  `codScheda` decimal(10,0) NOT NULL,
  `numeroCamera` decimal(5,0) NOT NULL,
  `resoconto` decimal(10,2) DEFAULT NULL,
  `tipologiaSoggiornoScelto` varchar(30) NOT NULL,
  `meseSoggiornoScelto` varchar(15) NOT NULL,
  `annoSoggiornoScelto` year NOT NULL,
  `codReceptionistInserente` tinyint unsigned NOT NULL,
  PRIMARY KEY (`dataInizio`,`codFiscaleCliente`),
  KEY `FKABBINAMENTO` (`tipologiaSoggiornoScelto`,`meseSoggiornoScelto`,`annoSoggiornoScelto`),
  KEY `FKIDENTIFICAZIONE` (`codFiscaleCliente`),
  KEY `FKCREAZIONE` (`codReceptionistInserente`),
  CONSTRAINT `FKABBINAMENTO` FOREIGN KEY (`tipologiaSoggiornoScelto`, `meseSoggiornoScelto`, `annoSoggiornoScelto`) REFERENCES `tipologiasoggiorno` (`tipologia`, `mese`, `anno`),
  CONSTRAINT `FKCREAZIONE` FOREIGN KEY (`codReceptionistInserente`) REFERENCES `receptionist` (`codReceptionist`),
  CONSTRAINT `FKIDENTIFICAZIONE` FOREIGN KEY (`codFiscaleCliente`) REFERENCES `cliente` (`codFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soggiorno`
--

LOCK TABLES `soggiorno` WRITE;
/*!40000 ALTER TABLE `soggiorno` DISABLE KEYS */;
INSERT INTO `soggiorno` VALUES ('gppvrd00D01E654R','2022-09-01','2022-09-10',1,'ALI',123541,506,1323.00,'ALI','Settembre',2022,10),('blbrjd16m87t113x','2022-09-01','2022-09-14',1,'ALI',8883478,111,1923.00,'ALI','Settembre',2022,10),('elzcna68w16r786i','2022-09-01','2022-09-14',1,'ALI',199978,110,1770.00,'ALI','Settembre',2022,10),('kdbrxr24p20x988x','2022-09-01','2022-09-14',1,'PB',673478,106,1350.00,'PB','Settembre',2022,10),('obznpr10a32w952u','2022-09-01','2022-09-14',1,'BB',193478,101,1131.00,'BB','Settembre',2022,10),('uwddfz89g60w152l','2022-09-01','2022-09-14',1,'ALI',44483478,210,1800.00,'ALI','Settembre',2022,10),('waidil48b45u898w','2022-09-01','2022-09-14',1,'PB',995448,107,1350.00,'PB','Settembre',2022,10),('wcqkht67z81h362a','2022-09-01','2022-09-14',1,'ALI',77773478,211,1800.00,'ALI','Settembre',2022,10),('wlurgn18s25z563g','2022-09-01','2022-09-14',1,'ALI',11883478,310,2000.00,'ALI','Settembre',2022,10),('yzfmmc73p40q141o','2022-09-01','2022-09-06',0,'BB',194478,204,0.00,'BB','Settembre',2022,10),('zsddmq19d50l295i','2022-09-01','2022-09-14',0,'BB',196668,103,0.00,'BB','Settembre',2022,10),('blbrjd16m87t113x','2022-12-17','2022-12-31',0,'ALI',93478,310,1500.00,'ALI','Dicembre',2022,10),('qminsg80f67i990v','2022-12-17','2022-12-31',0,'ALI',8899998,411,1500.00,'ALI','Dicembre',2022,10),('qpccsu81x56t466a','2022-12-17','2022-12-31',0,'ALI',8800008,410,1500.00,'ALI','Dicembre',2022,10),('sbupog32l65f028n','2022-12-17','2022-12-31',0,'ALI',190478,210,1500.00,'ALI','Dicembre',2022,10),('ucrhhv52p15d728l','2022-12-17','2022-12-31',0,'ALI',193470,211,1500.00,'ALI','Dicembre',2022,10),('ueiifj92b58o524c','2022-12-17','2022-12-31',0,'ALI',8900478,311,1500.00,'ALI','Dicembre',2022,10),('yzjnes53j56r141v','2022-12-17','2022-12-31',0,'ALI',122478,110,1500.00,'ALI','Dicembre',2022,10),('zxgbhr53x76v368i','2022-12-17','2022-12-31',0,'ALI',100078,111,1500.00,'ALI','Dicembre',2022,10);
/*!40000 ALTER TABLE `soggiorno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipologiasoggiorno`
--

DROP TABLE IF EXISTS `tipologiasoggiorno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipologiasoggiorno` (
  `tipologia` varchar(30) NOT NULL,
  `mese` varchar(15) NOT NULL,
  `anno` year NOT NULL,
  `prezzo` decimal(10,2) NOT NULL,
  PRIMARY KEY (`tipologia`,`mese`,`anno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipologiasoggiorno`
--

LOCK TABLES `tipologiasoggiorno` WRITE;
/*!40000 ALTER TABLE `tipologiasoggiorno` DISABLE KEYS */;
INSERT INTO `tipologiasoggiorno` VALUES ('ALI','Agosto',2022,120.00),('ALI','Agosto',2023,120.00),('ALI','Aprile',2022,100.00),('ALI','Aprile',2023,90.00),('ALI','Dicembre',2022,100.00),('ALI','Dicembre',2023,100.00),('ALI','Febbraio',2022,90.00),('ALI','Febbraio',2023,90.00),('ALI','Gennaio',2022,90.00),('ALI','Gennaio',2023,90.00),('ALI','Giugno',2022,120.00),('ALI','Giugno',2023,120.00),('ALI','Luglio',2022,120.00),('ALI','Luglio',2023,120.00),('ALI','Maggio',2022,100.00),('ALI','Maggio',2023,90.00),('ALI','Marzo',2022,90.00),('ALI','Marzo',2023,90.00),('ALI','Novembre',2022,90.00),('ALI','Novembre',2023,90.00),('ALI','Ottobre',2022,90.00),('ALI','Ottobre',2023,90.00),('ALI','Settembre',2022,120.00),('ALI','Settembre',2023,120.00),('BB','Agosto',2022,60.00),('BB','Agosto',2023,60.00),('BB','Aprile',2022,50.00),('BB','Aprile',2023,40.00),('BB','Dicembre',2022,50.00),('BB','Dicembre',2023,40.00),('BB','Febbraio',2022,30.00),('BB','Febbraio',2023,30.00),('BB','Gennaio',2022,30.00),('BB','Gennaio',2023,30.00),('BB','Giugno',2022,60.00),('BB','Giugno',2023,60.00),('BB','Luglio',2022,60.00),('BB','Luglio',2023,60.00),('BB','Maggio',2022,50.00),('BB','Maggio',2023,40.00),('BB','Marzo',2022,30.00),('BB','Marzo',2023,30.00),('BB','Novembre',2022,30.00),('BB','Novembre',2023,30.00),('BB','Ottobre',2022,30.00),('BB','Ottobre',2023,30.00),('BB','Settembre',2022,60.00),('BB','Settembre',2023,60.00),('PB','Agosto',2022,90.00),('PB','Agosto',2023,90.00),('PB','Aprile',2022,70.00),('PB','Aprile',2023,60.00),('PB','Dicembre',2022,70.00),('PB','Dicembre',2023,70.00),('PB','Febbraio',2022,60.00),('PB','Febbraio',2023,60.00),('PB','Gennaio',2022,60.00),('PB','Gennaio',2023,60.00),('PB','Giugno',2022,90.00),('PB','Giugno',2023,90.00),('PB','Luglio',2022,90.00),('PB','Luglio',2023,90.00),('PB','Maggio',2022,70.00),('PB','Maggio',2023,60.00),('PB','Marzo',2022,60.00),('PB','Marzo',2023,60.00),('PB','Novembre',2022,60.00),('PB','Novembre',2023,60.00),('PB','Ottobre',2022,60.00),('PB','Ottobre',2023,60.00),('PB','Settembre',2022,90.00),('PB','Settembre',2023,90.00);
/*!40000 ALTER TABLE `tipologiasoggiorno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-07 23:17:27
