package com.wangyousong.practice.pg.postgresql.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private Gender gender;
}
