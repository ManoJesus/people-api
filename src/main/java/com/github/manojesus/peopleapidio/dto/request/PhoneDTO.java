package com.github.manojesus.peopleapidio.dto.request;

import com.github.manojesus.peopleapidio.enums.PhoneType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneDTO {

    private Long id;
    @Enumerated(EnumType.STRING)
    @NotEmpty
    private PhoneType type;
    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

}


