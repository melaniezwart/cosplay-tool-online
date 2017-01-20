INSERT INTO cto_user(username, password, role, private_profile) VALUES
    ('user1', md5('pass1'), 'USER', false),
    ('user2', md5('pass2'), 'USER', false),
    ('user3', md5('pass3'), 'USER', true),
    ('user4', md5('pass4'), 'USER', false),
    ('user5', md5('pass5'), 'USER', false),
    ('admin', md5('admin'), 'ADMIN', false);


INSERT INTO material(name, price, location) VALUES ('mat1', 5, 'here');
INSERT INTO material(name, price, location) VALUES ('mat2', 6, 'here1');
INSERT INTO material(name, price, location) VALUES ('mat3', 7, 'here2');
INSERT INTO material(name, price, location) VALUES ('mat4', 8, 'here3');
INSERT INTO material(name, price, location) VALUES ('mat5', 9, 'here4');

INSERT INTO project(name, date_started, finished, days_passed, cto_user, total_money_spent, estimated_cost, estimated_time, private_profile)
    VALUES('Project1', date '2001-09-28', false, 100, 5, 105, 10, 15, false),
    ('Project2', date '2002-09-28', false, 101, 4, 106, 11, 16, true),
    ('Project3', date '2003-09-28', false, 102, 3, 107, 12, 17, false),
    ('Project4', date '2004-09-28', false, 103, 2, 108, 13, 18, true),
    ('Project5', date '2005-09-28', false, 104, 1, 109, 14, 19, false);
