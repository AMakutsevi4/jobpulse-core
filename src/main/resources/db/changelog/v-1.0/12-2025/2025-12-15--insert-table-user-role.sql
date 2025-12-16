--liquibase formatted sql
--changeset Alexandr Makutsevich:2025-12-15--insert-table-user-role.sql

INSERT INTO role (id, type)
VALUES
('00000000-0000-0000-0000-000000000001', 'ADMIN'),
('00000000-0000-0000-0000-000000000002', 'USER');

INSERT INTO "user"
(id, fio, phone_number, email, password, is_delete)
VALUES
(
'00000000-0000-0000-0000-000000000010',
'Admin',
'0000000000',
'admin@jobpulse.dev',
'$2a$10$HASH',
false
);

INSERT INTO user_role
VALUES
('00000000-0000-0000-0000-000000000010',
 '00000000-0000-0000-0000-000000000001');