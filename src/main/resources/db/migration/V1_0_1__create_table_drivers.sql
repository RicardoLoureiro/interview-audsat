CREATE TABLE drivers (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NOT NULL,
    `document` varchar(100) DEFAULT NOT NULL,
    `birthdate` varchar(19) DEFAULT NOT NULL,
    PRIMARY KEY (id)
);