CREATE TABLE budgets (
    id int NOT NULL AUTO_INCREMENT,
    costumer_name varchar(100) DEFAULT NOT NULL,
    document varchar(100) DEFAULT NOT NULL,
    birthdate varchar(19) DEFAULT NOT NULL,
    car_id int(20) DEFAULT NOT NULL,
    validate_time varchar(3) DEFAULT '30' NOT NULL
    PRIMARY KEY (id)
    CONSTRAINT fk_budget_car FOREIGN KEY (car_id) REFERENCES cars(id)
);