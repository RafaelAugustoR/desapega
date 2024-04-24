CREATE TABLE product (
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    description TEXT NOT NULL,
    image TEXT NOT NULL,
    user_id UUID,
    category_id UUID,
    FOREIGN KEY (user_id) REFERENCES "user" (id),
    FOREIGN KEY (category_id) REFERENCES category (id)
);
