import java.util.*;
import java.time.*;
public class ClientePJ extends Cliente {

  private String cnpj;
  private LocalDate dataFundacao;

  //Construtor

  public ClientePJ(
    String cnpj,
    LocalDate dataFundacao,
    String nome,
    String endereco,
    ArrayList<Veiculo> listaVeiculos
  ) {
    super(nome, endereco, listaVeiculos);
    this.cnpj = cnpj;
    this.dataFundacao = dataFundacao;
  }

  //Getters e Setters

  public String getCnpj() {
    return this.cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public LocalDate getDataFundacao() {
    return this.dataFundacao;
  }

  public void setDataFundacao(LocalDate dataFundacao) {
    this.dataFundacao = dataFundacao;
  }

  //Formatar CNPJ
  public static String formatarCnpj(String cnpj) {
    cnpj = cnpj.replaceAll("\\.", "");
    cnpj = cnpj.replaceAll("/", "");
    cnpj = cnpj.replaceAll("-", "");
    return cnpj;
  }

  //Validar CNPJ -- TO DO
  public static boolean validarCnpj(String cnpj) {
    // Verificar 14 digitos
    int n = cnpj.length();
    int tamanho = 14;
    if (n != tamanho) {
      return false;
    }

    // Verificar se todos numeros sao iguais
    int diferenteAnterior = 0;
    for (int i = 1; i < n; i++) {
      if (cnpj.charAt(i) != cnpj.charAt(i - 1)) {
        diferenteAnterior++;
      }
    }
    if (diferenteAnterior == 0) {
      return false;
    }

    // Algoritmo para definir validade do CNPJ
    int multiplicador1 = 2;
    int soma1dig = 0;
    for (int posicao = 11; posicao >= 0; posicao--) {
      int valor = Character.getNumericValue(cnpj.charAt(posicao));
      if (multiplicador1 == 10) {
        multiplicador1 = 2;
      }
      soma1dig += multiplicador1 * valor;
      multiplicador1++;
    }
    int resto1 = soma1dig % 11;
    if (resto1 < 2) {
      if (cnpj.charAt(12) != '0') {
        return false;
      }
    } else {
      int digito = 11 - resto1;
      if (digito != Character.getNumericValue(cnpj.charAt(12))) {
        return false;
      }
    }
    int multiplicador2 = 2;
    int soma2dig = 0;
    for (int posicao = 12; posicao >= 0; posicao--) {
      int valor = Character.getNumericValue(cnpj.charAt(posicao));
      if (multiplicador2 == 10) {
        multiplicador2 = 2;
      }
      soma2dig += multiplicador2 * valor;
      multiplicador2++;
    }
    int resto2 = soma2dig % 11;
    if (resto2 < 2) {
      if (cnpj.charAt(13) != '0') {
        return false;
      }
    } else {
      int digito = 11 - resto2;
      if (digito != Character.getNumericValue(cnpj.charAt(13))) {
        return false;
      }
    }
    return true;
  }

  //toString

  @Override
  public String toString() {
    return (
      "Nome Empresa: "+ getNome() + "\n"+
      "CNPJ: " +
      getCnpj() +
      "\n" +
      "Data Fundacao: " +
      getDataFundacao() +
      "\n" + "Endereço: "+ getEndereco() + "\n"
      
    );
  }
}
