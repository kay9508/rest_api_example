package com.sy.rest_api_example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_pid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_pid")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_pid")
    private Product product;

    @ColumnDefault("0")
    private Integer quantity;

    @Column
    private int totalPrice;

}