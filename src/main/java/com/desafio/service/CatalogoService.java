package com.desafio.service;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */

import com.desafio.dto.CatalogoDto;
import com.desafio.dto.MaiorValorAlcolicoDto;
import com.desafio.dto.MenorValorAlcolicoDto;
import com.desafio.model.Catalogo;
import com.desafio.repository.CatalogoRepository;
import org.hibernate.jpa.QueryHints;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class CatalogoService {

    @Autowired
    CatalogoRepository catalogoRepository;
    @Autowired
    EntityManager entityManager;

    public void save(List<CatalogoDto> catalogoDto){
        try {
        List<CatalogoDto> list = new ArrayList<>();
            for (CatalogoDto item : catalogoDto) {
                var catalogosDtos = CatalogoDto.builder()
                        .id(item.getId())
                        .marca(item.getMarca())
                        .regiao(item.getRegiao())
                        .nome(item.getNome())
                        .classificacao(item.getClassificacao())
                        .precoAtual(item.getPrecoAtual())
                        .teorAlcoolico(item.getTeorAlcoolico())
                        .build();
                list.add(catalogosDtos);
                Catalogo catalogo = new Catalogo();
                BeanUtils.copyProperties(catalogosDtos, catalogo);
                catalogoRepository.save(catalogo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Optional<Catalogo> findById(String id){return catalogoRepository.findById(id);}

    public Optional<Catalogo> findByNome(String nome) {
        return catalogoRepository.findByNome(nome);
    }

    public List<Catalogo> findAll(){
        return catalogoRepository.findAll();
    }

    @Transactional
    public void delete(Catalogo catalogo){
        catalogoRepository.delete(catalogo);
    }

    public MaiorValorAlcolicoDto findByMaiorValorAlcolico() {

        StringBuilder sql = new StringBuilder()
                .append("SELECT id, classificacao, marca, nome, preco_atual, regiao, teor_alcoolico\n" +
                        "    from catalogo\n" +
                        "    where teor_alcoolico = " +
                        "(SELECT MAX(teor_alcoolico) as " +
                        "BEBIDA_MAIS_FORTE  from catalogo);");

        @SuppressWarnings("unchecked")
        Tuple tuplas = (Tuple) entityManager.createNativeQuery(sql.toString(), Tuple.class)
                .setHint(QueryHints.HINT_READONLY, true)
                .getSingleResult();
        MaiorValorAlcolicoDto maiorValorAlcolicoDto = MaiorValorAlcolicoDto.builder()
                .regiao(tuplas.get(5).toString())
                .classificacao(tuplas.get(1).toString())
                .nome(tuplas.get("nome").toString())
                .preco_atual(Double.valueOf(tuplas.get(4).toString()))
                .marca(tuplas.get(2).toString())
                .teor_alcoolico(Double.valueOf(tuplas.get(6).toString()))
                .build();
        return maiorValorAlcolicoDto;
    } ;

    public MenorValorAlcolicoDto findByMenorValorAlcolico() {

        StringBuilder sql = new StringBuilder()
                .append("SELECT id, classificacao, marca, nome, preco_atual, regiao, teor_alcoolico\n" +
                        "    from catalogo\n" +
                        "    where teor_alcoolico = " +
                        "(SELECT MIN(teor_alcoolico) as " +
                        "BEBIDA_MAIS_FORTE  from catalogo);");

        @SuppressWarnings("unchecked")
        Tuple tuplas = (Tuple) entityManager.createNativeQuery(sql.toString(), Tuple.class)
                .setHint(QueryHints.HINT_READONLY, true)
                .getSingleResult();
        MenorValorAlcolicoDto menorValorAlcolicoDtos = MenorValorAlcolicoDto.builder()
                .regiao(tuplas.get(5).toString())
                .classificacao(tuplas.get(1).toString())
                .nome(tuplas.get("nome").toString())
                .preco_atual(Double.valueOf(tuplas.get(4).toString()))
                .marca(tuplas.get(2).toString())
                .teor_alcoolico(Double.valueOf(tuplas.get(6).toString()))
                .build();
        return menorValorAlcolicoDtos;
    } ;

}

