--liquibase formatted sql
--changeset Alexandr Makutsevich:2025-12-15--create-user-table.sql

CREATE TABLE "user" (
    id UUID PRIMARY KEY,
    fio TEXT NOT NULL,
    phone_number TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    is_delete BOOLEAN DEFAULT FALSE
);


CREATE TABLE user_role (
    user_id UUID NOT NULL REFERENCES "user"(id),
    role_id UUID NOT NULL REFERENCES role(id),
    PRIMARY KEY (user_id, role_id)
);