package com.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    private long count;
    private String email;
    private String lastName;

    public CustomerRequest(String lastName, String email, long count) {
        this.lastName = lastName;
        this.email = email;
        this.count = count;
    }
}
