package br.com.samorvell.vendas.dao;

import br.com.samorvell.vendas.model.Cliente;
import br.com.samorvell.vendas.model.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PedidoDao extends CrudRepository<Pedido, Integer> {

    ArrayList<Pedido> findByCliente(Cliente cliente);
}
