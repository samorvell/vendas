package br.com.samorvell.vendas.services;

import br.com.samorvell.vendas.model.Categoria;
import br.com.samorvell.vendas.model.Produto;

import java.util.ArrayList;


public interface ProdutoService {

    Produto inserirNovoProduto(Produto produto);
    Produto alterarProduto(Produto produto);
    ArrayList<Produto> listarTodos();
    ArrayList listarDisponiveis();
    ArrayList<Produto> listaPorCategoria(Categoria categoria);
    ArrayList<Produto> listarIndisponiveis();
    Produto recuperarPorId(int id);
}
