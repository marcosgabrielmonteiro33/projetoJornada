package Projeto;

import java.time.LocalDateTime;

public class Demanda {
    private int tipo;
    private int distanciaDaSede;
    private int distanciaDaEquipe;
    private int custoReparo;
    private int custoImpacto;
    private int prePrioridade;
    private int prejuizoFiscal;
    private int tempoEspera;
    private LocalDateTime horarioCriacao; 

    public Demanda(int tipo, int distanciaDaSede, int distanciaDaEquipe, int custoReparo, int custoImpacto,
                   int prePrioridade, int prejuizoFiscal, int tempoEspera) {
        this.tipo = tipo;
        this.distanciaDaSede = distanciaDaSede;
        this.distanciaDaEquipe = distanciaDaEquipe;
        this.custoReparo = custoReparo;
        this.custoImpacto = custoImpacto;
        this.prePrioridade = prePrioridade;
        this.prejuizoFiscal = prejuizoFiscal;
        this.tempoEspera = tempoEspera;
        this.horarioCriacao = LocalDateTime.now(); 
    }

    public int calcularPrioridade() {
        int pesoTipo = switch (tipo) {
            case TipoDemanda.URGENTE -> 5;
            case TipoDemanda.CRITICO -> 3;
            case TipoDemanda.NORMAL -> 1;
            default -> 0;
        };

        return (pesoTipo * 10) + (distanciaDaSede * 2) + (distanciaDaEquipe * 2) + (custoReparo * 3) +
               (custoImpacto * 5) + (prePrioridade * 2) +  (prejuizoFiscal * 3) + (tempoEspera * 4);
    }

    @Override
    public String toString() {
        return "Demanda [prioridade=" + calcularPrioridade() + ", tipo=" + TipoDemanda.obterDescricao(tipo) +
               ", distanciaDaSede=" + distanciaDaSede + ", distanciaDaEquipe=" + distanciaDaEquipe +
               ", custoReparo=" + custoReparo + ", custoImpacto=" + custoImpacto +
               ", prePrioridade=" + prePrioridade + 
               ", prejuizoFiscal=" + prejuizoFiscal + ", tempoEspera=" + tempoEspera +
               ", horarioCriacao=" + horarioCriacao + "]";
    }
}
