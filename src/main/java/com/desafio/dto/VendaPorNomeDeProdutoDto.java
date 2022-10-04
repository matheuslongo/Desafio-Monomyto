package com.desafio.dto;/*
 * @project desafioM
 * @author matheuslongo on 04/10/2022.
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class VendaPorNomeDeProdutoDto {

    private BigInteger id ;
    private String catalogo;
    private String venda;
    private Double precoUnitario;
    private Double quantidade;


    public VendaPorNomeDeProdutoDto(BigInteger id, String catalogo, String venda, Double precoUnitario, Double quantidade) {
        this.id = id;
        this.catalogo = catalogo;
        this.venda = venda;
        this.precoUnitario = precoUnitario;
        this.quantidade =quantidade;

    }
}
