package com.fshop.fashionshop.repository;

import com.fshop.fashionshop.model.commons.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long > {
}
