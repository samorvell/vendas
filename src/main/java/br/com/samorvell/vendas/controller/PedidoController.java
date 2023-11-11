package br.com.samorvell.vendas.controller;

import br.com.samorvell.vendas.model.Cliente;
import br.com.samorvell.vendas.model.Pedido;
import br.com.samorvell.vendas.services.ClienteService;
import br.com.samorvell.vendas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.Date;

@CrossOrigin("*")
@RestController
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> inserirNovoPedido(@RequestBody Pedido novo){

        novo.setDataPedido(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        System.out.println("--------PEDIDO---------");
        System.out.println(novo.getObservacoes());
        System.out.println(novo.getDataPedido());
        System.out.println(novo.getItensPedido());

        System.out.println("-------------------------");

        //antes de gravar o pedido preciso incluir o pedido na base
        Cliente cli = clienteService.atualizarDados(novo.getCliente());
        novo.setCliente(cli);

        //saval novo pedido na base
        novo = pedidoService.inserirPedido(novo);
        if(novo != null){
            return ResponseEntity.status(201).body(novo);
        }
        else {
            return ResponseEntity.status(400).build();
        }
    }
}
