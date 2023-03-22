CREATE DATABASE IF NOT EXISTS shipwell;


USE shipwell;

CREATE TABLE IF NOT EXISTS logistic_partner (
  logistic_partner_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  main_office_location VARCHAR(255) NOT NULL,
  phone_no VARCHAR(20) NOT NULL,
  email_id VARCHAR(100) NOT NULL,
  owner_name VARCHAR(100) NOT NULL,
  owner_email_id VARCHAR(100) NOT NULL,
  owner_phone_no VARCHAR(20) NOT NULL,
  road_km_rate DECIMAL(10,2) NOT NULL,
  air_km_rate DECIMAL(10,2) NOT NULL,
  sea_km_rate DECIMAL(10,2) NOT NULL,
  rail_km_rate DECIMAL(10,2) NOT NULL,
  security_question VARCHAR(150) NOT NULL,
  security_answer VARCHAR(150) NOT NULL,
  kg_increase_rate_5 DECIMAL(10,2) NOT NULL,
  kg_increase_rate_10 DECIMAL(10,2) NOT NULL,
  kg_increase_rate_20 DECIMAL(10,2) NOT NULL,
  kg_increase_rate_50 DECIMAL(10,2) NOT NULL,
  kg_increase_rate_50_more DECIMAL(10,2) NOT NULL,
  status INT NOT NULL,
  PRIMARY KEY (logistic_partner_id)
);



CREATE TABLE IF NOT EXISTS logistic_partner_office (
  lp_office_id INT NOT NULL AUTO_INCREMENT,
  logistic_partner_id INT NOT NULL,
  office_address VARCHAR(255) NOT NULL,
  phone_no VARCHAR(20) NOT NULL,
  email_id VARCHAR(100) NOT NULL,
  location_id INT NOT NULL,
  PRIMARY KEY (lp_office_id),
  FOREIGN KEY (logistic_partner_id) REFERENCES logistic_partner(logistic_partner_id)
);



CREATE TABLE IF NOT EXISTS customer (
  customer_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email_id VARCHAR(100) NOT NULL,
  phone_no VARCHAR(20) NOT NULL,
  password VARCHAR(100) NOT NULL,
  address VARCHAR(250),
  dob VARCHAR(100) NOT NULL,
  status INT NOT NULL,
  PRIMARY KEY (customer_id)
);



CREATE TABLE IF NOT EXISTS way_bill (
  waybill_id INT NOT NULL AUTO_INCREMENT,
  customer_id INT NOT NULL,
  logistic_partner_id INT NOT NULL,
  product_details VARCHAR(255) NOT NULL,
  amount DECIMAL(10,2) NOT NULL,
  weight DECIMAL(10,2) NOT NULL,
  mode_transportation VARCHAR(100) NOT NULL,
  status VARCHAR(10) NOT NULL,
  delivery_date VARCHAR(50) NOT NULL,
  comments VARCHAR(255),
  PRIMARY KEY (waybill_id),
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
  FOREIGN KEY (logistic_partner_id) REFERENCES logistic_partner(logistic_partner_id)
);


CREATE TABLE IF NOT EXISTS employee (
  employee_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email_id VARCHAR(100) NOT NULL,
  phone_no VARCHAR(20) NOT NULL,
  password VARCHAR(100) NOT NULL,
  status INT NOT NULL,
  PRIMARY KEY (employee_id)
);



CREATE TABLE IF NOT EXISTS locations_distance (
  location1_id INT NOT NULL,
  location2_id INT NOT NULL,
  distance DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (location1_id,location2_id)
);

CREATE TABLE IF NOT EXISTS location (
  location_id INT NOT NULL AUTO_INCREMENT,
  location_name VARCHAR(100) NOT NULL,
  state_name VARCHAR(100) NOT NULL,
  PRIMARY KEY (location_id)

);

CREATE TABLE IF NOT EXISTS complaint (
  complaint_id INT NOT NULL AUTO_INCREMENT,
  complaint VARCHAR(100) NOT NULL,
  response VARCHAR(100) NOT NULL,
  customer_id INT NOT NULL,
  logistic_partner_id INT NOT NULL,
  status INT NOT NULL,
  PRIMARY KEY (complaint_id)

);
