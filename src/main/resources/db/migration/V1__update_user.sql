alter table t_user
    add hobby varchar[];

comment on column t_user.hobby is '爱好';