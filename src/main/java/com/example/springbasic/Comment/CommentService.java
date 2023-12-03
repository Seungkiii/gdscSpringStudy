package com.example.springbasic.Comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Transactional
    public Long createComment(CommentCreateRequestDto request) {
        Comment comment = commentRepository.save(commentMapper.toEntity(request));
        return comment.getCommentCode();
    }

    @Transactional
    public CommentResponse updateComment(CommentUpdateRequestDto request, Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(IllegalStateException::new);

        comment.update(request.getCommentTitle(), request.getCommentContent());
        return commentMapper.toResponse(comment);
    }


    public List<CommentResponse> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(commentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CommentResponse getComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(IllegalStateException::new);
        return commentMapper.toResponse(comment);
    }

    @Transactional
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(IllegalStateException::new);
        comment.softDelete();
    }
}
