public class Validacao {

  //CPF

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
      multiplicador1++;
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
      multiplicador2++;
    }
    int resto2 = soma2dig % 11;
    if (resto2 < 2) {
      if (cpf.charAt(10) != '0') {
        return false;
      }
    } else {
      int digito2 = 11 - resto2;
      if (digito2 != Character.getNumericValue(cpf.charAt(10))) {
        return false;
      }
    }
    return true;
  }

  //CNPJ

  //Formatar CNPJ
  public static String formatarCnpj(String cnpj) {
    cnpj = cnpj.replaceAll("\\.", "");
    cnpj = cnpj.replaceAll("/", "");
    cnpj = cnpj.replaceAll("-", "");
    return cnpj;
  }

  //Validar CNPJ -- TO DO
  public static boolean validarCnpj(String cnpj) {
    // Verificar 14 digitos
    int n = cnpj.length();
    int tamanho = 14;
    if (n != tamanho) {
      return false;
    }

    // Verificar se todos numeros sao iguais
    int diferenteAnterior = 0;
    for (int i = 1; i < n; i++) {
      if (cnpj.charAt(i) != cnpj.charAt(i - 1)) {
        diferenteAnterior++;
      }
    }
    if (diferenteAnterior == 0) {
      return false;
    }

    // Algoritmo para definir validade do CNPJ
    int multiplicador1 = 2;
    int soma1dig = 0;
    for (int posicao = 11; posicao >= 0; posicao--) {
      int valor = Character.getNumericValue(cnpj.charAt(posicao));
      if (multiplicador1 == 10) {
        multiplicador1 = 2;
      }
      soma1dig += multiplicador1 * valor;
      multiplicador1++;
    }
    int resto1 = soma1dig % 11;
    if (resto1 < 2) {
      if (cnpj.charAt(12) != '0') {
        return false;
      }
    } else {
      int digito = 11 - resto1;
      if (digito != Character.getNumericValue(cnpj.charAt(12))) {
        return false;
      }
    }
    int multiplicador2 = 2;
    int soma2dig = 0;
    for (int posicao = 12; posicao >= 0; posicao--) {
      int valor = Character.getNumericValue(cnpj.charAt(posicao));
      if (multiplicador2 == 10) {
        multiplicador2 = 2;
      }
      soma2dig += multiplicador2 * valor;
      multiplicador2++;
    }
    int resto2 = soma2dig % 11;
    if (resto2 < 2) {
      if (cnpj.charAt(13) != '0') {
        return false;
      }
    } else {
      int digito = 11 - resto2;
      if (digito != Character.getNumericValue(cnpj.charAt(13))) {
        return false;
      }
    }
    return true;
  }
}
