package entidades;


public class ItemCardapio {
    private String nome;
    private String descricao;
    private double preco;
    public ItemCardapio(String nome, String descricao, double preco) {
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
 }
 public String getNome() {
    return nome;
 }

 public double getPreco() {
    return preco;
 }

 public void setNome(String nome) {
    this.nome = nome;
 }

 public String getDescricao() {
    return descricao;
 }

 public void setDescricao(String descricao) {
    this.descricao = descricao;
 }
 public void setPreco(double preco) {
    this.preco = preco;
 }
 
}
