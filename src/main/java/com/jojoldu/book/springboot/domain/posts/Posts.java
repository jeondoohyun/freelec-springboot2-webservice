package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // db테이블과 매핑됨(spring data jpa어노테이션, 중요), Entity클래스에서는 setter를 생성하지 않는다. 목적과 의도를 알수 있는 메소드를 생성하여 setter대신 사용한다.
public class Posts {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 생성자 대신 builder로 데이터 값을 설정해야 파라미터를 헷갈리지 않고 대입할수 있음.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
