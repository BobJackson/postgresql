package com.wangyousong.practice.pg.postgresql.domain;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);

    Optional<User> findUserById(String id);

    List<User> listAllUser();

    void deleteAll();
}
