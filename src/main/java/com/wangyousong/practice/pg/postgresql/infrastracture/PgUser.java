package com.wangyousong.practice.pg.postgresql.infrastracture;

import com.wangyousong.practice.pg.postgresql.domain.Gender;
import com.wangyousong.practice.pg.postgresql.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PgUser {
    private String id;
    private String name;
    private String gender;
    private String[] hobbies;

    public static PgUser from(User user) {
        return new PgUser(user.getId(),
                user.getName(),
                user.getGender().name(),
                Optional.ofNullable(user.getHobbies()).orElseThrow().toArray(new String[0]));
    }

    public User to() {
        return new User(id,
                name,
                Gender.valueOf(gender),
                Arrays.asList(Optional.ofNullable(hobbies).orElseGet(() -> new String[]{})));
    }
}
