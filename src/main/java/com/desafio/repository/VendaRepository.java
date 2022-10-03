package com.desafio.repository;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */
import com.desafio.dto.VendaDto;
import com.desafio.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional(readOnly = true)
@Repository
public interface VendaRepository extends JpaRepository<Venda, String> {

    @Query(value = "SELECT `venda`.`id`, " +
            "    `venda`.`data_de_venda`, " +
            "    `venda`.`cliente_id` " +
            "FROM `monomyto_json`.`venda` " +
            "where cliente_id =(select  id from monomyto_json.cliente where nome = '?1') ;" ,
    nativeQuery = true)
    List<VendaDto> findVendaByNameCliente(String nome);

}
