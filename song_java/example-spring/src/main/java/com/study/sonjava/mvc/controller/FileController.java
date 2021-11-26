package com.study.sonjava.mvc.controller;

import com.study.sonjava.configuration.GlobalConfig;
import com.study.sonjava.configuration.http.BaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {


    @Autowired
    private GlobalConfig config;

    /**
     * 업로드 리턴
     */
    @GetMapping
    public BaseResponse<Boolean> save(){
        log.debug("config : {} ", config);
        String uploadFilePath = config.getUploadFilePath();
        log.debug("uploadFilePath : {}", uploadFilePath);
        return new BaseResponse<Boolean>(true);
    }
    
}
