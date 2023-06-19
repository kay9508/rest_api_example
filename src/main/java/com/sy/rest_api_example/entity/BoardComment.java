package com.sy.rest_api_example.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "board_comment")
public class BoardComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_comment_pid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_pid")
    private Member member;

    @Column(length = 5000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_pid")
    private Board board;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "comment")
    private List<BoardReComment> boardReComments = new ArrayList<>();

    @Column(name = "del_at")
    @Type(type="yes_no")
    private Boolean delAt = false;


    public void delete() {
        this.delAt = true;
    }

}