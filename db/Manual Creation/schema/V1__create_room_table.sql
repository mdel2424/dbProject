CREATE TABLE Room (
    RoomID INTEGER,
    Damages VARCHAR(255),
    Price VARCHAR(255),
    Capacity VARCHAR(255),
    Extendable VARCHAR(255),
    Amenities VARCHAR(255),
	HotelID INT,
    PRIMARY KEY (RoomID),
    FOREIGN KEY (HotelID) REFERENCES Hotel
);