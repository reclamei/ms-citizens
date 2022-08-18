package br.com.reclamei.citizens.dataprovider.database.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
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
