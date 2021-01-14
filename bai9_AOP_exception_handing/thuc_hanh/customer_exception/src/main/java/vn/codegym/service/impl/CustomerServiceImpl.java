package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.exception.DuplicateEmailException;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;
import vn.codegym.service.CustomerService;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) throws DuplicateEmailException {
        try {
            customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllInputText(String firstname, Pageable pageable){
        return customerRepository.findAllByFirstNameContaining(firstname,pageable);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) throws Exception {
//        if (true) throw new Exception("a dummy exception");
        try {
            return customerRepository.findAll(pageable);
        } catch (Exception e){
            throw new Exception("a dummy exception");
        }

    }
}
