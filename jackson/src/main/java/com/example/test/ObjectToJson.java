package com.example.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJson {
    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person();
        person.setName("홍길동");
        person.setAge(20);

        System.out.println("Person Obj : " + person);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(person);

        System.out.println("JSON : " + json);
    }
}
