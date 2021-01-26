package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.entity.ServiceEntity;

import java.util.List;

public interface ServiceDAO {
    Page<ServiceEntity> findAll(Pageable pageable);

    List<ServiceEntity> findAll();

    ServiceEntity findById(String id);

    void save(ServiceEntity service);

    void remove(String id);

    Page<ServiceEntity> findAllInputText(String name, Pageable pageable);

}
