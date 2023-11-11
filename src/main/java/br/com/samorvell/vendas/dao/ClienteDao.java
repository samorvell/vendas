package br.com.samorvell.vendas.dao;

import br.com.samorvell.vendas.model.Cliente;
import ch.qos.logback.core.net.server.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {

    Cliente findByEmailOrTelefone(String email, String telefone);

    Cliente findByTelefone(String telefone);

    Cliente findByCpf(String cpf);
}
