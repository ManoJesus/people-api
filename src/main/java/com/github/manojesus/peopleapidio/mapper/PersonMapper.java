package com.github.manojesus.peopleapidio.mapper;

import com.github.manojesus.peopleapidio.dto.request.PersonDTO;
import com.github.manojesus.peopleapidio.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toModel(PersonDTO personDTO);
    PersonDTO toDTO(Person person);
}
