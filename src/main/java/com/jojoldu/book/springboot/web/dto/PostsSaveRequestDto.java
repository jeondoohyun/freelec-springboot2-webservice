package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor  // 기본생성자 생성.
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    // 이 클래스는 Entity클래스와 비슷한 형태임에도 굳이 새로 추가한 이유는 Entity클래스를 View를 위한 Request/Response 클래스로 사용해선 안되기 때문에 새로 추가함.
    // View의 변경은 빈번하게 발생하는데 그 작업을 Entity클래스를 사용하면 Entity와 연결되어있는 수많은 클래스에도 영향을 끼치게됨.
    // View Layer와 DB Layer의 역할 분리를 철저하게 하는게 좋습니다. Entity클래스와 Controller에 쓸 Dto는 분리해서 사용해야한다.

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
