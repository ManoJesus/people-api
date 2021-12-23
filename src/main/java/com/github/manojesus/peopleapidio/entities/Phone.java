package com.github.manojesus.peopleapidio.entities;

import com.github.manojesus.peopleapidio.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Phone {
    @Id
    @SequenceGenerator(
            name="phone_sequence",
            sequenceName = "phone_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "phone_sequence"
    )
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;
    @Column(nullable = false, length = 100)
    private String number;




}


