import java.time.*;
import java.util.*;

public class ClientePF extends Cliente {

  private String cpf;
  private String genero;
  private String educacao;
  private LocalDate dataNascimento;
  private String classeEconomica;
  private ArrayList<Veiculo> listaVeiculos;

  //Construtor
  public ClientePF(
    String nome,
    String endereco,
    String educacao,
    String genero,
    String classeEconomica,
    ArrayList<Veiculo> listaVeiculos,
    final String cpf,
    LocalDate dataNascimento,
    String email,
    String telefone
  ) throws Exception {
    super(nome, endereco, email, telefone);
    this.genero = genero;

    this.educacao = educacao;
    this.dataNascimento = dataNascimento;
    this.classeEconomica = classeEconomica;
    this.listaVeiculos = new ArrayList<Veiculo>();
    if (Validacao.validarCpf(Validacao.formatarCpf(cpf))) {
      this.cpf = cpf;
    } else {
      throw new Exception("CPF invalido");
    }
  }

  //Getters e Setters
  @Override
  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public LocalDate getDataNascimento() {
    return this.dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getGenero() {
    return this.genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }


  public String getEducacao() {
    return this.educacao;
  }

  public void setEducacao(String educacao) {
    this.educacao = educacao;
  }

  public String getClasseEconomica() {
    return this.classeEconomica;
  }

  public void setClasseEconomica(String classeEconomica) {
    this.classeEconomica = classeEconomica;
  }

  public ArrayList<Veiculo> getListaVeiculos() {
    return this.listaVeiculos;
  }

  public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
    this.listaVeiculos = listaVeiculos;
  }

  //pegar veiculo com nome do cliente
  public Veiculo getVeiculo(String nextLine) {
    for (Veiculo veiculo : listaVeiculos) {
      if (veiculo.getPlaca() == nextLine) {
        return veiculo;
      }
    }
    return null;
  }

  //cadastrar veiculo
  public boolean cadastrarVeiculo(Veiculo veiculo) {
    for (Veiculo veiculos : listaVeiculos) {
      if (veiculos.getPlaca() == veiculo.getPlaca()) {
        System.out.println("Veículo com placa já cadastrada!");
        return false;
      }
    }
    listaVeiculos.add(veiculo);
    return true;
  }

  //remover veiculo
  public boolean removerVeiculo(Veiculo veiculo) {
    for (Veiculo veiculos : listaVeiculos) {
      if (veiculos.getPlaca() == veiculo.getPlaca()) {
        listaVeiculos.remove(veiculo);
        return true;
      }
    }
    System.out.println("Veículo inexistente!");
    return false;
  }

  //toString

  @Override
  public String toString() {
    return "{" +
      "cpf='" + getCpf() + "'" + "\n"+
      "genero='" + getGenero() + "'" +"\n"+
      "educacao='" + getEducacao() + "'" +"\n"+
      "dataNascimento='" + getDataNascimento() + "'" +"\n"+
      "classeEconomica='" + getClasseEconomica() + "'" +"\n"+
      "listaVeiculos='" + getListaVeiculos() + "'" +"\n"+
      "}";
  }
  
}
