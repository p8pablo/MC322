import java.time.*;
import java.util.*;

public class ClientePF extends Cliente {

  private String cpf;
  private String genero;
  private LocalDate dataLicenca;
  private String educacao;
  private LocalDate dataNascimento;
  private String classeEconomica;

  //Construtor
  public ClientePF(
    String nome,
    String endereco,
    LocalDate dataLicenca,
    String educacao,
    String genero,
    String classeEconomica,
    ArrayList<Veiculo> listaVeiculos,
    double valorSeguro,
    final String cpf,
    LocalDate dataNascimento
  ) throws Exception {
    super(nome, endereco, listaVeiculos, valorSeguro);
    this.genero = genero;
    this.dataLicenca = dataLicenca;
    this.educacao = educacao;
    this.dataNascimento = dataNascimento;
    this.classeEconomica = classeEconomica;
    if (Validacao.validarCpf(Validacao.formatarCpf(cpf))) {
      this.cpf = cpf;
      
    }else{
      throw new Exception("CPF invalido");
    }
  }

  //Getters e Setters

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

  public LocalDate getDataLicenca() {
    return this.dataLicenca;
  }

  public void setDataLicenca(LocalDate dataLicenca) {
    this.dataLicenca = dataLicenca;
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

  //Calcular Score
  public double calculaScore(){
    int idade = 2023 - dataNascimento.getYear();
    if (idade < 30) {
    return  CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_18_30.getFator() * getListaVeiculos().size();
    } else if (idade < 60) {
      return  CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_30_60.getFator() * getListaVeiculos().size();
    } else{
      return  CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_60_90.getFator() * getListaVeiculos().size();
    }
  }

  //toString
  @Override
  public String toString() {
    return (
      "Nome: " +
      getNome() +
      "\n" +
      "CPF: " +
      getCpf() +
      "\n" +
      "Gênero " +
      getGenero() +
      "\n" +
      "Data Licenca: " +
      getDataLicenca() +
      "\n" +
      "Educação: " +
      getEducacao() +
      "\n" +
      "Data Nascimento: " +
      getDataNascimento() +
      "\n" +
      "Classe Economica: " +
      getClasseEconomica() +
      "\n"
    );
  }
}
