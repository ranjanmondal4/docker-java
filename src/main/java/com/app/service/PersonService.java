package com.app.service;

import com.app.domain.Person;
import com.app.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    public Person addPerson(Person person){
       // person.getAddress().setLocation(new Point(13.361389D, 38.115556D));
        return personRepository.save(person);
    }

    public Iterable<Person> findAllPerson(){
        Iterable<Person> persons = personRepository.findAll();

        persons.forEach(person -> {
            LOGGER.info("Person {}", person);
        });
        return personRepository.findAll();
    }

    public List<Person> findAllPersonByName(String name){
        return personRepository.findByName(name);
    }
}
