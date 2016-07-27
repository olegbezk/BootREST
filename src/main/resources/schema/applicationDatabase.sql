CREATE TABLE dataObject (
id INT NOT NULL AUTO_INCREMENT,
title CHAR(100) NOT NULL,
number BIGINT NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE user (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(45) NOT NULL,
	password VARCHAR(100) NOT NULL,
	enabled TINYINT NOT NULL DEFAULT 1 ,
	UNIQUE KEY uniq_username(username),
	PRIMARY KEY(id)
);

CREATE TABLE role (
	id INT NOT NULL AUTO_INCREMENT,
	role VARCHAR(20) NOT NULL,
	UNIQUE KEY uniq_role(role),
	PRIMARY KEY(id)
);

CREATE TABLE user_role (
	user_id INT NOT NULL,
	role_id INT NOT NULL,
	UNIQUE KEY uni_user_role(user_id, role_id),
);

create sequence HIBERNATE_SEQUENCE;