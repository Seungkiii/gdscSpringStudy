package com.example.springbasic.Board;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;


@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "is_deleted is null")
@Table(name = "boards")
public class Board extends BaseTimeEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNumber;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "views", nullable = false)
    private int views;

    @Column(name = "category", length = 50)
    private String category;


    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public void softDelete() {
        this.isDeleted = true;
    }


    public void update(String title, int views, String category, Long memberId) {
        this.title = title;
        this.views = views;
        this.category = category;
        this.memberId = memberId;
    }

}
