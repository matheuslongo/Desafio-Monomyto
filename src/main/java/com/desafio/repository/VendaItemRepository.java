package com.desafio.repository;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */

import com.desafio.model.VendaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VendaItemRepository extends JpaRepository<VendaItem, String> {
}
