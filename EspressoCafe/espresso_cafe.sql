/*
SQLyog Community Edition- MySQL GUI v6.07
Host - 5.5.30 : Database - busreservation
*********************************************************************
Server version : 5.5.30
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `espresso_cafe`;

USE `espresso_cafe`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `Cafe_Order` */

DROP TABLE IF EXISTS `Cafe_Order`;

CREATE TABLE `Cafe_Order` (
  `id` INT(11) DEFAULT NULL,
  `customer_email_id` varchar(255) DEFAULT NULL,
  `date_of_order` varchar(255) DEFAULT NULL,
  `staff_id` INT(255) DEFAULT NULL,
  `status` INT(255) DEFAULT NULL,
  `total_amount` INT(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `Cafe_Order` */

insert  into `Cafe_Order`(`id`,`customer_email_id`,`date_of_order`,`staff_id`,`status`,`total_amount`) values (800,'sonu@gmail.com','16-Jan-21 21:34:03', 1, 1, 240);

/*Table structure for table `Category` */

DROP TABLE IF EXISTS `Customer`;

CREATE TABLE `Customer` (
  `customer_id` int(11) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone_no` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*Table structure for table `Item` */

DROP TABLE IF EXISTS `Item`;

CREATE TABLE `Item` (
  `item_id` int(11) NOT NULL,
  `description` varchar(200) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `photo` longblob DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*Table structure for table `Order_Item` */

DROP TABLE IF EXISTS `Order_Item`;

CREATE TABLE `Order_Item` (
  `order_item_id` int(20) NOT NULL,
  `item_id` int(20) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `cafe_order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `Purchase_Item`;

CREATE TABLE `Purchase_Item` (
  `id` int(20) NOT NULL,
  `date` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL, 
  `name` varchar(255) NOT NULL,
  `quantity` varchar(255) NOT NULL,
  `total_cost` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `Staff`;

CREATE TABLE `Staff` (
	`staff_id` int(100) NOT NULL,
	`address` varchar(255) DEFAULT NULL,
	`dob` varchar(255) DEFAULT NULL,
	`email_id` varchar(255) DEFAULT NULL,
	`gender` varchar(255) DEFAULT NULL,
	`id_type` varchar(255) DEFAULT NULL,
	`identification` varchar(255) DEFAULT NULL,
	`is_active` bit(1) DEFAULT NULL,
	`name` varchar(255) DEFAULT NULL,
	`password` varchar(200) DEFAULT NULL,
	`phone_no` varchar(200) DEFAULT NULL,
	PRIMARY KEY (`staff_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
