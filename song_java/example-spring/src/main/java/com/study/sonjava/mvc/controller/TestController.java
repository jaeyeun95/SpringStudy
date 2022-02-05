package com.study.sonjava.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {

    @RequestMapping("/page")
    public String toPage() {
        return "page";
    }

    @RequestMapping("/page2")
    public String toPage2() {
        return "page2";
    }

    @RequestMapping("/clubCreate")
    public String fileUpload(@RequestParam("upfile") MultipartFile file) {
        System.out.println("파일 업로드" + file);
        return "page2";
    }

}
