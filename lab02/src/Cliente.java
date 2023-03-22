public class Cliente {

  private String nome;
  private String cpf;
  private String dataNascimento;
  private int idade;
  private String endereco;

  // Construtor
  public Cliente(
    String nome,
    String cpf,
    String dataNascimento,
    int idade,
    String endereco
  ) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.idade = idade;
    this.endereco = endereco;
  }
  // Formatar CPF
  public static String formatarCpf(String cpf){
    cpf = cpf.replaceAll("\\.","");
    cpf = cpf.replaceAll("-","");
  }
  // Validar CPF
  public static boolean validarCpf(String cpf){
    // Verificar 11 digitos
    int n = cpf.length();
    int tamanho = 11;
    if(n != tamanho){
      return false;
    }
    // Verificar se todos numeros sao iguais
    int diferenteAnterior = 0;
    for(i=1; i < n; i++){
      if(cpf[i] != cpf[i-1]){
        diferenteAnterior ++;
      }
    }
    if(!diferenteAnterior){
      return false;
    }

    // Algoritmo para definir validade do CPF
  }

  // Getters e Setters
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(String idade) {
    this.idade = idade;
  }

  public String getEndereco(String endereco){
    this.endereco = endereco;
  }
}
