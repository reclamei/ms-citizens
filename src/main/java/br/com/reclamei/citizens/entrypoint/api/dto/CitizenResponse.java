package br.com.reclamei.citizens.entrypoint.api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CitizenResponse {

    private String id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private LocalDate birthDate;

}
