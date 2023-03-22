// Arquivo executavel
public class Main {
    // metodo da Main
    public static void main(String[] entrada){
        /*
         *--- Fluxo do programa ---
         * Inserir dados do cliente
         *      Armazenar dados na classe Cliente
         *          Verificar existência do CPF
         *              Se existir continue o programa.
         *              Do contrário, reiniciar programa.
         * Inserir dados do Veículo
         *      Armazenar na Classe Veículo
         * Inserir dados do Sinistro
         *      Armazenar na Classe Sinistro
         * Inserir dados da Seguradora
         *      Armazenar na Classe Seguradora
         * 
         */
        Cliente cliente = new Cliente();
        cliente.setNome(entrada[0]);
        if(cliente.validarCpf(cliente.formatar(entrada[1])))
    }

}