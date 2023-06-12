package com.sy.rest_api_example.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "board_re_comment")
public class BoardReComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_re_comment_pid")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_pid")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "member_pid")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_pid")
    private BoardComment comment;

    @Column(length = 5000)
    private String content;

    @Column(name = "del_at")
    @Type(type="yes_no")
    private Boolean delAt = false;


    public void delete() {
        this.delAt = true;
    }
}