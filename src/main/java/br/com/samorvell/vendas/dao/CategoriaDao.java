package br.com.samorvell.vendas.dao;

import br.com.samorvell.vendas.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CategoriaDao extends CrudRepository<Categoria, Integer> {

    //consultas customizadas
    //1º- categoria por palavras chave
     ArrayList<Categoria> findByNameContaining(String palavra);

}
