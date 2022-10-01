package com.desafio.model;/*
 * @project desafio
 * @author matheuslongo on 27/09/2022.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;


@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonDeserialize
@Entity
public class Cliente {


    @Id
    @NotNull
    @JsonProperty("Id")
    public String id ;

    @JsonProperty("Nome")
    @Column(name ="nome")
    private String nome ;


    @Column(name = "dataDeNascimento")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonProperty("DataNascimento")
    private LocalDate dataNascimento;

    public Cliente(String cliente){
    this.id = id;
    }
}
