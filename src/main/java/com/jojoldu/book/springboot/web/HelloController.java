package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController     // 컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어준다.
public class HelloController {

    @GetMapping("/hello")   // url /hello로 요청이 오면 문자열 "hello"를 반환.
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {   // @RequestParam은 외부에서 API로 받은 파라미터를 가져오는 어노테이션.
        return new HelloResponseDto(name, amount);
    }
}
