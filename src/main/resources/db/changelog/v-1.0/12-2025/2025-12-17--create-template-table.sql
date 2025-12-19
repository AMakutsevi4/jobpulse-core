--liquibase formatted sql
--changeset Alexandr Makutsevich:2025-12-17--create-template-table.sql
CREATE TABLE templates (
  id UUID PRIMARY KEY,
  title VARCHAR(50),
  content TEXT
);