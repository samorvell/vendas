package br.com.samorvell.vendas.serviceimpl;

import br.com.samorvell.vendas.dao.PedidoDao;
import br.com.samorvell.vendas.model.ItemPedido;
import br.com.samorvell.vendas.model.Pedido;
import br.com.samorvell.vendas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDao pedidoDao;

    @Override
    public Pedido inserirPedido(Pedido novo) {
        try{
            double total = 0.0;
            //regra de desconto
            for(ItemPedido item: novo.getItensPedido()){
                item.setPrecoUnitario(item.getProduto().getPreco());
                if (item.getQtdItem() >= 5){ //desconto 20%
                    item.setPrecoTotal(item.getPrecoUnitario() * item.getQtdItem() * 0.8);
                }
                else {
                    item.setPrecoTotal(item.getPrecoUnitario() * item.getQtdItem()) ;
                }
                total += item.getPrecoTotal();
            }
            /*Aqui vem as regras de negocio. */
            for (ItemPedido item: novo.getItensPedido()){
                item.setPedido(novo);
            }
            novo.setValorTotal(total);
            pedidoDao.save(novo);
            return novo;
        }
        catch (Exception ex){
            return null;
        }
    }
}
