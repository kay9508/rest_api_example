package com.sy.rest_api_example.entity;

import com.sy.rest_api_example.enums.DeliveryStatus;
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
@Table(name = "delivery")
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_pid")
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_pid")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "delivery")
    private DeliveryAddress deliveryAddress;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

}
