package com.javawithsprinbootlucas.javawithspringboot.Respositories;

import com.javawithsprinbootlucas.javawithspringboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositories extends JpaRepository<Person, Long> {
}
