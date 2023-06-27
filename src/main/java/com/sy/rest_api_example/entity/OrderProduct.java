package com.sy.rest_api_example.entity;

import com.sy.rest_api_example.enums.OrderStatus;
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
@Table(name = "order_product")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_pid")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_pid")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_pid", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "way_bill_num")
    private String wayBillNum;

    @Column
    private int quantity;

    @Column(name = "total_price")
    private int totalPrice;
}