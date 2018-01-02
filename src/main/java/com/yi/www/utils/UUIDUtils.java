package com.yi.www.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UUIDUtils {
    @Test
    public  void getUuid(){
        String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
        System.out.println(uuid);
    }
}
