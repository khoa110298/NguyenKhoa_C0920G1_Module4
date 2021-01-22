package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.entity.Customer;
import vn.codegym.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByName(String name,Pageable pageable);

    Employee findById(String id);

    void save(Employee employee);

    void remove(String id);

}
