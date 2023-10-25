package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    //atributos
    private static Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() { this.eventosMap = new HashMap<>(); }


    public static void adicionarEvento(LocalDate data, String nome, String atracao) {
        //Evento evento = new Evento(nome, atracao);
        eventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate,  Evento> eventosTreemap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreemap);
    }

    public static void obterProximoEvento() {
        //Set<LocalDate> dataSet = eventosMap.keySet();
        //Collection<Evento> values = eventosMap.values();
        //eventosMap.get();

        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O próximo evento: " + entry.getValue() + "acontecerá na data " + entry.getKey());
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        AgendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY,15), "Evento 1", "Atracao 1");
        AgendaEventos.adicionarEvento(LocalDate.of(2022, 7,9), "Evento 2", "Atracao 2");
        AgendaEventos.adicionarEvento(LocalDate.of(2022, Month.JANUARY,10), "Evento 3", "Atracao 3");
        AgendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER,24), "Evento 4", "Atracao 4");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();


    }
}
