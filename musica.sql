-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-05-2025 a las 19:15:50
-- Versión del servidor: 5.7.17
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `musica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancioncompositor`
--

CREATE TABLE `cancioncompositor` (
  `idcancion` int(11) NOT NULL,
  `idcompositor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cancioncompositor`
--

INSERT INTO `cancioncompositor` (`idcancion`, `idcompositor`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(1, 4),
(2, 4),
(4, 4),
(2, 5),
(5, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canciones`
--

CREATE TABLE `canciones` (
  `idcancion` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechacreacion` varchar(10) NOT NULL,
  `duracion` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `canciones`
--

INSERT INTO `canciones` (`idcancion`, `nombre`, `fechacreacion`, `duracion`) VALUES
(1, 'Devils Never Cry', '052125', 210),
(2, 'Devil Trigger', '040125', 512),
(3, 'Bury The Light', '021525', 712),
(4, 'Believer', '042025', 192),
(5, 'Devils Never Cry SSS', '052525', 230);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compositores`
--

CREATE TABLE `compositores` (
  `idcompositor` int(10) NOT NULL,
  `nombrecompleto` varchar(50) NOT NULL,
  `edad` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `compositores`
--

INSERT INTO `compositores` (`idcompositor`, `nombrecompleto`, `edad`) VALUES
(1, 'Casey Edwards', 23),
(2, 'Imagine Dragons', 32),
(4, 'Queen', 85),
(5, 'The Weekend', 32),
(6, 'Franco', 99),
(7, 'Saul', 20),
(8, 'Ivan', 20);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cancioncompositor`
--
ALTER TABLE `cancioncompositor`
  ADD PRIMARY KEY (`idcancion`,`idcompositor`),
  ADD KEY `idcompositor` (`idcompositor`);

--
-- Indices de la tabla `canciones`
--
ALTER TABLE `canciones`
  ADD PRIMARY KEY (`idcancion`);

--
-- Indices de la tabla `compositores`
--
ALTER TABLE `compositores`
  ADD PRIMARY KEY (`idcompositor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `canciones`
--
ALTER TABLE `canciones`
  MODIFY `idcancion` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `compositores`
--
ALTER TABLE `compositores`
  MODIFY `idcompositor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cancioncompositor`
--
ALTER TABLE `cancioncompositor`
  ADD CONSTRAINT `cancioncompositor_ibfk_1` FOREIGN KEY (`idcancion`) REFERENCES `canciones` (`idcancion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cancioncompositor_ibfk_2` FOREIGN KEY (`idcompositor`) REFERENCES `compositores` (`idcompositor`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
