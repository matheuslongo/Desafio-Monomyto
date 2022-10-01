package com.desafio.model;/*
 * @project desafio
 * @author matheuslongo on 27/09/2022.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonDeserialize

@Table(name = "venda")
public class Venda implements Serializable {


    @Id
    @NotNull
    @JsonProperty("Id")
    @GeneratedValue
    private String id ;

    @ManyToOne
    @JsonProperty("IdCliente")
    private Cliente cliente ;


    @Column(name = "dataDeVenda", nullable = false)
    @DateTimeFormat(pattern ="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime data;


    @JsonProperty("Itens")
    @OneToMany(mappedBy = "venda")
    private List<VendaItem> itens ;

}
