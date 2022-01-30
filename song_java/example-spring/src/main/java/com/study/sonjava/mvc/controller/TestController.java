package com.study.sonjava.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/page")
    public String toPage() {
        return "page";
    }

}
