import java.util.*;
import java.time.*;
public class ClientePJ extends Cliente {

  private String cnpj;
  private LocalDate dataFundacao;
  private int qtdeFuncionarios;

  //Construtor

  public ClientePJ(
    final String cnpj,
    LocalDate dataFundacao,
    String nome,
    String endereco,
    ArrayList<Veiculo> listaVeiculos,
    double valorSeguro,
    int qtdeFuncionarios
  ) throws Exception {
    super(nome, endereco, listaVeiculos, valorSeguro);
    this.dataFundacao = dataFundacao;
    this.qtdeFuncionarios = qtdeFuncionarios;
    if (Validacao.validarCnpj(Validacao.formatarCnpj(cnpj))) {
      this.cnpj = cnpj;
    } else{
      throw new Exception("CNPJ invalido");
    }
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

  public int getQtdeFuncionarios() {
    return this.qtdeFuncionarios;
  }

  public void setQtdeFuncionarios(int qtdeFuncionarios) {
    this.qtdeFuncionarios = qtdeFuncionarios;
  }


  //Calcular Score
  @Override
  public double calculaScore(){
    return CalcSeguro.VALOR_BASE.getFator() * (1+(qtdeFuncionarios)/100) * getListaVeiculos().size();
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
