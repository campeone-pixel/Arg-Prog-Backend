-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: b36b1qyyaodmhkgy6skt-mysql.services.clever-cloud.com:3306
-- Generation Time: Jun 20, 2023 at 10:10 PM
-- Server version: 8.0.22-13
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `b36b1qyyaodmhkgy6skt`
--
CREATE DATABASE IF NOT EXISTS `b36b1qyyaodmhkgy6skt` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `b36b1qyyaodmhkgy6skt`;

-- --------------------------------------------------------

--
-- Table structure for table `educacion`
--

CREATE TABLE `educacion` (
  `id` bigint NOT NULL,
  `carrera` varchar(255) DEFAULT NULL,
  `escuela` varchar(255) DEFAULT NULL,
  `fin` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `inicio` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `educacion`
--

INSERT INTO `educacion` (`id`, `carrera`, `escuela`, `fin`, `imagen`, `inicio`, `titulo`) VALUES
(202, 'Data Analytics', 'coderhouse', 'Thu Sep 29 2022', 'https://i.imgur.com/posxPHb.png', 'Tue Jul 12 2022', 'Data Analyticss'),
(204, 'python django', 'coderhouse', 'Wed Sep 21 2022', 'https://i.imgur.com/Of0GX1Y.png', 'Mon Jun 20 2022', 'python django');

-- --------------------------------------------------------

--
-- Table structure for table `educacion_seq`
--

CREATE TABLE `educacion_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `educacion_seq`
--

INSERT INTO `educacion_seq` (`next_val`) VALUES
(301),
(301),
(301);

-- --------------------------------------------------------

--
-- Table structure for table `experiencia`
--

CREATE TABLE `experiencia` (
  `id` bigint NOT NULL,
  `puesto` varchar(255) DEFAULT NULL,
  `desde` varchar(255) DEFAULT NULL,
  `empresa` varchar(255) DEFAULT NULL,
  `hasta` varchar(255) DEFAULT NULL,
  `lugar` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `experiencia`
--

INSERT INTO `experiencia` (`id`, `puesto`, `desde`, `empresa`, `hasta`, `lugar`, `descripcion`) VALUES
(204, 'Coordinador tecnico', '8/12/2012', 'empresa provincial de la energia', '6/12/2063', 'rosario', 'Estoy a cargo del sector Estudios Tecnicos de la empresa'),
(209, 'Estibador', '5/15/2023', 'la virginia', '5/18/2023', 'rosario', 'realizaba trabajos en la linea de produccion de cafe');

-- --------------------------------------------------------

--
-- Table structure for table `experiencia_seq`
--

CREATE TABLE `experiencia_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `experiencia_seq`
--

INSERT INTO `experiencia_seq` (`next_val`) VALUES
(301),
(301),
(301);

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `id` bigint NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image_background_header` varchar(255) DEFAULT NULL,
  `image_perfil` varchar(255) DEFAULT NULL,
  `nacionalidad` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `ocupacion` varchar(255) DEFAULT NULL,
  `sobre_mi` varchar(255) DEFAULT NULL,
  `image_sobre_mi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`id`, `apellido`, `email`, `image_background_header`, `image_perfil`, `nacionalidad`, `nombres`, `ocupacion`, `sobre_mi`, `image_sobre_mi`) VALUES
(154, 'poses', 'posesmatiasabel@gmail.com', 'https://i.imgur.com/6ArQhzs.jpg', 'https://i.imgur.com/AxCTNg1.png', 'argentina', 'matias', 'programador fullstack', 'Empeze aprendiendo python porque necesitaba buscar una mejor manera de hacer mi trabajo y desde ahi no pare de aprender otros lenguajes. Ahora me di cuenta que la programacion es lo que me quiero dedicar. ', 'https://i.imgur.com/BtkuREn.png');

-- --------------------------------------------------------

--
-- Table structure for table `persona_seq`
--

CREATE TABLE `persona_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `persona_seq`
--

INSERT INTO `persona_seq` (`next_val`) VALUES
(251),
(251),
(251);

-- --------------------------------------------------------

--
-- Table structure for table `proyecto`
--

CREATE TABLE `proyecto` (
  `id` bigint NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `link_foto` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proyecto`
--

INSERT INTO `proyecto` (`id`, `descripcion`, `link`, `nombre`, `link_foto`) VALUES
(103, 'Un Blog que hice para el curso de Python en CoderHouse', 'https://github.com/campeone-pixel/blog', 'blog', 'https://i.imgur.com/RaFD11N.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `proyecto_seq`
--

CREATE TABLE `proyecto_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proyecto_seq`
--

INSERT INTO `proyecto_seq` (`next_val`) VALUES
(251),
(251),
(251);

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `id` bigint NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `porcentaje` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `skill`
--

INSERT INTO `skill` (`id`, `nombre`, `porcentaje`) VALUES
(106, 'python', '74'),
(108, 'javascript', '66');

-- --------------------------------------------------------

--
-- Table structure for table `skill_seq`
--

CREATE TABLE `skill_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `skill_seq`
--

INSERT INTO `skill_seq` (`next_val`) VALUES
(201),
(201),
(201);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint NOT NULL,
  `contraseña` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `contraseña`, `email`) VALUES
(2, '1984orwell', 'admin@admin.com'),
(52, '12345678', 'gabriel.poses@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `usuario_seq`
--

CREATE TABLE `usuario_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario_seq`
--

INSERT INTO `usuario_seq` (`next_val`) VALUES
(151);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `educacion`
--
ALTER TABLE `educacion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `experiencia`
--
ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
