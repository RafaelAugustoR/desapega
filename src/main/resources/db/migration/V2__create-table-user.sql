CREATE TABLE "user"(
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    name VARCHAR(80) NOT NULL,
    cpf INTEGER NOT NULL UNIQUE,
    birth_date DATE NOT NULL,
    password VARCHAR(80) NOT NULL,
    email VARCHAR(80) NOT NULL UNIQUE,
    profile_picture TEXT NOT NULL,
    role VARCHAR(10) NOT NULL CHECK(role IN ('ADMIN', 'CUSTOMER')) DEFAULT ('CUSTOMER'),
    address_id UUID,
    FOREIGN KEY (address_id) REFERENCES address(id)
);