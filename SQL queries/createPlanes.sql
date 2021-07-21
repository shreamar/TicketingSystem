use ticketing;
create table planes(
planeID int primary key auto_increment,
planeCode varchar(10),
economySeats int,
businessSeats int,
firstClassSeats int
);
