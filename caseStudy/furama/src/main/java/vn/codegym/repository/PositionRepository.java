package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.entity.Position;

public interface PositionRepository extends JpaRepository<Position,Integer> {
}
