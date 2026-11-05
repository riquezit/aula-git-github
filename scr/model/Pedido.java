package model;

import java.util.ArrayList;

import  model.Cliente;
import model.Produto;

public class Pedido {
    Cliente cliente;
    ArrayList<Produto> produtos;
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setProdutos(Produto produto) {
        produtos.add(produto);
    }
}
