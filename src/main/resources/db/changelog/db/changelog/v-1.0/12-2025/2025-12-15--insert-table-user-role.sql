--liquibase formatted sql
--changeset Alexandr Makutsevich:2025-12-15--insert-table-user-role.sql

INSERT INTO role (id, name) VALUES ('00000000-0000-0000-0000-000000000001', 'ADMIN');

INSERT INTO "user" (id, fio, phone_number, email, password, is_delete)
VALUES (
    '00000000-0000-0000-0000-000000000010',
    'Al al',
    '1234567890',
    'admin@jobpulse.dev',
    'password',
    false
);

INSERT INTO user_role (user_id, role_id)
VALUES ('00000000-0000-0000-0000-000000000010', '00000000-0000-0000-0000-000000000001');