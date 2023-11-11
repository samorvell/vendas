package br.com.samorvell.vendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_seq")
    private int numSeq;

    @Column(name = "qtd_item")
    private int qtdItem;

    @Column(name = "preco_unitario")
    private double precoUnitario;

    @Column(name = "preco_total")
    private double precoTotal;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @JsonIgnoreProperties("itensPedidos")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedido;

    @Override
    public String toString() {
        return "ItemPedido{" +
                "numSeq=" + numSeq +
                ", qtdItem=" + qtdItem +
                ", precoUnitario=" + precoUnitario +
                ", precoTotal=" + precoTotal +
                ", pedido=" + pedido +
                ", produto=" + produto.getId() +
                ", itensPedido=" + itensPedido +
                '}';
    }

    public int getNumSeq() {
        return numSeq;
    }

    public void setNumSeq(int numSeq) {
        this.numSeq = numSeq;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
