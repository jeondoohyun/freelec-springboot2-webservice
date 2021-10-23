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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)    // @RunWith은 스프링부트 테스트와 JUnit사이에 연결자 역할을 한다.
@WebMvcTest(controllers = HelloController.class)    // Service, Component, Repository테스트에는 사용할수 없음. Web에 집중할 수 있는 어노테이션. 여기서는 컨트롤러만 사용하기 때문에 사용가능.
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
    
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";  // 1.
        int amount = 1000;
        
        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))    // param() 요청 파라미터를 임시 지정.name에는 hello가 들어가고 amount에는 1000이 들어감. string값만 사용이 가능하기 때문에 숫자를 string으로 변경해줘야함.
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))    // jsonPath는 json의 응답값을 필드별로 검증 할수 있다. json의 필드 name에 들어가 있는게 1.의 name과 같은지 확인.
                .andExpect(jsonPath("$.amount",is(amount)));
                
    }
}
