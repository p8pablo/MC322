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
  public static String formatarCpf(String cpf) {
    cpf = cpf.replaceAll("\\.", "");
    cpf = cpf.replaceAll("-", "");
    return cpf;
  }

  // Validar CPF
  public static boolean validarCpf(String cpf) {
    // Verificar 11 digitos
    int n = cpf.length();
    int tamanho = 11;
    if (n != tamanho) {
      return false;
    }
    // Verificar se todos numeros sao iguais
    int diferenteAnterior = 0;
    for (int i = 1; i < n; i++) {
      if (cpf.charAt(i) != cpf.charAt(i - 1)) {
        diferenteAnterior++;
      }
    }
    if (diferenteAnterior == 0) {
      return false;
    }

    // Algoritmo para definir validade do CPF
    int soma1dig = 0;
    int multiplicador1 = 2;
    for (int i = 8; i >= 0; i--) {
      int valor = Character.getNumericValue(cpf.charAt(i));
      soma1dig += multiplicador1 * valor;
      multiplicador1 ++;
    }
    int resto1 = soma1dig % 11;
    if (resto1 < 2) {
      if (cpf.charAt(9) != '0') {
        return false;
      }
    } else {
      int digito = 11 - resto1;
      if (digito != Character.getNumericValue(cpf.charAt(9))) {
        return false;
      }
    }
    int soma2dig = 0;
    int multiplicador2 = 2;
    for (int i = 9; i >= 0; i--) {
      int valor = Character.getNumericValue(cpf.charAt(i));
      soma2dig += multiplicador2 * valor;
      multiplicador2 ++;
    }
    int resto2 = soma2dig % 11;
    if (resto2 < 2) {
      if(cpf.charAt(10)!= '0'){
        return false;
      }
    }
    else{
      int digito2 = 11 - resto2;
      if (digito2 != Character.getNumericValue(cpf.charAt(10))) {
        return false;
      }
    }
    return true;
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
    this.idade = Integer.parseInt(idade);
  }

  public String getEndereco() {
    return endereco;
  }
  public void setEndereco(String endereco){
    this.endereco = endereco;
  }
}
