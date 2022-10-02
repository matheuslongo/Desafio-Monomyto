package com.desafio.service;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */


import com.desafio.dto.ClienteDto;
import com.desafio.model.Cliente;
import com.desafio.repository.ClinteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClinteRepository clinteRepository;

    @Autowired
    EntityManager entityManager;

    public void persistir(List<ClienteDto> clienteDto) {
        List<ClienteDto> list = new ArrayList<>();
        for (ClienteDto item : clienteDto) {
            var clienteDtos = ClienteDto.builder()
                    .id(item.getId())
                    .dataNascimento(item.getDataNascimento())
                    .nome(item.getNome())
                    .build();
            list.add(clienteDtos);
            Cliente cliente = new Cliente();
            BeanUtils.copyProperties(clienteDtos, cliente);
            clinteRepository.save(cliente);
        }
    }

    public Optional<Cliente> findById(String id) {
        return clinteRepository.findById(id);
    }

    public List<Cliente> findByNome(String nome) {
        return clinteRepository.findByNome(nome);
    }

    public List<Cliente> findAll() {
        return clinteRepository.findAll();
    }

    @Transactional
    public void delete(Cliente cliente) {
        clinteRepository.delete(cliente);
    }

    public List<Cliente> findByContainsName(String nome){
        return clinteRepository.findByNomeContains(nome);
    }

}

