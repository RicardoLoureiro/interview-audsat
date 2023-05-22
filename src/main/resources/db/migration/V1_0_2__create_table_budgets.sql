CREATE TABLE budgets (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `driver_id` bigint NOT NULL,
    `car_id` bigint NOT NULL,
    `value_budget` decimal (10,2) NOT NULL,
    `expiration` varchar(10) NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_budget_car FOREIGN KEY (car_id) REFERENCES cars(id),
    CONSTRAINT fk_budget_driver FOREIGN KEY (driver_id) REFERENCES drivers(id)
);