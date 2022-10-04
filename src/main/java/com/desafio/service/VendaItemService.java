package com.desafio.service;/*
 * @project desafioM
 * @author matheuslongo on 01/10/2022.
 */

import com.desafio.dto.VendaDto;
import com.desafio.model.Catalogo;
import com.desafio.model.Cliente;
import com.desafio.model.Venda;
import com.desafio.model.VendaItem;
import com.desafio.repository.CatalogoRepository;
import com.desafio.repository.ClinteRepository;
import com.desafio.repository.VendaItemRepository;
import com.desafio.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class VendaItemService {

    @Autowired
    private VendaItemRepository vendaItemRepository;

    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private ClinteRepository clinteRepository;

    @Autowired
    private VendaRepository vendaRepository;

    public boolean save(VendaItem vendaItem) {
        try {
            vendaItemRepository.save(vendaItem);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cliente cliente(String id){
        Optional<Cliente> clienteOptional = clinteRepository.findById(id);
       return clienteOptional.get();
    }

    public Venda venda(String id){
        Optional<Venda> vendaOptional = vendaRepository.findById(id);
        return vendaOptional.get();
    }

    public Catalogo catalogo(String id){
        catalogoRepository.findById(id);
        Optional<Catalogo> catalogoOptional = catalogoRepository.findById(id);
        return catalogoOptional.get();
    }

    public boolean persistAll(List<VendaDto> vendaDtoList) {
        try {
            vendaDtoList.forEach(vendaDto -> {

                Venda venda = Venda.builder()
                        .cliente(clinteRepository.findById(vendaDto.getIdCliente()).get())
                        .id(vendaDto.getId())
                        .data(LocalDateTime.from((vendaDto.getDataDeVenda())))
                        .build();

                List<VendaItem> vendaItemList = new ArrayList<>();
                vendaDto.getVendaItens().forEach(vendaItemDto -> {
                    var vendaItem = VendaItem.builder()
                            .venda(venda)
                            .catalogo(catalogo(vendaItemDto.getCatalogoId()))
                            .quantidade(vendaItemDto.getQuantidade())
                            .precoUnitario(vendaItemDto.getPrecoUnitario())
                            .build();
                    vendaItemList.add(vendaItem);
                });
                venda.setItens(vendaItemList);
                vendaRepository.save(venda);
            });

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
