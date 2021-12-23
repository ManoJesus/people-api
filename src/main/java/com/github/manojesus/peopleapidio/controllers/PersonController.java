package com.github.manojesus.peopleapidio.controllers;

import com.github.manojesus.peopleapidio.dto.request.PersonDTO;
import com.github.manojesus.peopleapidio.entities.Person;
import com.github.manojesus.peopleapidio.exceptions.PersonNotFoundException;
import com.github.manojesus.peopleapidio.respositories.PersonRepository;
import com.github.manojesus.peopleapidio.services.MessageResponse;
import com.github.manojesus.peopleapidio.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1.0/people")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse createPerson(@RequestBody @Valid PersonDTO person) {
        return personService.createPerson(person);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> listAll() {
        return personService.listAl();
    }

    @GetMapping("/{personID}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getPerson(@PathVariable Long personID) throws PersonNotFoundException {
        return personService.getAPerson(personID);
    }

    @DeleteMapping("/{personID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public MessageResponse deleteAPerson(@PathVariable Long personID) throws PersonNotFoundException {
        return personService.deleteAPerson(personID);
    }

    @PutMapping("/{personID}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse updatePerson(@PathVariable Long personID, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updatePerson(personID, personDTO);
    }
}