package com.example.springbasic.Comment;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentMapper {

    public Comment toEntity(CommentCreateRequestDto request) {
        return Comment.builder()
                .commentTitle(request.getCommentTitle())
                .commentContent(request.getCommentContent())
                .build();
    }

    public CommentResponseDto toResponse(Comment comment) {
        return CommentResponseDto.builder()
                .commentCode(comment.getCommentCode())
                .commentContent(comment.getCommentContent())
                .commentTitle(comment.getCommentTitle())
                .build();
    }

    public ComemntListResponse toListResponse(List<Comment> commentList) {
        List<CommentResponseDto> commentResponseDtoList =
                commentList.stream().map(this::toResponse).collect(Collectors.toList());
        return ComemntListResponse.builder()
                .commentList(commentResponseDtoList)
                .build();
    }

    public CommentUpdateRequestDto toUpdateRequestDto(Comment comment) {
        return CommentUpdateRequestDto.builder()
                .commentCode(comment.getCommentCode())
                .commentTitle(comment.getCommentTitle())
                .commentTitle(comment.getCommentTitle())
                .build();
    }
}
