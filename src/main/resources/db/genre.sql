SET client_encoding = 'UTF8';

INSERT INTO movieland.genre VALUES (1, 'драма');
INSERT INTO movieland.genre VALUES (2, 'криминал');
INSERT INTO movieland.genre VALUES (3, 'фэнтези');
INSERT INTO movieland.genre VALUES (4, 'детектив');
INSERT INTO movieland.genre VALUES (5, 'мелодрама');
INSERT INTO movieland.genre VALUES (6, 'биография');
INSERT INTO movieland.genre VALUES (7, 'комедия');
INSERT INTO movieland.genre VALUES (8, 'фантастика');
INSERT INTO movieland.genre VALUES (9, 'боевик');
INSERT INTO movieland.genre VALUES (10, 'триллер');
INSERT INTO movieland.genre VALUES (11, 'приключения');
INSERT INTO movieland.genre VALUES (12, 'аниме');
INSERT INTO movieland.genre VALUES (13, 'мультфильм');
INSERT INTO movieland.genre VALUES (14, 'семейный');
INSERT INTO movieland.genre VALUES (15, 'вестерн');

SELECT pg_catalog.setval('movieland.genre_id_seq', 15, true);
