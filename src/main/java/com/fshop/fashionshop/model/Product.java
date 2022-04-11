package com.fshop.fashionshop.model;

import com.fshop.fashionshop.model.commons.Description;
import com.fshop.fashionshop.model.commons.Image;
import com.fshop.fashionshop.model.commons.Stock;
import com.fshop.fashionshop.model.commons.enums.Currency;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Float price;

    @OneToOne(cascade = CascadeType.ALL)
    private Description description;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToOne(cascade = CascadeType.ALL)
    private Stock stock;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> img;

    @Override
    public String toString() {
        return "" +
                "" + id +
                "" + name +
                "" + price +
                "" + description +
                "" + currency +
                "" + stock +
                "" + img;
    }
}
