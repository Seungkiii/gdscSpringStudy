package com.example.springbasic.Comment;

import com.example.springbasic.Member.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateRequestDto {
    private String commentTitle;
    private String commentContent;
}
