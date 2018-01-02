package com.yi.www.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/***
 * uuid工具使用集合
 */
public class UUIDUtils {

    /***
     * 获取
     */
    @Test
    public  void getUuid(){
        String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
        System.out.println(uuid);
    }
}
