CREATE DATABASE spainguide /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE USER 'spainguide'@'%' IDENTIFIED BY 'spainguide';
GRANT ALL ON spainguide.* TO 'spainguide'@'%';

USE spainguide;

CREATE TABLE users (username VARCHAR(50) NOT NULL, password VARCHAR(100) NOT NULL, enabled TINYINT NOT NULL DEFAULT 1, PRIMARY KEY (username));
CREATE TABLE authorities (username VARCHAR(50) NOT NULL, authority VARCHAR(50) NOT NULL, FOREIGN KEY (username) REFERENCES users(username));
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);