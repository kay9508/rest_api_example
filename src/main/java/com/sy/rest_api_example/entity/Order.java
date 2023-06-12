package com.sy.rest_api_example.entity;

import com.sy.rest_api_example.enums.PayType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_pid")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
    private Delivery delivery;

    /*@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
    private OrderPaymentInformation paymentInfo;*/

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "order")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private PayType payType;

    @ColumnDefault("0")
    private int totalPrice;

    @Column(name = "order_num", nullable = false)
    private String orderNum;

    @Column(name = "del_at")
    @Type(type="yes_no")
    private Boolean delAt = false;
}
