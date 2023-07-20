CREATE TABLE IF NOT EXISTS Sensor (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    desc VARCHAR(255) NOT NULL,
    location_description VARCHAR(255),
    type VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    sensor_class VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Sensor(name, desc, location_description, type, status, sensor_class)
VALUES ('My Sensor', 'A sensor', 'My House', 'THERMOMETER', 'TESTING', 'AMATEUR');
