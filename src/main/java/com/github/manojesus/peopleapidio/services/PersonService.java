package com.github.manojesus.peopleapidio.services;

import com.github.manojesus.peopleapidio.dto.request.PersonDTO;
import com.github.manojesus.peopleapidio.entities.Person;
import com.github.manojesus.peopleapidio.exceptions.PersonNotFoundException;
import com.github.manojesus.peopleapidio.mapper.PersonMapper;
import com.github.manojesus.peopleapidio.respositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponse createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return buildMessageResponse(String.format("Person of ID %s created with success", savedPerson.getId()));
    }


    public List<PersonDTO> listAl() {
        List<Person> allPersons = personRepository.findAll();
        return allPersons.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO getAPerson(Long personID) throws PersonNotFoundException {
        Person person = verifyIfPersonExists(personID);
        return personMapper.toDTO(person);
    }

    private Person verifyIfPersonExists(Long personID) throws PersonNotFoundException {
        return personRepository.findById(personID).orElseThrow(() -> new PersonNotFoundException(personID));
    }

    public MessageResponse deleteAPerson(Long personID) throws PersonNotFoundException {
        Person person = verifyIfPersonExists(personID);;
        personRepository.deleteById(personID);
        return buildMessageResponse("Person with ID "+personID +" was deleted.");
    }

    @Transactional
    public MessageResponse updatePerson(Long personID, PersonDTO personDTO) throws PersonNotFoundException {
        Person personToBeUpdate = verifyIfPersonExists(personID);
        personToBeUpdate = personMapper.toModel(personDTO);
        return buildMessageResponse("Person with ID " + personID + " was updated.");
    }

    private MessageResponse buildMessageResponse(String content) {
        return MessageResponse.builder()
                .message(content)
                .build();
    }
}
