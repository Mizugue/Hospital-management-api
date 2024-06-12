SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hospital` ;

-- -----------------------------------------------------
-- Schema hospital
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hospital` DEFAULT CHARACTER SET utf8 ;
USE `hospital` ;

-- -----------------------------------------------------
-- Table `hospital`.`patient_state`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`patient_state` ;

CREATE TABLE IF NOT EXISTS `hospital`.`patient_state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `state` ENUM("discharged", "not_discharged") NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`patient` ;

CREATE TABLE IF NOT EXISTS `hospital`.`patient` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `sickness` VARCHAR(45) NOT NULL,
  `id_pat_state` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_patient_3_idx` (`id_pat_state` ASC) VISIBLE,
  CONSTRAINT `fk_patient_3`
    FOREIGN KEY (`id_pat_state`)
    REFERENCES `hospital`.`patient_state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`attendant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`attendant` ;

CREATE TABLE IF NOT EXISTS `hospital`.`attendant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`ambulance_state`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`ambulance_state` ;

CREATE TABLE IF NOT EXISTS `hospital`.`ambulance_state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `state` ENUM("parked", "active") NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`ambulance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`ambulance` ;

CREATE TABLE IF NOT EXISTS `hospital`.`ambulance` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `plate` VARCHAR(45) NOT NULL,
  `id_amb_state` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ambulance_3_idx` (`id_amb_state` ASC) VISIBLE,
  CONSTRAINT `fk_ambulance_3`
    FOREIGN KEY (`id_amb_state`)
    REFERENCES `hospital`.`ambulance_state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`emergency_service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`emergency_service` ;

CREATE TABLE IF NOT EXISTS `hospital`.`emergency_service` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_ambulance` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_emergency_service_1_idx` (`id_ambulance` ASC) VISIBLE,
  CONSTRAINT `fk_emergency_service_1`
    FOREIGN KEY (`id_ambulance`)
    REFERENCES `hospital`.`ambulance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`doctor_state`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`doctor_state` ;

CREATE TABLE IF NOT EXISTS `hospital`.`doctor_state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `state` ENUM("busy", "unoccupied") NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`especialization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`especialization` ;

CREATE TABLE IF NOT EXISTS `hospital`.`especialization` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `especialization` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`doctor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`doctor` ;

CREATE TABLE IF NOT EXISTS `hospital`.`doctor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `crm` VARCHAR(6) NOT NULL,
  `id_specialization` INT NOT NULL,
  `id_doc_state` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_doctor_2_idx` (`id_doc_state` ASC) VISIBLE,
  INDEX `fk_doctor_3_idx` (`id_specialization` ASC) VISIBLE,
  CONSTRAINT `fk_doctor_2`
    FOREIGN KEY (`id_doc_state`)
    REFERENCES `hospital`.`doctor_state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_doctor_3`
    FOREIGN KEY (`id_specialization`)
    REFERENCES `hospital`.`especialization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`room_state`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`room_state` ;

CREATE TABLE IF NOT EXISTS `hospital`.`room_state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `state` ENUM("occupied", "vacant") NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`room` ;

CREATE TABLE IF NOT EXISTS `hospital`.`room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(10) NOT NULL,
  `id_room_state` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_room_1_idx` (`id_room_state` ASC) VISIBLE,
  CONSTRAINT `fk_room_1`
    FOREIGN KEY (`id_room_state`)
    REFERENCES `hospital`.`room_state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`hospitalization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`hospitalization` ;

CREATE TABLE IF NOT EXISTS `hospital`.`hospitalization` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_doctor` INT NOT NULL,
  `id_patient` INT NOT NULL,
  `id_room` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_service_1_idx` (`id_doctor` ASC) VISIBLE,
  INDEX `fk_service_2_idx` (`id_patient` ASC) VISIBLE,
  INDEX `fk_service_3_idx` (`id_room` ASC) VISIBLE,
  CONSTRAINT `fk_hospitalization_1`
    FOREIGN KEY (`id_doctor`)
    REFERENCES `hospital`.`doctor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hospitalization_2`
    FOREIGN KEY (`id_patient`)
    REFERENCES `hospital`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hospitalization_3`
    FOREIGN KEY (`id_room`)
    REFERENCES `hospital`.`room` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`local_service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`local_service` ;

CREATE TABLE IF NOT EXISTS `hospital`.`local_service` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_hospitalization` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_local_service_1_idx` (`id_hospitalization` ASC) VISIBLE,
  CONSTRAINT `fk_local_service_1`
    FOREIGN KEY (`id_hospitalization`)
    REFERENCES `hospital`.`hospitalization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`service` ;

CREATE TABLE IF NOT EXISTS `hospital`.`service` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_local_service` INT NOT NULL,
  `id_emergency_service` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_service_1_idx` (`id_emergency_service` ASC) VISIBLE,
  INDEX `fk_service_2_idx` (`id_local_service` ASC) VISIBLE,
  CONSTRAINT `fk_service_1`
    FOREIGN KEY (`id_emergency_service`)
    REFERENCES `hospital`.`emergency_service` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_2`
    FOREIGN KEY (`id_local_service`)
    REFERENCES `hospital`.`local_service` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital`.`hospital`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hospital`.`hospital` ;

CREATE TABLE IF NOT EXISTS `hospital`.`hospital` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `id_attendant` INT NOT NULL,
  `id_service` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hospital_1_idx` (`id_attendant` ASC) VISIBLE,
  INDEX `fk_hospital_2_idx` (`id_service` ASC) VISIBLE,
  CONSTRAINT `fk_hospital_1`
    FOREIGN KEY (`id_attendant`)
    REFERENCES `hospital`.`attendant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hospital_2`
    FOREIGN KEY (`id_service`)
    REFERENCES `hospital`.`service` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
