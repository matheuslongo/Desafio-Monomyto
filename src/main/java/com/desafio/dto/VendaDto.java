package com.desafio.dto;/*
 * @project desafio
 * @author matheuslongo on 29/09/2022.
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@ToString
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@JsonDeserialize
public class VendaDto implements Serializable {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("IdCliente")
    private String idCliente;

    @JsonProperty("Data")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String dataDeVenda;

    @JsonProperty("Itens")
    private List<VendaItemDto> vendaItens;


}
