package com.desafio.dto;/*
 * @project desafioM
 * @author matheuslongo on 01/10/2022.
 */

import com.desafio.model.Venda;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonDeserialize
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VendaItemDto implements Serializable {



    @JsonProperty("Id")
    private String catalogoId;

    @JsonProperty("PrecoUnitario")
    @JsonIgnore
    private  Double precoUnitario;

    @JsonProperty("Quantidade")
    private Double quantidade ;

    private String venda;

}
