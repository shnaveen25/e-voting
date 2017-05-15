-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 12, 2017 at 04:51 PM
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `assembly_constituency`
--

INSERT INTO `assembly_constituency` (`id`, `district_id`, `assembly`) VALUES
(1, 2, 'Yelahanka'),
(2, 2, 'K.R.Puram'),
(3, 2, 'Yeshawanthapura'),
(4, 2, 'Vijayanagara'),
(5, 2, 'Rajajinagar'),
(6, 2, 'Banashankari'),
(7, 7, 'Andheri');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `assembly_district`
--

INSERT INTO `assembly_district` (`id`, `state_id`, `district_name`) VALUES
(1, 1, 'Bagalkot'),
(2, 1, 'Bengaluru Urban'),
(3, 1, 'Bengaluru Rural'),
(4, 1, 'Belagavi'),
(5, 1, 'Bellary'),
(6, 1, 'Bidar'),
(7, 2, 'Mumbai');

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
  `election_date` date NOT NULL,
  `status` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `election`
--

INSERT INTO `election` (`id`, `state_id`, `election_for`, `election_date`, `status`, `created_date`) VALUES
(4, 1, 'generalElection', '2017-04-30', 'upcoming_election', '2017-04-20 18:30:00'),
(5, 2, 'generalElection', '2017-04-22', 'upcoming_election', '2017-04-20 18:30:00'),
(6, 1, 'generalElection', '2017-05-08', 'onGoing', '2017-04-20 18:30:00'),
(7, 1, 'stateElection', '2017-05-05', 'finished', '2017-04-23 05:37:49'),
(9, 1, 'stateElection', '2017-05-07', 'finished', '2017-05-06 16:58:16'),
(26, 1, 'stateElection', '2017-05-08', 'upcoming_election', '2017-05-07 09:58:37');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Dumping data for table `election_participants`
--

INSERT INTO `election_participants` (`id`, `party_Id`, `state_id`, `district_id`, `assembly_id`, `election_id`, `name`, `email`, `dob`, `gender`, `post`, `education`, `property`, `police_record`, `adhaar_num`, `address`, `created_date`, `mobile`, `no_of_votes`) VALUES
(9, 1, 1, 2, 6, 6, 'Akshay', 'akshay.biradar7@gmail.com', '2003-12-17 18:30:00', 'male', 'mla', 'MCA', '100000', 'no', '1234564', 'Bangalore', '2017-04-22 11:39:05', '1234567896', 1),
(13, 1, 1, 2, 6, 9, 'Bharat', 'bharat@gmail.com', '1992-01-03 18:30:00', 'male', 'mla', 'graduate', '1000000', 'no', '478512369856', 'bsk 3rd stage', '2017-05-06 17:03:04', '8745693210', 7),
(14, 10, 1, 2, 6, 9, 'Ramesh', 'ramesh@gmail.com', '1990-02-13 18:30:00', 'male', 'mla', 'graduate', '1000000', 'no', '963012547854', 'bsk', '2017-05-06 17:04:27', '9874563217', 0),
(15, 11, 1, 2, 6, 9, 'Siddu', 'siddu@gmail.com', '1988-07-13 18:30:00', 'male', 'mla', 'graduate', '1000000', 'no', '123456456710', 'bsk', '2017-05-06 17:06:32', '8745963210', 1),
(16, 12, 1, 2, 6, 9, 'pragnyanand', 'pragnya@gmail.com', '1993-06-15 18:30:00', 'male', 'mla', 'graduate', '1000000', 'no', '123456412465', 'bsk', '2017-05-06 17:07:55', '8965742130', 3),
(29, 1, 1, 2, 2, 26, 'karthik', 'sh.naveen25@gmail.com', '2017-05-16 18:30:00', 'male', 'mp', 'MCA', '100000', 'no', '123456456775', 'Bangalore', '2017-05-08 11:14:33', '9901155929', 0),
(45, 1, 1, 2, 6, 26, 'Naveen ', 'sh.naveen25@gmail.com', '2017-05-02 18:30:00', 'male', 'mla', 'MCA', '100000', 'no', '123456', 'asdcvfsa', '2017-05-12 05:57:31', '9901155929', 0);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `elector`
--

INSERT INTO `elector` (`id`, `application_id`, `elector_id`, `password`, `state_id`, `district_id`, `assembly_id`, `name`, `dob`, `gender`, `mobile`, `email`, `aadhar`, `address`, `land_mark`, `pin_code`, `status`, `created_date`) VALUES
(13, 1, 'KA2017BE123456789123', '411991', 1, 2, 6, ' Ajit Velkari', '2017-04-23', 'male', '9901155929', 'valkeriajeet@gmail.com', '123456789123', 'Dwarka Nagar , Hoskarahalli', 'St.Peters school', '560085', 'active', NULL),
(14, 3, 'KA2017BE123456789632', '2hw1yk', 1, 2, 6, 'karthik iyer', '2017-05-07', 'male', '9986745123', 'karthik@gmail.com', '123456789632', 'something , something', 'St.Peters school', '560085', 'inactive', '2017-04-23 18:01:47'),
(23, 17, 'KA2017BE852346179624', 'a0qgvo', 1, 2, 6, 'jagannath c', '1993-07-17', 'male', '8456321079', 'jagannath@gmail.com', '852346179624', 'something , something', 'pes college', '560085', 'active', '2017-05-06 17:17:59'),
(24, 19, 'KA2017BE785498566325', 'ywsyku', 1, 2, 6, 'Gaurav s', '1994-05-10', 'male', '74115896324', 'gaurav@gmail.com', '785498566325', 'something , something', 'pes college', '560085', 'active', '2017-05-06 17:18:07'),
(25, 21, 'KA2017BE474589632104', 'jqx4lq', 1, 2, 6, 'Durgesh s', '1993-06-01', 'male', '8745693210', 'durgesh@gmail.com', '474589632104', 'something , something', 'pes college', '560085', 'active', '2017-05-06 17:18:24'),
(30, 2, 'KA2017BE12345678912', 'xmcgqi', 1, 2, 1, 'Naveen  Heroorkar', '1991-01-04', 'male', '9901155929', 'sh.naveen16@gmail.com', '12345678912', 'dvdfgxh , fgxngfnhfgngf', 'St.Peters school', '560085', 'active', '2017-05-08 04:41:08');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(49),
(49),
(49),
(49),
(49),
(49),
(49),
(49),
(49),
(49);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=38 ;

--
-- Dumping data for table `party_description`
--

INSERT INTO `party_description` (`id`, `party_name`, `party_description`, `mp_members`, `mla_members`, `email`, `created_date`) VALUES
(1, 'BJP', 'The BJP''s origins lie in the Bharatiya Jana Sangh, popularly known as the Jana Sangh, founded by Syama Prasad Mookerjee in 1951 in response to the politics of the dominant Congress party. It was founded in collaboration with the Hindu nationalist volunteer organisation, the Rashtriya Swayamsevak Sangh (RSS), and was widely regarded as the political arm of the RSS.', 'aba,ds,ds,dsa', 'ss,as,asas,as', 'sh.naveen25@gmail.com', '2017-03-09 17:24:16'),
(10, 'Congress', 'The Congress was founded in December 1885 in Bombay. Its founding members included Allan Octavian Hume, who had chalked out the idea in an open letter to graduates of the University of Calcutta in 1883, as well as William Wedderburn, Pherozeshah Mehta, and others. Hume took the initiative, and in March 1885 the first notice convening the first Indian National Union to meet in Poona the following December was issued', 'aa', 'bb', 'congress@gmail.com', '2017-05-06 16:59:38'),
(11, 'JDS', 'The Janata Dal (Secular), formed in 1999, had its origins in the Janata Party, founded in 1977 as a coalition of several smaller parties that combined forces to oppose the Indian National Congress. In 1988 the Janata Party and other smaller parties merged to form the Janata Dal (JD). In 1996, Janata Dal party reached its pinnacle when H. D. Deve Gowda became Prime Minister of India, heading the United Front (UF) coalition government.', 'bb', 'cc', 'jds@gmail.com', '2017-05-06 17:00:04'),
(12, 'BSP', 'The Bahujan Samaj Party (BSP) was the third largest national political party in India.[6] It was formed mainly to represent Bahujans (literally meaning "People in majority"), referring to people from the Scheduled Castes, Scheduled Tribes and Other Backward Castes (OBC), as well as religious minorities that together consist of 85 percent of India''s population but still divided into 6000 different castes', 'cc', 'dd', 'bsp@gmail.com', '2017-05-06 17:00:35'),
(37, 'aap', 'Aam Aadmi Party (AAP, English: Common Man''s Party) is an Indian political party, formally launched on 26 November 2012, and is currently the ruling party of the National Capital Territory of Delhi. It came into existence following differences between the activists Arvind Kejriwal and Anna Hazare regarding whether or not to politicise the popular India Against Corruption movement that had been demanding a Jan Lokpal Bill since 2011. Hazare preferred that the movement should remain politically unaligned while Kejriwal felt the failure of the agitation route necessitated a direct political involvement.', NULL, NULL, 'b@b.com', '2017-05-11 08:34:03');

-- --------------------------------------------------------

--
-- Table structure for table `public_vote_records`
--

CREATE TABLE IF NOT EXISTS `public_vote_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `election_id` int(11) DEFAULT NULL,
  `elector_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `public_vote_records`
--

INSERT INTO `public_vote_records` (`id`, `election_id`, `elector_id`) VALUES
(13, 9, 25),
(14, 9, 24),
(15, 9, 23),
(20, 9, 14);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=43 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `mobile`, `created_date`) VALUES
(2, 'Naveen', 'sh.naveen25@gmail.com', '411991', '9886239696', '2017-04-01 10:00:58'),
(3, 'karthik', 'karthik@gmail.com', 'karthik', '9986745213', '2017-04-23 17:58:00'),
(4, 'Akshay', 'akshay.biradar7@gmail.com', '8951799202', '8951799202', '2017-04-23 18:16:14'),
(8, 'jagannath', 'jagannath@gmail.com', 'jaggu', '8794561302', '2017-05-06 16:57:24'),
(18, 'Gaurav', 'gaurav@gmail.com', 'gaurav', '8954632154', '2017-05-06 17:11:26'),
(20, 'Durgesh', 'durgesh@gmail.com', 'durgesh', '8574693245', '2017-05-06 17:13:47'),
(22, 'Akash', 'akash@gmail.com', 'akash', '7458963210', '2017-05-06 17:16:13'),
(42, 'Naveen ', 'a@a.com', 'aaa', '9901155929', '2017-05-11 11:34:44');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=49 ;

--
-- Dumping data for table `voters_applications`
--

INSERT INTO `voters_applications` (`id`, `applied_by`, `state_id`, `district_id`, `assembly_id`, `name`, `dob`, `gender`, `mobile`, `email`, `aadhar`, `address`, `land_mark`, `pin_code`, `application_status`, `comment`, `created_date`, `applied_for`) VALUES
(1, 2, 1, 2, 6, ' Ajit   Velkari   ', '2017-05-09', 'male', '9886239696', 'sh.naveen16@gmail.com', '123456789123', 'BSK , ', 'St.Peters school', '560085', 'pending', 'Congrats..\nYour Application has been accepted...\nPlease keep elector id number for voting ', '2017-04-30 18:30:00', 'editing'),
(2, 2, 1, 2, 6, 'Naveen  Heroorkar', '1991-01-04', 'male', '9901155929', 'sh.naveen16@gmail.com', '12345678912', 'dvdfgxh , fgxngfnhfgngf', 'St.Peters school', '560085', 'accepted', '', '2017-05-09 09:23:30', 'editing'),
(3, 3, 1, 2, 4, 'karthik iyer', '1993-05-11', 'male', '9986745123', 'karthik@gmail.com', '123456789632', 'something , something', 'St.Peters school', '560085', 'accepted', '', '2017-04-23 18:00:58', 'including'),
(17, 8, 1, 2, 6, 'jagannath c', '1993-07-17', 'male', '8456321079', 'jagannath@gmail.com', '852346179624', 'something , something', 'pes college', '560085', 'accepted', '', '2017-05-06 17:10:46', 'including'),
(19, 18, 1, 2, 6, 'Gaurav s', '1994-05-10', 'male', '74115896324', 'gaurav@gmail.com', '785498566325', 'something , something', 'pes college', '560085', 'accepted', '', '2017-05-06 17:13:01', 'including'),
(21, 20, 1, 2, 6, 'Durgesh s', '1993-06-01', 'male', '8745693210', 'durgesh@gmail.com', '474589632104', 'something , something', 'pes college', '560085', 'accepted', '', '2017-05-06 17:15:32', 'including'),
(46, 0, 1, 2, 6, 'Naveen  Heroorkar', '2017-05-02', 'female', '9901155929', 'sh.naveen25@gmail.com', '0', 'asasasas , asasasasa', 'St.Peters school', '560085', 'pending', NULL, '2017-05-12 07:07:32', 'including'),
(47, 0, 1, 2, 6, 'Naveen  Heroorkar', '2017-05-01', 'female', '9901155929', 'sh.naveen25@gmail.com', '123456789124', 'ssss , ssvvvvv', 'St.Peters school', '560085', 'pending', NULL, '2017-05-12 07:10:11', 'including');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
