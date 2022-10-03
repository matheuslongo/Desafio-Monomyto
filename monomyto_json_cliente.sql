-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: monomyto_json
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.22.04.1

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` varchar(255) NOT NULL,
  `data_de_nascimento` date DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('0463c6c9-dbe7-447f-a27d-72a977108d19','1985-01-01','Rafael Costa'),('176d0220-f17a-47a8-a6cd-94aa8b196ea3','1725-04-13','Rafael Garcez'),('3d43268f-f22d-4ee3-a291-e6a2a1e7fc2d','1995-08-13','Victor Canuto'),('42bc30e8-0ca9-401b-9e80-91a71a2abfa3','1995-04-12','Dio Franco'),('51e85ce9-8e13-4a25-907d-2fa7c7c98bc2','1980-08-22','João Canabrava'),('6bf7e3f3-9dab-4938-a09d-6f27ebe93780','1991-12-25','Lucas Pazze'),('957f1c25-9ddc-477b-b44c-48f383f843f1','2021-02-01','Cristóvão o Jovem'),('963a997a-6bfc-41b2-8125-c27d2f4c4de4','1994-07-15','Ricardo Pieper'),('a0d629cb-f86e-4d5c-9893-2e21a5a35d7d','1997-12-03','Fernanda Oliveira'),('be2babd1-1ba7-4a40-af02-af6df25a0f1aea','1997-07-17','Tiago Paschoalini'),('c88c3b13-c23e-4641-a6f4-b4d64ffb49cd','1943-11-21','Gotardo'),('f3d1aa5f-9415-44ef-b720-844be6f6f6da','1992-02-15','Rodrigo Magnus');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-03 14:41:48
