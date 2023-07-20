CREATE TABLE IF NOT EXISTS Content (
    id INTEGER NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    desc text,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    data_created TIMESTAMP NOT NULL,
    data_updated TIMESTAMP,
    url VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO Content(title, desc, status, content_type, data_created)
VALUES ('My Spring Data Blog Post', 'A post about Spring data', 'TESTING', 'THERMOMETER', NOW());


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
