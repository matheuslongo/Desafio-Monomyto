package com.desafio.repository;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */

import com.desafio.dto.ClienteDto;
import com.desafio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;



@Repository
public interface ClinteRepository extends JpaRepository<Cliente, String> {

    Optional<Cliente> findById(@Param("id") String id);

    List<Cliente> findByNome(@Param("nome")String nome);

    List<Cliente> findByNomeContains(String nome);


    @Query(value = "SELECT c FROM Cliente c " +
            " WHERE c.dataNascimento  between '1943-11-21' and '?1' ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
     List<Cliente> findByDataNascimento(String date);


}
