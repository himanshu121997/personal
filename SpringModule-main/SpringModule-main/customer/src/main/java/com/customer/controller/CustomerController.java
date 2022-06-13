package com.customer.controller;

import com.customer.model.Customer;
import com.customer.model.CustomerRequest;
import com.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    List<Object> list = new ArrayList<>();

    @PostMapping("/customer")
    public void registerCustomer(@RequestBody Customer request){
        log.info("new customer registration request {}", request);
        service.registerCustomer(request);
    }

    @GetMapping("/customer")
    public List<Customer> getCustomer(){
        log.info("get customer");
        List<Customer> customer = service.getCustomer();
       return customer;
    }

    @GetMapping("/customer/{email}/{name}")
    public List<CustomerRequest> getCustomer(@PathVariable String email, @PathVariable String name){
        log.info("get customer from email");
        List<CustomerRequest> customer = service.getCustomer(email,name);
        return customer;
    }

    @GetMapping("/customer/email")
    public List<Customer> getCustomerEmail() {
        log.info("get getCustomerEmail");
        List<Customer> customer = service.getCustomers();
        return customer;
    }

    @KafkaListener (groupId = "messageList", topics = "fraud", containerFactory = "kafkaListenerContainerFactory")
    public List<Object> getMsgFromTopic(String data){
        list.add(data);
        return list;
    }

    @GetMapping("/consume")
    public List<Object> getMsgs(){
        return list;
    }
}
