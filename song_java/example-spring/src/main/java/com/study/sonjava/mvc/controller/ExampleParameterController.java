package com.study.sonjava.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/example/parameter")
@Slf4j
public class ExampleParameterController {

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }
    /*
        requestparam 으로 받기
    */
    @GetMapping("/example1")
    public void example(@RequestParam String id, @RequestParam String code, Model model){
        // @RequestParam("id") String id -> 이렇게 할수도 있음. 단 form 안에 input name 과 같아야 함
        model.addAttribute("id", id);
        model.addAttribute("code", code);
    }
    /*
        Map을 사용해서 파라미터 받기
    */
    @GetMapping("/example2")
    public void example2(@RequestParam Map<String, Object> paramMap, Model model){
        model.addAttribute("paramMap", paramMap);
    }
    /*
        Class로 받기
        Class 로 받는 경우에는 @RequestParam 이 없어야 한다.
        @RequestBody로는 안된다. get방식에는 안되는 듯 싶다.
    */
    @GetMapping("/example3")
    public void example3(ExampleParameter parameter, Model model){
        model.addAttribute("parameter", parameter);
    }
    
    /*
        PathVariable 로 받기
    */
    @GetMapping("/example4/{id}/{code}")
    public String example4(@PathVariable String id,@PathVariable String code, Model model){
        model.addAttribute("id", id);
        model.addAttribute("code", code);
        return "/example/parameter/example4";
    }
    
    /*
        String[] 배열로 받기
        url : ↓
        http://localhost:9000/example/parameter/example5?ids=12&ids=23
    */
    @GetMapping("/example5")
    public String example5(@RequestParam String[] ids, Model model){
    // public String example5(HttpServletRequest request, Model model){
    //     model.addAttribute("ids", request.getParameter("ids"));
        model.addAttribute("ids", ids);
        return "/example/parameter/example5";
    }

    /*
        ajax 사용시 
        json 받는 경우
    */
    @GetMapping("/example6/form")
    public void form(){
    }
    /*
        ajax 사용시 
        json 받는 경우
    */
    @PostMapping("/example6/saveData")
    @ResponseBody
    public Map<String, Object> example6(@RequestBody ExampleUser requestBody){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("requestBody", requestBody);
        resultMap.put("result", true);
        log.info("requestBody : {}", requestBody);
        return resultMap;
    }
    // public Map<String, Object> example6(@RequestBody Map<String, Object> requestBody){
    //     Map<String, Object> resultMap = new HashMap<>();
    //     resultMap.put("requestBody", requestBody);
    //     resultMap.put("result", true);
    //     log.info("requestBody : {}", requestBody);
    //     return resultMap;
    // }
}
