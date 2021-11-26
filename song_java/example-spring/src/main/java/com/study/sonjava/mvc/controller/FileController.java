package com.study.sonjava.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import com.study.sonjava.configuration.GlobalConfig;
import com.study.sonjava.configuration.exception.BaseException;
import com.study.sonjava.configuration.http.BaseResponse;
import com.study.sonjava.configuration.http.BaseResponseCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {


    @Autowired
    private GlobalConfig config;

    // @RequestMapping("/main")
    // public String mainPage(){
    //     return "index";
    // }

    /**
     * 업로드 리턴
     */
    @PostMapping("/save")
    public BaseResponse<Boolean> save(@RequestParam("uploadFile") MultipartFile multipartFile ){
        // log.debug("config : {} ", config);
        log.debug("multipartFile : {} ", multipartFile);
        if (multipartFile == null || multipartFile.isEmpty()){
            throw new BaseException(BaseResponseCode.DATA_IS_NULL);
        }
        String uploadFilePath = config.getUploadFilePath();
        log.debug("uploadFilePath : {}", uploadFilePath);
        if (config.isProd()){
            log.debug("isProd calendar : {}", Calendar.getInstance());
        }
        String prefix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."), multipartFile.getOriginalFilename().length());
        String filename = UUID.randomUUID().toString() + "." + prefix;
        String pathname = uploadFilePath + filename;
        File dest = new File(pathname);

        try {
            multipartFile.transferTo(dest);
        } catch (IllegalStateException | IOException e) {
            log.error("e", e);
        }
        
        return new BaseResponse<Boolean>(true);
    }
    
}
