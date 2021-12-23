package com.github.manojesus.peopleapidio.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @SequenceGenerator(
            name="people_sequence",
            sequenceName = "people_sequence",
            allocationSize = 1
    )
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Integer age;
}
