package com.desafio.service;/*
 * @project desafioM
 * @author matheuslongo on 01/10/2022.
 */

import com.desafio.dto.ClienteDto;
import com.desafio.dto.VendaDTO;
import com.desafio.model.Cliente;
import com.desafio.model.Venda;
import com.desafio.repository.VendaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;


    public boolean save(Venda venda){
        try {
            vendaRepository.save(venda);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveAll(List<Venda> vendaList){
        try {
            vendaRepository.saveAll(vendaList);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean persistAll(List<VendaDTO>vendaDTOList){
        try {
            vendaDTOList.forEach(vendaDTO -> {
                Venda venda = new Venda();
                BeanUtils.copyProperties(vendaDTO, venda);
               if(!save(venda)){
                   System.out.println("VENDA NAO PERSISTIDA: " + venda.getId());
               }
            });
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
