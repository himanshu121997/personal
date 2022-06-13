package com.micro.control;

import com.micro.Exception.UserNotfoundException;
import com.micro.model.userRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class microController {

    Map<String, userRequest> dataMap = new HashMap<>();

    @GetMapping("/")
    public String msg(){
        return "welcome home";
    }

    @GetMapping(value = "/micro", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<userRequest> data(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "id", required = true, defaultValue = "1") String id){

        if(dataMap.get(id) != null){
            return new ResponseEntity<>(dataMap.get(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/micro/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<userRequest> data(@PathVariable(required = true) String id){

        if(dataMap.get(id) != null){
            return new ResponseEntity<>(dataMap.get(id), HttpStatus.OK);
        }else{
            throw new UserNotfoundException("user with id: " + id + " not found");
        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/micro",produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<userRequest> data(@Valid @RequestBody userRequest request){
        String id = UUID.randomUUID().toString();
        request.setUserId(id);
        dataMap.put(id,request);
        return new ResponseEntity<>(request,HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

}
