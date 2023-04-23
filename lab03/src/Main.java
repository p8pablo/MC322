// Arquivo executavel
import java.time.LocalDate;
import java.util.*;

public class Main {

  // metodo da Main
  public static void main(String[] args) {
    /*
     *--- Fluxo do programa ---
     * Instanciar Seguradora
     * Cadastrar Clientes PF e PJ
     *      Validar CPF e CNPJ
     * Listar Clientes
     * Adicionar veículos para os Clientes cadastrados
     * Gerar Sinistro
     *      Visualizar Sinistro
     *      Listar Sinistro
     * Método que faça leitura de dados
     *
     *
     */

    //Instanciar Seguradora
    Seguradora seguradoraLab03 = new Seguradora(
      "Seguradora Lab 03",
      "319872993994",
      "seguradora@lab03.com",
      "Sala CC00, IC, UNICAMP",
      null,
      null
    );

    //Cadastrar Clientes PF e PJ
    LocalDate dataLicenca = LocalDate.now();
    LocalDate dataNascimento = LocalDate.of(2003, 11, 12);
    LocalDate dataFundacao = LocalDate.of(2012, 9, 5);

    ClientePF clientepf = new ClientePF(
      "Pablo Mendes",
      "Avenida Paulista, 0000",
      dataLicenca,
      "Cursando Ensino Superior",
      "Masculino",
      "Classe Média",
      null,
      "15848106614",
      dataNascimento
    );

    ClientePJ clientepj = new ClientePJ(
      "16.954.565/0001-48",
      dataFundacao,
      "Twitter",
      "Rua Professor Atilio Innocenti, 642, Vila Nova Conceicao - 668 9 Andar São Paulo/SP",
      null
    );

    if (ClientePF.validarCpf(ClientePF.formatarCpf(clientepf.getCpf()))) {
      seguradoraLab03.cadastrarCliente(clientepf);
    }
    if (ClientePJ.validarCnpj(ClientePJ.formatarCnpj(clientepj.getCnpj()))) {
      seguradoraLab03.cadastrarCliente(clientepj);
    }

    //Listar Clientes
    System.out.println("Listando Clientes cadastrados...");
    seguradoraLab03.listarCliente("PF");
    seguradoraLab03.listarCliente("pj");

    //Adicionar Veiculos para Clientes Cadastrados
    Veiculo carroClientePF = new Veiculo(
      "C4LLTH3P8",
      "Mitsubishi",
      "Lancer",
      2000
    );

    Veiculo carroClientePJ = new Veiculo("3LONMU5K", "Tesla", "Model 3", 2077);

    clientepf.getListaVeiculos().add(carroClientePF);
    clientepj.getListaVeiculos().add(carroClientePJ);

    //Gerar Sinistro
    seguradoraLab03.gerarSinistro(carroClientePF, clientepf, seguradoraLab03);
    seguradoraLab03.gerarSinistro(carroClientePJ, clientepj, seguradoraLab03);

    seguradoraLab03.visualizarSinistro("Pablo Mendes");
    seguradoraLab03.visualizarSinistro("Twitter");

    //toString Geral
    System.out.println(clientepf + "\n");
    System.out.println(clientepj + "\n");
    System.out.println(carroClientePF + "\n");
    System.out.println(carroClientePJ + "\n");
    System.out.println(seguradoraLab03 + "\n");

    //Leitura de Dados
    int opcao = 1;
    try (Scanner entrada = new Scanner(System.in)) {
      System.out.println("Bem vindo à " + seguradoraLab03.getNome());
      while (opcao != 4) {
        System.out.println("Selecione a opção desejada:");
        System.out.println("1. Listar Clientes\n");
        System.out.println("2. Listar Sinistro\n");
        System.out.println("3. Informações para Contato\n");
        System.out.println("4. Finalizar");
        opcao = entrada.nextInt();
        switch (opcao) {
          case 1:
            seguradoraLab03.listarCliente("PF");
            seguradoraLab03.listarCliente("PJ");
            break;
          case 2:
            seguradoraLab03.listarSinistros();
            break;
          case 3:
            System.out.println(seguradoraLab03);
            break;
          case 4:
            System.out.println("Obrigado por utilizar nosso sistema!");
            
            continue;
        }
      }
    }
  }
}
