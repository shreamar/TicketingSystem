use ticketing;
create table flights(
flightID int primary key auto_increment,
flightType char,
seatType char,
origin varchar(50),
destination varchar(50),
oneWayPrice decimal,
twoWayPrice decimal,
leaveTime datetime,
arriveTime datetime,
seatsAvailable int, 
planeID int,
returnTime datetime,
returnArriveTime datetime,
foreign key(planeID) references planes(planeID)
);