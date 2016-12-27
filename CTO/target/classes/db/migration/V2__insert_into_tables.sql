INSERT INTO cto.CTO_USER(id, cto_username, email) VALUES
(nextval('user_seq'), 'testname1', 'test1@test.com'),
(nextval('user_seq'), 'testname2', 'test2@test.com'),
(nextval('user_seq'), 'testname3', 'test3@test.com'),
(nextval('user_seq'), 'testname4', 'test4@test.com'),
(nextval('user_seq'), 'testname5', 'test5@test.com'),
(nextval('user_seq'), 'testname6', 'test6@test.com');

INSERT INTO cto.CTO_LOGIN(username, password) VALUES
('testuser1', md5('testpass1')),
('testuser2', md5('testpass2')),
('testuser3', md5('testpass3')),
('testuser4', md5('testpass4')),
('testuser5', md5('testpass5')),
('testuser6', md5('testpass6')),
('testuser7', md5('testpass7'));

INSERT INTO cto.MATERIAL(id, name, avg_price) VALUES
(nextval('material_seq'), 'eva1', 5),
(nextval('material_seq'), 'eva2', 6),
(nextval('material_seq'), 'eva3', 7),
(nextval('material_seq'), 'eva4', 8),
(nextval('material_seq'), 'eva5', 9),
(nextval('material_seq'), 'eva6', 10),
(nextval('material_seq'), 'eva7', 11);

INSERT INTO cto.MAT_LOCATION(id, location, mat_id, price) VALUES
(nextval('location_seq'), 'here1', 2, 5),
(nextval('location_seq'), 'here2', 2, 6),
(nextval('location_seq'), 'here4', 4, 7),
(nextval('location_seq'), 'here5', 4, 8),
(nextval('location_seq'), 'here6', 5, 9),
(nextval('location_seq'), 'here7', 5, 1),
(nextval('location_seq'), 'here8', 6, 2),
(nextval('location_seq'), 'here9', 7, 3);

INSERT INTO cto.CTO_MAT_TO_MAT(mat_id1, mat_id2) VALUES
(1, 2),
(2, 1),
(3, 4),
(4, 3),
(5, 6),
(6, 5);
