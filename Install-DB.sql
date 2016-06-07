-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: facts3
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `academic_period`
--

DROP TABLE IF EXISTS `academic_period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `academic_period` (
  `academicPeriodId` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `shortName` varchar(10) NOT NULL,
  `startTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `endTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`academicPeriodId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `announcement` (
  `announcementId` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL,
  `content` varchar(500) NOT NULL,
  `title` varchar(45) NOT NULL,
  `creationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(10) NOT NULL,
  PRIMARY KEY (`announcementId`),
  KEY `announcement_courseId_fk_idx` (`courseId`),
  KEY `announcement_username_fk_idx` (`username`),
  CONSTRAINT `announcement_courseId_fk` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `announcement_username_fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assignment` (
  `assignmentId` int(10) NOT NULL AUTO_INCREMENT,
  `courseId` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `creationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dueTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `openTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`assignmentId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `assignment_file`
--

DROP TABLE IF EXISTS `assignment_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assignment_file` (
  `assignmentId` int(11) NOT NULL,
  `fileId` int(11) NOT NULL,
  PRIMARY KEY (`assignmentId`,`fileId`),
  KEY `assignment_file_file_fk_idx` (`fileId`),
  CONSTRAINT `assignment_file_assignment_fk` FOREIGN KEY (`assignmentId`) REFERENCES `assignment` (`assignmentId`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `assignment_file_file_fk` FOREIGN KEY (`fileId`) REFERENCES `file` (`fileId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `auth_user`
--

DROP TABLE IF EXISTS `auth_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auth_user` (
  `username` varchar(10) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `accountExpired` tinyint(4) DEFAULT NULL,
  `accountLocked` tinyint(4) DEFAULT NULL,
  `credentialsExpired` tinyint(4) DEFAULT NULL,
  `accountEnabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentId` int(10) NOT NULL AUTO_INCREMENT,
  `feedbackId` int(10) NOT NULL,
  `secret` tinyint(1) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `creationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(10) NOT NULL,
  PRIMARY KEY (`commentId`),
  KEY `feedbackId` (`feedbackId`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`feedbackId`) REFERENCES `feedback` (`feedbackId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `courseId` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `shortName` varchar(10) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `academicPeriodId` int(10) NOT NULL,
  PRIMARY KEY (`courseId`),
  KEY `academicPeriodId` (`academicPeriodId`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`academicPeriodId`) REFERENCES `academic_period` (`academicPeriodId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `download_link`
--

DROP TABLE IF EXISTS `download_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `download_link` (
  `downloadLinkId` int(11) NOT NULL AUTO_INCREMENT,
  `fileId` int(11) NOT NULL,
  `link` varchar(64) NOT NULL,
  `validFrom` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(10) NOT NULL,
  `used` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`downloadLinkId`),
  KEY `download_link_file_fk_idx` (`fileId`),
  KEY `download_link_user_fk_idx` (`username`),
  CONSTRAINT `download_link_file_fk` FOREIGN KEY (`fileId`) REFERENCES `file` (`fileId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `download_link_user_fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `enrollment`
--

DROP TABLE IF EXISTS `enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enrollment` (
  `enrollmentId` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `courseId` int(10) NOT NULL,
  `enrollmentLevel` varchar(25) NOT NULL,
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`enrollmentId`),
  KEY `username` (`username`,`courseId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `enrollment_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  CONSTRAINT `enrollment_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `feedbackId` int(10) NOT NULL AUTO_INCREMENT,
  `submissionId` int(10) NOT NULL,
  `feedbackStatus` varchar(25) NOT NULL,
  `username` varchar(10) NOT NULL,
  `mark` double NOT NULL DEFAULT '0',
  `dueTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `commentReleased` tinyint(4) NOT NULL DEFAULT '0',
  `markReleased` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`feedbackId`),
  UNIQUE KEY `submissionId` (`submissionId`,`username`),
  KEY `marker` (`username`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`submissionId`) REFERENCES `submission` (`submissionId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `fileId` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `extension` varchar(10) NOT NULL,
  `hash` varchar(64) NOT NULL,
  `location` varchar(100) NOT NULL,
  `size` bigint(20) NOT NULL,
  `username` varchar(10) NOT NULL,
  `creationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `contentType` varchar(45) NOT NULL,
  PRIMARY KEY (`fileId`),
  KEY `username` (`username`),
  KEY `username_2` (`username`),
  CONSTRAINT `file_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `file_requirement`
--

DROP TABLE IF EXISTS `file_requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_requirement` (
  `fileRequirementId` int(10) NOT NULL AUTO_INCREMENT,
  `assignmentId` int(10) NOT NULL,
  `fileName` varchar(50) NOT NULL,
  `maxFileSize` int(15) NOT NULL,
  `allowedExtension` varchar(10) NOT NULL,
  PRIMARY KEY (`fileRequirementId`),
  KEY `assignmentId` (`assignmentId`),
  CONSTRAINT `file_requirement_ibfk_1` FOREIGN KEY (`assignmentId`) REFERENCES `assignment` (`assignmentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `marker_assignment`
--

DROP TABLE IF EXISTS `marker_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marker_assignment` (
  `username` varchar(10) NOT NULL,
  `submissionId` int(11) NOT NULL,
  PRIMARY KEY (`username`,`submissionId`),
  KEY `marker_assignment_submissionId_fk_idx` (`submissionId`),
  CONSTRAINT `marker_assignment_submissionId_fk` FOREIGN KEY (`submissionId`) REFERENCES `submission` (`submissionId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `marker_assignment_username_fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `marker_for`
--

DROP TABLE IF EXISTS `marker_for`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marker_for` (
  `username` varchar(10) NOT NULL,
  `courseId` int(10) NOT NULL,
  KEY `username` (`username`,`courseId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `marker_for_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  CONSTRAINT `marker_for_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `marker_swap_request`
--

DROP TABLE IF EXISTS `marker_swap_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marker_swap_request` (
  `markerSwapRequestId` int(11) NOT NULL AUTO_INCREMENT,
  `feedbackId` int(11) NOT NULL,
  `username` varchar(10) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`markerSwapRequestId`),
  KEY `feedbackId_feedback_fk_idx` (`feedbackId`),
  KEY `username_user_fk_idx` (`username`),
  CONSTRAINT `feedbackId_feedback_fk` FOREIGN KEY (`feedbackId`) REFERENCES `feedback` (`feedbackId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `username_user_fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `notificationId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `content` varchar(255) NOT NULL,
  `link` varchar(100) NOT NULL,
  `creationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`notificationId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1 COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `notification_for`
--

DROP TABLE IF EXISTS `notification_for`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification_for` (
  `notificationId` int(11) NOT NULL,
  `username` varchar(10) NOT NULL,
  `seen` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`notificationId`,`username`),
  KEY `notification_for_username_fk_idx` (`username`),
  CONSTRAINT `notification_for_notificationId_fk` FOREIGN KEY (`notificationId`) REFERENCES `notification` (`notificationId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `notification_for_username_fk` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `owns`
--

DROP TABLE IF EXISTS `owns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owns` (
  `username` varchar(10) NOT NULL,
  `courseId` int(10) NOT NULL,
  KEY `username` (`username`,`courseId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `owns_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  CONSTRAINT `owns_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_information`
--

DROP TABLE IF EXISTS `student_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_information` (
  `username` varchar(10) NOT NULL,
  `studentId` int(10) NOT NULL,
  `yearOfStudy` int(2) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `studentId` (`studentId`),
  CONSTRAINT `student_information_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `submission`
--

DROP TABLE IF EXISTS `submission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submission` (
  `submissionId` int(10) NOT NULL AUTO_INCREMENT,
  `assignmentId` int(10) NOT NULL,
  `username` varchar(10) NOT NULL,
  `submissionStatus` varchar(25) NOT NULL,
  `creationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`submissionId`),
  KEY `assignmentId` (`assignmentId`,`username`),
  KEY `submitter` (`username`),
  CONSTRAINT `submission_ibfk_1` FOREIGN KEY (`assignmentId`) REFERENCES `assignment` (`assignmentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `submission_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `submission_file`
--

DROP TABLE IF EXISTS `submission_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `submission_file` (
  `submissionId` int(11) NOT NULL,
  `fileId` int(11) NOT NULL,
  PRIMARY KEY (`submissionId`,`fileId`),
  KEY `submission_file_fileId_fkl_idx` (`fileId`),
  CONSTRAINT `submission_file_fileId_fkl` FOREIGN KEY (`fileId`) REFERENCES `file` (`fileId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `submission_file_submissionId_fk` FOREIGN KEY (`submissionId`) REFERENCES `submission` (`submissionId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_authority`
--

DROP TABLE IF EXISTS `user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_authority` (
  `username` varchar(10) NOT NULL,
  `authority` varchar(100) NOT NULL,
  PRIMARY KEY (`username`,`authority`),
  CONSTRAINT `user_authority_auth_user_username_fk` FOREIGN KEY (`username`) REFERENCES `auth_user` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_title`
--

DROP TABLE IF EXISTS `user_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_title` (
  `username` varchar(10) NOT NULL,
  `title` varchar(10) NOT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `user_title_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-03 16:12:46
