package com.jojoldu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // 별다른 설정 없이 SpringBootTest만 사용할 경우 H2데이터베이스를 자동으로 사용합니다. H2:메모리에서 실행되기 때문에 재시작할때마다 초기화 되는 DB이므로 테스트용으로 많이 사용.
public class PostsRepositoryTest {
    // save, findAll 기능을 테스트

    @Autowired
    PostsRepository postsRepository;

    @After  // Junit에서 단위테스트가 끝날때마다 자동 수행되는 메소드. (초기화)
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()    // 내가 만든 PostsRepository에 save()메소드는 안만들었는데 사용이 가능. PostsRepository(인터페이스)에 extends JpaRepository<Posts, Long>를 상속받았기 때문에 save()메소드를 사용할수 있다.
                .title(title)
                .content(content)
                .author("sonlcr1@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);      // .getTitle(), getContent()는 Posts클래스의 @Getter 어노테이션으로 자동 생성.
        assertThat(posts.getContent()).isEqualTo(content);
    }

    // Jpa Auditing 테스트 코드 작성하기.
    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
