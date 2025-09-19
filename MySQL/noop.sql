CREATE DATABASE security_demo;
USE security_demo;
CREATE TABLE if not exists users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL );
    
INSERT INTO users (username, password) VALUES
('amit', '{noop}test123'),
('anshika', '{noop}test123'),
('rashi', '{noop}test123');