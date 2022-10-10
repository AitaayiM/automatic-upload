DROP DATABASE IF EXISTS ebook;
CREATE DATABASE ebook;
USE ebook;
CREATE TABLE ebookData (
     ID INT(50) AUTO_INCREMENT PRIMARY KEY,
     UserID INT(50),
     Language VARCHAR(500),
     BookTitle VARCHAR(500),
     Subtitle VARCHAR(500),
     FirstName VARCHAR(500),
     MiddleName VARCHAR(500),
     LastName VARCHAR(500),
     Description VARCHAR(5000),
     PublishingRights BOOLEAN,
     Keyword1 VARCHAR(1000),
     Keyword2 VARCHAR(1000),
     Keyword3 VARCHAR(1000),
     Keyword4 VARCHAR(1000),
     Keyword5 VARCHAR(1000),
     Keyword6 VARCHAR(1000),
     Keyword7 VARCHAR(1000),
     Categorie1 VARCHAR(250),
     Categorie2 VARCHAR(250),
     LargePrint BOOLEAN,
     AdultContent BOOLEAN,
     BookContent VARCHAR(5000),
     BookCover VARCHAR(5000),
     Barcode BOOLEAN,
     Price REAL,
     BleedStings VARCHAR(500),
     printISBN BOOLEAN,
     ISBN VARCHAR(100),
     imprint VARCHAR(500),
     InkPaper VARCHAR(500),
     Coverfinish VARCHAR(500),
     Marketplace VARCHAR(500),
     Date VARCHAR(1000),
     FOREIGN KEY (UserID) REFERENCES users (IDUser)
)

CREATE TABLE users(
     IDUser INT(50) AUTO_INCREMENT PRIMARY KEY,
     FirstNameU VARCHAR(1000),
     LastNameU VARCHAR(1000),
     Email VARCHAR(1000),
     username VARCHAR(1000),
     password VARCHAR(1000),
     DateOfBirth VARCHAR(50),
     SerialCode VARCHAR(1000)
)