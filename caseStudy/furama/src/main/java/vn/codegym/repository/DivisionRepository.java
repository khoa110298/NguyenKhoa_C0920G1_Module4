package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.entity.Division;

public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
