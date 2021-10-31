package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController // java에서 어노테이션은 주석 말고도 일종의 메타데이터의 기능도 수행한다.
// @RestController를 ctrl 왼쪽 클릭으로 들어가보면 , @Controller > @Component의 어노테이션을 가지고 있다. (@Component는 Bean을 등록하는 어노테이션)
// Spring IoC 컨테이너가 관리하는 자바 객체를 빈(Bean). Ioc(제어의역전 Inversion Of Control) : 사용자의 제어권을 다른 주체에게 넘기는 것을 IOC(제어의 역전) 라고 합니다. 객체를 사용자가 생성해서 사용하는것이 아니고 제어권을 다른 주체에 넘겼기 때문에 그 주체가 객체를 생성및 사용 한다.
// Spring에 의해 생성되고 관리되는 객체를 Bean이라고 한다.
public class PostsApiController {
    // http method 종류
    // 1. GET : 정보를 요청하기 위해 사용(Read)
    // 2. POST : 정보를 입력하기위해 사용 (Create)
    // 3. PUT : 정보를 업데이트하기위해 사용(Update)
    // 4. DELETE : 정보를 삭제하기 위해 사용(Delete)

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")       // @PutMapping과 아래의 @GetMapping이 주소가 같다. 둘다 실행된다? 업데이트되면서 동시에 id를 리턴 받는다?
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}
