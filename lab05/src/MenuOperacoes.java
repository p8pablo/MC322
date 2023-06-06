public enum MenuOperacoes {
    CADASTROS(1),
    CADASTRAR_PF(11),
    CADASTRAR_PJ(12),
    CADASTRAR_VEICULO_PF(13),
    CADASTRAR_VEICULO_FROTA(14),
    AUTORIZAR_CONDUTOR(15),
    DESAUTORIZAR_CONDUTOR(16),
    VOLTAR_CADASTRAR(17),
    LISTAR(2),
    LISTAR_PF(21),
    LISTAR_PJ(22),
    LISTAR_VEICULO_CLIENTE_PF(23),
    LISTAR_FROTA_CLIENTE_PJ(24),
    LISTAR_VEICULO_FROTA(25),
    LISTAR_SEGUROS(26),
    LISTAR_CONDUTORES_SEGURO(27),
    VOLTAR_LISTAR(28),
    EXCLUIR(3),
    EXCLUIR_CLIENTE(31),
    EXCLUIR_VEICULO_PF(32),
    EXCLUIR_VEICULO_PJ(33),
    EXCLUIR_FROTA(34),
    VOLTAR_EXCLUIR(35),
    GERAR_SINISTRO(4),
    CALCULAR_RECEITA(5),
    GERAR_SEGURO_PF(6),
    GERAR_SEGURO_PJ(7),
    CANCELAR_SEGURO(8),

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
