CREATE TABLE producers (
    producer_id         SERIAL          PRIMARY KEY,
    producer_name       VARCHAR(100)    NOT NULL,
    address             VARCHAR(100)
);