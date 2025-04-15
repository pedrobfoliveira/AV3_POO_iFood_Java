package entidades;

import java.util.ArrayList;
import java.util.List;


public class Juridica extends Pessoa {
    private String cnpj;
    private List<Restaurante> restaurantes;

    public Juridica(String nome, String endereco, String cnpj) {
    super(nome, endereco);
    this.cnpj = cnpj;
    this.restaurantes = new ArrayList<>();
 }
 public String getCnpj() {
    return cnpj;
 }

 public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
 }

 public List<Restaurante> getRestaurantes() {
    return restaurantes;
 }

 public void adicionarRestaurante(Restaurante restaurante) {
    restaurantes.add(restaurante);
    System.out.println("Restaurante adicionado com sucesso ao CNPJ " + cnpj);
 }

 public void setRestaurantes(List<Restaurante> restaurantes) {
    this.restaurantes = restaurantes;
 }
}
