package vn.codegym.service;

import vn.codegym.entity.RentType;
import vn.codegym.entity.ServiceType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();

    void save(RentType rentType);

    RentType findById(Integer id);

    void remove(Integer id);
}
