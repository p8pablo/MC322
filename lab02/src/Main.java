// Arquivo executavel


public class Main {
    // metodo da Main
    public static void main(String[] args){
        /*
         *--- Fluxo do programa ---
         * Inserir dados do cliente
         *      Armazenar dados na classe Cliente
         *          Verificar existência do CPF
         *              Se existir imprima CPF Válido.
         *              Do contrário, imprimir CPF inválido.
         * Inserir dados do Veículo
         *      Armazenar na Classe Veículo
         * Inserir dados do Sinistro
         *      Armazenar na Classe Sinistro
         * Inserir dados da Seguradora
         *      Armazenar na Classe Seguradora
         * 
         */
        Cliente cliente = new Cliente(null, "158.481.066-14", null, 0, null);
        Veiculo veiculo = new Veiculo(null, null, null);
        Sinistro sinistro = new Sinistro(0, null, null);
        Seguradora seguradora = new Seguradora(null, null, null, null);
        if (Cliente.validarCpf(Cliente.formatarCpf("158.481.066-14"))){
            System.out.println("Cpf Válido");

        }else{
            System.out.println("Cpf Inválido");
        }
        
        

    }

}