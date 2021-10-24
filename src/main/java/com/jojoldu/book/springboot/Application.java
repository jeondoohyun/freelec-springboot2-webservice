package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //Jpa Auditing 활성화
@SpringBootApplication  //@SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 상단에 있어야함.
public class Application {
    public static void main(String[] args) {    // class Application의 main은 이 프로젝트의 메인
        SpringApplication.run(Application.class, args);
        // .run으로 인해 내장 was(web application server)를 실행. 내장was : 외부에 was를 두지 않고 앱이 실행할때 내부에서 was를 실행하는것.
        // 이렇게 되면 항상 서버에 톰캣을 설치할 필요가 없게 되고, 스프링 부트로 만들어진 jar파일(실행 가능한 java패키징)로 실행하면 된다.
        // 외장 was를 쓴다면 모든 서버는 was의 종류와 버전, 설정을 동일하게 맞춰야 하는 번거로움이 있지만 내장was를 쓰면 그런 단점을 해결할수 있다.

    }
}
