package com.example.springbasic.Comment;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentUpdateRequestDto {
    private Long commentCode;
    private String commentTitle;
    private  String commentContent;

    @Builder
    public CommentUpdateRequestDto(Long commentCode, String commentTitle, String commentContent) {
        this.commentCode = commentCode;
        this.commentTitle = commentTitle;
        this.commentContent = commentContent;
    }
}
