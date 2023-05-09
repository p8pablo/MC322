// Arquivo executavel
import java.time.LocalDate;
import java.util.*;

public class Main {
  
  // metodo da Main
  public static void main(String[] args) throws Exception {
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
    Seguradora seguradoraLab04 = new Seguradora(
      "Seguradora Lab 04",
      "319872993994",
      "seguradora@lab04.com",
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
      0,
      "15848106614",
      dataNascimento
      );
      
      ClientePJ clientepj = new ClientePJ(
        "16.954.565/0001-48",
      dataFundacao,
      "Twitter",
      "Rua Professor Atilio Innocenti, 642, Vila Nova Conceicao - 668 9 Andar São Paulo/SP",
      null,
      0,
      150
      );
      clientepf.setValorSeguro(seguradoraLab04.calcularPrecoSeguroCliente(clientepf));
      seguradoraLab04.cadastrarCliente(clientepf);

      clientepj.setValorSeguro(seguradoraLab04.calcularPrecoSeguroCliente(clientepj));
      seguradoraLab04.cadastrarCliente(clientepj);
      
      //Listar Clientes
      System.out.println("Listando Clientes cadastrados...");
      seguradoraLab04.listarCliente("PF");
    seguradoraLab04.listarCliente("pj");
    
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
      seguradoraLab04.gerarSinistro(carroClientePF, clientepf, seguradoraLab04);
      seguradoraLab04.gerarSinistro(carroClientePJ, clientepj, seguradoraLab04);
      
      seguradoraLab04.visualizarSinistro("Pablo Mendes");
    seguradoraLab04.visualizarSinistro("Twitter");

    //toString Geral
    System.out.println(clientepf + "\n");
    System.out.println(clientepj + "\n");
    System.out.println(carroClientePF + "\n");
    System.out.println(carroClientePJ + "\n");
    System.out.println(seguradoraLab04 + "\n");
    System.out.println(seguradoraLab04.calcularReceita()+ "\n");
    
    //Leitura de Dados
    
    int opcao = 14;
    
    try (Scanner entrada = new Scanner(System.in)) {
      
      System.out.println("Bem vindo à " + seguradoraLab04.getNome());
      while (opcao != 0) {
        imprimirMenu(opcao);
        opcao = entrada.nextInt();
        MenuOperacoes operacao = MenuOperacoes.getEnum(opcao);
        switch (operacao) {
          case CADASTROS:
    
          break;
          case LISTAR:
    
          break;
          case EXCLUIR:
    
          break;
          case GERAR_SINISTRO:
          System.out.println("Digite um nome:");
          String nome_cliente = entrada.next();
          for (Cliente clientes : seguradoraLab04.getListaClientes()) {
            if (clientes.getNome() == nome_cliente) {
              System.out.println("Digite a placa:");
              String placa = entrada.next();
              for (Veiculo veiculo : clientes.getListaVeiculos()) {
                if (veiculo.getPlaca() == placa) {
                  seguradoraLab04.gerarSinistro(veiculo, clientes, seguradoraLab04);
                  System.out.println("Sinistro gerado");
                }
              }
            }
          }
          break;
          case CALCULAR_RECEITA:
          System.out.println("A receita de "+seguradoraLab04.getNome()+" é "+seguradoraLab04.calcularReceita());
          break;
          case CADASTRAR_PF:
          seguradoraLab04.cadastrarCliente(Construtor_teclado.criarClientePF());
          System.out.println("Cliente cadastrado");
          break; 

          case CADASTRAR_PJ:
          seguradoraLab04.cadastrarCliente(Construtor_teclado.criarClientePJ());
          System.out.println("Cliente cadastrado");
          break; 

          case CADASTRAR_VEICULO:
          seguradoraLab04.getCliente(entrada.next()).getVeiculo(Construtor_teclado.criarVeiculo().getPlaca());
          System.out.println("Veiculo cadastrado");
          break;

          case VOLTAR_CADASTRAR:
          opcao = 14;
          break; 

          case LISTAR_PF:
          System.out.println("Listando Clientes PF");
          seguradoraLab04.listarCliente("PF");
          break;

          case LISTAR_PJ:
          System.out.println("Listando Clientes PJ");
          seguradoraLab04.listarCliente("PJ");
          break;

          case LISTAR_SINISTROS:
          System.out.println("Sinistros");

          case VOLTAR_LISTAR:
          opcao = 14;
          break; 

          case EXCLUIR_CLIENTE:
          System.out.println("Digite o nome do cliente:");
          String nome = entrada.next();
          for (Cliente cliente : seguradoraLab04.getListaClientes()) {
            if (cliente.getNome() == nome) {
              seguradoraLab04.getListaClientes().remove(cliente);
            }
          }

          case EXCLUIR_VEICULO:
          System.out.println("Digite o nome do cliente:");
          String nome_cliente_v = entrada.next();
          for (Cliente cliente : seguradoraLab04.getListaClientes()) {
            if (cliente.getNome() == nome_cliente_v) {
              System.out.println("Digite a placa do veiculo:");
              String placa = entrada.next();
              for (Veiculo veiculos : cliente.getListaVeiculos()) {
                if(veiculos.getPlaca() == placa){
                  cliente.getListaVeiculos().remove(veiculos);
                  System.out.println("Veiculo Removido");
                }
              }
            }
          }
          break;

          case EXCLUIR_SINISTRO:
          System.out.println("Digite o ID do Sinistro:");
          int id = entrada.nextInt();
          for (Sinistro sinistro : seguradoraLab04.getListaSinistros()) {
            if(sinistro.getId() == id){
              seguradoraLab04.getListaSinistros().remove(sinistro);
              System.out.println("Sinistro Removido");
            }
          }
          case VOLTAR_EXCLUIR:
          opcao = 14;
          break; 


          case SAIR:
          opcao = 0;
          break; 
          

            
            
        }
        
      }
    }
    
  }

  private static void imprimirMenu(int opcao) {
    //Definição dos menus
    String menuInicial = "1.Cadastros\n 2.Listar\n 3.Excluir\n 4.Gerar Sinistro\n 5.Calcular Receita\n 0.Sair";
    String menuCadastros = "11. Cadastrar Pessoa Física\n 12. Cadastrar Pessoa Jurídica\n 13. Cadastrar Veículo\n 14. Voltar";
    String menuListar = "21. Listar Pessoa Física\n 22. Listar Pessoa Jurídica\n 23. Listar Sinistros\n 24. Voltar";
    String menuExcluir = "31. Excluir Pessoa Física\n 32. Excluir Pessoa Jurídica\n 33. Excluir Sinistro\n 34. Voltar";
    if(opcao == 14 || opcao == 24 || opcao == 34){
      System.out.println(menuInicial);
    } else if (opcao == 1){
      System.out.println(menuCadastros);
    } else if (opcao == 2){
      System.out.println(menuListar);
    } else if (opcao == 3){
      System.out.println(menuExcluir);
    }
  }
}
