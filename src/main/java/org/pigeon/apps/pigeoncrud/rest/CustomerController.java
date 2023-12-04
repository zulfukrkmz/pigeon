package org.pigeon.apps.pigeoncrud.rest;

import org.pigeon.apps.pigeoncrud.entity.Customer;
import org.pigeon.apps.pigeoncrud.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService service;

    // REST endpoints
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllEntities() {
        List<Customer> customers = service.getAllEntities();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getEntityById(@PathVariable Long id) {
        Customer customer = service.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createEntity(@RequestBody Customer customer) {
        Customer createdEntity = service.createCustomer(customer);
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateEntity(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        Customer entity = service.updateCustomer(id, updatedCustomer);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        service.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}