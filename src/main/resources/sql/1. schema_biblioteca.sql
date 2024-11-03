-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `biblioteca` ;

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `biblioteca` ;

-- --------------------------------------cliente---------------
-- Table `biblioteca`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`cliente` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`cliente` (
  `id_cliente` VARCHAR(15) NOT NULL,
  `nombres` VARCHAR(60) NOT NULL,
  `apellidos` VARCHAR(60) NOT NULL,
  `direccion` VARCHAR(100) NULL,
  `edad` INT NOT NULL,
  `telefono` VARCHAR(20) NULL,
  PRIMARY KEY (`id_cliente`)
  )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `biblioteca`.`libro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`libro` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`libro` (
  `id_libro` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  `descripcion` VARCHAR(100) NOT NULL,
  `categoria` VARCHAR(15) NOT NULL,
  `autor` VARCHAR(20) NOT NULL,
  `ano` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`id_libro`)
  )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `biblioteca`.`prestamo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`prestamo` ;

CREATE TABLE IF NOT EXISTS `biblioteca`.`prestamo` (
  `id_prestamo` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` VARCHAR(15) NOT NULL,
  `id_libro` INT NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NULL,
  PRIMARY KEY (`id_prestamo`),
  CONSTRAINT `fk_PRESTAMO_CLIENTE`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `biblioteca`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRESTAMO_LIBRO`
    FOREIGN KEY (`id_libro`)
    REFERENCES `biblioteca`.`libro` (`id_libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;