-- changeset jobpulse:init-admin
INSERT INTO role (id, name) VALUES ('00000000-0000-0000-0000-000000000001', 'ADMIN');

INSERT INTO "user" (id, email, password_hash, deleted)
VALUES ('00000000-0000-0000-0000-000000000010', 'admin@jobpulse.dev', 'HASHED_PASSWORD', false);

INSERT INTO user_role (user_id, role_id)
VALUES ('00000000-0000-0000-0000-000000000010', '00000000-0000-0000-0000-000000000001');