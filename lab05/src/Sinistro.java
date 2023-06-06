import java.time.LocalDate;
import java.util.*;

public class Sinistro {

  private final int id;
  private LocalDate data;
  private String endereco;
  private Condutor condutor;
  private Seguro seguro;

  //Construtor
  public Sinistro(
    final int id,
    LocalDate data,
    String endereco,
    Condutor condutor,
    Seguro seguro
  ) {
    this.data = data;
    this.endereco = endereco;
    Random gerarInteiro = new Random();
    this.id = gerarInteiro.nextInt();
    this.condutor = condutor;
    this.seguro = seguro;
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

  public Condutor getCondutor() {
    return this.condutor;
  }

  public void setCondutor(Condutor condutor) {
    this.condutor = condutor;
  }

  public Seguro getSeguro() {
    return this.seguro;
  }

  public void setSeguro(Seguro seguro) {
    this.seguro = seguro;
  }


  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", data='" + getData() + "'" +
      ", endereco='" + getEndereco() + "'" +
      ", condutor='" + getCondutor() + "'" +
      ", seguro='" + getSeguro() + "'" +
      "}";
  }


  
}
