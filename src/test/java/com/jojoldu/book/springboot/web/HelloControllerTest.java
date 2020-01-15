package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class) // 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킵니다. (여기서는 SpringRunner라는 스프링 실행자를 실행)
@WebMvcTest // 스프링 테스트 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션.
public class HelloControllerTest{
    @Autowired // 스프링 컨테이너에서 만들어지는 객체 = 스프링 빈(bean). Autowired는 이 bean을 주입 받는다.
    private MockMvc mvc; // 웹 API를 테스트할 때 사용, 스프링 MVC 테스트의 시작점.

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다.
                .andExpect(status().isOk()) // 200, 404, 500 상태를 검증합니다. 여기선 Ok() 즉, 200인지 검증.
                .andExpect(content().string(hello)); // 응답 본문 내용을 검증합니다. Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{ // api
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
