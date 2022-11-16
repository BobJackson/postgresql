package com.wangyousong.practice.pg.postgresql.infrastracture.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangyousong.practice.pg.postgresql.domain.Gender;
import com.wangyousong.practice.pg.postgresql.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PgUser {
    private String id;
    private String name;
    private String gender;
    private String[] hobbies;
    private Object customizedFields;

    public static PgUser from(User user) {
        return new PgUser(user.getId(),
                user.getName(),
                user.getGender().name(),
                Optional.ofNullable(user.getHobbies()).orElseThrow().toArray(new String[0]),
                user.getCustomizedFields());
    }

    @SneakyThrows
    public User to() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> fields = mapper.readValue(Optional.ofNullable(customizedFields).orElse("{}").toString(), new TypeReference<>() {
        });
        return new User(id,
                name,
                Gender.valueOf(gender),
                Arrays.asList(Optional.ofNullable(hobbies).orElseGet(() -> new String[]{})),
                fields);
    }
}
