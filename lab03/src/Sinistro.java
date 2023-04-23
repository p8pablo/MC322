import java.time.LocalDate;
import java.util.*;

public class Sinistro {

  private final int id;
  private LocalDate data;
  private String endereco;
  private Seguradora seguradora;
  private Veiculo veiculo;
  private Cliente cliente;

  //Construtor
  public Sinistro(
    final int id,
    LocalDate data,
    String endereco,
    Seguradora seguradora,
    Veiculo veiculo,
    Cliente cliente
  ) {
    this.data = data;
    this.endereco = endereco;
    Random gerarInteiro = new Random();
    this.id = gerarInteiro.nextInt();
    this.cliente = cliente;
    this.seguradora = seguradora;
    this.veiculo = veiculo;
  }

  //Getters e Setters
  public int getId() {
    return id;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public Seguradora getSeguradora() {
    return this.seguradora;
  }

  public void setSeguradora(Seguradora seguradora) {
    this.seguradora = seguradora;
  }

  public Veiculo getVeiculo() {
    return this.veiculo;
  }

  public void setVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  //toString

  @Override
  public String toString() {
    return 
      "ID: " + getId() + "\n" +
      "Data: " + getData() + "\n" +
      "Endereco: " + getEndereco() + "\n" +
      "Seguradora: " + getSeguradora().getNome() + "\n" +
      "Veiculo: " + veiculo.toString() + "\n" +
      "Cliente: " + getCliente().getNome() + "\n" 
      ;
  }

  
}
