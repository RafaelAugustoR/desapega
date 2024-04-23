CREATE TABLE product_transaction_item (
    id UUID PRIMARY KEY NOT NULL UNIQUE,
    transaction_id UUID,
    item_transaction_id UUID,
    FOREIGN KEY (transaction_id) REFERENCES transaction (id),
    FOREIGN KEY (item_transaction_id) REFERENCES product (id)
);
