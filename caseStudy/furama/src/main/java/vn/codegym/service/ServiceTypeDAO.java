package vn.codegym.service;

import vn.codegym.entity.ServiceType;

import java.util.List;

public interface ServiceTypeDAO {
    List<ServiceType> findAll();

    void save(ServiceType serviceType);

    ServiceType findById(Integer id);

    void remove(Integer id);
}
