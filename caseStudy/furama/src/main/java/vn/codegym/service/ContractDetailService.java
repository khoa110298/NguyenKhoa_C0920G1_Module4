package vn.codegym.service;

import vn.codegym.entity.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    ContractDetail findById(Integer id);

    void remove(Integer id);
}
