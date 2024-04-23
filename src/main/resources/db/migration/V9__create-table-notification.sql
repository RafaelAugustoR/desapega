CREATE TABLE notification (
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    message TEXT NOT NULL,
    date TIMESTAMP NOT NULL,
    is_viewed BOOLEAN NOT NULL,
    type VARCHAR(20) NOT NULL CHECK(role IN ('CONVERSATION', 'ITEM_REQUEST')),
    sender_solicitation UUID,
    receiver_solicitation UUID,
    transaction_id UUID,
    FOREIGN KEY (sender_solicitation) REFERENCES "user" (id),
    FOREIGN KEY (receiver_solicitation) REFERENCES "user" (id),
    FOREIGN KEY (transaction_id) REFERENCES transaction (id)
);
