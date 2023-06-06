import java.util.*;
import java.time.*;

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
                System.out.println("Cpf: ");
                String cpf = scanner.next();
                System.out.println("Email: ");
                String email = scanner.next();
                System.out.println("Telefone: ");
                String telefone = scanner.next();
                System.out.println("Data de nascimento (dd-mm-aaaa): ");
                String data_n = scanner.next();
                LocalDate dataNascimento = LocalDate.parse(data_n);
                ClientePF cliente = new ClientePF(nome, endereco, educacao, genero, classeEconomica, null, cpf, dataNascimento, email, telefone);
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
                System.out.println("Email: ");
                String email = scanner.next();
                System.out.println("Telefone: ");
                String telefone = scanner.next();
                ClientePJ cliente = new ClientePJ(cnpj, dataFundacao, nome, endereco, qtdeFuncionarios, email, telefone, null);
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
        Seguradora seguradora = new Seguradora(endereco, nome, telefone, email, endereco, null, null);
        return seguradora;
    }

    public static Sinistro criarSinistro(Seguro seguro) {
        try {
            System.out.println("Data: dd-MM-yyyy");
            LocalDate data = LocalDate.parse(scanner.nextLine());
            System.out.println("Endereco: ");
            String endereco = scanner.nextLine();
            System.out.println("Nome do condutor: ");
            Condutor condutor = seguro.getCondutor(scanner.nextLine());
            Sinistro sinistro = new Sinistro(0, data, endereco, condutor, seguro);
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
    public static Condutor criarCondutor(){
        try {
            System.out.println("CPF: ");
            String cpf = scanner.next();
            System.out.println("nome: ");
            String nome = scanner.next();
            System.out.println("telefone: ");
            String telefone = scanner.next();
            System.out.println("endereco: ");
            String endereco = scanner.next();
            System.out.println("email: ");
            String email = scanner.next();
            System.out.println("dataNascimento: ");
            String dataNascimento = scanner.next();
            LocalDate dataNascimentoL = LocalDate.parse(dataNascimento);
            Condutor condutor = new Condutor(cpf, nome, telefone, email, endereco, dataNascimentoL, null);
            return condutor;
            
        } catch (Exception e) {
            System.out.println("Esta condutora já está já registrada");
            return null;
        }
    }

    
    
}