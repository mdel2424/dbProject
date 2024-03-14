CREATE TABLE Employee (
    SSN INTEGER,
    FullName VARCHAR(255),
    "Address" VARCHAR(255),
    "Role" VARCHAR(255),
	HotelID INT,
    PRIMARY KEY (SSN),
    FOREIGN KEY (HotelID) REFERENCES Hotel
);