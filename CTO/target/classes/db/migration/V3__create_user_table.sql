create table CTO_USER(
    ID bigint not null primary key,
    USERNAME varchar(100) not null,
    PASSWORD varchar(100) not null,
    EMAIL varchar(255),
    DATEJOINED timestamp DEFAULT current_timestamp not null
);

create sequence user_seq maxvalue 9223372036854775807 no cycle;
create index cto_user_i1 on cto_user(id);

