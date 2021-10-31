package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// @RequiredArgsConstructor 롬복의 생성자 자동 생성.롬복의 장점 : 클래스의 의존성 관계가 변경될 때 마다 생성자 코드를 계속해서 수정하는 번거로움을 해결해준다.
// 스프링에선 Bean을 주입받는 방식은 3가지.(1. @Autowired, 2.setter, 3.생성자). 권장 하는 방식은 생성자 방식이다. @RequiredArgsConstructor가 빈을 주입 받는다.
@RequiredArgsConstructor
@Service
public class PostsService {     // Service에서는 트랜잭션, 도메인간 순서 보장의 역할만 한다. 트랜잭션 : 추가, 삭제, 갱신등의 정보를 가져오는것.
    private final PostsRepository postsRepository;  // Service에서 Repository를 이용한다. Service에서 비즈니스 로직이 동작 되진 않는다. Service에서 다른 클래스의 비즈니스로직을 가져다 쓰는것.

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();     // .save()는 Repository에 자동으로 만들어주는 메소드(sql), PostsRepository(인터페이스)에 extends JpaRepository<Posts, Long>를 상속받았기 때문에 save()메소드를 사용할수 있다.
        // .getId()는 Posts에 내가 만든 필드 값들을 롬복이 자동으로 getter들을 생성해준 메소드 이다.
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());   // 더티 체킹 : Repository 인터페이스로 update쿼리를 실행하지 않고 Entity 객체의 값만 변경해도 영속성 컨텍스트이기 때문에 해당 테이블에 변경분을 반영한다. 즉 update쿼리를 날릴 필요가 없다.
        // 위의 posts.update()메소드를 확인 해보면 sql 기능을 하는 메소드가 아니라 데이터만 대입하는 메소드임을 확인 할수 있음.
        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
