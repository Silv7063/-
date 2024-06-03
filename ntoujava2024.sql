-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2024-06-03 14:38:58
-- 伺服器版本： 10.4.32-MariaDB-log
-- PHP 版本： 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `ntoujava2024`
--

-- --------------------------------------------------------

--
-- 資料表結構 `attendance`
--

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL,
  `employee_name` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `sign_in` time NOT NULL,
  `sign_out` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 傾印資料表的資料 `attendance`
--

INSERT INTO `attendance` (`id`, `employee_name`, `date`, `sign_in`, `sign_out`) VALUES
(1, 'Alice Chen', '2024-06-01', '07:20:58', '17:43:08'),
(2, 'Alice Li', '2024-06-01', '07:53:14', '18:53:16'),
(3, 'Alice Wang', '2024-06-01', '08:33:42', '18:37:39'),
(4, 'Alice Zhang', '2024-06-01', '07:59:10', '18:15:23'),
(5, 'Bob Chen', '2024-06-01', '07:44:23', '17:34:45'),
(6, 'Bob Li', '2024-06-01', '07:33:21', '17:25:17'),
(7, 'Bob Wang', '2024-06-01', '07:30:45', '17:05:19'),
(8, 'Bob Zhang', '2024-06-01', '08:59:42', '16:44:24'),
(9, 'Charlie Chen', '2024-06-01', '08:46:51', '17:48:17'),
(10, 'Charlie Li', '2024-06-01', '07:36:25', '20:24:45'),
(11, 'Charlie Wang', '2024-06-01', '07:29:10', '18:17:43'),
(12, 'Charlie Zhang', '2024-06-01', '07:30:21', '20:30:38'),
(13, 'David Chen', '2024-06-01', '08:21:24', '18:52:00'),
(14, 'David Li', '2024-06-01', '07:52:45', '19:33:15'),
(15, 'David Wang', '2024-06-01', '08:42:07', '16:58:16'),
(16, 'David Wu', '2024-06-01', '07:25:39', '17:44:41'),
(17, 'David Zhang', '2024-06-01', '07:14:45', '17:23:19'),
(18, 'Eve Chen', '2024-06-01', '07:08:14', '15:59:15'),
(19, 'Eve Li', '2024-06-01', '07:20:22', '19:31:13'),
(20, 'Eve Wang', '2024-06-01', '08:27:30', '17:58:26'),
(21, 'Eve Zhang', '2024-06-01', '08:30:25', '16:52:04'),
(22, '張三', '2024-06-01', '08:11:21', '16:09:45'),
(24, '張大偉', '2024-06-01', '07:28:26', '17:25:42'),
(25, '張小強', '2024-06-01', '08:33:52', '19:09:52'),
(26, '張小玲', '2024-06-01', '07:22:17', '18:35:12'),
(27, '張小華', '2024-06-01', '08:29:17', '17:30:38'),
(29, '張美麗', '2024-06-01', '07:01:37', '18:10:53'),
(31, '李大海', '2024-06-01', '07:51:41', '17:07:17'),
(32, '李小明', '2024-06-01', '08:34:58', '19:20:04'),
(33, '李小紅', '2024-06-01', '08:22:29', '18:28:19'),
(34, '李小花', '2024-06-01', '08:15:09', '15:44:48'),
(35, '李小龍', '2024-06-01', '08:04:58', '18:59:50'),
(36, '李建國', '2024-06-01', '07:48:58', '16:38:58'),
(37, '李強', '2024-06-01', '07:03:56', '19:03:01'),
(39, '李美麗', '2024-06-01', '08:56:19', '18:22:52'),
(40, '李華', '2024-06-01', '07:06:43', '16:45:25'),
(41, '王偉', '2024-06-01', '07:36:47', '20:16:32'),
(42, '王大衛', '2024-06-01', '07:01:22', '19:37:56'),
(43, '王小明', '2024-06-01', '08:17:18', '19:09:29'),
(44, '王小白', '2024-06-01', '07:27:43', '16:35:58'),
(45, '王小花', '2024-06-01', '07:10:05', '18:41:56'),
(46, '王小芳', '2024-06-01', '07:58:31', '17:44:59'),
(47, '王建國', '2024-06-01', '08:29:36', '19:06:18'),
(48, '王強', '2024-06-01', '08:09:09', '17:11:17'),
(49, '王美麗', '2024-06-01', '08:53:01', '17:12:17'),
(50, '陳五', '2024-06-01', '08:34:38', '18:18:26'),
(51, '陳大偉', '2024-06-01', '08:19:17', '20:03:58'),
(52, '陳大山', '2024-06-01', '08:07:54', '19:00:23'),
(53, '陳小強', '2024-06-01', '07:51:32', '16:45:28'),
(54, '陳小明', '2024-06-01', '07:10:04', '19:27:39'),
(55, '陳小白', '2024-06-01', '07:13:43', '18:25:28'),
(57, '陳美玲', '2024-06-01', '08:48:47', '19:50:56'),
(58, '陳美麗', '2024-06-01', '08:08:16', '19:18:39');

-- --------------------------------------------------------

--
-- 資料表結構 `datasystem`
--

CREATE TABLE `datasystem` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- 傾印資料表的資料 `datasystem`
--

INSERT INTO `datasystem` (`id`, `username`, `password`) VALUES
(1, 'test1', '$argon2id$v=19$m=65536,t=2,p=1$zJ8T15lJnO9FUvKB3nsZYg$PGlRfR+l6chhPgHKuHpuLsdRSidPBdKF0fOvHKzsmkk'),
(2, '333', '$argon2id$v=19$m=65536,t=2,p=1$zJ8T15lJnO9FUvKB3nsZYg$PGlRfR+l6chhPgHKuHpuLsdRSidPBdKF0fOvHKzsmkk'),
(3, '222', '$argon2id$v=19$m=65536,t=2,p=1$zJ8T15lJnO9FUvKB3nsZYg$PGlRfR+l6chhPgHKuHpuLsdRSidPBdKF0fOvHKzsmkk');

-- --------------------------------------------------------

--
-- 資料表結構 `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `position` varchar(100) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `employee`
--

INSERT INTO `employee` (`id`, `name`, `position`, `department`, `email`, `state`, `avatar`) VALUES
(1, 'Alice Chen', '開發工程師', '開發部', 'alicechen@gmail.com', '在職', NULL),
(2, '李小龍', '高級開發工程師', '開發部', 'xiaolongli@gmail.com', '在職', NULL),
(3, 'Bob Wang', '市場專員', '市場部', 'bobwang@gmail.com', '在職', NULL),
(4, '王大衛', '市場經理', '市場部', 'davidwang@gmail.com', '在職', NULL),
(5, 'Eve Zhang', '行政助理', '行政部', 'evezhang@gmail.com', '在職', NULL),
(6, '陳美麗', '行政經理', '行政部', 'meilichen@gmail.com', '在職', NULL),
(7, 'Charlie Li', '人事專員', '人力資源部', 'charlieli@gmail.com', '在職', NULL),
(8, '張偉', '人力資源經理', '人力資源部', 'weizhang@gmail.com', '在職', NULL),
(9, 'David Wu', '開發工程師', '開發部', 'davidwu@gmail.com', '在職', NULL),
(10, '李華', '高級開發工程師', '開發部', 'huali@gmail.com', '在職', NULL),
(11, 'Eve Wang', '市場專員', '市場部', 'evewang@gmail.com', '在職', NULL),
(12, '王強', '市場經理', '市場部', 'qiangwang@gmail.com', '在職', NULL),
(13, 'Alice Li', '行政助理', '行政部', 'aliceli@gmail.com', '在職', NULL),
(14, '李秀英', '行政經理', '行政部', 'xiuyingli@gmail.com', '在職', NULL),
(15, 'Bob Zhang', '人事專員', '人力資源部', 'bobzhang@gmail.com', '在職', NULL),
(16, '張建國', '人力資源經理', '人力資源部', 'jianguozhang@gmail.com', '在職', NULL),
(17, 'Charlie Chen', '開發工程師', '開發部', 'charliechen@gmail.com', '在職', NULL),
(18, '陳小紅', '高級開發工程師', '開發部', 'xiaohongchen@gmail.com', '在職', NULL),
(19, 'David Zhang', '市場專員', '市場部', 'davidzhang@gmail.com', '在職', NULL),
(20, '張三', '市場經理', '市場部', 'sanzhang@gmail.com', '在職', NULL),
(21, 'Eve Li', '行政助理', '行政部', 'eveli@gmail.com', '在職', NULL),
(22, '李四', '行政經理', '行政部', 'sili@gmail.com', '在職', NULL),
(23, 'Bob Chen', '人事專員', '人力資源部', 'bobchen@gmail.com', '在職', NULL),
(24, '陳五', '人力資源經理', '人力資源部', 'wuchen@gmail.com', '在職', NULL),
(25, 'Alice Wang', '開發工程師', '開發部', 'alicewang@gmail.com', '在職', NULL),
(26, '王小明', '高級開發工程師', '開發部', 'xiaomingwang@gmail.com', '在職', NULL),
(27, 'Charlie Wang', '市場專員', '市場部', 'charliewang@gmail.com', '在職', NULL),
(28, '王小芳', '市場經理', '市場部', 'xiaofangwang@gmail.com', '在職', NULL),
(29, 'David Li', '行政助理', '行政部', 'davidli@gmail.com', '在職', NULL),
(30, '李大海', '行政經理', '行政部', 'dahaili@gmail.com', '在職', NULL),
(31, 'Eve Chen', '人事專員', '人力資源部', 'evechen@gmail.com', '在職', NULL),
(32, '陳美玲', '人力資源經理', '人力資源部', 'meilingchen@gmail.com', '在職', NULL),
(33, 'Bob Li', '開發工程師', '開發部', 'bobli@gmail.com', '在職', NULL),
(34, '李強', '高級開發工程師', '開發部', 'qiangli@gmail.com', '在職', NULL),
(36, '陳大山', '市場經理', '市場部', 'dashanchen@gmail.com', '在職', NULL),
(37, 'Alice Zhang', '行政助理', '行政部', 'alicezhang@gmail.com', '在職', NULL),
(38, '張小華', '行政經理', '行政部', 'xiaohuazhang@gmail.com', '在職', NULL),
(39, 'David Wang', '人事專員', '人力資源部', 'davidwang@gmail.com', '在職', NULL),
(40, '王偉', '人力資源經理', '人力資源部', 'weiwang@gmail.com', '在職', NULL),
(42, '李小明', '高級開發工程師', '開發部', 'xiaomingli@gmail.com', '在職', NULL),
(44, '張小強', '市場經理', '市場部', 'xiaoqiangzhang@gmail.com', '在職', NULL),
(46, '王美麗', '行政經理', '行政部', 'meiliwang@gmail.com', '在職', NULL),
(47, 'David Chen', '人事專員', '人力資源部', 'davidchen@gmail.com', '在職', NULL),
(48, '陳小白', '人力資源經理', '人力資源部', 'xiaobaichen@gmail.com', '在職', NULL),
(50, '張小玲', '高級開發工程師', '開發部', 'xiaolingzhang@gmail.com', '在職', NULL),
(52, '李小花', '市場經理', '市場部', 'xiaohuali@gmail.com', '在職', NULL),
(54, '陳小強', '行政經理', '行政部', 'xiaoqiangchen@gmail.com', '在職', NULL),
(56, '王小白', '人力資源經理', '人力資源部', 'xiaobaiwang@gmail.com', '在職', NULL),
(58, '李小紅', '高級開發工程師', '開發部', 'xiaohongli@gmail.com', '在職', NULL),
(60, '陳大偉', '市場經理', '市場部', 'dawai@gmail.com', '在職', NULL),
(62, '張美麗', '行政經理', '行政部', 'meilizhang@gmail.com', '在職', NULL),
(64, '李建國', '人力資源經理', '人力資源部', 'jianguoli@gmail.com', '在職', NULL),
(66, '陳小明', '高級開發工程師', '開發部', 'xiaomingchen@gmail.com', '在職', NULL),
(68, '王小花', '市場經理', '市場部', 'xiaohuang@gmail.com', '在職', NULL),
(70, '李美麗', '行政經理', '行政部', 'meilili@gmail.com', '在職', NULL),
(71, 'Charlie Zhang', '人事專員', '人力資源部', 'charliezhang@gmail.com', '在職', NULL),
(72, '張大偉', '人力資源經理', '人力資源部', 'daiwei@gmail.com', '在職', NULL),
(74, '王建國', '高級開發工程師', '開發部', 'jianguowang@gmail.com', '在職', NULL);

-- --------------------------------------------------------

--
-- 資料表結構 `financial`
--

CREATE TABLE `financial` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `salary` int(11) NOT NULL,
  `salaryCal` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `financial`
--

INSERT INTO `financial` (`id`, `name`, `salary`, `salaryCal`) VALUES
(1, 'Alice Chen', 50000, '0 11'),
(2, '李小龍', 80000, '0 8'),
(3, 'Bob Wang', 45000, '0 10'),
(4, '王大衛', 70000, '0 9'),
(5, 'Eve Zhang', 40000, '0 11'),
(6, '陳美麗', 60000, '0 9'),
(7, 'Charlie Li', 55000, '0 9'),
(8, '張偉', 75000, '0 8'),
(9, 'David Wu', 50000, '0 10'),
(10, '李華', 80000, '0 8'),
(11, 'Eve Wang', 45000, '0 10'),
(12, '王強', 70000, '0 9'),
(13, 'Alice Li', 40000, '0 8'),
(14, '李秀英', 60000, '0 9'),
(15, 'Bob Zhang', 55000, '0 9'),
(16, '張建國', 75000, '0 8'),
(17, 'Charlie Chen', 50000, '0 10'),
(18, '陳小紅', 80000, '0 8'),
(19, 'David Zhang', 45000, '0 10'),
(20, '張三', 70000, '0 9'),
(21, 'Eve Li', 40000, '0 8'),
(22, '李四', 60000, '0 9'),
(23, 'Bob Chen', 55000, '0 9'),
(24, '陳五', 75000, '0 8'),
(25, 'Alice Wang', 50000, '0 10'),
(26, '王小明', 80000, '0 8'),
(27, 'Charlie Wang', 45000, '0 10'),
(28, '王小芳', 70000, '0 9'),
(29, 'David Li', 40000, '0 8'),
(30, '李大海', 60000, '0 9'),
(31, 'Eve Chen', 55000, '0 9'),
(32, '陳美玲', 75000, '0 8'),
(33, 'Bob Li', 50000, '0 10'),
(34, '李強', 80000, '0 8'),
(36, '陳大山', 70000, '0 9'),
(37, 'Alice Zhang', 40000, '0 8'),
(38, '張小華', 60000, '0 9'),
(39, 'David Wang', 55000, '0 9'),
(40, '王偉', 75000, '0 8'),
(42, '李小明', 80000, '0 8'),
(44, '張小強', 70000, '0 9'),
(46, '王美麗', 60000, '0 9'),
(47, 'David Chen', 55000, '0 9'),
(48, '陳小白', 75000, '0 8'),
(50, '張小玲', 80000, '0 8'),
(52, '李小花', 70000, '0 9'),
(54, '陳小強', 60000, '0 9'),
(56, '王小白', 75000, '0 8'),
(58, '李小紅', 80000, '0 8'),
(60, '陳大偉', 70000, '0 9'),
(62, '張美麗', 60000, '0 9'),
(64, '李建國', 75000, '0 8'),
(66, '陳小明', 80000, '0 8'),
(68, '王小花', 70000, '0 9'),
(70, '李美麗', 60000, '0 9'),
(71, 'Charlie Zhang', 55000, '0 9'),
(72, '張大偉', 75000, '0 8'),
(74, '王建國', 80000, '0 8');

-- --------------------------------------------------------

--
-- 資料表結構 `leavesystem`
--

CREATE TABLE `leavesystem` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `reason` varchar(100) NOT NULL,
  `start` date NOT NULL,
  `end` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 傾印資料表的資料 `leavesystem`
--

INSERT INTO `leavesystem` (`id`, `name`, `reason`, `start`, `end`) VALUES
(1, '張偉', '病假', '2024-06-01', '2024-06-03'),
(2, '李秀英', '年度假期', '2024-06-01', '2024-06-06'),
(3, '李四', '事假', '2024-06-01', '2024-06-02'),
(4, '陳小紅', '喪假', '2024-06-01', '2024-06-03'),
(5, '張建國', '婚假', '2024-06-01', '2024-06-04');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idx_attendance_date` (`date`),
  ADD KEY `idx_employee_name` (`employee_name`);

--
-- 資料表索引 `datasystem`
--
ALTER TABLE `datasystem`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idx_name` (`name`);

--
-- 資料表索引 `financial`
--
ALTER TABLE `financial`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idx_name` (`name`);

--
-- 資料表索引 `leavesystem`
--
ALTER TABLE `leavesystem`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idx_leavesystem_start` (`start`),
  ADD KEY `idx_leavesystem_end` (`end`),
  ADD KEY `idx_name` (`name`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `financial`
--
ALTER TABLE `financial`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `leavesystem`
--
ALTER TABLE `leavesystem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
