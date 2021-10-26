package com.jojoldu.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
        // 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할때 앞의 경로(src/main/resources/templates)와
        // 뒤의 확장자(.mustache)가 자동으로 지정된다. 즉 src/main/resources/templates/index.mustache로 반환되어 View Resolver가 처리 한다.
    }
}
