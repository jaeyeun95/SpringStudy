package com.example.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Student {
    private String firstName;
    private String lastName;
    private Integer age;

//    @JsonProperty("Request")
//    private Request request;
    private List<Phone> phoneNumbers;

//    @Getter
//    @Setter
//    @ToString
//    @NoArgsConstructor
//    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
//    public static class Request {
//        private String test;
//    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
//    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Phone{
        private String type;
        private String phoneNumber;
    }

}
