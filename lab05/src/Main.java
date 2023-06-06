// Arquivo executavel
import java.time.LocalDate;
import java.util.*;

public class Main {

  // metodo da Main
  public static void main(String[] args) throws Exception {
    //Instanciar Seguradora
    Seguradora seguradoraLab05 = new Seguradora(
      "16.954.565/0001-48",
      "Seguradora Lab 05",
      "319872993994",
      "seguradora@lab04.com",
      "Sala CC00, IC, UNICAMP",
      null,
      null
    );

    //Cadastrar Clientes PF e PJ
    LocalDate dataNascimento = LocalDate.of(2003, 11, 12);
    LocalDate dataFundacao = LocalDate.of(2012, 9, 5);

    ClientePF clientepf = new ClientePF(
      "Pablo Mendes",
      "Avenida Paulista, 0000",
      "Cursando Ensino Superior",
      "Masculino",
      "Classe Média",
      null,
      "15848106614",
      dataNascimento,
      "p230977@dac.unicamp.br",
      null
    );

    ClientePJ clientepj = new ClientePJ(
      "16.954.565/0001-48",
      dataFundacao,
      "Twitter",
      "Rua Professor Atilio Innocenti, 642, Vila Nova Conceicao - 668 9 Andar São Paulo/SP",
      150,
      "twitter@twitter.com",
      "11090909090909",
      null
    );

    seguradoraLab05.cadastrarCliente(clientepj);
    seguradoraLab05.cadastrarCliente(clientepf);

    //Listar Clientes
    System.out.println("Listando Clientes cadastrados...");
    seguradoraLab05.listarCliente("PF");
    seguradoraLab05.listarCliente("pj");

    //Adicionar Veiculos e frotas para Clientes Cadastrados
    Veiculo carroClientePF = new Veiculo(
      "C4LLTH3P8",
      "Mitsubishi",
      "Lancer",
      2000
    );
    clientepf.getListaVeiculos().add(carroClientePF);

    ArrayList<Veiculo> listaFrotaPJ = new ArrayList<Veiculo>();
    Frota frotaClientePJ = new Frota(null, listaFrotaPJ);
    clientepj.cadastrarFrota(frotaClientePJ);
    Veiculo carroClientePJ = new Veiculo("3LONMU5K", "Tesla", "Model 3", 2077);
    clientepj.atualizarFrota(frotaClientePJ, 0, carroClientePJ);

    //Gerar Seguro

    seguradoraLab05.gerarSeguro(
      0,
      LocalDate.now(),
      null,
      seguradoraLab05,
      null,
      null,
      0,
      carroClientePF,
      clientepf
    );
    seguradoraLab05.gerarSeguro(
      0,
      LocalDate.now(),
      null,
      seguradoraLab05,
      null,
      null,
      0,
      frotaClientePJ,
      clientepj
    );

    //Autorizar Condutor
    Condutor condutor1 = new Condutor(
      "15848106614",
      "Pablo",
      "31999999999",
      "condutor@gmail.com",
      "beco do batman",
      dataNascimento,
      null
    );
    seguradoraLab05.getListaSeguros().get(0).autorizarCondutor(condutor1);
    //Criar Sinistro
    condutor1.adicionarSinistro(
      seguradoraLab05
        .getListaSeguros()
        .get(0)
        .gerarSinistro(
          LocalDate.now(),
          "Av Paulista",
          condutor1,
          seguradoraLab05.getListaSeguros().get(0)
        )
    );
    
    //toString Geral
    System.out.println(clientepf + "\n");
    System.out.println(clientepj + "\n");
    System.out.println(carroClientePF + "\n");
    System.out.println(carroClientePJ + "\n");
    System.out.println(seguradoraLab05 + "\n");
    System.out.println(seguradoraLab05.getListaSeguros().get(0) + "\n"); 
    System.out.println(
      seguradoraLab05.getListaSeguros().get(0).getListaCondutores().get(0) +
      "\n"
      );
      System.out.println(seguradoraLab05.calcularReceita() + "\n");
      //Desautorizar Condutor
      seguradoraLab05.getListaSeguros().get(0).desautorizarCondutor(condutor1);
      
    //Leitura de Dados

    int opcao = 17;

    try (Scanner entrada = new Scanner(System.in)) {
      System.out.println("Bem vindo à " + seguradoraLab05.getNome());
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
            System.out.println("DADOS DO CONDUTOR");
            System.out.println("Digite o CPF:");
            String cpf = entrada.next();
            for (Seguro seguros : seguradoraLab05.getListaSeguros()) {
              for (Condutor condutores : seguros.getListaCondutores()) {
                if (condutores.getCpf() == cpf) {
                  System.out.println("Digite a data:");
                  String data = entrada.next();
                  LocalDate dataSinistro = LocalDate.parse(data);
                  System.out.println("Digite o endereco:");
                  String enderecoSinistro = entrada.next();
                  seguros.gerarSinistro(
                    dataSinistro,
                    enderecoSinistro,
                    condutores,
                    seguros
                  );
                }
              }
            }
            break;
          case CALCULAR_RECEITA:
            System.out.println(
              "A receita de " +
              seguradoraLab05.getNome() +
              " é " +
              seguradoraLab05.calcularReceita()
            );
            break;
          case CADASTRAR_PF:
            seguradoraLab05.cadastrarCliente(
              Construtor_teclado.criarClientePF()
            );
            System.out.println("Cliente cadastrado");
            break;
          case CADASTRAR_PJ:
            seguradoraLab05.cadastrarCliente(
              Construtor_teclado.criarClientePJ()
            );
            System.out.println("Cliente cadastrado");
            break;
          case CADASTRAR_VEICULO_PF:
            System.out.println("Digite o cpf do cliente:");
            String cpfVeiculoPF = entrada.next();
            for (Cliente clientes : seguradoraLab05.getListaClientes()) {
              if (clientes instanceof ClientePF) {
                if (clientes.getCpf() == cpfVeiculoPF) {
                  System.out.println("Digite a placa:");
                  String placaPF = entrada.next();
                  System.out.println("Digite a marca:");
                  String marcaPF = entrada.next();
                  System.out.println("Digite o modelo:");
                  String modeloPF = entrada.next();
                  System.out.println("Digite o ano de fabricacao:");
                  int anoPF = entrada.nextInt();
                  Veiculo veiculoPF = new Veiculo(
                    placaPF,
                    marcaPF,
                    modeloPF,
                    anoPF
                  );
                  ((ClientePF) clientes).cadastrarVeiculo(veiculoPF);
                  break;
                }
              }
            }
            break;
          case CADASTRAR_VEICULO_FROTA:
            System.out.println("Digite o cnpj do cliente:");
            String cnpjVeiculo = entrada.next();
            for (Cliente clientes : seguradoraLab05.getListaClientes()) {
              if (clientes instanceof ClientePJ) {
                if (((ClientePJ) clientes).getCnpj() == cnpjVeiculo) {
                  System.out.println("Digite a placa:");
                  String placaPF = entrada.next();
                  System.out.println("Digite a marca:");
                  String marcaPF = entrada.next();
                  System.out.println("Digite o modelo:");
                  String modeloPF = entrada.next();
                  System.out.println("Digite o ano de fabricacao:");
                  int anoPF = entrada.nextInt();
                  Veiculo veiculoPJ = new Veiculo(
                    placaPF,
                    marcaPF,
                    modeloPF,
                    anoPF
                  );
                  System.out.println("Digite o codigo da frota desejada:");
                  String codeFrota = entrada.next();
                  for (Frota frotas : ((ClientePJ) clientes).getListaFrota()) {
                    if (frotas.getCode() == codeFrota) {
                      ((ClientePJ) clientes).atualizarFrota(
                          frotaClientePJ,
                          0,
                          veiculoPJ
                        );
                    }
                  }
                  break;
                }
              }
            }

            break;
          case VOLTAR_CADASTRAR:
            opcao = 17;
            break;
          case LISTAR_PF:
            System.out.println("Listando Clientes PF");
            seguradoraLab05.listarCliente("PF");
            break;
          case LISTAR_PJ:
            System.out.println("Listando Clientes PJ");
            seguradoraLab05.listarCliente("PJ");
            break;
          case LISTAR_VEICULO_CLIENTE_PF:
            System.out.println("Digite um nome:");
            String nome_clienteVeiculo = entrada.next();
            for (Cliente cliente : seguradoraLab05.getListaClientes()) {
              if (cliente.getNome() == nome_clienteVeiculo) {
                for (Veiculo veiculo : (
                  (ClientePF) cliente
                ).getListaVeiculos()) {
                  System.out.println(veiculo);
                }
              }
            }
            break;
          case LISTAR_FROTA_CLIENTE_PJ:
            System.out.println("Digite um CNPJ:");
            String cnpjClienteVeiculo = entrada.next();
            for (Cliente cliente : seguradoraLab05.getListaClientes()) {
              if (((ClientePJ) cliente).getCnpj() == cnpjClienteVeiculo) {
                for (Frota frotas : ((ClientePJ) cliente).getListaFrota()) {
                  System.out.println(frotas);
                }
              }
            }
            break;
          case LISTAR_VEICULO_FROTA:
            System.out.println("Digite um CNPJ:");
            String cnpjClienteVeiculoFrota = entrada.next();
            System.out.println("Digite um code de frota:");
            String codeFrota = entrada.next();
            for (Cliente cliente : seguradoraLab05.getListaClientes()) {
              if (((ClientePJ) cliente).getCnpj() == cnpjClienteVeiculoFrota) {
                System.out.println(
                  ((ClientePJ) cliente).getVeiculoFrota(codeFrota)
                );
              }
            }

            break;
          case LISTAR_SEGUROS:
            for (Seguro seguros : seguradoraLab05.getListaSeguros()) {
              System.out.println(seguros);
            }
            break;
          case LISTAR_CONDUTORES_SEGURO:
            System.out.println("Digite o id do seguro:");
            int id = entrada.nextInt();
            for (Seguro seguros : seguradoraLab05.getListaSeguros()) {
              if (seguros.getId() == id) {
                for (Condutor condutores : seguros.getListaCondutores()) {
                  System.out.println(condutores);
                }
              }
            }
            break;
          case VOLTAR_LISTAR:
            opcao = 17;
            break;
          case EXCLUIR_CLIENTE:
            System.out.println("Digite o nome do cliente:");
            String nome = entrada.next();
            for (Cliente cliente : seguradoraLab05.getListaClientes()) {
              if (cliente.getNome() == nome) {
                seguradoraLab05.getListaClientes().remove(cliente);
              }
            }
          case EXCLUIR_VEICULO_PF:
            System.out.println("Digite o nome do cliente:");
            String nome_cliente_v = entrada.next();
            for (Cliente cliente : seguradoraLab05.getListaClientes()) {
              if (cliente.getNome() == nome_cliente_v) {
                System.out.println("Digite a placa do veiculo:");
                String placa = entrada.next();
                for (Veiculo veiculos : (
                  (ClientePF) cliente
                ).getListaVeiculos()) {
                  if (veiculos.getPlaca() == placa) {
                    ((ClientePF) cliente).getListaVeiculos().remove(veiculos);
                    System.out.println("Veiculo Removido");
                  }
                }
              }
            }
            break;
          case EXCLUIR_VEICULO_PJ:
            System.out.println("Digite o cnpj:");
            String cnpjExcluirVeiculo = entrada.next();
            for (Cliente cliente : seguradoraLab05.getListaClientes()) {
              if (((ClientePJ) cliente).getCnpj() == cnpjExcluirVeiculo) {
                System.out.println("Digite o codigo da frota:");
                String codeExcluir = entrada.next();
                System.out.println("Digite a placa do veiculo:");
                String placa = entrada.next();
                for (Frota frotas : ((ClientePJ) cliente).getListaFrota()) {
                  if (codeExcluir == frotas.getCode()) {
                    for (Veiculo veiculos : frotas.getListaVeiculos()) {
                      if (placa == veiculos.getPlaca()) {
                        frotas.removeVeiculo(veiculos);
                      }
                    }
                  }
                }
              }
            }
            break;
          case EXCLUIR_FROTA:
            System.out.println("Digite um CNPJ:");
            String cnpjClienteExcluirFrota = entrada.next();
            System.out.println("Digite um code de frota:");
            String codeExcluirFrota = entrada.next();
            for (Cliente clientes : seguradoraLab05.getListaClientes()) {
              if (((ClientePJ) clientes).getCnpj() == cnpjClienteExcluirFrota) {
                for (Frota frotas : ((ClientePJ) clientes).getListaFrota()) {
                  if (frotas.getCode() == codeExcluirFrota) {
                    ((ClientePJ) clientes).atualizarFrota(frotas, 2);
                  }
                }
              }
            }

            break;
          case VOLTAR_EXCLUIR:
            opcao = 17;
            break;
          case GERAR_SEGURO_PF:
            System.out.println("Digite um CPF:");
            String cpfGerar = entrada.next();
            System.out.println("Digite a placa:");
            String placaGerar = entrada.next();
            System.out.println("Digite a data de inicio:");
            String dataInicioSeguro = entrada.next();
            LocalDate dataInicio = LocalDate.parse(dataInicioSeguro);
            System.out.println("Digite a data de fim:");
            String dataFimSeguro = entrada.next();
            LocalDate dataFim = LocalDate.parse(dataFimSeguro);
            for (Cliente clientes : seguradoraLab05.getListaClientes()) {
              if (((ClientePF) clientes).getCpf() == cpfGerar) {
                for (Veiculo veiculos : (
                  (ClientePF) clientes
                ).getListaVeiculos()) {
                  if (veiculos.getPlaca() == placaGerar) {
                    seguradoraLab05.gerarSeguro(
                      0,
                      dataInicio,
                      dataFim,
                      seguradoraLab05,
                      null,
                      null,
                      0,
                      veiculos,
                      ((ClientePF) clientes)
                    );
                  }
                }
              }
            }
            break;
          case GERAR_SEGURO_PJ:
            System.out.println("Digite um Cnpj:");
            String cnpjGerar = entrada.next();
            System.out.println("Digite o codigo da frota:");
            String frotaGerar = entrada.next();
            System.out.println("Digite a data de inicio:");
            String dataInicioSeguroPJ = entrada.next();
            LocalDate dataInicioPJ = LocalDate.parse(dataInicioSeguroPJ);
            System.out.println("Digite a data de fim:");
            String dataFimSeguroPJ = entrada.next();
            LocalDate dataFimPJ = LocalDate.parse(dataFimSeguroPJ);
            for (Cliente clientes : seguradoraLab05.getListaClientes()) {
              if (((ClientePJ) clientes).getCnpj() == cnpjGerar) {
                for (Frota frotas : ((ClientePJ) clientes).getListaFrota()) {
                  if (frotas.getCode() == frotaGerar) {
                    seguradoraLab05.gerarSeguro(
                      0,
                      dataInicioPJ,
                      dataFimPJ,
                      seguradoraLab05,
                      null,
                      null,
                      0,
                      frotaClientePJ,
                      ((ClientePJ) clientes)
                    );
                  }
                }
              }
            }
            break;
          case CANCELAR_SEGURO:
          System.out.println("Digite o id do seguro:");
            int idCancelar = entrada.nextInt();
            for(Seguro seguros: seguradoraLab05.getListaSeguros()){
              if(seguros.getId() == idCancelar){
                seguradoraLab05.getListaSeguros().remove(seguros);
              }
            }
            
            break;
          case AUTORIZAR_CONDUTOR:
          System.out.println("Digite o id do seguro:");
            int idAutorizar = entrada.nextInt();
            for(Seguro seguros: seguradoraLab05.getListaSeguros()){
              if(seguros.getId() == idAutorizar){
                seguros.autorizarCondutor(Construtor_teclado.criarCondutor());
              }
            }
            
            
          break;
          case DESAUTORIZAR_CONDUTOR:
          System.out.println("Digite o id do seguro:");
            int idDesautorizar = entrada.nextInt();
          System.out.println("Digite o CPF:");
          String cpfDesau = entrada.next();
            for(Seguro seguros: seguradoraLab05.getListaSeguros()){
              if(seguros.getId() == idDesautorizar){
                for (Condutor condutores : seguros.getListaCondutores()) {
                  if(condutores.getCpf() == cpfDesau){
                    seguros.getListaCondutores().remove(condutores);
                  }
                }
              }
            }
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
    String menuInicial =
      "1.Cadastros\n 2.Listar\n 3.Excluir\n 4.Gerar Sinistro\n 5.Calcular Receita\n 6.Gerar Seguro PF\n 7.Gerar Seguro PJ\n 8.Cancelar Seguro\n 0.Sair";
    String menuCadastros =
      "11. Cadastrar Pessoa Física\n 12. Cadastrar Pessoa Jurídica\n 13. Cadastrar Veículo PF\n 14. Cadastrar Veículo PJ\n 15. Autorizar Condutor\n 16. Desautorizar Condutor\n 17. Voltar";
    String menuListar =
      "21. Listar Pessoa Física\n 22. Listar Pessoa Jurídica\n 23. Listar Veiculos por Cliente PF\n 24. Listar Veiculo por Cliente PJ\n25. Listar Veiculo por Frota\n26. Listar Seguros\n27. Listar Condutores de um Seguro\n 28. Voltar";
    String menuExcluir =
      "31. Excluir Cliente\n 32. Excluir Veiculo PF\n 33. Excluir Veiculo PJ\n 34. Excluir Frota\n 35. Voltar";
    if (opcao == 17 || opcao == 28 || opcao == 34) {
      System.out.println(menuInicial);
    } else if (opcao == 1) {
      System.out.println(menuCadastros);
    } else if (opcao == 2) {
      System.out.println(menuListar);
    } else if (opcao == 3) {
      System.out.println(menuExcluir);
    }
  }
}
