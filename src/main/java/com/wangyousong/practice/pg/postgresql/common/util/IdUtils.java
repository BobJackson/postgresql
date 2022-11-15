package com.wangyousong.practice.pg.postgresql.common.util;

import java.util.UUID;

public class IdUtils {

    private IdUtils() {
    }

    public static String id() {
        return UUID.randomUUID().toString();
    }
}
