package com.study.springboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springboot.bean.Config;
import com.study.springboot.bean.Member;
import com.study.springboot.bean.Printer;

//@SpringBootApplication
public class Ex02JavaCodeDiApplication {

	public static void main(String[] args) {
//		SpringApplication.run(Ex02JavaCodeDiApplication.class, args);
		
		// 1. IoC 컨테이너 생성
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		// 2. Member Bean 가져오기
		// 스프링 컨테이너로부터 빈을 리턴받아 형변환하여 사용하고있음.
		Member member1 = (Member) context.getBean("member1");
		member1.print();

		// 3. Member Bean 가져오기
		// 미리 형을 지정하여 빈을 리턴하는 방법.
		Member member2 = context.getBean("hello", Member.class);
		member2.print();
		
		// 4. PringerB bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);
		member1.setPrinter(printer);
		member1.print();
		
		// 5. 싱글톤인지 확인
		// 같은 클래스 타입의 변수지만 서로 다른 메소드에서 각각 new를 통해 생성되었으므로
		// 서로 다른 객체임을 확인할 수있음
		if(member1 == member2) {
			System.out.println("동일한 객체입니다.");
		}else {
			System.out.println("서로 다른 객체입니다.");
		}
		
	}

}
