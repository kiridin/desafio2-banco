
package org.edu.unifaa.pizzaria.repository;

import org.edu.unifaa.pizzaria.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
