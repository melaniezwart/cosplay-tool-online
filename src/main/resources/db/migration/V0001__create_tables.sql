--Creates sequences for generated ids
CREATE SEQUENCE cto_user_id MAXVALUE 9223372036854775807 NO CYCLE;
CREATE SEQUENCE material_id MAXVALUE 9223372036854775807 NO CYCLE;
CREATE SEQUENCE project_id MAXVALUE 9223372036854775807 NO CYCLE;

--Creates tables
CREATE TABLE IF NOT EXISTS cto_user(
    id bigint primary key default (nextval('cto_user_id')),
    username varchar(50) not null,
    password varchar(50) not null,
    role varchar(10) not null,
    private_profile boolean,
    email varchar(100)
);

CREATE TABLE IF NOT EXISTS material(
    id bigint primary key default (nextval('material_id')),
    name varchar(50) not null,
    price int,
    location varchar(200)
);

CREATE TABLE IF NOT EXISTS project(
    id bigint primary key default (nextval('project_id')),
    name varchar(200),
    date_started varchar(50) not null,
    date_finished varchar(50),
    finished boolean,
    days_passed int,
    cto_user bigint not null,
    total_money_spent int,
    estimated_cost int,
    estimated_time int,
    private_profile boolean
);

--Indexes on tables for quicker searching
CREATE INDEX cto_user_i1 ON cto_user(id);
CREATE INDEX material_i1 ON material(id);
CREATE INDEX project_i1 ON project(id);
