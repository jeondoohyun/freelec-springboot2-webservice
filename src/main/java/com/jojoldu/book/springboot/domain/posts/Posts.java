package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 각 필드 데이터 값에 대해 get 메소드를 자동 생성.
@NoArgsConstructor  // No라고 해서 생성자 안만드는 건지 알았는데 기본생성자 자동추가 하는 어노테이션임.
@Entity // db테이블과 매핑됨(spring data jpa어노테이션, 중요), Entity클래스에서는 setter를 생성하지 않는다. 목적과 의도를 알수 있는 메소드를 생성하여 setter대신 사용한다.
public class Posts extends BaseTimeEntity { // BaseTimeEntity는 등록 및 수정할때의 시간 데이터를 자동으로 저장해주는 entity클래스

    @Id // pk, Entity의 PK는 Long타입을 권장.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id값은 자동으로 만들어지나?
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

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
