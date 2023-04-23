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
    String cpf,
    LocalDate dataNascimento
  ) {
    super(nome, endereco, listaVeiculos);
    this.cpf = cpf;
    this.genero = genero;
    this.dataLicenca = dataLicenca;
    this.educacao = educacao;
    this.dataNascimento = dataNascimento;
    this.classeEconomica = classeEconomica;
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

  // Formatar CPF
  public static String formatarCpf(String cpf) {
    cpf = cpf.replaceAll("\\.", "");
    cpf = cpf.replaceAll("-", "");
    return cpf;
  }

  // Validar CPF
  public static boolean validarCpf(String cpf) {
    // Verificar 11 digitos
    int n = cpf.length();
    int tamanho = 11;
    if (n != tamanho) {
      return false;
    }
    // Verificar se todos numeros sao iguais
    int diferenteAnterior = 0;
    for (int i = 1; i < n; i++) {
      if (cpf.charAt(i) != cpf.charAt(i - 1)) {
        diferenteAnterior++;
      }
    }
    if (diferenteAnterior == 0) {
      return false;
    }

    // Algoritmo para definir validade do CPF
    int soma1dig = 0;
    int multiplicador1 = 2;
    for (int i = 8; i >= 0; i--) {
      int valor = Character.getNumericValue(cpf.charAt(i));
      soma1dig += multiplicador1 * valor;
      multiplicador1++;
    }
    int resto1 = soma1dig % 11;
    if (resto1 < 2) {
      if (cpf.charAt(9) != '0') {
        return false;
      }
    } else {
      int digito = 11 - resto1;
      if (digito != Character.getNumericValue(cpf.charAt(9))) {
        return false;
      }
    }
    int soma2dig = 0;
    int multiplicador2 = 2;
    for (int i = 9; i >= 0; i--) {
      int valor = Character.getNumericValue(cpf.charAt(i));
      soma2dig += multiplicador2 * valor;
      multiplicador2++;
    }
    int resto2 = soma2dig % 11;
    if (resto2 < 2) {
      if (cpf.charAt(10) != '0') {
        return false;
      }
    } else {
      int digito2 = 11 - resto2;
      if (digito2 != Character.getNumericValue(cpf.charAt(10))) {
        return false;
      }
    }
    return true;
  }

  //toString
  @Override
  public String toString() {
    return 
      "Nome: "+ getNome() + "\n" +
      "CPF: " + getCpf() + "\n" +
      "Gênero " + getGenero() + "\n" +
      "Data Licenca: " + getDataLicenca() + "\n" +
      "Educação: " + getEducacao() + "\n" +
      "Data Nascimento: " + getDataNascimento() + "\n" +
      "Classe Economica: " + getClasseEconomica() + "\n" 
      ;
  }
  
  
}
