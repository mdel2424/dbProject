CREATE TRIGGER BeforeInsertBooking
BEFORE INSERT ON Booking
FOR EACH ROW
BEGIN
    DECLARE client_exists INT;
    SELECT COUNT(*) INTO client_exists FROM Client WHERE ClientID = NEW.ClientID;
    IF client_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Le ClientID nexiste pas dans la table Clients.';
    END IF;
END;

CREATE TRIGGER BeforeDeleteClient
BEFORE DELETE ON Client
FOR EACH ROW
BEGIN
    DECLARE booking_count INT;
    SELECT COUNT(*) INTO booking_count FROM Booking WHERE ClientID = OLD.ClientID;
    IF booking_count > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ce client a des réservations actives et ne peut pas être supprimé.';
    END IF;
END;
