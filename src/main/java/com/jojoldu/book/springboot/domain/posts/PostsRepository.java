package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // Posts클래스로 Database에 접근하게 해줄 JpaRepository(Dao), JpaRepository<클래스명, PK자료형>
    // extends JpaRepository<Posts, Long>  JpaRepository를 상속 하면 기본적인 CRUD 메소드가 자동으로 생성된다.
    // Entity클래스(Posts)와 기본 Entity Repository(interface PostsRepository)는 같은 위치에 있어야한다. 둘은 아주 밀접한 관계이고, Entity클래스는 기본 Repository없이는 제대로 역할을 할수가 없다.

}
