package vn.codegym.service;

import vn.codegym.model.Customer;
import vn.codegym.model.Province;

import java.util.List;

public interface ProvinceService {

    List<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);

}
