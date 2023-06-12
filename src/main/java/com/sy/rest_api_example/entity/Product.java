package com.sy.rest_api_example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_pid")
    private Long id;

    @Column(name = "productName", length = 100)
    private String productName;

    @Column(length = 20)
    private String category;

    @ColumnDefault("0")
    private Integer price;

    @Column(length = 10, name = "sale_status")
    private String saleStatus;

    @Column
    private String imageUrl;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
    private List<ProductImage> productImageList = new ArrayList<>();

    /*@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
    private List<ProductQnA> productQnAList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
    private List<ProductQnAReply> productQnAReplyList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
    private List<Review> reviewList = new ArrayList<>();*/

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }
}