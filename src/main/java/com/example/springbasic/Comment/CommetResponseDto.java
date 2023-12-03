package com.example.springbasic.Comment;

import com.example.springbasic.Member.Member;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class CommetResponseDto {

    private Long commentCode;
    private String commentTitle;
    private String commentContent;
    private Member member;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommetResponseDto(Comment comment){
        this.commentCode = comment.getCommentCode();
        this.commentContent = comment.getCommentContent();
        this.commentTitle = comment.getCommentTitle();
        this.member = comment.getMember();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }
}
