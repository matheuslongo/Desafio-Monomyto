package com.desafio.model;/*
 * @project desafio
 * @author matheuslongo on 27/09/2022.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonDeserialize
@Entity
public class Cliente implements Serializable {


    @Id
    @JsonProperty("Id")
    public String id;

    @JsonProperty(value = "Nome")
    @Column(name = "nome", nullable = false)
    private String nome;


    @Column(name = "dataDeNascimento", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("DataNascimento")
    private LocalDate dataNascimento;

}