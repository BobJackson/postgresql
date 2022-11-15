package com.wangyousong.practice.pg.postgresql.infrastracture.acl;

import com.wangyousong.practice.pg.postgresql.domain.User;
import com.wangyousong.practice.pg.postgresql.domain.UserService;
import com.wangyousong.practice.pg.postgresql.infrastracture.PgUser;
import com.wangyousong.practice.pg.postgresql.infrastracture.PgUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PgUserService implements UserService {

    @Resource
    private PgUserRepository repository;

    @Override
    public void createUser(User user) {
        repository.insert(PgUser.from(user));
    }

    @Override
    public Optional<User> findUserById(String id) {
        PgUser pgUser = repository.findById(id);
        if (Objects.isNull(pgUser)) return Optional.empty();
        return Optional.of(pgUser.to());
    }

    @Override
    public List<User> listAllUser() {
        List<PgUser> users = repository.findAll();
        return users.stream().map(PgUser::to).toList();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
