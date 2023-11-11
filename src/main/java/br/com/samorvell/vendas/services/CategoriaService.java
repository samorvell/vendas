package br.com.samorvell.vendas.services;

import br.com.samorvell.vendas.model.Categoria;

import java.util.ArrayList;

public interface CategoriaService {
    //método receb uma categor śo com o nome preenchi e vai inserir no banco
    Categoria inserirNovaCategoria(Categoria categoria) throws Exception;

    //método alteração de categoria
    Categoria alterarCategoria(Categoria categoria);

    //método recuperar todas as categorias
    ArrayList<Categoria> recuperarTodasCategorias();

    //Método recuperar todas as categorias por palavra chave
    ArrayList<Categoria> recuperarPorPalavraChave(String palavraChave);

}
