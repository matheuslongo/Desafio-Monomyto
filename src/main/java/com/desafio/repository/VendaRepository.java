package com.desafio.repository;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */
import com.desafio.dto.VendaDto;
import com.desafio.dto.VendaQueryDto;
import com.desafio.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository
public interface VendaRepository extends CrudRepository<Venda, String> {



}
