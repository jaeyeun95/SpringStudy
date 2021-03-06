package com.study.ex12_valid_annotation;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Validator (4)";
	}

	@RequestMapping("/insertForm")
	public String insert1(){
		return "createPage";
	}

	@RequestMapping("/create")
	public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto, BindingResult result){
		String page = "createDonePage";
		// System.out.println(contentDto);

		if (result.hasErrors()){
			System.out.println("getAllErrors : " + result.getAllErrors());

			if(result.getFieldError("writer") != null){
				System.out.println("1:" + result.getFieldError("writer").getDefaultMessage());
			}

			if(result.getFieldError("content") != null){
				System.out.println("2:" + result.getFieldError("content").getDefaultMessage());
			}
			page = "createPage";
		}

		return page;

	}


}
