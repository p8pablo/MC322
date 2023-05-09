public enum MenuOperacoes {
    CADASTROS(1),
    CADASTRAR_PF(11),
    CADASTRAR_PJ(12),
    CADASTRAR_VEICULO(13),
    VOLTAR_CADASTRAR(14),
    LISTAR(2),
    LISTAR_PF(21),
    LISTAR_PJ(22),
    LISTAR_SINISTROS(23),
    VOLTAR_LISTAR(24),
    EXCLUIR(3),
    EXCLUIR_CLIENTE(31),
    EXCLUIR_VEICULO(32),
    EXCLUIR_SINISTRO(33),
    VOLTAR_EXCLUIR(34),
    GERAR_SINISTRO(4),
    CALCULAR_RECEITA(5),
    SAIR(0);

    private final int operacao;

    MenuOperacoes(int operacao) {
        this.operacao = operacao;
    }
    
    public int getOperacao(){
        return this.operacao;
    }

    public static MenuOperacoes getEnum(int operacao) {
        for (MenuOperacoes p : MenuOperacoes.values()) {
            if (p.getOperacao() == operacao) {
                return p;
            }
        }
        return MenuOperacoes.SAIR;
    }

}
