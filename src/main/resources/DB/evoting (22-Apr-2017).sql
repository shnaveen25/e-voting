-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 22, 2017 at 05:18 PM
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `assembly_constituency`
--

INSERT INTO `assembly_constituency` (`id`, `district_id`, `assembly`) VALUES
(1, 2, 'Yelahanka'),
(2, 2, 'K.R.Puram'),
(3, 2, 'Yeshawanthapura'),
(4, 2, 'Vijayanagara'),
(5, 2, 'Rajajinagar'),
(6, 2, 'Banashankari');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `assembly_district`
--

INSERT INTO `assembly_district` (`id`, `state_id`, `district_name`) VALUES
(1, 1, 'Bagalkot'),
(2, 1, 'Bengaluru Urban'),
(3, 1, 'Bengaluru Rural'),
(4, 1, 'Belagavi'),
(5, 1, 'Bellary'),
(6, 1, 'Bidar');

-- --------------------------------------------------------

--
-- Table structure for table `assembly_states`
--

CREATE TABLE IF NOT EXISTS `assembly_states` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `assembly_states`
--

INSERT INTO `assembly_states` (`id`, `state_name`) VALUES
(1, 'Karnataka'),
(2, 'Maharastra'),
(3, 'Andhra'),
(4, 'Goa');

-- --------------------------------------------------------

--
-- Table structure for table `election`
--

CREATE TABLE IF NOT EXISTS `election` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `state_id` int(11) NOT NULL,
  `election_for` varchar(45) NOT NULL,
  `election_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `election`
--

INSERT INTO `election` (`id`, `state_id`, `election_for`, `election_date`, `status`, `created_date`) VALUES
(4, 1, 'generalElection', '2017-04-29 18:30:00', 'upcoming_election', '2017-04-21 17:59:24'),
(5, 2, 'generalElection', '2017-04-22 11:16:48', 'upcoming_election', '2017-04-21 18:06:47'),
(6, 1, 'generalElection', '2017-04-28 18:30:00', 'upcoming_election', '2017-04-21 18:08:20');

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`,`adhaar_num`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `election_participants`
--

INSERT INTO `election_participants` (`id`, `party_Id`, `state_id`, `district_id`, `assembly_id`, `election_id`, `name`, `email`, `dob`, `gender`, `post`, `education`, `property`, `police_record`, `adhaar_num`, `address`, `created_date`, `mobile`) VALUES
(1, 1, 0, 0, 0, 0, 'Naveen', 'sh.naveen16@gmail.com', NULL, 'male', 'mla', 'MCA', '1000000', 'yes', '1234567965', 'Bangalore', '2017-03-24 05:25:25', '9901155929'),
(2, 2, 0, 0, 0, 0, 'Naveen', 'naveen.heroorkar@janata.com', NULL, 'male', 'mla', 'MCA', '1000000', 'no', '1234567965', 'Bangalore', '2017-03-24 06:11:05', '9901155929'),
(4, 1, 0, 0, 0, 0, 'Ajit', 'ajit@gmail.com', NULL, 'male', 'mla', 'MCA', '1000000', 'no', '1234567965', 'Bangalore', '2017-03-24 07:06:55', '888888888'),
(6, 2, 1, 1, 6, 0, 'Ajit', 'valkeriajeet@gmail.com', NULL, 'male', 'mla', 'MCA', '100000', 'no', '123456', 'Bangalore', '2017-04-21 09:37:02', '9999999999'),
(8, 1, 1, 1, 5, 0, 'Naveen ', 'sh.naveen25@gmail.com', '1990-12-31 18:30:00', 'male', 'mla', 'MCA', '100000', 'no', '123456', 'Bangalore', '2017-04-21 10:15:42', '9901155929'),
(9, 1, 1, 2, 3, 6, 'Akshay', 'akshay.biradar7@gmail.com', '2003-06-17 18:30:00', 'male', 'mla', 'MCA', '100000', 'no', '1234564', 'Bangalore', '2017-04-22 11:39:05', '1234567896');

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
  `dob` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `elector`
--

INSERT INTO `elector` (`id`, `application_id`, `elector_id`, `password`, `state_id`, `district_id`, `assembly_id`, `name`, `dob`, `gender`, `mobile`, `email`, `aadhar`, `address`, `land_mark`, `pin_code`, `status`, `created_date`) VALUES
(13, 1, 'KA2017BE123456789123', '', 1, 2, 6, ' Ajit Velkari', '2017-04-21 18:08:04', 'male', '9901155929', 'valkeriajeet@gmail.com', '123456789123', 'Dwarka Nagar , Hoskarahalli', 'St.Peters school', '560085', 'active', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `party_description`
--

CREATE TABLE IF NOT EXISTS `party_description` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `party_name` varchar(100) NOT NULL,
  `party_description` varchar(256) DEFAULT NULL,
  `mp_members` varchar(256) DEFAULT NULL,
  `mla_members` varchar(256) DEFAULT NULL,
  `email` varchar(256) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `party_name` (`party_name`,`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `party_description`
--

INSERT INTO `party_description` (`id`, `party_name`, `party_description`, `mp_members`, `mla_members`, `email`, `created_date`) VALUES
(1, 'BJP', ' Some Text', 'aba,ds,ds,dsa', 'ss,as,asas,as', 'sh.naveen25@gmail.com', '2017-03-09 17:24:16'),
(2, 'Janata', 'bhjavfhafaf', 'abc,ddd,d,d,dd', 'ss,as,as,as,as', 'janata@gmail.com', '2017-03-24 06:10:00');

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
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `mobile`, `created_date`) VALUES
(2, 'Naveen', 'sh.naveen25@gmail.com', '411991', '9886239696', '2017-04-01 10:00:58');

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
  `dob` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `voters_applications`
--

INSERT INTO `voters_applications` (`id`, `applied_by`, `state_id`, `district_id`, `assembly_id`, `name`, `dob`, `gender`, `mobile`, `email`, `aadhar`, `address`, `land_mark`, `pin_code`, `application_status`, `comment`, `created_date`, `applied_for`) VALUES
(1, 2, 1, 2, 6, ' Ajit Velkari', '2017-04-21 09:01:11', 'male', '9901155929', 'valkeriajeet@gmail.com', '123456789123', 'Dwarka Nagar , Hoskarahalli', 'St.Peters school', '560085', 'accepted', 'Congrats..\nYour Application has been accepted...\nPlease keep elector id number for voting ', NULL, 'including');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
