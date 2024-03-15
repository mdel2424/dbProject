INSERT INTO Hotel (StarRating, NRooms, Address, HotelName, ContactEmails, PhoneNumber, ChainID) 
VALUES 
-- Ritz (chainid=1)
('5-star', 100, '123 Beach Ave, Miami, FL', 'Ritz Miami Beach', 'contact@ritzbeach.com', '305-555-1122', 1),
('4-star', 80, '101 Ocean Drive, Miami, FL', 'Ritz Ocean Resort', 'ocean@ritzresort.com', '305-555-2233', 1),
('5-star', 120, '50 Seaside Blvd, Miami, FL', 'Ritz Seaside Villa', 'villa@ritzseaside.com', '305-555-3344', 1),
('4-star', 90, '200 Marina Bay, Miami, FL', 'Ritz Marina Bay', 'bay@ritzmarina.com', '305-555-4455', 1),
('3-star', 70, '350 Coastal Rd, Miami, FL', 'Ritz Coastal Retreat', 'retreat@ritzcoastal.com', '305-555-5566', 1),
('4-star', 110, '123 Sunny Isles, Miami, FL', 'Ritz Sunny Isles', 'isles@ritzsunny.com', '305-555-6677', 1),
('5-star', 130, '400 Oceanfront, Miami, FL', 'Ritz Oceanfront Luxury', 'luxury@ritzoceanfront.com', '305-555-7788', 1),
('3-star', 60, '550 Beachside Drive, Miami, FL', 'Ritz Beachside Inn', 'inn@ritzbeachside.com', '305-555-8899', 1),

-- Insert Hotels for 'Hilton' (ChainId=2)
('5-star', 120, '456 Mountain Rd, Denver, CO', 'Hilton Mountain Lodge', 'lodge@hilton.com', '720-555-5567', 2),
('4-star', 90, '789 Peak View, Denver, CO', 'Hilton Peak Hotel', 'peak@hilton.com', '720-555-6678', 2),
('4-star', 100, '123 Ski Resort, Aspen, CO', 'Hilton Aspen Resort', 'aspen@hilton.com', '720-555-7789', 2),
('3-star', 80, '456 River St, Boulder, CO', 'Hilton Boulder Riverfront', 'boulder@hilton.com', '720-555-8890', 2),
('5-star', 150, '789 Downtown Blvd, Colorado Springs, CO', 'Hilton Springs Luxury', 'luxury@hilton.com', '720-555-9901', 2),
('4-star', 70, '101 Grand Ave, Fort Collins, CO', 'Hilton Fort Collins Central', 'central@hilton.com', '720-555-1011', 2),
('3-star', 60, '235 Country Lane, Pueblo, CO', 'Hilton Pueblo Countryside', 'country@hilton.com', '720-555-1212', 2),
('4-star', 85, '123 Main St, Vail, CO', 'Hilton Vail Valley', 'vail@hilton.com', '720-555-1313', 2),

-- Insert Hotels for 'Marriott' (ChainId=3)
('5-star', 150, '789 City Plaza, Seattle, WA', 'Marriott City Center', 'center@marriott.com', '206-555-9911', 3),
('4-star', 100, '456 Urban Lane, Seattle, WA', 'Marriott Urban Retreat', 'urban@marriott.com', '206-555-8822', 3),
('4-star', 110, '321 Lakeshore Blvd, Seattle, WA', 'Marriott Lakeside', 'lakeside@marriott.com', '206-555-7733', 3),
('3-star', 90, '234 Suburb Court, Bellevue, WA', 'Marriott Bellevue', 'bellevue@marriott.com', '206-555-6644', 3),
('4-star', 120, '111 Downtown Road, Portland, OR', 'Marriott Portland Central', 'central@marriottportland.com', '503-555-9555', 3),
('3-star', 75, '890 River Street, Portland, OR', 'Marriott Riverside', 'riverside@marriottportland.com', '503-555-8466', 3),
('5-star', 140, '555 Harbor Avenue, San Francisco, CA', 'Marriott Bay Area', 'bayarea@marriottsf.com', '415-555-9277', 3),
('4-star', 85, '678 Market Street, San Francisco, CA', 'Marriott Market Street', 'market@marriottsf.com', '415-555-0388', 3),

-- Insert Hotels for 'Lakeview Inn' (ChainId=4)
('3-star', 60, '235 Lake Rd, Orlando, FL', 'Lakeview Inn Lakeside', 'lakeside@lakeviewinn.com', '407-555-1234', 4),
('3-star', 50, '789 Lakefront Blvd, Orlando, FL', 'Lakeview Inn Waterfront', 'waterfront@lakeviewinn.com', '407-555-2345', 4),
('4-star', 75, '102 Lake Terrace, Orlando, FL', 'Lakeview Inn Terrace', 'terrace@lakeviewinn.com', '407-555-3456', 4),
('2-star', 40, '321 Lakeview Dr, Orlando, FL', 'Lakeview Budget Inn', 'budget@lakeviewinn.com', '407-555-4567', 4),
('3-star', 55, '456 Lake Park Ave, Orlando, FL', 'Lakeview Inn Parkside', 'parkside@lakeviewinn.com', '407-555-5678', 4),
('4-star', 80, '678 Lakeshore Ln, Orlando, FL', 'Lakeview Inn Shoreline', 'shoreline@lakeviewinn.com', '407-555-6789', 4),
('5-star', 100, '910 Lakeview Blvd, Orlando, FL', 'Lakeview Inn Luxury', 'luxury@lakeviewinn.com', '407-555-7890', 4),
('3-star', 60, '234 Lake Circle, Orlando, FL', 'Lakeview Inn Circle', 'circle@lakeviewinn.com', '407-555-8901', 4),

-- Insert Hotels for 'River Hotels' (ChainId=5)
('4-star', 70, '101 River St, Chicago, IL', 'River Hotel Downtown', 'downtown@riverhotels.com', '312-555-1678', 5),
('3-star', 50, '123 Riverside Ave, Chicago, IL', 'River Hotel Riverside', 'riverside@riverhotels.com', '312-555-2789', 5),
('3-star', 60, '234 Lakeside Blvd, Chicago, IL', 'River Hotel Lakeside', 'lakeside@riverhotels.com', '312-555-3490', 5),
('4-star', 75, '345 Park Lane, Chicago, IL', 'River Hotel Parkside', 'parkside@riverhotels.com', '312-555-4501', 5),
('4-star', 80, '456 Urban Road, Chicago, IL', 'River Urban Retreat', 'urban@riverhotels.com', '312-555-5612', 5),
('3-star', 55, '567 Suburban St, Chicago, IL', 'River Suburban Inn', 'suburban@riverhotels.com', '312-555-6723', 5),
('5-star', 100, '678 Luxury Ave, Chicago, IL', 'River Luxury Hotel', 'luxury@riverhotels.com', '312-555-7834', 5),
('4-star', 85, '789 Metropolis Rd, Chicago, IL', 'River Metropolis Resort', 'metropolis@riverhotels.com', '312-555-8945', 5);

