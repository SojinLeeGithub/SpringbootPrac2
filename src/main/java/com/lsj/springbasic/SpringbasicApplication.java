package com.lsj.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lsj.springbasic.dto.Lombok;

@SpringBootApplication
public class SpringbasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbasicApplication.class, args);
	}

	void lombokExample() {

		Lombok lombok = new Lombok("a", "b", "c", false, false);
		lombok.getField1();
		lombok.setField3(null);

		// lombok = new Lombok();
		lombok = new Lombok("d", "e");

		lombok.isField4();

		// 참조형 Boolean일 경우 getter 메서드 이름은 getXXX()
		// null을 받을 수 있기 때문에 get으로 표현한다.
		lombok.getField5();
	
	}

}
