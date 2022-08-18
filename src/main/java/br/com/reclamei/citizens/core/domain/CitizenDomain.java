package br.com.reclamei.citizens.core.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CitizenDomain {

    private String id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private LocalDate birthDate;

}
