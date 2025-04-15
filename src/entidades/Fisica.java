package entidades;


import java.util.ArrayList;
import java.util.List;


public class Fisica extends Pessoa {
 
 private String cpf;
 private List<Pedido> pedidos;

 public Fisica(String nome, String endereco, String cpf) {
    super(nome, endereco);
    this.cpf = cpf;
    this.pedidos = new ArrayList<>();
 }

 public String getCpf() {
    return cpf;
 }

 public void setCpf(String cpf) {
    this.cpf = cpf;
 }

 public void fazerPedido(Restaurante restaurante, List<ItemPedido> itens) {
    Pedido pedido = new Pedido(restaurante, itens);
    pedidos.add(pedido);
    System.out.printf("Pedido realizado com sucesso! Valor total: R$ %.2f%n",
    pedido.calcularTotal());
 }

 public List<Pedido> getPedidos() {
    return pedidos;
 }
 public void setPedidos(List<Pedido> pedidos) {
    this.pedidos = pedidos;
 }
}
