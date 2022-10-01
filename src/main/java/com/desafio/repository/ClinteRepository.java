package com.desafio.repository;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */

import com.desafio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ClinteRepository extends JpaRepository<Cliente, String> {

    Optional<Cliente> findById(@Param("id") String id);

    Optional<Cliente> findByNome(@Param("nome")String nome);

    List<Cliente> findByNomeContains(String nome);


}
