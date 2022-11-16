package com.wangyousong.practice.pg.postgresql.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private Gender gender;
    private List<String> hobbies;
    private Map<String, Object> customizedFields;
}
