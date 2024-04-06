create schema public;

CREATE TABLE IF NOT EXISTS smartphone (
    id UUID PRIMARY KEY,
    model VARCHAR(40),
    smartphone_manufacturer VARCHAR(40),
    processor_id UUID
);

CREATE TABLE IF NOT EXISTS processor (
    id UUID PRIMARY KEY,
    model INTEGER,
    name VARCHAR(40),
    cores INTEGER,
    frequency INTEGER,
    processor_manufacturer VARCHAR(40)
);





