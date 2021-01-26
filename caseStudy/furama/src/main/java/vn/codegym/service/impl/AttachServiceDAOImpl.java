package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.entity.AttachService;
import vn.codegym.repository.AttachServiceRepository;
import vn.codegym.service.AttachServiceDAO;

import java.util.List;
@Service
public class AttachServiceDAOImpl implements AttachServiceDAO {
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Integer id) {
        attachServiceRepository.deleteById(id);
    }

    @Override
    public AttachService findById(Integer id) {
        return attachServiceRepository.findById(id).orElse(null);
    }
}
