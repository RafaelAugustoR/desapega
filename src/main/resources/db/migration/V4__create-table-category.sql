CREATE TABLE category(
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    name VARCHAR(32) NOT NULL,
    description TEXT NOT NULL,
    image TEXT NOT NULL
);