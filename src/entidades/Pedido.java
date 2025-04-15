package entidades;

import java.util.List;


public class Pedido implements GerenciamentoPedido {
    private Restaurante restaurante;
    private List<ItemPedido> itens;
    private boolean fechado;


    public Pedido(Restaurante restaurante, List<ItemPedido> itens) {
    this.restaurante = restaurante;
    this.itens = itens;
    this.fechado = false;
 }

 public double calcularTotal() {
 double total = 0;
 for (ItemPedido item : itens) {
 total += item.calcularSubtotal();
 }
 return total;
 }

 public Restaurante getRestaurante() {
 return restaurante;
 }

 public void setRestaurante(Restaurante restaurante) {
 this.restaurante = restaurante;
 }

 public List<ItemPedido> getItens() {
 return itens;
 }

 public void setItens(List<ItemPedido> itens) {
 this.itens = itens;
 }

 public void fecharPedido(Pedido pedido) {
 if (pedido.fechado) {
 System.out.println("O pedido já foi fechado!");
 } else {
    pedido.fechado = true;
    System.out.printf("Pedido fechado com sucesso! Total a pagar: R$ %.2f%n", pedido.calcularTotal());
   }
 }

 public void listarItensDoPedido(Pedido pedido) {
 if (pedido.getItens().isEmpty()) {
 System.out.println("Nenhum item adicionado ao pedido.");

 } else {
    System.out.println("\n=== Itens do Pedido ===");
    for (ItemPedido item : pedido.getItens()) {
        System.out.printf("Item: %s | Quantidade: %d | Subtotal: R$ %.2f%n",item.getItemCardapio().getNome(), item.getQuantidade(), item.calcularSubtotal());
    }
   }
 }
 
}