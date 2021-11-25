package com.example.member.controller;

import java.util.List;
import java.util.Map;

import com.example.member.service.MemberService;
import com.example.member.vo.MemberVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService mService;

    @RequestMapping("/")
    public String root(){
        return "root";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestBody MemberVo vo){
        System.out.println("/test 들어왔음");
        return vo.getNickname();
    }

    // @RequestMapping("/insert")
    // public MemberVo insertMember(@RequestBody MemberVo vo) throws Exception{
    //     return mService.insertMember(vo);
    // }
    @RequestMapping("/insert")
    public Map<String, Object> insertMember(@RequestBody MemberVo vo) throws Exception{
        System.out.println("### CON ");
        Map<String, Object> map = mService.insertMember(vo);
        return map;
    }

    @RequestMapping("/list")
    public List<MemberVo> getList(){
        return mService.getlist();
    }
    
}
