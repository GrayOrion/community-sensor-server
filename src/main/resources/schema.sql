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
