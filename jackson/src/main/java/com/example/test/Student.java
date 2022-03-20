package com.example.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private Integer age;
    private List<Phone> phoneNumbers;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class Phone{
        private String type;
        private String phoneNumber;
    }

}
