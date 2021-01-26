package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.entity.ContractDetail;
import vn.codegym.repository.ContractDetailRepository;
import vn.codegym.service.ContractDetailService;

import java.util.List;
@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public ContractDetail findById(Integer id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        contractDetailRepository.deleteById(id);
    }
}
