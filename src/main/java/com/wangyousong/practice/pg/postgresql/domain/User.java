package com.wangyousong.practice.pg.postgresql.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private Gender gender;
    private List<String> hobbies;
}
