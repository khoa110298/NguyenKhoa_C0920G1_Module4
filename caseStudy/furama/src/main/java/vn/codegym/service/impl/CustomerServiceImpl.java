package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.entity.Customer;
import vn.codegym.repository.CustomerRepository;
import vn.codegym.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllInputText(String name, Pageable pageable) {
        return null;
    }
}
