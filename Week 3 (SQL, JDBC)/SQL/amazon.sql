-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema amazon
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema amazon
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `amazon` DEFAULT CHARACTER SET utf8 ;
USE `amazon` ;

-- -----------------------------------------------------
-- Table `amazon`.`receipt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazon`.`receipt` (
  `re_id` INT NOT NULL AUTO_INCREMENT,
  `re_date` DATETIME NULL,
  `re_total` DECIMAL(10,2) NULL,
  PRIMARY KEY (`re_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amazon`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazon`.`category` (
  `ca_id` INT NOT NULL AUTO_INCREMENT,
  `ca_name` VARCHAR(45) NULL,
  PRIMARY KEY (`ca_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amazon`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazon`.`products` (
  `pr_id` INT NOT NULL AUTO_INCREMENT,
  `pr_name` VARCHAR(45) NULL,
  `pr_ca_id` INT NULL,
  PRIMARY KEY (`pr_id`),
  INDEX `fk_category_idx` (`pr_ca_id` ASC) VISIBLE,
  CONSTRAINT `fk_category`
    FOREIGN KEY (`pr_ca_id`)
    REFERENCES `amazon`.`category` (`ca_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `amazon`.`receipt_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amazon`.`receipt_item` (
  `ri_id` INT NOT NULL AUTO_INCREMENT,
  `ri_re_id` INT NULL,
  `ri_pr_id` INT NULL,
  `ri_quantity` INT NULL,
  `ri_price` DECIMAL(5,2) NULL,
  `ri_total` DECIMAL(10,2) NULL,
  PRIMARY KEY (`ri_id`),
  INDEX `fk_receipt_idx` (`ri_re_id` ASC) VISIBLE,
  INDEX `fk_products_idx` (`ri_pr_id` ASC) VISIBLE,
  CONSTRAINT `fk_receipt`
    FOREIGN KEY (`ri_re_id`)
    REFERENCES `amazon`.`receipt` (`re_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products`
    FOREIGN KEY (`ri_pr_id`)
    REFERENCES `amazon`.`products` (`pr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
