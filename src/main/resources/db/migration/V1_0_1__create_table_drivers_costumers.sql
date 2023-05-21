CREATE TABLE drivers (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `document` varchar(100) DEFAULT NOT NULL,
    `birthdate` varchar(19) DEFAULT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE costumers (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NOT NULL,
    `driver_id` bigint DEFAULT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_costumer_driver FOREIGN KEY (driver_id) REFERENCES drivers(id) ON DELETE CASCADE
);