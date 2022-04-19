CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `servicos`
--

DROP TABLE IF EXISTS `servicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `servico` longtext NOT NULL,
  `observacao` mediumtext,
  `quantidade` int DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `modelo` varchar(20) DEFAULT NULL,
  `placa` varchar(20) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `metodo` int DEFAULT NULL,
  `data` varchar(20) DEFAULT NULL,
  `horario` time(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicos`
--

LOCK TABLES `servicos` WRITE;
/*!40000 ALTER TABLE `servicos` DISABLE KEYS */;
INSERT INTO `servicos` VALUES (67,' (1x Venda de pneu 15)','',1,'Outro','','',120,2,'2022-04-12',NULL),(68,' (1x Refil)','',1,'Outro','','',20,1,'2022-04-12',NULL),(69,' (1x Troca)','',1,'Outro','','',20,1,'2022-04-12',NULL),(70,' (1x Refil)','',1,'Outro','','',20,1,'2022-04-12',NULL),(71,' (2x Troca)','',2,'Outro','','',40,2,'2022-04-12',NULL),(73,' (1x Refil)','',1,'Outro','','',20,2,'2022-04-12',NULL),(74,' (2x Venda de pneu 14)','',2,'Outro','','',260,1,'2022-04-12',NULL),(75,' (1x Outro)','Itamar Gaz',1,'Outro','','',200,1,'2022-04-12',NULL),(76,' (1x Refil)','',1,'Outro','','',20,2,'2022-04-11',NULL),(77,' (1x Coxim)','',1,'Renault','Sandero','MJI7240',50,1,'2022-04-12',NULL),(78,' (1x Vulcanizo) (1x Rodízio)','',1,'Outro','',' ',60,4,'2022-04-12',NULL),(79,' (1x Remendo quente)','',1,'Outro','',' ',30,1,'2022-04-12',NULL),(80,' (1x Refil)','',1,'Outro','',' ',20,1,'2022-04-12',NULL),(81,' (1x Outro)','Mercado das embalagens',1,'Outro','',' ',20,1,'2022-04-11',NULL),(82,' (1x Remendo frio)','',1,'Outro','',' ',30,2,'2022-04-11',NULL),(83,' (2x Refil)','',2,'Outro','',' ',40,1,'2022-04-11',NULL),(84,' (1x Desempeno de Roda)','',1,'Outro','',' ',40,1,'2022-04-11',NULL),(85,' (1x Vedação)','',1,'Outro','',' ',20,2,'2022-04-11',NULL),(86,' (1x Refil)','',1,'Outro','',' ',20,2,'2022-04-11',NULL),(87,' (1x Outro)','Pendencia paga',1,'Outro','',' ',300,1,'2022-04-11',NULL),(88,' (1x Vulcanizo)','',1,'Outro','',' ',50,2,'2022-04-11',NULL),(89,' (1x Refil)','',1,'Outro','',' ',20,1,'2022-04-11',NULL),(91,' (1x Vedação)','',1,'Outro','','',20,4,'2022-04-13',NULL),(93,' (1x Refil)','',1,'Chevrolet','Prisma','',20,2,'2022-04-13',NULL),(94,' (1x Manutenção)','',1,'Renault','Sandero','',60,4,'2022-04-13',NULL),(96,' (1x Venda de pneu 14)','',1,'Outro','','',100,2,'2022-04-13',NULL),(98,' (4x Troca)','',4,'Outro','','',40,2,'2022-04-13',NULL),(99,'(2x Troca)',' ',2,'Outro',' ',' ',30,1,'2022-04-13',NULL),(108,'(1x Troca)',' ',1,'Outro',' ',' ',10,4,'2022-04-13',NULL),(109,'(1x Venda de roda)',' ',1,'Outro',' ',' ',300,4,'2022-04-13',NULL),(126,'1x Vedação.','',1,'Outro','','',20,4,'2022-04-13',NULL),(127,'1x Venda de pneu 14.','',1,'Outro','','',130,2,'2022-04-13',NULL),(130,'1x Troca.','',1,'Outro','','',20,4,'2022-04-14',NULL),(131,'1x Manutenção.','',1,'Outro','','',30,1,'2022-04-14',NULL),(132,'1x Troca.','',1,'Outro','','',80,2,'2022-04-14',NULL),(133,'1x Manutenção.','',1,'Outro','','',60,1,'2022-04-14',NULL),(134,'1x Vedação.','',1,'Outro','','',60,1,'2022-04-14',NULL),(136,'4x Balanceamento, 1x Vulcanizo, 4x Rodízio.','',4,'Outro','','',120,4,'2022-04-14',NULL),(137,'3x Venda de pneu 17.','',3,'Renault','Captur','',340,2,'2022-04-14',NULL);
/*!40000 ALTER TABLE `servicos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-19  0:12:01
