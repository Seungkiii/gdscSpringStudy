package com.example.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing // 이거 넣어줘야 @EntityListeners가 돌아감
public class SpringbasicApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbasicApplication.class, args);
	}

}




// onetomany 필요시에만 쓰고 웬만하면 쓰지말자/ 패키지 구조는 도메인형 추천 / lombok을 쓰면 케터 세터 할때 자동으로 메소드 만들어줌\ validation은 데이터검증하는거 유용한 어노테이션이 있다
// api 설계할때 기본적인 순서: requestdto로 어떤 값처리할지 정함/ response / repository / service/ controller
// 단일체계원칙을 한번 알아보자
//soft delete를 jpa에 맞게 수정해보자 어노테이션같은거로(@where) boolean은 디폴트가 펄스임 Boolean이랑 살짝 다르다 알아보자
// 코어분 코드를 한번 보자/ 추상클래스로 @CreateDate써서 구현해보자
//과제 피드백: 시간을 입력받는것이 아니라 알아서 시간이 찍히게하자 로컬데이터타임 @오토아우덜라이즈, autowired는 옛날꺼다 생성자 주입 패턴으로 하자,