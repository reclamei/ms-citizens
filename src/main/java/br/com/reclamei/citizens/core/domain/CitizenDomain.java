package br.com.reclamei.citizens.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CitizenDomain {

    private String id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private LocalDate birthDate;

}
