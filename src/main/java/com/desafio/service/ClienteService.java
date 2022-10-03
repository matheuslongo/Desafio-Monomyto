package com.desafio.service;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */


import com.desafio.dto.ClienteDto;
import com.desafio.model.Cliente;
import com.desafio.repository.ClinteRepository;
import lombok.var;
import org.hibernate.jpa.QueryHints;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.transaction.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClinteRepository clinteRepository;

    @PersistenceContext
    EntityManager entityManager;

    public void persistir(List<ClienteDto> clienteDto) {
      try {
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
      }catch (Exception e){
          e.printStackTrace();
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public List<Cliente> findByIdade(String date){
        return clinteRepository.findByDataNascimento(date);
    }

    public List<ClienteDto> findByIdadeRange(String idadeMenor) {
        try {
            StringBuilder sql = new StringBuilder()
                    .append(" SELECT nome, id, data_de_nascimento FROM monomyto_json.cliente  ")
                    .append(" WHERE cliente.data_de_nascimento   " )
                    .append(" between  :idadeMenor and '2022-02-01' ; ");

            @SuppressWarnings("unchecked")
            List<Tuple> tuplas = (List<Tuple>) entityManager.createNativeQuery(sql.toString(), Tuple.class)
                    .setHint(QueryHints.HINT_READONLY, true)
                    .setParameter("idadeMenor", idadeMenor)
                    .getResultList();
            List<ClienteDto> clienteDto = new ArrayList<>();
            tuplas.forEach(item -> {
                String nome = item.get("nome").toString();
                String data = String.valueOf(LocalDate.parse(item.get("data_de_nascimento").toString()));
                String id = item.get("id").toString();
                ClienteDto clienteDto1 = new ClienteDto(nome, id, data);
                clienteDto.add(clienteDto1);
            });

            return clienteDto;

        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
        return null;
    }

}

