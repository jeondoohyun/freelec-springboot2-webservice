package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // 모든 entity들의 상위클래스가 됨. entity클래스는 이 클래스를 통해 무조건 시간 정보가 자동으로 입력됨. createdDate, modifiedDate를 자동으로 관리 한다.
@EntityListeners(AuditingEntityListener.class)  //BaseTimeEntity클래스에 Auditing(감시)기능을 포함시킨다. 감시 하여 시간 저장을 자동으로 한다고 이해하자.
public class BaseTimeEntity {

    @CreatedDate    // Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate   // 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;

}
