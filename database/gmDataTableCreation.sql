CREATE DATABASE gmData;
USE gmData;
CREATE TABLE users (
	userID int primary key not null auto_increment,
    username varchar(16) not null,
    passcode varchar(16) not null,
    fullName varchar(28) not null,
    registeredUser bool not null,
    email varchar(50) not null,
    emailPrefDaily bool not null,
    emailTimePreference varchar(500),
    prefAnimal bool not null,
    prefFood bool not null,
    prefSky bool not null,
    prefWater bool not null,
    prefArchitecture bool not null,
    prefFlower bool not null,
    prefMuseum bool not null,
    prefArt bool not null,
    prefMountains bool not null,
    prefSoccer bool not null,
    prefDance bool not null,
    prefSinging bool not null,
    prefPolitics bool not null,
    prefLiterature bool not null,
    prefFashion bool not null,
    prefVolunteer bool not null,
    prefTravel bool not null,
    prefCooking bool not null
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
