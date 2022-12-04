package com.example.util;

public class SnowflakeIdUtils {

    private static SnowflakeIdWorker idWorker;
    static {
        idWorker = new SnowflakeIdWorker(1, 1);
    }

    public static Long nextId() {
        return idWorker.nextId();
    }

}
