package br.com.samorvell.vendas.serviceimpl;

import br.com.samorvell.vendas.dao.UsuarioDao;
import br.com.samorvell.vendas.model.Usuario;
import br.com.samorvell.vendas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario recuperarUsuario(Usuario original) {
        return usuarioDao.findByUsernameOrEmail(original.getUsername(), original.getEmail());
    }
}
