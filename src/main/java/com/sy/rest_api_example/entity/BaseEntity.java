package com.sy.rest_api_example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    /*@Column(name = "cre_ps_id", length = 50)
    private String crePsId;*/

    @Column(name = "cre_ps_pid")
    private Long crePsPid;

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_pid")
    private Member createMember;*/



    @CreatedDate
    @Column(name = "cre_dtm")
    private LocalDateTime creDtm;



    /*@Column(name = "mod_ps_id", length = 50)
    private String modPsId;*/

    @Column(name = "mod_ps_pid")
    private Long modPsPid;

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_pid")
    private Member lastModifyMember;*/

    @LastModifiedDate
    @Column(name = "mod_dtm")
    private LocalDateTime modDtm;

}
