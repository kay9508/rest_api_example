package com.sy.rest_api_example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "delivery_address")
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_address_pid")
    private Long id;

    @OneToOne
    @JoinColumn(name = "delivery_pid")
    private Delivery delivery;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone_num")
    private String customerPhoneNum;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "recipient_phone_num")
    private String recipientPhoneNum;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "address")
    private String address;

    @Column(name = "detail_address")
    private String detailAddress;

}
