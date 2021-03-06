package com.example.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class User {

    @JsonProperty("product_name")
    private String product;
    @JsonProperty("order_number")
    private String order;
    @JsonProperty("age")
    private Integer age;

    private List<Users> users;

    @Getter
    @Setter
    @ToString
//    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Users {
        @JsonProperty("name")
        private String buyerName;
        @JsonProperty("phone")
        private String phoneNumber;
    }

}
