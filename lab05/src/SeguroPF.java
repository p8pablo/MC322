import java.time.LocalDate;
import java.util.*;

public class SeguroPF extends Seguro {

  private Veiculo veiculo;
  private ClientePF cliente;

  //Construtor

  public SeguroPF(
    Veiculo veiculo,
    ClientePF cliente,
    int id,
    LocalDate dataInicio,
    LocalDate dataFim,
    Seguradora seguradora,
    ArrayList<Sinistro> listaSinistros,
    ArrayList<Condutor> listaCondutores,
    int valorMensal
  ) {
    super(
      id,
      dataInicio,
      dataFim,
      seguradora,
      listaSinistros,
      listaCondutores,
      valorMensal
    );
    this.veiculo = veiculo;
    this.cliente = cliente;
  }

  //Getters e Setters
  public Veiculo getVeiculo() {
    return this.veiculo;
  }

  public void setVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }
@Override
  public Cliente getCliente() {
    return this.cliente;
  }

  public void setCliente(ClientePF cliente) {
    this.cliente = cliente;
  }

  //calcular valor
  @Override
  public double calcularValor() {
    int idade = 2023 - cliente.getDataNascimento().getYear();
    double valor = 0;
    if (idade < 30) {
      valor =
        (
          CalcSeguro.VALOR_BASE.getFator() *
          CalcSeguro.FATOR_18_30.getFator() *
          (1 + 1 / (cliente.getListaVeiculos().size()))
        );
        this.setValorMensal(valor);
      return valor;
    } else if (30 < idade || 60 > idade) {
      valor =
        (
          CalcSeguro.VALOR_BASE.getFator() *
          CalcSeguro.FATOR_30_60.getFator() *
          (1 + 1 / (cliente.getListaVeiculos().size()))
        );
        this.setValorMensal(valor);
      return valor;
    } else {
      valor =
        (
          CalcSeguro.VALOR_BASE.getFator() *
          CalcSeguro.FATOR_60_90.getFator() *
          (1 + 1 / (cliente.getListaVeiculos().size()))
        );
        this.setValorMensal(valor);
      return valor;
    }
    
  }
}
 
