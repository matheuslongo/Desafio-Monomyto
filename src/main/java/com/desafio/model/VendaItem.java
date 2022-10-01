package com.desafio.model;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class VendaItem implements Serializable {


    @Id
    @GeneratedValue
    private String id;

    @Column(name = "precoUnitario", nullable = false)
    private  Double precoUnitario;

    @Column(name = "quantidade", nullable = false)
    private Double quantidade ;

    @ManyToOne(cascade = CascadeType.ALL)
    private Venda venda;




}
