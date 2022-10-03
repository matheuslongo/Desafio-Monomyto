package com.desafio.repository;/*

 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */

import com.desafio.model.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, String> {

    Optional<Catalogo> findById(@Param("id") String id);

    Optional<Catalogo> findByNome(@Param("nome")String nome);

    List<Catalogo> findByNomeContains(@Param("nome")String nome);



}
