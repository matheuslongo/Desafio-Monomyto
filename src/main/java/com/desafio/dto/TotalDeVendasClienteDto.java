package com.desafio.dto;/*
 * @project desafioM
 * @author matheuslongo on 04/10/2022.
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TotalDeVendasClienteDto {

    private BigInteger totalDeVendas;
}
