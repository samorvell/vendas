package br.com.samorvell.vendas.dao;

import br.com.samorvell.vendas.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

    Usuario findByUsernameOrEmail(String username, String email);
}
