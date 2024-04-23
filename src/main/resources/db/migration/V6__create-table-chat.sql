CREATE TABLE chat (
    id UUID PRIMARY KEY NOT NULL,
    message TEXT NOT NULL,
    date TIMESTAMP NOT NULL,
    sender_id UUID,
    receiver_id UUID,
    FOREIGN KEY (sender_id) REFERENCES "user" (id),
    FOREIGN KEY (receiver_id) REFERENCES "user" (id)
);
