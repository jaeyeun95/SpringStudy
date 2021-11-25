package com.example.member.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audio")
public class AudioController {

    @RequestMapping("/download")
    public void getAudioFile(){
        System.out.println("#################### 오디오파일 가져오기");
    }
    
}
