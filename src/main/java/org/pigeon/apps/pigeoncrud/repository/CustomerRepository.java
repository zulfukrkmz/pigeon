package org.pigeon.apps.pigeoncrud.repository;


import org.pigeon.apps.pigeoncrud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}