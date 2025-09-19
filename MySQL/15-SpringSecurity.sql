use `15springsecuritydb`;
INSERT INTO roles (rolename) VALUES 
('ROLE_USER'),
('ROLE_MANAGER'),
('ROLE_ADMIN');
INSERT INTO users (username, password, role_id) 
VALUES 
 ('vivek', '$2a$12$JuOG.1p79YJJlZ6cMt4qmu2aS9AlBgKlWRnouQwH.LZfifmhO2bEy', 1) ,
 ('amit', '$2a$12$t9MikaR591QLjTpEaoFYxup0oh06J4i7b4uNWBrGrzJVipx3HCluq', 2),
 ('anshika', '$2a$12$mL1M.Ejd4xOr6l9VVc/ke.9sr8n46iGAQAPxjGC64ZwOKI81tdsyW', 3);

-- passwords are same as name 
