package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)    // @RunWith은 스프링부트 테스트와 JUnit사이에 연결자 역할을 한다.
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired  // 스프링이 관리 하는 빈(Bean)을 주입받는다.
    private MockMvc mvc;    // MockMvc 클래스를 통해 HTTP GET,POST,등에 대한 API테스트를 할수 있다.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  // /hello 주소로 HTTP GET 요청을 한다.
                .andExpect(status().isOk())     // 상태 검증
                .andExpect(content().string(hello));    // 내용검증

        // Test코드를 run했을때 Tests passed가 뜨면 .andExpect로 실행한 status().isOk()와 content().string(hello)의 테스트가 성공했다는 뜻이다.
    }
}
