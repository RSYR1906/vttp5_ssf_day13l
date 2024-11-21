package com.SSF_day13lecture.SSF_day13lecture.repo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.SSF_day13lecture.SSF_day13lecture.model.Person;

@Repository
public class PersonRepo {

    private List<Person> persons = new ArrayList<>();

    public List<Person> findAll() {
        return persons;
    }

    public Person findById(String personId) {
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(personId)).findFirst().get();
        return foundPerson;
    }

    public Boolean create(Person person) {
        persons.add(person);
        return true;
    }

    public Boolean delete(Person person) {
        int iFoundPerson = persons.indexOf(person);

        if (iFoundPerson >= 0) {
            persons.remove(iFoundPerson);
            return true;
        }
        return false;
    }

    public Boolean update(Person person) {
        List<Person> filteredPerson = persons.stream().filter(p -> p.getId().equals(person.getId()))
                .collect(Collectors.toList());

        if (!filteredPerson.isEmpty()) {
            persons.remove(filteredPerson.getFirst());
            persons.add(person);
            return true;
        }

        return false;
    }
}
