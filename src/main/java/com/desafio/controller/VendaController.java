package com.desafio.controller;/*
 * @project desafioM
 * @author matheuslongo on 01/10/2022.
 */

import com.desafio.dto.VendaDto;
import com.desafio.model.Venda;
import com.desafio.service.VendaItemService;
import com.desafio.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private VendaItemService vendaItemService;

    @PostMapping
    public ResponseEntity<?> cargaAllVendas(@RequestBody List<VendaDto> vendaDtoList) {
        try {
            vendaItemService.persistAll(vendaDtoList);
            return ResponseEntity.status(HttpStatus.CREATED).body("CARGA REALIZADA COM SUCESSO!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("FALHA AO PERSISTIR AS VENDAS");
    }

    @GetMapping("/buscaPorNome/{nome}")
    public ResponseEntity<?> findByCliente(@PathVariable(value = "nome") String nome) {
        return ResponseEntity.ok(vendaService.findVendaByName(nome));
    }

}
