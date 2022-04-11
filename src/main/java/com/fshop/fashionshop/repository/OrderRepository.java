package com.fshop.fashionshop.repository;

import com.fshop.fashionshop.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM user_order WHERE user_id=:userId"
    )
    Optional<List<Order>> getAllByUserId(@Param("userId") String userId);
}
