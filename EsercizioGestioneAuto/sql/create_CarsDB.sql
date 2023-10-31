drop database CarsDB;
create database CarsDB;
use CarsDB;

create table if not exists Cars (
	Id int auto_increment,
    Brand varchar(30) not null, 
    Model varchar(30) not null, 
    Plate varchar(30)  not null,
    DateOfProduction varchar(30) not null, 
    Price float not null,
    TypeOfFuel varchar(30) not null, 
    PRIMARY key(id)
    );