package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.entity.ServiceType;
import vn.codegym.repository.ServiceTypeRepository;
import vn.codegym.service.ServiceTypeDAO;

import java.util.List;
@Service
public class ServiceTypeDAOImpl implements ServiceTypeDAO {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public ServiceType findById(Integer id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        serviceTypeRepository.deleteById(id);
    }
}
