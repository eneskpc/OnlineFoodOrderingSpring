package org.zerhusen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerhusen.model.City;

public interface CityRepository extends JpaRepository<City, Long> {}