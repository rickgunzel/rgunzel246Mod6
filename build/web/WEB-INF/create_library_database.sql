-- create the library_catalog database

DROP DATABASE IF EXISTS library_catalog;

CREATE DATABASE library_catalog;

USE library_catalog;

CREATE TABLE CheckOut (
	CheckOutNumber INT NOT NULL AUTO_INCREMENT,
	FirstName VARCHAR(50),
	LastName VARCHAR(50),
	EmailAddress VARCHAR(50),
	BookTitle VARCHAR(100),
	DueDate DATE,
	PRIMARY KEY(CheckOutNumber)
);

-- create the library_employees database

DROP DATABASE IF EXISTS library_employees;

CREATE DATABASE library_employees;

USE library_employees;

CREATE TABLE UserRole(
	Username VARCHAR(50),
	Rolename VARCHAR(50)
);

CREATE TABLE UserPass(
	Username VARCHAR(50),
	Password VARCHAR(50)
);

INSERT INTO UserRole (Username, Rolename)
	VALUES ("johnsmith", "librarian");

INSERT INTO UserPass (Username, Password)
	VALUES ("johnsmith", "sesame");
INSERT INTO UserPass (Username, Password)
	VALUES ("itp246", "itp246");
INSERT INTO UserPass (Username, Password)
	VALUES ("donald", "duck");