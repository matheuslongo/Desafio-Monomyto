package com.desafio.model;/*
 * @project desafio
 * @author matheuslongo on 27/09/2022.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Catalogo implements Serializable {


    @Id
    @NotNull
    @JsonProperty( "Id")
    private String id ;

    @JsonProperty("Marca")
    @Column(name ="marca", nullable = false)
    private String marca;

    @Column(name = "classificacao", nullable = false)
    @JsonProperty("Classificacao")
    private String classificacao;

    @Column(name = "nome", nullable = false)
    @JsonProperty("Nome")
    private String nome;

    @Column(name = "teorAlcoolico", nullable = false)
    @JsonProperty("TeorAlcoolico")
    private String teorAlcoolico ;

    @Column(name = "regiao", nullable = false)
    @JsonProperty("Regiao")
    private String regiao;

    @Column(name = "precoAtual", nullable = false)
    @JsonProperty("PrecoAtual")
    private Double precoAtual;


}
