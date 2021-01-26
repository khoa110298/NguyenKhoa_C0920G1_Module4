package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.entity.ServiceEntity;
import vn.codegym.repository.ServiceRepository;
import vn.codegym.service.ServiceDAO;

import java.util.List;
@Service
public class ServiceDAOImpl implements ServiceDAO {
    @Autowired
    ServiceRepository serviceRepository;
    @Override
    public Page<ServiceEntity> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<ServiceEntity> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceEntity findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceEntity service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(String id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Page<ServiceEntity> findAllInputText(String name, Pageable pageable) {
        return serviceRepository.findAllByNameContaining(name,pageable);
    }
}
