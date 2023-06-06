import java.time.*;
import java.util.*;

public class ClientePJ extends Cliente {

  private String cnpj;
  private LocalDate dataFundacao;
  private int qtdeFuncionarios;
  private ArrayList<Frota> listaFrota;

  //Construtor

  public ClientePJ(
    final String cnpj,
    LocalDate dataFundacao,
    String nome,
    String endereco,
    int qtdeFuncionarios,
    String email,
    String telefone,
    ArrayList<Frota> listaFrota
  ) throws Exception {
    super(nome, endereco, email, telefone);
    this.dataFundacao = dataFundacao;
    this.qtdeFuncionarios = qtdeFuncionarios;
    this.listaFrota = new ArrayList<Frota>();

    if (Validacao.validarCnpj(Validacao.formatarCnpj(cnpj))) {
      this.cnpj = cnpj;
    } else {
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

  public ArrayList<Frota> getListaFrota() {
    return this.listaFrota;
  }

  public void setListaFrota(ArrayList<Frota> listaFrota) {
    this.listaFrota = listaFrota;
  }


  //cadastrar Frota
  public boolean cadastrarFrota(Frota frota) {
    for (Frota frotas : listaFrota) {
      if (frota == frotas) {
        System.out.println("Frota já cadastrada!");
        return false;
      }
    }
    listaFrota.add(frota);
    return true;
  }

  //atualizar frota
  public boolean atualizarFrota(Frota frota, int operacao, Veiculo veiculo) {
    switch (operacao) {
      case 0:
        //adicionar carro
        return frota.addVeiculo(veiculo);
      case 1:
        //remover carro
        return frota.removeVeiculo(veiculo);
    }
    return false;
  }

  //remover frota
  public boolean atualizarFrota(Frota frota, int operacao) {
    if (operacao == 2) {
      for (Frota frotas : listaFrota) {
        if (frotas == frota) {
          listaFrota.remove(frota);
          return true;
        }
      }
      System.out.println("Frota inexistente");
      return false;
    }
    return false;
  }
  // pegar veiculos por frota
  public ArrayList<Veiculo> getVeiculoFrota(String code){
    for(Frota frotas: listaFrota){
      if(frotas.getCode() == code){
        return frotas.getListaVeiculos();
      }
    }
    return null;
  }
  //toString

  @Override
  public String toString() {
    return (
      "Nome Empresa: " +
      getNome() +
      "\n" +
      "CNPJ: " +
      getCnpj() +
      "\n" +
      "Data Fundacao: " +
      getDataFundacao() +
      "\n" +
      "Endereço: " +
      getEndereco() +
      "\n"
    );
  }
}
