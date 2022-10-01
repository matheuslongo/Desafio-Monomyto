package com.desafio.dto;/*
 * @project desafio
 * @author matheuslongo on 29/09/2022.
 */

import com.desafio.model.Cliente;
import com.desafio.model.VendaItem;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Data
@ToString
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@JsonDeserialize
public class VendaDTO {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("IdCliente")
    private Cliente idCliente ;

    @JsonProperty("Data")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataDeVenda ;

    @JsonProperty("Itens")
    private List<VendaItemDto> vendaItens ;


}
