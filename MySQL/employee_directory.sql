CREATE DATABASE  IF NOT EXISTS `employee_directory`;

USE `employee_directory`;



--

-- Table structure for table `employee`

--
 
DROP TABLE IF EXISTS `employee`;
 
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)

);

INSERT INTO `employee_directory`.`employee` (`id`, `first_name`, `last_name`, `email`) VALUES ('1', 'anshika', 'dubey', 'anshika@gmail.com');
INSERT INTO `employee_directory`.`employee` (`id`, `first_name`, `last_name`, `email`) VALUES ('2', 'alok', 'sahu', 'alok@gmail.com');
INSERT INTO `employee_directory`.`employee` (`id`, `first_name`, `last_name`, `email`) VALUES ('3', 'aditya', 'idk', 'aditya@gmail.com');
INSERT INTO `employee_directory`.`employee` (`id`, `first_name`, `last_name`, `email`) VALUES ('4', 'avisha', 'shah', 'avisha@gmail.com');
INSERT INTO `employee_directory`.`employee` (`id`, `first_name`, `last_name`, `email`) VALUES ('5', 'srusti', 'idk', 'srusti@gmail.com');

 