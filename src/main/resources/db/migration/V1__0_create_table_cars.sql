CREATE TABLE cars (
    id int NOT NULL AUTO_INCREMENT,
    model varchar(100) DEFAULT NULL,
    manufacturer varchar(19) DEFAULT NULL,
    fipe_value decimal(19,2) NOT NULL,
    year varchar(7) DEFAULT NULL,
    PRIMARY KEY (id)
);