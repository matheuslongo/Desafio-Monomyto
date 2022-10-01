package com.desafio.service;/*
 * @project desafioM
 * @author matheuslongo on 01/10/2022.
 */

import com.desafio.dto.VendaDTO;
import com.desafio.dto.VendaItemDto;
import com.desafio.model.Venda;
import com.desafio.model.VendaItem;
import com.desafio.repository.VendaItemRepository;
import com.desafio.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaItemService {

    @Autowired
    private VendaItemRepository vendaItemRepository;

    @Autowired
    private VendaRepository vendaRepository;

    public boolean save(VendaItem vendaItem){
        try {
            vendaItemRepository.save(vendaItem);
            return true ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean persistAll(List<VendaDTO> vendaDtoList){
        try {
            vendaDtoList.forEach(vendaDto -> {

                List<VendaItem>vendaItemList = new ArrayList<>();
                vendaDto.getVendaItens().forEach(vendaItemDto -> {
                    var vendaItem = VendaItem.builder()
                            .id(vendaItemDto.getCatalogoId())
                            .venda(vendaItemDto.getVenda())
                            .precoUnitario(vendaItemDto.getPrecoUnitario())
                            .quantidade(vendaItemDto.getQuantidade())
                            .build();
                    vendaItemList.add(vendaItem);
                });
                Venda venda = Venda.builder()
                        .cliente(vendaDto.getIdCliente())
                        .id(vendaDto.getId())
                        .data(vendaDto.getDataDeVenda())
                        .itens(vendaItemList)
                        .build();
                vendaRepository.save(venda);
            });
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
