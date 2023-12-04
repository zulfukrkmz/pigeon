package org.pigeon.apps.pigeoncrud.services;

import org.pigeon.apps.pigeoncrud.entity.Customer;
import org.pigeon.apps.pigeoncrud.exception.CustomerNotFoundException;
import org.pigeon.apps.pigeoncrud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAllEntities() {
        return repository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedEntity) {
        Customer existingEntity = getCustomerById(id);
        existingEntity.setName(updatedEntity.getName());
        existingEntity.setEmail(updatedEntity.getEmail());
        return repository.save(existingEntity);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}