create database PlantShop
GO
use PlantShop
GO
create table Accounts(
 accID int identity(1,1)primary key,
 email varchar(30) unique,
 password varchar(30),
 fullname varchar(30),
 phone varchar(12),
 status int check(status =1 or status=0),
 role int check(role=1 or role=0),
 token varchar(30)
)
GO
create table Categories(
 CateID int identity(1,1) primary key,
 CateName varchar(30)
)
GO
create table Plants(
 PID int identity(1,1) primary key,
 PName varchar(30),
 price int check(price>=0),
 imgPath varchar(50),
 description text,
 status int, --1:active, 0:inactive
 CateID int foreign key references Categories(CateID)
)
GO
create table Orders(
 OrderID int identity(1,1) primary key,
 OrdDate date,
 shipdate date,--1:processing, 
 AccID int foreign key references Accounts(AccID)
)
GO
create table OrderDetails(
 DetailId int identity(1,1) primary key,
 OrderID int foreign key references Orders(OrderID),
 FID int foreign key references Plants(PID),
 quantity int check(quantity>=1)
)
