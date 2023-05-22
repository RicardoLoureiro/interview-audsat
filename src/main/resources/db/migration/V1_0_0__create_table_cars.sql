CREATE TABLE cars (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `model` varchar(100) DEFAULT NOT NULL,
    `manufacturer` varchar(19) DEFAULT NOT NULL,
    `fipe_value` decimal(19,2) NOT NULL,
    `model_year` varchar(7) DEFAULT NULL,
    PRIMARY KEY (id)
);