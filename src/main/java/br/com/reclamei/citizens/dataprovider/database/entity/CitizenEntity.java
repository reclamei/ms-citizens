package br.com.reclamei.citizens.dataprovider.database.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@Document("citizen")
public class CitizenEntity {

    private String id;

    @Field("name")
    private String name;

    @Field("cpf")
    private String cpf;

    @Field("email")
    private String email;

    @Field("phone")
    private String phone;

    @Field("birth_date")
    private LocalDate birthDate;

}
