CREATE TABLE address(
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    country VARCHAR(30) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(30) NOT NULL,
    neighborhood VARCHAR(30) NOT NULL,
    street VARCHAR(30) NOT NULL,
    postal_code INTEGER NOT NULL,
    house_number INTEGER NOT NULL,
    complement TEXT NOT NULL
);