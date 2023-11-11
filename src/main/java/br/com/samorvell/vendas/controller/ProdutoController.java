package br.com.samorvell.vendas.controller;

import br.com.samorvell.vendas.model.Categoria;
import br.com.samorvell.vendas.model.Produto;
import br.com.samorvell.vendas.services.ProdutoService;
import br.com.samorvell.vendas.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@CrossOrigin("*")
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private UploadService uploadService;

    @PostMapping("/produto")
    public ResponseEntity<Produto> novoProduto(@RequestBody Produto produto){
        try{
            produtoService.inserirNovoProduto(produto);
            return ResponseEntity.status(201).body(produto);
        }
        catch (Exception exception){
            exception.printStackTrace();

        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/produto/upload")
    public ResponseEntity<String> updaloadFoto(@RequestParam(name = "arquivo")MultipartFile arquivo){
        String path = uploadService.uploadFile(arquivo);
        if(path != null){
            return ResponseEntity.status(201).body(path);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/produto")
    public ResponseEntity<ArrayList<Produto>> recuperarTodos(){
        return ResponseEntity.ok(produtoService.listarDisponiveis());
    }

    @GetMapping("/produto/categoria/{id}")
    public ResponseEntity<ArrayList<Produto>> recuperarPorCategoria(@PathVariable(name = "id") int id_categoria){
        Categoria categoria = new Categoria();
        categoria.setId(id_categoria);
        return ResponseEntity.ok(produtoService.listaPorCategoria(categoria));
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity <Produto> recuperarPorId(@PathVariable(name = "id") int idProduto){
        Produto produto = produtoService.recuperarPorId(idProduto);
        if(produto != null){
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }


}
