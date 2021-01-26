package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.entity.RentType;
import vn.codegym.repository.RentTypeRepository;
import vn.codegym.service.RentTypeService;

import java.util.List;
@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public RentType findById(Integer id) {
        return rentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        rentTypeRepository.deleteById(id);
    }
}
