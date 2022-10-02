package com.desafio.dto;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaiorValorAlcoolicoDto {

    private String classificacao;
    private String marca;
    private String nome;
    private Double preco_atual;
    private String regiao;
    private Double teor_alcoolico;



}
