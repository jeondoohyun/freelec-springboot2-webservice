package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // jpa : Java Persistence API, jsp : java server page
    // Posts클래스로 Database에 접근하게 해줄 JpaRepository(Dao), JpaRepository<클래스명, PK자료형>, 클래스명도 결국 Posts라는 자료형(클래스), ex)ArrayList, String들도 클래스면서 자료형.
    // extends JpaRepository<Posts, Long>  JpaRepository를 상속 하면 기본적인 CRUD 메소드가 자동으로 생성된다.
    // Entity클래스(Posts)와 기본 Entity Repository(interface PostsRepository)는 같은 위치에 있어야한다. 둘은 아주 밀접한 관계이고, Entity클래스는 기본 Repository없이는 제대로 역할을 할수가 없다.

    @Query("select p from Posts p order by p.id desc")  // desc:내림차순, asc:오름차순
    // 위의 쿼리로 작성해도 되는 것을 보여주고자 @Query를 사용했음. @Query를 사용하면 가독성이 좋음.
    // 사실 SpringDataJpa에서 제공 하는 기본 메소드만으로 해결이 가능한것임. ex) save(), findAll()
    List<Posts> findAllDesc();
}
