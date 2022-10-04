package com.desafio.model;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class VendaItem implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "precoUnitario", length = 10, precision = 2)
    private  Double precoUnitario;

    @Column(name = "quantidade")
    private Double quantidade ;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id", nullable = true)
    private Venda venda;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Catalogo catalogo;




}
