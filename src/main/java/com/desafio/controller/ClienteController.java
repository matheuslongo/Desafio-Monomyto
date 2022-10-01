package com.desafio.controller;/*
 * @project desafio
 * @author matheuslongo on 28/09/2022.
 */

import com.desafio.dto.ClienteDto;
import com.desafio.model.Cliente;
import com.desafio.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody List<ClienteDto> clienteDto) {
            clienteService.persistir(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("PERSSISTIDO COM SUCESSO");

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") String id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
    }

    @GetMapping("/{nome}/busca")
    public ResponseEntity<Object> getClienteByNome(@PathVariable(value = "nome") String nome) {
        Optional<Cliente> clienteOptional = clienteService.findByNome(nome);
        return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
    }

    @GetMapping("/buscaPorParteDoNome/{nome}")
    public ResponseEntity<?> getClienteByContainsNome(@PathVariable(value = "nome") String nome){
        return ResponseEntity.ok(clienteService.findByContainsName(nome));
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<?> findAllClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deleteClienteById(@PathVariable(value = "id") String id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        clienteService.delete(clienteOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("DELETADO COM SUCESSO");
    }

}
