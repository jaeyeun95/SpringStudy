package com.study.sonjava.configuration;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalConfig {

    @Autowired
    private org.springframework.context.ApplicationContext context;

    @Autowired
    private ResourceLoader resourceLoader;
    private String SchedulerCronExample1;

    private String uploadFilePath;

    private boolean local;
    private boolean dev;
    private boolean prod;

    @PostConstruct
    public void init(){
        log.info("init");
        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        String activeProfile = "local";
        if (ObjectUtils.isNotEmpty(activeProfiles)){
            activeProfile = activeProfiles[0];
        }
        String resourcePath = String.format("classpath:globals/global-%s.properties", activeProfile);
        try {
            Resource resource = resourceLoader.getResource(resourcePath);
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);

            this.uploadFilePath = properties.getProperty("uploadFile.path");
            this.SchedulerCronExample1 = properties.getProperty("schduler.cron.exmple1");
            this.local = activeProfile.equals("local");
            this.dev = activeProfile.equals("dev");
            this.prod = activeProfile.equals("prod");

        } catch (Exception e) {
            log.error("e", e);
        }
    }

    public String getUploadFilePath(){
        return uploadFilePath;
    }
    public String getSchedulerCronExample1(){
        return SchedulerCronExample1;
    }

    public boolean isLocal(){
        return local;
    }
    public boolean isDev(){
        return dev;
    }
    public boolean isProd(){
        return prod;
    }
}
