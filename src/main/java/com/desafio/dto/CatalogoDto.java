package com.desafio.dto;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */

import com.desafio.model.Catalogo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogoDto {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Marca")
    private String marca;

    @JsonProperty("Classificacao")
    private String classificacao;

    @JsonProperty("Nome")
    private String nome;

    @JsonProperty("TeorAlcoolico")
    private String teorAlcoolico ;

    @JsonProperty("Regiao")
    private String regiao;

    @JsonProperty("PrecoAtual")
    private Double precoAtual;


}
