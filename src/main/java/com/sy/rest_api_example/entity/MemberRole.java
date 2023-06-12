package com.sy.rest_api_example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member_role")
public class MemberRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_role_pid")
    private Long id;

    @ManyToOne // 기본 FetchType EAGER
    @JoinColumn(name = "member_pid")
    private Member member;

    @ManyToOne // 기본 FetchType EAGER
    @JoinColumn(name = "role_pid")
    private Role role;
}
