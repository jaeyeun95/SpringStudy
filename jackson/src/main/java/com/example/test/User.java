package com.example.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User {
    private List<Users> users;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class Users {
        private Integer userId;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String emailAddress;
        private String homepage;
    }

}
