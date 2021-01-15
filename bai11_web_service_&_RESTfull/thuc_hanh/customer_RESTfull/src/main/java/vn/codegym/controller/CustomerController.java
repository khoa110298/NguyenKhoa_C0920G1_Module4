package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.entity.Customer;
import vn.codegym.service.CustomerService;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/api/customer")
    public ResponseEntity<List<Customer>> listAllCustomer(){
        List<Customer> customerList = customerService.findAll();
        if (customerList.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/api/customer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
        Customer customer = customerService.findById(id);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
