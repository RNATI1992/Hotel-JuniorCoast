-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-03-2022 a las 23:37:57
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `allotjament`
--

CREATE TABLE `allotjament` (
  `id` int(11) NOT NULL,
  `num_bungalow` int(11) NOT NULL,
  `dni_client` varchar(9) NOT NULL,
  `dni_recepcionista` varchar(9) NOT NULL,
  `data_ingres` date NOT NULL,
  `hora_ingres` time NOT NULL,
  `data_sortida` date NOT NULL,
  `hora_sortida` varchar(100) NOT NULL,
  `preu_total` int(11) NOT NULL,
  `estat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `allotjament`
--

INSERT INTO `allotjament` (`id`, `num_bungalow`, `dni_client`, `dni_recepcionista`, `data_ingres`, `hora_ingres`, `data_sortida`, `hora_sortida`, `preu_total`, `estat`) VALUES
(1, 1, '47334052P', '9991234', '2022-03-03', '12:00:00', '2022-03-04', '21:00', 1275, 'Pagada'),
(2, 1, '47334052P', '9991234', '2022-03-05', '00:22:00', '2022-03-08', '08:02', 1225, 'Pagada'),
(3, 1, '47334052P', '9991234', '2022-03-03', '12:00:00', '2022-03-04', '21:00', 1275, 'Pagada'),
(4, 1, '47334052P', '9991234', '2022-03-09', '12:05:00', '2022-03-10', 'Pendent', 1250, 'Anulada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bungalow`
--

CREATE TABLE `bungalow` (
  `num_bungalow` int(11) NOT NULL,
  `caracteristiques` varchar(3000) NOT NULL,
  `preu` int(100) NOT NULL,
  `estat` varchar(100) NOT NULL,
  `tipus_bungalow` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `bungalow`
--

INSERT INTO `bungalow` (`num_bungalow`, `caracteristiques`, `preu`, `estat`, `tipus_bungalow`) VALUES
(1, '111', 1200, 'Desocupat', 'Duplex'),
(12, 'Es cool', 122, 'Ocupada', 'Especial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE `client` (
  `dni` varchar(9) NOT NULL,
  `email` varchar(200) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `cognoms` varchar(200) NOT NULL,
  `nacionalitat` varchar(100) NOT NULL,
  `telefon` int(50) NOT NULL,
  `ocupacio` varchar(200) NOT NULL,
  `estat_civil` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`dni`, `email`, `nom`, `cognoms`, `nacionalitat`, `telefon`, `ocupacio`, `estat_civil`) VALUES
('47334052P', 'redo@redo.com', 'redouan', 'nati', 'espanyola', 632594863, 'ocupat', 'Solter');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuari`
--

CREATE TABLE `usuari` (
  `dni` varchar(9) NOT NULL,
  `username` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `contrasenya` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `cognoms` varchar(200) NOT NULL,
  `nacionalitat` varchar(100) NOT NULL,
  `telefon` int(50) NOT NULL,
  `estat` varchar(100) NOT NULL,
  `rol` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuari`
--

INSERT INTO `usuari` (`dni`, `username`, `email`, `contrasenya`, `nom`, `cognoms`, `nacionalitat`, `telefon`, `estat`, `rol`) VALUES
('9991234', 'User', 'user@user', 'user', 'User', 'Useruser', 'Userlandia', 666, 'active', 'user'),
('99999999X', 'admin', 'admin@admin.com', 'admin', '', '', '', 999999999, 'active', 'admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `allotjament`
--
ALTER TABLE `allotjament`
  ADD PRIMARY KEY (`id`),
  ADD KEY `dni_client` (`dni_client`),
  ADD KEY `dni_recepcionista` (`dni_recepcionista`),
  ADD KEY `num_bungalow` (`num_bungalow`,`dni_client`,`data_ingres`) USING BTREE;

--
-- Indices de la tabla `bungalow`
--
ALTER TABLE `bungalow`
  ADD PRIMARY KEY (`num_bungalow`);

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `usuari`
--
ALTER TABLE `usuari`
  ADD PRIMARY KEY (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `allotjament`
--
ALTER TABLE `allotjament`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `bungalow`
--
ALTER TABLE `bungalow`
  MODIFY `num_bungalow` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `allotjament`
--
ALTER TABLE `allotjament`
  ADD CONSTRAINT `allotjament_ibfk_3` FOREIGN KEY (`num_bungalow`) REFERENCES `bungalow` (`num_bungalow`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `allotjament_ibfk_4` FOREIGN KEY (`dni_client`) REFERENCES `client` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `allotjament_ibfk_5` FOREIGN KEY (`dni_recepcionista`) REFERENCES `usuari` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
