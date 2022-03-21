package com.example.test;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserList {
    private List<Users> users;

    @Getter
    @Setter
    @ToString
    public static class Users {
        private Integer userId;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String emailAddress;
        private String homepage;
    }
}
