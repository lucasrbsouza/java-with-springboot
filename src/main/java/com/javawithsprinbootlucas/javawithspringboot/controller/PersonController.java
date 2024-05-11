package com.javawithsprinbootlucas.javawithspringboot.controller;

import com.javawithsprinbootlucas.javawithspringboot.data.vo.v1.PersonVO;
import com.javawithsprinbootlucas.javawithspringboot.data.vo.v2.PersonVOV2;
import com.javawithsprinbootlucas.javawithspringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {


    @Autowired
    private PersonServices service;


    @GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById (@PathVariable(value = "id")Long id)throws Exception {

    return service.findById(id);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
     public List<PersonVO> findAll(){

        return service.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create (@RequestBody PersonVO person){
        return service.create(person);
    }

    @PostMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 createV2 (@RequestBody PersonVOV2 person){
        return service.createV2(person);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@PathVariable("id") Long id, @RequestBody PersonVO person) {
        person.setId(id);
        return service.update(person);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete (@PathVariable(value="id")Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

}
