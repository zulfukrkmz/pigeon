package org.pigeon.apps.pigeoncrud.services;

import org.pigeon.apps.pigeoncrud.entity.Customer;
import org.pigeon.apps.pigeoncrud.exception.CustomerNotFoundException;
import org.pigeon.apps.pigeoncrud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    private static final Logger logger = LogManager.getLogger(CustomerService.class);

    public List<Customer> getAllEntities() {
        logger.info("All customers returned for Http request at: "+System.currentTimeMillis());
        return repository.findAll();
    }

    public Customer getCustomerById(Long id) {
        logger.info("Http request came for: "+id);
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
    }

    public Customer createCustomer(Customer customer) {
        logger.info("Customer created for:"+customer.toString());
        return repository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedEntity) {
        logger.info("Customer updated for:"+updatedEntity.toString());
        Customer existingEntity = getCustomerById(id);
        existingEntity.setName(updatedEntity.getName());
        existingEntity.setEmail(updatedEntity.getEmail());
        return repository.save(existingEntity);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
        logger.info("Customer deleted with id: "+id);
    }
}