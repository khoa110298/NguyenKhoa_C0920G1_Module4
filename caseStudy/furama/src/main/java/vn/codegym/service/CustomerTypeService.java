package vn.codegym.service;

import vn.codegym.entity.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();

    void save(CustomerType customerType);

    CustomerType findById(Integer id);

    void remove(Integer id);
}
