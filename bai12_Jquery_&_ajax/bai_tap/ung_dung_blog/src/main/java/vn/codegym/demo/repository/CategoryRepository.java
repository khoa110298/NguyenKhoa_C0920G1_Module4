package vn.codegym.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
