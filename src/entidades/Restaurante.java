package entidades;


import java.util.ArrayList;
import java.util.List;


public class Restaurante {
    private String nome;
    private CategoriaRestaurante categoria;
    private Juridica dono;
    private List<ItemCardapio> cardapio;

 public Restaurante(String nome, CategoriaRestaurante categoria, Juridica dono) {
    this.nome = nome;
    this.categoria = categoria;
    this.dono = dono;
    this.cardapio = new ArrayList<>();
 }

 public String getNome() {
    return nome;
 }

 public List<ItemCardapio> getCardapio() {
    return cardapio;
 }

 public void setNome(String nome) {
    this.nome = nome;
 }

 public CategoriaRestaurante getCategoria() {
    return categoria;
 }

 public void setCategoria(CategoriaRestaurante categoria) {
    this.categoria = categoria;
 }

 public Juridica getDono() {
    return dono;
 }

 public void setDono(Juridica dono) {
    this.dono = dono;
 }

 public void setCardapio(List<ItemCardapio> cardapio) {
    this.cardapio = cardapio;
 }
 
}
