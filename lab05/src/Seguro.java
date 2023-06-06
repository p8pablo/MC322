import java.time.LocalDate;
import java.util.*;

public abstract class Seguro {

  private final int id;
  private LocalDate dataInicio;
  private LocalDate dataFim;
  private Seguradora seguradora;
  private ArrayList<Sinistro> listaSinistros;
  private ArrayList<Condutor> listaCondutores;
  private double valorMensal;

  public Seguro(
    int id,
    LocalDate dataInicio,
    LocalDate dataFim,
    Seguradora seguradora,
    ArrayList<Sinistro> listaSinistros,
    ArrayList<Condutor> listaCondutores,
    double valorMensal
  ) {
    Random gerarInteiro = new Random();
    this.id = gerarInteiro.nextInt();
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.seguradora = seguradora;
    this.listaSinistros = listaSinistros;
    this.listaCondutores = listaCondutores;
    this.valorMensal = valorMensal;
  }

  //Getters e Setters
  public int getId() {
    return this.id;
  }

  public LocalDate getDataInicio() {
    return this.dataInicio;
  }

  public void setDataInicio(LocalDate dataInicio) {
    this.dataInicio = dataInicio;
  }

  public LocalDate getDataFim() {
    return this.dataFim;
  }

  public void setDataFim(LocalDate dataFim) {
    this.dataFim = dataFim;
  }

  public Seguradora getSeguradora() {
    return this.seguradora;
  }

  public void setSeguradora(Seguradora seguradora) {
    this.seguradora = seguradora;
  }

  public ArrayList<Sinistro> getListaSinistros() {
    return this.listaSinistros;
  }

  public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
    this.listaSinistros = listaSinistros;
  }

  public ArrayList<Condutor> getListaCondutores() {
    return this.listaCondutores;
  }

  public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
    this.listaCondutores = listaCondutores;
  }

  public double getValorMensal() {
    return this.valorMensal;
  }

  public void setValorMensal(double valorMensal) {
    this.valorMensal = valorMensal;
  }

  //autorizar e desautorizar condutor
  public boolean desautorizarCondutor(Condutor condutor) {
    for (Condutor condutores : listaCondutores) {
      if (condutores == condutor) {
        listaCondutores.remove(condutor);
        return true;
      }
    }
    return false;
  }

  public boolean autorizarCondutor(Condutor condutor) {
    if (listaCondutores != null) {
      for (Condutor condutores : listaCondutores) {
        if (condutores == condutor) {
          System.out.println("Condutor já cadastrado!");
          return false;
        } else {
          listaCondutores.add(condutor);
          return true;
        }
      }
    }
    listaCondutores = new ArrayList<Condutor>();
    listaCondutores.add(condutor);
    return true;
  }

  //Gerar Sinistro
  public Sinistro gerarSinistro(
    LocalDate data,
    String endereco,
    Condutor condutor,
    Seguro seguro
  ) {
    Sinistro sinistro = new Sinistro(id, data, endereco, condutor, seguro);
    if (listaSinistros == null) {
      listaSinistros = new ArrayList<Sinistro>();
      listaSinistros.add(sinistro);
      return sinistro;
    }
    listaSinistros.add(sinistro);
    return sinistro;
  }

  //Calcular Valor
  public double calcularValor() {
    return 0;
  }

  @Override
  public String toString() {
    return (
      "{" +
      " id='" +
      getId() +
      "'" +
      ", dataInicio='" +
      getDataInicio() +
      "'" +
      ", dataFim='" +
      getDataFim() +
      "'" +
      ", seguradora='" +
      getSeguradora() +
      "'" +
      "'" +
      ", valorMensal='" +
      getValorMensal() +
      "'" +
      "}"
    );
  }

  public Condutor getCondutor(String nome) {
    for (Condutor condutores : listaCondutores) {
      if (condutores.getNome() == nome) {
        return condutores;
      }
    }
    return null;
  }

  public Cliente getCliente() {
    return null;
  }
}
