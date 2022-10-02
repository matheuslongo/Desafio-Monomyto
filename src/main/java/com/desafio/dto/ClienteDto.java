package com.desafio.dto;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Nome")
    private String nome ;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonProperty("DataNascimento")
    private LocalDate dataNascimento;



}
