package com.desafio.dto;/*
 * @project desafioM
 * @author matheuslongo on 01/10/2022.
 */

import com.desafio.model.Catalogo;
import com.desafio.model.Venda;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonDeserialize
public class VendaItemDto {


    @JsonProperty( "Id")
    private String catalogoId;

    @JsonProperty("PrecoUnitario")
    private  Double precoUnitario;

    @JsonProperty("Quantidade")
    private Double quantidade ;

    @JsonProperty
    private Venda venda;

}
