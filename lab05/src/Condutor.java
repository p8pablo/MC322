import java.time.*;
import java.util.*;

public class Condutor {

  private final String cpf;
  private String nome;
  private String telefone;
  private String email;
  private String endereco;
  private LocalDate dataNasc;
  private ArrayList<Sinistro> listaSinitros;

  //Construtor
  public Condutor(
    String cpf,
    String nome,
    String telefone,
    String email,
    String endereco,
    LocalDate dataNasc,
    ArrayList<Sinistro> listaSinistros
  ) {
    this.cpf = cpf;
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.dataNasc = dataNasc;
    this.listaSinitros = listaSinistros;
    this.endereco = endereco;
  }

  //Get n Set

  public String getCpf() {
    return this.cpf;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTelefone() {
    return this.telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDataNasc() {
    return this.dataNasc;
  }

  public void setDataNasc(LocalDate dataNasc) {
    this.dataNasc = dataNasc;
  }

  public ArrayList<Sinistro> getListaSinitros() {
    return this.listaSinitros;
  }

  public void setListaSinitros(ArrayList<Sinistro> listaSinitros) {
    this.listaSinitros = listaSinitros;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  //To String

  @Override
  public String toString() {
    return "{" +
      " cpf='" + getCpf() + "'" +
      ", nome='" + getNome() + "'" +
      ", telefone='" + getTelefone() + "'" +
      ", email='" + getEmail() + "'" +
      ", endereco='" + getEndereco() + "'" +
      ", dataNasc='" + getDataNasc() + "'" +
      "}";
  }


  //adicionar sinistro
  public void adicionarSinistro(Sinistro sinistro) {
    if (listaSinitros == null) {
      listaSinitros = new ArrayList<Sinistro>();
      listaSinitros.add(sinistro);
      return;
    }
    listaSinitros.add(sinistro);
  }
}
