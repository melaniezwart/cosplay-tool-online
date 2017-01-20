-- Sequences for coming tables
CREATE SEQUENCE project_messages_seq MAXVALUE 9223372036854775807 NO CYCLE;
CREATE SEQUENCE project_todo_seq MAXVALUE 9223372036854775807 NO CYCLE;

-- Tables for the connections between different entities
CREATE TABLE IF NOT EXISTS user_connections (
    user_id1 bigint not null,
    user_id2 bigint not null
);

CREATE TABLE IF NOT EXISTS mat_connections (
    mat_id1 bigint not null,
    mat_id2 bigint not null
);

CREATE TABLE IF NOT EXISTS project_materials (
    project_id bigint not null,
    material_id bigint not null
);

CREATE TABLE IF NOT EXISTS project_messages (
    id bigint primary key default (nextval('project_messages_seq')),
    project_id bigint not null,
    date_posted date not null,
    private_message boolean default false,
    message varchar(5000) not null
);

CREATE TABLE IF NOT EXISTS project_todo (
    id bigint primary key default (nextval('project_todo_seq')),
    project_id bigint not null,
    message varchar(500) not null,
    estimated_time int,
    estimated_cost int
);

-- Creates indexes for quicker searches
CREATE UNIQUE INDEX user_connections_i1 ON user_connections(user_id1, user_id2);
CREATE UNIQUE INDEX mat_connections_i1 ON mat_connections(mat_id1, mat_id2);
CREATE UNIQUE INDEX project_materials_i1 ON project_materials(project_id, material_id);
CREATE INDEX project_messages_i1 ON project_messages(id);
CREATE INDEX project_todo_i1 ON project_todo(id);

INSERT INTO user_connections (user_id1, user_id2) VALUES (1, 2);
INSERT INTO user_connections (user_id1, user_id2) VALUES (2, 1);
INSERT INTO user_connections (user_id1, user_id2) VALUES (3, 4);
INSERT INTO user_connections (user_id1, user_id2) VALUES (4, 3);

INSERT INTO mat_connections (mat_id1, mat_id2) VALUES (1, 2);
INSERT INTO mat_connections (mat_id1, mat_id2) VALUES (2, 1);
INSERT INTO mat_connections (mat_id1, mat_id2) VALUES (1, 3);
INSERT INTO mat_connections (mat_id1, mat_id2) VALUES (3, 1);
INSERT INTO mat_connections (mat_id1, mat_id2) VALUES (3, 4);
INSERT INTO mat_connections (mat_id1, mat_id2) VALUES (4, 3);

INSERT INTO project_materials (project_id, material_id) VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (2, 2),
    (2, 3),
    (3, 4),
    (3, 5);

INSERT INTO project_messages (project_id, date_posted, message) VALUES
    (1, date '2001-04-21', 'Message11'),
    (1, date '2002-04-21', 'Message12'),
    (1, date '2003-04-21', 'Message13'),
    (2, date '2001-04-21', 'Message21'),
    (2, date '2002-04-21', 'Message12'),
    (1, date '2001-04-21', 'Message31');


INSERT INTO project_todo (project_id, message, estimated_cost, estimated_time) VALUES
    (1, 'Message1', 1, 1),
    (1, 'Message2', 2, 2),
    (1, 'Message3', 3, 3),
    (2, 'Message1', 1, 1),
    (2, 'Message2', 2, 2),
    (3, 'Message1', 5, 5),
    (1, 'Message4', 4, 4);

