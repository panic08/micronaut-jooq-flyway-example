CREATE  TABLE IF NOT EXISTS person(
                       id   bigint primary key not null,
                       name varchar(255)       not null,
                       surname  varchar(255)   not null,
                       age  int                not null
)