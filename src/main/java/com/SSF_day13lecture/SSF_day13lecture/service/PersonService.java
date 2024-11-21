package com.SSF_day13lecture.SSF_day13lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SSF_day13lecture.SSF_day13lecture.model.Person;
import com.SSF_day13lecture.SSF_day13lecture.repo.PersonRepo;

@Service
public class PersonService {

    private final PersonRepo personRepo;

    public PersonService(@Autowired PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public Boolean create(Person person) {
        return personRepo.create(person);
    }

    public Boolean delete(Person person) {
        return personRepo.delete(person);
    }

    public Boolean update(Person person) {
        return personRepo.update(person);
    }

    public Person findById(String personId) {
        return personRepo.findById(personId);
    }

    
}
