-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 08, 2014 at 08:16 PM
-- Server version: 5.00.15
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `aumninw`
--
CREATE DATABASE IF NOT EXISTS `aumninw` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `aumninw`;

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE IF NOT EXISTS `adminlogin` (
  `a_id` int(10) unsigned NOT NULL auto_increment,
  `aU_name` varchar(50) default NULL,
  `a_pwd` varchar(50) default NULL,
  PRIMARY KEY  (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `album`
--

CREATE TABLE IF NOT EXISTS `album` (
  `a_Id` int(10) unsigned NOT NULL auto_increment,
  `uplodr_Id` int(10) unsigned default NULL,
  `perm_Id` int(10) unsigned NOT NULL default '0',
  `date_time` datetime default NULL,
  `caption` varchar(200) default NULL,
  `upload_pic` varchar(50) default NULL,
  `albm_name` varchar(45) NOT NULL default '',
  `creator_Id` int(10) unsigned NOT NULL default '0',
  `albm_pic` varchar(45) NOT NULL default '',
  `details` varchar(45) NOT NULL default '',
  `creation_dttime` datetime NOT NULL default '0000-00-00 00:00:00',
  `taken_dttime` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`a_Id`),
  KEY `FK_gallary_permission` (`perm_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE IF NOT EXISTS `branch` (
  `b_Id` int(10) unsigned NOT NULL auto_increment,
  `Branch_Name` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`b_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`b_Id`, `Branch_Name`) VALUES
(1, 'Information Technology'),
(2, 'Computer Engineering'),
(3, 'Automobile Engineering'),
(4, 'Elec. & Comm. Engg.'),
(5, 'Mechanical Engineering');

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `c_Id` int(10) unsigned NOT NULL auto_increment,
  `f_Id` int(10) unsigned NOT NULL default '0',
  `cmt_data` varchar(500) default NULL,
  `m_Id` int(10) unsigned default NULL,
  `date_time` datetime default NULL,
  PRIMARY KEY  (`c_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `degree_type`
--

CREATE TABLE IF NOT EXISTS `degree_type` (
  `d_Id` int(10) unsigned NOT NULL auto_increment,
  `degree_Type` varchar(50) default NULL,
  PRIMARY KEY  (`d_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `degree_type`
--

INSERT INTO `degree_type` (`d_Id`, `degree_Type`) VALUES
(1, 'B.E'),
(2, 'M.E'),
(3, 'other');

-- --------------------------------------------------------

--
-- Table structure for table `doc_req`
--

CREATE TABLE IF NOT EXISTS `doc_req` (
  `doc_Id` int(10) unsigned NOT NULL auto_increment,
  `m_Id` int(10) unsigned default NULL,
  `data` varchar(500) default NULL,
  `date_time` datetime default NULL,
  `email_Id` varchar(50) default NULL,
  `sub` varchar(50) default NULL,
  `accept` varchar(5) default NULL,
  `pannding` varchar(5) default NULL,
  `ready` varchar(5) default NULL,
  `rejected` varchar(5) default NULL,
  PRIMARY KEY  (`doc_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `edu_details`
--

CREATE TABLE IF NOT EXISTS `edu_details` (
  `e_Id` int(10) unsigned NOT NULL auto_increment,
  `m_Id` int(10) unsigned default NULL,
  `d_Id` int(10) unsigned default NULL,
  `cource_name` varchar(50) default NULL,
  `year` varchar(50) default NULL,
  `college_name` varchar(50) default NULL,
  PRIMARY KEY  (`e_Id`),
  KEY `FK_edu_details_M_Id` (`m_Id`),
  KEY `FK_edu_details_D_Id` (`d_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `edu_details`
--

INSERT INTO `edu_details` (`e_Id`, `m_Id`, `d_Id`, `cource_name`, `year`, `college_name`) VALUES
(1, 1, 1, 'Microsoft Certified', '2006', 'B.V.M'),
(2, 1, 2, 'Java', '2008', 'SAMCDM'),
(3, 201402, 3, 'Microsoft Certified', '2010', 'A.D.I.T'),
(4, 201402, 2, 'M.e', '2008', 'G.H..Patel');

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `evnt_Id` int(10) unsigned NOT NULL auto_increment,
  `title` varchar(50) default NULL,
  `evnt_Pic` varchar(50) default NULL,
  `org_dat_time` datetime default NULL,
  `description` varbinary(500) default NULL,
  `date_time` datetime default NULL,
  PRIMARY KEY  (`evnt_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `faq`
--

CREATE TABLE IF NOT EXISTS `faq` (
  `f_Id` int(10) unsigned NOT NULL auto_increment,
  `que` varchar(200) default NULL,
  `ans` varchar(500) default NULL,
  PRIMARY KEY  (`f_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `forum`
--

CREATE TABLE IF NOT EXISTS `forum` (
  `f_Id` int(10) unsigned NOT NULL auto_increment,
  `p_sub` varchar(50) default NULL,
  `perm_Id` int(10) unsigned default NULL,
  `creator_Id` int(10) unsigned default NULL,
  `date_time` datetime default NULL,
  `reciver_Id` int(10) unsigned default NULL,
  `No_Of_cmt` int(10) unsigned default NULL,
  `desription` varchar(100) NOT NULL default '',
  `pinned_flag` int(1) unsigned NOT NULL default '0',
  `delete_flag` int(1) unsigned NOT NULL default '0',
  PRIMARY KEY  (`f_Id`),
  KEY `FK_forum_cratorId` (`creator_Id`),
  KEY `FK_forum_p_id` (`perm_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `forum`
--

INSERT INTO `forum` (`f_Id`, `p_sub`, `perm_Id`, `creator_Id`, `date_time`, `reciver_Id`, `No_Of_cmt`, `desription`, `pinned_flag`, `delete_flag`) VALUES
(1, 'Maths 1 doubt solved', 1, 1, '2013-02-03 00:00:00', NULL, 20, 'I have a doubt and now its solved', 0, 0),
(2, 'Operating system', 2, 1, '2013-06-08 00:00:00', NULL, 10, 'Does anyone have Mac OS ? ', 0, 0),
(3, 'dsds', 2, 1, '2014-03-21 12:56:11', 201402, NULL, 'sdfsd', 0, 0),
(4, 'sfds', 3, 2, '2014-03-21 13:51:21', NULL, NULL, 'ffsdfgsg', 0, 0),
(5, 'sub1', 2, 2, '2014-03-21 14:00:01', NULL, NULL, 'description', 0, 0),
(6, 'new', 2, 1, '2014-03-22 09:30:53', NULL, NULL, 'evet', 0, 0),
(7, 'subjet', 2, 1, '2014-03-22 09:34:39', 201402, NULL, 'sdfds', 0, 0),
(8, 'topic', 3, 1, '2014-03-22 09:35:54', NULL, NULL, 'desctiption testing', 0, 0),
(9, 'New Subject', 4, 2, '2014-03-22 10:51:16', 1, NULL, 'New Description', 0, 0),
(10, 'rahul', 1, 1, '2014-03-30 16:57:50', 2, NULL, '123', 0, 0),
(11, 'suraj', 2, 1, '2014-03-30 16:58:37', NULL, NULL, 'sdldbdmbvbmmm', 0, 0),
(12, 'hsdgds', 3, 1, '2014-03-30 18:48:01', 201402, NULL, 'vdvds', 0, 0),
(13, 'Jgdg', 2, 1, '2014-03-30 19:04:40', NULL, NULL, 'hhssss', 0, 0),
(14, 'JAY', 2, 1, '2014-03-30 19:05:21', NULL, NULL, 'KSGGSDGGSGSDGDSGDSGSGSDFG', 0, 0),
(15, 'Rajan', 1, 1, '2014-03-30 19:18:16', NULL, NULL, 'ddssd', 0, 0),
(16, 'akash', 2, 1, '2014-04-06 17:31:30', NULL, NULL, 'ffffffffff', 0, 0),
(17, 'newupdate', 1, 1, '2014-04-07 15:29:38', NULL, NULL, 'update', 0, 0),
(18, 'Rajan', 1, 201402, '2014-04-08 18:41:32', NULL, NULL, 'hello', 0, 0),
(19, 'at now', 2, 201402, '2014-04-08 18:41:55', NULL, NULL, 'fgdsf', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `helpsuppot`
--

CREATE TABLE IF NOT EXISTS `helpsuppot` (
  `h_Id` int(10) unsigned NOT NULL auto_increment,
  `email_Id` varchar(50) default NULL,
  `msg` varchar(500) default NULL,
  PRIMARY KEY  (`h_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `hobbies`
--

CREATE TABLE IF NOT EXISTS `hobbies` (
  `hob_id` int(10) unsigned NOT NULL auto_increment,
  `hob_name` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`hob_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `hobbies`
--

INSERT INTO `hobbies` (`hob_id`, `hob_name`) VALUES
(1, 'Reading'),
(2, 'Sleeping'),
(3, 'Traveling');

-- --------------------------------------------------------

--
-- Table structure for table `init_mod`
--

CREATE TABLE IF NOT EXISTS `init_mod` (
  `in_mod_Id` int(10) unsigned NOT NULL auto_increment,
  `b_Id` int(10) unsigned default NULL,
  `p_Id` int(10) unsigned default NULL,
  `i_Id1` int(10) unsigned default NULL,
  `i_Id2` int(10) unsigned default NULL,
  PRIMARY KEY  (`in_mod_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `init_users`
--

CREATE TABLE IF NOT EXISTS `init_users` (
  `i_Id` int(10) unsigned NOT NULL auto_increment,
  `m_Id` int(10) unsigned default NULL,
  `pwd` varchar(50) default NULL,
  PRIMARY KEY  (`i_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE IF NOT EXISTS `members` (
  `m_Id` int(10) unsigned NOT NULL auto_increment,
  `u_Id` varchar(50) default NULL,
  `pwd` varchar(50) default NULL,
  `f_name` varchar(50) default NULL,
  `m_name` varchar(50) default NULL,
  `l_name` varchar(50) default NULL,
  `dob` datetime default NULL,
  `email_Id` varchar(50) default NULL,
  `enr_No` varchar(50) default NULL,
  `Mob_No` varchar(15) default NULL,
  `gender` char(1) default NULL,
  `acc_type` int(1) unsigned default NULL,
  `hobbies` varchar(100) default NULL,
  `profile_pic` varchar(50) default NULL,
  `b_Id` int(10) unsigned default NULL,
  `p_Id` int(10) unsigned default NULL,
  `highest_degree` varchar(45) default NULL,
  `first_login` int(1) unsigned default NULL,
  `add1` varchar(45) default NULL,
  `add2` varchar(45) default NULL,
  `tot_exp_month` varchar(45) default NULL,
  `tot_exp_year` varchar(45) default NULL,
  `keyskills` varchar(100) default NULL,
  `mod_Id` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`m_Id`),
  KEY `FK_members_branch` (`b_Id`),
  KEY `FK_members_passout` (`p_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=201403 ;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`m_Id`, `u_Id`, `pwd`, `f_name`, `m_name`, `l_name`, `dob`, `email_Id`, `enr_No`, `Mob_No`, `gender`, `acc_type`, `hobbies`, `profile_pic`, `b_Id`, `p_Id`, `highest_degree`, `first_login`, `add1`, `add2`, `tot_exp_month`, `tot_exp_year`, `keyskills`, `mod_Id`) VALUES
(1, 'rahulp', '123', 'rahul', 's', 'prajapati', '2014-03-05 12:03:00', 'rahul@gmail.com', '123', '123123132', 'M', 0, 'h1,h2', 'image/rahulp.jpg', 2, 1, 'B.E', 1, 'address1', 'address2', '2', '3', 'ket1', 2),
(2, 'jayj', '1234', 'jay', 'n', 'jari', '2014-03-05 12:03:00', 'jay.jariwala@gmail.com', '007', '9992012473', 'M', 0, 'h2,h4', 'image/jayj.jpg', 4, 1, 'B.E', 1, 'add2', 'add34', '9', '1', 'key22', 0),
(5, 'suraj', 'suraj', 'iiiiiii', 'dfff', 'ddkkj', '1993-10-20 00:00:00', 'dsfds@fdfs.fdf', '10053011033', '3338822888', 'm', 1, 'ii', 'suraj.png', 1, 1, 'M.E', 1, 'sdf', 'kkjjj', '7', '2', 'kjfjfj', 0),
(201402, '2002029', 'rajan', 'resh', 'Gopalbhai', 'Shah', '1993-10-20 00:00:00', 'asfsdf@sfds.com', '100530116042', '8844288442', 'm', 1, 'music', 'rajan.png', 1, 2, 'M.E', 0, 'sddfdsfssf', 'surat', '3', '6', 'je lakhe te', 2);

-- --------------------------------------------------------

--
-- Table structure for table `member_hob`
--

CREATE TABLE IF NOT EXISTS `member_hob` (
  `mh_id` int(10) unsigned NOT NULL auto_increment,
  `m_id` int(10) unsigned NOT NULL default '0',
  `hob_id` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`mh_id`),
  KEY `FK_member_hob_mId` (`m_id`),
  KEY `FK_member_hob_hId` (`hob_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `member_hob`
--

INSERT INTO `member_hob` (`mh_id`, `m_id`, `hob_id`) VALUES
(1, 1, 2),
(2, 1, 3),
(3, 1, 1),
(4, 201402, 2),
(5, 201402, 1);

-- --------------------------------------------------------

--
-- Table structure for table `moderator`
--

CREATE TABLE IF NOT EXISTS `moderator` (
  `mod_Id` int(10) unsigned NOT NULL auto_increment,
  `m_Id` int(10) unsigned default NULL,
  `mod_Id1` int(10) unsigned default NULL,
  `mod_Id2` int(10) unsigned default NULL,
  PRIMARY KEY  (`mod_Id`),
  KEY `FK_moderator_1` (`mod_Id1`),
  KEY `FK_moderator_2` (`mod_Id2`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `moderator`
--

INSERT INTO `moderator` (`mod_Id`, `m_Id`, `mod_Id1`, `mod_Id2`) VALUES
(1, 201402, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `modrequest`
--

CREATE TABLE IF NOT EXISTS `modrequest` (
  `R_Id` int(10) unsigned NOT NULL auto_increment,
  `m_id` int(10) unsigned NOT NULL default '0',
  `mod_id1` int(10) unsigned default NULL,
  `mod_id2` int(10) unsigned default NULL,
  PRIMARY KEY  (`R_Id`),
  KEY `FK_modrequest_mid` (`m_id`),
  KEY `FK_modrequest_mod1` (`mod_id1`),
  KEY `FK_modrequest_mod2` (`mod_id2`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `modrequest`
--

INSERT INTO `modrequest` (`R_Id`, `m_id`, `mod_id1`, `mod_id2`) VALUES
(1, 1, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE IF NOT EXISTS `news` (
  `n_Id` int(10) unsigned NOT NULL auto_increment,
  `title` varchar(50) default NULL,
  `description` varchar(200) default NULL,
  `hide` varchar(50) default NULL,
  `date_time` datetime default NULL,
  PRIMARY KEY  (`n_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `passout_year`
--

CREATE TABLE IF NOT EXISTS `passout_year` (
  `p_Id` int(10) unsigned NOT NULL auto_increment,
  `Passout_yr` varchar(50) default NULL,
  PRIMARY KEY  (`p_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `passout_year`
--

INSERT INTO `passout_year` (`p_Id`, `Passout_yr`) VALUES
(1, '2001'),
(2, '2002'),
(3, '2003'),
(4, '2004'),
(5, '2005'),
(6, '2006'),
(7, '2007'),
(8, '2008'),
(9, '2009'),
(10, '2010'),
(11, '2011'),
(12, '2012'),
(13, '2013'),
(14, '2014'),
(15, '2015');

-- --------------------------------------------------------

--
-- Table structure for table `permision`
--

CREATE TABLE IF NOT EXISTS `permision` (
  `perm_Id` int(10) unsigned NOT NULL auto_increment,
  `perm_Name` varchar(50) default NULL,
  PRIMARY KEY  (`perm_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `permision`
--

INSERT INTO `permision` (`perm_Id`, `perm_Name`) VALUES
(1, 'public'),
(2, 'batch'),
(3, 'year'),
(4, 'branch'),
(5, 'private');

-- --------------------------------------------------------

--
-- Table structure for table `photos`
--

CREATE TABLE IF NOT EXISTS `photos` (
  `ph_Id` int(10) unsigned NOT NULL auto_increment,
  `a_Id` int(10) unsigned NOT NULL default '0',
  `ph_title` varchar(45) NOT NULL default '',
  `picture_loc` varchar(45) NOT NULL default '',
  `creator_Id` int(10) unsigned NOT NULL default '0',
  `catption` varchar(45) NOT NULL default '',
  `perm_Id` int(10) unsigned NOT NULL default '0',
  `creation_dttime` datetime NOT NULL default '0000-00-00 00:00:00',
  `taken_dttime` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`ph_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `proff_details`
--

CREATE TABLE IF NOT EXISTS `proff_details` (
  `pr_Id` int(10) unsigned NOT NULL auto_increment,
  `m_Id` int(10) unsigned default NULL,
  `designation` varchar(50) default NULL,
  `fun_Area` varchar(50) default NULL,
  `start_month` varchar(45) NOT NULL default '',
  `start_year` varchar(45) NOT NULL default '',
  `end_month` varchar(45) NOT NULL default '',
  `end_year` varchar(45) NOT NULL default '',
  `industry_name` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`pr_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `proff_details`
--

INSERT INTO `proff_details` (`pr_Id`, `m_Id`, `designation`, `fun_Area`, `start_month`, `start_year`, `end_month`, `end_year`, `industry_name`) VALUES
(1, 201402, 'perment', 'Programmer', 'May', '2002', 'May', '2003', 'Insfosys'),
(2, 201402, 'Temp', 'Developer', 'May', '2004', 'April', '2006', 'IDEA');

-- --------------------------------------------------------

--
-- Table structure for table `rejected_users`
--

CREATE TABLE IF NOT EXISTS `rejected_users` (
  `rejectedUID` int(11) NOT NULL auto_increment,
  `enr_no` int(11) NOT NULL,
  `f_name` varchar(45) NOT NULL default '',
  `l_name` varchar(45) NOT NULL default '',
  `gender` char(1) NOT NULL default '',
  `dob` datetime default NULL,
  `email_Id` varchar(45) NOT NULL default '',
  `p_id` int(10) unsigned NOT NULL default '0',
  `b_id` int(10) unsigned NOT NULL default '0',
  `email_verify` int(1) unsigned NOT NULL default '0',
  PRIMARY KEY  (`rejectedUID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `rejected_users`
--

INSERT INTO `rejected_users` (`rejectedUID`, `enr_no`, `f_name`, `l_name`, `gender`, `dob`, `email_Id`, `p_id`, `b_id`, `email_verify`) VALUES
(1, 123, 'Rajan', 'Patel', 'M', '2014-03-06 00:00:00', 'rajan@gmail.com', 3, 3, 0),
(2, 32, 'new', 'one', 'F', '2014-02-26 00:00:00', 'new@nsw.sdf', 2, 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `repoted_users`
--

CREATE TABLE IF NOT EXISTS `repoted_users` (
  `rept_Id` int(10) unsigned NOT NULL auto_increment,
  `Repoted_UId` int(10) unsigned default NULL,
  `Repoter_UId` int(10) unsigned default NULL,
  `issu_msg` varchar(500) default NULL,
  `wrng_msg` varchar(500) default NULL,
  `ban` varchar(50) default NULL,
  PRIMARY KEY  (`rept_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `requested_users`
--

CREATE TABLE IF NOT EXISTS `requested_users` (
  `R_Id` int(10) unsigned NOT NULL auto_increment,
  `f_name` varchar(50) default NULL,
  `l_name` varchar(50) default NULL,
  `gender` varchar(50) default NULL,
  `dob` date default NULL,
  `email_Id` varchar(50) default NULL,
  `p_Id` int(10) unsigned default NULL,
  `b_Id` int(10) unsigned default NULL,
  `enr_No` varchar(50) default NULL,
  `accept` varchar(50) default NULL,
  `reject` varchar(50) default NULL,
  `mod_Id1` int(10) unsigned default NULL,
  `mod_Id2` int(10) unsigned default NULL,
  PRIMARY KEY  (`R_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `tempuserdata`
--

CREATE TABLE IF NOT EXISTS `tempuserdata` (
  `tempUID` int(11) NOT NULL auto_increment,
  `enr_no` varchar(45) NOT NULL default '',
  `f_name` varchar(45) NOT NULL default '',
  `l_name` varchar(45) NOT NULL default '',
  `gender` char(1) NOT NULL default '',
  `dob` datetime default NULL,
  `email_Id` varchar(45) NOT NULL default '',
  `p_id` int(10) unsigned NOT NULL default '0',
  `b_id` int(10) unsigned NOT NULL default '0',
  `email_verify` int(1) unsigned NOT NULL default '0',
  PRIMARY KEY  (`tempUID`),
  KEY `FK_tempuserdata_1` (`p_id`),
  KEY `FK_tempuserdata_2` (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 3072 kB; (`b_id`) REFER `aumninw/branch`(`b_Id`' AUTO_INCREMENT=19 ;

--
-- Dumping data for table `tempuserdata`
--

INSERT INTO `tempuserdata` (`tempUID`, `enr_no`, `f_name`, `l_name`, `gender`, `dob`, `email_Id`, `p_id`, `b_id`, `email_verify`) VALUES
(14, '344', 'suraj', 'davariya', 'M', '2014-03-21 00:00:00', 'suarj@gmail.com', 2, 5, 0),
(15, '88', 'sdgodsg', 'kfgflk', 'M', '2014-03-06 12:03:00', 'jvsvs@#v.fsdkm', 3, 3, 0),
(17, 'jvfkj', 'ooo', 'fkjj', 'M', '2014-02-27 12:02:00', 'kjjmbjh@hhj.gh', 4, 4, 0),
(18, 'h33', 'gjsdgsfjo', 'fdjifd', 'M', '2014-03-05 12:03:00', 'oivsdj@fdlj.dkfd', 4, 3, 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `FK_gallary_permission` FOREIGN KEY (`perm_Id`) REFERENCES `permision` (`perm_Id`);

--
-- Constraints for table `edu_details`
--
ALTER TABLE `edu_details`
  ADD CONSTRAINT `FK_edu_details_D_Id` FOREIGN KEY (`d_Id`) REFERENCES `degree_type` (`d_Id`),
  ADD CONSTRAINT `FK_edu_details_M_Id` FOREIGN KEY (`m_Id`) REFERENCES `members` (`m_Id`);

--
-- Constraints for table `forum`
--
ALTER TABLE `forum`
  ADD CONSTRAINT `FK_forum_cratorId` FOREIGN KEY (`creator_Id`) REFERENCES `members` (`m_Id`),
  ADD CONSTRAINT `FK_forum_perm_Id` FOREIGN KEY (`perm_Id`) REFERENCES `permision` (`perm_Id`);

--
-- Constraints for table `members`
--
ALTER TABLE `members`
  ADD CONSTRAINT `FK_members_branch` FOREIGN KEY (`b_Id`) REFERENCES `branch` (`b_Id`),
  ADD CONSTRAINT `FK_members_passout` FOREIGN KEY (`p_Id`) REFERENCES `passout_year` (`p_Id`);

--
-- Constraints for table `member_hob`
--
ALTER TABLE `member_hob`
  ADD CONSTRAINT `FK_member_hob_hId` FOREIGN KEY (`hob_id`) REFERENCES `hobbies` (`hob_id`),
  ADD CONSTRAINT `FK_member_hob_mId` FOREIGN KEY (`m_id`) REFERENCES `members` (`m_Id`);

--
-- Constraints for table `moderator`
--
ALTER TABLE `moderator`
  ADD CONSTRAINT `FK_moderator_1` FOREIGN KEY (`mod_Id1`) REFERENCES `moderator` (`mod_Id`),
  ADD CONSTRAINT `FK_moderator_2` FOREIGN KEY (`mod_Id2`) REFERENCES `moderator` (`mod_Id`);

--
-- Constraints for table `modrequest`
--
ALTER TABLE `modrequest`
  ADD CONSTRAINT `FK_modrequest_mid` FOREIGN KEY (`m_id`) REFERENCES `members` (`m_Id`),
  ADD CONSTRAINT `FK_modrequest_mod1` FOREIGN KEY (`mod_id1`) REFERENCES `moderator` (`mod_Id`),
  ADD CONSTRAINT `FK_modrequest_mod2` FOREIGN KEY (`mod_id2`) REFERENCES `moderator` (`mod_Id`);

--
-- Constraints for table `tempuserdata`
--
ALTER TABLE `tempuserdata`
  ADD CONSTRAINT `FK_tempuserdata_1` FOREIGN KEY (`p_id`) REFERENCES `passout_year` (`p_Id`),
  ADD CONSTRAINT `FK_tempuserdata_2` FOREIGN KEY (`b_id`) REFERENCES `branch` (`b_Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
