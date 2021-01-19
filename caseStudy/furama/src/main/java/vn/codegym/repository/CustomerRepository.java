package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
