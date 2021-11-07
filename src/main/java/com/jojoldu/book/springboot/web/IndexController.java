package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    // 페이지에 관련된 컨트롤러

    private final PostsService postsService;

//    @GetMapping("/")
//    public String index() {
//        return "index";
//        // 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할때 앞의 경로(src/main/resources/templates)와
//        // 뒤의 확장자(.mustache)가 자동으로 지정된다. 즉 src/main/resources/templates/index.mustache로 반환되어 View Resolver가 처리 한다.
//    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";    // https .. /posts/save를 호출 하면 posts-save.mustache를 호출 한다.(반환한다.)
    }

    @GetMapping("/")
    public String index(Model model) {  // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할수 있다. postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달.
        // model은 HashMap형태를 갖고 있으므로 key값과 value값처럼 사용할 수 있다. addAttribute는 Map의 put과 같은 기능이여서 속성과 그것에 대한 값을 주어 전달할 뷰 데이터를 put 한다.
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

//    @GetMapping("/")
//    public String index2(Model model) {  // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할수 있다. postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달.
//        // model은 HashMap형태를 갖고 있으므로 key값과 value값처럼 사용할 수 있다. addAttribute는 Map의 put과 같은 기능이여서 속성과 그것에 대한 값을 주어 전달할 뷰 데이터를 put 한다.
//        model.addAttribute("posts", postsService.findAllDesc());
//        return "index2";
//    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("postss", dto);

        return "posts-update";
    }
}
