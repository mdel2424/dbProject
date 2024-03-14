CREATE TABLE Reservation (
    ReservationID INTEGER,
    CheckInDate DATE,
    CheckOutDate DATE,
	RoomID INT,
	ClientID INT,
    PRIMARY KEY (ReservationID),
    FOREIGN KEY (RoomID) REFERENCES Room,
    FOREIGN KEY (ClientID) REFERENCES Client
);