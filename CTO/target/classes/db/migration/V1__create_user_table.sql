create table CTO_USER(
    ID bigint not null primary key,
    USERNAME varchar(100) not null,
    PASSWORD varchar(100) not null,
    EMAIL varchar(255),
    DATEJOINED timestamp DEFAULT current_timestamp not null
);

create sequence user_seq maxvalue 9223372036854775807 no cycle;
create index cto_user_i1 on cto_user(id);

create table MATERIAL(
    ID bigint not null primary key,
    NAME varchar(100) not null,
    mat_alt_names bigint,
    mat_price bigint,
    mat_location bigint,
    avg_price int
);

create sequence material_seq maxvalue 9223372036854775807 no cycle;
create index material_i1 on material(id);

-- table for alternate names
create table MAT_ALT_NAMES(
    id bigint primary key not null,
    NAME varchar(100) not null,
    mat_id bigint not null
);

create table MAT_PRICE(
    id bigint primary key not null,
    PRICE varchar(100) not null,
    mat_id bigint not null
);

create table MAT_LOCATION(
    id bigint primary key not null,
    LOCATION varchar(100) not null,
    mat_id bigint not null
);

create sequence LOCATION_seq maxvalue 9223372036854775807 no cycle;
create index LOCATION_i1 on MAT_LOCATION(id);

create sequence PRICE_seq maxvalue 9223372036854775807 no cycle;
create index PRICE_i1 on MAT_PRICE(id);

create sequence ALT_seq maxvalue 9223372036854775807 no cycle;
create index ALT_NAMES_i1 on MAT_ALT_NAMES(id);
