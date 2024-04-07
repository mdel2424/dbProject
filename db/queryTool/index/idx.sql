CREATE INDEX idx_bookings_clientid ON booking(clientId);
CREATE INDEX idx_booking_date_range ON booking(startDate, endDate);
CREATE INDEX idx_clients_email ON client(email);
