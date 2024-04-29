package com.javawithsprinbootlucas.javawithspringboot.controller;

import com.javawithsprinbootlucas.javawithspringboot.model.Person;
import com.javawithsprinbootlucas.javawithspringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonServices service;



    @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById (@PathVariable(value = "id")Long id)throws Exception {

    return service.findById(id);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
     public List<Person> findAll(){

        return service.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create (@RequestBody Person person){
        return service.create(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update (@RequestBody Person person){
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete (@PathVariable(value="id")Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

}
