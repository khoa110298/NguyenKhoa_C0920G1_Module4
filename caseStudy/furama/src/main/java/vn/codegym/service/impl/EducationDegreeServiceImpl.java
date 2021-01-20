package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.entity.EducationDegree;
import vn.codegym.repository.EducationDegreeRepository;
import vn.codegym.service.EducationDegreeService;

import java.util.List;
@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public EducationDegree findById(Integer id) {
        return educationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        educationDegreeRepository.deleteById(id);
    }
}
