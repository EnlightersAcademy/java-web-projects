create table Customer (

	customerId INT,
	dob Date,
	sex VarChar(20),
	address VarChar(300),
	phoneNo BIGINT,
	emailId VarChar(50),
	locationId INT,
	locationName VarChar(100),
	identificationId VarChar(100)
);

create table Announcement (
	id INT,
	message VarChar(300),
	announcementType VarChar(20),
	messageDate Date
);

create table GameBooking(
	bookingId INT,
	sportCenterId INT,
	customerId INT,
	courtOrBoardName VarChar(100),
	timeSlot VarChar(20),
	DateOfBook																																																																																																																																																																																																																																																																																																																																																																																										