package com.example.springbasic.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentResponseDto {

    private Long commentCode;

    private String commentContent;

    private String commentTitle;

}
