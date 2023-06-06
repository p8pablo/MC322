import java.time.*;
import java.util.*;

public class SeguroPJ extends Seguro {

  private Frota frota;
  private ClientePJ cliente;

  //Construtor
  public SeguroPJ(
    Frota frota,
    ClientePJ cliente,
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
    this.frota = frota;
    this.cliente = cliente;
  }

  //Get n Set

  public Frota getFrota() {
    return this.frota;
  }

  public void setFrota(Frota frota) {
    this.frota = frota;
  }
  @Override
  public ClientePJ getCliente() {
    return this.cliente;
  }

  public void setClientePJ(ClientePJ cliente) {
    this.cliente = cliente;
  }

  //calcular valor
  @Override
  public double calcularValor() {
    double valor = CalcSeguro.VALOR_BASE.getFator() *
      (10 + (cliente.getQtdeFuncionarios()) / 10) *
      (1 + 1 / (frota.getListaVeiculos().size() + 2)) *
      (1 + 1 / (2025 - cliente.getDataFundacao().getYear())) *
      (2 + (this.getSeguradora().getSinistroPorCliente(cliente)).size() / 10) *
      (5 + (this.getSeguradora().qntdSinistroCondutor(getListaCondutores())));
      this.setValorMensal(valor);
    return valor;
  }

  
}
