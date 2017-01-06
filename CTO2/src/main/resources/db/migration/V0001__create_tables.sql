--Creates sequences for generated ids
CREATE SEQUENCE account_id MAXVALUE 9223372036854775807 NO CYCLE;

--Creates tables
CREATE TABLE IF NOT EXISTS account(
    id bigint primary key default (nextval('account_id')),
    username varchar(50) not null,
    password varchar(50) not null
);

--Indexes on tables for quicker searching
CREATE INDEX account_id_1 ON account(id);
