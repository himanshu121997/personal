package com.customer.repo;

import com.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("from Customer where firstName = :name and email = :email")
    Optional<Customer> findByCustomer(@Param("email") String email, @Param("name") String name);

    Optional<List<Customer>> findByEmailEndsWith(String director);
}
