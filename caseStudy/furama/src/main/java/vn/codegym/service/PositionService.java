package vn.codegym.service;

import vn.codegym.entity.EducationDegree;
import vn.codegym.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();

    void save(Position position);

    Position findById(Integer id);

    void remove(Integer id);
}
