package br.com.samorvell.vendas.services;

import br.com.samorvell.vendas.model.Cliente;

public interface ClienteService {
    Cliente buscarPeloCPF(String cpf);
    Cliente atualizarDados(Cliente dadosOriginais);
}
