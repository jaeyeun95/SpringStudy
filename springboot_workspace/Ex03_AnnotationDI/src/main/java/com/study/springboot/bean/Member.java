package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Member {
	// 빈이 생성될때 각각 변수에 기본값으로 () 안에 값을 지정한다.
	@Value("홍길동")
	private String name;
	@Value("도사")
	private String nickname;
	@Autowired
	@Qualifier("printerA")
	private Printer printer;
	
	public Member() {}

	public Member(String name, String nickname, Printer printer) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void print() {
		printer.print("Hello " + name + " : " +nickname);
	}
	
	
}
