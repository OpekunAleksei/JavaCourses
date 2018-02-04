
drop database pcdatabase;
create database if not exists PcDataBase;
use PcDataBase;
create table if not exists `product` (`marker` VARCHAR(10) NOT NULL , `model` VARCHAR(50) NOT NULL ,`type` VARCHAR(50) NOT NULL , PRIMARY KEY(`model`),INDEX(`model`));
create table `laptop` (`code` int NOT NULL AUTO_INCREMENT, `model` VARCHAR(50) NOT NULL ,`speed` smallint NOT NULL , `ram` smallint NOT NULL ,`hd` real NOT NULL ,`price` int  ,`screen` tinyint NOT NULL ,PRIMARY KEY(`code`),INDEX(`model`,`code`));
create table `pc` (`code` int NOT NULL AUTO_INCREMENT, `model` VARCHAR(50) NOT NULL ,`speed` smallint NOT NULL , `ram` smallint NOT NULL ,`hd` real NOT NULL ,`cd` varchar(10) NOT NULL ,`price` int   ,PRIMARY KEY(`code`),INDEX(`model`,`code`));
create table `printer` (`code` int NOT NULL AUTO_INCREMENT, `model` VARCHAR(50) NOT NULL ,`color` char(1) NOT NULL , `type` VARCHAR(10) NOT NULL  ,`price` int   ,PRIMARY KEY(`code`),INDEX(`model`,`code`));

#describe product;
SHOW TABLES; 