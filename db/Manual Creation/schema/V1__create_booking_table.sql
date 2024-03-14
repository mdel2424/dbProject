CREATE TABLE BOOKING (
    BookingID INTEGER,
    "Status" VARCHAR(255),
    StartDate DATE,
    EndDate DATE,
	RoomID INT,
	ClientID INT,
    PRIMARY KEY (BookingID),
    FOREIGN KEY (RoomID) REFERENCES Room,
    FOREIGN KEY (ClientID) REFERENCES Client
);