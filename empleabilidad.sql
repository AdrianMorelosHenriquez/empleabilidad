-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-01-2013 a las 03:28:18
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `empleabilidad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE IF NOT EXISTS `area` (
  `idarea` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `profesion` int(10) unsigned NOT NULL,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `categoria` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idarea`),
  UNIQUE KEY `idarea_UNIQUE` (`idarea`),
  KEY `profesion_idx` (`profesion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `capacidad`
--

CREATE TABLE IF NOT EXISTS `capacidad` (
  `idcapacidad` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `area` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idcapacidad`),
  UNIQUE KEY `idcapacidad_UNIQUE` (`idcapacidad`),
  KEY `desempeño_idx` (`area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `capacidades_por_estudios`
--

CREATE TABLE IF NOT EXISTS `capacidades_por_estudios` (
  `idcapacidad_por_estudio` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `capacidad` int(10) unsigned NOT NULL,
  `estudios` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idcapacidad_por_estudio`),
  UNIQUE KEY `idcapacidad_por_estudio_UNIQUE` (`idcapacidad_por_estudio`),
  KEY `capacidad_idx` (`capacidad`),
  KEY `estudios_idx` (`estudios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `capacidades_por_experiencias`
--

CREATE TABLE IF NOT EXISTS `capacidades_por_experiencias` (
  `idcapporexperiencia` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `capacidad` int(10) unsigned NOT NULL,
  `experiencia` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idcapporexperiencia`),
  UNIQUE KEY `idcapporexperiencia_UNIQUE` (`idcapporexperiencia`),
  KEY `capacidad_idx` (`capacidad`),
  KEY `experiencia_idx` (`experiencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `capacidades_por_ofertas`
--

CREATE TABLE IF NOT EXISTS `capacidades_por_ofertas` (
  `idcapporofertas` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `oferta` int(10) unsigned NOT NULL,
  `capacidad` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idcapporofertas`),
  UNIQUE KEY `idcapporofertas_UNIQUE` (`idcapporofertas`),
  KEY `oferta_idx` (`oferta`),
  KEY `capacidad_idx` (`capacidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_personales`
--

CREATE TABLE IF NOT EXISTS `datos_personales` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombres` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `apellido1` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sexo` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `estado_civil` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `lugar_nacimiento` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `direccion` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `barrio` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `cudad` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL,
  `celular` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE IF NOT EXISTS `empresas` (
  `nit` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `actividad` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_contacto` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `representante_legal` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `celular_contacto` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `telefono_contacto` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`nit`),
  UNIQUE KEY `idempresas_UNIQUE` (`nit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudios`
--

CREATE TABLE IF NOT EXISTS `estudios` (
  `idestudios` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `aspirante` int(10) unsigned NOT NULL,
  `titulo` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT 'En caso de educación no formal, este campo registra el nombre del curso, seminariio, conferencia; en el caso de certificaciones tecnológica, aqui se guarda el nombre de la certificación',
  `institucion` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Quien concede el título, curso, seminario, certificación, etcétera.',
  `ciudad` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT 'La ciudad donde se culminó formalmente el estudio, o donde se hizo el curso, seminario, taller, certificación, etcétera.',
  `fecha_titulacion` date NOT NULL COMMENT 'Fecha en que se logra el titulo o se culminó el curso, seminario, taller, conferencia, etc.',
  `nivel_estudio` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Primaria, Bachillerato, Técnico, tecnólogo, profesional, especialización, maestría, curso, seminario, certificación, ponencia, conferencia, etcetera.',
  `estado_estudio` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Terminado, en curso, aplazado.',
  `area_estudio` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Creo que corresponde a Segurida, ingenniería, laboral, etcétera.',
  `fecha_start` date NOT NULL COMMENT 'Fecha de inicio de los estudios.',
  `tipo_estudio` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `promedio` decimal(5,1) DEFAULT NULL,
  `materias_carrera` int(11) DEFAULT NULL,
  `materias_cursadas` int(11) DEFAULT NULL,
  PRIMARY KEY (`idestudios`),
  UNIQUE KEY `idestudios_UNIQUE` (`idestudios`),
  KEY `aspirante_idx` (`aspirante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Esta clase tiene como propósito almacenar los datos relacionados con los estudios realizados por un aspirante. Un aspirante puede tener varios estudios de interés: primaria, bachillerato, técnico, tecnólogo, profesional, especialización, maestría, doctorado, curso, taller, seminario, conferencia, etcétera. El tipo de estudio se clasifican en formal e informal.\n\nEsta clase debe contener el id del aspirante y los datos de sus estudios, los cuales son, al menos, los siguientes:\nNombre de la institución.\nAño de inicio\nAño de terminación.\nTitulo obtenido\nCiudad de la Institución otorgadora del titulo\n\nImportante, tratar de obtener lista de colegios por ciudades, de ciudades por departamentos, de universidades por ciudades,etcétera. Algo parecido a lo que se hace en el portal de empleo del sena' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluaciones`
--

CREATE TABLE IF NOT EXISTS `evaluaciones` (
  `idtest` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `inscripcion` int(10) unsigned NOT NULL,
  `prueba` int(10) unsigned NOT NULL,
  `puntuacion` decimal(4,1) NOT NULL,
  `cualificacion` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `comentarios` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idtest`),
  UNIQUE KEY `identrevistas_UNIQUE` (`idtest`),
  KEY `inscripcion_idx` (`inscripcion`),
  KEY `prueba_idx` (`prueba`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencia_laboral`
--

CREATE TABLE IF NOT EXISTS `experiencia_laboral` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `area` int(10) unsigned NOT NULL,
  `nombre_empresa` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `cargo` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_in` date NOT NULL,
  `fecha_ou` date DEFAULT NULL,
  `actividad_empresa` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tipo_cargo` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion_tarea` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `aspirante` int(10) unsigned NOT NULL,
  `experiencia_laboralcol` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `aspirante_idx` (`aspirante`),
  KEY `area_desempenio_idx` (`area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Guarda las experiencias laborales de un aspirante' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE IF NOT EXISTS `inscripcion` (
  `idinscripcion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `aspirante` int(10) unsigned NOT NULL,
  `oferta` int(10) unsigned NOT NULL,
  `fecha` date NOT NULL,
  `entrevista` date NOT NULL,
  PRIMARY KEY (`idinscripcion`),
  UNIQUE KEY `idinscripcion_UNIQUE` (`idinscripcion`),
  KEY `aspirante_idx` (`aspirante`),
  KEY `oferta_idx` (`oferta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas`
--

CREATE TABLE IF NOT EXISTS `ofertas` (
  `idofertas` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nit` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `profesion` int(10) unsigned NOT NULL,
  `fecha_start` date NOT NULL,
  `fecha_end` date NOT NULL,
  `cargo` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `salario` decimal(10,0) NOT NULL,
  `descripcion` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `nivel_estudios_min` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `nivel_estudios_max` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idofertas`),
  UNIQUE KEY `idofertas_UNIQUE` (`idofertas`),
  KEY `empresa_idx` (`nit`),
  KEY `Ofertas_Profesionid_fk` (`profesion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesion`
--

CREATE TABLE IF NOT EXISTS `profesion` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `categoria` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Encarga de almacenar la información de las distintas profesiones formales e informales' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesiones_por_aspirante`
--

CREATE TABLE IF NOT EXISTS `profesiones_por_aspirante` (
  `idprofesones_aspirante` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `profesion` int(10) unsigned NOT NULL,
  `aspirante` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idprofesones_aspirante`),
  UNIQUE KEY `idprofesones_aspirante_UNIQUE` (`idprofesones_aspirante`),
  KEY `profesion_idx` (`profesion`),
  KEY `aspirante_idx` (`aspirante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesiones_por_oferta`
--

CREATE TABLE IF NOT EXISTS `profesiones_por_oferta` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `oferta` int(10) unsigned NOT NULL,
  `profesion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `Profesionporoferta_oferta_idx` (`oferta`),
  KEY `Profesionporoferta_profesion_fk_idx` (`profesion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pruebas`
--

CREATE TABLE IF NOT EXISTS `pruebas` (
  `idpruebas` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_prueba` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idpruebas`),
  UNIQUE KEY `idpruebas_UNIQUE` (`idpruebas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencias`
--

CREATE TABLE IF NOT EXISTS `referencias` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL,
  `celular` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `barrio` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ciudad` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `profesion` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cargo` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `aspirante` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `aspirante_idx` (`aspirante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `area`
--
ALTER TABLE `area`
  ADD CONSTRAINT `Area_Profesionid_fk` FOREIGN KEY (`profesion`) REFERENCES `profesion` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `capacidad`
--
ALTER TABLE `capacidad`
  ADD CONSTRAINT `Capacidad_Desempeñoid_fk` FOREIGN KEY (`area`) REFERENCES `area` (`idarea`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `capacidades_por_estudios`
--
ALTER TABLE `capacidades_por_estudios`
  ADD CONSTRAINT `CapacidadesporEstudios_Capacidadid_fk` FOREIGN KEY (`capacidad`) REFERENCES `capacidad` (`idcapacidad`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `CapacidadesporEstudios_Estudiosid_fk` FOREIGN KEY (`estudios`) REFERENCES `estudios` (`idestudios`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `capacidades_por_experiencias`
--
ALTER TABLE `capacidades_por_experiencias`
  ADD CONSTRAINT `CapacidadesporExperiencias_Capacidadid_fk` FOREIGN KEY (`capacidad`) REFERENCES `capacidad` (`idcapacidad`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `CapacidadesporExperiencias_Experienciaid_fk` FOREIGN KEY (`experiencia`) REFERENCES `experiencia_laboral` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `capacidades_por_ofertas`
--
ALTER TABLE `capacidades_por_ofertas`
  ADD CONSTRAINT `CapacidadesporOfertas_Ofertaid_fk` FOREIGN KEY (`oferta`) REFERENCES `ofertas` (`idofertas`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `CapacidadesporOfertas_Capacidadid_fk` FOREIGN KEY (`capacidad`) REFERENCES `capacidad` (`idcapacidad`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `estudios`
--
ALTER TABLE `estudios`
  ADD CONSTRAINT `Estudios_Aspiranteid_fk` FOREIGN KEY (`aspirante`) REFERENCES `datos_personales` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `evaluaciones`
--
ALTER TABLE `evaluaciones`
  ADD CONSTRAINT `Evaluacion_Inscripcionid_fk` FOREIGN KEY (`inscripcion`) REFERENCES `inscripcion` (`idinscripcion`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `Evaluacion_Pruebaid_fk` FOREIGN KEY (`prueba`) REFERENCES `pruebas` (`idpruebas`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `experiencia_laboral`
--
ALTER TABLE `experiencia_laboral`
  ADD CONSTRAINT `ExperienciaLaboral_Aspiranteid_fk` FOREIGN KEY (`aspirante`) REFERENCES `datos_personales` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `ExperienciaLaboral_Area` FOREIGN KEY (`area`) REFERENCES `area` (`idarea`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `Inscripcion_Aspiranteid_fk` FOREIGN KEY (`aspirante`) REFERENCES `datos_personales` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `Inscripcion_Ofertaid_fk` FOREIGN KEY (`oferta`) REFERENCES `ofertas` (`idofertas`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ofertas`
--
ALTER TABLE `ofertas`
  ADD CONSTRAINT `Ofertas_Empresaid_fk` FOREIGN KEY (`nit`) REFERENCES `empresas` (`nit`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `Ofertas_Profesionid_fk` FOREIGN KEY (`profesion`) REFERENCES `profesion` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `profesiones_por_aspirante`
--
ALTER TABLE `profesiones_por_aspirante`
  ADD CONSTRAINT `ProfesionesporAspirante_Profesionid_fk` FOREIGN KEY (`profesion`) REFERENCES `profesion` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `ProfesionesporAspirante_Aspiranteid_fk` FOREIGN KEY (`aspirante`) REFERENCES `datos_personales` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `profesiones_por_oferta`
--
ALTER TABLE `profesiones_por_oferta`
  ADD CONSTRAINT `Profesionporoferta_oferta_fk` FOREIGN KEY (`oferta`) REFERENCES `ofertas` (`idofertas`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `Profesionporoferta_profesion_fk` FOREIGN KEY (`profesion`) REFERENCES `profesion` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `referencias`
--
ALTER TABLE `referencias`
  ADD CONSTRAINT `Referencias_Aspiranteid_fk` FOREIGN KEY (`aspirante`) REFERENCES `datos_personales` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
