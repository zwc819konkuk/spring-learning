package com.zwc;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class TestUUID {

    @Test
    public void Test01(){
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        System.out.println(s);
    }
}
