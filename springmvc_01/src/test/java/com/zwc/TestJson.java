package com.zwc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zwc.pojo.Person;
import com.zwc.pojo.Pet;
import org.junit.jupiter.api.Test;

public class TestJson {

    @Test
    public void testA() throws JsonProcessingException {
        Pet pet = new Pet("tom", "cat");
        String s = new ObjectMapper().writeValueAsString(pet);
        System.out.println(s);
    }
}
