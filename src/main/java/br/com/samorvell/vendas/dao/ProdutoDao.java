package br.com.samorvell.vendas.dao;

import br.com.samorvell.vendas.model.Categoria;
import br.com.samorvell.vendas.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProdutoDao extends CrudRepository<Produto, Integer> {

    //query by method name
    ArrayList<Produto> findAllByCategoria(Categoria categoria);
    ArrayList<Produto> findAllByDisponivel(int disponivel);
    ArrayList<Produto> findAllByDisponivelAndCategoria(int disponivel, Categoria categoria);


}
