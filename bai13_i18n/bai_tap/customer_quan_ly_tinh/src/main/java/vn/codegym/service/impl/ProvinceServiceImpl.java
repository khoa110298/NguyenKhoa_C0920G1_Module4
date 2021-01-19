package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.model.Province;
import vn.codegym.repository.ProvinceRepository;
import vn.codegym.service.ProvinceService;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
@Autowired
ProvinceRepository provinceRepository;
    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
