package com.desafio.model;/*
 * @project desafio
 * @author matheuslongo on 27/09/2022.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    @JsonProperty("id")
    private String id ;

    @JsonProperty("id_cliente")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cliente cliente ;


    @Column(name = "dataDeVenda", nullable = false)
    @DateTimeFormat(pattern ="dd-MM-yyyy HH:mm:ss")
    @JsonProperty("data_de_venda")
    private LocalDateTime data;


    @JsonProperty("Itens")
    @JsonIgnore
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VendaItem> itens ;

}
