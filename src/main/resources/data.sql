
<<<<<<< HEAD
INSERT INTO roles (role_id, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO users (id, username, password) VALUES (default, 'admin', '$2a$12$K0PNWuP6xtBLdt8iFc.Jee6eJuCOHJx/y7gpQdp.I5EXg0Ub.JnEa');
INSERT INTO user_roles (role_id, user_id) VALUES (1, 1);

INSERT INTO events (id_events, title, date, maxparticipants, description, image_url, is_featured, location, time) VALUES
(1, 'Rock Fest', '2024-09-15', 500, 'El festival de rock más esperado del año.', 'https://example.com/images/rockfest.jpg', true, 'Parque Central', '18:00'),
(2, 'Jazz Night', '2024-09-18', 300, 'Una noche llena de jazz y melodías relajantes.', 'https://example.com/images/jazznight.jpg', false, 'Club de Jazz', '20:00'),
(3, 'Pop Music Live', '2024-09-20', 1000, 'Los éxitos del pop en vivo hola jisidhif wjfhdsf  ehwfiowefh wehfiowefh eiwifhweioñf wehwfvd skjfbsd f sdfgs skdjfglsa asjidfg ashgdis afdlaskgfas asfg s hfiowe f.', 'https://example.com/images/popmusiclive.jpg', true, 'Estadio Nacional', '19:30'),
=======
INSERT INTO roles (role_id, name) VALUES 
(default, 'ROLE_ADMIN'),
(default, 'ROLE_USER');

INSERT INTO users (id, username, password) VALUES 
(default, 'admin', '$2a$12$K0PNWuP6xtBLdt8iFc.Jee6eJuCOHJx/y7gpQdp.I5EXg0Ub.JnEa'),
(default, 'user', '$2a$12$K0PNWuP6xtBLdt8iFc.Jee6eJuCOHJx/y7gpQdp.I5EXg0Ub.JnEa');

INSERT INTO user_roles (role_id, user_id) VALUES 
(1, 1),
(2, 2);

INSERT INTO events (id_events, title, date, maxparticipants, description, image_url, is_featured, location, time) VALUES
(1, 'Rock Fest', '2024-09-15', 500, 'Get ready to rock at the annual Rock Fest this September! This one-night extravaganza will feature electrifying performances from legendary rock bands and rising stars. Expect an evening filled with iconic guitar riffs, powerful vocals, and pounding drum solos. This year`s lineup includes bands known for their influential rock anthems and spectacular live shows. In addition to great music, there will be artisan food stalls, craft beer stands, and exclusive festival merchandise. Join us at Parque Central to experience the raw energy and passion of live rock music!', 'https://example.com/images/rockfest.jpg', true, 'Parque Central', '18:00'),
(2, 'Jazz Night', '2024-09-18', 300, 'Experience the soothing and sophisticated sounds of jazz at our annual Jazz Night Under the Stars. This intimate evening will showcase a selection of some of the finest jazz musicians from around the globe. From smooth classics to modern twists, the melodies will transport you to the golden age of jazz. The event will be set in the serene ambiance of Club de Jazz, complete with candlelit tables and a starlit sky. Indulge in a gourmet menu paired perfectly with vintage wines while the sultry sounds of saxophones and double basses serenade you.', 'https://example.com/images/jazznight.jpg', false, 'Club de Jazz', '20:00'),
(3, 'Pop Music Live', '2024-09-20', 1000, 'This summer, the city`s biggest stadium turns into a pop paradise for the Pop Music Live: Summer Extravaganza! This festival brings together top chart-toppers and breakout artists for a day full of catchy tunes, spectacular dance routines, and unforgettable performances. The event features a massive stage with state-of-the-art sound and lighting to enhance the live performance experience. Attendees can enjoy interactive activities, photo booths, and meet-and-greets with their favorite artists. From pop icons to fresh new talent, get ready to dance the day away in a celebration of all things pop.', 'https://example.com/images/popmusiclive.jpg', true, 'Estadio Nacional', '19:30'),
>>>>>>> ab9681145364dc55a69d7e6dba84b2b109017e63
(4, 'Classical Evening', '2024-09-22', 200, 'Disfruta de la mejor música clásica.', 'https://example.com/images/classicalevening.jpg', false, 'Teatro Municipal', '17:00'),
(5, 'Indie Festival', '2024-09-25', 700, 'Un evento para los amantes de la música indie.', 'https://example.com/images/indiefestival.jpg', true, 'Plaza Independencia', '16:00'),
(6, 'Electronic Beats', '2024-09-27', 600, 'El mejor evento de música electrónica.', 'https://example.com/images/electronicbeats.jpg', false, 'Discoteca Central', '23:00'),
(7, 'Reggae Vibes', '2024-09-29', 400, 'Relájate con las mejores vibras del reggae.', 'https://example.com/images/reggaevibes.jpg', true, 'Parque del Sol', '15:00'),
(8, 'Folk Festival', '2024-09-30', 350, 'Lo mejor del folk en un solo lugar.', 'https://example.com/images/folkfestival.jpg', false, 'Anfiteatro de la Ciudad', '14:00'),
(9, 'Folk Festival', '2024-09-30', 350, 'Lo mejor del folk en un solo lugar.', 'https://example.com/images/folkfestival.jpg', false, 'Anfiteatro de la Ciudad', '14:00'),
(10, 'Latin Music Fiesta', '2024-10-01', 400, 'Baila al ritmo de la mejor música latina.', 'https://example.com/images/latinmusicfiesta.jpg', true, 'Plaza Mayor', '18:00'),
(11, 'Country Roadshow', '2024-10-02', 500, 'Un espectáculo de música country en la carretera.', 'https://example.com/images/countryroadshow.jpg', false, 'Estadio Municipal', '19:00'),
(12, 'Hip-Hop Culture Night', '2024-10-03', 300, 'La cultura del hip-hop en su máxima expresión.', 'https://example.com/images/hiphopculturenight.jpg', true, 'Club Nocturno', '21:00'),
(13, 'Blues Jam Session', '2024-10-04', 250, 'Sumérgete en los clásicos del blues.', 'https://example.com/images/bluesjamsession.jpg', false, 'Café del Jazz', '19:00'),
(14, 'Rock Legends Tribute', '2024-10-05', 1000, 'Un tributo a las leyendas del rock.', 'https://example.com/images/rocklegendstribute.jpg', true, 'Parque de las Naciones', '20:00'),
(15, 'Acoustic Sunday', '2024-10-06', 150, 'Un domingo de música acústica en vivo.', 'https://example.com/images/acousticsunday.jpg', false, 'Café Central', '12:00');

--  INSERT INTO event_registrations (event_id, user_id) VALUES (1, 1);