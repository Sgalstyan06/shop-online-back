package com.fshop.fashionshop.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ToString
@Entity
public class User {
    @Id
    private String id;

    private String email;

    private String name;

    private String picture;

}
