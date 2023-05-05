CREATE TABLE IF NOT EXISTS `register1` (
  `account` VARCHAR(20) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  `name` VARCHAR(20) NULL,
  `age` INT NULL,
  `city` VARCHAR(20) NULL,
  `reg_time` DATETIME NULL,
  `active` TINYINT(1) NOT NULL,
  `role` VARCHAR(20) NULL,
  PRIMARY KEY (`account`));
