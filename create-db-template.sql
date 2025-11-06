CREATE DATABASE dbroller_speed
    DEFAULT CHARACTER SET = 'utf8mb4';

USE dbroller_speed;
create USER 'admin'@'localhost' IDENTIFIED BY 'admin123';
GRANT ALL PRIVILEGES ON dbroller_speed.* TO 'admin'@'localhost';   
FLUSH PRIVILEGES;

SHOW GRANTS FOR 'admin'@'localhost';