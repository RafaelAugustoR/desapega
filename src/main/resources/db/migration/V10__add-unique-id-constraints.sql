ALTER TABLE evaluation
ADD CONSTRAINT unique_evaluation_id UNIQUE (id);

ALTER TABLE chat
ADD CONSTRAINT unique_chat_id UNIQUE (id);

ALTER TABLE transaction
ADD CONSTRAINT unique_transaction_id UNIQUE (id);
