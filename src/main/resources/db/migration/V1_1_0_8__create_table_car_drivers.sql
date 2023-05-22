CREATE TABLE car_drivers (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `car_id` bigint NOT NULL,
    `driver_id` bigint DEFAULT NOT NULL,
    `is_main_driver` boolean DEFAULT NOT NULL,
    `claim_event_date` DATE,
    PRIMARY KEY (id),
    CONSTRAINT fk_car_drivers_driver FOREIGN KEY (driver_id) REFERENCES drivers(id) ON DELETE CASCADE,
    CONSTRAINT fk_car_drivers_car FOREIGN KEY (car_id) REFERENCES cars(id) ON DELETE CASCADE
);