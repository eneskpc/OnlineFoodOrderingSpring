package org.zerhusen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerhusen.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
