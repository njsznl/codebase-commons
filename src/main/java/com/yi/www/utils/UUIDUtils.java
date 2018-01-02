package com.yi.www.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/***
 * uuid工具使用集合
 */
class UUIDUtils {

    /***
     * 获取一个uuid
     */
    @Test
    private void getUuid(){
        String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
        System.out.println(uuid);
    }

}
