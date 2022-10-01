package com.desafio.utils;/*
 * @project desafio
 * @author matheuslongo on 29/09/2022.
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter

public class ConverterData {
    /**
     * Converte o formato da data para o padrao americano: DD-MM-YYYY.
     *
     * @param localDate
     * @return
     */
    public static String formatterDateBr(LocalDate localDate) {
        String[] date = localDate.toString().split("-");
        StringBuilder strDate = new StringBuilder();
        strDate.append(date[2]).append("/").append(date[1]).append("/").append(date[0]);
        return strDate.toString();
    }

    public ConverterData() {
    }
}
