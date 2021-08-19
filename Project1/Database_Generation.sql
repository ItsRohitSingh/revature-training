-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema project1_onlineshopping
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema project1_onlineshopping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `project1_onlineshopping` ;
USE `project1_onlineshopping` ;

-- -----------------------------------------------------
-- Table `project1_onlineshopping`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project1_onlineshopping`.`customer` (
  `customerid` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(25) NOT NULL,
  `lastname` VARCHAR(25) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`customerid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project1_onlineshopping`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project1_onlineshopping`.`products` (
  `productid` INT NOT NULL AUTO_INCREMENT,
  `productname` VARCHAR(45) NOT NULL,
  `productquantity` INT NOT NULL,
  `productprice` INT NOT NULL,
  `productmanufacturer` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`productid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project1_onlineshopping`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project1_onlineshopping`.`cart` (
  `cartcustomerid` INT NOT NULL,
  `cartproductid` INT NOT NULL,
  `cartproductname` VARCHAR(45) NOT NULL,
  `cartquantity` INT NOT NULL,
  `cartprice` INT NOT NULL,
  INDEX `fk_cu_id_idx` (`cartcustomerid` ASC) VISIBLE,
  INDEX `fk_pr_id_idx` (`cartproductid` ASC) VISIBLE,
  CONSTRAINT `fk_cu_id`
    FOREIGN KEY (`cartcustomerid`)
    REFERENCES `project1_onlineshopping`.`customer` (`customerid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pr_id`
    FOREIGN KEY (`cartproductid`)
    REFERENCES `project1_onlineshopping`.`products` (`productid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project1_onlineshopping`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project1_onlineshopping`.`order` (
  `orderid` INT NOT NULL AUTO_INCREMENT,
  `ordercustomerid` INT NOT NULL,
  `orderproductid` INT NOT NULL,
  `orderproductname` VARCHAR(45) NOT NULL,
  `orderquantity` INT NOT NULL,
  `orderprice` INT NOT NULL,
  `orderstatus` VARCHAR(10) NOT NULL DEFAULT 'Ordered',
  PRIMARY KEY (`orderid`),
  INDEX `fk_or_cu_id_idx` (`ordercustomerid` ASC) VISIBLE,
  INDEX `fk_or_pr_id_idx` (`orderproductid` ASC) VISIBLE,
  CONSTRAINT `fk_or_cu_id`
    FOREIGN KEY (`ordercustomerid`)
    REFERENCES `project1_onlineshopping`.`customer` (`customerid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_or_pr_id`
    FOREIGN KEY (`orderproductid`)
    REFERENCES `project1_onlineshopping`.`products` (`productid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
