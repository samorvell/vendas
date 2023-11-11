package br.com.samorvell.vendas.controller;

import br.com.samorvell.vendas.model.Cliente;
import br.com.samorvell.vendas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/cliente/{cpf}")
    public ResponseEntity<Cliente> buscarPeloCpf(@Valid @PathVariable String cpf){
        Cliente resultado = service.buscarPeloCPF(cpf);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.notFound().build();
    }
}
