package com.example.springbasic.Board;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
public class BoardRequestDto {

    private String title;
    private int views;
    private String category;
    private Boolean isDeleted;
    private Long memberId;


    public Board toEntity() {
        return Board.builder()
                .title(title)
                .views(views)
                .category(category)
                .isDeleted(isDeleted)
                .memberId(memberId)

                .build();
    }

}
