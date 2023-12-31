package com.example.springbasic.Comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<Long> createComment(@RequestBody CommentCreateRequestDto request) {
        Long commentCode = commentService.createComment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentCode);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(@RequestBody CommentUpdateRequestDto request, @PathVariable Long id) {
        CommentResponseDto updatedComment = commentService.updateComment(request,id);
        return ResponseEntity.ok(updatedComment);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CommentResponseDto>> getAllComments() {
        List<CommentResponseDto> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CommentResponseDto> getComment(@PathVariable Long id) {
        CommentResponseDto comment = commentService.getComment(id);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
