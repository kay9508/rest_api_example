package com.sy.rest_api_example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_pid")
    private Long id;

    @Column(length = 100, name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<MemberRole> memberRoles;
}
