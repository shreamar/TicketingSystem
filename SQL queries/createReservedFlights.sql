use ticketing;
create table reservedFlights(
reservedFlightID int primary key auto_increment,
flightID int,
seatType char,
tripType char,
price double,
userID int,
foreign key(flightID) references flights(flightID),
foreign key(userID) references user(userID)
);