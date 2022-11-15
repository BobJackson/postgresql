package com.wangyousong.practice.pg.postgresql.infrastracture;

import com.wangyousong.practice.pg.postgresql.domain.Gender;
import com.wangyousong.practice.pg.postgresql.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PgUser {
    private String id;
    private String name;
    private String gender;
    private List<String> hobbies;

    public static PgUser from(User user) {
        return new PgUser(user.getId(),
                user.getName(),
                user.getGender().name(),
                user.getHobbies());
    }

    public User to() {
        return new User(this.id,
                this.name,
                Gender.valueOf(this.gender),
                this.hobbies);
    }
}
