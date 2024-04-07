
CREATE TABLE HotelChain (
    ChainId SERIAL PRIMARY KEY,
    NHotels INTEGER,
    HQAddress VARCHAR(255),
    ContactEmails VARCHAR(255)[],
    PhoneNumber VARCHAR(255),
    HotelChainName VARCHAR(255)
);

CREATE TABLE Client (
    SSN INTEGER PRIMARY KEY,
    FullName VARCHAR(255),
    Email VARCHAR(255),
    RegistrationDate DATE
);

CREATE TABLE Hotel (
    HotelID SERIAL PRIMARY KEY,
    StarRating INT,
    NRooms INTEGER,
    "Address" VARCHAR(255),
    HotelName VARCHAR(255),
    ContactEmails VARCHAR(255)[],
    PhoneNumber VARCHAR(255),
	ChainID INTEGER,
    FOREIGN KEY (ChainID) REFERENCES HotelChain
);
CREATE TABLE Employee (
    SSN INTEGER PRIMARY KEY,
    FullName VARCHAR(255),
    "Address" VARCHAR(255),
    "Role" VARCHAR(255),
	HotelID INT,
    FOREIGN KEY (HotelID) REFERENCES Hotel
);


CREATE TABLE Room (
    RoomID SERIAL PRIMARY KEY,
    Damages VARCHAR(255)[],
    View VARCHAR(255),
    Price INT,
    Capacity INT,
    Extendable BOOLEAN,
    Amenities VARCHAR(255)[],
    RoomNumber INT,
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
