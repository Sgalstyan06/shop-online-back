package com.fshop.fashionshop.repository;

import com.fshop.fashionshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
