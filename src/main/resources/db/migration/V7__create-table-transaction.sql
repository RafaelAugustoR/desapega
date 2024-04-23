CREATE TABLE transaction (
    id UUID PRIMARY KEY NOT NULL,
    date TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,
    requester_id UUID,
    requested_user_id UUID,
    FOREIGN KEY (requester_id) REFERENCES "user" (id),
    FOREIGN KEY (requested_user_id) REFERENCES "user" (id)
);
