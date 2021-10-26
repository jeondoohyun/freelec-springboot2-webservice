package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
        //when
        String body = this.restTemplate.getForObject("/",String.class);

        // 실제로 URL호출시 페이지의 내용이 제대로 호출되는지 테스트.
        // index.mustache에 포함된 코드들이 있는지 확인(문자열 "스프링 부트로 시작하는 웹 서비스"가 포함되어 있는지 확인)
        //then
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}
