-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2018 at 10:00 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `email_id` varchar(30) NOT NULL,
  `security_question` varchar(30) NOT NULL,
  `security_answer` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `status`, `username`, `password`, `name`, `contact`, `email_id`, `security_question`, `security_answer`) VALUES
(1, 'Admin', 'admin', 'admin', 'Rohit', '8557896701', 'rg356521@gmail.com', 'your nick name', 'kuch nahi'),
(2, 'Manager', 'wtf', 'kyudassa', 'ravi', '9782782448', 'hihihiihihi', 'your nick name', 'rai'),
(3, 'Employee', 'ishann888', '111', 'ishann', '8557896701', 'ishaan@gmail.com', 'your nick name', 'kamlesh');

-- --------------------------------------------------------

--
-- Table structure for table `check_out`
--

CREATE TABLE `check_out` (
  `name` text NOT NULL,
  `coustmer_id` varchar(10) NOT NULL,
  `room_no` varchar(10) NOT NULL,
  `check_out` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `check_out`
--

INSERT INTO `check_out` (`name`, `coustmer_id`, `room_no`, `check_out`) VALUES
('rohti', 'rohit111', '100', 'date'),
('rohti', 'rohit', '200', 'date');

-- --------------------------------------------------------

--
-- Table structure for table `coustmer`
--

CREATE TABLE `coustmer` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` varchar(20) NOT NULL,
  `contact` varchar(13) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email_id` varchar(20) NOT NULL,
  `coustmer_id` varchar(20) NOT NULL,
  `total_member` varchar(10) NOT NULL,
  `check_in` varchar(20) NOT NULL,
  `check_out` varchar(20) NOT NULL,
  `id_proof` varchar(20) NOT NULL,
  `id_number` varchar(30) NOT NULL,
  `gender` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coustmer`
--

INSERT INTO `coustmer` (`id`, `name`, `age`, `contact`, `address`, `email_id`, `coustmer_id`, `total_member`, `check_in`, `check_out`, `id_proof`, `id_number`, `gender`) VALUES
(40, 'rohit', '20', '8557896701', 'new company bagh', 'rg3565212gmail.com', 'rohit855', '1', '20/apr/2018', '25/apr/2018', 'aadhar card', '987653210', 'male'),
(41, 'rohit', '20', '8557896701', 'new company bagh', 'rg3565212gmail.com', 'rohit85', '1', '20/apr/2018', '25/apr/2018', 'aadhar card', '987653210', 'male'),
(42, 'rohit', '20', '8557896701', 'new company bagh', 'rg3565212gmail.com', 'rohit8', '1', '20/apr/2018', '25/apr/2018', 'aadhar card', '987653210', 'male'),
(45, 'rohit', '20', '8557896701', 'new company bagh', 'rg3565212gmail.com', 'rohit', '', '20/apr/2018', '25/apr/2018', 'aadhar card', '987653210', 'male'),
(46, 'rohit', '20', '8557896701', 'new company bagh', '', 'rohi', '', '20/apr/2018', '25/apr/2018', 'aadhar card', '987653210', 'male'),
(47, 'Rohit kumar', '21', '8557896701', 'new company bagh', 'rg356521@gmail.com', 'rohit8756133', '1', '20/4/2018', '21/4/2018', 'pen card', '56641616163413', 'male'),
(48, 'rohit', '21', '9876993738', 'new company bagh', 'rohit@gmail.com', '15111044451364', '1', '20/4/2018', '27/4/2018', 'aadhar card', '2018724568', 'male'),
(49, 'rohit', '21', '8557896701', 'byfcgfcgfctg', 'jhbjbhj', 'bhbjbjbjuuh', '1', '522222', '51556', 'aadhar card', '8694478744', 'male'),
(50, 'rohit', '21', '8557896701', 'byfcgfcgfctg', 'jhbjbhj', 'bhbjbjbju', '1', '522222', '51556', 'aadhar card', '8694478744', 'male'),
(52, 'rohit', '21', '8557896701', 'byfcgfcgfctg', 'jhbjbhj', 'bhbjbjbj', '1', '522222', '51556', 'aadhar card', '8694478744', 'male'),
(53, 'rohit', '21', '97797943', 'vb vb b b b b b', 'hgcgcgcgcgbh', '151515', '1626', '12', '112', 'voter id', '5113131313', 'male'),
(54, 'pranjal', '21', '9878360622', 'frefrefe', 'frefregr', 'regrgr', 'rgrgregrge', 'egregegr', 'regregre', 'aadhar card', 'regregege', 'male'),
(55, 'sagar', '21', '8557896701', 'new comapany bagh', 'rg356521@gmail.com', '1000000000', '1', '20/4/2018', '2151564', 'aadhar card', '595648486', 'male'),
(56, 'Rohit', '21', '855789701', 'fefe', 'efewgewge', 'feff', 'fwefwefwe', 'ewfef', 'feefew', 'aadhar card', 'weffewf', 'male');

-- --------------------------------------------------------

--
-- Table structure for table `coustmer_id`
--

CREATE TABLE `coustmer_id` (
  `id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coustmer_id`
--

INSERT INTO `coustmer_id` (`id`) VALUES
(1000000000),
(1000000001),
(1000000002);

-- --------------------------------------------------------

--
-- Table structure for table `coustmer_payment`
--

CREATE TABLE `coustmer_payment` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `coustmer_id` varchar(10) NOT NULL,
  `room_no` text NOT NULL,
  `room_type` text NOT NULL,
  `room_charge` double NOT NULL,
  `total_charges` double NOT NULL,
  `bill_pay` double NOT NULL,
  `bill_pending` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coustmer_payment`
--

INSERT INTO `coustmer_payment` (`id`, `name`, `coustmer_id`, `room_no`, `room_type`, `room_charge`, `total_charges`, `bill_pay`, `bill_pending`) VALUES
(9, 'rohit', 'rohit855', '100', 'AC', 2000, 2000, 2000, 0),
(10, 'rohit', 'rohit85', '100', 'AC', 2000, 2000, 2000, 0),
(11, 'rohit', 'rohit8', '100', 'AC', 2000, 2000, 2000, 0),
(12, 'rohit', 'rohit', '100', 'AC', 2000, 2000, 2000, 0),
(13, 'rohit', 'rohi', '100', 'AC', 2000, 2000, 2000, 0),
(14, 'Rohit kumar', 'rohit87561', '105', 'NON-AC', 1500, 1500, 1500, 0),
(15, 'rohit', '1511104445', '1078', 'AC', 3000, 3000, 3000, 0),
(16, 'rohit', 'bhbjbjbjuu', '987', 'AC', 3000, 3000, 2145, 5418545),
(17, 'rohit', 'bhbjbjbju', '987', 'AC', 3000, 3000, 2145, 5418545),
(18, 'rohit', 'bhbjbjbj', '105', 'AC', 3000, 3000, 2145, 5418545),
(19, 'rohit', '151515', '105', 'AC', 3000, 3000, 3000, 0),
(20, 'pranjal', 'regrgr', '105', 'AC', 3000, 3000, 3000, 0),
(21, 'sagar', '1000000000', '200', 'AC', 3000, 3000, 3000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `employee_id` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` varchar(10) NOT NULL,
  `mobile_no` varchar(20) NOT NULL,
  `email_id` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `joining_date` varchar(15) NOT NULL,
  `salary` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`employee_id`, `name`, `age`, `mobile_no`, `email_id`, `status`, `joining_date`, `salary`) VALUES
('1000000001', 'sagar', '22', '855786701', 'sagar@gmail.com', 'manager', '20/4/2018', 20000),
('rohit111', 'rohit', '22', '8557896701', 'rg356521@gmail.com', 'employee', '20/4/2018', 30000);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `S.no` int(11) NOT NULL,
  `Room_no` varchar(5) NOT NULL,
  `Room_type` varchar(10) NOT NULL,
  `charges` double NOT NULL,
  `Booking` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`S.no`, `Room_no`, `Room_type`, `charges`, `Booking`) VALUES
(2, '200', 'sun.awt.wi', 2000, 'AVAILABLE'),
(3, '103', 'NON-AC', 1500, 'BOOK'),
(5, '105', 'AC', 3000, 'BOOK'),
(6, '101', 'AC', 3000, 'AVAILABLE');

-- --------------------------------------------------------

--
-- Table structure for table `room_type`
--

CREATE TABLE `room_type` (
  `id` int(11) NOT NULL,
  `room_type` varchar(20) NOT NULL,
  `charges` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_type`
--

INSERT INTO `room_type` (`id`, `room_type`, `charges`) VALUES
(1, 'AC', 3000),
(3, 'NON-AC', 1500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `coustmer`
--
ALTER TABLE `coustmer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `coustmer_id` (`coustmer_id`),
  ADD KEY `id_proof` (`id_proof`) USING BTREE,
  ADD KEY `contact` (`contact`,`email_id`) USING BTREE;

--
-- Indexes for table `coustmer_id`
--
ALTER TABLE `coustmer_id`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `coustmer_payment`
--
ALTER TABLE `coustmer_payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD UNIQUE KEY `employee_id` (`employee_id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`S.no`),
  ADD UNIQUE KEY `Room_no` (`Room_no`);

--
-- Indexes for table `room_type`
--
ALTER TABLE `room_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `coustmer`
--
ALTER TABLE `coustmer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT for table `coustmer_payment`
--
ALTER TABLE `coustmer_payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `S.no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `room_type`
--
ALTER TABLE `room_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
