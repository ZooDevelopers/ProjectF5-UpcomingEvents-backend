INSERT INTO roles (role_id, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO users (id, username, password) VALUES (default, 'admin', 'password');
INSERT INTO roles_users (role_id, id) VALUES (1, 1);