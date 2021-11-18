package com.study.springboot.bean;

import org.springframework.stereotype.Component;

// 다음에 나오는 PrinterA 라는 클래스를 빈으로 등록하겠다는 의미, 이름도 printerA로 지정
@Component("printerA")
public class PrinterA implements Printer{

	@Override
	public void print(String message) {
		
		System.out.println("Printer A : " + message);
	}

}
