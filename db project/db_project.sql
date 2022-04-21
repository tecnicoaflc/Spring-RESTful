CREATE DATABASE `db_project`; 
USE `db_project`;

SET NAMES utf8 ;
SET character_set_client = utf8mb4 ;

DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;


INSERT INTO `clients` VALUES (1,'Juan','Ferran','658974135','juan.ferran@example.net','Galicia'),(2,'Miguel','Gutierrez','654239874','miguel@example.net','Cantabria'),(3,'Sara','Molina','623598422','sara.molinaa@example.net','Valencia'),(4,'Carmen','Perez','635899423','luis@example.org','Sevilla'),(5,'Carlos','Martinez','665320011','karlie.mar@example.org','Madrid'),(6,'Luis','Valles','678995544','valles.ines@example.net','Bilbao'),(7,'Alejandro','Mar','603322015','alel05@example.net','Barcelona'),(8,'Alfonso','Perez','677854210','alfonso.perez@example.com','Valencia'),(9,'Manuel','Garcia','652398889','mn.gr@example.net','Barcelona'),(10,'Rocio','Lopez','655423987','r.lop@example.org','Madrid');

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `lastname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

INSERT INTO `users` VALUES (7,'Andres','Perez','0','admin@admin.com','$argon2id$v=19$m=1024,t=1,p=1$/rbk8EXE3Hf0kVXyyepIxQ$9j2NF/XomxrJlkFhGZQMKi+jIluOPGz9OC3MC0N8LVk');

