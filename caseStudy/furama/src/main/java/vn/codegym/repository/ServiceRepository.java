package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.entity.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity,String> {
    Page<ServiceEntity> findAllByNameContaining(String name, Pageable pageable);
}
