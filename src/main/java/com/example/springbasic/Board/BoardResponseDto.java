package com.example.springbasic.Board;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {

    private Long postNumber;
    private String title;
    private int views;
    private String category;
    private Long memberId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BoardResponseDto(Board board) {
        this.createdAt = board.getCreatedAt();
        this.updatedAt = board.getUpdatedAt();
        this.postNumber = board.getPostNumber();
        this.title = board.getTitle();
        this.views = board.getViews();
        this.category = board.getCategory();
        this.memberId = board.getMemberId();
    }

}
