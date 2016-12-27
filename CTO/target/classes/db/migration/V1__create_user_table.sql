create table CTO_USER(
    ID bigint not null primary key,
    CTO_USERNAME varchar(100) not null,
    EMAIL varchar(255),
    DATEJOINED timestamp DEFAULT current_timestamp not null
);

create sequence user_seq maxvalue 9223372036854775807 no cycle;
create index cto_user_i1 on cto_user(id);

create table CTO_LOGIN(
    USERNAME varchar(100) not null,
    PASSWORD varchar(100) not null,
    CTO_USER_ID bigint
);

create table MATERIAL(
    ID bigint not null primary key,
    NAME varchar(100) not null,
    avg_price int
);

create sequence material_seq maxvalue 9223372036854775807 no cycle;
create index material_i1 on material(id);

-- table for alternate names
create table MAT_LOCATION(
    id bigint primary key not null,
    LOCATION varchar(100) not null,
    mat_id bigint not null,
    price int
);

create sequence LOCATION_seq maxvalue 9223372036854775807 no cycle;
create index LOCATION_i1 on MAT_LOCATION(id);

alter table MAT_LOCATION add foreign key(mat_id) references MATERIAL(id);

create table CTO_MAT_TO_MAT  (
	mat_id1 bigint not null,
	mat_id2 bigint not null,
	UNIQUE (mat_id1, mat_id2)
);

alter table CTO_MAT_TO_MAT add foreign key(mat_id1) references MATERIAL(id);
alter table CTO_MAT_TO_MAT add foreign key(mat_id2) references MATERIAL(id);
