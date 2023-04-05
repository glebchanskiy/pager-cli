create table shared_message
(
    id       serial,
    text     varchar not null,
    username varchar
);

alter table shared_message
    owner to postgres;

create table "users"
(
    id       serial
             primary key,
    username varchar not null,
    password varchar not null
);

alter table "users"
    owner to postgres;

create unique index user_username_uindex
    on "users" (username);


