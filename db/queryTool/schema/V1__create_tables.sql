
CREATE TABLE HotelChain (
    ChainId SERIAL PRIMARY KEY,
    NHotels INTEGER,
    HQAddress VARCHAR(255),
    ContactEmails VARCHAR(255),
    PhoneNumber VARCHAR(255),
    HotelChainName VARCHAR(255)
);

CREATE TABLE Client (
    SSN INTEGER,
    FullName VARCHAR(255),
    "Address" VARCHAR(255),
    RegistrationDate DATE,
    PRIMARY KEY (SSN)
);

CREATE TABLE Hotel (
    HotelID INTEGER,
    StarRating VARCHAR(255),
    NRooms INTEGER,
    "Address" VARCHAR(255),
    HotelName VARCHAR(255),
    ContactEmails VARCHAR(255),
    PhoneNumber VARCHAR(255),
	ChainID INTEGER,
    PRIMARY KEY (HotelID),
    FOREIGN KEY (ChainID) REFERENCES HotelChain
);
CREATE TABLE Employee (
    SSN INTEGER,
    FullName VARCHAR(255),
    "Address" VARCHAR(255),
    "Role" VARCHAR(255),
	HotelID INT,
    PRIMARY KEY (SSN),
    FOREIGN KEY (HotelID) REFERENCES Hotel
);


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
