package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.entity.ContractDetail;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
