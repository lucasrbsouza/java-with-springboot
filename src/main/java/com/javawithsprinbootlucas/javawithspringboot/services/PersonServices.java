package com.javawithsprinbootlucas.javawithspringboot.services;

import com.javawithsprinbootlucas.javawithspringboot.Respositories.PersonRepositories;
import com.javawithsprinbootlucas.javawithspringboot.data.vo.v1.PersonVO;
import com.javawithsprinbootlucas.javawithspringboot.data.vo.v2.PersonVOV2;
import com.javawithsprinbootlucas.javawithspringboot.exception.ResourceNotFoundException;
import com.javawithsprinbootlucas.javawithspringboot.mapper.DozerMapper;
import com.javawithsprinbootlucas.javawithspringboot.mapper.custom.PersonMapper;
import com.javawithsprinbootlucas.javawithspringboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepositories repositories;

    @Autowired
    PersonMapper mapper;


    public List<PersonVO> findAll(){
        logger.info("Finding one person!");

        return DozerMapper.parseListObjects(repositories.findAll(), PersonVO.class);
    }


    public PersonVO findById(Long id){
        logger.info("Finding one person!");

       var entity =  repositories.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("No record found for this ID!"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person");

        var entity = DozerMapper.parseObject(person, Person.class);

        var vo = DozerMapper.parseObject(repositories.save(entity), PersonVO.class);
        return vo;
    }
    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating one person with personVOV2");

        var entity = mapper.convertVOToEntity(person);

        var vo = mapper.convertEntityToVO(repositories.save(entity));
        return vo;
    }
    public PersonVO update(PersonVO person) {
        logger.info("Updating one person");
        var entity = repositories.findById(person.getId()).
                orElseThrow(()-> new ResourceNotFoundException("No record found for this ID!"));


        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo = DozerMapper.parseObject(repositories.save(entity), PersonVO.class);
        return vo;
    }
    public void delete(Long id) {
        logger.info("deleting one person");
        var entity = repositories.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("No record found for this ID!"));
        repositories.delete(entity);
    }


}
