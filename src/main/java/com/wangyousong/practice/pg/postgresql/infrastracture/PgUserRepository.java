package com.wangyousong.practice.pg.postgresql.infrastracture;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PgUserRepository {

    @Insert("insert into t_user(id, name, gender) values (#{id}, #{name}, #{gender})")
    void insert(PgUser pgUser);

    @Select("select * from t_user where id = #{id}")
    PgUser findById(String id);

    @Select("select * from t_user")
    List<PgUser> findAll();

    @Delete("delete from t_user")
    void deleteAll();
}
