-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2024 at 08:55 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flowstation_db`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `generate_sales_entries` ()   BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE sales_date DATE;
    DECLARE sales_id INT;
    DECLARE day_count INT DEFAULT 8;
    
    -- Loop to generate 200 entries
    WHILE i < 200 DO
        -- Calculate sales_date, spreading 200 entries across the last 8 days
        SET sales_date = CURDATE() - INTERVAL (FLOOR(i / (200 / day_count))) DAY;
        
        -- Generate a unique SalesID for each day
        SET sales_id = (SELECT IFNULL(MAX(SalesID), 0) + 1 FROM Sales WHERE Date = sales_date);
        
        -- Randomly generate container quantities sold
        SET @sold_large = FLOOR(RAND() * 10) + 1; -- Large containers (1-10)
        SET @sold_medium = FLOOR(RAND() * 10) + 1; -- Medium containers (1-10)
        SET @sold_small = FLOOR(RAND() * 10) + 1; -- Small containers (1-10)
        
        -- Calculate total profit
        SET @container_profit = (@sold_large * 25) + (@sold_medium * 15) + (@sold_small * 12.5);
        SET @container_fee = (@sold_large + @sold_medium + @sold_small) * 3; -- 3 per container
        
        -- 80% chance for delivery
        SET @delivery_fee = IF(RAND() < 0.8, 10, 0); -- 80% chance of delivery
        
        SET @total_profit = @container_profit + @container_fee + @delivery_fee;
        
        -- Ensure the profit is greater than 1000
        IF @total_profit < 1000 THEN
            SET @sold_large = 10;
            SET @sold_medium = 10;
            SET @sold_small = 10;
            SET @container_profit = (@sold_large * 25) + (@sold_medium * 15) + (@sold_small * 12.5);
            SET @container_fee = (@sold_large + @sold_medium + @sold_small) * 3; -- 3 per container
            SET @delivery_fee = IF(RAND() < 0.8, 10, 0); -- 80% chance of delivery
            SET @total_profit = @container_profit + @container_fee + @delivery_fee;
        END IF;
        
        -- Generate random time between 7:00 AM and 6:00 PM
        SET @hour = FLOOR(RAND() * 10) + 7;  -- Random hour between 7 and 17 (7 AM to 5 PM)
        SET @minute = LPAD(FLOOR(RAND() * 60), 2, '0');  -- Random minute (0-59)
        SET @second = LPAD(FLOOR(RAND() * 60), 2, '0');  -- Random second (0-59)
        SET @random_time = CONCAT(@hour, ':', @minute, ':', @second);  -- Combine hour, minute, and second
        
        -- Insert into Sales table (assuming Sales table already exists with columns as per earlier schema)
        INSERT INTO Sales (SalesID, CustomerID, Date, Time, Sold_Large_Container, Sold_Medium_Container, Sold_Small_Container, Delivery, Total_Fees, Customer_Payment, Customer_Change)
        VALUES (
            sales_id,  -- Use the same SalesID for all records from the same day
            FLOOR(RAND() * 50) + 1,  -- Random CustomerID from 1 to 50
            sales_date,
            @random_time,
            @sold_large,
            @sold_medium,
            @sold_small,
            IF(@delivery_fee > 0, TRUE, FALSE),  -- If delivery fee is > 0, delivery is TRUE
            @total_profit,
            @total_profit * 1.1, -- Customer Payment is 10% more than total fees (example)
            @total_profit * 0.1  -- Customer Change is 10% of the total fees (example)
        );
        
        SET i = i + 1;
    END WHILE;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminID` int(11) NOT NULL,
  `Admin_Name` varchar(255) NOT NULL,
  `Admin_Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminID`, `Admin_Name`, `Admin_Password`) VALUES
(1, 'Jared', 'thisismypassword'),
(2, 'Aeron', 'mypasskey'),
(3, 'Clyde', 'mypasscode'),
(4, 'Alyssa', 'aseriesofchars');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL,
  `Customer_Name` varchar(255) NOT NULL,
  `Contact_Number` varchar(20) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Lent_Large_Container` int(11) DEFAULT 0,
  `Lent_Medium_Container` int(11) DEFAULT 0,
  `Lent_Small_Container` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `Customer_Name`, `Contact_Number`, `Address`, `Lent_Large_Container`, `Lent_Medium_Container`, `Lent_Small_Container`) VALUES
(1, 'Juan dela Cruz', '0917-123-4567', 'Brgy. Wawa, Nasugbu, Batangas', 0, 0, 0),
(2, 'John Smith', '0918-234-5678', 'Brgy. Kaylaway, Nasugbu, Batangas', 0, 0, 0),
(3, 'Marie Curie', '0919-345-6789', 'Brgy. Calayo, Nasugbu, Batangas', 0, 0, 0),
(4, 'Carlos Santos', '0920-456-7890', 'Brgy. Tumalim, Nasugbu, Batangas', 0, 0, 0),
(5, 'Emma Johnson', '0921-567-8901', 'Brgy. Lumbangan, Nasugbu, Batangas', 0, 0, 0),
(6, 'Sofia Rossi', '0922-678-9012', 'Brgy. Bilaran, Nasugbu, Batangas', 0, 0, 0),
(7, 'Andres Bonifacio', '0923-789-0123', 'Brgy. Banilad, Nasugbu, Batangas', 0, 0, 0),
(8, 'Michael Brown', '0924-890-1234', 'Brgy. Balaytigui, Nasugbu, Batangas', 0, 0, 0),
(9, 'Lucas Müller', '0925-901-2345', 'Brgy. Aga, Nasugbu, Batangas', 0, 0, 0),
(10, 'Maria Clara', '0926-012-3456', 'Brgy. Catandaan, Lian, Batangas', 0, 0, 0),
(11, 'Daniela Silva', '0927-123-4567', 'Brgy. Kapito, Lian, Batangas', 0, 0, 0),
(12, 'William Taylor', '0928-234-5678', 'Brgy. Binubusan, Lian, Batangas', 0, 0, 0),
(13, 'Anika Schmidt', '0929-345-6789', 'Brgy. Matabungkay, Lian, Batangas', 0, 0, 0),
(14, 'Luna Garcia', '0930-456-7890', 'Brgy. Malaruhatan, Lian, Batangas', 0, 0, 0),
(15, 'James Wilson', '0931-567-8901', 'Brgy. San Diego, Lian, Batangas', 0, 0, 0),
(16, 'Chloe Martin', '0932-678-9012', 'Brgy. Bagong Pook, Nasugbu, Batangas', 0, 0, 0),
(17, 'Fernando Lopez', '0933-789-0123', 'Brgy. Caluangan, Nasugbu, Batangas', 0, 0, 0),
(18, 'Sophia Hernández', '0934-890-1234', 'Brgy. Lumaniag, Nasugbu, Batangas', 0, 0, 0),
(19, 'David Anderson', '0935-901-2345', 'Brgy. Dayap, Nasugbu, Batangas', 0, 0, 0),
(20, 'Anna Kowalski', '0936-012-3456', 'Brgy. Cogunan, Nasugbu, Batangas', 0, 0, 0),
(21, 'Jose Rizal', '0937-123-4567', 'Brgy. Catanghalan, Nasugbu, Batangas', 0, 0, 0),
(22, 'Isabella Leone', '0938-234-5678', 'Brgy. Bungahan, Nasugbu, Batangas', 0, 0, 0),
(23, 'Benjamin Scott', '0939-345-6789', 'Brgy. Natipuan, Nasugbu, Batangas', 0, 0, 0),
(24, 'Mia Jansson', '0940-456-7890', 'Brgy. Bulihan, Nasugbu, Batangas', 0, 0, 0),
(25, 'Gabriel Reyes', '0941-567-8901', 'Brgy. Calayo, Nasugbu, Batangas', 0, 0, 0),
(26, 'Olivia Brown', '0942-678-9012', 'Brgy. Sitio Balagbag, Nasugbu, Batangas', 0, 0, 0),
(27, 'Nina Petrova', '0943-789-0123', 'Brgy. Lumbangan, Nasugbu, Batangas', 0, 0, 0),
(28, 'Ethan Miller', '0944-890-1234', 'Brgy. Kayrilaw, Nasugbu, Batangas', 0, 0, 0),
(29, 'Layla Nowak', '0945-901-2345', 'Brgy. San Roque, Nasugbu, Batangas', 0, 0, 0),
(30, 'Diego Santiago', '0946-012-3456', 'Brgy. Talangan, Nasugbu, Batangas', 0, 0, 0),
(31, 'Alexander White', '0947-123-4567', 'Brgy. Munting Indang, Nasugbu, Batangas', 0, 0, 0),
(32, 'Victoria Ivanova', '0948-234-5678', 'Brgy. San Jose, Nasugbu, Batangas', 0, 0, 0),
(33, 'Lucas Costa', '0949-345-6789', 'Brgy. Barangay Uno, Nasugbu, Batangas', 0, 0, 0),
(34, 'Mika Takahashi', '0950-456-7890', 'Brgy. Tumalim, Nasugbu, Batangas', 0, 0, 0),
(35, 'Eleanor Clark', '0951-567-8901', 'Brgy. Aga, Nasugbu, Batangas', 0, 0, 0),
(36, 'Santiago Torres', '0952-678-9012', 'Brgy. Balaytigui, Nasugbu, Batangas', 0, 0, 0),
(37, 'Charlotte Davis', '0953-789-0123', 'Brgy. Banilad, Nasugbu, Batangas', 0, 0, 0),
(38, 'Mateo Cruz', '0954-890-1234', 'Brgy. Dayap, Nasugbu, Batangas', 0, 0, 0),
(39, 'Isla O\'Connor', '0955-901-2345', 'Brgy. Sitio Balagbag, Nasugbu, Batangas', 0, 0, 0),
(40, 'Joshua Brooks', '0956-012-3456', 'Brgy. San Roque, Nasugbu, Batangas', 0, 0, 0),
(41, 'Liam Dupont', '0957-123-4567', 'Brgy. Cogunan, Nasugbu, Batangas', 0, 0, 0),
(42, 'Amelia Svensson', '0958-234-5678', 'Brgy. Bungahan, Nasugbu, Batangas', 0, 0, 0),
(43, 'Nicolas Gomez', '0959-345-6789', 'Brgy. Binubusan, Lian, Batangas', 0, 0, 0),
(44, 'Mila Novak', '0960-456-7890', 'Brgy. Catandaan, Lian, Batangas', 0, 0, 0),
(45, 'Oliver King', '0961-567-8901', 'Brgy. Matabungkay, Lian, Batangas', 0, 0, 0),
(46, 'Dylan Singh', '0962-678-9012', 'Brgy. Kapito, Lian, Batangas', 0, 0, 0),
(47, 'Ava Martínez', '0963-789-0123', 'Brgy. Malaruhatan, Lian, Batangas', 0, 0, 0),
(48, 'Zoe Wilson', '0964-890-1234', 'Brgy. San Diego, Lian, Batangas', 0, 0, 0),
(49, 'Lucas Brown', '0965-901-2345', 'Brgy. Binubusan, Lian, Batangas', 0, 0, 0),
(50, 'Perseus Jackson', '0999-404-6969', 'Brgy. Malaruhatan, Lian, Batangas', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `InventoryID` int(11) NOT NULL,
  `PriceID` int(11) NOT NULL,
  `Container_Type` varchar(50) NOT NULL,
  `In_Storage_Quantity` int(11) DEFAULT 0,
  `Lent_Quantity` int(11) DEFAULT 0,
  `Total_Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`InventoryID`, `PriceID`, `Container_Type`, `In_Storage_Quantity`, `Lent_Quantity`, `Total_Quantity`) VALUES
(1, 1, '5/gl Large', 500, 0, 500),
(2, 2, '3/gl Medium', 500, 0, 500),
(3, 3, '2.5/gl Small', 500, 0, 500);

-- --------------------------------------------------------

--
-- Table structure for table `pricing`
--

CREATE TABLE `pricing` (
  `PriceID` int(11) NOT NULL,
  `Price_perGallon` int(11) NOT NULL,
  `Container_Size` double NOT NULL,
  `Container_Price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pricing`
--

INSERT INTO `pricing` (`PriceID`, `Price_perGallon`, `Container_Size`, `Container_Price`) VALUES
(1, 5, 5, 25),
(2, 5, 3, 15),
(3, 5, 2.5, 12.5);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `Date ID` int(11) NOT NULL,
  `SalesID` int(11) NOT NULL,
  `CustomerID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Sold_Large_Container` int(11) DEFAULT 0,
  `Sold_Medium_Container` int(11) DEFAULT 0,
  `Sold_Small_Container` int(11) DEFAULT 0,
  `Delivery` tinyint(1) DEFAULT 1,
  `Total_Fees` double NOT NULL,
  `Customer_Payment` double NOT NULL,
  `Customer_Change` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`SalesID`, `Date ID`, `CustomerID`, `Date`, `Time`, `Sold_Large_Container`, `Sold_Medium_Container`, `Sold_Small_Container`, `Delivery`, `Total_Fees`, `Customer_Payment`, `Customer_Change`) VALUES
(1, 1, 50, '2024-11-20', '13:34:54', 5, 0, 1, 0, 155.5, 780, 624.5),
(2, 1, 35, '2024-11-20', '08:27:45', 2, 1, 5, 1, 161.5, 310, 148.5),
(3, 1, 10, '2024-11-22', '08:54:24', 5, 0, 1, 0, 155.5, 970, 814.5),
(3, 1, 29, '2024-11-23', '08:00:21', 0, 2, 1, 1, 61.5, 950, 888.5),
(4, 1, 17, '2024-11-25', '11:15:59', 4, 4, 2, 0, 215, 380, 165),
(5, 1, 32, '2024-11-19', '12:46:19', 4, 4, 1, 1, 209.5, 990, 780.5),
(6, 1, 33, '2024-11-25', '09:21:04', 4, 3, 2, 1, 207, 650, 443),
(7, 1, 41, '2024-11-22', '17:18:17', 5, 3, 3, 0, 240.5, 690, 449.5),
(8, 1, 9, '2024-11-23', '13:40:25', 4, 4, 1, 0, 199.5, 980, 780.5),
(9, 1, 38, '2024-11-21', '07:18:14', 0, 2, 0, 1, 46, 620, 574),
(10, 1, 5, '2024-11-20', '18:36:54', 1, 5, 2, 1, 159, 950, 791),
(11, 1, 1, '2024-11-23', '11:01:06', 1, 1, 1, 0, 61.5, 660, 598.5),
(12, 1, 27, '2024-11-25', '08:33:30', 5, 5, 5, 0, 307.5, 830, 522.5),
(13, 1, 10, '2024-11-19', '08:20:20', 0, 0, 5, 0, 77.5, 110, 32.5),
(14, 1, 40, '2024-11-25', '17:32:14', 5, 5, 1, 1, 255.5, 840, 584.5),
(15, 1, 21, '2024-11-23', '13:38:08', 3, 2, 0, 1, 130, 480, 350),
(16, 1, 41, '2024-11-19', '16:28:28', 2, 5, 1, 0, 161.5, 600, 438.5),
(17, 1, 37, '2024-11-21', '07:46:32', 0, 0, 5, 1, 87.5, 790, 702.5),
(18, 1, 44, '2024-11-25', '08:02:08', 0, 1, 0, 1, 28, 830, 802),
(19, 1, 27, '2024-11-18', '16:06:13', 5, 3, 5, 1, 281.5, 540, 258.5),
(20, 1, 15, '2024-11-25', '15:24:47', 4, 2, 4, 1, 220, 300, 80),
(21, 1, 13, '2024-11-25', '16:39:43', 5, 3, 3, 0, 240.5, 860, 619.5),
(22, 1, 18, '2024-11-21', '15:28:43', 3, 3, 4, 0, 200, 490, 290),
(23, 1, 8, '2024-11-21', '18:47:38', 5, 0, 3, 0, 186.5, 470, 283.5),
(24, 1, 31, '2024-11-22', '11:46:03', 3, 3, 2, 0, 169, 180, 11),
(25, 2, 46, '2024-11-21', '09:47:13', 0, 2, 5, 0, 113.5, 460, 346.5),
(26, 2, 19, '2024-11-23', '13:46:02', 5, 1, 3, 0, 204.5, 180, -24.5),
(27, 2, 8, '2024-11-22', '09:23:18', 2, 5, 1, 1, 171.5, 220, 48.5),
(28, 2, 25, '2024-11-20', '18:04:59', 2, 3, 1, 0, 125.5, 170, 44.5),
(29, 2, 46, '2024-11-21', '13:53:20', 1, 0, 0, 0, 28, 990, 962),
(30, 2, 35, '2024-11-25', '07:20:19', 1, 0, 0, 1, 38, 410, 372),
(31, 2, 20, '2024-11-21', '14:15:53', 5, 0, 4, 0, 202, 930, 728),
(32, 2, 18, '2024-11-19', '13:50:36', 3, 2, 3, 1, 176.5, 680, 503.5),
(33, 2, 47, '2024-11-25', '15:46:13', 1, 3, 5, 1, 169.5, 980, 810.5),
(34, 2, 4, '2024-11-20', '13:18:34', 3, 2, 5, 1, 207.5, 640, 432.5),
(35, 2, 22, '2024-11-20', '13:17:52', 0, 0, 3, 1, 56.5, 440, 383.5),
(36, 2, 4, '2024-11-23', '11:57:14', 5, 1, 5, 0, 235.5, 650, 414.5),
(37, 2, 13, '2024-11-19', '07:56:43', 4, 3, 2, 1, 207, 800, 593),
(38, 2, 44, '2024-11-25', '13:20:44', 5, 2, 2, 0, 207, 980, 773),
(39, 2, 40, '2024-11-25', '15:20:03', 0, 0, 2, 0, 31, 150, 119),
(40, 2, 41, '2024-11-18', '10:29:06', 5, 3, 0, 0, 194, 150, -44),
(41, 2, 44, '2024-11-19', '14:29:51', 3, 5, 5, 1, 261.5, 920, 658.5),
(42, 2, 19, '2024-11-23', '16:58:16', 4, 5, 5, 1, 289.5, 800, 510.5),
(43, 2, 21, '2024-11-18', '07:05:00', 2, 0, 2, 1, 97, 740, 643),
(44, 2, 41, '2024-11-18', '17:06:45', 0, 5, 0, 0, 90, 160, 70),
(45, 2, 28, '2024-11-22', '08:44:38', 2, 4, 3, 0, 174.5, 250, 75.5),
(46, 2, 12, '2024-11-18', '16:18:48', 3, 4, 5, 1, 243.5, 890, 646.5),
(47, 2, 9, '2024-11-23', '12:20:58', 5, 5, 0, 0, 230, 180, -50),
(48, 2, 40, '2024-11-20', '18:40:21', 1, 2, 5, 0, 141.5, 660, 518.5),
(49, 2, 20, '2024-11-22', '08:49:17', 1, 2, 5, 0, 141.5, 660, 518.5),
(50, 3, 10, '2024-11-25', '18:10:43', 0, 0, 3, 0, 46.5, 160, 113.5),
(51, 3, 29, '2024-11-22', '17:07:32', 5, 5, 1, 1, 255.5, 210, -45.5),
(52, 3, 27, '2024-11-25', '13:39:24', 2, 3, 3, 1, 166.5, 640, 473.5),
(53, 3, 34, '2024-11-18', '08:30:21', 3, 0, 2, 0, 115, 430, 315),
(54, 3, 42, '2024-11-25', '16:59:22', 5, 3, 0, 1, 204, 420, 216),
(55, 3, 28, '2024-11-20', '15:51:20', 1, 1, 2, 1, 87, 350, 263),
(56, 3, 22, '2024-11-25', '12:28:20', 5, 5, 1, 1, 255.5, 750, 494.5),
(57, 3, 44, '2024-11-25', '16:39:14', 3, 0, 5, 0, 161.5, 650, 488.5),
(58, 3, 31, '2024-11-23', '12:09:02', 4, 2, 5, 1, 235.5, 920, 684.5),
(59, 3, 24, '2024-11-18', '09:19:20', 2, 0, 5, 1, 143.5, 340, 196.5),
(60, 3, 30, '2024-11-25', '08:04:47', 2, 3, 1, 0, 125.5, 120, -5.5),
(61, 3, 8, '2024-11-19', '08:23:53', 1, 2, 3, 1, 120.5, 600, 479.5),
(62, 3, 4, '2024-11-20', '18:21:45', 1, 3, 3, 1, 138.5, 570, 431.5),
(63, 3, 25, '2024-11-22', '15:09:12', 5, 3, 2, 0, 225, 250, 25),
(64, 3, 43, '2024-11-25', '08:32:35', 1, 3, 0, 1, 92, 290, 198),
(65, 3, 31, '2024-11-23', '16:19:43', 2, 1, 3, 0, 120.5, 130, 9.5),
(66, 3, 19, '2024-11-21', '15:09:36', 1, 0, 3, 1, 84.5, 390, 305.5),
(67, 3, 8, '2024-11-23', '10:57:27', 4, 5, 3, 1, 258.5, 160, -98.5),
(68, 3, 31, '2024-11-25', '15:14:47', 3, 5, 3, 0, 220.5, 150, -70.5),
(69, 3, 1, '2024-11-20', '15:22:18', 3, 1, 2, 1, 143, 410, 267),
(70, 3, 3, '2024-11-21', '13:37:02', 0, 1, 3, 1, 74.5, 820, 745.5),
(71, 3, 32, '2024-11-21', '13:00:34', 1, 1, 0, 1, 56, 730, 674),
(72, 3, 18, '2024-11-21', '16:21:23', 4, 3, 2, 0, 197, 810, 613),
(73, 3, 9, '2024-11-20', '08:28:17', 3, 0, 5, 0, 161.5, 240, 78.5),
(74, 3, 47, '2024-11-21', '16:35:21', 4, 0, 4, 0, 174, 120, -54),
(75, 4, 31, '2024-11-19', '17:34:02', 5, 0, 5, 0, 217.5, 310, 92.5),
(76, 4, 9, '2024-11-24', '10:17:51', 4, 3, 0, 1, 176, 550, 374),
(77, 4, 27, '2024-11-21', '08:05:18', 4, 0, 0, 0, 112, 810, 698),
(78, 4, 41, '2024-11-22', '08:02:21', 1, 0, 0, 1, 38, 310, 272),
(79, 4, 25, '2024-11-18', '10:21:15', 0, 2, 0, 1, 46, 100, 54),
(80, 4, 23, '2024-11-20', '10:32:03', 5, 0, 1, 0, 155.5, 690, 534.5),
(81, 4, 18, '2024-11-21', '10:18:53', 2, 1, 2, 1, 115, 440, 325),
(82, 4, 42, '2024-11-22', '12:11:25', 5, 4, 0, 1, 222, 690, 468),
(83, 4, 31, '2024-11-18', '12:44:40', 0, 3, 2, 0, 85, 400, 315),
(84, 4, 6, '2024-11-25', '12:10:44', 2, 2, 3, 0, 138.5, 310, 171.5),
(85, 4, 7, '2024-11-22', '16:13:03', 0, 1, 1, 0, 33.5, 150, 116.5),
(86, 4, 5, '2024-11-20', '08:50:00', 5, 2, 5, 1, 263.5, 720, 456.5),
(87, 4, 31, '2024-11-22', '08:31:32', 0, 3, 2, 1, 95, 930, 835),
(88, 4, 47, '2024-11-23', '17:02:25', 3, 2, 2, 0, 151, 260, 109),
(89, 4, 4, '2024-11-21', '11:34:49', 5, 4, 4, 0, 274, 330, 56),
(90, 4, 3, '2024-11-19', '17:46:59', 2, 2, 0, 1, 102, 190, 88),
(91, 4, 30, '2024-11-25', '15:16:13', 1, 5, 0, 1, 128, 720, 592),
(92, 4, 7, '2024-11-21', '16:12:48', 5, 0, 3, 0, 186.5, 480, 293.5),
(93, 4, 20, '2024-11-19', '12:18:49', 4, 5, 2, 1, 243, 490, 247),
(94, 4, 15, '2024-11-25', '16:05:13', 1, 0, 2, 1, 69, 880, 811),
(95, 4, 34, '2024-11-22', '13:42:24', 1, 3, 2, 1, 123, 620, 497),
(96, 4, 46, '2024-11-21', '15:49:32', 2, 0, 4, 1, 128, 700, 572),
(97, 4, 32, '2024-11-23', '09:14:45', 2, 5, 1, 1, 171.5, 780, 608.5),
(98, 4, 44, '2024-11-19', '16:23:58', 2, 1, 3, 0, 120.5, 430, 309.5),
(99, 4, 22, '2024-11-22', '15:51:45', 1, 4, 5, 1, 187.5, 480, 292.5),
(100, 5, 29, '2024-11-18', '07:07:14', 1, 4, 2, 1, 141, 710, 569),
(101, 5, 39, '2024-11-19', '13:31:06', 1, 3, 0, 0, 82, 230, 148),
(102, 5, 24, '2024-11-18', '07:27:01', 4, 3, 4, 0, 228, 680, 452),
(103, 5, 27, '2024-11-23', '12:23:24', 4, 2, 0, 0, 148, 320, 172),
(104, 5, 4, '2024-11-22', '07:12:26', 3, 4, 1, 0, 171.5, 450, 278.5),
(105, 5, 3, '2024-11-19', '13:19:23', 0, 3, 2, 1, 95, 340, 245),
(106, 5, 6, '2024-11-25', '11:48:38', 2, 0, 5, 1, 143.5, 880, 736.5),
(107, 5, 4, '2024-11-23', '15:29:16', 2, 0, 1, 0, 71.5, 780, 708.5),
(108, 5, 8, '2024-11-18', '15:08:12', 2, 0, 4, 1, 128, 850, 722),
(109, 5, 33, '2024-11-25', '17:01:04', 5, 2, 0, 1, 186, 220, 34),
(110, 5, 27, '2024-11-18', '15:32:12', 5, 5, 3, 0, 276.5, 700, 423.5),
(111, 5, 32, '2024-11-18', '08:43:48', 4, 0, 0, 0, 112, 930, 818),
(112, 5, 5, '2024-11-20', '16:08:39', 4, 1, 5, 0, 207.5, 700, 492.5),
(113, 5, 13, '2024-11-21', '16:14:34', 1, 0, 2, 0, 59, 400, 341),
(114, 5, 11, '2024-11-19', '14:46:36', 5, 4, 1, 1, 237.5, 920, 682.5),
(115, 5, 14, '2024-11-22', '12:29:13', 4, 4, 1, 1, 209.5, 880, 670.5),
(116, 5, 50, '2024-11-18', '07:00:28', 0, 3, 4, 0, 116, 300, 184),
(117, 5, 44, '2024-11-18', '12:29:51', 2, 5, 1, 1, 171.5, 640, 468.5),
(118, 5, 7, '2024-11-20', '15:51:51', 4, 0, 1, 1, 137.5, 820, 682.5),
(119, 5, 3, '2024-11-23', '18:12:06', 1, 5, 4, 1, 190, 550, 360),
(120, 5, 11, '2024-11-24', '17:27:02', 4, 1, 4, 0, 192, 790, 598),
(121, 5, 5, '2024-11-21', '12:38:53', 2, 1, 2, 1, 115, 830, 715),
(122, 5, 6, '2024-11-19', '16:31:03', 4, 4, 1, 1, 209.5, 440, 230.5),
(123, 5, 27, '2024-11-23', '10:13:34', 5, 5, 3, 1, 286.5, 280, -6.5),
(124, 5, 15, '2024-11-21', '08:25:03', 5, 3, 0, 1, 204, 350, 146),
(125, 6, 37, '2024-11-22', '18:52:36', 1, 1, 2, 0, 77, 540, 463),
(126, 6, 15, '2024-11-22', '16:47:16', 5, 3, 3, 0, 240.5, 430, 189.5),
(127, 6, 43, '2024-11-21', '08:23:00', 5, 1, 0, 0, 158, 230, 72),
(128, 6, 9, '2024-11-18', '13:49:06', 2, 0, 5, 1, 143.5, 750, 606.5),
(129, 6, 31, '2024-11-21', '10:03:37', 4, 4, 0, 0, 184, 600, 416),
(130, 6, 11, '2024-11-23', '12:04:04', 2, 2, 4, 1, 164, 930, 766),
(131, 6, 11, '2024-11-23', '17:33:11', 4, 1, 2, 0, 161, 540, 379),
(132, 6, 34, '2024-11-18', '11:50:05', 3, 3, 4, 1, 210, 960, 750),
(133, 6, 32, '2024-11-23', '10:34:55', 2, 0, 2, 0, 87, 880, 793),
(134, 6, 30, '2024-11-23', '10:17:41', 4, 2, 0, 1, 158, 390, 232),
(135, 6, 26, '2024-11-20', '16:09:15', 2, 5, 1, 1, 171.5, 120, -51.5),
(136, 6, 6, '2024-11-18', '15:53:49', 3, 4, 0, 0, 156, 750, 594),
(137, 6, 19, '2024-11-20', '10:47:15', 4, 0, 4, 1, 184, 620, 436),
(138, 6, 31, '2024-11-21', '11:06:04', 5, 2, 1, 0, 191.5, 350, 158.5),
(139, 6, 38, '2024-11-20', '11:56:48', 0, 1, 2, 1, 59, 360, 301),
(140, 6, 41, '2024-11-24', '08:45:23', 0, 1, 0, 0, 46, 400, 354),
(141, 6, 14, '2024-11-24', '09:47:39', 5, 4, 2, 0, 243, 440, 197),
(142, 6, 7, '2024-11-24', '08:02:34', 3, 0, 0, 0, 84, 500, 416),
(143, 6, 12, '2024-11-21', '09:45:27', 2, 2, 2, 1, 133, 950, 817),
(144, 6, 38, '2024-11-25', '18:43:33', 0, 4, 0, 0, 72, 800, 728),
(145, 6, 6, '2024-11-25', '11:35:58', 4, 5, 0, 0, 202, 510, 308),
(146, 6, 35, '2024-11-23', '14:30:03', 5, 2, 1, 1, 201.5, 970, 768.5),
(147, 6, 37, '2024-11-23', '08:32:51', 0, 2, 5, 1, 123.5, 730, 606.5),
(148, 6, 28, '2024-11-18', '10:43:52', 3, 0, 0, 1, 94, 770, 676),
(149, 6, 31, '2024-11-24', '17:50:22', 1, 3, 5, 0, 159.5, 960, 800.5),
(150, 7, 8, '2024-11-22', '17:42:34', 2, 0, 4, 1, 128, 200, 72),
(151, 7, 12, '2024-11-22', '18:25:49', 4, 2, 5, 0, 225.5, 970, 744.5),
(152, 7, 18, '2024-11-24', '18:37:32', 4, 5, 3, 1, 258.5, 780, 521.5),
(153, 7, 13, '2024-11-22', '07:57:15', 1, 5, 4, 1, 190, 110, -80),
(154, 7, 12, '2024-11-20', '16:03:23', 4, 4, 0, 0, 184, 830, 646),
(155, 7, 46, '2024-11-24', '12:12:59', 5, 4, 1, 0, 227.5, 320, 92.5),
(156, 7, 39, '2024-11-18', '14:54:40', 5, 4, 2, 0, 243, 260, 17),
(157, 7, 19, '2024-11-20', '09:49:23', 3, 0, 4, 1, 156, 670, 514),
(158, 7, 16, '2024-11-23', '13:39:59', 1, 5, 1, 1, 143.5, 900, 756.5),
(159, 7, 35, '2024-11-23', '13:19:29', 3, 5, 1, 1, 199.5, 290, 90.5),
(160, 7, 45, '2024-11-22', '15:30:21', 3, 1, 4, 1, 174, 590, 416),
(161, 7, 7, '2024-11-21', '18:59:43', 0, 2, 4, 1, 108, 990, 882),
(162, 7, 37, '2024-11-19', '11:37:55', 4, 1, 4, 1, 202, 690, 488),
(163, 7, 12, '2024-11-20', '09:06:11', 3, 3, 5, 1, 225.5, 810, 584.5),
(164, 7, 42, '2024-11-25', '12:32:05', 3, 2, 1, 0, 135.5, 400, 264.5),
(165, 7, 34, '2024-11-20', '07:34:25', 0, 5, 4, 1, 162, 940, 778),
(166, 7, 40, '2024-11-18', '18:54:28', 0, 4, 3, 1, 128.5, 530, 401.5),
(167, 7, 41, '2024-11-25', '08:19:17', 5, 5, 2, 1, 271, 670, 399),
(168, 7, 29, '2024-11-21', '17:15:32', 5, 0, 2, 1, 181, 490, 309),
(169, 7, 5, '2024-11-23', '07:55:40', 2, 0, 4, 1, 128, 490, 362),
(170, 7, 17, '2024-11-24', '17:22:04', 3, 3, 2, 1, 179, 720, 541),
(171, 7, 44, '2024-11-19', '08:05:21', 5, 2, 4, 0, 238, 540, 302),
(172, 7, 43, '2024-11-22', '10:18:53', 3, 1, 4, 0, 164, 560, 396),
(173, 7, 23, '2024-11-20', '11:11:41', 1, 3, 1, 1, 107.5, 800, 692.5),
(174, 7, 22, '2024-11-21', '11:59:35', 5, 2, 2, 1, 217, 620, 403),
(175, 8, 7, '2024-11-21', '10:06:55', 2, 0, 1, 0, 71.5, 130, 58.5),
(176, 8, 1, '2024-11-19', '15:02:54', 3, 1, 2, 1, 143, 490, 347),
(177, 8, 21, '2024-11-23', '12:52:02', 3, 2, 0, 0, 120, 190, 70),
(178, 8, 41, '2024-11-19', '12:06:59', 0, 0, 5, 1, 87.5, 730, 642.5),
(179, 8, 26, '2024-11-22', '09:25:21', 5, 3, 0, 1, 204, 930, 726),
(180, 8, 25, '2024-11-18', '15:03:00', 3, 1, 2, 1, 143, 540, 397),
(181, 8, 27, '2024-11-22', '14:55:32', 2, 1, 3, 1, 130.5, 240, 109.5),
(182, 8, 13, '2024-11-24', '15:03:26', 2, 2, 0, 1, 102, 710, 608),
(183, 8, 49, '2024-11-22', '08:19:08', 4, 2, 1, 0, 163.5, 190, 26.5),
(184, 8, 33, '2024-11-24', '11:31:33', 2, 3, 3, 1, 166.5, 610, 443.5),
(185, 8, 36, '2024-11-22', '07:16:36', 1, 0, 1, 0, 43.5, 550, 506.5),
(186, 8, 1, '2024-11-19', '12:06:18', 2, 4, 4, 1, 200, 1000, 800),
(187, 8, 37, '2024-11-21', '16:47:11', 5, 2, 3, 0, 222.5, 420, 197.5),
(188, 8, 31, '2024-11-18', '14:48:31', 3, 4, 1, 1, 181.5, 870, 688.5),
(189, 8, 1, '2024-11-18', '10:20:54', 2, 5, 2, 0, 177, 720, 543),
(190, 8, 49, '2024-11-24', '17:09:44', 1, 4, 5, 1, 187.5, 850, 662.5),
(191, 8, 15, '2024-11-22', '17:02:54', 5, 3, 2, 0, 225, 920, 695),
(192, 8, 11, '2024-11-23', '09:55:06', 4, 3, 4, 1, 238, 580, 342),
(193, 8, 41, '2024-11-21', '18:26:49', 2, 5, 4, 0, 208, 220, 12),
(194, 8, 44, '2024-11-25', '16:13:53', 5, 4, 0, 1, 222, 620, 398),
(195, 8, 27, '2024-11-24', '08:08:32', 5, 2, 4, 0, 238, 120, -118),
(196, 8, 32, '2024-11-19', '14:11:40', 4, 5, 4, 1, 274, 570, 296),
(197, 8, 22, '2024-11-20', '11:57:16', 0, 3, 2, 0, 85, 580, 495),
(198, 8, 12, '2024-11-25', '08:05:06', 4, 5, 5, 1, 289.5, 880, 590.5),
(199, 8, 38, '2024-11-21', '17:12:31', 3, 5, 0, 1, 184, 690, 506)
(451, 8, 38, '2024-11-21', '17:12:31', 3, 5, 0, 1, 184, 690, 506);

-- --------------------------------------------------------

--
-- Table structure for table `salescatalog`
--

CREATE TABLE `salescatalog` (
  `CatalogID` int(11) NOT NULL,
  `SalesID` int(11) NOT NULL,
  `Expenses` double NOT NULL,
  `TotalProfit` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`InventoryID`),
  ADD KEY `PriceID` (`PriceID`);

--
-- Indexes for table `pricing`
--
ALTER TABLE `pricing`
  ADD PRIMARY KEY (`PriceID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`Date ID`),
  ADD KEY `CustomerID` (`CustomerID`);

--
-- Indexes for table `salescatalog`
--
ALTER TABLE `salescatalog`
  ADD PRIMARY KEY (`CatalogID`),
  ADD KEY `SalesID` (`SalesID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AdminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `InventoryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pricing`
--
ALTER TABLE `pricing`
  MODIFY `PriceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `Date ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=452;

--
-- AUTO_INCREMENT for table `salescatalog`
--
ALTER TABLE `salescatalog`
  MODIFY `CatalogID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`PriceID`) REFERENCES `pricing` (`PriceID`);

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`);

--
-- Constraints for table `salescatalog`
--
ALTER TABLE `salescatalog`
  ADD CONSTRAINT `salescatalog_ibfk_1` FOREIGN KEY (`SalesID`) REFERENCES `sales` (`Date ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
