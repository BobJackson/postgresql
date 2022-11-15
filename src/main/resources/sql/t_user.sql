-- auto-generated definition
create table t_user
(
    id     varchar not null
        constraint t_user_pk
            primary key,
    name   varchar not null,
    gender varchar not null
);

comment on table t_user is '用户表';

comment on column t_user.id is 'id';

comment on column t_user.name is '名称';

comment on column t_user.gender is '性别';

alter table t_user
    owner to postgres;

create index t_user__index_name
    on t_user (name);