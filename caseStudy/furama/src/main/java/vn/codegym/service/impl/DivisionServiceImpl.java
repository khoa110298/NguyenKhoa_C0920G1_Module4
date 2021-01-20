package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.entity.Division;
import vn.codegym.repository.DivisionRepository;
import vn.codegym.service.DivisionService;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public Division findById(Integer id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        divisionRepository.deleteById(id);
    }
}
