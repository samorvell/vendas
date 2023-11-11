package br.com.samorvell.vendas.serviceimpl;

import br.com.samorvell.vendas.dao.ClienteDao;
import br.com.samorvell.vendas.model.Cliente;
import br.com.samorvell.vendas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClinteServiceImpl implements ClienteService {


    @Autowired
    private ClienteDao clienteDao;

    @Override
    public Cliente buscarPeloCPF(String cpf) {
        return clienteDao.findByCpf(cpf);
    }

    @Override
    public Cliente atualizarDados(Cliente dadosOriginais) {
        return clienteDao.save(dadosOriginais);
    }


}
