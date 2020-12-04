-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-12-2020 a las 19:30:30
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pia`
--
CREATE DATABASE IF NOT EXISTS `pia` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `pia`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consumos`
--

CREATE TABLE `consumos` (
  `id` int(11) NOT NULL,
  `claveReporte` varchar(2) NOT NULL COMMENT 'RA o RP',
  `planta` varchar(3) NOT NULL,
  `departamento` varchar(6) NOT NULL,
  `producto` varchar(6) NOT NULL,
  `cantConsumo` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `consumos`
--

INSERT INTO `consumos` (`id`, `claveReporte`, `planta`, `departamento`, `producto`, `cantConsumo`) VALUES
(1, 'RA', 'P01', 'D00001', 'P00001', 1),
(2, 'RP', 'P02', 'D00002', 'P00002', 3),
(3, 'RA', 'P03', 'D00003', 'P00005', 1),
(4, 'RA', 'P01', 'D00004', 'P00005', 2),
(5, 'RP', 'P05', 'D00002', 'P00004', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devoluciones`
--

CREATE TABLE `devoluciones` (
  `id` int(11) NOT NULL,
  `planta` varchar(3) NOT NULL,
  `departamento` varchar(6) NOT NULL,
  `producto` varchar(6) NOT NULL,
  `cantDevolucion` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `devoluciones`
--

INSERT INTO `devoluciones` (`id`, `planta`, `departamento`, `producto`, `cantDevolucion`) VALUES
(1, 'P01', 'D00001', 'P00001', 2),
(2, 'P01', 'D00002', 'P00002', 4),
(3, 'P02', 'D00001', 'P00003', 3),
(4, 'P03', 'D00003', 'P00005', 2),
(5, 'P02', 'D00003', 'P00004', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `producto` varchar(6) NOT NULL,
  `descripcion` varchar(20) NOT NULL,
  `precioUnitario` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `producto`, `descripcion`, `precioUnitario`) VALUES
(1, 'P00001', 'Producto 1', 10),
(2, 'P00002', 'Producto 2', 15),
(3, 'P00003', 'Producto 3', 20),
(4, 'P00004', 'Producto 4', 25),
(5, 'P00005', 'Producto 5', 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tablas`
--

CREATE TABLE `tablas` (
  `id` int(11) NOT NULL,
  `claveTabla` varchar(3) NOT NULL,
  `llaveTabla` varchar(19) NOT NULL,
  `informacion` varchar(58) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tablas`
--

INSERT INTO `tablas` (`id`, `claveTabla`, `llaveTabla`, `informacion`) VALUES
(1, 'T04', 'P01', 'MONTERREY, NUEVO LEON'),
(2, 'T04', 'P02', 'SAN NICOLAS DE LOS GARZA, NUEVO LEON'),
(3, 'T05', 'P01D01', 'JUGUETERIA'),
(4, 'T05', 'P02D02', 'PAPELERIA'),
(5, 'F01', '', '20201204'),
(6, 'F01', '', '20201212');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `consumos`
--
ALTER TABLE `consumos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `claveReporte` (`claveReporte`);

--
-- Indices de la tabla `devoluciones`
--
ALTER TABLE `devoluciones`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tablas`
--
ALTER TABLE `tablas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `claveTabla` (`claveTabla`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `consumos`
--
ALTER TABLE `consumos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `devoluciones`
--
ALTER TABLE `devoluciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tablas`
--
ALTER TABLE `tablas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
