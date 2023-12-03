package com.example.springbasic.Comment;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ComemntListResponse {
    private List<CommentResponseDto> commentList;
}
