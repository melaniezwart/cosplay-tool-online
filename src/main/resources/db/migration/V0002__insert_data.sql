INSERT INTO cto_user(username, password, role) VALUES ('user1', md5('pass1'), 'USER');
INSERT INTO cto_user(username, password, role) VALUES ('user2', md5('pass2'), 'USER');
INSERT INTO cto_user(username, password, role) VALUES ('user3', md5('pass3'), 'USER');
INSERT INTO cto_user(username, password, role) VALUES ('user4', md5('pass4'), 'USER');
INSERT INTO cto_user(username, password, role) VALUES ('user5', md5('pass5'), 'USER');
INSERT INTO cto_user(username, password, role) VALUES ('admin', md5('admin'), 'ADMIN');


INSERT INTO material(name, price, location) VALUES ('mat1', 5, 'here');
INSERT INTO material(name, price, location) VALUES ('mat2', 6, 'here1');
INSERT INTO material(name, price, location) VALUES ('mat3', 7, 'here2');
INSERT INTO material(name, price, location) VALUES ('mat4', 8, 'here3');
INSERT INTO material(name, price, location) VALUES ('mat5', 9, 'here4');

INSERT INTO project(name, date_started, finished, days_passed, cto_user, total_money_spent, estimated_cost, estimated_time)
    VALUES('Project1', date '2001-09-28', false, 100, 5, 105, 10, 15),
    ('Project2', date '2002-09-28', false, 101, 4, 106, 11, 16),
    ('Project3', date '2003-09-28', false, 102, 3, 107, 12, 17),
    ('Project4', date '2004-09-28', false, 103, 2, 108, 13, 18),
    ('Project5', date '2005-09-28', false, 104, 1, 109, 14, 19);
