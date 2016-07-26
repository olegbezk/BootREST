CREATE TABLE dataObject (
id INT NOT NULL AUTO_INCREMENT,
title CHAR(100) NOT NULL,
number BIGINT NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE users (
username VARCHAR(45) NOT NULL,
password VARCHAR(100) NOT NULL,
enabled TINYINT NOT NULL DEFAULT 1 ,
PRIMARY KEY(username)
);

CREATE TABLE userRoles (
user_id INT(10) NOT NULL AUTO_INCREMENT,
username VARCHAR(45) NOT NULL,
role VARCHAR(20) NOT NULL,
PRIMARY KEY (user_id),
UNIQUE KEY uni_username_role(username, role),
CONSTRAINT fk_username FOREIGN KEY(username) REFERENCES users(username)
);