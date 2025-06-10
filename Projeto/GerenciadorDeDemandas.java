package Projeto;

import java.util.PriorityQueue;
import java.util.Queue;

public class GerenciadorDeDemandas {
    private Queue<Demanda> demandasEmAndamento;
    private Queue<Demanda> demandasEmEspera;

    public GerenciadorDeDemandas() {
        this.demandasEmAndamento = new PriorityQueue<>((d1, d2) -> Integer.compare(d2.calcularPrioridade(), d1.calcularPrioridade()));
        this.demandasEmEspera = new PriorityQueue<>((d1, d2) -> Integer.compare(d2.calcularPrioridade(), d1.calcularPrioridade()));
    }

    public void adicionarDemanda(Demanda demanda, boolean emAndamento) {
        if (emAndamento) {
            demandasEmAndamento.offer(demanda);
            System.out.println("Demanda adicionada à fila de andamento!");
        } else {
            demandasEmEspera.offer(demanda);
            System.out.println("Demanda adicionada à fila de espera!");
        }
    }

    public void listarDemandas() {
        System.out.println(" Demandas em andamento:");
        demandasEmAndamento.forEach(System.out::println);

        System.out.println(" Demandas em espera:");
        demandasEmEspera.forEach(System.out::println);
    }
}