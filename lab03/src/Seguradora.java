import java.time.LocalDate;
import java.util.*;

public class Seguradora {

  private String nome;
  private String telefone;
  private String email;
  private String endereco;
  private ArrayList<Sinistro> listaSinistros;
  private ArrayList<Cliente> listaClientes;

  // Construtor
  public Seguradora(
    String nome,
    String telefone,
    String email,
    String endereco,
    ArrayList<Sinistro> listaSinistros,
    ArrayList<Cliente> listaClientes
  ) {
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.endereco = endereco;
    this.listaClientes = new ArrayList<Cliente>();
    this.listaSinistros = new ArrayList<Sinistro>();
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

  public ArrayList<Sinistro> getListaSinistros() {
    return this.listaSinistros;
  }

  public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
    this.listaSinistros = listaSinistros;
  }

  public ArrayList<Cliente> getListaClientes() {
    return this.listaClientes;
  }

  public void setListaClientes(ArrayList<Cliente> listaClientes) {
    this.listaClientes = listaClientes;
  }

  //toString

  @Override
  public String toString() {
    return (
      
      "Nome: " +
      getNome() +
      "\n" +
      "Telefone: " +
      getTelefone() +
      "\n" +
      "Email: " +
      getEmail() +
      "\n" +
      "Endereco: " +
      getEndereco() +
      "\n" 
      

    );
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
  
  //Gerar Sinistro
  public boolean gerarSinistro(Veiculo veiculoSinistro, Cliente clienteSinistro, Seguradora seguradoraSinistro){
    int dia = 22;
    int mes = 04;
    int ano = 2023;
    LocalDate dataOcorrenciaSinistro = LocalDate.of(ano, mes, dia);
    Sinistro sinistro = new Sinistro(0, dataOcorrenciaSinistro, "Rua do IC, UNICAMP", seguradoraSinistro, veiculoSinistro, clienteSinistro);
    listaSinistros.add(sinistro);
    return true;
  }

  //Visualizar Sinistro
  public void visualizarSinistro(String cliente){
    if(listaSinistros != null){
      int existeSinistro = 0;
      for (Sinistro sinistrosExistentes : listaSinistros) {
        if (sinistrosExistentes.getCliente().getNome() == cliente) {
          System.out.println(sinistrosExistentes);
          existeSinistro ++;
        }
      }
      if (existeSinistro == 0) {
        System.out.println("Este cliente não tem sinistros!");
        return;
      }
      else{
        return;
      }
    }
    System.out.println("Não há sinistros no sistema");
    return;
  }

  //Listar Sinistros
  public void listarSinistros(){
    for (Sinistro sinistrosExistentes : listaSinistros) {
      System.out.println(sinistrosExistentes);
      System.out.println('\n');
    }
  }

}
