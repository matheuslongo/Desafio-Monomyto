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
-- Table structure for table `catalogo`
--

DROP TABLE IF EXISTS `catalogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalogo` (
  `id` varchar(255) NOT NULL,
  `classificacao` varchar(255) NOT NULL,
  `marca` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `preco_atual` double DEFAULT NULL,
  `regiao` varchar(255) NOT NULL,
  `teor_alcoolico` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogo`
--

LOCK TABLES `catalogo` WRITE;
/*!40000 ALTER TABLE `catalogo` DISABLE KEYS */;
INSERT INTO `catalogo` VALUES ('2998f46b-8c31-49ec-8695-cd7f7c9603ba','Pura','Cachaça 51','Cachaça Caninha 51 200ml',6.99,'SP','51'),('2fe9c1ba-0f05-41ad-97e0-77688e381219','Ouro','Weber Haus','Weber Haus Extra Premium 700ml',78.99,'RS','38'),('6837dbda-3868-45dc-84ec-81e70156cb1f','Pura','Cachaça Singleton','Cachaça Singleton 200ml',12,'AC','99'),('8f947684-a87d-482f-90fc-debbc7aaa3b8','Ouro','Princesa Isabel','Cachaça Princesa Isabel Carvalho 700ml',100,'ES','40'),('970d8e96-9041-4f0a-9871-89330683e318','Pura','Cachaça 51','Cachaça Caninha 51 700ml',20.99,'SP','51'),('a9807de2-1943-4744-b446-14c1cba5a9db','Ouro','Cachaças Canuto','Canuto Golden 700ml',110,'MG','44'),('b3df0541-d25f-4d7a-b29c-1e723a3080d9','Pura','Cachaça Botiqueira','Botiqueira Pura 900ml',54.32,'MG','40'),('d07e7eeb-c4bf-4449-a666-7bc52d10e405','Prata','Cachaça Pasieka','Pasieka Prata 2L',24.99,'RS','43');
/*!40000 ALTER TABLE `catalogo` ENABLE KEYS */;
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
