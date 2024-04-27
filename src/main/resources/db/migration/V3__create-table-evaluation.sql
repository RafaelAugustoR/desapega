CREATE TABLE evaluation(
    id UUID PRIMARY KEY NOT NULL,
    rating DECIMAL(1, 1) NOT NULL,
    comment TEXT NOT NULL,
    date TIMESTAMP NOT NULL,
    evaluating_user_id UUID,
    evaluated_user_id UUID,
    FOREIGN KEY (evaluating_user_id) REFERENCES "user" (id),
    FOREIGN KEY (evaluated_user_id) REFERENCES "user" (id)
);