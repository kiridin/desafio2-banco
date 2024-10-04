
package org.edu.unifaa.pizzaria.repository;

import org.edu.unifaa.pizzaria.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
