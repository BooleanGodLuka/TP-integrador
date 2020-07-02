CREATE DATABASE  IF NOT EXISTS `db_grupo4_labo4` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_grupo4_labo4`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: db_grupo4_labo4
-- ------------------------------------------------------
-- Server version	5.7.30-log

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `ALUMNOS_id` int(11) NOT NULL AUTO_INCREMENT,
  `ALUMNOS_dni` varchar(30) NOT NULL,
  `ALUMNOS_nombre` varchar(30) NOT NULL,
  `ALUMNOS_apellido` varchar(30) NOT NULL,
  `ALUMNOS_fechanacimiento` varchar(30) NOT NULL,
  `ALUMNOS_email` varchar(30) NOT NULL,
  `ALUMNOS_direccion` varchar(30) NOT NULL,
  `ALUMNOS_idlocalidad` int(11) NOT NULL,
  `ALUMNOS_telefono` varchar(30) NOT NULL,
  PRIMARY KEY (`ALUMNOS_id`),
  KEY `ALUMNOS_idlocalidad` (`ALUMNOS_idlocalidad`),
  CONSTRAINT `alumnos_ibfk_1` FOREIGN KEY (`ALUMNOS_idlocalidad`) REFERENCES `localidades` (`LOCALIDADES_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'39107022','Luca','Di Tullio','1995-10-17','luca.ditu@hotmail.com','Peru 2882',2,'1540817447'),(2,'40235486','Lucas','Feldman','1996-4-20','lucas.feld@hotmail.com','Peron 556',4,'1568432148'),(3,'41548668','Guido','Amicci','1997-8-10','guido.ami@hotmail.com','Alfonsin 746',6,'1546687753');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnosxcursos`
--

DROP TABLE IF EXISTS `alumnosxcursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnosxcursos` (
  `ALUMNOSXCURSOS_idalumno` int(11) NOT NULL,
  `ALUMNOSXCURSOS_idcurso` int(11) NOT NULL,
  `ALUMNOSXCURSOS_nota1` int(11) DEFAULT NULL,
  `ALUMNOSXCURSOS_recu` int(11) DEFAULT NULL,
  `ALUMNOSXCURSOS_nota2` int(11) DEFAULT NULL,
  `ALUMNOSXCURSOS_notafinal` int(11) DEFAULT NULL,
  PRIMARY KEY (`ALUMNOSXCURSOS_idalumno`,`ALUMNOSXCURSOS_idcurso`),
  KEY `ALUMNOSXCURSOS_idcurso` (`ALUMNOSXCURSOS_idcurso`),
  CONSTRAINT `alumnosxcursos_ibfk_1` FOREIGN KEY (`ALUMNOSXCURSOS_idalumno`) REFERENCES `alumnos` (`ALUMNOS_id`),
  CONSTRAINT `alumnosxcursos_ibfk_2` FOREIGN KEY (`ALUMNOSXCURSOS_idcurso`) REFERENCES `cursos` (`CURSOS_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnosxcursos`
--

LOCK TABLES `alumnosxcursos` WRITE;
/*!40000 ALTER TABLE `alumnosxcursos` DISABLE KEYS */;
INSERT INTO `alumnosxcursos` VALUES (1,1,7,7,8,8),(2,2,2,6,5,6),(3,3,8,8,5,6);
/*!40000 ALTER TABLE `alumnosxcursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `CURSOS_id` int(11) NOT NULL AUTO_INCREMENT,
  `CURSOS_cuatrimestre` varchar(30) NOT NULL,
  `CURSOS_año` varchar(30) NOT NULL,
  `CURSOS_idmateria` int(11) NOT NULL,
  `CURSOS_iddocente` int(11) NOT NULL,
  PRIMARY KEY (`CURSOS_id`),
  KEY `CURSOS_idmateria` (`CURSOS_idmateria`),
  KEY `CURSOS_iddocente` (`CURSOS_iddocente`),
  CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`CURSOS_idmateria`) REFERENCES `materias` (`MATERIAS_id`),
  CONSTRAINT `cursos_ibfk_2` FOREIGN KEY (`CURSOS_iddocente`) REFERENCES `docentes` (`DOCENTES_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'2° cuatrimestre','1° año',1,1),(2,'1° cuatrimestre','2° año',2,2),(3,'1° cuatrimestre','1° año',3,3);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docentes`
--

DROP TABLE IF EXISTS `docentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docentes` (
  `DOCENTES_id` int(11) NOT NULL AUTO_INCREMENT,
  `DOCENTES_dni` int(11) NOT NULL,
  `DOCENTES_nombre` varchar(30) NOT NULL,
  `DOCENTES_apellido` varchar(30) NOT NULL,
  `DOCENTES_fechanacimiento` varchar(30) NOT NULL,
  `DOCENTES_email` varchar(30) NOT NULL,
  `DOCENTES_direccion` varchar(30) NOT NULL,
  `DOCENTES_idlocalidad` int(11) NOT NULL,
  PRIMARY KEY (`DOCENTES_id`),
  KEY `DOCENTES_idlocalidad` (`DOCENTES_idlocalidad`),
  CONSTRAINT `docentes_ibfk_1` FOREIGN KEY (`DOCENTES_idlocalidad`) REFERENCES `localidades` (`LOCALIDADES_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docentes`
--

LOCK TABLES `docentes` WRITE;
/*!40000 ALTER TABLE `docentes` DISABLE KEYS */;
INSERT INTO `docentes` VALUES (1,20564896,'Daniel','Kloster','1975-11-27','dani.klost@hotmail.com','San Martin 3882',1),(2,30678468,'Tamara','Herrera','1986-4-20','tami.herr@hotmail.com','San Fransisco 756',3),(3,29684687,'Maximiliano','Sar','1985-8-10','maxi.sar@hotmail.com','Pacheco 946',5);
/*!40000 ALTER TABLE `docentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docentesxcursos`
--

DROP TABLE IF EXISTS `docentesxcursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docentesxcursos` (
  `DOCENTESXCURSOS_iddocente` int(11) NOT NULL,
  `DOCENTESXCURSOS_idcurso` int(11) NOT NULL,
  PRIMARY KEY (`DOCENTESXCURSOS_iddocente`,`DOCENTESXCURSOS_idcurso`),
  KEY `DOCENTESXCURSOS_idcurso` (`DOCENTESXCURSOS_idcurso`),
  CONSTRAINT `docentesxcursos_ibfk_1` FOREIGN KEY (`DOCENTESXCURSOS_iddocente`) REFERENCES `docentes` (`DOCENTES_id`),
  CONSTRAINT `docentesxcursos_ibfk_2` FOREIGN KEY (`DOCENTESXCURSOS_idcurso`) REFERENCES `cursos` (`CURSOS_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docentesxcursos`
--

LOCK TABLES `docentesxcursos` WRITE;
/*!40000 ALTER TABLE `docentesxcursos` DISABLE KEYS */;
INSERT INTO `docentesxcursos` VALUES (1,1),(2,2),(3,3);
/*!40000 ALTER TABLE `docentesxcursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidades`
--

DROP TABLE IF EXISTS `localidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localidades` (
  `LOCALIDADES_id` int(11) NOT NULL AUTO_INCREMENT,
  `LOCALIDADES_nombre` varchar(30) NOT NULL,
  `LOCALIDADES_idprovincia` int(11) NOT NULL,
  PRIMARY KEY (`LOCALIDADES_id`),
  KEY `LOCALIDADES_idprovincia` (`LOCALIDADES_idprovincia`),
  CONSTRAINT `localidades_ibfk_1` FOREIGN KEY (`LOCALIDADES_idprovincia`) REFERENCES `provincias` (`PROVINCIAS_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
INSERT INTO `localidades` VALUES (1,'Pacheco',1),(2,'San Isidro',1),(3,'Agreto',2),(4,'Jocoli',2),(5,'Aguaray',3),(6,'Hipolito Yrigoyen',3);
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materias` (
  `MATERIAS_id` int(11) NOT NULL AUTO_INCREMENT,
  `MATERIAS_nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`MATERIAS_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
INSERT INTO `materias` VALUES (1,'Laboratorio II'),(2,'Ingles'),(3,'Estadistica');
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paises` (
  `PAISES_id` int(11) NOT NULL AUTO_INCREMENT,
  `PAISES_nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`PAISES_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'Argentina');
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provincias` (
  `PROVINCIAS_id` int(11) NOT NULL AUTO_INCREMENT,
  `PROVINCIAS_nombre` varchar(30) NOT NULL,
  `PROVINCIAS_idpais` int(11) NOT NULL,
  PRIMARY KEY (`PROVINCIAS_id`),
  KEY `PROVINCIAS_idpais` (`PROVINCIAS_idpais`),
  CONSTRAINT `provincias_ibfk_1` FOREIGN KEY (`PROVINCIAS_idpais`) REFERENCES `paises` (`PAISES_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,'BsAs',1),(2,'Mendoza',1),(3,'Salta',1);
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-01  6:15:20
