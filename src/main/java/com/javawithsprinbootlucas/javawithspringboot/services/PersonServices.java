package com.javawithsprinbootlucas.javawithspringboot.services;

import com.javawithsprinbootlucas.javawithspringboot.Respositories.PersonRepositories;
import com.javawithsprinbootlucas.javawithspringboot.exception.ResourceNotFoundException;
import com.javawithsprinbootlucas.javawithspringboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepositories repositories;
    public List<Person> findAll(){
        logger.info("Finding one person!");

        return repositories.findAll();
    }


    public Person findById(Long id){
        logger.info("Finding one person!");

        return  repositories.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("No record found for this ID!"));
    }

    public Person create(Person person) {
        logger.info("Creating one person");

        return repositories.save(person);
    }
    public Person update(Person person) {
        logger.info("Updating one person");
        var entity = repositories.findById(person.getId()).
                orElseThrow(()-> new ResourceNotFoundException("No record found for this ID!"));


        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repositories.save(person);
    }
    public void delete(Long id) {
        logger.info("deleting one person");
        var entity = repositories.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("No record found for this ID!"));
        repositories.delete(entity);
    }


}
