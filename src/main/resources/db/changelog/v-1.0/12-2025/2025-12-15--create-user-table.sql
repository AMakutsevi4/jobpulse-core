--liquibase formatted sql
--changeset Alexandr Makutsevich:2025-12-15--create-user-table.sql

CREATE TABLE "user" (
    id UUID PRIMARY KEY,
    fio TEXT NOT NULL,
    phone_number TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    is_delete BOOLEAN DEFAULT FALSE
);