package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.entity.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
