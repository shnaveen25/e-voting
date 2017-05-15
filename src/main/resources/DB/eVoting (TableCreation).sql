-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 12, 2017 at 04:54 PM
-- Server version: 5.6.33-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `evoting`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `email`, `password`) VALUES
(1, 'Naveen', 'sh.naveen16@gmail.com', '411991'),
(2, 'Ajit', 'valkeriajeet@gmail.com', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `assembly_constituency`
--

CREATE TABLE IF NOT EXISTS `assembly_constituency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `district_id` int(11) NOT NULL,
  `assembly` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `assembly` (`assembly`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `assembly_district`
--

CREATE TABLE IF NOT EXISTS `assembly_district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state_id` int(11) NOT NULL,
  `district_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `district_name` (`district_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `assembly_states`
--

CREATE TABLE IF NOT EXISTS `assembly_states` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `election`
--

CREATE TABLE IF NOT EXISTS `election` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state_id` int(11) NOT NULL,
  `election_for` varchar(45) NOT NULL,
  `election_date` date NOT NULL,
  `status` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `election_participants`
--

CREATE TABLE IF NOT EXISTS `election_participants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `party_Id` int(100) NOT NULL,
  `state_id` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  `assembly_id` int(11) NOT NULL,
  `election_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dob` timestamp NULL DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `post` varchar(102) NOT NULL,
  `education` varchar(100) NOT NULL,
  `property` varchar(100) NOT NULL,
  `police_record` varchar(10) NOT NULL,
  `adhaar_num` varchar(45) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `no_of_votes` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`,`adhaar_num`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `election_poll`
--

CREATE TABLE IF NOT EXISTS `election_poll` (
  `id` bigint(20) NOT NULL,
  `election_id` bigint(20) DEFAULT NULL,
  `participant_id` bigint(20) DEFAULT NULL,
  `no_of_votes` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `elector`
--

CREATE TABLE IF NOT EXISTS `elector` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_id` int(11) NOT NULL,
  `elector_id` varchar(50) NOT NULL,
  `password` varchar(45) NOT NULL,
  `state_id` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  `assembly_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(10) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `aadhar` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `land_mark` varchar(45) NOT NULL,
  `pin_code` varchar(15) NOT NULL,
  `status` varchar(20) NOT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `elector_id` (`elector_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `party_description`
--

CREATE TABLE IF NOT EXISTS `party_description` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `party_name` varchar(100) NOT NULL,
  `party_description` mediumtext,
  `mp_members` varchar(256) DEFAULT NULL,
  `mla_members` varchar(256) DEFAULT NULL,
  `email` varchar(256) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `party_name` (`party_name`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `public_vote_records`
--

CREATE TABLE IF NOT EXISTS `public_vote_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `election_id` int(11) DEFAULT NULL,
  `elector_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `voters_applications`
--

CREATE TABLE IF NOT EXISTS `voters_applications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `applied_by` int(11) NOT NULL,
  `state_id` int(11) NOT NULL,
  `district_id` int(11) NOT NULL,
  `assembly_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(10) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `aadhar` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `land_mark` varchar(45) NOT NULL,
  `pin_code` varchar(15) NOT NULL,
  `application_status` varchar(45) NOT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `applied_for` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `aadhar` (`aadhar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
