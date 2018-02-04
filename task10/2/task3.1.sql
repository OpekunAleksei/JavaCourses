
drop database HotelDatabase;
create database if not exists HotelDatabase;
use HotelDatabase;
CREATE TABLE IF NOT EXISTS `Room` (
    `idRoom` INT AUTO_INCREMENT NOT NULL,
    `number` INT NOT NULL,
    `price` INT NOT NULL,
    `busy` varchar(50) NOT NULL,
    `capacity` int NOT NULL ,
    `numberOfStars` int NOT NULL ,
    `status` varchar(50) NOT NULL ,
    PRIMARY KEY (`idRoom`),
    INDEX (`idRoom`)
);
CREATE TABLE `guest` (
    `idGuest` INT NOT NULL AUTO_INCREMENT,
    `arrivalDate` date NOT NULL,
    `departureDate` date NOT NULL,
    `name` varchar(50) NOT NULL,
    PRIMARY KEY (`idGuest`),
    INDEX (`idGuest`)
);
CREATE TABLE `service` (
    `idService` INT NOT NULL AUTO_INCREMENT,
    `category` VARCHAR(50) NOT NULL,
    `price` INT NOT NULL,
    PRIMARY KEY (`idService`),
    INDEX (`idService`)
);
CREATE TABLE `services` (
    `idServices` INT NOT NULL AUTO_INCREMENT,
    `idService` INT NOT NULL,
    `idRoom` int NOT NULL,
    PRIMARY KEY (`idServices`),
    INDEX (`idServices` , `idService`, `idRoom`)
);
CREATE TABLE `history` (
    `idHistory` INT NOT NULL AUTO_INCREMENT,
    `idRoom` INT NOT NULL,
    `idServices` INT ,
    `idguest` INT NOT NULL,
    `arrivalDate` DATE NOT NULL,
    `departureDate` DATE NOT NULL,
    `enable` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`idHistory`),
    INDEX (`idServices` , `idGuest` , `idRoom`)
);

insert into guest (arrivalDate,departureDate,name) values ('2008-04-09','2009-04-09','alex');
insert into guest (arrivalDate,departureDate,name) values ('2008-04-10','2009-05-09','dima');
insert into guest (arrivalDate,departureDate,name) values ('2010-04-09','2011-04-09','oleg');
insert into room (number,price,busy,capacity,numberOfStars,status) values(401,100,'y',5,5,'t');
insert into room (number,price,busy,capacity,numberOfStars,status) values(402,200,'n',2,1,'f');
insert into room (number,price,busy,capacity,numberOfStars,status) values(40,150,'n',3,4,'t');
insert into service(category,price) values ('taxi',40);
insert into service(category,price) values ('chating',50);
insert into service(category,price) values ('wake-up',10);
insert into history(idRoom,idguest,arrivalDate,departureDate,enable) values(1,1,'2008-04-09','2009-04-09','n');
insert into history(idRoom,idguest,arrivalDate,departureDate,enable) values(2,2,'2008-04-10','2009-05-09','y');
insert into history(idRoom,idguest,arrivalDate,departureDate,enable) values(3,3,'2010-04-09','2011-04-09','y');