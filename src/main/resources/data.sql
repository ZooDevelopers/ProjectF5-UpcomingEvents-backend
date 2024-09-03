INSERT INTO roles (role_id, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO users (id, username, password) VALUES (default, 'admin', '$2a$12$K0PNWuP6xtBLdt8iFc.Jee6eJuCOHJx/y7gpQdp.I5EXg0Ub.JnEa');
INSERT INTO user_roles (role_id, user_id) VALUES (1, 1);

INSERT INTO events (id_events, title, maxparticipants, description, is_featured, location) VALUES (default, 'Event 1', '5', 'event description', 'true', 'Lisbon');
INSERT INTO events (id_events, title, maxparticipants, description, is_featured, location) VALUES (default, 'Event 2', '10', 'event description 2', 'true', 'Madrid');


INSERT INTO event_registrations (event_id, user_id) VALUES (1, 1);