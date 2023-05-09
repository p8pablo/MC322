
import java.util.ArrayList;
public class Cliente {

  private String nome;
  private String endereco;
  private ArrayList<Veiculo> listaVeiculos;
  private double valorSeguro;

  // Construtor
  public Cliente(
    String nome,
    String endereco,
    ArrayList<Veiculo> listaVeiculos,
    double valorSeguro
  ) {
    this.nome = nome;
    this.endereco = endereco;
    this.listaVeiculos = new ArrayList<Veiculo>();
    this.valorSeguro = valorSeguro;
  }
  
  //Calcula Score
  public double calculaScore(){
    return 0;
  }

  // Getters e Setters

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public ArrayList<Veiculo> getListaVeiculos() {
    return this.listaVeiculos;
  }

  public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
    this.listaVeiculos = listaVeiculos;
  }

  public double getValorSeguro() {
    return this.valorSeguro;
  }

  public void setValorSeguro(double valorSeguro) {
    this.valorSeguro = valorSeguro;
  }

//toString

  @Override
  public String toString() {
    return "{" +
      " nome='" + getNome() + "'" +
      ", endereco='" + getEndereco() + "'" +
      ", listaVeiculos='" + getListaVeiculos() + "'" +
      "}";
  }
//pegar veiculo com nome do cliente
  public Veiculo getVeiculo(String nextLine) {
    for (Veiculo veiculo : listaVeiculos) {
      if (veiculo.getPlaca()==nextLine) {
        return veiculo;
      }
    }
    return null;
  }

 
}
