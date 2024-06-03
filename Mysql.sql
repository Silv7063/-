-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2024-06-03 10:49:06
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
CREATE DATABASE IF NOT EXISTS `ntoujava2024` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ntoujava2024`;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `financial`
--
ALTER TABLE `financial`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `leavesystem`
--
ALTER TABLE `leavesystem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- 資料庫： `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- 資料表結構 `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) NOT NULL DEFAULT '',
  `user` varchar(255) NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `query` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) NOT NULL,
  `col_name` varchar(64) NOT NULL,
  `col_type` varchar(64) NOT NULL,
  `col_length` text DEFAULT NULL,
  `col_collation` varchar(64) NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) DEFAULT '',
  `col_default` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `column_name` varchar(64) NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `transformation` varchar(255) NOT NULL DEFAULT '',
  `transformation_options` varchar(255) NOT NULL DEFAULT '',
  `input_transformation` varchar(255) NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) NOT NULL,
  `settings_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

--
-- 傾印資料表的資料 `pma__designer_settings`
--

INSERT INTO `pma__designer_settings` (`username`, `settings_data`) VALUES
('root', '{\"angular_direct\":\"direct\",\"snap_to_grid\":\"off\",\"relation_lines\":\"true\"}');

-- --------------------------------------------------------

--
-- 資料表結構 `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL,
  `export_type` varchar(10) NOT NULL,
  `template_name` varchar(64) NOT NULL,
  `template_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db` varchar(64) NOT NULL DEFAULT '',
  `table` varchar(64) NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) NOT NULL,
  `item_name` varchar(64) NOT NULL,
  `item_type` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- 傾印資料表的資料 `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{\"db\":\"ntoujava2024\",\"table\":\"attendance\"},{\"db\":\"ntoujava2024\",\"table\":\"employee\"},{\"db\":\"ntoujava2024\",\"table\":\"leavesystem\"},{\"db\":\"ntoujava2024\",\"table\":\"financial\"},{\"db\":\"ntoujava2024\",\"table\":\"datasystem\"}]');

-- --------------------------------------------------------

--
-- 資料表結構 `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) NOT NULL DEFAULT '',
  `master_table` varchar(64) NOT NULL DEFAULT '',
  `master_field` varchar(64) NOT NULL DEFAULT '',
  `foreign_db` varchar(64) NOT NULL DEFAULT '',
  `foreign_table` varchar(64) NOT NULL DEFAULT '',
  `foreign_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `search_name` varchar(64) NOT NULL DEFAULT '',
  `search_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `display_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `prefs` text NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

--
-- 傾印資料表的資料 `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'ntoujava2024', 'employee', '{\"CREATE_TIME\":\"2024-05-28 04:33:26\"}', '2024-05-29 13:00:10'),
('root', 'ntoujava2024', 'financial', '{\"CREATE_TIME\":\"2024-05-29 20:51:38\",\"sorted_col\":\"`id` ASC\"}', '2024-05-31 18:58:03'),
('root', 'ntoujava2024', 'leavesystem', '{\"CREATE_TIME\":\"2024-05-28 04:15:26\"}', '2024-05-29 13:00:23');

-- --------------------------------------------------------

--
-- 資料表結構 `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text NOT NULL,
  `schema_sql` text DEFAULT NULL,
  `data_sql` longtext DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- 傾印資料表的資料 `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2024-06-03 08:48:59', '{\"lang\":\"zh_TW\",\"Console\\/Mode\":\"collapse\",\"ThemeDefault\":\"pmahomme\",\"NavigationWidth\":206}');

-- --------------------------------------------------------

--
-- 資料表結構 `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) NOT NULL,
  `tab` varchar(64) NOT NULL,
  `allowed` enum('Y','N') NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- 資料表結構 `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) NOT NULL,
  `usergroup` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- 資料表索引 `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- 資料表索引 `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- 資料表索引 `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- 資料表索引 `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- 資料表索引 `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- 資料表索引 `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- 資料表索引 `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- 資料表索引 `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- 資料表索引 `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- 資料表索引 `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- 資料表索引 `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- 資料表索引 `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- 資料表索引 `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- 資料表索引 `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- 資料表索引 `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- 資料表索引 `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- 資料表索引 `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- 資料庫： `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
