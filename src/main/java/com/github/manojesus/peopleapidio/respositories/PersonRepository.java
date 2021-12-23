package com.github.manojesus.peopleapidio.respositories;

import com.github.manojesus.peopleapidio.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
