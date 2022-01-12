-- --------------------------------------------------------
-- Servidor:                     sql10.freemysqlhosting.net
-- Versão do servidor:           5.5.62-0ubuntu0.14.04.1 - (Ubuntu)
-- OS do Servidor:               debian-linux-gnu
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para sql10463651
CREATE DATABASE IF NOT EXISTS `sql10463651` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sql10463651`;

-- Copiando estrutura para tabela sql10463651.cofre
CREATE TABLE IF NOT EXISTS `cofre` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `cadastro` date DEFAULT NULL,
  `descricao_meta` varchar(255) DEFAULT NULL,
  `is_deletado` bit(1) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `valor_meta` double NOT NULL,
  `valor_total` double NOT NULL,
  `vencimento_meta` date DEFAULT NULL,
  `conta_codigo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK7edt57wactatjuc351gyjp61m` (`conta_codigo`),
  CONSTRAINT `FK7edt57wactatjuc351gyjp61m` FOREIGN KEY (`conta_codigo`) REFERENCES `conta` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela sql10463651.cofre: ~0 rows (aproximadamente)
DELETE FROM `cofre`;
/*!40000 ALTER TABLE `cofre` DISABLE KEYS */;
INSERT INTO `cofre` (`codigo`, `cadastro`, `descricao_meta`, `is_deletado`, `nome`, `valor_meta`, `valor_total`, `vencimento_meta`, `conta_codigo`) VALUES
	(1, '2022-01-12', 'Descricao', b'0', 'Apartamento', 300000, 100, '2024-01-01', 1),
	(2, '2022-01-12', 'Descricao', b'0', 'Viagem', 5000, 500, '2022-01-01', 1),
	(3, '2022-01-12', 'Descricao', b'0', 'Carro', 35000, 750, '2025-01-01', 1),
	(4, '2022-01-12', 'Descricao', b'0', 'Casamento', 25000, 7500, '2022-05-05', 1),
	(5, '2022-01-12', 'Descricao', b'0', 'MBA - FIAP', 25000, 5500, '2022-06-01', 1);
/*!40000 ALTER TABLE `cofre` ENABLE KEYS */;

-- Copiando estrutura para tabela sql10463651.cofre_cofre_historico
CREATE TABLE IF NOT EXISTS `cofre_cofre_historico` (
  `cofre_codigo` bigint(20) NOT NULL,
  `cofre_historico_codigo` bigint(20) NOT NULL,
  UNIQUE KEY `UK_3u142aiblgxu2syoet5bkran` (`cofre_historico_codigo`),
  KEY `FKllo8cnq948p6ociknbrcd3qwq` (`cofre_codigo`),
  CONSTRAINT `FKllo8cnq948p6ociknbrcd3qwq` FOREIGN KEY (`cofre_codigo`) REFERENCES `cofre` (`codigo`),
  CONSTRAINT `FK609w1fwyc3xy1qq8kiuvxkn` FOREIGN KEY (`cofre_historico_codigo`) REFERENCES `cofre_historico` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela sql10463651.cofre_cofre_historico: ~0 rows (aproximadamente)
DELETE FROM `cofre_cofre_historico`;
/*!40000 ALTER TABLE `cofre_cofre_historico` DISABLE KEYS */;
/*!40000 ALTER TABLE `cofre_cofre_historico` ENABLE KEYS */;

-- Copiando estrutura para tabela sql10463651.cofre_historico
CREATE TABLE IF NOT EXISTS `cofre_historico` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `operacao` date DEFAULT NULL,
  `valor` double NOT NULL,
  `cofre_codigo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKtjkk7pgvb3sbi58vdraubxck9` (`cofre_codigo`),
  CONSTRAINT `FKtjkk7pgvb3sbi58vdraubxck9` FOREIGN KEY (`cofre_codigo`) REFERENCES `cofre` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela sql10463651.cofre_historico: ~0 rows (aproximadamente)
DELETE FROM `cofre_historico`;
/*!40000 ALTER TABLE `cofre_historico` DISABLE KEYS */;
/*!40000 ALTER TABLE `cofre_historico` ENABLE KEYS */;

-- Copiando estrutura para tabela sql10463651.conta
CREATE TABLE IF NOT EXISTS `conta` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `agencia` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `saldo_livre` double DEFAULT NULL,
  `pessoa_codigo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKmgerysb70l0va36dwmpia7b75` (`pessoa_codigo`),
  CONSTRAINT `FKmgerysb70l0va36dwmpia7b75` FOREIGN KEY (`pessoa_codigo`) REFERENCES `pessoa` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela sql10463651.conta: ~1 rows (aproximadamente)
DELETE FROM `conta`;
/*!40000 ALTER TABLE `conta` DISABLE KEYS */;
INSERT INTO `conta` (`codigo`, `agencia`, `numero`, `saldo_livre`, `pessoa_codigo`) VALUES
	(1, '0001', '10000', 2000, 1);
/*!40000 ALTER TABLE `conta` ENABLE KEYS */;

-- Copiando estrutura para tabela sql10463651.conta_cofre
CREATE TABLE IF NOT EXISTS `conta_cofre` (
  `conta_codigo` bigint(20) NOT NULL,
  `cofre_codigo` bigint(20) NOT NULL,
  UNIQUE KEY `UK_hojev8367vte8mbrxf83sk4we` (`cofre_codigo`),
  KEY `FKof57urmwy5eb8ye2id1nbfmk7` (`conta_codigo`),
  CONSTRAINT `FKof57urmwy5eb8ye2id1nbfmk7` FOREIGN KEY (`conta_codigo`) REFERENCES `conta` (`codigo`),
  CONSTRAINT `FK9peyj33mie4iu9d2a82ku40w3` FOREIGN KEY (`cofre_codigo`) REFERENCES `cofre` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela sql10463651.conta_cofre: ~0 rows (aproximadamente)
DELETE FROM `conta_cofre`;
/*!40000 ALTER TABLE `conta_cofre` DISABLE KEYS */;
INSERT INTO `conta_cofre` (`conta_codigo`, `cofre_codigo`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4);
/*!40000 ALTER TABLE `conta_cofre` ENABLE KEYS */;

-- Copiando estrutura para tabela sql10463651.pessoa
CREATE TABLE IF NOT EXISTS `pessoa` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `conta_codigo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKmaw57fo4i9ggxcu67c9llu8jo` (`conta_codigo`),
  CONSTRAINT `FKmaw57fo4i9ggxcu67c9llu8jo` FOREIGN KEY (`conta_codigo`) REFERENCES `conta` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela sql10463651.pessoa: ~1 rows (aproximadamente)
DELETE FROM `pessoa`;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` (`codigo`, `email`, `nome`, `senha`, `conta_codigo`) VALUES
	(1, 'professor@fiap.com.br', 'Professor Rubens', '123456', NULL);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;

-- Copiando estrutura para tabela sql10463651.pessoa_promocao
CREATE TABLE IF NOT EXISTS `pessoa_promocao` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL,
  `pessoa_codigo` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK2k1cptc5crspfdkwtavncvuwd` (`pessoa_codigo`),
  CONSTRAINT `FK2k1cptc5crspfdkwtavncvuwd` FOREIGN KEY (`pessoa_codigo`) REFERENCES `pessoa` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela sql10463651.pessoa_promocao: ~0 rows (aproximadamente)
DELETE FROM `pessoa_promocao`;
/*!40000 ALTER TABLE `pessoa_promocao` DISABLE KEYS */;
INSERT INTO `pessoa_promocao` (`codigo`, `valor`, `pessoa_codigo`) VALUES
	(1, 100, 1);
/*!40000 ALTER TABLE `pessoa_promocao` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
