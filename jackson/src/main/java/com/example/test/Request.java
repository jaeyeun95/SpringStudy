package com.example.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Request {
    private List<Sample> bundle;

    @Getter
    @Setter
    @ToString
    public static class Sample {
        @JsonProperty("product_name")
        private String product;
        @JsonProperty("order_number")
        private String order;
        @JsonProperty("age")
        private Integer age;

        @JsonProperty("users")
        private List<Samples> samples;

        @Getter
        @Setter
        @ToString
        public static class Samples {
            @JsonProperty("name")
            private String buyerName;
            @JsonProperty("phone")
            private String phoneNumber;
        }
    }
}
