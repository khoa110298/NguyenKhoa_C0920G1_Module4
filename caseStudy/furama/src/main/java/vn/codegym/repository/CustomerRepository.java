package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

    @Query("select c from customer c where concat(c.name,c.idCard,c.phone,c.email) like %?1%")
    Page<Customer> findAllInputTex(String keyword,Pageable pageable);

}
