package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter     // 선언된 모든 필드의 getter 메소드를 자동으로 생성.
@RequiredArgsConstructor    // 선언된 모든 final 필드가 포함된 생성자를 생성해 준다. final이 없는 필드는 생성자에 포함되지 않음.
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
