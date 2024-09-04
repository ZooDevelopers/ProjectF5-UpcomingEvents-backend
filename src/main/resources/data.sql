
INSERT INTO roles (role_id, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO users (id, username, password) VALUES (default, 'admin', '$2a$12$K0PNWuP6xtBLdt8iFc.Jee6eJuCOHJx/y7gpQdp.I5EXg0Ub.JnEa');
INSERT INTO user_roles (role_id, user_id) VALUES (1, 1);

INSERT INTO events (id_events, title, date, maxparticipants, description, image_url, is_featured, location, time) VALUES
(1, 'Rock Fest', '2024-09-15', 500, 'El festival de rock más esperado del año.', 'https://example.com/images/rockfest.jpg', true, 'Parque Central', '18:00'),
(2, 'Jazz Night', '2024-09-18', 300, 'Una noche llena de jazz y melodías relajantes.', 'https://example.com/images/jazznight.jpg', false, 'Club de Jazz', '20:00'),
(3, 'Pop Music Live', '2024-09-20', 1000, 'Los éxitos del pop en vivo hola jisidhif wjfhdsf  ehwfiowefh wehfiowefh eiwifhweioñf wehwfvd skjfbsd f sdfgs skdjfglsa asjidfg ashgdis afdlaskgfas asfg s hfiowe f.', 'https://example.com/images/popmusiclive.jpg', true, 'Estadio Nacional', '19:30'),
(4, 'Classical Evening', '2024-09-22', 200, 'Disfruta de la mejor música clásica.', 'https://example.com/images/classicalevening.jpg', false, 'Teatro Municipal', '17:00'),
(5, 'Indie Festival', '2024-09-25', 700, 'Un evento para los amantes de la música indie.', 'https://example.com/images/indiefestival.jpg', true, 'Plaza Independencia', '16:00'),
(6, 'Electronic Beats', '2024-09-27', 600, 'El mejor evento de música electrónica.', 'https://example.com/images/electronicbeats.jpg', false, 'Discoteca Central', '23:00'),
(7, 'Reggae Vibes', '2024-09-29', 400, 'Relájate con las mejores vibras del reggae.', 'https://example.com/images/reggaevibes.jpg', true, 'Parque del Sol', '15:00'),
(8, 'Folk Festival', '2024-09-30', 350, 'Lo mejor del folk en un solo lugar.', 'https://example.com/images/folkfestival.jpg', false, 'Anfiteatro de la Ciudad', '14:00');

INSERT INTO event_registrations (event_id, user_id) VALUES (1, 1);