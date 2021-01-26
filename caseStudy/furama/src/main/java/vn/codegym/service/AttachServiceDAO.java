package vn.codegym.service;

import vn.codegym.entity.AttachService;

import java.util.List;

public interface AttachServiceDAO {
    List<AttachService> findAll();

    void save(AttachService attachService);

    void remove(Integer id);

    AttachService findById(Integer id);
}
