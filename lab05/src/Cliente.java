
public abstract class Cliente {

  private String nome;
  private String endereco;
  
  private String email;
  private String telefone;

  // Construtor
  public Cliente(
    String nome,
    String endereco,
    
    String email,
    String telefone
  ) {
    this.nome = nome;
    this.endereco = endereco;
    
    this.email = email;
    this.telefone = telefone;
  }
  
  // Getters e Setters

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }


  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return this.telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getCpf(){
    return null;
  }
//toString

  @Override
  public String toString() {
    return "{" +
      " nome='" + getNome() + "'" +
      ", endereco='" + getEndereco() + "'" +
      "}";
  }
 
}
