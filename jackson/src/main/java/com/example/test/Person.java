package com.example.test;

import lombok.*;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Person {

    private String name;
    private Integer age;
    
    public void makePerson(){
        Person person = new Person();
        person.setAge(20);
        person.setName("홍길동");
    }

}
