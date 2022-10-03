package com.desafio.controller;/*

 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */

import com.desafio.dto.CatalogoDto;
import com.desafio.model.Catalogo;
import com.desafio.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

    @Autowired
    CatalogoService catalogoService;


    @GetMapping("/buscarporid/{id}")
    public ResponseEntity<?> findCatalogoById(@PathVariable(value = "id") String id) {
        Optional<Catalogo> catalogoOptional = catalogoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(catalogoOptional.get());
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<?> findAllCatalogo() {
        return ResponseEntity.status(HttpStatus.OK).body(catalogoService.findAll());
    }

    @GetMapping("/buscar/{nome}")
    public ResponseEntity<?> findCatalogoByName(@PathVariable(value = "nome") String Nome) {
        Optional<Catalogo> catalogoOptional = catalogoService.findByNome(Nome);
        return ResponseEntity.status(HttpStatus.OK).body(catalogoOptional.get());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deleteItemCatalogo(@PathVariable(value = "id") String id) {
        Optional<Catalogo> catalogoOptional = catalogoService.findById(id);
        catalogoService.delete(catalogoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("DELETADO" + catalogoService.findById(id) + "COM SUCESSO");
    }

    @GetMapping("/bebidaMaisForte")
    public ResponseEntity<?> findBebidaMaisForte() {
        return ResponseEntity.status(HttpStatus.OK).body(catalogoService.findByMaiorValorAlcoolico());
    }

    @GetMapping("/bebidaMaisFraca")
    public ResponseEntity<?> findBebidaMaisFraca() {
        return ResponseEntity.status(HttpStatus.OK).body(catalogoService.findByMenorValorAlcoolico());
    }

    @PostMapping
    public ResponseEntity<Object> saveCatalogo(@RequestBody List<CatalogoDto> catalogoDto) {
        catalogoService.save(catalogoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("PERSSISTIDO COM SUCESSO");
    }

    @GetMapping("/buscaPorParteDoNome/{nome}")
    public ResponseEntity<?> findBebidaByContainsNome(@PathVariable(value = "nome") String nome){
        return ResponseEntity.ok(catalogoService.findByContainsName(nome));
    }

}
