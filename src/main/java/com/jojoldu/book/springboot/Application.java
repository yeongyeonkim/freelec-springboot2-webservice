package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정.
특히 이 어노테이션 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야 한다.
*/
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); //run으로 내장 WAS(웹 애플리케이션 서버)를 실행한다.
        //내장 WAS를 사용해야 '언제 어디서나 같은 환경에서 스프링 부트를 배포'할 수 있다.
    }
}
