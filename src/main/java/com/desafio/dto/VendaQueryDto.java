package com.desafio.dto;/*
 * @project desafioM
 * @author matheuslongo on 03/10/2022.
 */


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)

@NoArgsConstructor
public class VendaQueryDto {

    @DateTimeFormat(pattern ="dd-MM-yyyy HH:mm:ss")
    public Timestamp data;

    public String id;
    public String cliente_id;

    public VendaQueryDto(Timestamp data, String id, String cliente_id) {
        this.data = data;
        this.id = id;
        this.cliente_id = cliente_id;
    }
}
