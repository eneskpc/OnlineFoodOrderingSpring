package org.zerhusen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerhusen.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}