package org.zerhusen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerhusen.model.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

}
