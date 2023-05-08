create table counter
(
    id   serial primary key,
    code varchar(20) not null
);

insert into counter(code)
values ('a0a0');