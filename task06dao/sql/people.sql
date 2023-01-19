DROP DATABASE IF EXISTS people;
CREATE DATABASE people;
USE people;
CREATE TABLE person
(
    id              INTEGER          NOT NULL AUTO_INCREMENT,
    name            VARCHAR(255)     NOT NULL,
    surname         VARCHAR(255)     NOT NULL,
    CONSTRAINT PK_person PRIMARY KEY (id)
);
INSERT INTO person(name,surname) VALUES
('Conrad','Potter'),
('Kathy','Kirkham'),
('Alvin','Greenwood'),
('Kelly','Felderman'),
('Edward','Williamson'),
('Maria','Webb'),
('Stanley','Webb'),
('Alice','Kingston'),
('Bradley','Hagman'),
('Danielle','Sadler');