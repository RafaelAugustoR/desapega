CREATE TABLE forgot_password (
    id UUID PRIMARY KEY NOT NULL,
    otp INTEGER NOT NULL,
    expiration_time TIMESTAMP NOT NULL,
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);
