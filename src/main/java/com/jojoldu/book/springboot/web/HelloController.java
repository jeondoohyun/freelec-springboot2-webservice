package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     // 컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어준다.
public class HelloController {

    @GetMapping("/hello")   // url /hello로 요청이 오면 문자열 "hello"를 반환.
    public String hello() {
        return "hello";
    }
}
