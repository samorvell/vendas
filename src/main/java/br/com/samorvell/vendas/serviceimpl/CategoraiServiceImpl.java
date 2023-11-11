package br.com.samorvell.vendas.serviceimpl;

import br.com.samorvell.vendas.dao.CategoriaDao;
import br.com.samorvell.vendas.model.Categoria;
import br.com.samorvell.vendas.services.CategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class CategoraiServiceImpl implements CategoriaService {

    private static final Logger logger = LoggerFactory.getLogger(CategoraiServiceImpl.class);

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public Categoria inserirNovaCategoria(Categoria categoria) {

        try{
            if(categoria.getName() != null && categoria.getName().trim().length() > 0){
                categoriaDao.save(categoria);
                return categoria;
            }

        }catch (IllegalArgumentException ex){
            logger.error("DEBUG = ", ex.getMessage());
        }catch (Exception exception){
            logger.error("DEBUG = " ,exception.getMessage());
        }
        return null;
    }

    @Override
    public Categoria alterarCategoria(Categoria categoria) {
        try{
            if(categoria.getName() != null && categoria.getName().trim().length() > 0){
                categoriaDao.save(categoria);
                return categoria;
            }
        }catch (Exception ex){
            System.out.println("DEBUG = " + ex.getMessage());
        }

        return null;
    }

    @Override
    public ArrayList<Categoria> recuperarTodasCategorias() {

        return (ArrayList<Categoria>)categoriaDao.findAll() ;
    }

    @Override
    public ArrayList<Categoria> recuperarPorPalavraChave(String palavraChave) {
        if(palavraChave != null){
            return categoriaDao.findByNameContaining(palavraChave);
        }
        return null;

    }
}
