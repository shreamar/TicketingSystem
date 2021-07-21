use ticketing;
create table user
(userID int primary key auto_increment,
username varchar(50),
password varchar(100),
firstName varchar(100),
middleName varchar(100),
lastName varchar(100),
gender char,
age int,
addressLine varchar(500),
addressUnit varchar(10),
city varchar(50),
state varchar(20),
zipCode int,
email varchar(100),
phone varchar(20)
);

insert into user(username,password,firstName,middleName,lastName,gender,age,addressLine,addressUnit,city,state,zipCode,email,phone)
values("shreamar","password","Amar","","Shrestha",'m',27,"1227 S. 4th Ave.","13","Pocatello","Idaho",83201,"shreamar@isu.edu","2083808818");