CREATE DATABASE  IF NOT EXISTS `academiadb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `academiadb`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: academiadb
-- ------------------------------------------------------
-- Server version	8.0.36

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
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `dataNascimento` date NOT NULL,
  `idEndereco` int DEFAULT NULL,
  `idPlano` int DEFAULT NULL,
  `dataInicioPlano` varchar(45) DEFAULT NULL,
  `idTreino` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `idEndereco_idx` (`idEndereco`),
  KEY `idPlano_idx` (`idPlano`),
  CONSTRAINT `idEndereco` FOREIGN KEY (`idEndereco`) REFERENCES `enderecocliente` (`idEnderecoCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (2,'Pedro','046.556.523-90','1999-05-11',23,5,'2024-04-07','1'),(3,'lucas','883.761.528-07','1998-11-08',11,5,'2024-04-07','0'),(5,'aaa','060.246.089-18','2003-01-22',NULL,0,'2024-04-07','0'),(6,'Pedro','122.447.499-67','1111-10-11',21,5,'2024-04-07','8');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enderecocliente`
--

DROP TABLE IF EXISTS `enderecocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enderecocliente` (
  `idEnderecoCliente` int NOT NULL AUTO_INCREMENT,
  `rua` varchar(45) DEFAULT NULL,
  `cep` int DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `numero` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idEnderecoCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enderecocliente`
--

LOCK TABLES `enderecocliente` WRITE;
/*!40000 ALTER TABLE `enderecocliente` DISABLE KEYS */;
INSERT INTO `enderecocliente` VALUES (9,'maria das graças',22222,'11',''),(10,'pedro das gracianes',33333333,'111111','12'),(11,'piratuab',2345,'urubuca','123'),(12,NULL,NULL,NULL,NULL),(13,'pedro aaaaaa',NULL,NULL,NULL),(14,'pocas',111,'12121','11'),(15,NULL,NULL,NULL,NULL),(16,'1221',22,'1212','122'),(17,'1221',22,'1212','122'),(18,'1221',22,'1212','122'),(19,NULL,NULL,NULL,NULL),(20,'11',1,NULL,'1'),(21,NULL,NULL,NULL,NULL),(22,'pocas',111,'12121','11'),(23,'pocas',111,'12121','11');
/*!40000 ALTER TABLE `enderecocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercicio`
--

DROP TABLE IF EXISTS `exercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercicio` (
  `idExercicio` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `musculaturaAfetada` varchar(45) NOT NULL,
  PRIMARY KEY (`idExercicio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercicio`
--

LOCK TABLES `exercicio` WRITE;
/*!40000 ALTER TABLE `exercicio` DISABLE KEYS */;
INSERT INTO `exercicio` VALUES (1,'supino reto','Peito');
/*!40000 ALTER TABLE `exercicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrutor`
--

DROP TABLE IF EXISTS `instrutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instrutor` (
  `idInstrutor` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  PRIMARY KEY (`idInstrutor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrutor`
--

LOCK TABLES `instrutor` WRITE;
/*!40000 ALTER TABLE `instrutor` DISABLE KEYS */;
INSERT INTO `instrutor` VALUES (1,'kleber','122.447.499-67'),(4,'joel','222.622.489-07');
/*!40000 ALTER TABLE `instrutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `idLogin` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`idLogin`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalidade`
--

DROP TABLE IF EXISTS `modalidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modalidade` (
  `idModalidade` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idModalidade`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidade`
--

LOCK TABLES `modalidade` WRITE;
/*!40000 ALTER TABLE `modalidade` DISABLE KEYS */;
INSERT INTO `modalidade` VALUES (1,'Spinning'),(2,'Ginastica'),(3,'Musculação'),(4,'Yoga'),(5,'Terapeutica'),(6,'natação'),(7,'Muay Thai'),(8,'Box');
/*!40000 ALTER TABLE `modalidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalidade_has_instrutor`
--

DROP TABLE IF EXISTS `modalidade_has_instrutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modalidade_has_instrutor` (
  `idModalidade_has_instrutor` int NOT NULL AUTO_INCREMENT,
  `idModalidade` int NOT NULL,
  `idInstrutor` int NOT NULL,
  PRIMARY KEY (`idModalidade_has_instrutor`),
  KEY `idModalidade_idx` (`idModalidade`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidade_has_instrutor`
--

LOCK TABLES `modalidade_has_instrutor` WRITE;
/*!40000 ALTER TABLE `modalidade_has_instrutor` DISABLE KEYS */;
INSERT INTO `modalidade_has_instrutor` VALUES (31,1,4),(32,3,4),(33,5,4),(40,2,2),(41,4,2),(42,6,2),(48,1,2),(53,6,5);
/*!40000 ALTER TABLE `modalidade_has_instrutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `idPedido` int NOT NULL AUTO_INCREMENT,
  `formaPagamento` varchar(45) NOT NULL,
  `quantidadeParcelas` int NOT NULL,
  `desconto` decimal(2,2) DEFAULT NULL,
  PRIMARY KEY (`idPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plano`
--

DROP TABLE IF EXISTS `plano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plano` (
  `idPlano` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `tempoAtivacao` int NOT NULL,
  PRIMARY KEY (`idPlano`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plano`
--

LOCK TABLES `plano` WRITE;
/*!40000 ALTER TABLE `plano` DISABLE KEYS */;
INSERT INTO `plano` VALUES (5,'Ultra',10000.00,12),(7,'small',500.00,12),(8,'ze',150.00,12),(9,'jonas',23.00,12),(10,'Planio senio',3500.00,12);
/*!40000 ALTER TABLE `plano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plano_has_modalidade`
--

DROP TABLE IF EXISTS `plano_has_modalidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plano_has_modalidade` (
  `idPlano_has_modalidade` int NOT NULL AUTO_INCREMENT,
  `idPlano` int NOT NULL,
  `idModalidade` int NOT NULL,
  PRIMARY KEY (`idPlano_has_modalidade`),
  KEY `idPlano_idx` (`idPlano`),
  KEY `idModalidade_idx` (`idModalidade`),
  CONSTRAINT `idModalidade` FOREIGN KEY (`idModalidade`) REFERENCES `modalidade` (`idModalidade`) ON DELETE CASCADE,
  CONSTRAINT `idPlano` FOREIGN KEY (`idPlano`) REFERENCES `plano` (`idPlano`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plano_has_modalidade`
--

LOCK TABLES `plano_has_modalidade` WRITE;
/*!40000 ALTER TABLE `plano_has_modalidade` DISABLE KEYS */;
INSERT INTO `plano_has_modalidade` VALUES (1,8,1),(2,8,3),(3,8,5),(4,9,2),(11,9,5),(12,9,3),(13,9,4),(14,8,2),(15,8,4),(16,8,6),(17,10,3),(18,10,8);
/*!40000 ALTER TABLE `plano_has_modalidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treino`
--

DROP TABLE IF EXISTS `treino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treino` (
  `idTreino` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`idTreino`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treino`
--

LOCK TABLES `treino` WRITE;
/*!40000 ALTER TABLE `treino` DISABLE KEYS */;
INSERT INTO `treino` VALUES (1,'Colleman','feito para campeões'),(2,'Monstro Training','Treino pra ficar gigante'),(3,'anothe one','good training to grow up'),(5,'tal','dificil'),(8,'Teste final','se nao der acabou');
/*!40000 ALTER TABLE `treino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treino_has_exercicio`
--

DROP TABLE IF EXISTS `treino_has_exercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treino_has_exercicio` (
  `idTreino_has_exercicio` int NOT NULL AUTO_INCREMENT,
  `idTreino` int NOT NULL,
  `idExercicio` int NOT NULL,
  `diaSemana` varchar(45) NOT NULL,
  PRIMARY KEY (`idTreino_has_exercicio`),
  KEY `idExercicio_idx` (`idExercicio`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treino_has_exercicio`
--

LOCK TABLES `treino_has_exercicio` WRITE;
/*!40000 ALTER TABLE `treino_has_exercicio` DISABLE KEYS */;
INSERT INTO `treino_has_exercicio` VALUES (1,8,2,'Segunda'),(2,8,7,'Segunda'),(3,8,8,'Segunda'),(4,8,9,'Segunda'),(5,8,10,'Segunda'),(6,8,11,'Segunda'),(7,8,12,'Segunda'),(8,8,13,'Segunda'),(9,8,14,'Segunda'),(10,8,15,'Segunda'),(11,8,16,'Terça'),(12,8,17,'Terça'),(13,8,18,'Terça'),(14,8,19,'Terça'),(15,8,20,'Terça'),(16,8,31,'Terça'),(17,8,4,'Quinta'),(18,8,21,'Quinta'),(19,8,22,'Quinta'),(20,8,23,'Quinta'),(21,8,6,'Sexta'),(22,8,24,'Sexta'),(23,8,25,'Sexta'),(24,8,26,'Sexta'),(25,8,28,'Sabado'),(26,8,29,'Sabado'),(27,8,30,'Sabado'),(28,8,28,'Domingo'),(29,8,29,'Domingo'),(30,8,30,'Domingo');
/*!40000 ALTER TABLE `treino_has_exercicio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-07 19:03:40
