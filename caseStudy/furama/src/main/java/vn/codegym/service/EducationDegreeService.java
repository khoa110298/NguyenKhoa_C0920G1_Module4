package vn.codegym.service;

import vn.codegym.entity.Division;
import vn.codegym.entity.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();

    void save(EducationDegree educationDegree);

    EducationDegree findById(Integer id);

    void remove(Integer id);
}
