package com.wangyousong.practice.pg.postgresql.infrastracture.persistence;

import com.wangyousong.practice.pg.postgresql.common.handler.JsonTypeHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.ArrayTypeHandler;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PgUserRepository {

    @Insert("""
            <script>
                insert into t_user(id, name, gender, hobby, customized_fields) values (
                    #{id},
                    #{name},
                    #{gender},
                    #{hobbies, typeHandler=org.apache.ibatis.type.ArrayTypeHandler},
                    #{customizedFields, typeHandler=com.wangyousong.practice.pg.postgresql.common.handler.JsonTypeHandler})
            </script>
            """)
    void insert(PgUser pgUser);

    @Result(column = "hobby", property = "hobbies", typeHandler = ArrayTypeHandler.class)
    @Result(column = "customized_fields", property = "customizedFields", typeHandler = JsonTypeHandler.class)
    @Select("select * from t_user where id = #{id}")
    PgUser findById(String id);

    @Result(column = "hobby", property = "hobbies", typeHandler = ArrayTypeHandler.class)
    @Select("select * from t_user")
    List<PgUser> findAll();

    @Delete("delete from t_user")
    void deleteAll();
}
