
package org.edu.unifaa.pizzaria.repository;

import org.edu.unifaa.pizzaria.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
