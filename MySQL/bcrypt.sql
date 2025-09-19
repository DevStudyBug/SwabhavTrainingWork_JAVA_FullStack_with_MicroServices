USE `employee_directory`;
 
DROP TABLE IF EXISTS `authorities`;

DROP TABLE IF EXISTS `users`;
 
--

-- Table structure for table `users`

--
 
CREATE TABLE `users` (

  `username` varchar(50) NOT NULL,

  `password` char(68) NOT NULL,

  `enabled` tinyint NOT NULL,

  PRIMARY KEY (`username`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
--

-- Inserting data for table `users`

--

-- NOTE: The passwords are encrypted using BCrypt

--

-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password

--

-- Default passwords here are: fun123

--
-- password for amit is employee, anshika- manager, rashi - admin
INSERT INTO `users` 
VALUES 
('amit','{bcrypt}$2a$10$g1Nz./QZC2mdKam3j1himeADBbD/tqo6t2PH/qkNe9wHJ9NmaWcxe',1),

('anshika','{bcrypt}$2a$10$vWAhhtO.4avYLp7xjZ2k0Ok5N1qqnOWAFyd1wfutmi4LZljnBrfKy',1),

('rashi','{bcrypt}$2a$10$IA0nXoyDSs9DJxErfoRMT.NCxCfoQqIMwFQ0vsr4so5Jh29pzc3mO',1);
 
 
--

-- Table structure for table `authorities`

--
 
CREATE TABLE `authorities` (

  `username` varchar(50) NOT NULL,

  `authority` varchar(50) NOT NULL,

  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),

  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
--

-- Inserting data for table `authorities`

--
 
INSERT INTO `authorities` VALUES 

('amit','ROLE_EMPLOYEE'),

('anshika','ROLE_MANAGER'),

('rashi','ROLE_ADMIN');
 