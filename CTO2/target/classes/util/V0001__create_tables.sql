CREATE SEQUENCE account_id MAXVALUE 9223372036854775807 NO CYCLE;

CREATE TABLE IF NOT EXISTS account(
    id bigint primary key default (nextval('account_id')),
    username varchar(50) not null,
    password varchar(50) not null
);

CREATE SEQUENCE bookmark_id MAXVALUE 9223372036854775807 NO CYCLE;

CREATE TABLE IF NOT EXISTS bookmark(
    id bigint primary key default (nextval('bookmark_id')),
    account_id bigint not null,
    uri varchar(200) not null,
    description varchar(500)
);

--Indexes on tables for quicker searching
CREATE INDEX account_id_1 ON account(id);
CREATE INDEX bookmark_id_1 ON bookmark(id);
