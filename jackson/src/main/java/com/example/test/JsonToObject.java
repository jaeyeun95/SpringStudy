package com.example.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonToObject {
    public static void main(String[] args) throws IOException {

        String json = "{\"name\":\"zooneon\",\"age\":25}";

        System.out.println("json : " + json);

        ObjectMapper objectMapper = new ObjectMapper();

        Person person = objectMapper.readValue(json, Person.class);

        System.out.println("JsonToObject : " + person);

        Map<String, Object> map = new HashMap<>();

        map = objectMapper.readValue(json, Map.class);

        System.out.println("Map : " + map);




    }
}
