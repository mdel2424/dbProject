
CREATE TABLE HotelChain (
    ChainId SERIAL PRIMARY KEY,
    NHotels INTEGER,
    HQAddress VARCHAR(255),
    ContactEmails VARCHAR(255),
    PhoneNumber VARCHAR(255),
    HotelChainName VARCHAR(255)
);

CREATE TABLE Client (
    SSN SERIAL PRIMARY KEY,
    FullName VARCHAR(255),
    "Address" VARCHAR(255),
    RegistrationDate DATE
);

CREATE TABLE Hotel (
    HotelID SERIAL PRIMARY KEY,
    StarRating VARCHAR(255),
    NRooms INTEGER,
    "Address" VARCHAR(255),
    HotelName VARCHAR(255),
    ContactEmails VARCHAR(255),
    PhoneNumber VARCHAR(255),
	ChainID INTEGER,
    FOREIGN KEY (ChainID) REFERENCES HotelChain
);
CREATE TABLE Employee (
    SSN SERIAL PRIMARY KEY,
    FullName VARCHAR(255),
    "Address" VARCHAR(255),
    "Role" VARCHAR(255),
	HotelID INT,
    FOREIGN KEY (HotelID) REFERENCES Hotel
);


CREATE TABLE Room (
    RoomID SERIAL PRIMARY KEY,
    Damages VARCHAR(255),
    Price VARCHAR(255),
    Capacity VARCHAR(255),
    Extendable VARCHAR(255),
    Amenities VARCHAR(255),
	HotelID INT,
    FOREIGN KEY (HotelID) REFERENCES Hotel
);
CREATE TABLE Reservation (
    ReservationID SERIAL PRIMARY KEY,
    CheckInDate DATE,
    CheckOutDate DATE,
	RoomID INT,
	ClientID INT,
    FOREIGN KEY (RoomID) REFERENCES Room,
    FOREIGN KEY (ClientID) REFERENCES Client
);


CREATE TABLE BOOKING (
    BookingID SERIAL PRIMARY KEY,
    "Status" VARCHAR(255),
    StartDate DATE,
    EndDate DATE,
	RoomID INT,
	ClientID INT,
    FOREIGN KEY (RoomID) REFERENCES Room,
    FOREIGN KEY (ClientID) REFERENCES Client
);
