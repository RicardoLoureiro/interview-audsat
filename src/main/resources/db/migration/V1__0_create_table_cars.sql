CREATE TABLE cars (
    id int NOT NULL AUTO_INCREMENT,
    fipe_value decimal(19,2) NOT NULL,
    model varchar(100) DEFAULT NULL,
    manufacturer varchar(19) DEFAULT NULL,
    year varchar(7) DEFAULT NULL,
    PRIMARY KEY (id)
);