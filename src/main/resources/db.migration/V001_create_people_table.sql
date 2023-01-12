CREATE TABLE people (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL
);

CREATE TABLE address (
    id UUID PRIMARY KEY NOT NULL,
    people_id UUID NOT NULL,
    public_place VARCHAR(255) NOT NULL,
    zip_code INT NOT NULL,
    number INT NOT NULL,
    city VARCHAR(255) NOT NULL,
    FOREIGN KEY (people_id) REFERENCES people(id)
);