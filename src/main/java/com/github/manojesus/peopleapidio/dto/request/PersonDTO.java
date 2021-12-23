package com.github.manojesus.peopleapidio.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;
    @NotEmpty
    @CPF
    private String cpf;
    @NotEmpty
    private LocalDate dob;
    private Integer age;
    @NotEmpty
    @Valid
    private List<PhoneDTO> phones;

}
