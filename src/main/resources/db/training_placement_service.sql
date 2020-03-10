-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2020 at 05:22 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `training_placement_service`
--

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE `answers` (
  `id` bigint(20) NOT NULL,
  `subject` bigint(20) DEFAULT NULL,
  `question` bigint(20) DEFAULT NULL,
  `exam` bigint(20) DEFAULT NULL,
  `answer` varchar(200) NOT NULL,
  `is_correct` bit(1) DEFAULT NULL,
  `marks_awarded` varchar(50) DEFAULT NULL,
  `created_on` bigint(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `companies`
--

CREATE TABLE `companies` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `Code` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `address` varchar(500) NOT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `fax_number` varchar(50) DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'0',
  `created_on` bigint(50) DEFAULT NULL,
  `ctc_offered` double DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `companies_students`
--

CREATE TABLE `companies_students` (
  `id` bigint(20) NOT NULL,
  `criteria` bigint(20) DEFAULT NULL,
  `student` bigint(20) DEFAULT NULL,
  `is_selected` bit(1) DEFAULT NULL,
  `updated_on` bigint(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `criteria_details`
--

CREATE TABLE `criteria_details` (
  `id` bigint(20) NOT NULL,
  `company` bigint(20) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `ssc` varchar(20) NOT NULL,
  `degree` varchar(20) NOT NULL,
  `skill_set` varchar(150) DEFAULT NULL,
  `hsc_disploma` varchar(20) NOT NULL,
  `others` varchar(100) DEFAULT NULL,
  `updated_on` bigint(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `exams`
--

CREATE TABLE `exams` (
  `id` bigint(20) NOT NULL,
  `subject` bigint(20) DEFAULT NULL,
  `is_correct` bit(1) DEFAULT NULL,
  `exam_code` varchar(50) NOT NULL,
  `no_of_questions` int(20) DEFAULT NULL,
  `duration` bigint(30) DEFAULT NULL,
  `exam_date` bigint(20) DEFAULT NULL,
  `created_on` bigint(30) DEFAULT NULL,
  `is_negative_for_wrong` bit(1) DEFAULT NULL,
  `negative_mark_per_question` int(20) DEFAULT NULL,
  `marks_per_question` int(20) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` bigint(20) NOT NULL,
  `subject` bigint(20) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `question` varchar(1000) NOT NULL,
  `is_multiple_answers` bit(1) NOT NULL,
  `option1` varchar(200) DEFAULT NULL,
  `option2` varchar(200) DEFAULT NULL,
  `option3` varchar(200) DEFAULT NULL,
  `option4` varchar(200) DEFAULT NULL,
  `correct_answer` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `exam_answer_id_fk` (`exam`),
  ADD KEY `answer_question_id_fk` (`question`);

--
-- Indexes for table `companies`
--
ALTER TABLE `companies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `companies_students`
--
ALTER TABLE `companies_students`
  ADD PRIMARY KEY (`id`),
  ADD KEY `criteria_company_students_id_fk` (`criteria`);

--
-- Indexes for table `criteria_details`
--
ALTER TABLE `criteria_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `criteria_company_id_fk` (`company`);

--
-- Indexes for table `exams`
--
ALTER TABLE `exams`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answers`
--
ALTER TABLE `answers`
  ADD CONSTRAINT `answer_question_id_fk` FOREIGN KEY (`question`) REFERENCES `questions` (`id`);

--
-- Constraints for table `companies_students`
--
ALTER TABLE `companies_students`
  ADD CONSTRAINT `criteria_company_students_id_fk` FOREIGN KEY (`criteria`) REFERENCES `criteria_details` (`id`);

--
-- Constraints for table `criteria_details`
--
ALTER TABLE `criteria_details`
  ADD CONSTRAINT `criteria_company_id_fk` FOREIGN KEY (`company`) REFERENCES `companies` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
