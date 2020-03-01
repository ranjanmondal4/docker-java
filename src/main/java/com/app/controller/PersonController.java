package com.app.controller;

import com.app.domain.Person;
import com.app.dto.user.AddUserDto;
import com.app.service.PersonService;
import com.app.utility.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/practise/api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(path = "/person")
    public ResponseEntity<Object> addPerson(@RequestBody Person person){

        person = personService.addPerson(person);
        return ResponseHandler.generateResponse(HttpStatus.OK, true, "Person is created", person);
    }

    @GetMapping(path = "/persons")
    public ResponseEntity<Object> getAllPerson(@RequestParam String name){
        //personService.findAllPerson();

        return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success",
               personService.findAllPersonByName(name));
    }
}
