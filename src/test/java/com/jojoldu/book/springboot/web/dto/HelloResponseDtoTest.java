package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        // HelloResponseDto 클래스에 만든 롬복 .getName(), getAmount()가 제대로 작동하는지 테스트 하는 것.
        assertThat(dto.getName()).isEqualTo(name);  // dto.getName()로 "test"가 불러져 오는지 확인, name("test"가들어가있다)과 같은지 확인. 생성자 자동 생성됫는지 확인.
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
