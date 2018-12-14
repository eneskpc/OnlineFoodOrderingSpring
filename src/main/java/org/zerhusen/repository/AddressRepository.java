package org.zerhusen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerhusen.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
