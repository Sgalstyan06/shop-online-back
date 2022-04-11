package com.fshop.fashionshop.model;

import com.fshop.fashionshop.model.commons.enums.OrderStatus;
import com.fshop.fashionshop.model.commons.enums.PaymentMethod;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long date;

    private Integer count;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToOne
    private Product product;

    @ManyToOne
    private User user;

//    private String address;
//
//    private String phone;
//
//    @Enumerated(EnumType.STRING)
//    private PaymentMethod paymentMethod;
}
