package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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
    @PostMapping("/api/customer")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer, UriComponentsBuilder uriComponentsBuilder){
        customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/api/customer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }
    @PutMapping("/api/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id,@RequestBody Customer customer){
        Customer cus = customerService.findById(id);
        if (cus == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cus.setFirstName(customer.getFirstName());
        cus.setLastName(customer.getLastName());
        cus.setId(customer.getId());
        customerService.save(cus);

        return new ResponseEntity<>(cus,HttpStatus.OK);
    }
    @DeleteMapping("/api/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") long id){
        Customer customer = customerService.findById(id);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
