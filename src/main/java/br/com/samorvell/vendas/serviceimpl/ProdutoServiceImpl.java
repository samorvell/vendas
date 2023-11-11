package br.com.samorvell.vendas.serviceimpl;

import br.com.samorvell.vendas.dao.ProdutoDao;
import br.com.samorvell.vendas.model.Categoria;
import br.com.samorvell.vendas.model.Produto;
import br.com.samorvell.vendas.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoDao produtoDao;

    @Override
    public Produto inserirNovoProduto(Produto produto) {
        try{
            produtoDao.save(produto);
            return produto;
        }
        catch (Exception exception){
            System.out.println("-------ProdutoService.inserirNovoProduto -------");
            exception.printStackTrace();
            System.out.println("------------------------------------------------");
        }
        return null;
    }

    @Override
    public Produto alterarProduto(Produto produto) {
        try{
            produtoDao.save(produto);
            return produto;
        }
        catch (Exception exception){
            System.out.println("-------ProdutoService.alteraProduto -------");
            exception.printStackTrace();
            System.out.println("-------------------------------------------");
        }
        return null;
    }

    @Override
    public ArrayList<Produto> listarTodos() {
        return (ArrayList<Produto>)produtoDao.findAll();
    }

    @Override
    public ArrayList listarDisponiveis() {
        return produtoDao.findAllByDisponivel(1); //Considerando todos os produtos 1 como disponveis
    }

    @Override
    public ArrayList<Produto> listaPorCategoria(Categoria categoria) {
        return produtoDao.findAllByDisponivelAndCategoria(1, categoria);
    }

    @Override
    public ArrayList<Produto> listarIndisponiveis() {
        return produtoDao.findAllByDisponivel(0);
    }

    @Override
    public Produto recuperarPorId(int id) {
        return produtoDao.findById(id).orElse(null);
    }


}
