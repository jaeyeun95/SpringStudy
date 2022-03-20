package com.example.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonParsing {
    public static void main(String[] args) throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("D:\\coding\\study_workspace\\SpringStudy\\jackson\\src\\main\\java\\com\\example\\test\\JSONFile3.json"));

        JSONObject cafe24Obj = (JSONObject) obj;

        String cafe24Json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cafe24Obj);

        System.out.println("cafe24Json : " + cafe24Json);

        Cafe24 cafe24 = objectMapper.readValue(cafe24Json, Cafe24.class);

        System.out.println("cafe24 : " + cafe24);

        User user = objectMapper.convertValue(cafe24, User.class);

        System.out.println("user : " + user);

    }
}
