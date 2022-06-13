package com.micro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class userRequest {

    private String userId;
    @NotNull(message = "firstName is missing")
    private String firstName;
    @NotNull(message = "lastName is missing")
    private String lastName;
    @NotNull(message = "email is missing")
    @Email(message = "email is invalid")
    private String email;
    @NotNull(message = "password is missing")
    @Size(min = 8, max = 10,message = "password should be between 8 & 10 character")
    private String password;
}
