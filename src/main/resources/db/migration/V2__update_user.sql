alter table t_user
    add "customized_fields" jsonb;

comment on column t_user."customized_fields" is '自定义字段';