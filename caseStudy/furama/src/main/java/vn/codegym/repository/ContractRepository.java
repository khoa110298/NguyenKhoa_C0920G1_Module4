package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.entity.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract,String> {
    @Query("select c from Contract c where concat(c.employee.name,c.customer.name) like %?1%")
    Page<Contract> findAllInputText(String keyword,Pageable pageable);

}
