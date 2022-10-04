package com.desafio.dto;/*
 * @project cadastroModel
 * @author matheuslongo on 04/10/2022.
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TotalDeVendaDeProdutosDto {
    private String id;
    private Double valorTotal;
}
