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
('Jack','Moore'),
('Bryan','White'),
('William','Brown'),
('Scott','Goldberg'),
('Rick','Rolling');