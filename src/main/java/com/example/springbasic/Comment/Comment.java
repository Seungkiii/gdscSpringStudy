package com.example.springbasic.Comment;

import com.example.springbasic.Member.Member;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentCode;

    @Column(name = "comment_content", nullable = false, columnDefinition = "TEXT")
    private String commentContent;

    @CreatedDate
    @Column(name = "comment_time", nullable = false, updatable = false)
    private LocalDateTime commentTime;

    @LastModifiedDate
    @Column(name = "comment_update_time", nullable = false)
    private LocalDateTime commentUpdateTime;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // 생성자, Getter, Setter, 기타 메서드들...

}


