package com.wangyousong.practice.pg.postgresql.infrastracture.acl;

import com.wangyousong.practice.pg.postgresql.common.util.IdUtils;
import com.wangyousong.practice.pg.postgresql.domain.Gender;
import com.wangyousong.practice.pg.postgresql.domain.User;
import com.wangyousong.practice.pg.postgresql.domain.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PgUserServiceTest {

    @Autowired
    private UserService userService;

    @AfterEach
    void tearDown() {
        userService.deleteAll();
    }

    @Test
    void should_create_a_user() {
        String id = IdUtils.id();
        userService.createUser(buildAUser(id));

        Optional<User> optional = userService.findUserById(id);

        assertTrue(optional.isPresent());
    }

    @Test
    void should_save_hobbies() {
        String id = IdUtils.id();
        userService.createUser(buildAUser(id));

        Optional<User> optional = userService.findUserById(id);

        assertTrue(optional.isPresent());
        User user = optional.get();
        assertEquals(3, user.getHobbies().size());
    }

    private static User buildAUser(String id) {
        return new User(id,
                "Bob Jackson",
                Gender.MALE,
                List.of("Basketball", "Swimming", "Running"));
    }

    @Test
    void should_return_empty_list_when_no_data() {
        userService.deleteAll();

        List<User> users = userService.listAllUser();

        assertTrue(users.isEmpty());
    }

    @Test
    void should_return_list_when_has_data() {
        userService.createUser(buildAUser(IdUtils.id()));

        List<User> users = userService.listAllUser();

        assertEquals(1, users.size());
    }

}