package br.com.reclamei.citizens.entrypoint.api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class CitizenCreateRequest {

    @NotBlank
    private String name;

    @CPF
    @NotBlank
    private String cpf;

    @Email
    @NotBlank
    private String email;

    @Size(min = 11, max = 12)
    @NotBlank
    private String phone;

    @Past
    @NotNull
    private LocalDate birthDate;

}
