--Creates sequences for generated ids
CREATE SEQUENCE cto_user_id MAXVALUE 9223372036854775807 NO CYCLE;

--Creates tables
CREATE TABLE IF NOT EXISTS cto_user(
    id bigint primary key default (nextval('cto_user_id')),
    username varchar(50) not null,
    password varchar(50) not null
);

--Indexes on tables for quicker searching
CREATE INDEX cto_user_id_1 ON cto_user(id);
