package com.github.manojesus.peopleapidio.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Builder
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
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "people_sequence"
    )
    private Long id;
    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false, length = 100, unique = true)
    private String cpf;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false)
    private Integer age;
    @OneToMany(fetch = FetchType.LAZY,cascade = {PERSIST, MERGE, REMOVE})
    private List<Phone> phones;

    @PrePersist
    public void calculateAge(){
        age = Period.between(dob, LocalDate.now()).getYears();
    }
}
