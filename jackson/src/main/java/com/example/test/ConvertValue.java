package com.example.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ConvertValue {
    public static void main(String[] args) throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("D:\\coding\\study_workspace\\SpringStudy\\jackson\\src\\main\\java\\com\\example\\test\\JSONFile.json"));

        JSONObject jo = (JSONObject) obj;
        System.out.println("jo : "+jo);

        Student json = objectMapper.convertValue(jo, Student.class);

        System.out.println("Student :   " + json);

    }
}
