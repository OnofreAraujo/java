-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Máquina: localhost
-- Data de Criação: 26-Jun-2019 às 23:23
-- Versão do servidor: 5.6.13
-- versão do PHP: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `projeto`
--
CREATE DATABASE IF NOT EXISTS `projeto` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `projeto`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `conteudos`
--

CREATE TABLE IF NOT EXISTS `conteudos` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `materia` varchar(25) NOT NULL,
  `titulo` varchar(80) NOT NULL,
  `conteudo` text NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `materias`
--

CREATE TABLE IF NOT EXISTS `materias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `materia` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Extraindo dados da tabela `materias`
--

INSERT INTO `materias` (`id`, `materia`) VALUES
(1, 'biologia'),
(2, 'design'),
(3, 'educacao fisica'),
(4, 'filosofia'),
(5, 'fisica'),
(6, 'geografia'),
(7, 'banco de dados'),
(8, 'historia'),
(9, 'espanhol'),
(10, 'ingles'),
(11, 'português'),
(12, 'matematica'),
(13, 'robotica'),
(14, 'java'),
(15, 'PHP/MYSQL'),
(16, 'java script'),
(17, 'quimica'),
(18, 'redes de computadores'),
(19, 'sistemas operacionais'),
(20, 'sociologia');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `privilegios` int(2) NOT NULL DEFAULT '0',
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
