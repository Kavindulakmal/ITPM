-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2021 at 02:20 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mynewdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `consecutive`
--

CREATE TABLE `consecutive` (
  `sid` int(11) NOT NULL,
  `firstLecturer` varchar(150) NOT NULL,
  `secondLecturer` varchar(150) NOT NULL,
  `tag` varchar(20) NOT NULL,
  `subjectCode` varchar(20) NOT NULL,
  `subjectName` varchar(150) NOT NULL,
  `studentGroup` varchar(20) NOT NULL,
  `numberOfStudents` int(5) NOT NULL,
  `duration` time NOT NULL,
  `day` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `consecutive`
--

INSERT INTO `consecutive` (`sid`, `firstLecturer`, `secondLecturer`, `tag`, `subjectCode`, `subjectName`, `studentGroup`, `numberOfStudents`, `duration`, `day`) VALUES
(24, 'Amali Rashmika', 'Dayan Gunawardane', 'Lecture', 'IT1020', 'EAP', 'Y1.S1. IT. 01. 1', 111, '00:00:02', ''),
(19, 'Amali Rashmika', 'Kamal Senanayake', 'Tutorial', 'IT1020', 'EAP', 'Y3.S1.IT.2', 120, '00:00:01', '');

-- --------------------------------------------------------

--
-- Table structure for table `lecturers`
--

CREATE TABLE `lecturers` (
  `id` int(11) NOT NULL,
  `staffid` varchar(6) NOT NULL,
  `name` varchar(100) NOT NULL,
  `faculty` varchar(100) NOT NULL,
  `department` varchar(200) NOT NULL,
  `center` varchar(200) NOT NULL,
  `building` varchar(200) NOT NULL,
  `level` varchar(20) NOT NULL,
  `rank` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lecturers`
--

INSERT INTO `lecturers` (`id`, `staffid`, `name`, `faculty`, `department`, `center`, `building`, `level`, `rank`) VALUES
(1, '000123', 'Amal Bandara', 'Faculty of Computing', 'Department of Computer Science & Software Engineering', 'Malabe', 'Main Building', 'Senior Lecturer(HG)', '3.000123'),
(3, '000146', 'R M Ramani Perera', 'Faculty of Computing', 'Department of Computer Systems Engineering', 'Malabe', 'New Building', 'Assistant Professor', '2.000145');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `locationId` int(11) NOT NULL,
  `buildingName` varchar(100) NOT NULL,
  `roomName` varchar(100) NOT NULL,
  `roomType` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `createdOn` datetime NOT NULL,
  `createdBy` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`locationId`, `buildingName`, `roomName`, `roomType`, `capacity`, `createdOn`, `createdBy`) VALUES
(5, 'A Building', 'A1', 1, 50, '2021-03-29 01:16:28', 1),
(6, 'A Building', 'A2', 2, 30, '2021-03-29 01:16:39', 1),
(7, 'A Building', 'A3', 1, 80, '2021-03-29 01:16:58', 1);

-- --------------------------------------------------------

--
-- Table structure for table `locationkl`
--

CREATE TABLE `locationkl` (
  `lid` int(5) NOT NULL,
  `lroom` varchar(10) NOT NULL,
  `lday` varchar(15) NOT NULL,
  `stime` varchar(10) NOT NULL,
  `etime` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `locationkl`
--

INSERT INTO `locationkl` (`lid`, `lroom`, `lday`, `stime`, `etime`) VALUES
(1, 'A501', 'Monday', '4:30', '5:30'),
(3, 'A501', 'Tuesday', '10:30', '12:30'),
(4, 'A502', 'Tuesday', '9:30', '12:30'),
(5, 'A503', 'Tuesday', '10:30', '11:30'),
(6, 'A505', 'Sunday', '4:30', '6:30');

-- --------------------------------------------------------

--
-- Table structure for table `nonparallel`
--

CREATE TABLE `nonparallel` (
  `sid` int(11) NOT NULL,
  `firstLecturer` varchar(150) NOT NULL,
  `secondLecturer` varchar(150) NOT NULL,
  `tag` varchar(20) NOT NULL,
  `subjectCode` varchar(20) NOT NULL,
  `subjectName` varchar(20) NOT NULL,
  `studentGroup` varchar(20) NOT NULL,
  `numberOfStudents` int(5) NOT NULL,
  `duration` time NOT NULL,
  `day` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nonparallel`
--

INSERT INTO `nonparallel` (`sid`, `firstLecturer`, `secondLecturer`, `tag`, `subjectCode`, `subjectName`, `studentGroup`, `numberOfStudents`, `duration`, `day`) VALUES
(25, 'Nalaka Perera', '-', 'Lecture', 'IT3030', 'PAF', 'Y3.S1.IT.3', 120, '00:00:02', ''),
(26, 'Sarath Fernando', 'Kamal Senanayake', 'Practicle', 'IT3020', 'DBS', 'Y3.S1.IT.3.1', 60, '00:00:02', ''),
(27, 'Piyumika De Silva', 'R M Ramani Perera', 'Practicle', 'IT4010', 'BMIT', 'Y3.S1.IT.2', 54, '00:00:02', '');

-- --------------------------------------------------------

--
-- Table structure for table `overlappingsessions`
--

CREATE TABLE `overlappingsessions` (
  `sid` int(10) NOT NULL,
  `firstLecturer` varchar(150) NOT NULL,
  `secondLecturer` varchar(150) NOT NULL,
  `tag` varchar(20) NOT NULL,
  `subjectCode` varchar(20) NOT NULL,
  `subjectName` varchar(20) NOT NULL,
  `studentGroup` varchar(20) NOT NULL,
  `numberOfStudents` int(5) NOT NULL,
  `duration` time NOT NULL,
  `day` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `overlappingsessions`
--

INSERT INTO `overlappingsessions` (`sid`, `firstLecturer`, `secondLecturer`, `tag`, `subjectCode`, `subjectName`, `studentGroup`, `numberOfStudents`, `duration`, `day`) VALUES
(27, 'Piyumika De Silva', 'R M Ramani Perera', 'Practicle', 'IT4010', 'BMIT', 'Y3.S1.IT.2', 54, '00:00:02', '');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `code` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `building` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `capacity` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`code`, `name`, `building`, `type`, `capacity`) VALUES
(205, 'Com', 'Com New', 'non', '1500'),
(504, 'NB', 'New B', 'ac', '1000');

-- --------------------------------------------------------

--
-- Table structure for table `sessions`
--

CREATE TABLE `sessions` (
  `sid` int(10) NOT NULL,
  `firstLecturer` varchar(150) NOT NULL,
  `secondLecturer` varchar(150) NOT NULL,
  `tag` varchar(20) NOT NULL,
  `subjectCode` varchar(20) NOT NULL,
  `subjectName` varchar(150) NOT NULL,
  `studentGroup` varchar(20) NOT NULL,
  `numberOfStudents` int(5) NOT NULL,
  `duration` time(6) NOT NULL,
  `day` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sessions`
--

INSERT INTO `sessions` (`sid`, `firstLecturer`, `secondLecturer`, `tag`, `subjectCode`, `subjectName`, `studentGroup`, `numberOfStudents`, `duration`, `day`) VALUES
(1, 'ms.Kavindi Gunasekara', 'Mr.manjula sigera', '1', 'IT1010', 'Spm', '1', 60, '00:00:02.000000', 'Monday'),
(2, 'Kavindu lakmal', 'Lakmal Wickramasinghe', '1', 'IT1020', 'ITP', '2', 10, '00:00:02.000000', 'friday');

-- --------------------------------------------------------

--
-- Table structure for table `studentgroups`
--

CREATE TABLE `studentgroups` (
  `groupID` int(10) NOT NULL,
  `yearsemester` varchar(20) NOT NULL,
  `studentprogramme` varchar(20) NOT NULL,
  `groupnumber` int(10) NOT NULL,
  `subgroup` int(10) NOT NULL,
  `StudentGroupID` varchar(20) NOT NULL,
  `StudentSubGroupID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `studentgroups`
--

INSERT INTO `studentgroups` (`groupID`, `yearsemester`, `studentprogramme`, `groupnumber`, `subgroup`, `StudentGroupID`, `StudentSubGroupID`) VALUES
(46, 'Y1.S1', 'IT', 1, 1, 'Y1.S1. IT. 01', 'Y1.S1. IT. 01. 1'),
(47, 'Y1.S1', 'IT', 2, 2, 'Y1.S1. IT. 02', 'Y1.S1. IT. 02. 2');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL,
  `subname` varchar(200) NOT NULL,
  `subcode` varchar(50) NOT NULL,
  `offeredyear` varchar(50) NOT NULL,
  `offeredsem` varchar(50) NOT NULL,
  `nooflechrs` int(11) NOT NULL,
  `nooftuthers` int(11) NOT NULL,
  `noofprachrs` int(11) NOT NULL,
  `noofevahrs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`id`, `subname`, `subcode`, `offeredyear`, `offeredsem`, `nooflechrs`, `nooftuthers`, `noofprachrs`, `noofevahrs`) VALUES
(3, 'PAF', 'IT3030', '3rd Year', 'Semester 1', 2, 1, 2, 0),
(4, 'EAP', 'IT1020', '1st Year', 'Semester 2', 2, 1, 0, 0),
(5, 'IP', 'IT1080', '1st Year', 'Semester 1', 2, 1, 2, 0),
(6, 'IWT', 'IT1070', '1st Year', 'Semester 2', 2, 1, 2, 0),
(7, 'DBS', 'IT3020', '3rd Year', 'Semester 2', 2, 1, 2, 0),
(8, 'BMIT', 'IT4010', '4th Year', 'Semester 1', 2, 1, 2, 0),
(9, 'MAD', 'IT2010', '2nd Year', 'Semester 2', 2, 1, 2, 0),
(10, 'DSA', 'IT2070', '2nd Year', 'Semester 2', 2, 1, 2, 0),
(11, 'ESD', 'IT3050', '2nd Year', 'Semester 2', 2, 0, 0, 0),
(12, 'SE', 'IT2020', '1st Year', 'Semester 1', 2, 1, 2, 0),
(13, 'NDM ', 'IT3010', '3rd Year', 'Semester 1', 2, 1, 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tags`
--

CREATE TABLE `tags` (
  `tagid` int(10) NOT NULL,
  `tagname` varchar(20) NOT NULL,
  `tagcode` varchar(20) NOT NULL,
  `relatedtag` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tags`
--

INSERT INTO `tags` (`tagid`, `tagname`, `tagcode`, `relatedtag`) VALUES
(22, 'lec', 'dd', 'Tutorial'),
(24, 'lec', '01', 'Lecture'),
(25, 'tute', '02', 'Tutorial'),
(26, 'lab', '03', 'Practical');

-- --------------------------------------------------------

--
-- Table structure for table `timeallofl`
--

CREATE TABLE `timeallofl` (
  `tallid` int(5) NOT NULL,
  `lectur` varchar(80) NOT NULL,
  `lgro` varchar(9) NOT NULL,
  `sgro` varchar(9) NOT NULL,
  `seid` varchar(5) NOT NULL,
  `stime` varchar(8) NOT NULL,
  `etime` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `timeallofl`
--

INSERT INTO `timeallofl` (`tallid`, `lectur`, `lgro`, `sgro`, `seid`, `stime`, `etime`) VALUES
(5, 'R M Ramani Perera', '2', '2', '2', '1:30', '4:30'),
(6, 'R M Ramani Perera', '2', '2', '2', '1:30', '4:30'),
(7, 'R M Ramani Perera', '2', '2', '2', '1:30', '4:30'),
(8, 'R M Ramani Perera', '2', '2', '2', '1:30', '4:30'),
(9, 'R M Ramani Perera', '2', '2', '2', '1:30', '4:30'),
(10, 'R M Ramani Perera', '2', '2', '2', '1:30', '4:30');

-- --------------------------------------------------------

--
-- Table structure for table `timeallofs`
--

CREATE TABLE `timeallofs` (
  `talsid` int(5) NOT NULL,
  `grup` varchar(10) NOT NULL,
  `sgrup` varchar(10) NOT NULL,
  `seid` varchar(10) NOT NULL,
  `stime` varchar(10) NOT NULL,
  `etime` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `timeallofs`
--

INSERT INTO `timeallofs` (`talsid`, `grup`, `sgrup`, `seid`, `stime`, `etime`) VALUES
(1, '1', '2', '2', '5:30', '7:30'),
(2, '1', '2', '2', '5:30', '7:30'),
(3, '1', '2', '2', '5:30', '7:30'),
(5, '2', '2', '2', '9:30', '11:30'),
(6, '1', '2', '2', '12:30', '2:30');

-- --------------------------------------------------------

--
-- Table structure for table `workingdays`
--

CREATE TABLE `workingdays` (
  `wid` int(4) NOT NULL,
  `nowd` varchar(6) NOT NULL,
  `mon` varchar(6) NOT NULL,
  `tue` varchar(6) NOT NULL,
  `wed` varchar(6) NOT NULL,
  `thu` varchar(6) NOT NULL,
  `fri` varchar(6) NOT NULL,
  `sut` varchar(6) NOT NULL,
  `sun` varchar(6) NOT NULL,
  `hours` varchar(3) NOT NULL,
  `min` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `workingdays`
--

INSERT INTO `workingdays` (`wid`, `nowd`, `mon`, `tue`, `wed`, `thu`, `fri`, `sut`, `sun`, `hours`, `min`) VALUES
(1, '4', 'Yes', 'Yes', 'Yes', 'Yes', 'No', 'No', 'No', '3', '20'),
(2, '5', 'No', 'No', 'Yes', 'Yes', 'Yes', 'Yes', 'Yes', '10', '30'),
(3, '5', 'Yes', 'Yes', 'Yes', 'Yes', 'No', 'No', 'Yes', '6', '30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `locationkl`
--
ALTER TABLE `locationkl`
  ADD PRIMARY KEY (`lid`);

--
-- Indexes for table `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`sid`);

--
-- Indexes for table `studentgroups`
--
ALTER TABLE `studentgroups`
  ADD PRIMARY KEY (`groupID`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tags`
--
ALTER TABLE `tags`
  ADD PRIMARY KEY (`tagid`);

--
-- Indexes for table `timeallofl`
--
ALTER TABLE `timeallofl`
  ADD PRIMARY KEY (`tallid`);

--
-- Indexes for table `timeallofs`
--
ALTER TABLE `timeallofs`
  ADD PRIMARY KEY (`talsid`);

--
-- Indexes for table `workingdays`
--
ALTER TABLE `workingdays`
  ADD PRIMARY KEY (`wid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `locationkl`
--
ALTER TABLE `locationkl`
  MODIFY `lid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `sessions`
--
ALTER TABLE `sessions`
  MODIFY `sid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `studentgroups`
--
ALTER TABLE `studentgroups`
  MODIFY `groupID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tags`
--
ALTER TABLE `tags`
  MODIFY `tagid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `timeallofl`
--
ALTER TABLE `timeallofl`
  MODIFY `tallid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `timeallofs`
--
ALTER TABLE `timeallofs`
  MODIFY `talsid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `workingdays`
--
ALTER TABLE `workingdays`
  MODIFY `wid` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
