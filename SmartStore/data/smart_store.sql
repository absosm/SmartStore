-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Jeu 14 Décembre 2017 à 18:48
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `smart_store`
--
CREATE DATABASE IF NOT EXISTS `smart_store` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `smart_store`;

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) COLLATE utf8_bin NOT NULL,
  `lastname` varchar(50) COLLATE utf8_bin NOT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `family` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `zip` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `wilaya` tinyint(4) DEFAULT NULL,
  `city` tinyint(4) DEFAULT NULL,
  `mobile` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `fax` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `mail` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `website` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mode` int(10) DEFAULT '0',
  `bank_account` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `credit` double NOT NULL DEFAULT '0',
  `credit_limit` double DEFAULT '0',
  `NRC` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `NART` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `NIF` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `NIS` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `RIB` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Contenu de la table `clients`
--

INSERT INTO `clients` (`id`, `firstname`, `lastname`, `address`, `family`, `zip`, `wilaya`, `city`, `mobile`, `phone`, `fax`, `mail`, `website`, `mode`, `bank_account`, `credit`, `credit_limit`, `NRC`, `NART`, `NIF`, `NIS`, `RIB`) VALUES
(4, 'Oussama', 'ABBAS', 'HAI KHOBZI BISKRA', 'Cosmitique', '07000', 6, 7, '0550200150', '033679511', '033679509', 'absosm@gmail.com', 'www.absosm.com', 4, '3772888011234', 15000, 10000, '349017728', '321672882', '897639201124', '1235623', '22391032738');

-- --------------------------------------------------------

--
-- Structure de la table `families`
--

CREATE TABLE IF NOT EXISTS `families` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `designation` varchar(100) COLLATE utf8_bin NOT NULL,
  `note` varchar(200) COLLATE utf8_bin NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Contenu de la table `families`
--

INSERT INTO `families` (`id`, `designation`, `note`, `count`) VALUES
(1, 'alé;lsmdkfdmsl', '(vide)', 0),
(4, 'sdfsdf', 'sdfsdfsdfsdf', 0),
(3, 'ghfgfggh', '(vide)', 0);

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

CREATE TABLE IF NOT EXISTS `produits` (
  `Id_produit` int(11) NOT NULL,
  `Code_produit` int(20) NOT NULL,
  `Famille` varchar(50) COLLATE utf8_bin NOT NULL,
  `Prix_vent1` double NOT NULL,
  `Prix_vent2` double NOT NULL,
  `Prix_vent3` double NOT NULL,
  `Prix_vent4` double NOT NULL,
  `Prix_vent5` double NOT NULL,
  `Prix_vent6` double NOT NULL,
  `Stock_actuel` double NOT NULL,
  `Date_premption` date NOT NULL,
  `Nbr_jours_Alerte` int(10) NOT NULL,
  `Stock_min` double NOT NULL,
  `Unite_mesure` varchar(25) COLLATE utf8_bin NOT NULL,
  `Depot/magasin` varchar(50) COLLATE utf8_bin NOT NULL,
  `colissage` double NOT NULL,
  `TVA` double NOT NULL,
  `localisation_Rayonnage` varchar(50) COLLATE utf8_bin NOT NULL,
  `Limite_prix_vente` double NOT NULL,
  PRIMARY KEY (`Id_produit`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `providers`
--

CREATE TABLE IF NOT EXISTS `providers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) COLLATE utf8_bin NOT NULL,
  `lastname` varchar(50) COLLATE utf8_bin NOT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `family` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `zip` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `wilaya` tinyint(4) DEFAULT NULL,
  `city` tinyint(4) DEFAULT NULL,
  `mobile` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `fax` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `mail` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `website` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mode` int(10) DEFAULT '0',
  `bank_account` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `credit` double NOT NULL DEFAULT '0',
  `NRC` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `NART` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `NIF` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `NIS` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `RIB` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

--
-- Contenu de la table `providers`
--

INSERT INTO `providers` (`id`, `firstname`, `lastname`, `address`, `family`, `zip`, `wilaya`, `city`, `mobile`, `phone`, `fax`, `mail`, `website`, `mode`, `bank_account`, `credit`, `NRC`, `NART`, `NIF`, `NIS`, `RIB`) VALUES
(1, 'Oussama', 'ABBAS', 'HAI KHOBZI', '', '0', 6, 0, '0550200150', '', '', '', '', 0, '', 0, '', '', '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `firstname` varchar(50) COLLATE utf8_bin NOT NULL,
  `lastname` varchar(50) COLLATE utf8_bin NOT NULL,
  `telephone` varchar(15) COLLATE utf8_bin NOT NULL,
  `privilege` int(11) NOT NULL,
  `last_login` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `firstname`, `lastname`, `telephone`, `privilege`, `last_login`) VALUES
(1, 'admin', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', 'ABBAS', 'Oussama', '0550200150', 1, '2017-12-14 19:05:04');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
