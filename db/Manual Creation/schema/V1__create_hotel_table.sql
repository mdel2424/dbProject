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