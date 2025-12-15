--liquibase formatted sql
--changeset Alexandr Makutsevich:2025-12-15--create-role-table.sql
CREATE TABLE role (
  id UUID PRIMARY KEY,
  name TEXT NOT NULL UNIQUE
);