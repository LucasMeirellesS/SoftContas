-- Obs: esse script foi gerado a partir de um modelo relacional criado por mim no MySQL utilizando a função Foward Engineer da aba Database.
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema contasoft
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema contasoft
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `contasoft` DEFAULT CHARACTER SET utf8 ;
USE `contasoft` ;

-- -----------------------------------------------------
-- Table `contasoft`.`plano_de_contas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contasoft`.`plano_de_contas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `natureza` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contasoft`.`patrimonio_liquido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contasoft`.`patrimonio_liquido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contas_id` INT NOT NULL,
  `grupo` VARCHAR(45),
  PRIMARY KEY (`id`),
  INDEX `fk_patrimonio_liquido_contas1_idx` (`contas_id` ASC) VISIBLE,
  CONSTRAINT `fk_patrimonio_liquido_contas1`
    FOREIGN KEY (`contas_id`)
    REFERENCES `contasoft`.`plano_de_contas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contasoft`.`ativo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contasoft`.`ativo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contas_id` INT NOT NULL,
  `grupo` VARCHAR(45) NOT NULL,
  `subgrupo` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ativo_contas_idx` (`contas_id` ASC) VISIBLE,
  CONSTRAINT `fk_ativo_contas`
    FOREIGN KEY (`contas_id`)
    REFERENCES `contasoft`.`plano_de_contas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contasoft`.`passivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contasoft`.`passivo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contas_id` INT NOT NULL,
  `grupo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_passivo_contas1_idx` (`contas_id` ASC) VISIBLE,
  CONSTRAINT `fk_passivo_contas1`
    FOREIGN KEY (`contas_id`)
    REFERENCES `contasoft`.`plano_de_contas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contasoft`.`contas_de_resultado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contasoft`.`contas_de_resultado` (
  `id` INT NOT NULL auto_increment,
  `contas_id` INT NOT NULL,
  `grupo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contas_de_resultado_contas1_idx` (`contas_id` ASC) VISIBLE,
  CONSTRAINT `fk_contas_de_resultado_contas1`
    FOREIGN KEY (`contas_id`)
    REFERENCES `contasoft`.`plano_de_contas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
