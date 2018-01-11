package com.yi.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.parsing.SourceExtractor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StringTest {
    private  final String ttt = "1";
    @Test
    public void int_to_string_if_null(){
        System.out.println(String.valueOf(null));
    }
    @Test
    public void get_value_byIntegerKye_from_stringKeymap(){
        Map<String,String> map = new HashMap<String,String>();
        System.out.println(map.isEmpty());
        map.put(String.valueOf(1),"yes,你没看错，就是我！！");
        System.out.println(map.get("1"));
    }

    @Test
    public void string_2_integer_if_null(){
       String t = "1";
        System.out.println(t.equals(ttt));
    }

    @Test
    public void collection_2_list(){
        Collection<String> cs = new ArrayList<>();
    }
}
