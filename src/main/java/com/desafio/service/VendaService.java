package com.desafio.service;/*
 * @project desafioM
 * @author matheuslongo on 01/10/2022.
 */

import com.desafio.dto.*;
import com.desafio.model.Venda;
import com.desafio.repository.VendaRepository;
import org.hibernate.jpa.QueryHints;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private EntityManager entityManager;

    public boolean save(Venda venda) {
        try {
            vendaRepository.save(venda);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveAll(List<Venda> vendaList) {
        try {
            vendaRepository.saveAll(vendaList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean persistAll(List<VendaDto> vendaDtoList) {
        try {
            vendaDtoList.forEach(vendaDto -> {
                Venda venda = new Venda();
                BeanUtils.copyProperties(vendaDto, venda);
                if (!save(venda)) {
                    System.out.println("VENDA NAO PERSISTIDA: " + venda.getId());
                }
            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<VendaQueryDto> findVendaByName(String nome) {
        try {
            StringBuilder sql = new StringBuilder()
                    .append("SELECT * FROM `monomyto_json`.`venda` where cliente_id =(select  id from monomyto_json.cliente where nome = :nome);");

            @SuppressWarnings("unchecked")
            List<Tuple> tuplas = (List<Tuple>) entityManager.createNativeQuery(sql.toString(), Tuple.class)
                    .setHint(QueryHints.HINT_READONLY, true)
                    .setParameter("nome", nome)
                    .getResultList();
            List<VendaQueryDto> vendaQueryDtoList = new ArrayList<>();
            tuplas.forEach(item -> {
                Timestamp date = (Timestamp) item.get("data_de_venda");
                String id = (String) item.get("id");
                String cliente = (String) item.get("cliente_id");
                VendaQueryDto vendaQueryDto = new VendaQueryDto(date,id,cliente);
                vendaQueryDtoList.add(vendaQueryDto);
            });
            return vendaQueryDtoList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<VendaPorNomeDeProdutoDto> findVendaByProduto(String nome) {
        try {
            StringBuilder sql = new StringBuilder()
                    .append("SELECT *\n" +
                            "FROM `monomyto_json`.`venda_item`\n" +
                            "where catalogo_id =(select  id from monomyto_json.catalogo where nome = :nome);");

            @SuppressWarnings("unchecked")
            List<Tuple> tuplas = (List<Tuple>) entityManager.createNativeQuery(sql.toString(), Tuple.class)
                    .setHint(QueryHints.HINT_READONLY, true)
                    .setParameter("nome", nome)
                    .getResultList();
            List<VendaPorNomeDeProdutoDto> vendaPorNomeDeProdutoDtoList = new ArrayList<>();
            tuplas.forEach(item -> {
                BigInteger id = (BigInteger) item.get("id");
                String venda = (String) item.get("venda_id");
                Double quantidade = (Double) item.get("quantidade");
                Double precoUnitario = (Double) item.get("preco_unitario");
                String catalogo = (String) item.get("catalogo_id");
                VendaPorNomeDeProdutoDto vendaPorNomeDeProdutoDto = new VendaPorNomeDeProdutoDto(id, catalogo, venda , precoUnitario ,quantidade);
                vendaPorNomeDeProdutoDtoList.add(vendaPorNomeDeProdutoDto);
            });
            return vendaPorNomeDeProdutoDtoList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TotalDeVendasClienteDto> findTotalDeVendas(String nome) {
        try {
            StringBuilder sql = new StringBuilder()
                    .append("SELECT COUNT(cliente_id) as total_de_vendas ")
                    .append("FROM `monomyto_json`.`venda` " )
                    .append("where cliente_id =(select  id from monomyto_json.cliente where nome = :nome);");

            @SuppressWarnings("unchecked")
            List<Tuple> tuplas = (List<Tuple>) entityManager.createNativeQuery(sql.toString(), Tuple.class)
                    .setHint(QueryHints.HINT_READONLY, true)
                    .setParameter("nome", nome)
                    .getResultList();
            List<TotalDeVendasClienteDto> totalDeVendasClienteDtosList = new ArrayList<>();
            tuplas.forEach(item -> {
                BigInteger totalDeVendas = (BigInteger) item.get("total_de_vendas");
                TotalDeVendasClienteDto totalDeVendasClienteDto = new TotalDeVendasClienteDto(totalDeVendas);
                totalDeVendasClienteDtosList.add(totalDeVendasClienteDto);
            });
            return totalDeVendasClienteDtosList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TotalDeVendaDeProdutosDto> findTotalDeVendas() {
        try {
            StringBuilder sql = new StringBuilder()
                    .append("select venda_item.catalogo_id, Sum(preco_unitario ) as valor_total_de_vendas ")
                    .append("FROM monomyto_json.venda_item ")
                    .append("group by catalogo_id ;");

            @SuppressWarnings("unchecked")
            List<Tuple> tuplas = (List<Tuple>) entityManager.createNativeQuery(sql.toString(), Tuple.class)
                    .setHint(QueryHints.HINT_READONLY, true)
                    .getResultList();
            List<TotalDeVendaDeProdutosDto> totalDeVendaDeProdutoDtos = new ArrayList<>();
            tuplas.forEach(item -> {
                Double totalDeVendas = (Double) item.get("valor_total_de_vendas");
                String id = (String) item.get("catalogo_id");
                TotalDeVendaDeProdutosDto totalDeVendaDeProdutosDto = new TotalDeVendaDeProdutosDto(id ,totalDeVendas);
                totalDeVendaDeProdutoDtos.add(totalDeVendaDeProdutosDto);
            });
            return totalDeVendaDeProdutoDtos;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
