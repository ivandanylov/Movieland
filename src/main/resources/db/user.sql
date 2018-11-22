SET client_encoding = 'UTF8';

INSERT INTO movieland.users VALUES (1, 'paco', '012cbf6f-5955-4d38-9517-74d1e2366428', '3063727439001fc117a3428bd49510a7cc38232c082b0d9ea2a48ea3b3d33eee', 'USER', 'ronald.reynolds66@example.com', 'Рональд', 'Рейнольдс', '2018-11-21');
INSERT INTO movieland.users VALUES (2, 'bricks', '5db07daf-b586-444a-8423-619fd7656f1c', '9474673e4278edf9933173426f660268a1981d18b2e7fe25e0641e30b9adc01b', 'USER', 'darlene.edwards15@example.com', 'Дарлин', 'Эдвардс', '2018-11-21');
INSERT INTO movieland.users VALUES (3, 'hjkl', 'bf5973c2-aaf8-4ab9-9fa1-bdb93a03fff0', '477c5737153dab1329778e3af4ff0d738a9621b0757d966a1faaefe2943ffc22', 'USER', 'gabriel.jackson91@example.com', 'Габриэль', 'Джексон', '2018-11-21');
INSERT INTO movieland.users VALUES (4, 'exodus', 'b3c6ab99-630a-4c90-bfc6-0f1b07c560ac', 'b62f7f4651212f1a160ed3aea2044269fe2c6b3b443b8423b1c0f27b47bee967', 'USER', 'daryl.bryant94@example.com', 'Дэрил', 'Брайант', '2018-11-21');
INSERT INTO movieland.users VALUES (5, '878787', 'da1eef88-76d4-4f74-8697-88bc97330fca', '138bfbcce1db3a3a07d701021c5f1e0439b5fdd62ad54a6c2b42df4b1ef0a89e', 'USER', 'neil.parker43@example.com', 'Нил', 'Паркер', '2018-11-21');
INSERT INTO movieland.users VALUES (6, 'smart', '6150cc40-99d2-4c77-9368-ee1441238f75', 'f1b1a530d7042b3520f217af0d47084e0736d1a77aa52b2497b8404dcad392d5', 'USER', 'travis.wright36@example.com', 'Трэвис', 'Райт', '2018-11-21');
INSERT INTO movieland.users VALUES (7, 'beaker', '41c25f68-6819-434d-af11-c0760f3e00db', '1887189d70d9d98fdfe6dd2376744bf5f3330cf36d748950163ee6148667f5d9', 'USER', 'amelia.kennedy58@example.com', 'Амелия', 'Кэннеди', '2018-11-21');
INSERT INTO movieland.users VALUES (8, 'pepsi1', '99a3d943-43d3-4ac5-aa43-1aec4f7562ed', '7e79492ac90feaa5b9e69918b944ac7e5a0bc9f5a3e0cfb4ec1b141ad510dd20', 'USER', 'ida.davis80@example.com', 'Айда', 'Дэвис', '2018-11-21');
INSERT INTO movieland.users VALUES (9, 'tommy', '6e551168-cfa6-48a3-8397-1e393970a992', 'cac5b2d6784934e0a0f5a7533c5a8c129cbb1f7a3b1af1a94746c79813dd70c2', 'USER', 'jessie.patterson68@example.com', 'Джесси', 'Паттерсон', '2018-11-21');
INSERT INTO movieland.users VALUES (10, 'coldbeer', 'df9256e9-71d9-4885-b457-b183e5259971', 'd6af09c51bfb59379bfb438e084d975fbfbc1c9219fcaede75b4347f9ca357d3', 'USER', 'dennis.craig82@example.com', 'Деннис', 'Крейг', '2018-11-21');
INSERT INTO movieland.users VALUES (11, 'admin', '7521ecd0-7f4e-4924-be0b-adf46130999d', '71863df5124cf2967bb945210144259cc01a11cc6210d30a2b03d6631a480323', 'ADMIN', 'ivandanylov@gmail.com', 'Иван', 'Данилов', '2018-11-21');

SELECT pg_catalog.setval('movieland.users_id_seq', 11, true);
