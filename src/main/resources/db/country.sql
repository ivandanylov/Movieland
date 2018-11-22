SET client_encoding = 'UTF8';

INSERT INTO movieland.country VALUES (1, 'США');
INSERT INTO movieland.country VALUES (2, 'Франция');
INSERT INTO movieland.country VALUES (3, 'Великобритания');
INSERT INTO movieland.country VALUES (4, 'Италия');
INSERT INTO movieland.country VALUES (5, 'Германия');
INSERT INTO movieland.country VALUES (6, 'Япония');
INSERT INTO movieland.country VALUES (7, 'Испания');

SELECT pg_catalog.setval('movieland.country_id_seq', 7, true);
