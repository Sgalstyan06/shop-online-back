package com.fshop.fashionshop.service;

import com.fshop.fashionshop.model.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product getById(long id);

    List<Product> getAll();

    Product update( Product product,long id);

    void delete(long id);
}
