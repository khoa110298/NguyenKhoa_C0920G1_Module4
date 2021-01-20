package vn.codegym.service;

import vn.codegym.entity.CustomerType;
import vn.codegym.entity.Division;

import java.util.List;

public interface DivisionService {
    List<Division> findAll();

    void save(Division division);

    Division findById(Integer id);

    void remove(Integer id);
}
