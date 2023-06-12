package com.sy.rest_api_example.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "board")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_pid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_pid")
    private Member member;

    @Column(length = 100)
    private String title;

    @Column(length = 10000)
    private String content;

    @Column(name = "del_at")
    @Type(type="yes_no")
    private Boolean delAt = false;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    List<BoardComment> boardComments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "board")
    private List<BoardReComment> boardReCommentList = new ArrayList<>();

    public void delete() {
        this.delAt = true;
    }
}
