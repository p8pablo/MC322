import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class Construtor_teclado {
    private static Scanner scanner = new Scanner(System.in);

    public static ClientePF criarClientePF() {
        while (true) {
            try {
                System.out.println("Nome: ");
                String nome = scanner.next();
                System.out.println("Educação: ");
                String educacao = scanner.next();
                System.out.println("Gênero: ");
                String genero = scanner.next();
                System.out.println("Classe econômica: ");
                String classeEconomica = scanner.next();
                System.out.println("Endereço: ");
                String endereco = scanner.next();
                System.out.println("Data da licença (dd-mm-aaaa): ");
                String data_l = scanner.next();
                LocalDate dataLicenca = LocalDate.parse(data_l, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.println("Cpf: ");
                String cpf = scanner.next();
                System.out.println("Data de nascimento (dd-mm-aaaa): ");
                String data_n = scanner.next();
                LocalDate dataNascimento = LocalDate.parse(data_n);
                ClientePF cliente = new ClientePF(nome, cpf, dataLicenca, educacao, genero, classeEconomica, null, 0, endereco,
                        dataNascimento);
                return cliente;
            } catch (java.text.ParseException e) {
                System.out.println("Data inserida possui formato inválido, tente novamente");
            } catch (Exception e) {
                System.out.println("Cpf digitado é invalido, tente novamente.");
            }
        }
    }

    public static ClientePJ criarClientePJ() {
        while (true) {
            try {
                System.out.println("Nome: ");
                String nome = scanner.next();
                System.out.println("Endereço: ");
                String endereco = scanner.next();
                System.out.println("Cnpj: ");
                String cnpj = scanner.next();
                System.out.println("Data de fundação (dd-mm-aaaa): ");
                String data_f = scanner.next();
                LocalDate dataFundacao = LocalDate.parse(data_f);
                System.out.println("Quantidade de funcionários: ");
                int qtdeFuncionarios = Integer.parseInt(scanner.next());
                ClientePJ cliente = new ClientePJ(cnpj, dataFundacao, nome, endereco, null, qtdeFuncionarios, qtdeFuncionarios);
                return cliente;
            } catch (java.text.ParseException e) {
                System.out.println("Data inserida possui formato inválido, tente novamente");
            } catch (Exception e) {
                System.out.println("Cpf digitado é invalido, tente novamente.");
            }
        }
    }

    public static Seguradora criarSeguradora() {
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Telefone: ");
        String telefone = scanner.next();
        System.out.println("Email: ");
        String email = scanner.next();
        System.out.println("Endereco: ");
        String endereco = scanner.next();
        Seguradora seguradora = new Seguradora(nome, telefone, email, endereco, null, null);
        return seguradora;
    }

    public static Sinistro criarSinistro(Seguradora seguradora) {
        try {
            System.out.println("Data: dd-MM-yyyy");
            LocalDate data = LocalDate.parse(scanner.nextLine());
            System.out.println("Endereco: ");
            String endereco = scanner.nextLine();
            System.out.println("Id do cliente: ");
            Cliente cliente = seguradora.getCliente(scanner.nextLine());
            System.out.println("Placa do veiculo: ");
            Veiculo veiculo = cliente.getVeiculo(scanner.nextLine());
            if (!cliente.getListaVeiculos().contains(veiculo) || !seguradora.getListaClientes().contains(cliente)) {
                return null;
            }
            Sinistro sinistro = new Sinistro(0, data, endereco, seguradora, veiculo, cliente);
            return sinistro;
        } catch (Exception e) {
            return null;
        }
    }

    public static Veiculo criarVeiculo() {
        try {
            System.out.println("Placa: ");
            String placa = scanner.next();
            System.out.println("Marca: ");
            String marca = scanner.next();
            System.out.println("Modelo: ");
            String modelo = scanner.next();
            System.out.println("Ano de fabricacao: ");
            int anoFabricacao = Integer.parseInt(scanner.next());
            Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
            return veiculo;
        } catch (Exception e) {
            System.out.println("Esta placa já está já registrada");
            return null;
        }
    }
}