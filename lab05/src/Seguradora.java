import java.time.LocalDate;
import java.util.*;

public class Seguradora {

  private final String cnpj;
  private String nome;
  private String telefone;
  private String email;
  private String endereco;
  private ArrayList<Seguro> listaSeguros;
  private ArrayList<Cliente> listaClientes;

  // Construtor
  public Seguradora(
    final String cnpj,
    String nome,
    String telefone,
    String email,
    String endereco,
    ArrayList<Seguro> listaSeguros,
    ArrayList<Cliente> listaClientes
  ) {
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.endereco = endereco;
    this.listaClientes = new ArrayList<Cliente>();
    this.listaSeguros = new ArrayList<Seguro>();
    this.cnpj = cnpj;
  }

  // Getters e setters

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

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public ArrayList<Seguro> getListaSeguros() {
    return this.listaSeguros;
  }

  public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
    this.listaSeguros = listaSeguros;
  }

  public ArrayList<Cliente> getListaClientes() {
    return this.listaClientes;
  }

  public void setListaClientes(ArrayList<Cliente> listaClientes) {
    this.listaClientes = listaClientes;
  }

  public String getCnpj() {
    return this.cnpj;
  }


  //Cadastrar Cliente
  public boolean cadastrarCliente(Cliente cliente) {
    for (Cliente clientesExistentes : listaClientes) {
      if (clientesExistentes.getNome() == cliente.getNome()) {
        System.out.println("O Cliente já existe!");
        return false;
      }
    }
    listaClientes.add(cliente);
    System.out.println("Cliente cadastrado!");
    return true;
  }

  //Remover Cliente
  public boolean removerCliente(String clienteNome) {
    for (Cliente clientesExistentes : listaClientes) {
      if (clientesExistentes.getNome() == clienteNome) {
        listaClientes.remove(clientesExistentes);
        System.out.println("Cliente removido com sucesso!");
        return true;
      }
    }
    System.out.println("O Cliente não existe!");
    return false;
  }

  //Listar Clientes
  public void listarCliente(String tipoCliente) {
    for (Cliente clientesExistentes : listaClientes) {
      if (tipoCliente == "pf" || tipoCliente == "PF") {
        if (clientesExistentes instanceof ClientePF) {
          System.out.println(clientesExistentes);
        }
      } else if (tipoCliente == "pj" || tipoCliente == "PJ") {
        if (clientesExistentes instanceof ClientePJ) {
          System.out.println(clientesExistentes);
        }
      }
    }
  }

  //Gerar Seguros
  public boolean gerarSeguro(
    int id,
    LocalDate inicio,
    LocalDate fim,
    Seguradora seguradora,
    ArrayList<Sinistro> listaSinistros,
    ArrayList<Condutor> listaCondutores,
    int valorMensal,
    Frota frota,
    ClientePJ cliente
  ) {
    Seguro seguro = new SeguroPJ(
      frota,
      cliente,
      id,
      inicio,
      fim,
      seguradora,
      listaSinistros,
      listaCondutores,
      valorMensal
    );
    listaSeguros.add(seguro);
    return true;
  }

  public boolean gerarSeguro(
    int id,
    LocalDate inicio,
    LocalDate fim,
    Seguradora seguradora,
    ArrayList<Sinistro> listaSinistros,
    ArrayList<Condutor> listaConturores,
    int valorMensal,
    Veiculo veiculo,
    ClientePF cliente
  ) {
    Seguro seguro = new SeguroPF(
      veiculo,
      cliente,
      id,
      inicio,
      fim,
      seguradora,
      listaSinistros,
      listaConturores,
      valorMensal
    );
    listaSeguros.add(seguro);
    return true;
  }

  //Calcelar seguros
  public boolean cancelarSeguro(SeguroPF seguro) {
    listaSeguros.remove(seguro);
    return true;
  }

  public boolean cancelarSeguro(SeguroPJ seguro) {
    listaSeguros.remove(seguro);
    return true;
  }

  //Pegar Seguros por Clientes
  public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente) {
    ArrayList<Seguro> seguros = new ArrayList<Seguro>();
    for (Seguro segurosExistentes : listaSeguros) {
      for(Condutor condutores : segurosExistentes.getListaCondutores()){
        if(condutores.getNome() == cliente.getNome()){
          seguros.add(segurosExistentes);
        }
      }
    }
    return seguros;
  }

  //Pegar Sinistros por Clientes
  public ArrayList<Sinistro> getSinistroPorCliente(Cliente cliente) {
    ArrayList<Sinistro> sinistros = new ArrayList<Sinistro>();
    for (Seguro segurosExistentes : listaSeguros) {
      for (Condutor condutores : segurosExistentes.getListaCondutores()) {
        if (cliente.getNome() == condutores.getNome()) {
          sinistros.addAll(condutores.getListaSinitros());
        }
      }
    }
    return sinistros;
  }

  //Pegar quantidade de Sinistro por lista de Condutores
  public int qntdSinistroCondutor(ArrayList<Condutor> condutores) {
    int valor = 0;
    for (Condutor condutor : condutores) {
      valor += condutor.getListaSinitros().size();
    }
    return valor;
  }
  //Calcular Receita
  public double calcularReceita(){
    double valor = 0;
    for(Seguro seguros: listaSeguros){
      valor += seguros.getValorMensal();
    }
    return valor;
  }
  //Pegar cliente com CPF
  public Cliente getCliente(String nextLine) {
    for (Cliente clientes_existentes : listaClientes) {
      if (clientes_existentes.getNome() == nextLine) {
        return clientes_existentes;
      }
    }
    return null;
  }
  public String toString() {
    return "{" +
      " cnpj='" + getCnpj() + "'" +
      ", nome='" + getNome() + "'" +
      ", telefone='" + getTelefone() + "'" +
      ", email='" + getEmail() + "'" +
      ", endereco='" + getEndereco() + "'" +
      "}";
  }
}


