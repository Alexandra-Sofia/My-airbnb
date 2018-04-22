use airbnb;
-- update entries for room availabilities
update calendar set date=replace(replace(date,'2016','2018'),'2015','2017');

-- create bookings table
CREATE TABLE `airbnb`.`bookings` (
  `id_booking` INT NOT NULL AUTO_INCREMENT,
  `listing_id` INT(11) NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `dateFrom` VARCHAR(45) NULL DEFAULT NULL,
  `dateTo` VARCHAR(45) NULL DEFAULt NULL,
  `price` VARCHAR(45) NULL DEFAULT NULL,
  `cancelled` VARCHAR(45) NULL DEFAULT 'f',
  PRIMARY KEY (`id_booking`));
