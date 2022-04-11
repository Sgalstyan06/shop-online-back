package com.fshop.fashionshop.repository;

import com.fshop.fashionshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
