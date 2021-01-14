package vn.codegym.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.exception.DuplicateEmailException;
import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer) throws DuplicateEmailException;

    void remove(Long id);

    Page<Customer> findAllInputText(String firstname, Pageable pageable);

    Page<Customer> findAll(Pageable pageable) throws Exception;

//    Page<Customer> findAll(Pageable pageInfo) throws Exception {
//        if (true) throw new Exception("a dummy exception");
//    }
}