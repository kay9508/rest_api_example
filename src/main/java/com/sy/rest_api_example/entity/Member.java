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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_pid")
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(length = 100)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "member", fetch = FetchType.EAGER)
    private List<MemberRole> roles = new ArrayList<>();

    @Column(length = 11)
    private String phoneNum;

    @Column(length = 11)
    private String name;

    @Column(length = 6, nullable = false)
    private String zipcode;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 100, name = "detail_address")
    private String detailAddress;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "member")
    private Cart cart;

    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "member")
    private List<ProductQnA> qnaList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "member")
    private List<ProductQnAReply> qnaReplyList = new ArrayList<>();*/

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "member")
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "member")
    private List<BoardComment> boardCommentList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "member")
    private List<BoardReComment> boardReCommentList = new ArrayList<>();

    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "member")
    private Set<Review> reviewList = new HashSet<>();*/

    @Column(name = "del_at")
    @Type(type="yes_no")
    private Boolean delAt = false;
}
