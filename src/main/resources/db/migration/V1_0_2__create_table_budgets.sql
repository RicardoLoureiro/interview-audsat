CREATE TABLE budgets (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `costumer_id` bigint NOT NULL,
    `car_id` bigint NOT NULL,
    `car_sinister` boolean DEFAULT false NOT NULL,
    `driver_sinister` boolean DEFAULT false NOT NULL,
    `value_budget` decimal (10,2) NOT NULL,
    `validate_time` DATE NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_budget_car FOREIGN KEY (car_id) REFERENCES cars(id),
    CONSTRAINT fk_budget_costumer FOREIGN KEY (costumer_id) REFERENCES costumers(id)
);