package Projeto;

public class TipoDemanda {
    public static final int URGENTE = 1;
    public static final int CRITICO = 2;
    public static final int NORMAL = 3;

    public static String obterDescricao(int tipo) {
        return switch (tipo) {
            case URGENTE -> "Urgente";
            case CRITICO -> "Crítico";
            case NORMAL -> "Normal";
            default -> "Desconhecido";
        };
    }
}