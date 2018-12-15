package org.zerhusen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerhusen.model.District;

public interface DistrictRepository extends JpaRepository<District, Integer> {
	
}