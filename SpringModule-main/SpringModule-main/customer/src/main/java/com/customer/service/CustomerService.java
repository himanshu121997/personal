package com.customer.service;

import com.customer.model.Customer;
import com.customer.model.CustomerRequest;
import com.customer.repo.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    
    private final RestTemplate template;

    EntityManager em;
    
    public void registerCustomer(Customer request) {
        repository.saveAndFlush(request);
        Boolean isValid = template.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}"
                , Boolean.class, request.getId());
        if (isValid){
            throw new IllegalStateException("fraud");
        }
    }

    public List<Customer> getCustomer() {
        List<Customer> customer =  repository.findAll();
        return customer;
    }

    public List<CustomerRequest> getCustomer(String email, String name) {
//        Optional<Customer> customer =  repository.findByCustomer(email,name);
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<CustomerRequest> criteriaQuery = builder.createQuery(CustomerRequest.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);

        Expression<Long> sum = builder.count(root.get("lastName"));
        criteriaQuery.multiselect(root.get("lastName"),root.get("email"), sum.alias("count"));
        criteriaQuery.groupBy(root.get("email"),root.get("lastName"));

        List<CustomerRequest> items = em.createQuery(criteriaQuery).getResultList();
        return items;
    }

    public List<Customer> getCustomers() {
        Optional<List<Customer>> byCustomerEmail = repository.findByEmailEndsWith(".com");
        return byCustomerEmail.get();
    }
}
