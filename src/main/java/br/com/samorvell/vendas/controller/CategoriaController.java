package br.com.samorvell.vendas.controller;


import br.com.samorvell.vendas.model.Categoria;
import br.com.samorvell.vendas.services.CategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin("*")
@RestController
public class CategoriaController {

    private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria")
    public ResponseEntity<ArrayList<Categoria>> listarTodas() {
        return ResponseEntity.ok().body(categoriaService.recuperarTodasCategorias());
    }

    @GetMapping("/categoria/search")
    public ResponseEntity<ArrayList<Categoria>> recuperarPorPalavraChave(@RequestParam(name = "key") String palavraChave) {
        if (palavraChave != null) {
            return ResponseEntity.ok().body(categoriaService.recuperarPorPalavraChave(palavraChave));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/categoria")
    public ResponseEntity<Categoria> adicionarNova(@RequestBody Categoria categoria) {
        Categoria resultado = null;
        try {
            resultado = categoriaService.inserirNovaCategoria(categoria);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resultado);
        if (resultado != null) {
            return ResponseEntity.status(201).body(resultado);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/categoria")
    public ResponseEntity<Categoria> alterarDados(@RequestBody Categoria categoria){
        Categoria resultado = categoriaService.alterarCategoria(categoria);
        if(resultado != null){
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.badRequest().build();
    }

}
