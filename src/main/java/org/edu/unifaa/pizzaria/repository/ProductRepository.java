
package org.edu.unifaa.pizzaria.repository;

import org.edu.unifaa.pizzaria.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
