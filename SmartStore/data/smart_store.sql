-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 18, 2017 at 08:12 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `smart_store`
--
CREATE DATABASE IF NOT EXISTS `smart_store` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `smart_store`;

-- --------------------------------------------------------

--
-- Table structure for table `clients`
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
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`id`, `firstname`, `lastname`, `address`, `family`, `zip`, `wilaya`, `city`, `mobile`, `phone`, `fax`, `mail`, `website`, `mode`, `bank_account`, `credit`, `credit_limit`, `NRC`, `NART`, `NIF`, `NIS`, `RIB`) VALUES
(4, 'Oussama', 'ABBAS', 'HAI KHOBZI BISKRA', 'Cosmitique', '07000', 6, 7, '0550200150', '033679511', '033679509', 'absosm@gmail.com', 'www.absosm.com', 4, '3772888011234', 15000, 10000, '349017728', '321672882', '897639201124', '1235623', '22391032738');

-- --------------------------------------------------------

--
-- Table structure for table `families`
--

CREATE TABLE IF NOT EXISTS `families` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `designation` varchar(100) COLLATE utf8_bin NOT NULL,
  `note` varchar(200) COLLATE utf8_bin NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Dumping data for table `families`
--

INSERT INTO `families` (`id`, `designation`, `note`, `count`) VALUES
(1, 'alé;lsmdkfdmsl', '(vide)', 0),
(4, 'sdfsdf', 'sdfsdfsdfsdf', 0);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `barcode` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `family` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `unit` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `count` int(10) DEFAULT NULL,
  `used` int(10) DEFAULT NULL,
  `min` int(10) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `selling` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `selling_limit` double DEFAULT NULL,
  `tva` double DEFAULT NULL,
  `store_date` date DEFAULT NULL,
  `expire` tinyint(1) NOT NULL,
  `expiration` date DEFAULT NULL,
  `delay_exp` int(10) DEFAULT NULL,
  `packing` int(10) DEFAULT NULL,
  `location` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `shelf` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `path_image` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `providers`
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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Dumping data for table `providers`
--

INSERT INTO `providers` (`id`, `firstname`, `lastname`, `address`, `family`, `zip`, `wilaya`, `city`, `mobile`, `phone`, `fax`, `mail`, `website`, `mode`, `bank_account`, `credit`, `NRC`, `NART`, `NIF`, `NIS`, `RIB`) VALUES
(2, 'Oussama', 'ABBAS', 'HAI KHOBZI', '', '07000', 6, 0, '0550200150', '', '', '', '', 0, '', 15000, '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
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
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `firstname`, `lastname`, `telephone`, `privilege`, `last_login`) VALUES
(1, 'admin', 'e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855', 'ABBAS', 'Oussama', '0550200150', 1, '2017-12-18 00:39:14');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
