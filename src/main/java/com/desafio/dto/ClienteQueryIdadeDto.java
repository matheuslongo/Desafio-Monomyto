package com.desafio.dto;/*
 * @project desafioM
 * @author matheuslongo on 04/10/2022.
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteQueryIdadeDto {
    private String id ;
    private String nome;
    private Date data;
}
