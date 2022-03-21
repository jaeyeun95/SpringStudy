package com.example.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TypeReferenceEx {
    public static void main(String[] args) throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
//
//        String json = "{\"name\":\"mkyong\", \"age\":29, \"messages\" : [\"msg 1\",\"msg 2\",\"msg 3\"] }";
//
//        System.out.println(json);
//
//        Map<String, Object> map;
//        map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
//
//        System.out.println(map);

        JSONParser parser = new JSONParser();
//        Object obj = parser.parse(new FileReader("D:\\coding\\study_workspace\\SpringStudy\\jackson\\src\\main\\java\\com\\example\\test\\test.json"));
        Object obj = parser.parse(new FileReader("D:\\coding\\study_workspace\\SpringStudy\\jackson\\src\\main\\java\\com\\example\\test\\test3.json"));

        JSONObject jo = (JSONObject) obj;
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jo);
        System.out.println("json : "+json);

        Map<String, Object> map = new HashMap<>();
        map = objectMapper.readValue(json, new TypeReference<Map<String, List<UserList.Users>>>(){});

        System.out.println("map : " + map);

//        User user = new User();
//        user = objectMapper.readValue(json, new TypeReference<Map<String, List<User.Users>>>(){});
//
//        System.out.println(user);


    }

}
