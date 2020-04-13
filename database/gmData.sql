DROP DATABASE if exists gmData;
CREATE DATABASE gmData;
USE gmData;
CREATE TABLE users (
	userID int primary key not null auto_increment,
    username varchar(16) not null,
    passcode varchar(16) not null,
    fullName varchar(28) not null,
    registeredUser bool not null,
    email varchar(50) not null,
    emailPrefDaily bool DEFAULT 0,
    prefAnimal bool DEFAULT 0,
    prefFood bool DEFAULT 0,
    prefSky bool DEFAULT 0,
    prefWater bool DEFAULT 0,
    prefArchitecture bool DEFAULT 0,
    prefFlower bool DEFAULT 0,
    prefMuseum bool DEFAULT 0,
    prefArt bool DEFAULT 0,
    prefMountains bool DEFAULT 0,
    prefSoccer bool DEFAULT 0,
    prefDance bool DEFAULT 0,
    prefSinging bool DEFAULT 0,
    prefPolitics bool DEFAULT 0,
    prefLiterature bool DEFAULT 0,
    prefFashion bool DEFAULT 0,
    prefVolunteer bool DEFAULT 0,
    prefTravel bool DEFAULT 0,
    prefCooking bool DEFAULT 0
);
CREATE TABLE pictures (
	picID int primary key not null auto_increment,
    photoURL varchar(2083),
    attribute varchar(15)
);
CREATE TABLE moodBoard (
	boardID int primary key not null auto_increment,
    userID int not null,
    picID1 int not null,
    picID2 int not null,
    picID3 int not null,
    picID4 int not null,
    picID5 int not null,
    picID6 int not null,
    picID7 int not null,
    picID8 int not null,
    picID9 int not null,
    FOREIGN KEY fk1(picID1) REFERENCES pictures(picID),
    FOREIGN KEY fk2(picID2) REFERENCES pictures(picID),
    FOREIGN KEY fk3(picID3) REFERENCES pictures(picID),
    FOREIGN KEY fk4(picID4) REFERENCES pictures(picID),
    FOREIGN KEY fk5(picID5) REFERENCES pictures(picID),
    FOREIGN KEY fk6(picID6) REFERENCES pictures(picID),
    FOREIGN KEY fk7(picID7) REFERENCES pictures(picID),
    FOREIGN KEY fk8(picID8) REFERENCES pictures(picID),
    FOREIGN KEY fk9(picID9) REFERENCES pictures(picID)
);
CREATE TABLE emails (
	emailID int primary key not null auto_increment,
    userID int,
    goodMorningMessage varchar(500) not null,
    emailTimePreference varchar(500) not null,
    photoURL varchar(2083) not null,
    FOREIGN KEY fk1(userID) REFERENCES users(userID)
);